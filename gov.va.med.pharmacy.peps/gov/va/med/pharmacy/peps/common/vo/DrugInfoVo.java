package gov.va.med.pharmacy.peps.common.vo;

import java.util.ArrayList;
import java.util.Collection;

public class DrugInfoVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private String gcnSeqNo = "";
  private String strengthUnit = "";
  private Collection<DoseRouteVo> doseRoutes = new ArrayList();
  private Collection<DoseTypeVo> doseTypes = new ArrayList();

  public String getGcnSeqNo()
  {
    return this.gcnSeqNo;
  }

  public void setGcnSeqNo(String paramString)
  {
    this.gcnSeqNo = paramString;
  }

  public Collection<DoseRouteVo> getDoseRoutes()
  {
    return this.doseRoutes;
  }

  public void setDoseRoutes(Collection<DoseRouteVo> paramCollection)
  {
    this.doseRoutes = paramCollection;
  }

  public Collection<DoseTypeVo> getDoseTypes()
  {
    return this.doseTypes;
  }

  public void setDoseTypes(Collection<DoseTypeVo> paramCollection)
  {
    this.doseTypes = paramCollection;
  }

  public String getStrengthUnit()
  {
    return this.strengthUnit;
  }

  public void setStrengthUnit(String paramString)
  {
    this.strengthUnit = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DrugInfoVo
 * JD-Core Version:    0.6.2
 */