package gov.va.med.pharmacy.peps.common.vo;

import java.util.Collection;
import java.util.HashSet;

public class OrderCheckResultsVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private Collection<DrugCheckVo> drugsNotChecked = new HashSet();
  private DrugCheckResultsVo<DrugDrugCheckResultVo> drugDrugCheckResults;
  private DrugCheckResultsVo<DrugDoseCheckResultVo> drugDoseCheckResults;
  private DrugCheckResultsVo<DrugTherapyCheckResultVo> drugTherapyCheckResults;
  private OrderCheckHeaderVo header;
  private DrugDataVendorVersionVo drugDataVendorVersion;

  public DrugCheckResultsVo<DrugDoseCheckResultVo> getDrugDoseCheckResults()
  {
    return this.drugDoseCheckResults;
  }

  public void setDrugDoseCheckResults(DrugCheckResultsVo<DrugDoseCheckResultVo> paramDrugCheckResultsVo)
  {
    this.drugDoseCheckResults = paramDrugCheckResultsVo;
  }

  public DrugCheckResultsVo<DrugDrugCheckResultVo> getDrugDrugCheckResults()
  {
    return this.drugDrugCheckResults;
  }

  public void setDrugDrugCheckResults(DrugCheckResultsVo<DrugDrugCheckResultVo> paramDrugCheckResultsVo)
  {
    this.drugDrugCheckResults = paramDrugCheckResultsVo;
  }

  public Collection<DrugCheckVo> getDrugsNotChecked()
  {
    return this.drugsNotChecked;
  }

  public void setDrugsNotChecked(Collection<DrugCheckVo> paramCollection)
  {
    this.drugsNotChecked = paramCollection;
  }

  public DrugCheckResultsVo<DrugTherapyCheckResultVo> getDrugTherapyCheckResults()
  {
    return this.drugTherapyCheckResults;
  }

  public void setDrugTherapyCheckResults(DrugCheckResultsVo<DrugTherapyCheckResultVo> paramDrugCheckResultsVo)
  {
    this.drugTherapyCheckResults = paramDrugCheckResultsVo;
  }

  public DrugDataVendorVersionVo getDrugDataVendorVersion()
  {
    return this.drugDataVendorVersion;
  }

  public void setDrugDataVendorVersion(DrugDataVendorVersionVo paramDrugDataVendorVersionVo)
  {
    this.drugDataVendorVersion = paramDrugDataVendorVersionVo;
  }

  public OrderCheckHeaderVo getHeader()
  {
    return this.header;
  }

  public void setHeader(OrderCheckHeaderVo paramOrderCheckHeaderVo)
  {
    this.header = paramOrderCheckHeaderVo;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.OrderCheckResultsVo
 * JD-Core Version:    0.6.2
 */