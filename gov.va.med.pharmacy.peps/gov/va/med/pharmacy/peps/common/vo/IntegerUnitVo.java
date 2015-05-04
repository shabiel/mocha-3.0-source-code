package gov.va.med.pharmacy.peps.common.vo;

public class IntegerUnitVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Integer value;
  private String unit;

  public IntegerUnitVo()
  {
  }

  public IntegerUnitVo(Integer paramInteger, String paramString)
  {
    this.value = paramInteger;
    this.unit = paramString;
  }

  public final Integer getValue()
  {
    return this.value;
  }

  public final void setValue(Integer paramInteger)
  {
    this.value = paramInteger;
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
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.IntegerUnitVo
 * JD-Core Version:    0.6.2
 */