package gov.va.med.pharmacy.peps.common.vo;

public class DoseRouteVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private String id;
  private String name;

  public final String getId()
  {
    return this.id;
  }

  public final void setId(String paramString)
  {
    this.id = paramString;
  }

  public final String getName()
  {
    return this.name;
  }

  public final void setName(String paramString)
  {
    this.name = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DoseRouteVo
 * JD-Core Version:    0.6.2
 */