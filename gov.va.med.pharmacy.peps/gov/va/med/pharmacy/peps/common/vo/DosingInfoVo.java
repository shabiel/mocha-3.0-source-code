package gov.va.med.pharmacy.peps.common.vo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

public class DosingInfoVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private BigInteger gcnSeqNo;
  private Short conceptType;
  private Short hitType;
  private String fdbdx;
  private String dispensableDrugName;
  private String dispensableDrugDescription;
  private Collection<DoseRangeResultVo> doseRangeResults = new ArrayList();
  private Collection<MinMaxResultVo> minMaxResults = new ArrayList();
  private Collection<DoseRangeResultVo> neonatalDoseRangeResults = new ArrayList();

  public final BigInteger getGcnSeqNo()
  {
    return this.gcnSeqNo;
  }

  public final void setGcnSeqNo(BigInteger paramBigInteger)
  {
    this.gcnSeqNo = paramBigInteger;
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

  public final Collection<DoseRangeResultVo> getDoseRangeResults()
  {
    return this.doseRangeResults;
  }

  public final void setDoseRangeResults(Collection<DoseRangeResultVo> paramCollection)
  {
    this.doseRangeResults = paramCollection;
  }

  public final Collection<MinMaxResultVo> getMinMaxResults()
  {
    return this.minMaxResults;
  }

  public final void setMinMaxResults(Collection<MinMaxResultVo> paramCollection)
  {
    this.minMaxResults = paramCollection;
  }

  public final Collection<DoseRangeResultVo> getNeonatalDoseRangeResults()
  {
    return this.neonatalDoseRangeResults;
  }

  public final void setNeonatalDoseRangeResults(Collection<DoseRangeResultVo> paramCollection)
  {
    this.neonatalDoseRangeResults = paramCollection;
  }

  public final String getDispensableDrugName()
  {
    return this.dispensableDrugName;
  }

  public final void setDispensableDrugName(String paramString)
  {
    this.dispensableDrugName = paramString;
  }

  public final String getDispensableDrugDescription()
  {
    return this.dispensableDrugDescription;
  }

  public final void setDispensableDrugDescription(String paramString)
  {
    this.dispensableDrugDescription = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DosingInfoVo
 * JD-Core Version:    0.6.2
 */