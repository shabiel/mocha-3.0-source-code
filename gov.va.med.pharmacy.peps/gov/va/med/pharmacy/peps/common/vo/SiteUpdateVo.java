package gov.va.med.pharmacy.peps.common.vo;

import java.util.Date;
import java.util.TimeZone;

public class SiteUpdateVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private String[] siteId;
  private String regionName;
  private boolean isSuccessful;
  private boolean isCustom;
  private String message;
  private Date lastUpdateTime;
  private TimeZone lastUpdateTimeZone;
  private String fdbDatabaseVersion;
  private String fdbSessionDate;

  public String[] getSiteId()
  {
    return this.siteId;
  }

  public void setSiteId(String[] paramArrayOfString)
  {
    this.siteId = paramArrayOfString;
  }

  public boolean getIsSuccessful()
  {
    return this.isSuccessful;
  }

  public void setIsSuccessful(boolean paramBoolean)
  {
    this.isSuccessful = paramBoolean;
  }

  public String getMessage()
  {
    return this.message;
  }

  public void setMessage(String paramString)
  {
    this.message = paramString;
  }

  public Date getLastUpdateTime()
  {
    return this.lastUpdateTime;
  }

  public void setLastUpdateTime(Date paramDate)
  {
    this.lastUpdateTime = paramDate;
  }

  public TimeZone getLastUpdateTimeZone()
  {
    return this.lastUpdateTimeZone;
  }

  public void setLastUpdateTimeZone(TimeZone paramTimeZone)
  {
    this.lastUpdateTimeZone = paramTimeZone;
  }

  public boolean getIsCustom()
  {
    return this.isCustom;
  }

  public void setIsCustom(boolean paramBoolean)
  {
    this.isCustom = paramBoolean;
  }

  public String getFdbDatabaseVersion()
  {
    return this.fdbDatabaseVersion;
  }

  public void setFdbDatabaseVersion(String paramString)
  {
    this.fdbDatabaseVersion = paramString;
  }

  public String getRegionName()
  {
    return this.regionName;
  }

  public void setRegionName(String paramString)
  {
    this.regionName = paramString;
  }

  public void setFdbSessionDate(String paramString)
  {
    this.fdbSessionDate = paramString;
  }

  public String getFdbSessionDate()
  {
    return this.fdbSessionDate;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.SiteUpdateVo
 * JD-Core Version:    0.6.2
 */