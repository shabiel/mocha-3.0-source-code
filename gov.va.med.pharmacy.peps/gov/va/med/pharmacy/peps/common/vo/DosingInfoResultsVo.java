package gov.va.med.pharmacy.peps.common.vo;

import java.util.ArrayList;
import java.util.Collection;

public class DosingInfoResultsVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Collection<DosingInfoVo> dosingInfo = new ArrayList();
  private Collection<DosingNotFoundVo> dosingNotFound = new ArrayList();

  public final Collection<DosingInfoVo> getDosingInfo()
  {
    return this.dosingInfo;
  }

  public final void setDosingInfo(Collection<DosingInfoVo> paramCollection)
  {
    this.dosingInfo = paramCollection;
  }

  public final Collection<DosingNotFoundVo> getDosingNotFound()
  {
    return this.dosingNotFound;
  }

  public final void setDosingNotFound(Collection<DosingNotFoundVo> paramCollection)
  {
    this.dosingNotFound = paramCollection;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DosingInfoResultsVo
 * JD-Core Version:    0.6.2
 */