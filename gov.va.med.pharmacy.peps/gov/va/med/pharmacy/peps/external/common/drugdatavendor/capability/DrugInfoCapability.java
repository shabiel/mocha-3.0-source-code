package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability;

import gov.va.med.pharmacy.peps.common.vo.DrugInfoResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DrugInfoVo;
import java.util.Collection;

public abstract interface DrugInfoCapability
{
  public abstract DrugInfoResultsVo processDrugInfoRequest(Collection<DrugInfoVo> paramCollection);
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.DrugInfoCapability
 * JD-Core Version:    0.6.2
 */