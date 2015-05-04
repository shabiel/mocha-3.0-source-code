package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability;

import gov.va.med.pharmacy.peps.common.vo.DosingInfoResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DosingInfoVo;
import java.util.Collection;

public abstract interface DosingInfoCapability
{
  public abstract DosingInfoResultsVo processDosingInfoRequest(Collection<DosingInfoVo> paramCollection);
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.DosingInfoCapability
 * JD-Core Version:    0.6.2
 */