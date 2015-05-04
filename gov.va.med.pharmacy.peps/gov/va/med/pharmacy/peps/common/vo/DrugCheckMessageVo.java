package gov.va.med.pharmacy.peps.common.vo;

public class DrugCheckMessageVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private DrugCheckVo drug;
  private String severity = "";
  private String type = "";
  private String drugName = "";
  private String text = "";

  public final DrugCheckVo getDrug()
  {
    return this.drug;
  }

  public final void setDrug(DrugCheckVo paramDrugCheckVo)
  {
    this.drug = paramDrugCheckVo;
  }

  public final String getSeverity()
  {
    return this.severity;
  }

  public final void setSeverity(String paramString)
  {
    this.severity = paramString;
  }

  public final String getType()
  {
    return this.type;
  }

  public final void setType(String paramString)
  {
    this.type = paramString;
  }

  public final String getDrugName()
  {
    return this.drugName;
  }

  public final void setDrugName(String paramString)
  {
    this.drugName = paramString;
  }

  public final String getText()
  {
    return this.text;
  }

  public final void setText(String paramString)
  {
    this.text = paramString;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DrugCheckMessageVo
 * JD-Core Version:    0.6.2
 */