package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"custom", "bsaRequired", "halfLifeUnit", "category", "hepaticImpairment", "highEliminationHalfLife", "lowEliminationHalfLife", "maxDuration", "renalImpairment", "weightRequired", "doseRouteDescription", "intlDoseRouteDescription", "doseTypeDescription", "intlDoseTypeDescription", "crclThreshold", "crclThresholdUnit", "doseFormHigh", "doseFormHighUnit", "doseFormLow", "doseFormLowUnit", "doseHigh", "doseHighUnit", "doseLow", "doseLowUnit", "maxDailyDose", "maxDailyDoseUnit", "maxDailyDoseForm", "maxDailyDoseFormUnit", "maxLifetimeDose", "maxLifetimeDoseUnit", "maxLifetimeDoseForm", "maxLifetimeDoseFormUnit", "maxSingleDose", "maxSingleDoseUnit", "maxSingleDoseForm", "maxSingleDoseFormUnit", "durationHigh", "durationLow", "frequencyHigh", "frequencyLow", "hitIndicationDescription", "hitIndicationId", "intlHighIndicationDescription", "indicationDescription", "indicationId", "indicationIdType", "maxSingleNTEDose", "maxSingleNTEDoseUnit", "maxSingleNTEDoseForm", "maxSingleNTEDoseFormUnit"})
@XmlRootElement(name="doseRange")
public class DoseRange extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Boolean custom;
  protected Boolean bsaRequired;
  protected String halfLifeUnit;
  protected String category;
  protected Boolean hepaticImpairment;
  protected BigDecimal highEliminationHalfLife;
  protected BigDecimal lowEliminationHalfLife;
  protected Long maxDuration;
  protected Boolean renalImpairment;
  protected Boolean weightRequired;
  protected String doseRouteDescription;
  protected String intlDoseRouteDescription;
  protected String doseTypeDescription;
  protected String intlDoseTypeDescription;
  protected BigInteger crclThreshold;
  protected String crclThresholdUnit;
  protected BigDecimal doseFormHigh;
  protected String doseFormHighUnit;
  protected BigDecimal doseFormLow;
  protected String doseFormLowUnit;
  protected BigDecimal doseHigh;
  protected String doseHighUnit;
  protected BigDecimal doseLow;
  protected String doseLowUnit;
  protected BigDecimal maxDailyDose;
  protected String maxDailyDoseUnit;
  protected BigDecimal maxDailyDoseForm;
  protected String maxDailyDoseFormUnit;
  protected BigDecimal maxLifetimeDose;
  protected String maxLifetimeDoseUnit;
  protected BigDecimal maxLifetimeDoseForm;
  protected String maxLifetimeDoseFormUnit;
  protected BigDecimal maxSingleDose;
  protected String maxSingleDoseUnit;
  protected BigDecimal maxSingleDoseForm;
  protected String maxSingleDoseFormUnit;
  protected Long durationHigh;
  protected Long durationLow;
  protected BigDecimal frequencyHigh;
  protected BigDecimal frequencyLow;
  protected String hitIndicationDescription;
  protected String hitIndicationId;
  protected String intlHighIndicationDescription;
  protected String indicationDescription;
  protected String indicationId;
  protected String indicationIdType;
  protected BigDecimal maxSingleNTEDose;
  protected String maxSingleNTEDoseUnit;
  protected BigDecimal maxSingleNTEDoseForm;
  protected String maxSingleNTEDoseFormUnit;

  @XmlAttribute(name="ageHighInDays", required=true)
  protected long ageHighInDays;

  @XmlAttribute(name="ageLowInDays", required=true)
  protected long ageLowInDays;

  @XmlAttribute(name="doseRouteId", required=true)
  protected String doseRouteId;

  @XmlAttribute(name="doseTypeId", required=true)
  protected String doseTypeId;

  public Boolean isCustom()
  {
    return this.custom;
  }

  public void setCustom(Boolean paramBoolean)
  {
    this.custom = paramBoolean;
  }

  public boolean isSetCustom()
  {
    return this.custom != null;
  }

  public Boolean isBsaRequired()
  {
    return this.bsaRequired;
  }

  public void setBsaRequired(Boolean paramBoolean)
  {
    this.bsaRequired = paramBoolean;
  }

  public boolean isSetBsaRequired()
  {
    return this.bsaRequired != null;
  }

  public String getHalfLifeUnit()
  {
    return this.halfLifeUnit;
  }

  public void setHalfLifeUnit(String paramString)
  {
    this.halfLifeUnit = paramString;
  }

  public boolean isSetHalfLifeUnit()
  {
    return this.halfLifeUnit != null;
  }

  public String getCategory()
  {
    return this.category;
  }

  public void setCategory(String paramString)
  {
    this.category = paramString;
  }

  public boolean isSetCategory()
  {
    return this.category != null;
  }

  public Boolean isHepaticImpairment()
  {
    return this.hepaticImpairment;
  }

  public void setHepaticImpairment(Boolean paramBoolean)
  {
    this.hepaticImpairment = paramBoolean;
  }

  public boolean isSetHepaticImpairment()
  {
    return this.hepaticImpairment != null;
  }

  public BigDecimal getHighEliminationHalfLife()
  {
    return this.highEliminationHalfLife;
  }

  public void setHighEliminationHalfLife(BigDecimal paramBigDecimal)
  {
    this.highEliminationHalfLife = paramBigDecimal;
  }

  public boolean isSetHighEliminationHalfLife()
  {
    return this.highEliminationHalfLife != null;
  }

  public BigDecimal getLowEliminationHalfLife()
  {
    return this.lowEliminationHalfLife;
  }

  public void setLowEliminationHalfLife(BigDecimal paramBigDecimal)
  {
    this.lowEliminationHalfLife = paramBigDecimal;
  }

  public boolean isSetLowEliminationHalfLife()
  {
    return this.lowEliminationHalfLife != null;
  }

  public Long getMaxDuration()
  {
    return this.maxDuration;
  }

  public void setMaxDuration(Long paramLong)
  {
    this.maxDuration = paramLong;
  }

  public boolean isSetMaxDuration()
  {
    return this.maxDuration != null;
  }

  public Boolean isRenalImpairment()
  {
    return this.renalImpairment;
  }

  public void setRenalImpairment(Boolean paramBoolean)
  {
    this.renalImpairment = paramBoolean;
  }

  public boolean isSetRenalImpairment()
  {
    return this.renalImpairment != null;
  }

  public Boolean isWeightRequired()
  {
    return this.weightRequired;
  }

  public void setWeightRequired(Boolean paramBoolean)
  {
    this.weightRequired = paramBoolean;
  }

  public boolean isSetWeightRequired()
  {
    return this.weightRequired != null;
  }

  public String getDoseRouteDescription()
  {
    return this.doseRouteDescription;
  }

  public void setDoseRouteDescription(String paramString)
  {
    this.doseRouteDescription = paramString;
  }

  public boolean isSetDoseRouteDescription()
  {
    return this.doseRouteDescription != null;
  }

  public String getIntlDoseRouteDescription()
  {
    return this.intlDoseRouteDescription;
  }

  public void setIntlDoseRouteDescription(String paramString)
  {
    this.intlDoseRouteDescription = paramString;
  }

  public boolean isSetIntlDoseRouteDescription()
  {
    return this.intlDoseRouteDescription != null;
  }

  public String getDoseTypeDescription()
  {
    return this.doseTypeDescription;
  }

  public void setDoseTypeDescription(String paramString)
  {
    this.doseTypeDescription = paramString;
  }

  public boolean isSetDoseTypeDescription()
  {
    return this.doseTypeDescription != null;
  }

  public String getIntlDoseTypeDescription()
  {
    return this.intlDoseTypeDescription;
  }

  public void setIntlDoseTypeDescription(String paramString)
  {
    this.intlDoseTypeDescription = paramString;
  }

  public boolean isSetIntlDoseTypeDescription()
  {
    return this.intlDoseTypeDescription != null;
  }

  public BigInteger getCrclThreshold()
  {
    return this.crclThreshold;
  }

  public void setCrclThreshold(BigInteger paramBigInteger)
  {
    this.crclThreshold = paramBigInteger;
  }

  public boolean isSetCrclThreshold()
  {
    return this.crclThreshold != null;
  }

  public String getCrclThresholdUnit()
  {
    return this.crclThresholdUnit;
  }

  public void setCrclThresholdUnit(String paramString)
  {
    this.crclThresholdUnit = paramString;
  }

  public boolean isSetCrclThresholdUnit()
  {
    return this.crclThresholdUnit != null;
  }

  public BigDecimal getDoseFormHigh()
  {
    return this.doseFormHigh;
  }

  public void setDoseFormHigh(BigDecimal paramBigDecimal)
  {
    this.doseFormHigh = paramBigDecimal;
  }

  public boolean isSetDoseFormHigh()
  {
    return this.doseFormHigh != null;
  }

  public String getDoseFormHighUnit()
  {
    return this.doseFormHighUnit;
  }

  public void setDoseFormHighUnit(String paramString)
  {
    this.doseFormHighUnit = paramString;
  }

  public boolean isSetDoseFormHighUnit()
  {
    return this.doseFormHighUnit != null;
  }

  public BigDecimal getDoseFormLow()
  {
    return this.doseFormLow;
  }

  public void setDoseFormLow(BigDecimal paramBigDecimal)
  {
    this.doseFormLow = paramBigDecimal;
  }

  public boolean isSetDoseFormLow()
  {
    return this.doseFormLow != null;
  }

  public String getDoseFormLowUnit()
  {
    return this.doseFormLowUnit;
  }

  public void setDoseFormLowUnit(String paramString)
  {
    this.doseFormLowUnit = paramString;
  }

  public boolean isSetDoseFormLowUnit()
  {
    return this.doseFormLowUnit != null;
  }

  public BigDecimal getDoseHigh()
  {
    return this.doseHigh;
  }

  public void setDoseHigh(BigDecimal paramBigDecimal)
  {
    this.doseHigh = paramBigDecimal;
  }

  public boolean isSetDoseHigh()
  {
    return this.doseHigh != null;
  }

  public String getDoseHighUnit()
  {
    return this.doseHighUnit;
  }

  public void setDoseHighUnit(String paramString)
  {
    this.doseHighUnit = paramString;
  }

  public boolean isSetDoseHighUnit()
  {
    return this.doseHighUnit != null;
  }

  public BigDecimal getDoseLow()
  {
    return this.doseLow;
  }

  public void setDoseLow(BigDecimal paramBigDecimal)
  {
    this.doseLow = paramBigDecimal;
  }

  public boolean isSetDoseLow()
  {
    return this.doseLow != null;
  }

  public String getDoseLowUnit()
  {
    return this.doseLowUnit;
  }

  public void setDoseLowUnit(String paramString)
  {
    this.doseLowUnit = paramString;
  }

  public boolean isSetDoseLowUnit()
  {
    return this.doseLowUnit != null;
  }

  public BigDecimal getMaxDailyDose()
  {
    return this.maxDailyDose;
  }

  public void setMaxDailyDose(BigDecimal paramBigDecimal)
  {
    this.maxDailyDose = paramBigDecimal;
  }

  public boolean isSetMaxDailyDose()
  {
    return this.maxDailyDose != null;
  }

  public String getMaxDailyDoseUnit()
  {
    return this.maxDailyDoseUnit;
  }

  public void setMaxDailyDoseUnit(String paramString)
  {
    this.maxDailyDoseUnit = paramString;
  }

  public boolean isSetMaxDailyDoseUnit()
  {
    return this.maxDailyDoseUnit != null;
  }

  public BigDecimal getMaxDailyDoseForm()
  {
    return this.maxDailyDoseForm;
  }

  public void setMaxDailyDoseForm(BigDecimal paramBigDecimal)
  {
    this.maxDailyDoseForm = paramBigDecimal;
  }

  public boolean isSetMaxDailyDoseForm()
  {
    return this.maxDailyDoseForm != null;
  }

  public String getMaxDailyDoseFormUnit()
  {
    return this.maxDailyDoseFormUnit;
  }

  public void setMaxDailyDoseFormUnit(String paramString)
  {
    this.maxDailyDoseFormUnit = paramString;
  }

  public boolean isSetMaxDailyDoseFormUnit()
  {
    return this.maxDailyDoseFormUnit != null;
  }

  public BigDecimal getMaxLifetimeDose()
  {
    return this.maxLifetimeDose;
  }

  public void setMaxLifetimeDose(BigDecimal paramBigDecimal)
  {
    this.maxLifetimeDose = paramBigDecimal;
  }

  public boolean isSetMaxLifetimeDose()
  {
    return this.maxLifetimeDose != null;
  }

  public String getMaxLifetimeDoseUnit()
  {
    return this.maxLifetimeDoseUnit;
  }

  public void setMaxLifetimeDoseUnit(String paramString)
  {
    this.maxLifetimeDoseUnit = paramString;
  }

  public boolean isSetMaxLifetimeDoseUnit()
  {
    return this.maxLifetimeDoseUnit != null;
  }

  public BigDecimal getMaxLifetimeDoseForm()
  {
    return this.maxLifetimeDoseForm;
  }

  public void setMaxLifetimeDoseForm(BigDecimal paramBigDecimal)
  {
    this.maxLifetimeDoseForm = paramBigDecimal;
  }

  public boolean isSetMaxLifetimeDoseForm()
  {
    return this.maxLifetimeDoseForm != null;
  }

  public String getMaxLifetimeDoseFormUnit()
  {
    return this.maxLifetimeDoseFormUnit;
  }

  public void setMaxLifetimeDoseFormUnit(String paramString)
  {
    this.maxLifetimeDoseFormUnit = paramString;
  }

  public boolean isSetMaxLifetimeDoseFormUnit()
  {
    return this.maxLifetimeDoseFormUnit != null;
  }

  public BigDecimal getMaxSingleDose()
  {
    return this.maxSingleDose;
  }

  public void setMaxSingleDose(BigDecimal paramBigDecimal)
  {
    this.maxSingleDose = paramBigDecimal;
  }

  public boolean isSetMaxSingleDose()
  {
    return this.maxSingleDose != null;
  }

  public String getMaxSingleDoseUnit()
  {
    return this.maxSingleDoseUnit;
  }

  public void setMaxSingleDoseUnit(String paramString)
  {
    this.maxSingleDoseUnit = paramString;
  }

  public boolean isSetMaxSingleDoseUnit()
  {
    return this.maxSingleDoseUnit != null;
  }

  public BigDecimal getMaxSingleDoseForm()
  {
    return this.maxSingleDoseForm;
  }

  public void setMaxSingleDoseForm(BigDecimal paramBigDecimal)
  {
    this.maxSingleDoseForm = paramBigDecimal;
  }

  public boolean isSetMaxSingleDoseForm()
  {
    return this.maxSingleDoseForm != null;
  }

  public String getMaxSingleDoseFormUnit()
  {
    return this.maxSingleDoseFormUnit;
  }

  public void setMaxSingleDoseFormUnit(String paramString)
  {
    this.maxSingleDoseFormUnit = paramString;
  }

  public boolean isSetMaxSingleDoseFormUnit()
  {
    return this.maxSingleDoseFormUnit != null;
  }

  public Long getDurationHigh()
  {
    return this.durationHigh;
  }

  public void setDurationHigh(Long paramLong)
  {
    this.durationHigh = paramLong;
  }

  public boolean isSetDurationHigh()
  {
    return this.durationHigh != null;
  }

  public Long getDurationLow()
  {
    return this.durationLow;
  }

  public void setDurationLow(Long paramLong)
  {
    this.durationLow = paramLong;
  }

  public boolean isSetDurationLow()
  {
    return this.durationLow != null;
  }

  public BigDecimal getFrequencyHigh()
  {
    return this.frequencyHigh;
  }

  public void setFrequencyHigh(BigDecimal paramBigDecimal)
  {
    this.frequencyHigh = paramBigDecimal;
  }

  public boolean isSetFrequencyHigh()
  {
    return this.frequencyHigh != null;
  }

  public BigDecimal getFrequencyLow()
  {
    return this.frequencyLow;
  }

  public void setFrequencyLow(BigDecimal paramBigDecimal)
  {
    this.frequencyLow = paramBigDecimal;
  }

  public boolean isSetFrequencyLow()
  {
    return this.frequencyLow != null;
  }

  public String getHitIndicationDescription()
  {
    return this.hitIndicationDescription;
  }

  public void setHitIndicationDescription(String paramString)
  {
    this.hitIndicationDescription = paramString;
  }

  public boolean isSetHitIndicationDescription()
  {
    return this.hitIndicationDescription != null;
  }

  public String getHitIndicationId()
  {
    return this.hitIndicationId;
  }

  public void setHitIndicationId(String paramString)
  {
    this.hitIndicationId = paramString;
  }

  public boolean isSetHitIndicationId()
  {
    return this.hitIndicationId != null;
  }

  public String getIntlHighIndicationDescription()
  {
    return this.intlHighIndicationDescription;
  }

  public void setIntlHighIndicationDescription(String paramString)
  {
    this.intlHighIndicationDescription = paramString;
  }

  public boolean isSetIntlHighIndicationDescription()
  {
    return this.intlHighIndicationDescription != null;
  }

  public String getIndicationDescription()
  {
    return this.indicationDescription;
  }

  public void setIndicationDescription(String paramString)
  {
    this.indicationDescription = paramString;
  }

  public boolean isSetIndicationDescription()
  {
    return this.indicationDescription != null;
  }

  public String getIndicationId()
  {
    return this.indicationId;
  }

  public void setIndicationId(String paramString)
  {
    this.indicationId = paramString;
  }

  public boolean isSetIndicationId()
  {
    return this.indicationId != null;
  }

  public String getIndicationIdType()
  {
    return this.indicationIdType;
  }

  public void setIndicationIdType(String paramString)
  {
    this.indicationIdType = paramString;
  }

  public boolean isSetIndicationIdType()
  {
    return this.indicationIdType != null;
  }

  public BigDecimal getMaxSingleNTEDose()
  {
    return this.maxSingleNTEDose;
  }

  public void setMaxSingleNTEDose(BigDecimal paramBigDecimal)
  {
    this.maxSingleNTEDose = paramBigDecimal;
  }

  public boolean isSetMaxSingleNTEDose()
  {
    return this.maxSingleNTEDose != null;
  }

  public String getMaxSingleNTEDoseUnit()
  {
    return this.maxSingleNTEDoseUnit;
  }

  public void setMaxSingleNTEDoseUnit(String paramString)
  {
    this.maxSingleNTEDoseUnit = paramString;
  }

  public boolean isSetMaxSingleNTEDoseUnit()
  {
    return this.maxSingleNTEDoseUnit != null;
  }

  public BigDecimal getMaxSingleNTEDoseForm()
  {
    return this.maxSingleNTEDoseForm;
  }

  public void setMaxSingleNTEDoseForm(BigDecimal paramBigDecimal)
  {
    this.maxSingleNTEDoseForm = paramBigDecimal;
  }

  public boolean isSetMaxSingleNTEDoseForm()
  {
    return this.maxSingleNTEDoseForm != null;
  }

  public String getMaxSingleNTEDoseFormUnit()
  {
    return this.maxSingleNTEDoseFormUnit;
  }

  public void setMaxSingleNTEDoseFormUnit(String paramString)
  {
    this.maxSingleNTEDoseFormUnit = paramString;
  }

  public boolean isSetMaxSingleNTEDoseFormUnit()
  {
    return this.maxSingleNTEDoseFormUnit != null;
  }

  public long getAgeHighInDays()
  {
    return this.ageHighInDays;
  }

  public void setAgeHighInDays(long paramLong)
  {
    this.ageHighInDays = paramLong;
  }

  public boolean isSetAgeHighInDays()
  {
    return true;
  }

  public long getAgeLowInDays()
  {
    return this.ageLowInDays;
  }

  public void setAgeLowInDays(long paramLong)
  {
    this.ageLowInDays = paramLong;
  }

  public boolean isSetAgeLowInDays()
  {
    return true;
  }

  public String getDoseRouteId()
  {
    return this.doseRouteId;
  }

  public void setDoseRouteId(String paramString)
  {
    this.doseRouteId = paramString;
  }

  public boolean isSetDoseRouteId()
  {
    return this.doseRouteId != null;
  }

  public String getDoseTypeId()
  {
    return this.doseTypeId;
  }

  public void setDoseTypeId(String paramString)
  {
    this.doseTypeId = paramString;
  }

  public boolean isSetDoseTypeId()
  {
    return this.doseTypeId != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.DoseRange
 * JD-Core Version:    0.6.2
 */