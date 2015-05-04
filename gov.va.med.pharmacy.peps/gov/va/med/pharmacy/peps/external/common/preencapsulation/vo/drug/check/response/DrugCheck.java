package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"drugsNotChecked", "drugDrugChecks", "drugTherapyChecks", "drugDoseChecks"})
@XmlRootElement(name="drugCheck")
public class DrugCheck extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected DrugsNotChecked drugsNotChecked;
  protected DrugDrugChecks drugDrugChecks;
  protected DrugTherapyChecks drugTherapyChecks;
  protected DrugDoseChecks drugDoseChecks;

  public DrugsNotChecked getDrugsNotChecked()
  {
    return this.drugsNotChecked;
  }

  public void setDrugsNotChecked(DrugsNotChecked paramDrugsNotChecked)
  {
    this.drugsNotChecked = paramDrugsNotChecked;
  }

  public boolean isSetDrugsNotChecked()
  {
    return this.drugsNotChecked != null;
  }

  public DrugDrugChecks getDrugDrugChecks()
  {
    return this.drugDrugChecks;
  }

  public void setDrugDrugChecks(DrugDrugChecks paramDrugDrugChecks)
  {
    this.drugDrugChecks = paramDrugDrugChecks;
  }

  public boolean isSetDrugDrugChecks()
  {
    return this.drugDrugChecks != null;
  }

  public DrugTherapyChecks getDrugTherapyChecks()
  {
    return this.drugTherapyChecks;
  }

  public void setDrugTherapyChecks(DrugTherapyChecks paramDrugTherapyChecks)
  {
    this.drugTherapyChecks = paramDrugTherapyChecks;
  }

  public boolean isSetDrugTherapyChecks()
  {
    return this.drugTherapyChecks != null;
  }

  public DrugDoseChecks getDrugDoseChecks()
  {
    return this.drugDoseChecks;
  }

  public void setDrugDoseChecks(DrugDoseChecks paramDrugDoseChecks)
  {
    this.drugDoseChecks = paramDrugDoseChecks;
  }

  public boolean isSetDrugDoseChecks()
  {
    return this.drugDoseChecks != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugCheck
 * JD-Core Version:    0.6.2
 */