package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="")
@XmlRootElement(name="PEPSVersion")
public class PEPSVersion extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlAttribute(name="difDbVersion", required=true)
  protected String difDbVersion;

  @XmlAttribute(name="difBuildVersion", required=true)
  protected String difBuildVersion;

  @XmlAttribute(name="difIssueDate", required=true)
  protected String difIssueDate;

  @XmlAttribute(name="customDbVersion", required=true)
  protected String customDbVersion;

  @XmlAttribute(name="customBuildVersion", required=true)
  protected String customBuildVersion;

  @XmlAttribute(name="customIssueDate", required=true)
  protected String customIssueDate;

  public String getDifDbVersion()
  {
    return this.difDbVersion;
  }

  public void setDifDbVersion(String paramString)
  {
    this.difDbVersion = paramString;
  }

  public boolean isSetDifDbVersion()
  {
    return this.difDbVersion != null;
  }

  public String getDifBuildVersion()
  {
    return this.difBuildVersion;
  }

  public void setDifBuildVersion(String paramString)
  {
    this.difBuildVersion = paramString;
  }

  public boolean isSetDifBuildVersion()
  {
    return this.difBuildVersion != null;
  }

  public String getDifIssueDate()
  {
    return this.difIssueDate;
  }

  public void setDifIssueDate(String paramString)
  {
    this.difIssueDate = paramString;
  }

  public boolean isSetDifIssueDate()
  {
    return this.difIssueDate != null;
  }

  public String getCustomDbVersion()
  {
    return this.customDbVersion;
  }

  public void setCustomDbVersion(String paramString)
  {
    this.customDbVersion = paramString;
  }

  public boolean isSetCustomDbVersion()
  {
    return this.customDbVersion != null;
  }

  public String getCustomBuildVersion()
  {
    return this.customBuildVersion;
  }

  public void setCustomBuildVersion(String paramString)
  {
    this.customBuildVersion = paramString;
  }

  public boolean isSetCustomBuildVersion()
  {
    return this.customBuildVersion != null;
  }

  public String getCustomIssueDate()
  {
    return this.customIssueDate;
  }

  public void setCustomIssueDate(String paramString)
  {
    this.customIssueDate = paramString;
  }

  public boolean isSetCustomIssueDate()
  {
    return this.customIssueDate != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.PEPSVersion
 * JD-Core Version:    0.6.2
 */