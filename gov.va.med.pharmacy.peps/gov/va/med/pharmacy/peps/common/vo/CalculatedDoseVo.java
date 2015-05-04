package gov.va.med.pharmacy.peps.common.vo;

public final class CalculatedDoseVo extends ValueObject
{
  private static final long serialVersionUID = 1633076460383974914L;
  private String databaseValue;
  private String doseValue;
  private String percentError;
  private String unitOfMeasure;

  public String getDatabaseValue()
  {
    return this.databaseValue;
  }

  public void setDatabaseValue(String paramString)
  {
    this.databaseValue = paramString;
  }

  public String getDoseValue()
  {
    return this.doseValue;
  }

  public void setDoseValue(String paramString)
  {
    this.doseValue = paramString;
  }

  public String getPercentError()
  {
    return this.percentError;
  }

  public void setPercentError(String paramString)
  {
    this.percentError = paramString;
  }

  public String getUnitOfMeasure()
  {
    return this.unitOfMeasure;
  }

  public void setUnitOfMeasure(String paramString)
  {
    this.unitOfMeasure = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.CalculatedDoseVo
 * JD-Core Version:    0.6.2
 */