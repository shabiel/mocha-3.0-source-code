package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"drugCheck"})
@XmlRootElement(name="Body")
public class Body extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  protected DrugCheck drugCheck;

  public DrugCheck getDrugCheck()
  {
    return this.drugCheck;
  }

  public void setDrugCheck(DrugCheck paramDrugCheck)
  {
    this.drugCheck = paramDrugCheck;
  }

  public boolean isSetDrugCheck()
  {
    return this.drugCheck != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Body
 * JD-Core Version:    0.6.2
 */