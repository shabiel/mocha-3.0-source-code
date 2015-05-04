package gov.va.med.pharmacy.peps.common.vo;

import java.util.ArrayList;
import java.util.Collection;

public class DrugDrugCheckResultVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Collection<DrugCheckVo> drugs = new ArrayList();
  private String severity = "";
  private String interactionDescription = "";
  private String shortText = "";
  private ProfessionalMonographVo professionalMonograph;
  private ConsumerMonographVo consumerMonograph;
  private long id;
  private boolean custom;

  public Collection<DrugCheckVo> getDrugs()
  {
    return this.drugs;
  }

  public void setDrugs(Collection<DrugCheckVo> paramCollection)
  {
    this.drugs = paramCollection;
  }

  public String getInteractionDescription()
  {
    return this.interactionDescription;
  }

  public void setInteractionDescription(String paramString)
  {
    this.interactionDescription = paramString;
  }

  public String getSeverity()
  {
    return this.severity;
  }

  public void setSeverity(String paramString)
  {
    this.severity = paramString;
  }

  public String getShortText()
  {
    return this.shortText;
  }

  public void setShortText(String paramString)
  {
    this.shortText = paramString;
  }

  public ProfessionalMonographVo getProfessionalMonograph()
  {
    return this.professionalMonograph;
  }

  public void setProfessionalMonograph(ProfessionalMonographVo paramProfessionalMonographVo)
  {
    this.professionalMonograph = paramProfessionalMonographVo;
  }

  public ConsumerMonographVo getConsumerMonograph()
  {
    return this.consumerMonograph;
  }

  public void setConsumerMonograph(ConsumerMonographVo paramConsumerMonographVo)
  {
    this.consumerMonograph = paramConsumerMonographVo;
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
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.DrugDrugCheckResultVo
 * JD-Core Version:    0.6.2
 */