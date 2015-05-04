package gov.va.med.pharmacy.peps.common.vo;

import java.util.Date;
import java.util.TimeZone;

public class SiteUpdateReportVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Long siteId;
  private String siteName;
  private String regionName;
  private boolean isSuccessful;
  private String message;
  private Date lastUpdateTime;
  private TimeZone lastUpdateTimeZone;
  private String fdbSessionDate;
  private Long fdbId;
  private Long id;
  private String fdbCustomSessionDate;
  private String fdbCustomMessage;
  private boolean isFdbCustomSuccessful;
  private Long fdbCustomId;
  private Date customLastUpdateTime;
  private TimeZone customLastUpdateTimeZone;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }

  public Long getSiteId()
  {
    return this.siteId;
  }

  public void setSiteId(Long paramLong)
  {
    this.siteId = paramLong;
  }

  public String getSiteName()
  {
    return this.siteName;
  }

  public void setSiteName(String paramString)
  {
    if (paramString != null)
      paramString = paramString.replaceAll("(-|\\(|,).*", "").trim();
    this.siteName = paramString;
  }

  public String getRegionName()
  {
    return this.regionName;
  }

  public void setRegionName(String paramString)
  {
    this.regionName = paramString;
  }

  public boolean isFdbSuccessful()
  {
    return this.isSuccessful;
  }

  public void setFdbSuccessful(boolean paramBoolean)
  {
    this.isSuccessful = paramBoolean;
  }

  public String getFdbMessage()
  {
    return this.message;
  }

  public void setFdbMessage(String paramString)
  {
    this.message = paramString;
  }

  public Date getFdbLastUpdateTime()
  {
    return this.lastUpdateTime;
  }

  public void setFdbLastUpdateTime(Date paramDate)
  {
    this.lastUpdateTime = paramDate;
  }

  public TimeZone getFdbLastUpdateTimeZone()
  {
    return this.lastUpdateTimeZone;
  }

  public void setFdbLastUpdateTimeZone(TimeZone paramTimeZone)
  {
    this.lastUpdateTimeZone = paramTimeZone;
  }

  public String getFdbSessionDate()
  {
    return this.fdbSessionDate;
  }

  public void setFdbSessionDate(String paramString)
  {
    this.fdbSessionDate = paramString;
  }

  public Long getFdbId()
  {
    return this.fdbId;
  }

  public void setFdbId(Long paramLong)
  {
    this.fdbId = paramLong;
  }

  public String getFdbCustomSessionDate()
  {
    return this.fdbCustomSessionDate;
  }

  public void setFdbCustomSessionDate(String paramString)
  {
    this.fdbCustomSessionDate = paramString;
  }

  public String getFdbCustomMessage()
  {
    return this.fdbCustomMessage;
  }

  public void setFdbCustomMessage(String paramString)
  {
    this.fdbCustomMessage = paramString;
  }

  public boolean isFdbCustomSuccessful()
  {
    return this.isFdbCustomSuccessful;
  }

  public void setFdbCustomSuccessful(boolean paramBoolean)
  {
    this.isFdbCustomSuccessful = paramBoolean;
  }

  public Long getFdbCustomId()
  {
    return this.fdbCustomId;
  }

  public void setFdbCustomId(Long paramLong)
  {
    this.fdbCustomId = paramLong;
  }

  public Date getFdbCustomLastUpdateTime()
  {
    return this.customLastUpdateTime;
  }

  public void setFdbCustomLastUpdateTime(Date paramDate)
  {
    this.customLastUpdateTime = paramDate;
  }

  public TimeZone getFdbCustomLastUpdateTimeZone()
  {
    return this.customLastUpdateTimeZone;
  }

  public void setFdbCustomLastUpdateTimeZone(TimeZone paramTimeZone)
  {
    this.customLastUpdateTimeZone = paramTimeZone;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.SiteUpdateReportVo
 * JD-Core Version:    0.6.2
 */