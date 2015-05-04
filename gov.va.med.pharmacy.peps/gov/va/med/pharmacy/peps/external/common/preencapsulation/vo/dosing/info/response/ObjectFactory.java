package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
  public DosingInfoResponse createDosingInfoResponse()
  {
    return new DosingInfoResponse();
  }

  public DosingNotFound createDosingNotFound()
  {
    return new DosingNotFound();
  }

  public NotFound createNotFound()
  {
    return new NotFound();
  }

  public DosingInfo createDosingInfo()
  {
    return new DosingInfo();
  }

  public DoseRanges createDoseRanges()
  {
    return new DoseRanges();
  }

  public DoseRange createDoseRange()
  {
    return new DoseRange();
  }

  public MinMaxResults createMinMaxResults()
  {
    return new MinMaxResults();
  }

  public MinMax createMinMax()
  {
    return new MinMax();
  }

  public NeonatalDoseRanges createNeonatalDoseRanges()
  {
    return new NeonatalDoseRanges();
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.ObjectFactory
 * JD-Core Version:    0.6.2
 */