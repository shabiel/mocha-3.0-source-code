package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"monographSource", "disclaimer", "monographTitle", "severityLevel", "mechanismOfAction", "clinicalEffects", "predisposingFactors", "patientManagement", "discussion", "references"})
@XmlRootElement(name="professionalMonograph")
public class ProfessionalMonograph extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  @XmlSchemaType(name="string")
  protected SourceType monographSource;

  @XmlElement(required=true)
  protected String disclaimer;

  @XmlElement(required=true)
  protected String monographTitle;

  @XmlElement(required=true)
  protected String severityLevel;

  @XmlElement(required=true)
  protected String mechanismOfAction;

  @XmlElement(required=true)
  protected String clinicalEffects;

  @XmlElement(required=true)
  protected String predisposingFactors;

  @XmlElement(required=true)
  protected String patientManagement;

  @XmlElement(required=true)
  protected String discussion;

  @XmlElement(required=true)
  protected ReferencesType references;

  public SourceType getMonographSource()
  {
    return this.monographSource;
  }

  public void setMonographSource(SourceType paramSourceType)
  {
    this.monographSource = paramSourceType;
  }

  public boolean isSetMonographSource()
  {
    return this.monographSource != null;
  }

  public String getDisclaimer()
  {
    return this.disclaimer;
  }

  public void setDisclaimer(String paramString)
  {
    this.disclaimer = paramString;
  }

  public boolean isSetDisclaimer()
  {
    return this.disclaimer != null;
  }

  public String getMonographTitle()
  {
    return this.monographTitle;
  }

  public void setMonographTitle(String paramString)
  {
    this.monographTitle = paramString;
  }

  public boolean isSetMonographTitle()
  {
    return this.monographTitle != null;
  }

  public String getSeverityLevel()
  {
    return this.severityLevel;
  }

  public void setSeverityLevel(String paramString)
  {
    this.severityLevel = paramString;
  }

  public boolean isSetSeverityLevel()
  {
    return this.severityLevel != null;
  }

  public String getMechanismOfAction()
  {
    return this.mechanismOfAction;
  }

  public void setMechanismOfAction(String paramString)
  {
    this.mechanismOfAction = paramString;
  }

  public boolean isSetMechanismOfAction()
  {
    return this.mechanismOfAction != null;
  }

  public String getClinicalEffects()
  {
    return this.clinicalEffects;
  }

  public void setClinicalEffects(String paramString)
  {
    this.clinicalEffects = paramString;
  }

  public boolean isSetClinicalEffects()
  {
    return this.clinicalEffects != null;
  }

  public String getPredisposingFactors()
  {
    return this.predisposingFactors;
  }

  public void setPredisposingFactors(String paramString)
  {
    this.predisposingFactors = paramString;
  }

  public boolean isSetPredisposingFactors()
  {
    return this.predisposingFactors != null;
  }

  public String getPatientManagement()
  {
    return this.patientManagement;
  }

  public void setPatientManagement(String paramString)
  {
    this.patientManagement = paramString;
  }

  public boolean isSetPatientManagement()
  {
    return this.patientManagement != null;
  }

  public String getDiscussion()
  {
    return this.discussion;
  }

  public void setDiscussion(String paramString)
  {
    this.discussion = paramString;
  }

  public boolean isSetDiscussion()
  {
    return this.discussion != null;
  }

  public ReferencesType getReferences()
  {
    return this.references;
  }

  public void setReferences(ReferencesType paramReferencesType)
  {
    this.references = paramReferencesType;
  }

  public boolean isSetReferences()
  {
    return this.references != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.ProfessionalMonograph
 * JD-Core Version:    0.6.2
 */