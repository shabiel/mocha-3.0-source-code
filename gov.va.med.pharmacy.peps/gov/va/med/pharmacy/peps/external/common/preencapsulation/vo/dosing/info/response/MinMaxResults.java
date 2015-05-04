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
@XmlType(name="", propOrder={"minMax"})
@XmlRootElement(name="minMaxResults")
public class MinMaxResults extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  protected List<MinMax> minMax;

  public List<MinMax> getMinMax()
  {
    if (this.minMax == null)
      this.minMax = new ArrayList();
    return this.minMax;
  }

  public boolean isSetMinMax()
  {
    return (this.minMax != null) && (!this.minMax.isEmpty());
  }

  public void unsetMinMax()
  {
    this.minMax = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.MinMaxResults
 * JD-Core Version:    0.6.2
 */