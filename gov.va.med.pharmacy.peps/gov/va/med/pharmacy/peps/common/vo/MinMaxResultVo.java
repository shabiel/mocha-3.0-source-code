package gov.va.med.pharmacy.peps.common.vo;

import firstdatabank.dif.FDBMinMaxType;

public class MinMaxResultVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Long ageInDaysHigh;
  private Long ageInDaysLow;
  private Boolean bsaRequired;
  private Double doseFormHigh;
  private String doseFormHighUnit;
  private Double doseFormLow;
  private String doseFormLowUnit;
  private Double doseHigh;
  private String doseHighUnit;
  private Double doseLow;
  private String doseLowUnit;
  private Double maxDailyDose;
  private Double maxDailyDoseForm;
  private String maxDailyDoseFormUnit;
  private String maxDailyDoseUnit;
  private FDBMinMaxType resultType;
  private Integer warningCode;
  private String warningMessage;
  private Boolean weightRequired;

  public Long getAgeInDaysHigh()
  {
    return this.ageInDaysHigh;
  }

  public void setAgeInDaysHigh(Long paramLong)
  {
    this.ageInDaysHigh = paramLong;
  }

  public Long getAgeInDaysLow()
  {
    return this.ageInDaysLow;
  }

  public void setAgeInDaysLow(Long paramLong)
  {
    this.ageInDaysLow = paramLong;
  }

  public Boolean getBsaRequired()
  {
    return this.bsaRequired;
  }

  public void setBsaRequired(Boolean paramBoolean)
  {
    this.bsaRequired = paramBoolean;
  }

  public Double getDoseFormHigh()
  {
    return this.doseFormHigh;
  }

  public void setDoseFormHigh(Double paramDouble)
  {
    this.doseFormHigh = paramDouble;
  }

  public String getDoseFormHighUnit()
  {
    return this.doseFormHighUnit;
  }

  public void setDoseFormHighUnit(String paramString)
  {
    this.doseFormHighUnit = paramString;
  }

  public Double getDoseFormLow()
  {
    return this.doseFormLow;
  }

  public void setDoseFormLow(Double paramDouble)
  {
    this.doseFormLow = paramDouble;
  }

  public String getDoseFormLowUnit()
  {
    return this.doseFormLowUnit;
  }

  public void setDoseFormLowUnit(String paramString)
  {
    this.doseFormLowUnit = paramString;
  }

  public Double getDoseHigh()
  {
    return this.doseHigh;
  }

  public void setDoseHigh(Double paramDouble)
  {
    this.doseHigh = paramDouble;
  }

  public String getDoseHighUnit()
  {
    return this.doseHighUnit;
  }

  public void setDoseHighUnit(String paramString)
  {
    this.doseHighUnit = paramString;
  }

  public Double getDoseLow()
  {
    return this.doseLow;
  }

  public void setDoseLow(Double paramDouble)
  {
    this.doseLow = paramDouble;
  }

  public String getDoseLowUnit()
  {
    return this.doseLowUnit;
  }

  public void setDoseLowUnit(String paramString)
  {
    this.doseLowUnit = paramString;
  }

  public Double getMaxDailyDose()
  {
    return this.maxDailyDose;
  }

  public void setMaxDailyDose(Double paramDouble)
  {
    this.maxDailyDose = paramDouble;
  }

  public Double getMaxDailyDoseForm()
  {
    return this.maxDailyDoseForm;
  }

  public void setMaxDailyDoseForm(Double paramDouble)
  {
    this.maxDailyDoseForm = paramDouble;
  }

  public String getMaxDailyDoseFormUnit()
  {
    return this.maxDailyDoseFormUnit;
  }

  public void setMaxDailyDoseFormUnit(String paramString)
  {
    this.maxDailyDoseFormUnit = paramString;
  }

  public String getMaxDailyDoseUnit()
  {
    return this.maxDailyDoseUnit;
  }

  public void setMaxDailyDoseUnit(String paramString)
  {
    this.maxDailyDoseUnit = paramString;
  }

  public FDBMinMaxType getResultType()
  {
    return this.resultType;
  }

  public void setResultType(FDBMinMaxType paramFDBMinMaxType)
  {
    this.resultType = paramFDBMinMaxType;
  }

  public Integer getWarningCode()
  {
    return this.warningCode;
  }

  public void setWarningCode(Integer paramInteger)
  {
    this.warningCode = paramInteger;
  }

  public String getWarningMessage()
  {
    return this.warningMessage;
  }

  public void setWarningMessage(String paramString)
  {
    this.warningMessage = paramString;
  }

  public Boolean getWeightRequired()
  {
    return this.weightRequired;
  }

  public void setWeightRequired(Boolean paramBoolean)
  {
    this.weightRequired = paramBoolean;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.MinMaxResultVo
 * JD-Core Version:    0.6.2
 */