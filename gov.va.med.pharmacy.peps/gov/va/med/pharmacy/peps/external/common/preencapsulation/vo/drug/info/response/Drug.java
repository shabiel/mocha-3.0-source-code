package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"routes", "doseTypes", "strengthUnit"})
@XmlRootElement(name="drug")
public class Drug extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Routes routes;
  protected DoseTypes doseTypes;
  protected String strengthUnit;

  @XmlAttribute(name="gcnSeqNo", required=true)
  protected BigInteger gcnSeqNo;

  public Routes getRoutes()
  {
    return this.routes;
  }

  public void setRoutes(Routes paramRoutes)
  {
    this.routes = paramRoutes;
  }

  public boolean isSetRoutes()
  {
    return this.routes != null;
  }

  public DoseTypes getDoseTypes()
  {
    return this.doseTypes;
  }

  public void setDoseTypes(DoseTypes paramDoseTypes)
  {
    this.doseTypes = paramDoseTypes;
  }

  public boolean isSetDoseTypes()
  {
    return this.doseTypes != null;
  }

  public String getStrengthUnit()
  {
    return this.strengthUnit;
  }

  public void setStrengthUnit(String paramString)
  {
    this.strengthUnit = paramString;
  }

  public boolean isSetStrengthUnit()
  {
    return this.strengthUnit != null;
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
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.Drug
 * JD-Core Version:    0.6.2
 */