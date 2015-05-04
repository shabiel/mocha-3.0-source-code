package gov.va.med.pharmacy.peps.external.common.preencapsulation.utility;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import firstdatabank.database.FDBException;
import firstdatabank.dif.FDBUnknownTypeException;
import gov.va.med.pharmacy.peps.common.exception.FDBUpdateInProgressException;
import gov.va.med.pharmacy.peps.common.exception.InterfaceException;
import gov.va.med.pharmacy.peps.common.exception.InterfaceValidationException;
import gov.va.med.pharmacy.peps.common.exception.PharmacyException;
import gov.va.med.pharmacy.peps.common.exception.PharmacyRuntimeException;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.ExceptionCodeType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.ObjectFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

public class XmlUtility
{
  protected static final String EXCEPTION_PACKAGE = gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.Exception.class.getPackage().getName();
  protected static final JAXBContext EXCEPTION_CONTEXT = initializeJaxbContext(EXCEPTION_PACKAGE);
  protected static final String EXCEPTION_NAMESPACE = EXCEPTION_PACKAGE.replace('.', '/');
  protected static final String EXCEPTION_SCHEMA_LOCATION = EXCEPTION_NAMESPACE + " " + "exception.xsd";
  protected static final String EXCEPTION_SCHEMA_FILE = "schema/exception.xsd";
  protected static final String[] EXCEPTION_CDATA_ELEMENTS = { EXCEPTION_NAMESPACE + "^detailedMessage" };
  private static final Logger LOG = Logger.getLogger(XmlUtility.class);
  private static final SchemaFactory SCHEMA_FACTORY = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

  protected static JAXBContext initializeJaxbContext(String paramString)
  {
    try
    {
      return JAXBContext.newInstance(paramString, Thread.currentThread().getContextClassLoader());
    }
    catch (JAXBException localJAXBException)
    {
      throw new InterfaceException(localJAXBException, InterfaceException.INTERFACE_ERROR, new Object[] { "PRE Encapsulation" });
    }
  }

  protected static XMLSerializer getXmlSerializer(Writer paramWriter, String[] paramArrayOfString, boolean paramBoolean)
  {
    OutputFormat localOutputFormat = new OutputFormat();
    localOutputFormat.setCDataElements(paramArrayOfString);
    localOutputFormat.setIndenting(paramBoolean);
    return new XMLSerializer(paramWriter, localOutputFormat);
  }

  protected static void handleValidationEvents(ValidationEventCollector paramValidationEventCollector, String paramString)
  {
    handleValidationEvents(null, paramValidationEventCollector, paramString);
  }

  protected static void handleValidationEvents(JAXBException paramJAXBException, ValidationEventCollector paramValidationEventCollector, String paramString)
  {
    if (paramValidationEventCollector.hasEvents())
    {
      ValidationEvent[] arrayOfValidationEvent = paramValidationEventCollector.getEvents();
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0; i < arrayOfValidationEvent.length; i++)
      {
        if (i > 0)
          localStringBuffer.append(" ");
        localStringBuffer.append(arrayOfValidationEvent[i].getMessage());
      }
      if (paramJAXBException == null)
        throw new InterfaceValidationException(InterfaceValidationException.VALIDATION_ERROR, new Object[] { "PRE Encapsulation", paramString, localStringBuffer });
      throw new InterfaceValidationException(paramJAXBException, InterfaceValidationException.VALIDATION_ERROR, new Object[] { "PRE Encapsulation", paramString, localStringBuffer });
    }
  }

  protected static <T> T unmarshal(String paramString1, boolean paramBoolean, JAXBContext paramJAXBContext, String paramString2, Class<T> paramClass)
  {
    InputStream localInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(paramString2);
    return unmarshal(paramString1, paramBoolean, paramJAXBContext, localInputStream, paramClass);
  }

  protected static <T> T unmarshal(String paramString, boolean paramBoolean, JAXBContext paramJAXBContext, InputStream paramInputStream, Class<T> paramClass)
  {
    ValidationEventCollector localValidationEventCollector = new ValidationEventCollector();
    try
    {
      Unmarshaller localUnmarshaller = paramJAXBContext.createUnmarshaller();
      localUnmarshaller.setEventHandler(localValidationEventCollector);
      if (paramBoolean)
        synchronized (SCHEMA_FACTORY)
        {
          localObject1 = SCHEMA_FACTORY.newSchema(new StreamSource(paramInputStream));
          localUnmarshaller.setSchema((Schema)localObject1);
        }
      ??? = new BufferedReader(new StringReader(paramString));
      Object localObject1 = localUnmarshaller.unmarshal(new StreamSource((Reader)???), paramClass);
      Object localObject3 = ((JAXBElement)localObject1).getValue();
      try
      {
        ((BufferedReader)???).close();
      }
      catch (IOException localIOException)
      {
        LOG.error("Due to implementation of StringReader, this exception should never be thrown.", localIOException);
      }
      handleValidationEvents(localValidationEventCollector, getClassName(paramClass));
      return localObject3;
    }
    catch (JAXBException localJAXBException)
    {
      handleValidationEvents(localJAXBException, localValidationEventCollector, getClassName(paramClass));
      throw new InterfaceException(localJAXBException, InterfaceException.INTERFACE_ERROR, new Object[] { "PRE Encapsulation" });
    }
    catch (SAXException localSAXException)
    {
      throw new InterfaceException(localSAXException, InterfaceException.INTERFACE_ERROR, new Object[] { "PRE Encapsulation" });
    }
  }

  protected static <T> String marshal(T paramT, boolean paramBoolean, JAXBContext paramJAXBContext, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      StringWriter localStringWriter = new StringWriter();
      Marshaller localMarshaller = paramJAXBContext.createMarshaller();
      localMarshaller.setEventHandler(new ValidationEventCollector());
      localMarshaller.setProperty("jaxb.schemaLocation", paramString1);
      synchronized (SCHEMA_FACTORY)
      {
        Schema localSchema = SCHEMA_FACTORY.newSchema(new StreamSource(Thread.currentThread().getContextClassLoader().getResourceAsStream(paramString2)));
        localMarshaller.setSchema(localSchema);
      }
      localMarshaller.marshal(paramT, getXmlSerializer(localStringWriter, paramArrayOfString, paramBoolean));
      handleValidationEvents((ValidationEventCollector)localMarshaller.getEventHandler(), getClassName(paramT.getClass()));
      return localStringWriter.toString();
    }
    catch (JAXBException localJAXBException)
    {
      throw new InterfaceException(localJAXBException, InterfaceException.INTERFACE_ERROR, new Object[] { "PRE Encapsulation" });
    }
    catch (SAXException localSAXException)
    {
      throw new InterfaceException(localSAXException, InterfaceException.INTERFACE_ERROR, new Object[] { "PRE Encapsulation" });
    }
  }

  private static String getClassName(Class<?> paramClass)
  {
    int i = paramClass.getName().lastIndexOf(".") + 1;
    return paramClass.getName().substring(i);
  }

  public static boolean exceptionEquals(String paramString1, String paramString2)
  {
    try
    {
      Unmarshaller localUnmarshaller = EXCEPTION_CONTEXT.createUnmarshaller();
      gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.Exception localException1 = (gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.Exception)localUnmarshaller.unmarshal(new StreamSource(new StringReader(paramString1)));
      gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.Exception localException2 = (gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.Exception)localUnmarshaller.unmarshal(new StreamSource(new StringReader(paramString2)));
      return (localException1.getCode().equals(localException2.getCode())) && (localException1.getMessage().equals(localException2.getMessage()));
    }
    catch (JAXBException localJAXBException)
    {
      throw new InterfaceException(localJAXBException, InterfaceException.INTERFACE_ERROR, new Object[] { "PRE Encapsulation" });
    }
  }

  public static String createXmlErrorMessage(Throwable paramThrowable)
  {
    ObjectFactory localObjectFactory = new ObjectFactory();
    gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.Exception localException = localObjectFactory.createException();
    if (((paramThrowable instanceof FDBException)) || ((paramThrowable instanceof FDBUnknownTypeException)))
      localException.setCode(ExceptionCodeType.FDB);
    else if ((paramThrowable instanceof FDBUpdateInProgressException))
      localException.setCode(ExceptionCodeType.FDBUPDATE);
    else if (((paramThrowable instanceof PharmacyException)) || ((paramThrowable instanceof PharmacyRuntimeException)))
      localException.setCode(ExceptionCodeType.PRE);
    else if ((paramThrowable instanceof java.lang.Exception))
      localException.setCode(ExceptionCodeType.JAVA);
    else
      localException.setCode(ExceptionCodeType.SYSTEM);
    if (paramThrowable.getLocalizedMessage() == null)
      localException.setMessage("");
    else
      localException.setMessage(paramThrowable.getLocalizedMessage());
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    localException.setDetailedMessage(localStringWriter.toString());
    return marshal(localException, false, EXCEPTION_CONTEXT, EXCEPTION_SCHEMA_LOCATION, "schema/exception.xsd", EXCEPTION_CDATA_ELEMENTS);
  }

  protected static <T> String prettyPrint(T paramT, JAXBContext paramJAXBContext, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return marshal(paramT, true, paramJAXBContext, paramString1, paramString2, paramArrayOfString);
  }

  protected static <T> String prettyPrint(String paramString1, JAXBContext paramJAXBContext, String paramString2, String paramString3, Class<T> paramClass, String[] paramArrayOfString)
  {
    try
    {
      return prettyPrint(unmarshal(paramString1, false, paramJAXBContext, paramString3, paramClass), paramJAXBContext, paramString2, paramString3, paramArrayOfString);
    }
    catch (java.lang.Exception localException)
    {
      LOG.error("Unable to pretty print XML. Returning original XML String.");
    }
    return paramString1;
  }

  public static String prettyPrintException(String paramString)
  {
    return prettyPrint(paramString, EXCEPTION_CONTEXT, EXCEPTION_SCHEMA_LOCATION, "schema/exception.xsd", gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.Exception.class, EXCEPTION_CDATA_ELEMENTS);
  }

  public static String prettyPrintException(gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.Exception paramException)
  {
    return prettyPrint(paramException, EXCEPTION_CONTEXT, EXCEPTION_SCHEMA_LOCATION, "schema/exception.xsd", EXCEPTION_CDATA_ELEMENTS);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.XmlUtility
 * JD-Core Version:    0.6.2
 */