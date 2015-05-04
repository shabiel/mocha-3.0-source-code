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
@XmlType(name="", propOrder={"bsaRequired", "doseFormHigh", "doseFormHighUnit", "doseFormLow", "doseFormLowUnit", "doseHigh", "doseHighUnit", "doseLow", "doseLowUnit", "maxDailyDose", "maxDailyDoseUnit", "maxDailyDoseForm", "maxDailyDoseFormUnit", "resultType", "warningCode", "warningMessage", "weightRequired"})
@XmlRootElement(name="minMax")
public class MinMax extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Boolean bsaRequired;
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
  protected String resultType;
  protected BigInteger warningCode;
  protected String warningMessage;
  protected Boolean weightRequired;

  @XmlAttribute(name="ageHighInDays", required=true)
  protected long ageHighInDays;

  @XmlAttribute(name="ageLowInDays", required=true)
  protected long ageLowInDays;

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

  public String getResultType()
  {
    return this.resultType;
  }

  public void setResultType(String paramString)
  {
    this.resultType = paramString;
  }

  public boolean isSetResultType()
  {
    return this.resultType != null;
  }

  public BigInteger getWarningCode()
  {
    return this.warningCode;
  }

  public void setWarningCode(BigInteger paramBigInteger)
  {
    this.warningCode = paramBigInteger;
  }

  public boolean isSetWarningCode()
  {
    return this.warningCode != null;
  }

  public String getWarningMessage()
  {
    return this.warningMessage;
  }

  public void setWarningMessage(String paramString)
  {
    this.warningMessage = paramString;
  }

  public boolean isSetWarningMessage()
  {
    return this.warningMessage != null;
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
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.MinMax
 * JD-Core Version:    0.6.2
 */