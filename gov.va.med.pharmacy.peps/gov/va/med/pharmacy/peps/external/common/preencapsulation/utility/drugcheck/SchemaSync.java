package gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.drugcheck;

import gov.va.med.pharmacy.peps.common.exception.InterfaceException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class SchemaSync
  implements ApplicationContextAware, InitializingBean
{
  private static final Log LOGGER = LogFactory.getLog(SchemaSync.class);
  private static final int BUFFER_SIZE = 32000;
  private DataSource dataSource;
  private static ApplicationContext appCtx;
  private CachedSchema cachedSchema = null;
  private Properties mochaServerProperties;
  private static final String EVICTION_DAY_OF_WEEK = "evictionDayOfWeek";
  private static final String EVICTION_HOUR_OF_DAY = "evictionHourOfDay";
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

  public static SchemaSync getInstance()
  {
    return (SchemaSync)appCtx.getBean("orderCheckRequestSchemaSync", SchemaSync.class);
  }

  public InputStream getSchema()
  {
    InputStream localInputStream = getCachedElement();
    try
    {
      localInputStream.reset();
    }
    catch (IOException localIOException)
    {
      LOGGER.error(localIOException.getMessage(), localIOException);
    }
    return localInputStream;
  }

  private InputStream getCachedElement()
  {
    if ((this.cachedSchema == null) || (shouldEvict()))
    {
      InputStream localInputStream = processSchema();
      this.cachedSchema = new CachedSchema(null);
      this.cachedSchema.setInputStream(localInputStream);
    }
    return this.cachedSchema.getInputStream();
  }

  private boolean shouldEvict()
  {
    GregorianCalendar localGregorianCalendar1 = calculateWeeklyEvictionDate();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    if (localGregorianCalendar2.after(localGregorianCalendar1))
    {
      if (LOGGER.isInfoEnabled())
        LOGGER.info("Evicting object created on " + dateFormat.format(this.cachedSchema.getCreatedTimestamp().getTime()) + ".  Eviction Date of " + dateFormat.format(localGregorianCalendar1.getTime()));
      return true;
    }
    return false;
  }

  private InputStream processSchema()
  {
    try
    {
      InputStream localInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("schema/drugCheckSchemaInput.xsd");
      DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
      localDocumentBuilderFactory.setNamespaceAware(true);
      DocumentBuilder localDocumentBuilder = localDocumentBuilderFactory.newDocumentBuilder();
      Document localDocument = localDocumentBuilder.parse(localInputStream);
      XPathFactory localXPathFactory = XPathFactory.newInstance();
      XPath localXPath = localXPathFactory.newXPath();
      localXPath.setNamespaceContext(MyNamespaceContext.getInstance());
      ProcessSchema localProcessSchema = new ProcessSchema(localDocument, localXPath);
      localProcessSchema.execute("//xsd:simpleType[@name='doseTypeType']/xsd:restriction", "select description1 from fdb_dosetype where description1 is not null", "//xsd:element[@name='doseType']");
      localProcessSchema.execute("//xsd:simpleType[@name='doseUnitType']/xsd:restriction", "select units from fdb_doseunitstype", "//xsd:element[@name='doseUnit']");
      localProcessSchema.execute("//xsd:simpleType[@name='routeType']/xsd:restriction", "select description1 from fdb_doseroute", "//xsd:element[@name='route']");
      DOMSource localDOMSource = new DOMSource(localDocument);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(32000);
      StreamResult localStreamResult = new StreamResult(localByteArrayOutputStream);
      Transformer localTransformer = TransformerFactory.newInstance().newTransformer();
      localTransformer.transform(localDOMSource, localStreamResult);
      return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
    }
    catch (Exception localException)
    {
      throw new InterfaceException(localException, InterfaceException.INTERFACE_ERROR, new Object[] { "PRE Encapsulation" });
    }
  }

  private void addEnumValues(Node paramNode, List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Element localElement = paramNode.getOwnerDocument().createElement("xsd:enumeration");
      localElement.setAttribute("value", str);
      paramNode.appendChild(localElement);
    }
  }

  private void print(NamedNodeMap paramNamedNodeMap)
  {
    if (LOGGER.isDebugEnabled())
      for (int i = 0; i < paramNamedNodeMap.getLength(); i++)
        LOGGER.debug(paramNamedNodeMap.item(i).getNodeName() + " : " + paramNamedNodeMap.item(i).getNodeValue());
  }

  private Connection getConnection()
    throws SQLException
  {
    return this.dataSource.getConnection();
  }

  public void setDataSource(DataSource paramDataSource)
  {
    this.dataSource = paramDataSource;
  }

  public void setMochaServerProperties(Properties paramProperties)
  {
    this.mochaServerProperties = paramProperties;
  }

  public void setApplicationContext(ApplicationContext paramApplicationContext)
  {
    appCtx = paramApplicationContext;
  }

  public void afterPropertiesSet()
    throws Exception
  {
    if (this.dataSource == null)
      throw new Exception("DataSource has not been injected in to SchemaSync.");
    if (this.mochaServerProperties == null)
      throw new Exception("MochaServerProperties has not been injected in to SchemaSync.");
    validateIntegerProperty("evictionDayOfWeek");
    validateIntegerProperty("evictionHourOfDay");
  }

  private void validateIntegerProperty(String paramString)
    throws Exception
  {
    String str1 = this.mochaServerProperties.getProperty(paramString);
    if (str1 == null)
    {
      String str2 = "Cannot find the property " + paramString + " in the mochaServerProperties file.";
      LOGGER.error(str2);
      throw new Exception(str2);
    }
    try
    {
      Integer.parseInt(str1);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str3 = "The value for the property " + paramString + " is not a valid Integer.";
      LOGGER.error(str3);
      throw new Exception(str3);
    }
  }

  private Integer getEvictionDayOfWeek()
  {
    return getIntegerProperty("evictionDayOfWeek");
  }

  private Integer getEvictionHourOfDay()
  {
    return getIntegerProperty("evictionHourOfDay");
  }

  private Integer getIntegerProperty(String paramString)
  {
    return Integer.valueOf(Integer.parseInt(this.mochaServerProperties.getProperty(paramString)));
  }

  private GregorianCalendar calculateWeeklyEvictionDate()
  {
    Integer localInteger1 = getEvictionDayOfWeek();
    Integer localInteger2 = getEvictionHourOfDay();
    GregorianCalendar localGregorianCalendar1 = this.cachedSchema.getCreatedTimestamp();
    GregorianCalendar localGregorianCalendar2 = (GregorianCalendar)localGregorianCalendar1.clone();
    int i = localGregorianCalendar1.get(7);
    if (i > localInteger1.intValue())
    {
      localGregorianCalendar2.add(3, 1);
      localGregorianCalendar2.set(7, localInteger1.intValue());
    }
    if (i < localInteger1.intValue())
      localGregorianCalendar2.add(7, localInteger1.intValue() - i);
    localGregorianCalendar2.set(11, localInteger2.intValue());
    localGregorianCalendar2.set(12, 0);
    localGregorianCalendar2.set(13, 0);
    localGregorianCalendar2.set(14, 0);
    return localGregorianCalendar2;
  }

  private final class CachedSchema
  {
    private GregorianCalendar createdTimestamp = new GregorianCalendar();
    private InputStream inputStream;

    private CachedSchema()
    {
    }

    public GregorianCalendar getCreatedTimestamp()
    {
      return this.createdTimestamp;
    }

    public InputStream getInputStream()
    {
      return this.inputStream;
    }

    public void setInputStream(InputStream paramInputStream)
    {
      this.inputStream = paramInputStream;
    }
  }

  public static final class MyNamespaceContext
    implements NamespaceContext
  {
    private HashMap<String, String> nameSpaceMappings = new HashMap();
    private static MyNamespaceContext instance = new MyNamespaceContext();

    public static MyNamespaceContext getInstance()
    {
      return instance;
    }

    private MyNamespaceContext()
    {
      this.nameSpaceMappings.put("xml", "http://www.w3.org/XML/1998/namespace");
      this.nameSpaceMappings.put("xsd", "http://www.w3.org/2001/XMLSchema");
    }

    public String getNamespaceURI(String paramString)
    {
      String str = (String)this.nameSpaceMappings.get(paramString);
      return str == null ? "" : str;
    }

    public String getPrefix(String paramString)
    {
      throw new UnsupportedOperationException();
    }

    public Iterator<String> getPrefixes(String paramString)
    {
      throw new UnsupportedOperationException();
    }
  }

  private class ProcessSchema
  {
    private Document doc;
    private XPath xpath;

    ProcessSchema(Document paramXPath, XPath arg3)
    {
      this.doc = paramXPath;
      Object localObject;
      this.xpath = localObject;
    }

    public void execute(String paramString1, String paramString2, String paramString3)
      throws Exception
    {
      XPathExpression localXPathExpression = this.xpath.compile(paramString1);
      Node localNode = (Node)localXPathExpression.evaluate(this.doc, XPathConstants.NODE);
      replaceEnumValues(localNode, paramString2);
      changeFieldType(localNode, paramString3);
    }

    private void changeFieldType(Node paramNode, String paramString)
      throws Exception
    {
      String str = paramNode.getParentNode().getAttributes().getNamedItem("name").getNodeValue();
      XPathExpression localXPathExpression = this.xpath.compile(paramString);
      Node localNode = (Node)localXPathExpression.evaluate(this.doc, XPathConstants.NODE);
      localNode.getAttributes().getNamedItem("type").setNodeValue(str);
    }

    private void replaceEnumValues(Node paramNode, String paramString)
      throws Exception
    {
      removeChildren(paramNode, this.xpath);
      List localList = getValues(paramString);
      SchemaSync.this.addEnumValues(paramNode, localList);
    }

    private List<String> getValues(String paramString)
      throws Exception
    {
      Connection localConnection = SchemaSync.this.getConnection();
      Statement localStatement = localConnection.createStatement();
      ResultSet localResultSet = localStatement.executeQuery(paramString);
      ArrayList localArrayList = new ArrayList();
      while (localResultSet.next())
        localArrayList.add(localResultSet.getString(1));
      localConnection.close();
      return localArrayList;
    }

    private void removeChildren(Node paramNode, XPath paramXPath)
      throws Exception
    {
      XPathExpression localXPathExpression = paramXPath.compile("*");
      NodeList localNodeList = (NodeList)localXPathExpression.evaluate(paramNode, XPathConstants.NODESET);
      for (int i = 0; i < localNodeList.getLength(); i++)
      {
        Node localNode = localNodeList.item(i);
        localNode.getParentNode().removeChild(localNode);
      }
      paramNode.normalize();
      paramNode.removeChild(paramNode.getChildNodes().item(0));
    }
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.drugcheck.SchemaSync
 * JD-Core Version:    0.6.2
 */