package gov.va.med.pharmacy.peps.external.common.preencapsulation.session.impl;

import gov.va.med.pharmacy.peps.common.exception.FDBUpdateInProgressException;
import gov.va.med.pharmacy.peps.common.exception.MessageKey;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.ProcessOrderChecksCapability;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.session.OrderCheckService;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.drugcheck.DrugCheckXmlUtility;
import javax.naming.NamingException;
import org.apache.log4j.Logger;
import org.springframework.jndi.JndiTemplate;

public class OrderCheckServiceImpl
  implements OrderCheckService
{
  private static final Logger LOG = Logger.getLogger(OrderCheckServiceImpl.class);
  private static int RUNCOUNTER;
  private Long lastSynchonizationCheck = Long.valueOf(System.currentTimeMillis());
  private boolean updateInProgress;
  private static final int MILLISECONDS = 1000;
  private static final int NUMBER_OF_SECONDS_TO_SLEEP = 15;
  private ProcessOrderChecksCapability processOrderChecksCapability;
  private JndiTemplate jndiTemplate;

  public static boolean isRunning()
  {
    return RUNCOUNTER > 0;
  }

  public final String performOrderCheck(String paramString)
  {
    try
    {
      if (System.currentTimeMillis() - this.lastSynchonizationCheck.longValue() >= 15000L)
      {
        try
        {
          this.updateInProgress = Boolean.TRUE.equals(this.jndiTemplate.lookup("DATUP_UPDATE_IN_PROGRESS"));
        }
        catch (NamingException localNamingException)
        {
          LOG.debug("DATUP does not appear to be installed. Update synchronization check will not be performed.", localNamingException);
        }
        this.lastSynchonizationCheck = Long.valueOf(System.currentTimeMillis());
      }
      if (this.updateInProgress)
        throw new FDBUpdateInProgressException(new MessageKey("UPDATE_IN_PROGRESS"));
      try
      {
        RUNCOUNTER += 1;
        String str1 = this.processOrderChecksCapability.handleRequest(paramString);
        return str1;
      }
      finally
      {
        RUNCOUNTER -= 1;
      }
    }
    catch (Throwable localThrowable)
    {
      String str2 = DrugCheckXmlUtility.createXmlErrorMessage(localThrowable);
      LOG.error("Error message sent to VistA:");
      LOG.error(DrugCheckXmlUtility.prettyPrintException(str2));
      return str2;
    }
  }

  public final void setProcessOrderChecksCapability(ProcessOrderChecksCapability paramProcessOrderChecksCapability)
  {
    this.processOrderChecksCapability = paramProcessOrderChecksCapability;
  }

  public final boolean updatesRunning()
  {
    return RUNCOUNTER == 0;
  }

  public final void setJndiTemplate(JndiTemplate paramJndiTemplate)
  {
    this.jndiTemplate = paramJndiTemplate;
  }

  public final JndiTemplate getJndiTemplate()
  {
    return this.jndiTemplate;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.session.impl.OrderCheckServiceImpl
 * JD-Core Version:    0.6.2
 */