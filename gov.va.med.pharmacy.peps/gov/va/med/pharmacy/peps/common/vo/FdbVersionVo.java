package gov.va.med.pharmacy.peps.common.vo;

import java.util.Date;

public class FdbVersionVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private long fdbId;
  private boolean isCustom;
  private String fdbSessionDate;
  private Date when;

  public long getFdbId()
  {
    return this.fdbId;
  }

  public void setFdbId(long paramLong)
  {
    this.fdbId = paramLong;
  }

  public String getFdbSessionDate()
  {
    return this.fdbSessionDate;
  }

  public void setFdbSessionDate(String paramString)
  {
    this.fdbSessionDate = paramString;
  }

  public boolean getIsCustom()
  {
    return this.isCustom;
  }

  public void setIsCustom(boolean paramBoolean)
  {
    this.isCustom = paramBoolean;
  }

  public Date getWhen()
  {
    return this.when;
  }

  public void setWhen(Date paramDate)
  {
    this.when = paramDate;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.FdbVersionVo
 * JD-Core Version:    0.6.2
 */