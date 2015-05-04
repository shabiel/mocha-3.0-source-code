package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"header", "body"})
@XmlRootElement(name="PEPSResponse")
public class PEPSResponse extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(name="Header", required=true)
  protected Header header;

  @XmlElement(name="Body")
  protected Body body;

  public Header getHeader()
  {
    return this.header;
  }

  public void setHeader(Header paramHeader)
  {
    this.header = paramHeader;
  }

  public boolean isSetHeader()
  {
    return this.header != null;
  }

  public Body getBody()
  {
    return this.body;
  }

  public void setBody(Body paramBody)
  {
    this.body = paramBody;
  }

  public boolean isSetBody()
  {
    return this.body != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.PEPSResponse
 * JD-Core Version:    0.6.2
 */