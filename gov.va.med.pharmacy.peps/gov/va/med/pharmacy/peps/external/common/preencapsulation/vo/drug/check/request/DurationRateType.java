package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="durationRateType")
@XmlEnum
public enum DurationRateType
{
  HOUR, HR, H, MINUTE, MIN, DAY;

  public String value()
  {
    return name();
  }

  public static DurationRateType fromValue(String paramString)
  {
    return valueOf(paramString);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DurationRateType
 * JD-Core Version:    0.6.2
 */