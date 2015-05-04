package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"time", "mServer", "mUser", "pepsVersion"})
@XmlRootElement(name="Header")
public class Header extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(name="Time", required=true)
  protected Time time;

  @XmlElement(name="MServer", required=true)
  protected MServer mServer;

  @XmlElement(name="MUser", required=true)
  protected MUser mUser;

  @XmlElement(name="PEPSVersion", required=true)
  protected PEPSVersion pepsVersion;

  public Time getTime()
  {
    return this.time;
  }

  public void setTime(Time paramTime)
  {
    this.time = paramTime;
  }

  public boolean isSetTime()
  {
    return this.time != null;
  }

  public MServer getMServer()
  {
    return this.mServer;
  }

  public void setMServer(MServer paramMServer)
  {
    this.mServer = paramMServer;
  }

  public boolean isSetMServer()
  {
    return this.mServer != null;
  }

  public MUser getMUser()
  {
    return this.mUser;
  }

  public void setMUser(MUser paramMUser)
  {
    this.mUser = paramMUser;
  }

  public boolean isSetMUser()
  {
    return this.mUser != null;
  }

  public PEPSVersion getPEPSVersion()
  {
    return this.pepsVersion;
  }

  public void setPEPSVersion(PEPSVersion paramPEPSVersion)
  {
    this.pepsVersion = paramPEPSVersion;
  }

  public boolean isSetPEPSVersion()
  {
    return this.pepsVersion != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.Header
 * JD-Core Version:    0.6.2
 */