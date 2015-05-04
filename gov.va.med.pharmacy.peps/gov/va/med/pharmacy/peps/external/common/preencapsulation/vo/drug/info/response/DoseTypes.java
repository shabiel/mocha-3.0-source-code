package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"doseType"})
@XmlRootElement(name="doseTypes")
public class DoseTypes extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected List<DoseType> doseType;

  public List<DoseType> getDoseType()
  {
    if (this.doseType == null)
      this.doseType = new ArrayList();
    return this.doseType;
  }

  public boolean isSetDoseType()
  {
    return (this.doseType != null) && (!this.doseType.isEmpty());
  }

  public void unsetDoseType()
  {
    this.doseType = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.DoseTypes
 * JD-Core Version:    0.6.2
 */