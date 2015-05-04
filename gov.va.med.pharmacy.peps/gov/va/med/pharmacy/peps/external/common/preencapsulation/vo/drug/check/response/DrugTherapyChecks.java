package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"message", "drugTherapyCheck"})
@XmlRootElement(name="drugTherapyChecks")
public class DrugTherapyChecks extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected List<Message> message;
  protected List<DrugTherapyCheck> drugTherapyCheck;

  public List<Message> getMessage()
  {
    if (this.message == null)
      this.message = new ArrayList();
    return this.message;
  }

  public boolean isSetMessage()
  {
    return (this.message != null) && (!this.message.isEmpty());
  }

  public void unsetMessage()
  {
    this.message = null;
  }

  public List<DrugTherapyCheck> getDrugTherapyCheck()
  {
    if (this.drugTherapyCheck == null)
      this.drugTherapyCheck = new ArrayList();
    return this.drugTherapyCheck;
  }

  public boolean isSetDrugTherapyCheck()
  {
    return (this.drugTherapyCheck != null) && (!this.drugTherapyCheck.isEmpty());
  }

  public void unsetDrugTherapyCheck()
  {
    this.drugTherapyCheck = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugTherapyChecks
 * JD-Core Version:    0.6.2
 */