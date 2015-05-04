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
@XmlType(name="", propOrder={"id", "source", "interactedDrugList", "classification", "duplicateAllowance", "shortText"})
@XmlRootElement(name="drugTherapyCheck")
public class DrugTherapyCheck extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  protected String id;

  @XmlElement(required=true)
  @XmlSchemaType(name="string")
  protected SourceType source;

  @XmlElement(required=true)
  protected InteractedDrugList interactedDrugList;

  @XmlElement(required=true)
  protected String classification;
  protected long duplicateAllowance;

  @XmlElement(required=true)
  protected String shortText;

  public String getId()
  {
    return this.id;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public boolean isSetId()
  {
    return this.id != null;
  }

  public SourceType getSource()
  {
    return this.source;
  }

  public void setSource(SourceType paramSourceType)
  {
    this.source = paramSourceType;
  }

  public boolean isSetSource()
  {
    return this.source != null;
  }

  public InteractedDrugList getInteractedDrugList()
  {
    return this.interactedDrugList;
  }

  public void setInteractedDrugList(InteractedDrugList paramInteractedDrugList)
  {
    this.interactedDrugList = paramInteractedDrugList;
  }

  public boolean isSetInteractedDrugList()
  {
    return this.interactedDrugList != null;
  }

  public String getClassification()
  {
    return this.classification;
  }

  public void setClassification(String paramString)
  {
    this.classification = paramString;
  }

  public boolean isSetClassification()
  {
    return this.classification != null;
  }

  public long getDuplicateAllowance()
  {
    return this.duplicateAllowance;
  }

  public void setDuplicateAllowance(long paramLong)
  {
    this.duplicateAllowance = paramLong;
  }

  public boolean isSetDuplicateAllowance()
  {
    return true;
  }

  public String getShortText()
  {
    return this.shortText;
  }

  public void setShortText(String paramString)
  {
    this.shortText = paramString;
  }

  public boolean isSetShortText()
  {
    return this.shortText != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugTherapyCheck
 * JD-Core Version:    0.6.2
 */