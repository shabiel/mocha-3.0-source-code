package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability;

import firstdatabank.dif.ScreenDrugs;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckVo;
import gov.va.med.pharmacy.peps.common.vo.DrugTherapyCheckResultVo;
import java.util.Map;

public abstract interface PerformDrugTherapyCheckCapability
{
  public abstract DrugCheckResultsVo<DrugTherapyCheckResultVo> performDrugTherapyCheck(ScreenDrugs paramScreenDrugs, Map<String, DrugCheckVo> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.PerformDrugTherapyCheckCapability
 * JD-Core Version:    0.6.2
 */