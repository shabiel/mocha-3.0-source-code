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
@XmlRootElement(name="demographics")
public class Demographics extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlAttribute(name="ageInDays", required=true)
  protected long ageInDays;

  @XmlAttribute(name="weightInKG", required=true)
  protected double weightInKG;

  @XmlAttribute(name="bodySurfaceAreaInSqM", required=true)
  protected double bodySurfaceAreaInSqM;

  public long getAgeInDays()
  {
    return this.ageInDays;
  }

  public void setAgeInDays(long paramLong)
  {
    this.ageInDays = paramLong;
  }

  public boolean isSetAgeInDays()
  {
    return true;
  }

  public double getWeightInKG()
  {
    return this.weightInKG;
  }

  public void setWeightInKG(double paramDouble)
  {
    this.weightInKG = paramDouble;
  }

  public boolean isSetWeightInKG()
  {
    return true;
  }

  public double getBodySurfaceAreaInSqM()
  {
    return this.bodySurfaceAreaInSqM;
  }

  public void setBodySurfaceAreaInSqM(double paramDouble)
  {
    this.bodySurfaceAreaInSqM = paramDouble;
  }

  public boolean isSetBodySurfaceAreaInSqM()
  {
    return true;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Demographics
 * JD-Core Version:    0.6.2
 */