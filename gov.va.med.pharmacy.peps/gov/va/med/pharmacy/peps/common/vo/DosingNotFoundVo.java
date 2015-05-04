package gov.va.med.pharmacy.peps.common.vo;

import java.math.BigInteger;

public class DosingNotFoundVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private BigInteger gcnSeqNo;
  private String fdbdx;
  private String notFoundReason;

  public final BigInteger getGcnSeqNo()
  {
    return this.gcnSeqNo;
  }

  public final void setGcnSeqNo(BigInteger paramBigInteger)
  {
    this.gcnSeqNo = paramBigInteger;
  }

  public final String getFdbdx()
  {
    return this.fdbdx;
  }

  public final void setFdbdx(String paramString)
  {
    this.fdbdx = paramString;
  }

  public final String getNotFoundReason()
  {
    return this.notFoundReason;
  }

  public final void setNotFoundReason(String paramString)
  {
    this.notFoundReason = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DosingNotFoundVo
 * JD-Core Version:    0.6.2
 */