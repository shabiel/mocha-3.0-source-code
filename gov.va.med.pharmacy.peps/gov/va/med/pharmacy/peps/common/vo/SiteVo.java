package gov.va.med.pharmacy.peps.common.vo;

public class SiteVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Long id;
  private String name;
  private String shortName;
  private String visn;

  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }

  public Long getId()
  {
    return this.id;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public String getName()
  {
    return this.name;
  }

  public void setVisn(String paramString)
  {
    this.visn = paramString;
  }

  public String getVisn()
  {
    return this.visn;
  }

  public void setShortName(String paramString)
  {
    if (paramString != null)
      paramString = paramString.replaceAll("(-|\\().*", "");
    this.shortName = paramString;
  }

  public String getShortName()
  {
    return this.shortName;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.SiteVo
 * JD-Core Version:    0.6.2
 */