package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

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
@XmlRootElement(name="drug")
public class Drug extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlAttribute(name="gcnSeqNo", required=true)
  protected BigInteger gcnSeqNo;

  @XmlAttribute(name="vuid")
  protected BigInteger vuid;

  @XmlAttribute(name="drugName")
  protected String drugName;

  @XmlAttribute(name="ien")
  protected BigInteger ien;

  @XmlAttribute(name="orderNumber", required=true)
  protected String orderNumber;

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

  public BigInteger getVuid()
  {
    return this.vuid;
  }

  public void setVuid(BigInteger paramBigInteger)
  {
    this.vuid = paramBigInteger;
  }

  public boolean isSetVuid()
  {
    return this.vuid != null;
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

  public BigInteger getIen()
  {
    return this.ien;
  }

  public void setIen(BigInteger paramBigInteger)
  {
    this.ien = paramBigInteger;
  }

  public boolean isSetIen()
  {
    return this.ien != null;
  }

  public String getOrderNumber()
  {
    return this.orderNumber;
  }

  public void setOrderNumber(String paramString)
  {
    this.orderNumber = paramString;
  }

  public boolean isSetOrderNumber()
  {
    return this.orderNumber != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.Drug
 * JD-Core Version:    0.6.2
 */