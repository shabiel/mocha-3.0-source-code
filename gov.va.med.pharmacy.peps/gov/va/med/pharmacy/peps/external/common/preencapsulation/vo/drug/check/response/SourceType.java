package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="sourceType")
@XmlEnum
public enum SourceType
{
  FDB("FDB"), CUSTOM("Custom");

  private final String value;

  private SourceType(String paramString)
  {
    this.value = paramString;
  }

  public String value()
  {
    return this.value;
  }

  public static SourceType fromValue(String paramString)
  {
    for (SourceType localSourceType : values())
      if (localSourceType.value.equals(paramString))
        return localSourceType;
    throw new IllegalArgumentException(paramString);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.SourceType
 * JD-Core Version:    0.6.2
 */