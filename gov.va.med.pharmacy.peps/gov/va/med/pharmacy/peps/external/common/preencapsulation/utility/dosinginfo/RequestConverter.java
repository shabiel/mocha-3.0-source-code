package gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.dosinginfo;

import gov.va.med.pharmacy.peps.common.vo.DosingInfoVo;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.request.DosingInfo;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.request.DosingInfoRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class RequestConverter
{
  public static Collection<DosingInfoVo> toDosingInfoVo(DosingInfoRequest paramDosingInfoRequest)
  {
    ArrayList localArrayList = new ArrayList(paramDosingInfoRequest.getDosingInfo().size());
    Iterator localIterator = paramDosingInfoRequest.getDosingInfo().iterator();
    while (localIterator.hasNext())
    {
      DosingInfo localDosingInfo = (DosingInfo)localIterator.next();
      DosingInfoVo localDosingInfoVo = new DosingInfoVo();
      localDosingInfoVo.setGcnSeqNo(localDosingInfo.getGcnSeqNo());
      localDosingInfoVo.setFdbdx(localDosingInfo.getFdbdx());
      localArrayList.add(localDosingInfoVo);
    }
    return localArrayList;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.dosinginfo.RequestConverter
 * JD-Core Version:    0.6.2
 */