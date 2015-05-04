package gov.va.med.pharmacy.peps.common.vo;

public final class DrugDoseCheckResultVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private DrugCheckVo drug;
  private String singleDoseStatus = "";
  private String singleDoseStatusCode = "";
  private String singleDoseMessage = "";
  private String singleDoseMax = "";
  private String rangeDoseStatus = "";
  private String rangeDoseStatusCode = "";
  private String rangeDoseMessage = "";
  private String rangeDoseLow = "";
  private String rangeDoseHigh = "";
  private String durationStatus = "";
  private String durationStatusCode = "";
  private String durationMessage = "";
  private String frequencyStatus = "";
  private String frequencyStatusCode = "";
  private String frequencyMessage = "";
  private String dailyDoseStatus = "";
  private String dailyDoseStatusCode = "";
  private String dailyDoseMessage = "";
  private String maxDailyDoseStatus = "";
  private String maxDailyDoseStatusCode = "";
  private String maxDailyDoseMessage = "";
  private String maxLifetimeDose = "";
  private String doseLow = "";
  private String doseLowUnit = "";
  private String doseHigh = "";
  private String doseHighUnit = "";
  private String doseRouteDescription = "";
  private String doseFormLow = "";
  private String doseFormLowUnit = "";
  private String doseFormHigh = "";
  private String doseFormHighUnit = "";
  private String doseFrequencyHigh = "";
  private String doseFrequencyLow = "";
  private String maxDailyDose = "";
  private String maxDailyDoseUnit = "";
  private String maxDailyDoseForm = "";
  private String maxDailyDoseFormUnit = "";
  private boolean chemoInjectable = false;
  private boolean custom;
  private String maxSingleNTEDose = "";
  private String maxSingleNTEDoseUnit = "";
  private String maxSingleNTEDoseForm = "";
  private String maxSingleNTEDoseFormUnit = "";
  private String maxLifetimeOrderMessage = "";
  private String maxLifetimeOrderStatus = "";
  private String maxLifetimeOrderStatusCode = "";
  private CalculatedDoseVo daily;
  private CalculatedDoseVo maxDaily;
  private CalculatedDoseVo rangeLow;
  private CalculatedDoseVo rangeHigh;
  private CalculatedDoseVo maxLifetime;
  private CalculatedDoseVo maxLifetimeOrder;
  private CalculatedDoseVo single;

  public DrugCheckVo getDrug()
  {
    return this.drug;
  }

  public void setDrug(DrugCheckVo paramDrugCheckVo)
  {
    this.drug = paramDrugCheckVo;
  }

  public String getSingleDoseStatus()
  {
    return this.singleDoseStatus;
  }

  public void setSingleDoseStatus(String paramString)
  {
    this.singleDoseStatus = paramString;
  }

  public String getSingleDoseStatusCode()
  {
    return this.singleDoseStatusCode;
  }

  public void setSingleDoseStatusCode(String paramString)
  {
    this.singleDoseStatusCode = paramString;
  }

  public String getSingleDoseMessage()
  {
    return this.singleDoseMessage;
  }

  public void setSingleDoseMessage(String paramString)
  {
    this.singleDoseMessage = paramString;
  }

  public String getSingleDoseMax()
  {
    return this.singleDoseMax;
  }

  public void setSingleDoseMax(String paramString)
  {
    this.singleDoseMax = paramString;
  }

  public String getRangeDoseStatus()
  {
    return this.rangeDoseStatus;
  }

  public void setRangeDoseStatus(String paramString)
  {
    this.rangeDoseStatus = paramString;
  }

  public String getRangeDoseStatusCode()
  {
    return this.rangeDoseStatusCode;
  }

  public void setRangeDoseStatusCode(String paramString)
  {
    this.rangeDoseStatusCode = paramString;
  }

  public String getRangeDoseMessage()
  {
    return this.rangeDoseMessage;
  }

  public void setRangeDoseMessage(String paramString)
  {
    this.rangeDoseMessage = paramString;
  }

  public String getRangeDoseLow()
  {
    return this.rangeDoseLow;
  }

  public void setRangeDoseLow(String paramString)
  {
    this.rangeDoseLow = paramString;
  }

  public String getRangeDoseHigh()
  {
    return this.rangeDoseHigh;
  }

  public void setRangeDoseHigh(String paramString)
  {
    this.rangeDoseHigh = paramString;
  }

  public String getDurationStatus()
  {
    return this.durationStatus;
  }

  public void setDurationStatus(String paramString)
  {
    this.durationStatus = paramString;
  }

  public String getDurationStatusCode()
  {
    return this.durationStatusCode;
  }

  public void setDurationStatusCode(String paramString)
  {
    this.durationStatusCode = paramString;
  }

  public String getDurationMessage()
  {
    return this.durationMessage;
  }

  public void setDurationMessage(String paramString)
  {
    this.durationMessage = paramString;
  }

  public String getFrequencyStatus()
  {
    return this.frequencyStatus;
  }

  public void setFrequencyStatus(String paramString)
  {
    this.frequencyStatus = paramString;
  }

  public String getFrequencyStatusCode()
  {
    return this.frequencyStatusCode;
  }

  public void setFrequencyStatusCode(String paramString)
  {
    this.frequencyStatusCode = paramString;
  }

  public String getFrequencyMessage()
  {
    return this.frequencyMessage;
  }

  public void setFrequencyMessage(String paramString)
  {
    this.frequencyMessage = paramString;
  }

  public String getDailyDoseStatus()
  {
    return this.dailyDoseStatus;
  }

  public void setDailyDoseStatus(String paramString)
  {
    this.dailyDoseStatus = paramString;
  }

  public String getDailyDoseStatusCode()
  {
    return this.dailyDoseStatusCode;
  }

  public void setDailyDoseStatusCode(String paramString)
  {
    this.dailyDoseStatusCode = paramString;
  }

  public String getDailyDoseMessage()
  {
    return this.dailyDoseMessage;
  }

  public void setDailyDoseMessage(String paramString)
  {
    this.dailyDoseMessage = paramString;
  }

  public String getMaxDailyDoseStatus()
  {
    return this.maxDailyDoseStatus;
  }

  public void setMaxDailyDoseStatus(String paramString)
  {
    this.maxDailyDoseStatus = paramString;
  }

  public String getMaxDailyDoseStatusCode()
  {
    return this.maxDailyDoseStatusCode;
  }

  public void setMaxDailyDoseStatusCode(String paramString)
  {
    this.maxDailyDoseStatusCode = paramString;
  }

  public String getMaxDailyDoseMessage()
  {
    return this.maxDailyDoseMessage;
  }

  public void setMaxDailyDoseMessage(String paramString)
  {
    this.maxDailyDoseMessage = paramString;
  }

  public String getMaxLifetimeDose()
  {
    return this.maxLifetimeDose;
  }

  public void setMaxLifetimeDose(String paramString)
  {
    this.maxLifetimeDose = paramString;
  }

  public String getDoseLow()
  {
    return this.doseLow;
  }

  public void setDoseLow(String paramString)
  {
    this.doseLow = paramString;
  }

  public String getDoseLowUnit()
  {
    return this.doseLowUnit;
  }

  public void setDoseLowUnit(String paramString)
  {
    this.doseLowUnit = paramString;
  }

  public String getDoseHigh()
  {
    return this.doseHigh;
  }

  public void setDoseHigh(String paramString)
  {
    this.doseHigh = paramString;
  }

  public String getDoseHighUnit()
  {
    return this.doseHighUnit;
  }

  public void setDoseHighUnit(String paramString)
  {
    this.doseHighUnit = paramString;
  }

  public String getDoseRouteDescription()
  {
    return this.doseRouteDescription;
  }

  public void setDoseRouteDescription(String paramString)
  {
    this.doseRouteDescription = paramString;
  }

  public String getDoseFormLow()
  {
    return this.doseFormLow;
  }

  public void setDoseFormLow(String paramString)
  {
    this.doseFormLow = paramString;
  }

  public String getDoseFormLowUnit()
  {
    return this.doseFormLowUnit;
  }

  public void setDoseFormLowUnit(String paramString)
  {
    this.doseFormLowUnit = paramString;
  }

  public String getDoseFormHigh()
  {
    return this.doseFormHigh;
  }

  public void setDoseFormHigh(String paramString)
  {
    this.doseFormHigh = paramString;
  }

  public String getDoseFormHighUnit()
  {
    return this.doseFormHighUnit;
  }

  public void setDoseFormHighUnit(String paramString)
  {
    this.doseFormHighUnit = paramString;
  }

  public String getDoseFrequencyHigh()
  {
    return this.doseFrequencyHigh;
  }

  public void setDoseFrequencyHigh(String paramString)
  {
    this.doseFrequencyHigh = paramString;
  }

  public String getDoseFrequencyLow()
  {
    return this.doseFrequencyLow;
  }

  public void setDoseFrequencyLow(String paramString)
  {
    this.doseFrequencyLow = paramString;
  }

  public boolean isChemoInjectable()
  {
    return this.chemoInjectable;
  }

  public void setChemoInjectable(boolean paramBoolean)
  {
    this.chemoInjectable = paramBoolean;
  }

  public boolean isCustom()
  {
    return this.custom;
  }

  public void setCustom(boolean paramBoolean)
  {
    this.custom = paramBoolean;
  }

  public String getMaxSingleNTEDose()
  {
    return this.maxSingleNTEDose;
  }

  public void setMaxSingleNTEDose(String paramString)
  {
    this.maxSingleNTEDose = paramString;
  }

  public String getMaxSingleNTEDoseUnit()
  {
    return this.maxSingleNTEDoseUnit;
  }

  public void setMaxSingleNTEDoseUnit(String paramString)
  {
    this.maxSingleNTEDoseUnit = paramString;
  }

  public String getMaxSingleNTEDoseForm()
  {
    return this.maxSingleNTEDoseForm;
  }

  public void setMaxSingleNTEDoseForm(String paramString)
  {
    this.maxSingleNTEDoseForm = paramString;
  }

  public String getMaxSingleNTEDoseFormUnit()
  {
    return this.maxSingleNTEDoseFormUnit;
  }

  public void setMaxSingleNTEDoseFormUnit(String paramString)
  {
    this.maxSingleNTEDoseFormUnit = paramString;
  }

  public String getMaxLifetimeOrderMessage()
  {
    return this.maxLifetimeOrderMessage;
  }

  public void setMaxLifetimeOrderMessage(String paramString)
  {
    this.maxLifetimeOrderMessage = paramString;
  }

  public String getMaxLifetimeOrderStatus()
  {
    return this.maxLifetimeOrderStatus;
  }

  public void setMaxLifetimeOrderStatus(String paramString)
  {
    this.maxLifetimeOrderStatus = paramString;
  }

  public String getMaxLifetimeOrderStatusCode()
  {
    return this.maxLifetimeOrderStatusCode;
  }

  public void setMaxLifetimeOrderStatusCode(String paramString)
  {
    this.maxLifetimeOrderStatusCode = paramString;
  }

  public CalculatedDoseVo getDaily()
  {
    return this.daily;
  }

  public void setDaily(CalculatedDoseVo paramCalculatedDoseVo)
  {
    this.daily = paramCalculatedDoseVo;
  }

  public CalculatedDoseVo getMaxDaily()
  {
    return this.maxDaily;
  }

  public void setMaxDaily(CalculatedDoseVo paramCalculatedDoseVo)
  {
    this.maxDaily = paramCalculatedDoseVo;
  }

  public CalculatedDoseVo getRangeLow()
  {
    return this.rangeLow;
  }

  public void setRangeLow(CalculatedDoseVo paramCalculatedDoseVo)
  {
    this.rangeLow = paramCalculatedDoseVo;
  }

  public CalculatedDoseVo getRangeHigh()
  {
    return this.rangeHigh;
  }

  public void setRangeHigh(CalculatedDoseVo paramCalculatedDoseVo)
  {
    this.rangeHigh = paramCalculatedDoseVo;
  }

  public CalculatedDoseVo getMaxLifetime()
  {
    return this.maxLifetime;
  }

  public void setMaxLifetime(CalculatedDoseVo paramCalculatedDoseVo)
  {
    this.maxLifetime = paramCalculatedDoseVo;
  }

  public CalculatedDoseVo getMaxLifetimeOrder()
  {
    return this.maxLifetimeOrder;
  }

  public void setMaxLifetimeOrder(CalculatedDoseVo paramCalculatedDoseVo)
  {
    this.maxLifetimeOrder = paramCalculatedDoseVo;
  }

  public CalculatedDoseVo getSingle()
  {
    return this.single;
  }

  public void setSingle(CalculatedDoseVo paramCalculatedDoseVo)
  {
    this.single = paramCalculatedDoseVo;
  }

  public String getMaxDailyDose()
  {
    return this.maxDailyDose;
  }

  public void setMaxDailyDose(String paramString)
  {
    this.maxDailyDose = paramString;
  }

  public String getMaxDailyDoseUnit()
  {
    return this.maxDailyDoseUnit;
  }

  public void setMaxDailyDoseUnit(String paramString)
  {
    this.maxDailyDoseUnit = paramString;
  }

  public String getMaxDailyDoseForm()
  {
    return this.maxDailyDoseForm;
  }

  public void setMaxDailyDoseForm(String paramString)
  {
    this.maxDailyDoseForm = paramString;
  }

  public String getMaxDailyDoseFormUnit()
  {
    return this.maxDailyDoseFormUnit;
  }

  public void setMaxDailyDoseFormUnit(String paramString)
  {
    this.maxDailyDoseFormUnit = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DrugDoseCheckResultVo
 * JD-Core Version:    0.6.2
 */