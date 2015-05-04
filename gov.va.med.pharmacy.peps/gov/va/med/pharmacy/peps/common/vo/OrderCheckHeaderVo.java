package gov.va.med.pharmacy.peps.common.vo;

import java.math.BigInteger;

public class OrderCheckHeaderVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private String time = "";
  private BigInteger jobNumber = new BigInteger("0");
  private BigInteger duz = new BigInteger("0");
  private String userName = "";
  private BigInteger stationNumber = new BigInteger("0");
  private String serverName = "";
  private String ip = "";
  private String uci = "";
  private String namespace = "";
  private boolean pingOnly;

  public BigInteger getDuz()
  {
    return this.duz;
  }

  public void setDuz(BigInteger paramBigInteger)
  {
    this.duz = paramBigInteger;
  }

  public String getIp()
  {
    return this.ip;
  }

  public void setIp(String paramString)
  {
    this.ip = paramString;
  }

  public BigInteger getJobNumber()
  {
    return this.jobNumber;
  }

  public void setJobNumber(BigInteger paramBigInteger)
  {
    this.jobNumber = paramBigInteger;
  }

  public String getNamespace()
  {
    return this.namespace;
  }

  public void setNamespace(String paramString)
  {
    this.namespace = paramString;
  }

  public String getServerName()
  {
    return this.serverName;
  }

  public void setServerName(String paramString)
  {
    this.serverName = paramString;
  }

  public BigInteger getStationNumber()
  {
    return this.stationNumber;
  }

  public void setStationNumber(BigInteger paramBigInteger)
  {
    this.stationNumber = paramBigInteger;
  }

  public String getTime()
  {
    return this.time;
  }

  public void setTime(String paramString)
  {
    this.time = paramString;
  }

  public String getUci()
  {
    return this.uci;
  }

  public void setUci(String paramString)
  {
    this.uci = paramString;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }

  public boolean isPingOnly()
  {
    return this.pingOnly;
  }

  public void setPingOnly(boolean paramBoolean)
  {
    this.pingOnly = paramBoolean;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.OrderCheckHeaderVo
 * JD-Core Version:    0.6.2
 */