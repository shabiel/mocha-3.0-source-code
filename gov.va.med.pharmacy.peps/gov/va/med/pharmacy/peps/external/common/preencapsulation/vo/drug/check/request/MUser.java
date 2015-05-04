package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="")
@XmlRootElement(name="MUser")
public class MUser extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlAttribute(name="jobNumber", required=true)
  @XmlSchemaType(name="unsignedLong")
  protected BigInteger jobNumber;

  @XmlAttribute(name="duz", required=true)
  @XmlSchemaType(name="unsignedLong")
  protected BigInteger duz;

  @XmlAttribute(name="userName", required=true)
  protected String userName;

  public BigInteger getJobNumber()
  {
    return this.jobNumber;
  }

  public void setJobNumber(BigInteger paramBigInteger)
  {
    this.jobNumber = paramBigInteger;
  }

  public boolean isSetJobNumber()
  {
    return this.jobNumber != null;
  }

  public BigInteger getDuz()
  {
    return this.duz;
  }

  public void setDuz(BigInteger paramBigInteger)
  {
    this.duz = paramBigInteger;
  }

  public boolean isSetDuz()
  {
    return this.duz != null;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }

  public boolean isSetUserName()
  {
    return this.userName != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.MUser
 * JD-Core Version:    0.6.2
 */