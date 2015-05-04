package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="doseStatus")
@XmlEnum
public enum DoseStatus
{
  UNABLE_TO_CHECK("UnableToCheck"), PASSED("Passed"), EXCEEDS_MAX("ExceedsMax"), EXCEEDS_RECOMMENDED("ExceedsRecommended"), BELOW_RECOMMENDED("BelowRecommended");

  private final String value;

  private DoseStatus(String paramString)
  {
    this.value = paramString;
  }

  public String value()
  {
    return this.value;
  }

  public static DoseStatus fromValue(String paramString)
  {
    for (DoseStatus localDoseStatus : values())
      if (localDoseStatus.value.equals(paramString))
        return localDoseStatus;
    throw new IllegalArgumentException(paramString);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DoseStatus
 * JD-Core Version:    0.6.2
 */