package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
  public PEPSRequest createPEPSRequest()
  {
    return new PEPSRequest();
  }

  public Header createHeader()
  {
    return new Header();
  }

  public Time createTime()
  {
    return new Time();
  }

  public MServer createMServer()
  {
    return new MServer();
  }

  public MUser createMUser()
  {
    return new MUser();
  }

  public Body createBody()
  {
    return new Body();
  }

  public DrugCheck createDrugCheck()
  {
    return new DrugCheck();
  }

  public Checks createChecks()
  {
    return new Checks();
  }

  public DrugDrugCheck createDrugDrugCheck()
  {
    return new DrugDrugCheck();
  }

  public DrugTherapyCheck createDrugTherapyCheck()
  {
    return new DrugTherapyCheck();
  }

  public DrugDoseCheck createDrugDoseCheck()
  {
    return new DrugDoseCheck();
  }

  public Demographics createDemographics()
  {
    return new Demographics();
  }

  public ProspectiveDrugs createProspectiveDrugs()
  {
    return new ProspectiveDrugs();
  }

  public Drug createDrug()
  {
    return new Drug();
  }

  public DoseInformation createDoseInformation()
  {
    return new DoseInformation();
  }

  public MedicationProfile createMedicationProfile()
  {
    return new MedicationProfile();
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.ObjectFactory
 * JD-Core Version:    0.6.2
 */