package gov.va.med.pharmacy.peps.common.vo;

import java.util.ArrayList;
import java.util.Collection;

public class DrugInfoResultsVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Collection<DrugInfoVo> drugsNotFound = new ArrayList();
  private Collection<DrugInfoVo> drugs = new ArrayList();

  public Collection<DrugInfoVo> getDrugsNotFound()
  {
    return this.drugsNotFound;
  }

  public void setDrugsNotFound(Collection<DrugInfoVo> paramCollection)
  {
    this.drugsNotFound = paramCollection;
  }

  public Collection<DrugInfoVo> getDrugs()
  {
    return this.drugs;
  }

  public void setDrugs(Collection<DrugInfoVo> paramCollection)
  {
    this.drugs = paramCollection;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DrugInfoResultsVo
 * JD-Core Version:    0.6.2
 */