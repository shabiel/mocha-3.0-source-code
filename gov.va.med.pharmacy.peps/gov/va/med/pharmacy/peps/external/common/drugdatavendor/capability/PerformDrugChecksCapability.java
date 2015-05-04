package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability;

import gov.va.med.pharmacy.peps.common.vo.OrderCheckResultsVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckVo;

public abstract interface PerformDrugChecksCapability
{
  public abstract OrderCheckResultsVo performDrugChecks(OrderCheckVo paramOrderCheckVo);
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.PerformDrugChecksCapability
 * JD-Core Version:    0.6.2
 */