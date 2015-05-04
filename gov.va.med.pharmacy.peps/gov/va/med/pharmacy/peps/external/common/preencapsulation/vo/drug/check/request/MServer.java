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
@XmlRootElement(name="MServer")
public class MServer extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlAttribute(name="stationNumber", required=true)
  @XmlSchemaType(name="unsignedLong")
  protected BigInteger stationNumber;

  @XmlAttribute(name="serverName", required=true)
  protected String serverName;

  @XmlAttribute(name="ip", required=true)
  protected String ip;

  @XmlAttribute(name="uci", required=true)
  protected String uci;

  @XmlAttribute(name="namespace", required=true)
  protected String namespace;

  public BigInteger getStationNumber()
  {
    return this.stationNumber;
  }

  public void setStationNumber(BigInteger paramBigInteger)
  {
    this.stationNumber = paramBigInteger;
  }

  public boolean isSetStationNumber()
  {
    return this.stationNumber != null;
  }

  public String getServerName()
  {
    return this.serverName;
  }

  public void setServerName(String paramString)
  {
    this.serverName = paramString;
  }

  public boolean isSetServerName()
  {
    return this.serverName != null;
  }

  public String getIp()
  {
    return this.ip;
  }

  public void setIp(String paramString)
  {
    this.ip = paramString;
  }

  public boolean isSetIp()
  {
    return this.ip != null;
  }

  public String getUci()
  {
    return this.uci;
  }

  public void setUci(String paramString)
  {
    this.uci = paramString;
  }

  public boolean isSetUci()
  {
    return this.uci != null;
  }

  public String getNamespace()
  {
    return this.namespace;
  }

  public void setNamespace(String paramString)
  {
    this.namespace = paramString;
  }

  public boolean isSetNamespace()
  {
    return this.namespace != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.MServer
 * JD-Core Version:    0.6.2
 */