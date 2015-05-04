package gov.va.med.pharmacy.peps.updater.common.utility;

import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;

public final class Configuration
{
  private static final Logger LOG = Logger.getLogger(Configuration.class);
  private static final String CONFIG_LOCATION_PROPERTY = "peps.datup.configuration";
  public static final String SCHEDULED_TIME = "scheduled.time";
  public static final String FTP_HOSTNAME = "ftp.hostname";
  public static final String FTP_PORT = "ftp.port";
  public static final String FTP_USERNAME = "ftp.username";
  public static final String FTP_PASSWORD = "ftp.password";
  public static final String FTP_WORKING_DIRECTORY = "ftp.directory.working";
  public static final String FTP_PENDING_DIRECTORY = "ftp.directory.pending";
  public static final String FDB_RETENTON = "fdb.retention";
  public static final String FDB_TEST_COUNT = "fdb.verification.test.count";
  public static final String FDB_BATCH_COMMIT_SIZE = "fdb.batch.commit.size";
  public static final String EMAIL_HOSTNAME = "email.hostname";
  public static final String EMAIL_SENDER = "email.sender";
  public static final String EMAIL_USERNAME = "email.username";
  public static final String EMAIL_PASSWORD = "email.password";
  public static final String EMAIL_LIST_SUCCESS = "email.list.success";
  public static final String EMAIL_LIST_FAILURE = "email.list.failure";
  public static final String EMAIL_LIST_UPDATE_AVAILABLE = "email.list.update.available";
  public static final String EMAIL_TEMPLATE_SUCCESS = "email.template.success";
  public static final String EMAIL_TEMPLATE_FAILURE = "email.template.failure";
  public static final String EMAIL_TEMPLATE_UPDATE_AVAILABLE = "email.template.update.available";
  public static final String RDC_NAME = "locality.rdc.name";
  public static final String SITE_NUMBER = "locality.site.number";
  private String filename;
  private PropertiesConfiguration config = new PropertiesConfiguration();
  private boolean isLoaded;

  public synchronized org.apache.commons.configuration.Configuration load()
  {
    if (!this.isLoaded)
      try
      {
        this.config.load(System.getProperty("peps.datup.configuration", this.filename));
        this.config.setReloadingStrategy(new FileChangedReloadingStrategy());
        this.isLoaded = true;
      }
      catch (ConfigurationException localConfigurationException)
      {
        LOG.error(System.getProperty("peps.datup.configuration", this.filename));
        LOG.error("Unable to locate the DATUP configuration file in the (1) current directory or (2) classpath.", localConfigurationException);
      }
    return this.config;
  }

  public void setFilename(String paramString)
  {
    this.filename = paramString;
  }

  public String toString()
  {
    ToStringBuilder localToStringBuilder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    localToStringBuilder.append("file", System.getProperty("peps.datup.configuration", this.filename)).append("loaded", this.isLoaded);
    Iterator localIterator = this.config.getKeys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ("locality.site.number".equals(str))
        localToStringBuilder.append(str, Arrays.toString(this.config.getStringArray(str)));
      else
        localToStringBuilder.append(str, this.config.getString(str));
    }
    return localToStringBuilder.toString();
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.updater.common.utility.Configuration
 * JD-Core Version:    0.6.2
 */