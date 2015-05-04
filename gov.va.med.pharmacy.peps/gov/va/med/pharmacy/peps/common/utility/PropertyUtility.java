package gov.va.med.pharmacy.peps.common.utility;

import gov.va.med.pharmacy.peps.common.exception.CommonException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.Logger;

public final class PropertyUtility
{
  private static final Logger LOG = Logger.getLogger(PropertyUtility.class);
  private static final String PROPERTY_OVERRIDE_FILE = "gov.va.med.pharmacy.peps.siteConfig.properties";
  private static final Map<Class<?>, Properties> PROPERTIES_CACHE = Collections.synchronizedMap(new HashMap());
  private static final Properties PROPERTIES_OVERRIDE = loadPropertiesOverride();
  private static final int BUFFER_SIZE = 128;

  public static String getOverriddenProperty(String paramString)
  {
    return PROPERTIES_OVERRIDE.getProperty(paramString);
  }

  public static String getProperty(Class<?> paramClass, String paramString)
  {
    try
    {
      return loadProperties(paramClass).getProperty(paramString);
    }
    catch (IOException localIOException)
    {
      throw new CommonException(localIOException, CommonException.PROPERTY_FILE_UNAVAILABLE, new Object[] { createPath(paramClass) });
    }
  }

  public static Properties loadProperties(Class<?> paramClass)
    throws IOException
  {
    if (!PROPERTIES_CACHE.containsKey(paramClass))
    {
      Properties localProperties = load(paramClass);
      overrideProperties(localProperties);
      PROPERTIES_CACHE.put(paramClass, localProperties);
    }
    return (Properties)PROPERTIES_CACHE.get(paramClass);
  }

  public static Properties loadPropertiesWithoutOverride(Class<?> paramClass)
    throws IOException
  {
    return load(paramClass);
  }

  public static void overrideProperty(String paramString1, String paramString2)
  {
    PROPERTIES_OVERRIDE.setProperty(paramString1, paramString2);
    synchronized (PROPERTIES_CACHE)
    {
      Iterator localIterator = PROPERTIES_CACHE.values().iterator();
      while (localIterator.hasNext())
      {
        Properties localProperties = (Properties)localIterator.next();
        localProperties.setProperty(paramString1, paramString2);
      }
    }
  }

  private static Properties loadPropertiesOverride()
  {
    Properties localProperties = new Properties();
    InputStream localInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("gov.va.med.pharmacy.peps.siteConfig.properties");
    if (localInputStream != null)
      try
      {
        try
        {
          localProperties.load(localInputStream);
        }
        finally
        {
          localInputStream.close();
        }
      }
      catch (IOException localIOException)
      {
        throw new CommonException(localIOException, CommonException.PROPERTY_FILE_UNAVAILABLE, new Object[] { "gov.va.med.pharmacy.peps.siteConfig.properties" });
      }
    else
      LOG.debug("No gov.va.med.pharmacy.peps.siteConfig.properties file on class path defined to override site configuration! Using defaults instead.");
    return localProperties;
  }

  private static String createPath(Class<?> paramClass)
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("properties/");
    localStringBuffer.append(paramClass.getName().replace('.', '/'));
    localStringBuffer.append(".properties");
    return localStringBuffer.toString();
  }

  private static Properties load(Class<?> paramClass)
    throws IOException
  {
    String str = createPath(paramClass);
    InputStream localInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(str);
    Properties localProperties;
    try
    {
      localProperties = new Properties();
      localProperties.load(localInputStream);
    }
    finally
    {
      localInputStream.close();
    }
    return localProperties;
  }

  private static void overrideProperties(Properties paramProperties)
  {
    Iterator localIterator = PROPERTIES_OVERRIDE.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramProperties.setProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.utility.PropertyUtility
 * JD-Core Version:    0.6.2
 */