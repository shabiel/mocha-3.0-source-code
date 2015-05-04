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
@XmlType(name="", propOrder={"monographSource", "disclaimer", "monographTitle", "medicalWarning", "howOccurs", "whatMightHappen", "whatToDo", "references"})
@XmlRootElement(name="consumerMonograph")
public class ConsumerMonograph extends ValueObject
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
  protected String medicalWarning;

  @XmlElement(required=true)
  protected String howOccurs;

  @XmlElement(required=true)
  protected String whatMightHappen;

  @XmlElement(required=true)
  protected String whatToDo;

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

  public String getMedicalWarning()
  {
    return this.medicalWarning;
  }

  public void setMedicalWarning(String paramString)
  {
    this.medicalWarning = paramString;
  }

  public boolean isSetMedicalWarning()
  {
    return this.medicalWarning != null;
  }

  public String getHowOccurs()
  {
    return this.howOccurs;
  }

  public void setHowOccurs(String paramString)
  {
    this.howOccurs = paramString;
  }

  public boolean isSetHowOccurs()
  {
    return this.howOccurs != null;
  }

  public String getWhatMightHappen()
  {
    return this.whatMightHappen;
  }

  public void setWhatMightHappen(String paramString)
  {
    this.whatMightHappen = paramString;
  }

  public boolean isSetWhatMightHappen()
  {
    return this.whatMightHappen != null;
  }

  public String getWhatToDo()
  {
    return this.whatToDo;
  }

  public void setWhatToDo(String paramString)
  {
    this.whatToDo = paramString;
  }

  public boolean isSetWhatToDo()
  {
    return this.whatToDo != null;
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
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.ConsumerMonograph
 * JD-Core Version:    0.6.2
 */