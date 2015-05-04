package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="calculatedDose", propOrder={"databaseValue", "doseValue", "percentError", "unitOfMeasure"})
public class CalculatedDose extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  protected String databaseValue;

  @XmlElement(required=true)
  protected String doseValue;

  @XmlElement(required=true)
  protected String percentError;

  @XmlElement(required=true)
  protected String unitOfMeasure;

  public String getDatabaseValue()
  {
    return this.databaseValue;
  }

  public void setDatabaseValue(String paramString)
  {
    this.databaseValue = paramString;
  }

  public boolean isSetDatabaseValue()
  {
    return this.databaseValue != null;
  }

  public String getDoseValue()
  {
    return this.doseValue;
  }

  public void setDoseValue(String paramString)
  {
    this.doseValue = paramString;
  }

  public boolean isSetDoseValue()
  {
    return this.doseValue != null;
  }

  public String getPercentError()
  {
    return this.percentError;
  }

  public void setPercentError(String paramString)
  {
    this.percentError = paramString;
  }

  public boolean isSetPercentError()
  {
    return this.percentError != null;
  }

  public String getUnitOfMeasure()
  {
    return this.unitOfMeasure;
  }

  public void setUnitOfMeasure(String paramString)
  {
    this.unitOfMeasure = paramString;
  }

  public boolean isSetUnitOfMeasure()
  {
    return this.unitOfMeasure != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.CalculatedDose
 * JD-Core Version:    0.6.2
 */