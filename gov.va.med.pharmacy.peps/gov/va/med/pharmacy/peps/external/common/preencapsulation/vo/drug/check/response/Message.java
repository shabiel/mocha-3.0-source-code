package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"drug", "severity", "type", "drugName", "text"})
@XmlRootElement(name="message")
public class Message extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Drug drug;

  @XmlElement(required=true)
  @XmlSchemaType(name="string")
  protected MessageSeverity severity;

  @XmlElement(required=true)
  @XmlSchemaType(name="string")
  protected MessageTypeType type;

  @XmlElement(required=true)
  protected String drugName;

  @XmlElement(required=true)
  protected String text;

  public Drug getDrug()
  {
    return this.drug;
  }

  public void setDrug(Drug paramDrug)
  {
    this.drug = paramDrug;
  }

  public boolean isSetDrug()
  {
    return this.drug != null;
  }

  public MessageSeverity getSeverity()
  {
    return this.severity;
  }

  public void setSeverity(MessageSeverity paramMessageSeverity)
  {
    this.severity = paramMessageSeverity;
  }

  public boolean isSetSeverity()
  {
    return this.severity != null;
  }

  public MessageTypeType getType()
  {
    return this.type;
  }

  public void setType(MessageTypeType paramMessageTypeType)
  {
    this.type = paramMessageTypeType;
  }

  public boolean isSetType()
  {
    return this.type != null;
  }

  public String getDrugName()
  {
    return this.drugName;
  }

  public void setDrugName(String paramString)
  {
    this.drugName = paramString;
  }

  public boolean isSetDrugName()
  {
    return this.drugName != null;
  }

  public String getText()
  {
    return this.text;
  }

  public void setText(String paramString)
  {
    this.text = paramString;
  }

  public boolean isSetText()
  {
    return this.text != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.Message
 * JD-Core Version:    0.6.2
 */