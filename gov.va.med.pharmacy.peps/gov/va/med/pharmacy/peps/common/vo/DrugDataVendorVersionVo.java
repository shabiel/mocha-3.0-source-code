package gov.va.med.pharmacy.peps.common.vo;

public class DrugDataVendorVersionVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private String buildVersion = "";
  private String dataVersion = "";
  private String issueDate = "";
  private String customBuildVersion = "";
  private String customDataVersion = "";
  private String customIssueDate = "";

  public final String getBuildVersion()
  {
    return this.buildVersion;
  }

  public final void setBuildVersion(String paramString)
  {
    this.buildVersion = paramString;
  }

  public final String getDataVersion()
  {
    return this.dataVersion;
  }

  public final void setDataVersion(String paramString)
  {
    this.dataVersion = paramString;
  }

  public final String getIssueDate()
  {
    return this.issueDate;
  }

  public final void setIssueDate(String paramString)
  {
    this.issueDate = paramString;
  }

  public final String getCustomBuildVersion()
  {
    return this.customBuildVersion;
  }

  public final void setCustomBuildVersion(String paramString)
  {
    this.customBuildVersion = paramString;
  }

  public final String getCustomDataVersion()
  {
    return this.customDataVersion;
  }

  public final void setCustomDataVersion(String paramString)
  {
    this.customDataVersion = paramString;
  }

  public final String getCustomIssueDate()
  {
    return this.customIssueDate;
  }

  public final void setCustomIssueDate(String paramString)
  {
    this.customIssueDate = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DrugDataVendorVersionVo
 * JD-Core Version:    0.6.2
 */