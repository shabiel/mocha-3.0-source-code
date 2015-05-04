package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response;

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
@XmlType(name="", propOrder={"drugNotFound"})
@XmlRootElement(name="drugsNotFound")
public class DrugsNotFound extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  protected List<DrugNotFound> drugNotFound;

  public List<DrugNotFound> getDrugNotFound()
  {
    if (this.drugNotFound == null)
      this.drugNotFound = new ArrayList();
    return this.drugNotFound;
  }

  public boolean isSetDrugNotFound()
  {
    return (this.drugNotFound != null) && (!this.drugNotFound.isEmpty());
  }

  public void unsetDrugNotFound()
  {
    this.drugNotFound = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.DrugsNotFound
 * JD-Core Version:    0.6.2
 */