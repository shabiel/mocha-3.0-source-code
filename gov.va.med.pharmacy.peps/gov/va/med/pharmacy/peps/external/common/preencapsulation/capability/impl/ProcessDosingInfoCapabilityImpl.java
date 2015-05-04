package gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.impl;

import gov.va.med.pharmacy.peps.common.exception.InterfaceValidationException;
import gov.va.med.pharmacy.peps.common.vo.DosingInfoResultsVo;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.DosingInfoCapability;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.ProcessDosingInfoCapability;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.dosinginfo.DosingInfoXmlUtility;
import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

public class ProcessDosingInfoCapabilityImpl
  implements InitializingBean, ProcessDosingInfoCapability
{
  private static final Log LOGGER = LogFactory.getLog(ProcessDosingInfoCapabilityImpl.class);
  private DosingInfoCapability dosingCapability;

  public final String handleRequest(String paramString)
  {
    if (LOGGER.isDebugEnabled())
    {
      LOGGER.debug("Request received from VistA:");
      LOGGER.debug(paramString);
    }
    if (paramString == null)
      throw new InterfaceValidationException(InterfaceValidationException.XML_REQUEST_REQUIRED);
    Collection localCollection = DosingInfoXmlUtility.toDosingInfoVo(paramString);
    DosingInfoResultsVo localDosingInfoResultsVo = this.dosingCapability.processDosingInfoRequest(localCollection);
    String str = DosingInfoXmlUtility.toDosingInfoResponse(localDosingInfoResultsVo);
    if (LOGGER.isDebugEnabled())
    {
      LOGGER.debug("Response sent back to VistA:");
      LOGGER.debug(DosingInfoXmlUtility.prettyPrintResponse(str));
    }
    return str;
  }

  public final void setDosingInfoCapability(DosingInfoCapability paramDosingInfoCapability)
  {
    this.dosingCapability = paramDosingInfoCapability;
  }

  public final void afterPropertiesSet()
    throws Exception
  {
    if (this.dosingCapability == null)
      throw new Exception("DosingInfoCapability has not been injected in to ProcessDosingInfoCapabilityImpl.");
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.impl.ProcessDosingInfoCapabilityImpl
 * JD-Core Version:    0.6.2
 */