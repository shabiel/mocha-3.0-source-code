package gov.va.med.pharmacy.peps.external.common.preencapsulation.session.impl;

import gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.ProcessDrugInfoCapability;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.session.DrugInfoService;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.druginfo.DrugInfoXmlUtility;
import org.apache.log4j.Logger;

public class DrugInfoServiceImpl
  implements DrugInfoService
{
  private static final Logger LOG = Logger.getLogger(DrugInfoServiceImpl.class);
  private ProcessDrugInfoCapability processDrugInfoCapability;

  public final String retrieveDrugInformation(String paramString)
  {
    try
    {
      return this.processDrugInfoCapability.handleRequest(paramString);
    }
    catch (Throwable localThrowable)
    {
      String str = DrugInfoXmlUtility.createXmlErrorMessage(localThrowable);
      LOG.error("Error message sent to VistA:");
      LOG.error(DrugInfoXmlUtility.prettyPrintException(str));
      return str;
    }
  }

  public final void setProcessDrugInfoCapability(ProcessDrugInfoCapability paramProcessDrugInfoCapability)
  {
    this.processDrugInfoCapability = paramProcessDrugInfoCapability;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.session.impl.DrugInfoServiceImpl
 * JD-Core Version:    0.6.2
 */