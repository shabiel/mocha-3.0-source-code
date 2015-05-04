package gov.va.med.pharmacy.peps.external.common.preencapsulation.session.impl;

import gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.ProcessDosingInfoCapability;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.session.DosingInfoService;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.dosinginfo.DosingInfoXmlUtility;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

public class DosingInfoServiceImpl
  implements DosingInfoService, InitializingBean
{
  private static final Log LOGGER = LogFactory.getLog(DosingInfoServiceImpl.class);
  private ProcessDosingInfoCapability capability;

  public final String retrieveDosingInformation(String paramString)
  {
    try
    {
      return this.capability.handleRequest(paramString);
    }
    catch (Throwable localThrowable)
    {
      String str = DosingInfoXmlUtility.createXmlErrorMessage(localThrowable);
      LOGGER.error("Error message returned to caller:");
      LOGGER.error(DosingInfoXmlUtility.prettyPrintException(str));
      return str;
    }
  }

  public final void setProcessDosingInfoCapability(ProcessDosingInfoCapability paramProcessDosingInfoCapability)
  {
    this.capability = paramProcessDosingInfoCapability;
  }

  public final void afterPropertiesSet()
    throws Exception
  {
    if (this.capability == null)
      throw new Exception("ProcessDosingInfoCapability has not been injected in to DosingInfoServiceImpl.");
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.session.impl.DosingInfoServiceImpl
 * JD-Core Version:    0.6.2
 */