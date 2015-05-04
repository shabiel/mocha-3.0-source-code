package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"demographics"})
@XmlRootElement(name="drugDoseCheck")
public class DrugDoseCheck extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  protected Demographics demographics;

  public Demographics getDemographics()
  {
    return this.demographics;
  }

  public void setDemographics(Demographics paramDemographics)
  {
    this.demographics = paramDemographics;
  }

  public boolean isSetDemographics()
  {
    return this.demographics != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DrugDoseCheck
 * JD-Core Version:    0.6.2
 */