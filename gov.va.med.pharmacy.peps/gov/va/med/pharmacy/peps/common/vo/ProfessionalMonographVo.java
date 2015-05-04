package gov.va.med.pharmacy.peps.common.vo;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalMonographVo extends ValueObject
{
  public static final String MONOGRAPH_TYPE = "FDB-PE";
  public static final String DISCLAIMER_SECTION = "Z";
  public static final String TITLE_SECTION = "T";
  public static final String SEVERITY_SECTION = "L";
  public static final String MECHANISM_SECTION = "A";
  public static final String CLINICAL_SECTION = "E";
  public static final String PREDISPOSING_SECTION = "P";
  public static final String PATIENT_SECTION = "M";
  public static final String DISCUSSION_SECTION = "D";
  public static final String REFERENCES_SECTION = "R";
  private static final long serialVersionUID = 1L;
  private boolean fdbMonographSourceType = true;
  private String disclaimer = "";
  private String monographTitle = "";
  private String severityLevel = "";
  private String mechanismOfAction = "";
  private String clinicalEffects = "";
  private String predisposingFactors = "";
  private String patientManagement = "";
  private String discussion = "";
  private List<String> references = new ArrayList();

  public String getDisclaimer()
  {
    return this.disclaimer;
  }

  public void setDisclaimer(String paramString)
  {
    this.disclaimer = paramString;
  }

  public String getMonographTitle()
  {
    return this.monographTitle;
  }

  public void setMonographTitle(String paramString)
  {
    this.monographTitle = paramString;
  }

  public String getSeverityLevel()
  {
    return this.severityLevel;
  }

  public void setSeverityLevel(String paramString)
  {
    this.severityLevel = paramString;
  }

  public String getMechanismOfAction()
  {
    return this.mechanismOfAction;
  }

  public void setMechanismOfAction(String paramString)
  {
    this.mechanismOfAction = paramString;
  }

  public String getClinicalEffects()
  {
    return this.clinicalEffects;
  }

  public void setClinicalEffects(String paramString)
  {
    this.clinicalEffects = paramString;
  }

  public String getPredisposingFactors()
  {
    return this.predisposingFactors;
  }

  public void setPredisposingFactors(String paramString)
  {
    this.predisposingFactors = paramString;
  }

  public String getPatientManagement()
  {
    return this.patientManagement;
  }

  public void setPatientManagement(String paramString)
  {
    this.patientManagement = paramString;
  }

  public String getDiscussion()
  {
    return this.discussion;
  }

  public void setDiscussion(String paramString)
  {
    this.discussion = paramString;
  }

  public List<String> getReferences()
  {
    return this.references;
  }

  public void setReferences(List<String> paramList)
  {
    this.references = paramList;
  }

  public boolean isFdbMonographSourceType()
  {
    return this.fdbMonographSourceType;
  }

  public void setFdbMonographSourceType(boolean paramBoolean)
  {
    this.fdbMonographSourceType = paramBoolean;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.ProfessionalMonographVo
 * JD-Core Version:    0.6.2
 */