package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={})
@XmlRootElement(name="checks")
public class Checks extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected DrugDrugCheck drugDrugCheck;
  protected DrugTherapyCheck drugTherapyCheck;
  protected DrugDoseCheck drugDoseCheck;

  @XmlAttribute(name="prospectiveOnly", required=true)
  protected boolean prospectiveOnly;

  @XmlAttribute(name="useCustomTables")
  protected Boolean useCustomTables;

  public DrugDrugCheck getDrugDrugCheck()
  {
    return this.drugDrugCheck;
  }

  public void setDrugDrugCheck(DrugDrugCheck paramDrugDrugCheck)
  {
    this.drugDrugCheck = paramDrugDrugCheck;
  }

  public boolean isSetDrugDrugCheck()
  {
    return this.drugDrugCheck != null;
  }

  public DrugTherapyCheck getDrugTherapyCheck()
  {
    return this.drugTherapyCheck;
  }

  public void setDrugTherapyCheck(DrugTherapyCheck paramDrugTherapyCheck)
  {
    this.drugTherapyCheck = paramDrugTherapyCheck;
  }

  public boolean isSetDrugTherapyCheck()
  {
    return this.drugTherapyCheck != null;
  }

  public DrugDoseCheck getDrugDoseCheck()
  {
    return this.drugDoseCheck;
  }

  public void setDrugDoseCheck(DrugDoseCheck paramDrugDoseCheck)
  {
    this.drugDoseCheck = paramDrugDoseCheck;
  }

  public boolean isSetDrugDoseCheck()
  {
    return this.drugDoseCheck != null;
  }

  public boolean isProspectiveOnly()
  {
    return this.prospectiveOnly;
  }

  public void setProspectiveOnly(boolean paramBoolean)
  {
    this.prospectiveOnly = paramBoolean;
  }

  public boolean isSetProspectiveOnly()
  {
    return true;
  }

  public boolean isUseCustomTables()
  {
    if (this.useCustomTables == null)
      return true;
    return this.useCustomTables.booleanValue();
  }

  public void setUseCustomTables(boolean paramBoolean)
  {
    this.useCustomTables = Boolean.valueOf(paramBoolean);
  }

  public boolean isSetUseCustomTables()
  {
    return this.useCustomTables != null;
  }

  public void unsetUseCustomTables()
  {
    this.useCustomTables = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Checks
 * JD-Core Version:    0.6.2
 */