package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.request;

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
@XmlRootElement(name="dosingInfo")
public class DosingInfo extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlAttribute(name="gcnSeqNo", required=true)
  protected BigInteger gcnSeqNo;

  @XmlAttribute(name="fdbdx", required=true)
  protected String fdbdx;

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
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.request.DosingInfo
 * JD-Core Version:    0.6.2
 */