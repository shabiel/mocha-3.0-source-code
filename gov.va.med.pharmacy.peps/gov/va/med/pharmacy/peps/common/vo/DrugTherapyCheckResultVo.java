package gov.va.med.pharmacy.peps.common.vo;

import java.util.ArrayList;
import java.util.Collection;

public class DrugTherapyCheckResultVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Collection<DrugCheckVo> drugs = new ArrayList();
  private String duplicateClass = "";
  private String shortText = "";
  private long allowance;
  private long id;
  private boolean custom;

  public long getAllowance()
  {
    return this.allowance;
  }

  public void setAllowance(long paramLong)
  {
    this.allowance = paramLong;
  }

  public Collection<DrugCheckVo> getDrugs()
  {
    return this.drugs;
  }

  public void setDrugs(Collection<DrugCheckVo> paramCollection)
  {
    this.drugs = paramCollection;
  }

  public String getDuplicateClass()
  {
    return this.duplicateClass;
  }

  public void setDuplicateClass(String paramString)
  {
    this.duplicateClass = paramString;
  }

  public String getShortText()
  {
    return this.shortText;
  }

  public void setShortText(String paramString)
  {
    this.shortText = paramString;
  }

  public long getId()
  {
    return this.id;
  }

  public void setId(long paramLong)
  {
    this.id = paramLong;
  }

  public boolean isCustom()
  {
    return this.custom;
  }

  public void setCustom(boolean paramBoolean)
  {
    this.custom = paramBoolean;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DrugTherapyCheckResultVo
 * JD-Core Version:    0.6.2
 */