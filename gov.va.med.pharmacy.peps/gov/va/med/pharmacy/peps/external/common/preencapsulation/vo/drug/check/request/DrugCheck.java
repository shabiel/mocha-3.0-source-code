package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"checks", "prospectiveDrugs", "medicationProfile"})
@XmlRootElement(name="drugCheck")
public class DrugCheck extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  protected Checks checks;
  protected ProspectiveDrugs prospectiveDrugs;
  protected MedicationProfile medicationProfile;

  public Checks getChecks()
  {
    return this.checks;
  }

  public void setChecks(Checks paramChecks)
  {
    this.checks = paramChecks;
  }

  public boolean isSetChecks()
  {
    return this.checks != null;
  }

  public ProspectiveDrugs getProspectiveDrugs()
  {
    return this.prospectiveDrugs;
  }

  public void setProspectiveDrugs(ProspectiveDrugs paramProspectiveDrugs)
  {
    this.prospectiveDrugs = paramProspectiveDrugs;
  }

  public boolean isSetProspectiveDrugs()
  {
    return this.prospectiveDrugs != null;
  }

  public MedicationProfile getMedicationProfile()
  {
    return this.medicationProfile;
  }

  public void setMedicationProfile(MedicationProfile paramMedicationProfile)
  {
    this.medicationProfile = paramMedicationProfile;
  }

  public boolean isSetMedicationProfile()
  {
    return this.medicationProfile != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DrugCheck
 * JD-Core Version:    0.6.2
 */