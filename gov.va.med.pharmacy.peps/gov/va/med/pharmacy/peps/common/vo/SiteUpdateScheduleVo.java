package gov.va.med.pharmacy.peps.common.vo;

import java.util.Date;

public class SiteUpdateScheduleVo extends ValueObject
{
  public static final String PEPS = "PEPS";
  public static final String COTS = "COTS";
  public static final String VISTA = "VISTA";
  private static final long serialVersionUID = 1L;
  private Long id;
  private String siteNumber;
  private String softwareUpdateType;
  private String softwareUpdateVersion;
  private String inProgress;
  private Date startDtm;
  private Date endDtm;
  private Date scheduleStartDtm;
  private String scheduleInterval;
  private String md5Sum;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }

  public String getSiteNumber()
  {
    return this.siteNumber;
  }

  public void setSiteNumber(String paramString)
  {
    this.siteNumber = paramString;
  }

  public String getSoftwareUpdateType()
  {
    return this.softwareUpdateType;
  }

  public void setSoftwareUpdateType(String paramString)
  {
    this.softwareUpdateType = paramString;
  }

  public String getSoftwareUpdateVersion()
  {
    return this.softwareUpdateVersion;
  }

  public void setSoftwareUpdateVersion(String paramString)
  {
    this.softwareUpdateVersion = paramString;
  }

  public Date getScheduleStartDtm()
  {
    return this.scheduleStartDtm;
  }

  public void setScheduleStartDtm(Date paramDate)
  {
    this.scheduleStartDtm = paramDate;
  }

  public String getScheduleInterval()
  {
    return this.scheduleInterval;
  }

  public void setScheduleInterval(String paramString)
  {
    this.scheduleInterval = paramString;
  }

  public String getInProgress()
  {
    return this.inProgress;
  }

  public void setInProgress(String paramString)
  {
    this.inProgress = paramString;
  }

  public Date getStartDtm()
  {
    return this.startDtm;
  }

  public void setStartDtm(Date paramDate)
  {
    this.startDtm = paramDate;
  }

  public Date getEndDtm()
  {
    return this.endDtm;
  }

  public void setEndDtm(Date paramDate)
  {
    this.endDtm = paramDate;
  }

  public String getMd5Sum()
  {
    return this.md5Sum;
  }

  public void setMd5Sum(String paramString)
  {
    this.md5Sum = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.SiteUpdateScheduleVo
 * JD-Core Version:    0.6.2
 */