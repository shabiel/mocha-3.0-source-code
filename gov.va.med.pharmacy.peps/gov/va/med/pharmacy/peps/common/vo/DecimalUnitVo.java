package gov.va.med.pharmacy.peps.common.vo;

public class DecimalUnitVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Double value;
  private String unit;

  public DecimalUnitVo()
  {
  }

  public DecimalUnitVo(Double paramDouble, String paramString)
  {
    this.value = paramDouble;
    this.unit = paramString;
  }

  public final Double getValue()
  {
    return this.value;
  }

  public final void setValue(Double paramDouble)
  {
    this.value = paramDouble;
  }

  public final String getUnit()
  {
    return this.unit;
  }

  public final void setUnit(String paramString)
  {
    this.unit = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DecimalUnitVo
 * JD-Core Version:    0.6.2
 */