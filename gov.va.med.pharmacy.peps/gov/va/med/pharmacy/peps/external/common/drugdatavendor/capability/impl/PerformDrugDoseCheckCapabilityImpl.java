package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl;

import firstdatabank.database.FDBDataManager;
import firstdatabank.database.FDBException;
import firstdatabank.dif.CalculatedDoseValue;
import firstdatabank.dif.Classification;
import firstdatabank.dif.Classifications;
import firstdatabank.dif.DOSEScreenResult;
import firstdatabank.dif.DOSEScreenResults;
import firstdatabank.dif.DRCLookupResult;
import firstdatabank.dif.DispensableGeneric;
import firstdatabank.dif.DoseRoute;
import firstdatabank.dif.DoseRoutes;
import firstdatabank.dif.FDBClassificationsType;
import firstdatabank.dif.FDBDOSESource;
import firstdatabank.dif.FDBDOSEStatus;
import firstdatabank.dif.ScreenDrug;
import firstdatabank.dif.ScreenDrugs;
import firstdatabank.dif.Screening;
import gov.va.med.pharmacy.peps.common.exception.InterfaceException;
import gov.va.med.pharmacy.peps.common.utility.PropertyUtility;
import gov.va.med.pharmacy.peps.common.vo.CalculatedDoseVo;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckVo;
import gov.va.med.pharmacy.peps.common.vo.DrugDoseCheckResultVo;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.PerformDrugDoseCheckCapability;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.DoseStatusUtility;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.MessageConversionUtility;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.StringUtility;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class PerformDrugDoseCheckCapabilityImpl
  implements PerformDrugDoseCheckCapability
{
  private static final Logger LOG = Logger.getLogger(PerformDrugDoseCheckCapabilityImpl.class);
  private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.#####");
  private static final int MAX_DECIMALS = 5;
  private static final String ORAL_ROUTE_PROPERTY = "ORAL_ROUTE_ID";
  private static final String TOPICAL_ROUTE_PROPERTY = "TOPICAL_ROUTE_ID";
  private static final String ANTINEOPLASTICS_CLASS_PROPERTY = "ANTINEOPLASTICS_CLASS_ID";
  private static final String ORAL_ROUTE_ID = PropertyUtility.getProperty(PerformDrugDoseCheckCapabilityImpl.class, "ORAL_ROUTE_ID");
  private static final String TOPICAL_ROUTE_ID = PropertyUtility.getProperty(PerformDrugDoseCheckCapabilityImpl.class, "TOPICAL_ROUTE_ID");
  private static final String ANTINEOPLASTICS_CLASS_ID = PropertyUtility.getProperty(PerformDrugDoseCheckCapabilityImpl.class, "ANTINEOPLASTICS_CLASS_ID");
  private Screening screening;
  private FDBDataManager fdbDataManager;

  public PerformDrugDoseCheckCapabilityImpl()
  {
    DECIMAL_FORMAT.setMaximumFractionDigits(5);
  }

  public final DrugCheckResultsVo<DrugDoseCheckResultVo> performDrugDoseCheck(ScreenDrugs paramScreenDrugs, Map<String, DrugCheckVo> paramMap, boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2)
  {
    FDBDOSESource localFDBDOSESource;
    String str;
    if (paramBoolean2)
    {
      localFDBDOSESource = FDBDOSESource.fdbDSCustomDRCAndMinMax;
      str = "VA";
    }
    else
    {
      localFDBDOSESource = FDBDOSESource.fdbDSDRCAndMinMax;
      str = "";
    }
    try
    {
      DOSEScreenResults localDOSEScreenResults = this.screening.DOSEScreen(paramScreenDrugs, paramBoolean1, paramLong, paramDouble1, paramDouble2, localFDBDOSESource, str);
      return convertResults(localDOSEScreenResults, paramScreenDrugs, paramMap);
    }
    catch (FDBException localFDBException)
    {
      throw new InterfaceException(localFDBException, InterfaceException.INTERFACE_ERROR, new Object[] { "Drug Data Vendor" });
    }
  }

  private DrugCheckResultsVo<DrugDoseCheckResultVo> convertResults(DOSEScreenResults paramDOSEScreenResults, ScreenDrugs paramScreenDrugs, Map<String, DrugCheckVo> paramMap)
    throws FDBException
  {
    DrugCheckResultsVo localDrugCheckResultsVo = new DrugCheckResultsVo();
    localDrugCheckResultsVo.setMessages(MessageConversionUtility.toDrugCheckMessages(paramDOSEScreenResults.getMessages(), paramMap, paramScreenDrugs));
    localDrugCheckResultsVo.setChecks(new ArrayList(paramDOSEScreenResults.count()));
    for (int i = 0; i < paramDOSEScreenResults.count(); i++)
    {
      DOSEScreenResult localDOSEScreenResult = paramDOSEScreenResults.item(i);
      DrugDoseCheckResultVo localDrugDoseCheckResultVo = new DrugDoseCheckResultVo();
      localDrugDoseCheckResultVo.setCustom(FDBDOSESource.fdbDSCustom.equals(localDOSEScreenResult.getDoseSource()));
      localDrugDoseCheckResultVo.setDrug((DrugCheckVo)paramMap.get(paramScreenDrugs.get(localDOSEScreenResult.getDrugIndex()).getCustomID()));
      setChemoInjectable(localDrugDoseCheckResultVo);
      localDrugDoseCheckResultVo.setRangeDoseHigh(DECIMAL_FORMAT.format(localDOSEScreenResult.doseRecord().getDoseHigh()));
      if (StringUtils.isNotBlank(localDOSEScreenResult.getDoseRecord().getDoseHighUnit()))
        localDrugDoseCheckResultVo.setRangeDoseHigh(localDrugDoseCheckResultVo.getRangeDoseHigh() + " " + localDOSEScreenResult.doseRecord().getDoseHighUnit().trim());
      localDrugDoseCheckResultVo.setRangeDoseLow(DECIMAL_FORMAT.format(localDOSEScreenResult.doseRecord().getDoseLow()));
      if (StringUtils.isNotBlank(localDOSEScreenResult.getDoseRecord().getDoseLowUnit()))
        localDrugDoseCheckResultVo.setRangeDoseLow(localDrugDoseCheckResultVo.getRangeDoseLow() + " " + localDOSEScreenResult.doseRecord().getDoseLowUnit().trim());
      localDrugDoseCheckResultVo.setRangeDoseMessage(StringUtility.nullToEmptyString(localDOSEScreenResult.getRangeDoseMessage()));
      localDrugDoseCheckResultVo.setRangeDoseStatus(DoseStatusUtility.convert(localDOSEScreenResult.getRangeDoseStatus()));
      localDrugDoseCheckResultVo.setRangeDoseStatusCode(String.valueOf(localDOSEScreenResult.getRangeDoseStatus().toInt()));
      localDrugDoseCheckResultVo.setSingleDoseMax(DECIMAL_FORMAT.format(localDOSEScreenResult.doseRecord().getMaxSingleDose()));
      if (StringUtils.isNotBlank(localDOSEScreenResult.getDoseRecord().getMaxSingleDoseUnit()))
        localDrugDoseCheckResultVo.setSingleDoseMax(localDrugDoseCheckResultVo.getSingleDoseMax() + " " + localDOSEScreenResult.doseRecord().getMaxSingleDoseUnit().trim());
      localDrugDoseCheckResultVo.setSingleDoseMessage(StringUtility.nullToEmptyString(localDOSEScreenResult.getSingleDoseMessage()));
      localDrugDoseCheckResultVo.setSingleDoseStatus(DoseStatusUtility.convert(localDOSEScreenResult.getSingleDoseStatus()));
      localDrugDoseCheckResultVo.setSingleDoseStatusCode(String.valueOf(localDOSEScreenResult.getSingleDoseStatus().toInt()));
      if (!Double.isNaN(localDOSEScreenResult.getDoseRecord().getFrequencyHigh()))
        localDrugDoseCheckResultVo.setDoseFrequencyHigh(Double.toString(localDOSEScreenResult.getDoseRecord().getFrequencyHigh()));
      if (!Double.isNaN(localDOSEScreenResult.getDoseRecord().getFrequencyLow()))
        localDrugDoseCheckResultVo.setDoseFrequencyLow(Double.toString(localDOSEScreenResult.getDoseRecord().getFrequencyLow()));
      localDrugDoseCheckResultVo.setDurationMessage(StringUtility.nullToEmptyString(localDOSEScreenResult.getDurationMessage()));
      localDrugDoseCheckResultVo.setDurationStatus(DoseStatusUtility.convert(localDOSEScreenResult.getDurationStatus()));
      localDrugDoseCheckResultVo.setDurationStatusCode(String.valueOf(localDOSEScreenResult.getDurationStatus().toInt()));
      localDrugDoseCheckResultVo.setFrequencyMessage(StringUtility.nullToEmptyString(localDOSEScreenResult.getFrequencyMessage()));
      localDrugDoseCheckResultVo.setFrequencyStatus(DoseStatusUtility.convert(localDOSEScreenResult.getFrequencyStatus()));
      localDrugDoseCheckResultVo.setFrequencyStatusCode(String.valueOf(localDOSEScreenResult.getFrequencyStatus().toInt()));
      localDrugDoseCheckResultVo.setDailyDoseMessage(StringUtility.nullToEmptyString(localDOSEScreenResult.getDailyDoseMessage()));
      localDrugDoseCheckResultVo.setDailyDoseStatus(DoseStatusUtility.convert(localDOSEScreenResult.getDailyDoseStatus()));
      localDrugDoseCheckResultVo.setDailyDoseStatusCode(String.valueOf(localDOSEScreenResult.getDailyDoseStatus().toInt()));
      localDrugDoseCheckResultVo.setMaxDailyDoseMessage(StringUtility.nullToEmptyString(localDOSEScreenResult.getMaxDailyDoseMessage()));
      localDrugDoseCheckResultVo.setMaxDailyDoseStatus(DoseStatusUtility.convert(localDOSEScreenResult.getMaxDailyDoseStatus()));
      localDrugDoseCheckResultVo.setMaxDailyDoseStatusCode(String.valueOf(localDOSEScreenResult.getMaxDailyDoseStatus().toInt()));
      localDrugDoseCheckResultVo.setMaxLifetimeDose(DECIMAL_FORMAT.format(localDOSEScreenResult.doseRecord().getMaxLifetimeDose()));
      if (StringUtils.isNotBlank(localDOSEScreenResult.getDoseRecord().getMaxLifetimeDoseUnit()))
        localDrugDoseCheckResultVo.setMaxLifetimeDose(localDrugDoseCheckResultVo.getMaxLifetimeDose() + " " + localDOSEScreenResult.doseRecord().getMaxLifetimeDoseUnit().trim());
      localDrugDoseCheckResultVo.setMaxLifetimeOrderMessage(StringUtility.nullToEmptyString(localDOSEScreenResult.getMaxLifetimeOrderMessage()));
      localDrugDoseCheckResultVo.setMaxLifetimeOrderStatus(DoseStatusUtility.convert(localDOSEScreenResult.getMaxLifetimeOrderStatus()));
      localDrugDoseCheckResultVo.setMaxLifetimeOrderStatusCode(String.valueOf(localDOSEScreenResult.getMaxLifetimeOrderStatus().toInt()));
      localDrugDoseCheckResultVo.setDoseHigh(DECIMAL_FORMAT.format(localDOSEScreenResult.getDoseRecord().getDoseHigh()));
      localDrugDoseCheckResultVo.setDoseHighUnit(StringUtility.nullToEmptyString(localDOSEScreenResult.getDoseRecord().getDoseHighUnit()));
      localDrugDoseCheckResultVo.setDoseLow(DECIMAL_FORMAT.format(localDOSEScreenResult.getDoseRecord().getDoseLow()));
      localDrugDoseCheckResultVo.setDoseLowUnit(StringUtility.nullToEmptyString(localDOSEScreenResult.getDoseRecord().getDoseLowUnit()));
      localDrugDoseCheckResultVo.setDoseFormHigh(DECIMAL_FORMAT.format(localDOSEScreenResult.getDoseRecord().getDoseFormHigh()));
      localDrugDoseCheckResultVo.setDoseFormHighUnit(StringUtility.nullToEmptyString(localDOSEScreenResult.getDoseRecord().getDoseFormHighUnit()));
      localDrugDoseCheckResultVo.setDoseFormLow(DECIMAL_FORMAT.format(localDOSEScreenResult.getDoseRecord().getDoseFormLow()));
      localDrugDoseCheckResultVo.setDoseFormLowUnit(StringUtility.nullToEmptyString(localDOSEScreenResult.getDoseRecord().getDoseFormLowUnit()));
      localDrugDoseCheckResultVo.setDoseRouteDescription(StringUtility.nullToEmptyString(localDOSEScreenResult.getDoseRecord().getDoseRouteDescription()));
      localDrugDoseCheckResultVo.setMaxSingleNTEDose(DECIMAL_FORMAT.format(localDOSEScreenResult.getDoseRecord().getMaxSingleNTEDose()));
      localDrugDoseCheckResultVo.setMaxSingleNTEDoseUnit(StringUtility.nullToEmptyString(localDOSEScreenResult.getDoseRecord().getMaxSingleNTEDoseUnit()));
      localDrugDoseCheckResultVo.setMaxSingleNTEDoseForm(DECIMAL_FORMAT.format(localDOSEScreenResult.getDoseRecord().getMaxSingleNTEDoseForm()));
      localDrugDoseCheckResultVo.setMaxSingleNTEDoseFormUnit(StringUtility.nullToEmptyString(localDOSEScreenResult.getDoseRecord().getMaxSingleNTEDoseFormUnit()));
      localDrugDoseCheckResultVo.setDaily(convertToCalculatedDoseVo(localDOSEScreenResult.getDailyDoseCalculatedValue()));
      localDrugDoseCheckResultVo.setMaxDaily(convertToCalculatedDoseVo(localDOSEScreenResult.getMaxDailyDoseCalculatedValue()));
      localDrugDoseCheckResultVo.setRangeLow(convertToCalculatedDoseVo(localDOSEScreenResult.getRangeDoseCalculatedLow()));
      localDrugDoseCheckResultVo.setRangeHigh(convertToCalculatedDoseVo(localDOSEScreenResult.getRangeDoseCalculatedHigh()));
      localDrugDoseCheckResultVo.setMaxLifetime(convertToCalculatedDoseVo(localDOSEScreenResult.getMaxLifetimeDoseCalculatedValue()));
      localDrugDoseCheckResultVo.setMaxLifetimeOrder(convertToCalculatedDoseVo(localDOSEScreenResult.getMaxLifetimeOrderCalculatedValue()));
      localDrugDoseCheckResultVo.setSingle(convertToCalculatedDoseVo(localDOSEScreenResult.getSingleDoseCalculatedValue()));
      localDrugDoseCheckResultVo.setMaxDailyDose(DECIMAL_FORMAT.format(localDOSEScreenResult.getDoseRecord().getMaxDailyDose()));
      localDrugDoseCheckResultVo.setMaxDailyDoseUnit(StringUtility.nullToEmptyString(localDOSEScreenResult.getDoseRecord().getMaxDailyDoseUnit()));
      localDrugDoseCheckResultVo.setMaxDailyDoseForm(DECIMAL_FORMAT.format(localDOSEScreenResult.getDoseRecord().getMaxDailyDoseForm()));
      localDrugDoseCheckResultVo.setMaxDailyDoseFormUnit(StringUtility.nullToEmptyString(localDOSEScreenResult.getDoseRecord().getMaxDailyDoseFormUnit()));
      localDrugCheckResultsVo.getChecks().add(localDrugDoseCheckResultVo);
    }
    return localDrugCheckResultsVo;
  }

  private CalculatedDoseVo convertToCalculatedDoseVo(CalculatedDoseValue paramCalculatedDoseValue)
  {
    CalculatedDoseVo localCalculatedDoseVo = new CalculatedDoseVo();
    localCalculatedDoseVo.setDatabaseValue(DECIMAL_FORMAT.format(paramCalculatedDoseValue.getDatabaseValue()));
    localCalculatedDoseVo.setDoseValue(DECIMAL_FORMAT.format(paramCalculatedDoseValue.getDoseValue()));
    localCalculatedDoseVo.setPercentError(Integer.toString(paramCalculatedDoseValue.getPercentError()));
    localCalculatedDoseVo.setUnitOfMeasure(paramCalculatedDoseValue.getUnitOfMeasure());
    return localCalculatedDoseVo;
  }

  private void setChemoInjectable(DrugDoseCheckResultVo paramDrugDoseCheckResultVo)
  {
    boolean bool = false;
    try
    {
      DispensableGeneric localDispensableGeneric = newDispensableGenericInstance();
      localDispensableGeneric.load(Long.valueOf(paramDrugDoseCheckResultVo.getDrug().getGcnSeqNo()).longValue(), "", "");
      int i = 1;
      DoseRoutes localDoseRoutes = localDispensableGeneric.getDoseRoutes();
      for (int j = 0; j < localDoseRoutes.count(); j++)
      {
        String str = localDoseRoutes.item(j).getID();
        if ((ORAL_ROUTE_ID.equals(str)) || (TOPICAL_ROUTE_ID.equals(str)))
        {
          i = 0;
          break;
        }
      }
      if (i != 0)
      {
        Classifications localClassifications = localDispensableGeneric.getClassifications(FDBClassificationsType.fdbCTETC);
        for (int k = 0; k < localClassifications.count(); k++)
        {
          Classification localClassification1 = localClassifications.item(k);
          Classification localClassification2 = localClassification1.getUltimateParent();
          if ((ANTINEOPLASTICS_CLASS_ID.equals(localClassification1.getID())) || ((localClassification2 != null) && (ANTINEOPLASTICS_CLASS_ID.equals(localClassification2.getID()))))
          {
            bool = true;
            break;
          }
        }
      }
    }
    catch (Exception localException)
    {
      LOG.warn("Unable to determine if GCN " + paramDrugDoseCheckResultVo.getDrug().getGcnSeqNo() + " is a chemo injectable. Defaulting value to false.", localException);
    }
    paramDrugDoseCheckResultVo.setChemoInjectable(bool);
  }

  public final void setScreening(Screening paramScreening)
  {
    this.screening = paramScreening;
  }

  protected final DispensableGeneric newDispensableGenericInstance()
  {
    return new DispensableGeneric(this.fdbDataManager);
  }

  public final void setFdbDataManager(FDBDataManager paramFDBDataManager)
  {
    this.fdbDataManager = paramFDBDataManager;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl.PerformDrugDoseCheckCapabilityImpl
 * JD-Core Version:    0.6.2
 */