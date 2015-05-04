package gov.va.med.pharmacy.peps.common.vo;

import java.util.ArrayList;
import java.util.List;

public class ConsumerMonographVo extends ValueObject
{
  public static final String MONOGRAPH_TYPE = "FDB-CE";
  public static final String DISCLAIMER_SECTION = "Z";
  public static final String TITLE_SECTION = "T";
  public static final String MEDICAL_WARNING_SECTION = "L";
  public static final String HOW_OCCURS_SECTION = "A";
  public static final String WHAT_MIGHT_HAPPEN_SECTION = "E";
  public static final String WHAT_TO_DO_SECTION = "M";
  public static final String REFERENCE_SECTION = "R";
  private static final long serialVersionUID = 1L;
  private boolean fdbMonographSourceType = true;
  private String disclaimer = "";
  private String monographTitle = "";
  private String medicalWarning = "";
  private String howOccurs = "";
  private String whatMightHappen = "";
  private String whatToDo = "";
  private List<String> references = new ArrayList();

  public final String getDisclaimer()
  {
    return this.disclaimer;
  }

  public final void setDisclaimer(String paramString)
  {
    this.disclaimer = paramString;
  }

  public final String getMonographTitle()
  {
    return this.monographTitle;
  }

  public final void setMonographTitle(String paramString)
  {
    this.monographTitle = paramString;
  }

  public final String getMedicalWarning()
  {
    return this.medicalWarning;
  }

  public final void setMedicalWarning(String paramString)
  {
    this.medicalWarning = paramString;
  }

  public final String getHowOccurs()
  {
    return this.howOccurs;
  }

  public final void setHowOccurs(String paramString)
  {
    this.howOccurs = paramString;
  }

  public final String getWhatMightHappen()
  {
    return this.whatMightHappen;
  }

  public final void setWhatMightHappen(String paramString)
  {
    this.whatMightHappen = paramString;
  }

  public final String getWhatToDo()
  {
    return this.whatToDo;
  }

  public final void setWhatToDo(String paramString)
  {
    this.whatToDo = paramString;
  }

  public final List<String> getReferences()
  {
    return this.references;
  }

  public final void setReferences(List<String> paramList)
  {
    this.references = paramList;
  }

  public final boolean isFdbMonographSourceType()
  {
    return this.fdbMonographSourceType;
  }

  public final void setFdbMonographSourceType(boolean paramBoolean)
  {
    this.fdbMonographSourceType = paramBoolean;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.ConsumerMonographVo
 * JD-Core Version:    0.6.2
 */