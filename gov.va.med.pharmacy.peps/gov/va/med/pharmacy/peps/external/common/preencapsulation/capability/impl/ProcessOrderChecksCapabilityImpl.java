package gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.impl;

import gov.va.med.pharmacy.peps.common.exception.InterfaceValidationException;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckHeaderVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckResultsVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckVo;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.PerformDrugChecksCapability;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.VersionCapability;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.ProcessOrderChecksCapability;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.drugcheck.DrugCheckXmlUtility;
import org.apache.log4j.Logger;

public class ProcessOrderChecksCapabilityImpl
  implements ProcessOrderChecksCapability
{
  private static final Logger LOG = Logger.getLogger(ProcessOrderChecksCapabilityImpl.class);
  private PerformDrugChecksCapability performDrugChecksCapability;
  private VersionCapability versionCapability;

  public final String handleRequest(String paramString)
  {
    LOG.debug("Request received from VistA:");
    LOG.debug(paramString);
    if (paramString == null)
      throw new InterfaceValidationException(InterfaceValidationException.XML_REQUEST_REQUIRED);
    OrderCheckVo localOrderCheckVo = DrugCheckXmlUtility.toOrderCheckVo(paramString);
    LOG.debug(localOrderCheckVo);
    String str;
    if ((localOrderCheckVo.getHeader().isPingOnly()) && (!localOrderCheckVo.hasDrugsToScreen()))
    {
      str = DrugCheckXmlUtility.createPingResponse(localOrderCheckVo.getHeader(), this.versionCapability.retrieveDrugDataVendorVersion());
    }
    else
    {
      if ((!localOrderCheckVo.isDrugDoseCheck()) && (!localOrderCheckVo.isDrugDrugCheck()) && (!localOrderCheckVo.isDrugTherapyCheck()))
        throw new InterfaceValidationException(InterfaceValidationException.ORDER_CHECK_REQUERED);
      if (!localOrderCheckVo.hasDrugsToScreen())
        throw new InterfaceValidationException(InterfaceValidationException.DRUGS_TO_SCREEN_REQUIRED);
      OrderCheckResultsVo localOrderCheckResultsVo = this.performDrugChecksCapability.performDrugChecks(localOrderCheckVo);
      localOrderCheckResultsVo.setHeader(localOrderCheckVo.getHeader());
      localOrderCheckResultsVo.setDrugDataVendorVersion(this.versionCapability.retrieveDrugDataVendorVersion());
      str = DrugCheckXmlUtility.toPepsResponse(localOrderCheckResultsVo);
      if (LOG.isDebugEnabled())
      {
        LOG.debug("Response sent back to VistA:");
        LOG.debug(DrugCheckXmlUtility.prettyPrintResponse(str));
      }
    }
    return str;
  }

  public final void setVersionCapability(VersionCapability paramVersionCapability)
  {
    this.versionCapability = paramVersionCapability;
  }

  public final void setPerformDrugChecksCapability(PerformDrugChecksCapability paramPerformDrugChecksCapability)
  {
    this.performDrugChecksCapability = paramPerformDrugChecksCapability;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.impl.ProcessOrderChecksCapabilityImpl
 * JD-Core Version:    0.6.2
 */