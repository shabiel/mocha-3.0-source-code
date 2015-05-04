package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="")
@XmlRootElement(name="notFound")
public class NotFound extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlAttribute(name="gcnSeqNo", required=true)
  protected BigInteger gcnSeqNo;

  @XmlAttribute(name="fdbdx", required=true)
  protected String fdbdx;

  @XmlAttribute(name="notFoundReason")
  protected String notFoundReason;

  public BigInteger getGcnSeqNo()
  {
    return this.gcnSeqNo;
  }

  public void setGcnSeqNo(BigInteger paramBigInteger)
  {
    this.gcnSeqNo = paramBigInteger;
  }

  public boolean isSetGcnSeqNo()
  {
    return this.gcnSeqNo != null;
  }

  public String getFdbdx()
  {
    return this.fdbdx;
  }

  public void setFdbdx(String paramString)
  {
    this.fdbdx = paramString;
  }

  public boolean isSetFdbdx()
  {
    return this.fdbdx != null;
  }

  public String getNotFoundReason()
  {
    return this.notFoundReason;
  }

  public void setNotFoundReason(String paramString)
  {
    this.notFoundReason = paramString;
  }

  public boolean isSetNotFoundReason()
  {
    return this.notFoundReason != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.NotFound
 * JD-Core Version:    0.6.2
 */