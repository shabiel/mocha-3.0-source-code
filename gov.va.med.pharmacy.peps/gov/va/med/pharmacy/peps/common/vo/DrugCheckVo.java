package gov.va.med.pharmacy.peps.common.vo;

public class DrugCheckVo extends ValueObject
{
  public static final String VA_CUSTOM_CATEGORY = "VA";
  private static final long serialVersionUID = 1L;
  private double singleDoseAmount;
  private String doseUnit = "";
  private String doseRate = "";
  private String frequency = "";
  private long duration;
  private String durationRate = "";
  private String doseRoute = "";
  private String doseType = "";
  private String vuid = "";
  private String ien = "";
  private String orderNumber = "";
  private boolean prospective;
  private String gcnSeqNo = "";
  private boolean doseCheck;
  private String drugName = "";

  public String getIen()
  {
    return this.ien;
  }

  public void setIen(String paramString)
  {
    this.ien = paramString;
  }

  public String getVuid()
  {
    return this.vuid;
  }

  public void setVuid(String paramString)
  {
    this.vuid = paramString;
  }

  public boolean isProspective()
  {
    return this.prospective;
  }

  public void setProspective(boolean paramBoolean)
  {
    this.prospective = paramBoolean;
  }

  public String getOrderNumber()
  {
    return this.orderNumber;
  }

  public void setOrderNumber(String paramString)
  {
    this.orderNumber = paramString;
  }

  public String getDoseRate()
  {
    return this.doseRate;
  }

  public void setDoseRate(String paramString)
  {
    this.doseRate = paramString;
  }

  public String getDoseRoute()
  {
    return this.doseRoute;
  }

  public void setDoseRoute(String paramString)
  {
    this.doseRoute = paramString;
  }

  public String getDoseUnit()
  {
    return this.doseUnit;
  }

  public void setDoseUnit(String paramString)
  {
    this.doseUnit = paramString;
  }

  public long getDuration()
  {
    return this.duration;
  }

  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }

  public String getDurationRate()
  {
    return this.durationRate;
  }

  public void setDurationRate(String paramString)
  {
    this.durationRate = paramString;
  }

  public String getFrequency()
  {
    return this.frequency;
  }

  public void setFrequency(String paramString)
  {
    this.frequency = paramString;
  }

  public double getSingleDoseAmount()
  {
    return this.singleDoseAmount;
  }

  public void setSingleDoseAmount(double paramDouble)
  {
    this.singleDoseAmount = paramDouble;
  }

  public String getDoseType()
  {
    return this.doseType;
  }

  public void setDoseType(String paramString)
  {
    this.doseType = paramString;
  }

  public String getGcnSeqNo()
  {
    return this.gcnSeqNo;
  }

  public void setGcnSeqNo(String paramString)
  {
    this.gcnSeqNo = paramString;
  }

  public boolean isDoseCheck()
  {
    return this.doseCheck;
  }

  public void setDoseCheck(boolean paramBoolean)
  {
    this.doseCheck = paramBoolean;
  }

  public String getDrugName()
  {
    return this.drugName;
  }

  public final void setDrugName(String paramString)
  {
    this.drugName = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DrugCheckVo
 * JD-Core Version:    0.6.2
 */