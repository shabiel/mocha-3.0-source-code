package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl;

import firstdatabank.database.FDBSQLException;
import firstdatabank.dif.DTScreenDrugItem;
import firstdatabank.dif.DTScreenDrugItems;
import firstdatabank.dif.DTScreenResult;
import firstdatabank.dif.DTScreenResults;
import firstdatabank.dif.FDBAllowanceSource;
import firstdatabank.dif.FDBDuplicateAllowance;
import firstdatabank.dif.ScreenDrug;
import firstdatabank.dif.ScreenDrugs;
import firstdatabank.dif.Screening;
import gov.va.med.pharmacy.peps.common.exception.InterfaceException;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckVo;
import gov.va.med.pharmacy.peps.common.vo.DrugTherapyCheckResultVo;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.PerformDrugTherapyCheckCapability;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.MessageConversionUtility;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.StringUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class PerformDrugTherapyCheckCapabilityImpl
  implements PerformDrugTherapyCheckCapability
{
  private Screening screening;

  public final DrugCheckResultsVo<DrugTherapyCheckResultVo> performDrugTherapyCheck(ScreenDrugs paramScreenDrugs, Map<String, DrugCheckVo> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    FDBDuplicateAllowance localFDBDuplicateAllowance = FDBDuplicateAllowance.fdbDADoNotUse;
    String str = "";
    if (paramBoolean2)
    {
      localFDBDuplicateAllowance = FDBDuplicateAllowance.fdbDAFDBOnly;
      if (paramBoolean3)
        localFDBDuplicateAllowance = FDBDuplicateAllowance.fdbDACustomWithFDBDefault;
    }
    if (paramBoolean3)
      str = "VA";
    try
    {
      DTScreenResults localDTScreenResults = this.screening.DTScreen(paramScreenDrugs, paramBoolean1, localFDBDuplicateAllowance, paramBoolean3, str);
      return convertResults(localDTScreenResults, paramScreenDrugs, paramMap);
    }
    catch (FDBSQLException localFDBSQLException)
    {
      throw new InterfaceException(localFDBSQLException, InterfaceException.INTERFACE_ERROR, new Object[] { "Drug Data Vendor" });
    }
  }

  private DrugCheckResultsVo<DrugTherapyCheckResultVo> convertResults(DTScreenResults paramDTScreenResults, ScreenDrugs paramScreenDrugs, Map<String, DrugCheckVo> paramMap)
  {
    DrugCheckResultsVo localDrugCheckResultsVo = new DrugCheckResultsVo();
    Collection localCollection = MessageConversionUtility.toDrugCheckMessages(paramDTScreenResults.getMessages(), paramMap, paramScreenDrugs);
    localDrugCheckResultsVo.setMessages(localCollection);
    localDrugCheckResultsVo.setChecks(new ArrayList(paramDTScreenResults.count()));
    for (int i = 0; i < paramDTScreenResults.count(); i++)
    {
      DTScreenResult localDTScreenResult = paramDTScreenResults.item(i);
      DrugTherapyCheckResultVo localDrugTherapyCheckResultVo = new DrugTherapyCheckResultVo();
      localDrugTherapyCheckResultVo.setId(localDTScreenResult.getClassID());
      localDrugTherapyCheckResultVo.setCustom(FDBAllowanceSource.fdbASCustom.equals(localDTScreenResult.getAllowanceSource()));
      localDrugTherapyCheckResultVo.setDuplicateClass(StringUtility.nullToEmptyString(localDTScreenResult.getClassDescription()));
      if (FDBAllowanceSource.fdbASCustom.equals(localDTScreenResult.getAllowanceSource()))
        localDrugTherapyCheckResultVo.setAllowance(localDTScreenResult.getCustomAllowance());
      else
        localDrugTherapyCheckResultVo.setAllowance(localDTScreenResult.getAllowance());
      localDrugTherapyCheckResultVo.setDrugs(new ArrayList(localDTScreenResult.getDrugItems().count()));
      for (int j = 0; j < localDTScreenResult.getDrugItems().count(); j++)
      {
        DrugCheckVo localDrugCheckVo = (DrugCheckVo)paramMap.get(paramScreenDrugs.get(localDTScreenResult.getDrugItems().item(j).getDrugIndex()).getCustomID());
        localDrugTherapyCheckResultVo.getDrugs().add(localDrugCheckVo);
      }
      localDrugTherapyCheckResultVo.setShortText(StringUtility.nullToEmptyString(localDTScreenResult.getScreenMessage()));
      localDrugCheckResultsVo.getChecks().add(localDrugTherapyCheckResultVo);
    }
    return localDrugCheckResultsVo;
  }

  public final void setScreening(Screening paramScreening)
  {
    this.screening = paramScreening;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl.PerformDrugTherapyCheckCapabilityImpl
 * JD-Core Version:    0.6.2
 */