package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="")
@XmlRootElement(name="drugTherapyCheck")
public class DrugTherapyCheck extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlAttribute(name="useDuplicateAllowance")
  protected Boolean useDuplicateAllowance;

  public boolean isUseDuplicateAllowance()
  {
    if (this.useDuplicateAllowance == null)
      return true;
    return this.useDuplicateAllowance.booleanValue();
  }

  public void setUseDuplicateAllowance(boolean paramBoolean)
  {
    this.useDuplicateAllowance = Boolean.valueOf(paramBoolean);
  }

  public boolean isSetUseDuplicateAllowance()
  {
    return this.useDuplicateAllowance != null;
  }

  public void unsetUseDuplicateAllowance()
  {
    this.useDuplicateAllowance = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DrugTherapyCheck
 * JD-Core Version:    0.6.2
 */