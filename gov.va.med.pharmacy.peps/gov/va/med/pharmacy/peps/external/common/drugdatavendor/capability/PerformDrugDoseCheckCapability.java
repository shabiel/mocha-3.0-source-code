package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability;

import firstdatabank.dif.ScreenDrugs;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckVo;
import gov.va.med.pharmacy.peps.common.vo.DrugDoseCheckResultVo;
import java.util.Map;

public abstract interface PerformDrugDoseCheckCapability
{
  public abstract DrugCheckResultsVo<DrugDoseCheckResultVo> performDrugDoseCheck(ScreenDrugs paramScreenDrugs, Map<String, DrugCheckVo> paramMap, boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2);
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.PerformDrugDoseCheckCapability
 * JD-Core Version:    0.6.2
 */