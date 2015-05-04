package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response;

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
@XmlType(name="", propOrder={"doseRange"})
@XmlRootElement(name="neonatalDoseRanges")
public class NeonatalDoseRanges extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  protected List<DoseRange> doseRange;

  public List<DoseRange> getDoseRange()
  {
    if (this.doseRange == null)
      this.doseRange = new ArrayList();
    return this.doseRange;
  }

  public boolean isSetDoseRange()
  {
    return (this.doseRange != null) && (!this.doseRange.isEmpty());
  }

  public void unsetDoseRange()
  {
    this.doseRange = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.NeonatalDoseRanges
 * JD-Core Version:    0.6.2
 */