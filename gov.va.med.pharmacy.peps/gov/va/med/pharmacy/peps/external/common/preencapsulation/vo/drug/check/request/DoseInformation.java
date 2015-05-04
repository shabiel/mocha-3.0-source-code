package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"doseType", "doseAmount", "doseUnit", "doseRate", "frequency", "duration", "durationRate", "route"})
@XmlRootElement(name="doseInformation")
public class DoseInformation extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  @XmlSchemaType(name="string")
  protected DoseTypeType doseType;
  protected double doseAmount;

  @XmlElement(required=true)
  @XmlSchemaType(name="string")
  protected DoseUnitType doseUnit;

  @XmlElement(required=true)
  @XmlSchemaType(name="string")
  protected DoseRateType doseRate;

  @XmlElement(required=true)
  protected String frequency;

  @XmlElement(required=true)
  protected BigInteger duration;

  @XmlElement(required=true)
  @XmlSchemaType(name="string")
  protected DurationRateType durationRate;

  @XmlElement(required=true)
  @XmlSchemaType(name="string")
  protected RouteType route;

  public DoseTypeType getDoseType()
  {
    return this.doseType;
  }

  public void setDoseType(DoseTypeType paramDoseTypeType)
  {
    this.doseType = paramDoseTypeType;
  }

  public boolean isSetDoseType()
  {
    return this.doseType != null;
  }

  public double getDoseAmount()
  {
    return this.doseAmount;
  }

  public void setDoseAmount(double paramDouble)
  {
    this.doseAmount = paramDouble;
  }

  public boolean isSetDoseAmount()
  {
    return true;
  }

  public DoseUnitType getDoseUnit()
  {
    return this.doseUnit;
  }

  public void setDoseUnit(DoseUnitType paramDoseUnitType)
  {
    this.doseUnit = paramDoseUnitType;
  }

  public boolean isSetDoseUnit()
  {
    return this.doseUnit != null;
  }

  public DoseRateType getDoseRate()
  {
    return this.doseRate;
  }

  public void setDoseRate(DoseRateType paramDoseRateType)
  {
    this.doseRate = paramDoseRateType;
  }

  public boolean isSetDoseRate()
  {
    return this.doseRate != null;
  }

  public String getFrequency()
  {
    return this.frequency;
  }

  public void setFrequency(String paramString)
  {
    this.frequency = paramString;
  }

  public boolean isSetFrequency()
  {
    return this.frequency != null;
  }

  public BigInteger getDuration()
  {
    return this.duration;
  }

  public void setDuration(BigInteger paramBigInteger)
  {
    this.duration = paramBigInteger;
  }

  public boolean isSetDuration()
  {
    return this.duration != null;
  }

  public DurationRateType getDurationRate()
  {
    return this.durationRate;
  }

  public void setDurationRate(DurationRateType paramDurationRateType)
  {
    this.durationRate = paramDurationRateType;
  }

  public boolean isSetDurationRate()
  {
    return this.durationRate != null;
  }

  public RouteType getRoute()
  {
    return this.route;
  }

  public void setRoute(RouteType paramRouteType)
  {
    this.route = paramRouteType;
  }

  public boolean isSetRoute()
  {
    return this.route != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DoseInformation
 * JD-Core Version:    0.6.2
 */