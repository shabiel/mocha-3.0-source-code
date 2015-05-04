package gov.va.med.pharmacy.peps.common.vo;

public class DoseRangeResultKey
{
  private Long ageHighInDays;
  private Long ageLowInDays;
  private String doseRouteId;
  private String doseTypeId;
  private String indicationId;

  public DoseRangeResultKey()
  {
  }

  public DoseRangeResultKey(DoseRangeResultVo paramDoseRangeResultVo)
  {
    this.ageHighInDays = paramDoseRangeResultVo.getAgeHighInDays();
    this.ageLowInDays = paramDoseRangeResultVo.getAgeLowInDays();
    this.doseRouteId = paramDoseRangeResultVo.getDoseRouteId();
    this.doseTypeId = paramDoseRangeResultVo.getDoseTypeId();
    this.indicationId = paramDoseRangeResultVo.getIndicationId();
  }

  public final Long getAgeHighInDays()
  {
    return this.ageHighInDays;
  }

  public final void setAgeHighInDays(Long paramLong)
  {
    this.ageHighInDays = paramLong;
  }

  public final Long getAgeLowInDays()
  {
    return this.ageLowInDays;
  }

  public final void setAgeLowInDays(Long paramLong)
  {
    this.ageLowInDays = paramLong;
  }

  public final String getDoseRouteId()
  {
    return this.doseRouteId;
  }

  public final void setDoseRouteId(String paramString)
  {
    this.doseRouteId = paramString;
  }

  public final String getDoseTypeId()
  {
    return this.doseTypeId;
  }

  public final void setDoseTypeId(String paramString)
  {
    this.doseTypeId = paramString;
  }

  public final String getIndicationId()
  {
    return this.indicationId;
  }

  public final void setIndicationId(String paramString)
  {
    this.indicationId = paramString;
  }

  public final int hashCode()
  {
    return this.ageHighInDays.hashCode() + this.ageLowInDays.hashCode() + this.doseRouteId.hashCode() + this.doseTypeId.hashCode() + this.indicationId.hashCode();
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof DoseRangeResultKey))
    {
      DoseRangeResultKey localDoseRangeResultKey = (DoseRangeResultKey)paramObject;
      if ((this.ageHighInDays.equals(localDoseRangeResultKey.getAgeHighInDays())) && (this.ageLowInDays.equals(localDoseRangeResultKey.getAgeLowInDays())) && (this.doseRouteId.equals(localDoseRangeResultKey.getDoseRouteId())) && (this.doseTypeId.equals(localDoseRangeResultKey.getDoseTypeId())) && (this.indicationId.equals(localDoseRangeResultKey.indicationId)))
        bool = true;
    }
    return bool;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DoseRangeResultKey
 * JD-Core Version:    0.6.2
 */