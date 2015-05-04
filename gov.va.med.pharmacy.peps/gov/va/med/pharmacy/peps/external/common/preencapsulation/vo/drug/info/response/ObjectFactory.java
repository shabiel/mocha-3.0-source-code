package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
  public DrugInfoResponse createDrugInfoResponse()
  {
    return new DrugInfoResponse();
  }

  public DrugsNotFound createDrugsNotFound()
  {
    return new DrugsNotFound();
  }

  public DrugNotFound createDrugNotFound()
  {
    return new DrugNotFound();
  }

  public Drug createDrug()
  {
    return new Drug();
  }

  public Routes createRoutes()
  {
    return new Routes();
  }

  public Route createRoute()
  {
    return new Route();
  }

  public DoseTypes createDoseTypes()
  {
    return new DoseTypes();
  }

  public DoseType createDoseType()
  {
    return new DoseType();
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.ObjectFactory
 * JD-Core Version:    0.6.2
 */