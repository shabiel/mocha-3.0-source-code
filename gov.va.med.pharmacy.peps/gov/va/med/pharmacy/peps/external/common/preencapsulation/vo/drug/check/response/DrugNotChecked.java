package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"drug"})
@XmlRootElement(name="drugNotChecked")
public class DrugNotChecked extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  protected Drug drug;

  @XmlAttribute(name="status")
  protected NotCheckedStatus status;

  public Drug getDrug()
  {
    return this.drug;
  }

  public void setDrug(Drug paramDrug)
  {
    this.drug = paramDrug;
  }

  public boolean isSetDrug()
  {
    return this.drug != null;
  }

  public NotCheckedStatus getStatus()
  {
    return this.status;
  }

  public void setStatus(NotCheckedStatus paramNotCheckedStatus)
  {
    this.status = paramNotCheckedStatus;
  }

  public boolean isSetStatus()
  {
    return this.status != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugNotChecked
 * JD-Core Version:    0.6.2
 */