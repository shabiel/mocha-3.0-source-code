package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"drugNotChecked"})
@XmlRootElement(name="drugsNotChecked")
public class DrugsNotChecked extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  protected List<DrugNotChecked> drugNotChecked;

  public List<DrugNotChecked> getDrugNotChecked()
  {
    if (this.drugNotChecked == null)
      this.drugNotChecked = new ArrayList();
    return this.drugNotChecked;
  }

  public boolean isSetDrugNotChecked()
  {
    return (this.drugNotChecked != null) && (!this.drugNotChecked.isEmpty());
  }

  public void unsetDrugNotChecked()
  {
    this.drugNotChecked = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugsNotChecked
 * JD-Core Version:    0.6.2
 */