package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"doseRanges", "minMaxResults", "neonatalDoseRanges", "dispensableDrugName", "dispensableDrugDescription"})
@XmlRootElement(name="dosingInfo")
public class DosingInfo extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected List<DoseRanges> doseRanges;
  protected List<MinMaxResults> minMaxResults;
  protected List<NeonatalDoseRanges> neonatalDoseRanges;

  @XmlElement(required=true)
  protected String dispensableDrugName;

  @XmlElement(required=true)
  protected String dispensableDrugDescription;

  @XmlAttribute(name="gcnSeqNo", required=true)
  protected BigInteger gcnSeqNo;

  @XmlAttribute(name="fdbdx", required=true)
  protected String fdbdx;

  public List<DoseRanges> getDoseRanges()
  {
    if (this.doseRanges == null)
      this.doseRanges = new ArrayList();
    return this.doseRanges;
  }

  public boolean isSetDoseRanges()
  {
    return (this.doseRanges != null) && (!this.doseRanges.isEmpty());
  }

  public void unsetDoseRanges()
  {
    this.doseRanges = null;
  }

  public List<MinMaxResults> getMinMaxResults()
  {
    if (this.minMaxResults == null)
      this.minMaxResults = new ArrayList();
    return this.minMaxResults;
  }

  public boolean isSetMinMaxResults()
  {
    return (this.minMaxResults != null) && (!this.minMaxResults.isEmpty());
  }

  public void unsetMinMaxResults()
  {
    this.minMaxResults = null;
  }

  public List<NeonatalDoseRanges> getNeonatalDoseRanges()
  {
    if (this.neonatalDoseRanges == null)
      this.neonatalDoseRanges = new ArrayList();
    return this.neonatalDoseRanges;
  }

  public boolean isSetNeonatalDoseRanges()
  {
    return (this.neonatalDoseRanges != null) && (!this.neonatalDoseRanges.isEmpty());
  }

  public void unsetNeonatalDoseRanges()
  {
    this.neonatalDoseRanges = null;
  }

  public String getDispensableDrugName()
  {
    return this.dispensableDrugName;
  }

  public void setDispensableDrugName(String paramString)
  {
    this.dispensableDrugName = paramString;
  }

  public boolean isSetDispensableDrugName()
  {
    return this.dispensableDrugName != null;
  }

  public String getDispensableDrugDescription()
  {
    return this.dispensableDrugDescription;
  }

  public void setDispensableDrugDescription(String paramString)
  {
    this.dispensableDrugDescription = paramString;
  }

  public boolean isSetDispensableDrugDescription()
  {
    return this.dispensableDrugDescription != null;
  }

  public BigInteger getGcnSeqNo()
  {
    return this.gcnSeqNo;
  }

  public void setGcnSeqNo(BigInteger paramBigInteger)
  {
    this.gcnSeqNo = paramBigInteger;
  }

  public boolean isSetGcnSeqNo()
  {
    return this.gcnSeqNo != null;
  }

  public String getFdbdx()
  {
    return this.fdbdx;
  }

  public void setFdbdx(String paramString)
  {
    this.fdbdx = paramString;
  }

  public boolean isSetFdbdx()
  {
    return this.fdbdx != null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.DosingInfo
 * JD-Core Version:    0.6.2
 */