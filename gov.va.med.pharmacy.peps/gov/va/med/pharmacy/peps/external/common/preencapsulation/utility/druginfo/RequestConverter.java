package gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.druginfo;

import gov.va.med.pharmacy.peps.common.vo.DrugInfoVo;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.request.Drug;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.request.DrugInfoRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class RequestConverter
{
  public static Collection<DrugInfoVo> toDrugInfoVo(DrugInfoRequest paramDrugInfoRequest)
  {
    ArrayList localArrayList = new ArrayList(paramDrugInfoRequest.getDrug().size());
    Iterator localIterator = paramDrugInfoRequest.getDrug().iterator();
    while (localIterator.hasNext())
    {
      Drug localDrug = (Drug)localIterator.next();
      DrugInfoVo localDrugInfoVo = new DrugInfoVo();
      localDrugInfoVo.setGcnSeqNo(localDrug.getGcnSeqNo().toString());
      localArrayList.add(localDrugInfoVo);
    }
    return localArrayList;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.druginfo.RequestConverter
 * JD-Core Version:    0.6.2
 */