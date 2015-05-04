package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"drug"})
@XmlRootElement(name="medicationProfile")
public class MedicationProfile extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected List<Drug> drug;

  public List<Drug> getDrug()
  {
    if (this.drug == null)
      this.drug = new ArrayList();
    return this.drug;
  }

  public boolean isSetDrug()
  {
    return (this.drug != null) && (!this.drug.isEmpty());
  }

  public void unsetDrug()
  {
    this.drug = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.MedicationProfile
 * JD-Core Version:    0.6.2
 */