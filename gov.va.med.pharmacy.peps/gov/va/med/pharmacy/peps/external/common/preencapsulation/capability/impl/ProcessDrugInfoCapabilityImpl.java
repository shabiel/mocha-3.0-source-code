package gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.impl;

import gov.va.med.pharmacy.peps.common.exception.InterfaceValidationException;
import gov.va.med.pharmacy.peps.common.vo.DrugInfoResultsVo;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.DrugInfoCapability;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.ProcessDrugInfoCapability;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.druginfo.DrugInfoXmlUtility;
import java.util.Collection;
import org.apache.log4j.Logger;

public class ProcessDrugInfoCapabilityImpl
  implements ProcessDrugInfoCapability
{
  private static final Logger LOG = Logger.getLogger(ProcessDrugInfoCapabilityImpl.class);
  private DrugInfoCapability drugInfoCapability;

  public final String handleRequest(String paramString)
  {
    LOG.debug("Request received from VistA:");
    LOG.debug(paramString);
    if (paramString == null)
      throw new InterfaceValidationException(InterfaceValidationException.XML_REQUEST_REQUIRED);
    Collection localCollection = DrugInfoXmlUtility.toDrugInfoVo(paramString);
    DrugInfoResultsVo localDrugInfoResultsVo = this.drugInfoCapability.processDrugInfoRequest(localCollection);
    String str = DrugInfoXmlUtility.toDrugInfoResponse(localDrugInfoResultsVo);
    if (LOG.isDebugEnabled())
    {
      LOG.debug("Response sent back to VistA:");
      LOG.debug(DrugInfoXmlUtility.prettyPrintResponse(str));
    }
    return str;
  }

  public final void setDrugInfoCapability(DrugInfoCapability paramDrugInfoCapability)
  {
    this.drugInfoCapability = paramDrugInfoCapability;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.impl.ProcessDrugInfoCapabilityImpl
 * JD-Core Version:    0.6.2
 */