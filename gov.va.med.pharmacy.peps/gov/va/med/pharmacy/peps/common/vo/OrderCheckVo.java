package gov.va.med.pharmacy.peps.common.vo;

import java.util.ArrayList;
import java.util.Collection;

public class OrderCheckVo extends ValueObject
{
  private static final long serialVersionUID = 1L;
  private boolean prospectiveOnly;
  private boolean drugDrugCheck;
  private boolean drugTherapyCheck;
  private boolean drugDoseCheck;
  private Collection<DrugCheckVo> drugsToScreen = new ArrayList();
  private long ageInDays;
  private double bodySurfaceAreaInSqM;
  private double weightInKg;
  private boolean duplicateAllowance;
  private OrderCheckHeaderVo header;
  private boolean customTables;

  public long getAgeInDays()
  {
    return this.ageInDays;
  }

  public void setAgeInDays(long paramLong)
  {
    this.ageInDays = paramLong;
  }

  public double getBodySurfaceAreaInSqM()
  {
    return this.bodySurfaceAreaInSqM;
  }

  public void setBodySurfaceAreaInSqM(double paramDouble)
  {
    this.bodySurfaceAreaInSqM = paramDouble;
  }

  public boolean isDrugDoseCheck()
  {
    return this.drugDoseCheck;
  }

  public void setDrugDoseCheck(boolean paramBoolean)
  {
    this.drugDoseCheck = paramBoolean;
  }

  public boolean isDrugDrugCheck()
  {
    return this.drugDrugCheck;
  }

  public void setDrugDrugCheck(boolean paramBoolean)
  {
    this.drugDrugCheck = paramBoolean;
  }

  public boolean isProspectiveOnly()
  {
    return this.prospectiveOnly;
  }

  public void setProspectiveOnly(boolean paramBoolean)
  {
    this.prospectiveOnly = paramBoolean;
  }

  public boolean isDrugTherapyCheck()
  {
    return this.drugTherapyCheck;
  }

  public void setDrugTherapyCheck(boolean paramBoolean)
  {
    this.drugTherapyCheck = paramBoolean;
  }

  public double getWeightInKg()
  {
    return this.weightInKg;
  }

  public void setWeightInKg(double paramDouble)
  {
    this.weightInKg = paramDouble;
  }

  public Collection<DrugCheckVo> getDrugsToScreen()
  {
    return this.drugsToScreen;
  }

  public boolean hasDrugsToScreen()
  {
    return (this.drugsToScreen != null) && (!this.drugsToScreen.isEmpty());
  }

  public void setDrugsToScreen(Collection<DrugCheckVo> paramCollection)
  {
    this.drugsToScreen = paramCollection;
  }

  public boolean isDuplicateAllowance()
  {
    return this.duplicateAllowance;
  }

  public void setDuplicateAllowance(boolean paramBoolean)
  {
    this.duplicateAllowance = paramBoolean;
  }

  public OrderCheckHeaderVo getHeader()
  {
    return this.header;
  }

  public void setHeader(OrderCheckHeaderVo paramOrderCheckHeaderVo)
  {
    this.header = paramOrderCheckHeaderVo;
  }

  public boolean isCustomTables()
  {
    return this.customTables;
  }

  public void setCustomTables(boolean paramBoolean)
  {
    this.customTables = paramBoolean;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.OrderCheckVo
 * JD-Core Version:    0.6.2
 */