package gov.va.med.pharmacy.peps.common.vo;

import firstdatabank.dif.FDBMedicalConditionType;
import firstdatabank.dif.IString;

public final class DoseRangeResultVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Boolean custom;
  private Long ageHighInDays;
  private Long ageLowInDays;
  private Boolean bsaRequired;
  private String halfLifeUnit;
  private String category;
  private Boolean hepaticImpairment;
  private Double highEliminationHalfLife;
  private Double lowEliminationHalfLife;
  private Long maxDuration;
  private Boolean renalImpairment;
  private Boolean weightRequired;
  private String doseRouteDescription;
  private String doseRouteId;
  private IString intlDoseRouteDescription;
  private String doseTypeDescription;
  private String doseTypeId;
  private IString intlDoseTypeDescription;
  private IntegerUnitVo crclThreshold;
  private DecimalUnitVo doseFormHigh;
  private DecimalUnitVo doseFormLow;
  private DecimalUnitVo doseHigh;
  private DecimalUnitVo doseLow;
  private DecimalUnitVo maxDailyDose;
  private DecimalUnitVo maxDailyDoseForm;
  private DecimalUnitVo maxLifetimeDose;
  private DecimalUnitVo maxLifetimeDoseForm;
  private DecimalUnitVo maxSingleDose;
  private DecimalUnitVo maxSingleDoseForm;
  private Long durationHigh;
  private Long durationLow;
  private Double frequencyHigh;
  private Double frequencyLow;
  private String hitIndicationDescription;
  private Integer hitIndicationId;
  private IString intlHitIndicationDescription;
  private String indicationDescription;
  private String indicationId;
  private FDBMedicalConditionType indicationIdType;
  private DecimalUnitVo maxSingleNTEDose;
  private DecimalUnitVo maxSingleNTEDoseForm;

  public Boolean getCustom()
  {
    return this.custom;
  }

  public void setCustom(Boolean paramBoolean)
  {
    this.custom = paramBoolean;
  }

  public Long getAgeHighInDays()
  {
    return this.ageHighInDays;
  }

  public void setAgeHighInDays(Long paramLong)
  {
    this.ageHighInDays = paramLong;
  }

  public Long getAgeLowInDays()
  {
    return this.ageLowInDays;
  }

  public void setAgeLowInDays(Long paramLong)
  {
    this.ageLowInDays = paramLong;
  }

  public Boolean getBsaRequired()
  {
    return this.bsaRequired;
  }

  public void setBsaRequired(Boolean paramBoolean)
  {
    this.bsaRequired = paramBoolean;
  }

  public String getHalfLifeUnit()
  {
    return this.halfLifeUnit;
  }

  public void setHalfLifeUnit(String paramString)
  {
    this.halfLifeUnit = paramString;
  }

  public String getCategory()
  {
    return this.category;
  }

  public void setCategory(String paramString)
  {
    this.category = paramString;
  }

  public Boolean getHepaticImpairment()
  {
    return this.hepaticImpairment;
  }

  public void setHepaticImpairment(Boolean paramBoolean)
  {
    this.hepaticImpairment = paramBoolean;
  }

  public Double getHighEliminationHalfLife()
  {
    return this.highEliminationHalfLife;
  }

  public void setHighEliminationHalfLife(Double paramDouble)
  {
    this.highEliminationHalfLife = paramDouble;
  }

  public Double getLowEliminationHalfLife()
  {
    return this.lowEliminationHalfLife;
  }

  public void setLowEliminationHalfLife(Double paramDouble)
  {
    this.lowEliminationHalfLife = paramDouble;
  }

  public Long getMaxDuration()
  {
    return this.maxDuration;
  }

  public void setMaxDuration(Long paramLong)
  {
    this.maxDuration = paramLong;
  }

  public Boolean getRenalImpairment()
  {
    return this.renalImpairment;
  }

  public void setRenalImpairment(Boolean paramBoolean)
  {
    this.renalImpairment = paramBoolean;
  }

  public Boolean getWeightRequired()
  {
    return this.weightRequired;
  }

  public void setWeightRequired(Boolean paramBoolean)
  {
    this.weightRequired = paramBoolean;
  }

  public String getDoseRouteDescription()
  {
    return this.doseRouteDescription;
  }

  public void setDoseRouteDescription(String paramString)
  {
    this.doseRouteDescription = paramString;
  }

  public String getDoseRouteId()
  {
    return this.doseRouteId;
  }

  public void setDoseRouteId(String paramString)
  {
    this.doseRouteId = paramString;
  }

  public IString getIntlDoseRouteDescription()
  {
    return this.intlDoseRouteDescription;
  }

  public void setIntlDoseRouteDescription(IString paramIString)
  {
    this.intlDoseRouteDescription = paramIString;
  }

  public String getDoseTypeDescription()
  {
    return this.doseTypeDescription;
  }

  public void setDoseTypeDescription(String paramString)
  {
    this.doseTypeDescription = paramString;
  }

  public String getDoseTypeId()
  {
    return this.doseTypeId;
  }

  public void setDoseTypeId(String paramString)
  {
    this.doseTypeId = paramString;
  }

  public IString getIntlDoseTypeDescription()
  {
    return this.intlDoseTypeDescription;
  }

  public void setIntlDoseTypeDescription(IString paramIString)
  {
    this.intlDoseTypeDescription = paramIString;
  }

  public IntegerUnitVo getCrclThreshold()
  {
    return this.crclThreshold;
  }

  public void setCrclThreshold(IntegerUnitVo paramIntegerUnitVo)
  {
    this.crclThreshold = paramIntegerUnitVo;
  }

  public DecimalUnitVo getDoseFormHigh()
  {
    return this.doseFormHigh;
  }

  public void setDoseFormHigh(DecimalUnitVo paramDecimalUnitVo)
  {
    this.doseFormHigh = paramDecimalUnitVo;
  }

  public DecimalUnitVo getDoseFormLow()
  {
    return this.doseFormLow;
  }

  public void setDoseFormLow(DecimalUnitVo paramDecimalUnitVo)
  {
    this.doseFormLow = paramDecimalUnitVo;
  }

  public DecimalUnitVo getDoseHigh()
  {
    return this.doseHigh;
  }

  public void setDoseHigh(DecimalUnitVo paramDecimalUnitVo)
  {
    this.doseHigh = paramDecimalUnitVo;
  }

  public DecimalUnitVo getDoseLow()
  {
    return this.doseLow;
  }

  public void setDoseLow(DecimalUnitVo paramDecimalUnitVo)
  {
    this.doseLow = paramDecimalUnitVo;
  }

  public DecimalUnitVo getMaxDailyDose()
  {
    return this.maxDailyDose;
  }

  public void setMaxDailyDose(DecimalUnitVo paramDecimalUnitVo)
  {
    this.maxDailyDose = paramDecimalUnitVo;
  }

  public DecimalUnitVo getMaxDailyDoseForm()
  {
    return this.maxDailyDoseForm;
  }

  public void setMaxDailyDoseForm(DecimalUnitVo paramDecimalUnitVo)
  {
    this.maxDailyDoseForm = paramDecimalUnitVo;
  }

  public DecimalUnitVo getMaxLifetimeDose()
  {
    return this.maxLifetimeDose;
  }

  public void setMaxLifetimeDose(DecimalUnitVo paramDecimalUnitVo)
  {
    this.maxLifetimeDose = paramDecimalUnitVo;
  }

  public DecimalUnitVo getMaxLifetimeDoseForm()
  {
    return this.maxLifetimeDoseForm;
  }

  public void setMaxLifetimeDoseForm(DecimalUnitVo paramDecimalUnitVo)
  {
    this.maxLifetimeDoseForm = paramDecimalUnitVo;
  }

  public DecimalUnitVo getMaxSingleDose()
  {
    return this.maxSingleDose;
  }

  public void setMaxSingleDose(DecimalUnitVo paramDecimalUnitVo)
  {
    this.maxSingleDose = paramDecimalUnitVo;
  }

  public DecimalUnitVo getMaxSingleDoseForm()
  {
    return this.maxSingleDoseForm;
  }

  public void setMaxSingleDoseForm(DecimalUnitVo paramDecimalUnitVo)
  {
    this.maxSingleDoseForm = paramDecimalUnitVo;
  }

  public Long getDurationHigh()
  {
    return this.durationHigh;
  }

  public void setDurationHigh(Long paramLong)
  {
    this.durationHigh = paramLong;
  }

  public Long getDurationLow()
  {
    return this.durationLow;
  }

  public void setDurationLow(Long paramLong)
  {
    this.durationLow = paramLong;
  }

  public Double getFrequencyHigh()
  {
    return this.frequencyHigh;
  }

  public void setFrequencyHigh(Double paramDouble)
  {
    this.frequencyHigh = paramDouble;
  }

  public Double getFrequencyLow()
  {
    return this.frequencyLow;
  }

  public void setFrequencyLow(Double paramDouble)
  {
    this.frequencyLow = paramDouble;
  }

  public String getHitIndicationDescription()
  {
    return this.hitIndicationDescription;
  }

  public void setHitIndicationDescription(String paramString)
  {
    this.hitIndicationDescription = paramString;
  }

  public Integer getHitIndicationId()
  {
    return this.hitIndicationId;
  }

  public void setHitIndicationId(Integer paramInteger)
  {
    this.hitIndicationId = paramInteger;
  }

  public IString getIntlHitIndicationDescription()
  {
    return this.intlHitIndicationDescription;
  }

  public void setIntlHitIndicationDescription(IString paramIString)
  {
    this.intlHitIndicationDescription = paramIString;
  }

  public String getIndicationDescription()
  {
    return this.indicationDescription;
  }

  public void setIndicationDescription(String paramString)
  {
    this.indicationDescription = paramString;
  }

  public String getIndicationId()
  {
    return this.indicationId;
  }

  public void setIndicationId(String paramString)
  {
    this.indicationId = paramString;
  }

  public FDBMedicalConditionType getIndicationIdType()
  {
    return this.indicationIdType;
  }

  public void setIndicationIdType(FDBMedicalConditionType paramFDBMedicalConditionType)
  {
    this.indicationIdType = paramFDBMedicalConditionType;
  }

  public DecimalUnitVo getMaxSingleNTEDose()
  {
    return this.maxSingleNTEDose;
  }

  public void setMaxSingleNTEDose(DecimalUnitVo paramDecimalUnitVo)
  {
    this.maxSingleNTEDose = paramDecimalUnitVo;
  }

  public DecimalUnitVo getMaxSingleNTEDoseForm()
  {
    return this.maxSingleNTEDoseForm;
  }

  public void setMaxSingleNTEDoseForm(DecimalUnitVo paramDecimalUnitVo)
  {
    this.maxSingleNTEDoseForm = paramDecimalUnitVo;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DoseRangeResultVo
 * JD-Core Version:    0.6.2
 */