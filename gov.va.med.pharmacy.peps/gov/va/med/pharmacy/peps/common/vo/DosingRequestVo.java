package gov.va.med.pharmacy.peps.common.vo;

public class DosingRequestVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Integer gcnSeqNo;
  private Short conceptType;
  private Short hitType;
  private String fdbdx;

  public final Integer getGcnSeqNo()
  {
    return this.gcnSeqNo;
  }

  public final void setGcnSeqNo(Integer paramInteger)
  {
    this.gcnSeqNo = paramInteger;
  }

  public final Short getConceptType()
  {
    return this.conceptType;
  }

  public final void setConceptType(Short paramShort)
  {
    this.conceptType = paramShort;
  }

  public final Short getHitType()
  {
    return this.hitType;
  }

  public final void setHitType(Short paramShort)
  {
    this.hitType = paramShort;
  }

  public final String getFdbdx()
  {
    return this.fdbdx;
  }

  public final void setFdbdx(String paramString)
  {
    this.fdbdx = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DosingRequestVo
 * JD-Core Version:    0.6.2
 */