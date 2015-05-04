package gov.va.med.pharmacy.peps.common.exception;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class FDBUpdateInProgressException extends Exception
{
  private static final long serialVersionUID = 1L;
  private static final Logger LOG = Logger.getLogger(PharmacyException.class);
  private MessageKey key;
  private Object[] arguments;

  public FDBUpdateInProgressException(MessageKey paramMessageKey)
  {
    this.key = paramMessageKey;
    this.arguments = new Object[0];
    log();
  }

  public final String getLocalizedMessage()
  {
    ResourceBundle localResourceBundle = ResourceBundle.getBundle("properties/" + getClass().getName(), Locale.getDefault(), Thread.currentThread().getContextClassLoader());
    String str;
    try
    {
      str = localResourceBundle.getString(this.key.getKey());
      if (this.arguments.length > 0)
        str = MessageFormat.format(str, this.arguments);
    }
    catch (MissingResourceException localMissingResourceException)
    {
      str = localMissingResourceException.getLocalizedMessage();
    }
    return str;
  }

  public final String getMessage()
  {
    return getLocalizedMessage();
  }

  protected final void log()
  {
    LOG.error("", this);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.exception.FDBUpdateInProgressException
 * JD-Core Version:    0.6.2
 */