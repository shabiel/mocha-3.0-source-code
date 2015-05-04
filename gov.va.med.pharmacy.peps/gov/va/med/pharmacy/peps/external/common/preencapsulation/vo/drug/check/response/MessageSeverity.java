package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="messageSeverity")
@XmlEnum
public enum MessageSeverity
{
  NOT_SCREENED("NotScreened"), WARNING("Warning"), INFORMATION("Information");

  private final String value;

  private MessageSeverity(String paramString)
  {
    this.value = paramString;
  }

  public String value()
  {
    return this.value;
  }

  public static MessageSeverity fromValue(String paramString)
  {
    for (MessageSeverity localMessageSeverity : values())
      if (localMessageSeverity.value.equals(paramString))
        return localMessageSeverity;
    throw new IllegalArgumentException(paramString);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.MessageSeverity
 * JD-Core Version:    0.6.2
 */