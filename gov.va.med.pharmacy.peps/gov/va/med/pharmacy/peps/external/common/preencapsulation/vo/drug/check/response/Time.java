package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="")
@XmlRootElement(name="Time")
public class Time extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlAttribute(name="value", required=true)
  protected String value;

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }

  public boolean isSetValue()
  {
    return this.value != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.Time
 * JD-Core Version:    0.6.2
 */