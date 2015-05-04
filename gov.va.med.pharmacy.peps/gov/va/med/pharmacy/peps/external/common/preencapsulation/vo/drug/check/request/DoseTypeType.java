package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="doseTypeType")
@XmlEnum
public enum DoseTypeType
{
  LOADING("LOADING"), MAINTENANCE("MAINTENANCE"), SINGLE_DOSE("SINGLE DOSE");

  private final String value;

  private DoseTypeType(String paramString)
  {
    this.value = paramString;
  }

  public String value()
  {
    return this.value;
  }

  public static DoseTypeType fromValue(String paramString)
  {
    for (DoseTypeType localDoseTypeType : values())
      if (localDoseTypeType.value.equals(paramString))
        return localDoseTypeType;
    throw new IllegalArgumentException(paramString);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DoseTypeType
 * JD-Core Version:    0.6.2
 */