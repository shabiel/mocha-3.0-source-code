package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"source", "message", "drug", "chemoInjectable", "singleDoseStatus", "singleDoseStatusCode", "singleDoseMessage", "singleDoseMax", "single", "rangeDoseStatus", "rangeDoseStatusCode", "rangeDoseMessage", "rangeDoseLow", "rangeLow", "rangeDoseHigh", "rangeHigh", "doseHigh", "doseHighUnit", "doseLow", "doseLowUnit", "doseFormHigh", "doseFormHighUnit", "doseFormLow", "doseFormLowUnit", "doseRouteDescription", "durationStatus", "durationStatusCode", "durationMessage", "frequencyStatus", "frequencyStatusCode", "frequencyMessage", "frequencyHigh", "frequencyLow", "dailyDoseStatus", "dailyDoseStatusCode", "dailyDoseMessage", "daily", "maxDailyDoseStatus", "maxDailyDoseStatusCode", "maxDailyDoseMessage", "maxDailyDose", "maxDailyDoseUnit", "maxDailyDoseForm", "maxDailyDoseFormUnit", "maxDaily", "maxLifetimeDose", "maxLifetime", "maxSingleNTEDose", "maxSingleNTEDoseUnit", "maxSingleNTEDoseForm", "maxSingleNTEDoseFormUnit", "maxLifetimeOrderMessage", "maxLifetimeOrderStatus", "maxLifetimeOrderStatusCode", "maxLifetimeOrder"})
@XmlRootElement(name="drugDoseCheck")
public class DrugDoseCheck extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  @XmlSchemaType(name="string")
  protected SourceType source;
  protected List<Message> message;

  @XmlElement(required=true)
  protected Drug drug;
  protected Boolean chemoInjectable;

  @XmlSchemaType(name="string")
  protected DoseStatus singleDoseStatus;
  protected String singleDoseStatusCode;
  protected String singleDoseMessage;
  protected String singleDoseMax;
  protected CalculatedDose single;

  @XmlSchemaType(name="string")
  protected DoseStatus rangeDoseStatus;
  protected String rangeDoseStatusCode;
  protected String rangeDoseMessage;
  protected String rangeDoseLow;
  protected CalculatedDose rangeLow;
  protected String rangeDoseHigh;
  protected CalculatedDose rangeHigh;
  protected String doseHigh;
  protected String doseHighUnit;
  protected String doseLow;
  protected String doseLowUnit;
  protected String doseFormHigh;
  protected String doseFormHighUnit;
  protected String doseFormLow;
  protected String doseFormLowUnit;
  protected String doseRouteDescription;

  @XmlSchemaType(name="string")
  protected DoseStatus durationStatus;
  protected String durationStatusCode;
  protected String durationMessage;

  @XmlSchemaType(name="string")
  protected DoseStatus frequencyStatus;
  protected String frequencyStatusCode;
  protected String frequencyMessage;
  protected String frequencyHigh;
  protected String frequencyLow;

  @XmlSchemaType(name="string")
  protected DoseStatus dailyDoseStatus;
  protected String dailyDoseStatusCode;
  protected String dailyDoseMessage;
  protected CalculatedDose daily;

  @XmlSchemaType(name="string")
  protected DoseStatus maxDailyDoseStatus;
  protected String maxDailyDoseStatusCode;
  protected String maxDailyDoseMessage;
  protected String maxDailyDose;
  protected String maxDailyDoseUnit;
  protected String maxDailyDoseForm;
  protected String maxDailyDoseFormUnit;
  protected CalculatedDose maxDaily;
  protected String maxLifetimeDose;
  protected CalculatedDose maxLifetime;
  protected String maxSingleNTEDose;
  protected String maxSingleNTEDoseUnit;
  protected String maxSingleNTEDoseForm;
  protected String maxSingleNTEDoseFormUnit;
  protected String maxLifetimeOrderMessage;
  protected String maxLifetimeOrderStatus;
  protected String maxLifetimeOrderStatusCode;
  protected CalculatedDose maxLifetimeOrder;

  public SourceType getSource()
  {
    return this.source;
  }

  public void setSource(SourceType paramSourceType)
  {
    this.source = paramSourceType;
  }

  public boolean isSetSource()
  {
    return this.source != null;
  }

  public List<Message> getMessage()
  {
    if (this.message == null)
      this.message = new ArrayList();
    return this.message;
  }

  public boolean isSetMessage()
  {
    return (this.message != null) && (!this.message.isEmpty());
  }

  public void unsetMessage()
  {
    this.message = null;
  }

  public Drug getDrug()
  {
    return this.drug;
  }

  public void setDrug(Drug paramDrug)
  {
    this.drug = paramDrug;
  }

  public boolean isSetDrug()
  {
    return this.drug != null;
  }

  public Boolean isChemoInjectable()
  {
    return this.chemoInjectable;
  }

  public void setChemoInjectable(Boolean paramBoolean)
  {
    this.chemoInjectable = paramBoolean;
  }

  public boolean isSetChemoInjectable()
  {
    return this.chemoInjectable != null;
  }

  public DoseStatus getSingleDoseStatus()
  {
    return this.singleDoseStatus;
  }

  public void setSingleDoseStatus(DoseStatus paramDoseStatus)
  {
    this.singleDoseStatus = paramDoseStatus;
  }

  public boolean isSetSingleDoseStatus()
  {
    return this.singleDoseStatus != null;
  }

  public String getSingleDoseStatusCode()
  {
    return this.singleDoseStatusCode;
  }

  public void setSingleDoseStatusCode(String paramString)
  {
    this.singleDoseStatusCode = paramString;
  }

  public boolean isSetSingleDoseStatusCode()
  {
    return this.singleDoseStatusCode != null;
  }

  public String getSingleDoseMessage()
  {
    return this.singleDoseMessage;
  }

  public void setSingleDoseMessage(String paramString)
  {
    this.singleDoseMessage = paramString;
  }

  public boolean isSetSingleDoseMessage()
  {
    return this.singleDoseMessage != null;
  }

  public String getSingleDoseMax()
  {
    return this.singleDoseMax;
  }

  public void setSingleDoseMax(String paramString)
  {
    this.singleDoseMax = paramString;
  }

  public boolean isSetSingleDoseMax()
  {
    return this.singleDoseMax != null;
  }

  public CalculatedDose getSingle()
  {
    return this.single;
  }

  public void setSingle(CalculatedDose paramCalculatedDose)
  {
    this.single = paramCalculatedDose;
  }

  public boolean isSetSingle()
  {
    return this.single != null;
  }

  public DoseStatus getRangeDoseStatus()
  {
    return this.rangeDoseStatus;
  }

  public void setRangeDoseStatus(DoseStatus paramDoseStatus)
  {
    this.rangeDoseStatus = paramDoseStatus;
  }

  public boolean isSetRangeDoseStatus()
  {
    return this.rangeDoseStatus != null;
  }

  public String getRangeDoseStatusCode()
  {
    return this.rangeDoseStatusCode;
  }

  public void setRangeDoseStatusCode(String paramString)
  {
    this.rangeDoseStatusCode = paramString;
  }

  public boolean isSetRangeDoseStatusCode()
  {
    return this.rangeDoseStatusCode != null;
  }

  public String getRangeDoseMessage()
  {
    return this.rangeDoseMessage;
  }

  public void setRangeDoseMessage(String paramString)
  {
    this.rangeDoseMessage = paramString;
  }

  public boolean isSetRangeDoseMessage()
  {
    return this.rangeDoseMessage != null;
  }

  public String getRangeDoseLow()
  {
    return this.rangeDoseLow;
  }

  public void setRangeDoseLow(String paramString)
  {
    this.rangeDoseLow = paramString;
  }

  public boolean isSetRangeDoseLow()
  {
    return this.rangeDoseLow != null;
  }

  public CalculatedDose getRangeLow()
  {
    return this.rangeLow;
  }

  public void setRangeLow(CalculatedDose paramCalculatedDose)
  {
    this.rangeLow = paramCalculatedDose;
  }

  public boolean isSetRangeLow()
  {
    return this.rangeLow != null;
  }

  public String getRangeDoseHigh()
  {
    return this.rangeDoseHigh;
  }

  public void setRangeDoseHigh(String paramString)
  {
    this.rangeDoseHigh = paramString;
  }

  public boolean isSetRangeDoseHigh()
  {
    return this.rangeDoseHigh != null;
  }

  public CalculatedDose getRangeHigh()
  {
    return this.rangeHigh;
  }

  public void setRangeHigh(CalculatedDose paramCalculatedDose)
  {
    this.rangeHigh = paramCalculatedDose;
  }

  public boolean isSetRangeHigh()
  {
    return this.rangeHigh != null;
  }

  public String getDoseHigh()
  {
    return this.doseHigh;
  }

  public void setDoseHigh(String paramString)
  {
    this.doseHigh = paramString;
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

  public String getDoseLow()
  {
    return this.doseLow;
  }

  public void setDoseLow(String paramString)
  {
    this.doseLow = paramString;
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

  public String getDoseFormHigh()
  {
    return this.doseFormHigh;
  }

  public void setDoseFormHigh(String paramString)
  {
    this.doseFormHigh = paramString;
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

  public String getDoseFormLow()
  {
    return this.doseFormLow;
  }

  public void setDoseFormLow(String paramString)
  {
    this.doseFormLow = paramString;
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

  public DoseStatus getDurationStatus()
  {
    return this.durationStatus;
  }

  public void setDurationStatus(DoseStatus paramDoseStatus)
  {
    this.durationStatus = paramDoseStatus;
  }

  public boolean isSetDurationStatus()
  {
    return this.durationStatus != null;
  }

  public String getDurationStatusCode()
  {
    return this.durationStatusCode;
  }

  public void setDurationStatusCode(String paramString)
  {
    this.durationStatusCode = paramString;
  }

  public boolean isSetDurationStatusCode()
  {
    return this.durationStatusCode != null;
  }

  public String getDurationMessage()
  {
    return this.durationMessage;
  }

  public void setDurationMessage(String paramString)
  {
    this.durationMessage = paramString;
  }

  public boolean isSetDurationMessage()
  {
    return this.durationMessage != null;
  }

  public DoseStatus getFrequencyStatus()
  {
    return this.frequencyStatus;
  }

  public void setFrequencyStatus(DoseStatus paramDoseStatus)
  {
    this.frequencyStatus = paramDoseStatus;
  }

  public boolean isSetFrequencyStatus()
  {
    return this.frequencyStatus != null;
  }

  public String getFrequencyStatusCode()
  {
    return this.frequencyStatusCode;
  }

  public void setFrequencyStatusCode(String paramString)
  {
    this.frequencyStatusCode = paramString;
  }

  public boolean isSetFrequencyStatusCode()
  {
    return this.frequencyStatusCode != null;
  }

  public String getFrequencyMessage()
  {
    return this.frequencyMessage;
  }

  public void setFrequencyMessage(String paramString)
  {
    this.frequencyMessage = paramString;
  }

  public boolean isSetFrequencyMessage()
  {
    return this.frequencyMessage != null;
  }

  public String getFrequencyHigh()
  {
    return this.frequencyHigh;
  }

  public void setFrequencyHigh(String paramString)
  {
    this.frequencyHigh = paramString;
  }

  public boolean isSetFrequencyHigh()
  {
    return this.frequencyHigh != null;
  }

  public String getFrequencyLow()
  {
    return this.frequencyLow;
  }

  public void setFrequencyLow(String paramString)
  {
    this.frequencyLow = paramString;
  }

  public boolean isSetFrequencyLow()
  {
    return this.frequencyLow != null;
  }

  public DoseStatus getDailyDoseStatus()
  {
    return this.dailyDoseStatus;
  }

  public void setDailyDoseStatus(DoseStatus paramDoseStatus)
  {
    this.dailyDoseStatus = paramDoseStatus;
  }

  public boolean isSetDailyDoseStatus()
  {
    return this.dailyDoseStatus != null;
  }

  public String getDailyDoseStatusCode()
  {
    return this.dailyDoseStatusCode;
  }

  public void setDailyDoseStatusCode(String paramString)
  {
    this.dailyDoseStatusCode = paramString;
  }

  public boolean isSetDailyDoseStatusCode()
  {
    return this.dailyDoseStatusCode != null;
  }

  public String getDailyDoseMessage()
  {
    return this.dailyDoseMessage;
  }

  public void setDailyDoseMessage(String paramString)
  {
    this.dailyDoseMessage = paramString;
  }

  public boolean isSetDailyDoseMessage()
  {
    return this.dailyDoseMessage != null;
  }

  public CalculatedDose getDaily()
  {
    return this.daily;
  }

  public void setDaily(CalculatedDose paramCalculatedDose)
  {
    this.daily = paramCalculatedDose;
  }

  public boolean isSetDaily()
  {
    return this.daily != null;
  }

  public DoseStatus getMaxDailyDoseStatus()
  {
    return this.maxDailyDoseStatus;
  }

  public void setMaxDailyDoseStatus(DoseStatus paramDoseStatus)
  {
    this.maxDailyDoseStatus = paramDoseStatus;
  }

  public boolean isSetMaxDailyDoseStatus()
  {
    return this.maxDailyDoseStatus != null;
  }

  public String getMaxDailyDoseStatusCode()
  {
    return this.maxDailyDoseStatusCode;
  }

  public void setMaxDailyDoseStatusCode(String paramString)
  {
    this.maxDailyDoseStatusCode = paramString;
  }

  public boolean isSetMaxDailyDoseStatusCode()
  {
    return this.maxDailyDoseStatusCode != null;
  }

  public String getMaxDailyDoseMessage()
  {
    return this.maxDailyDoseMessage;
  }

  public void setMaxDailyDoseMessage(String paramString)
  {
    this.maxDailyDoseMessage = paramString;
  }

  public boolean isSetMaxDailyDoseMessage()
  {
    return this.maxDailyDoseMessage != null;
  }

  public String getMaxDailyDose()
  {
    return this.maxDailyDose;
  }

  public void setMaxDailyDose(String paramString)
  {
    this.maxDailyDose = paramString;
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

  public String getMaxDailyDoseForm()
  {
    return this.maxDailyDoseForm;
  }

  public void setMaxDailyDoseForm(String paramString)
  {
    this.maxDailyDoseForm = paramString;
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

  public CalculatedDose getMaxDaily()
  {
    return this.maxDaily;
  }

  public void setMaxDaily(CalculatedDose paramCalculatedDose)
  {
    this.maxDaily = paramCalculatedDose;
  }

  public boolean isSetMaxDaily()
  {
    return this.maxDaily != null;
  }

  public String getMaxLifetimeDose()
  {
    return this.maxLifetimeDose;
  }

  public void setMaxLifetimeDose(String paramString)
  {
    this.maxLifetimeDose = paramString;
  }

  public boolean isSetMaxLifetimeDose()
  {
    return this.maxLifetimeDose != null;
  }

  public CalculatedDose getMaxLifetime()
  {
    return this.maxLifetime;
  }

  public void setMaxLifetime(CalculatedDose paramCalculatedDose)
  {
    this.maxLifetime = paramCalculatedDose;
  }

  public boolean isSetMaxLifetime()
  {
    return this.maxLifetime != null;
  }

  public String getMaxSingleNTEDose()
  {
    return this.maxSingleNTEDose;
  }

  public void setMaxSingleNTEDose(String paramString)
  {
    this.maxSingleNTEDose = paramString;
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

  public String getMaxSingleNTEDoseForm()
  {
    return this.maxSingleNTEDoseForm;
  }

  public void setMaxSingleNTEDoseForm(String paramString)
  {
    this.maxSingleNTEDoseForm = paramString;
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

  public String getMaxLifetimeOrderMessage()
  {
    return this.maxLifetimeOrderMessage;
  }

  public void setMaxLifetimeOrderMessage(String paramString)
  {
    this.maxLifetimeOrderMessage = paramString;
  }

  public boolean isSetMaxLifetimeOrderMessage()
  {
    return this.maxLifetimeOrderMessage != null;
  }

  public String getMaxLifetimeOrderStatus()
  {
    return this.maxLifetimeOrderStatus;
  }

  public void setMaxLifetimeOrderStatus(String paramString)
  {
    this.maxLifetimeOrderStatus = paramString;
  }

  public boolean isSetMaxLifetimeOrderStatus()
  {
    return this.maxLifetimeOrderStatus != null;
  }

  public String getMaxLifetimeOrderStatusCode()
  {
    return this.maxLifetimeOrderStatusCode;
  }

  public void setMaxLifetimeOrderStatusCode(String paramString)
  {
    this.maxLifetimeOrderStatusCode = paramString;
  }

  public boolean isSetMaxLifetimeOrderStatusCode()
  {
    return this.maxLifetimeOrderStatusCode != null;
  }

  public CalculatedDose getMaxLifetimeOrder()
  {
    return this.maxLifetimeOrder;
  }

  public void setMaxLifetimeOrder(CalculatedDose paramCalculatedDose)
  {
    this.maxLifetimeOrder = paramCalculatedDose;
  }

  public boolean isSetMaxLifetimeOrder()
  {
    return this.maxLifetimeOrder != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugDoseCheck
 * JD-Core Version:    0.6.2
 */