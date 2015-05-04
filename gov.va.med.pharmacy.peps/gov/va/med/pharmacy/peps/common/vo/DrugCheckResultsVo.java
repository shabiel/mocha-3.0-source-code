package gov.va.med.pharmacy.peps.common.vo;

import java.util.ArrayList;
import java.util.Collection;

public class DrugCheckResultsVo<T> extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Collection<DrugCheckMessageVo> messages = new ArrayList();
  private Collection<T> checks = new ArrayList();

  public final Collection<DrugCheckMessageVo> getMessages()
  {
    return this.messages;
  }

  public final void setMessages(Collection<DrugCheckMessageVo> paramCollection)
  {
    this.messages = paramCollection;
  }

  public final Collection<T> getChecks()
  {
    return this.checks;
  }

  public final void setChecks(Collection<T> paramCollection)
  {
    this.checks = paramCollection;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DrugCheckResultsVo
 * JD-Core Version:    0.6.2
 */