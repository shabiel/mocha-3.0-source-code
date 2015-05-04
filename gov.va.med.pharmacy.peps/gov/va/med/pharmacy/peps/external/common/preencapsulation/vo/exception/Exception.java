package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"code", "message", "detailedMessage"})
@XmlRootElement(name="exception")
public class Exception extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  @XmlSchemaType(name="string")
  protected ExceptionCodeType code;

  @XmlElement(required=true)
  protected String message;

  @XmlElement(required=true)
  protected String detailedMessage;

  public ExceptionCodeType getCode()
  {
    return this.code;
  }

  public void setCode(ExceptionCodeType paramExceptionCodeType)
  {
    this.code = paramExceptionCodeType;
  }

  public boolean isSetCode()
  {
    return this.code != null;
  }

  public String getMessage()
  {
    return this.message;
  }

  public void setMessage(String paramString)
  {
    this.message = paramString;
  }

  public boolean isSetMessage()
  {
    return this.message != null;
  }

  public String getDetailedMessage()
  {
    return this.detailedMessage;
  }

  public void setDetailedMessage(String paramString)
  {
    this.detailedMessage = paramString;
  }

  public boolean isSetDetailedMessage()
  {
    return this.detailedMessage != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.Exception
 * JD-Core Version:    0.6.2
 */