package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl;

import firstdatabank.database.FDBDataManager;
import firstdatabank.database.FDBException;
import firstdatabank.database.FDBSQLException;
import firstdatabank.dif.DRCLookupResult;
import firstdatabank.dif.DRCLookupResults;
import firstdatabank.dif.DispensableDrug;
import firstdatabank.dif.FDBDispensableDrugLoadType;
import firstdatabank.dif.FDBDosingSource;
import firstdatabank.dif.FDBMedicalConditionType;
import firstdatabank.dif.FDBSource;
import firstdatabank.dif.GlobalObjectManager;
import firstdatabank.dif.MMLookupResult;
import firstdatabank.dif.MMLookupResults;
import firstdatabank.dif.NeoDRCLookupResult;
import firstdatabank.dif.NeoDRCLookupResults;
import gov.va.med.pharmacy.peps.common.vo.DecimalUnitVo;
import gov.va.med.pharmacy.peps.common.vo.DoseRangeResultKey;
import gov.va.med.pharmacy.peps.common.vo.DoseRangeResultVo;
import gov.va.med.pharmacy.peps.common.vo.DosingInfoResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DosingInfoVo;
import gov.va.med.pharmacy.peps.common.vo.DosingNotFoundVo;
import gov.va.med.pharmacy.peps.common.vo.IntegerUnitVo;
import gov.va.med.pharmacy.peps.common.vo.MinMaxResultVo;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.DosingInfoCapability;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DosingInfoCapabilityImpl
  implements DosingInfoCapability
{
  private static final Log LOGGER = LogFactory.getLog(DosingInfoCapabilityImpl.class);
  private FDBDataManager fdbDataManager;
  private static final String EMPTY_STRING = "";

  public final DosingInfoResultsVo processDosingInfoRequest(Collection<DosingInfoVo> paramCollection)
  {
    DosingInfoResultsVo localDosingInfoResultsVo = new DosingInfoResultsVo();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      DosingInfoVo localDosingInfoVo = (DosingInfoVo)localIterator.next();
      try
      {
        synchronized (GlobalObjectManager.class)
        {
          DispensableDrug localDispensableDrug = newDispensableDrugInstance();
          localDispensableDrug.load(localDosingInfoVo.getGcnSeqNo().longValue(), FDBDispensableDrugLoadType.fdbDDLTGCNSeqNo, "", "", "");
          localDosingInfoVo.setDispensableDrugName(localDispensableDrug.getName());
          localDosingInfoVo.setDispensableDrugDescription(localDispensableDrug.getDescription());
          processDoseRanges(localDosingInfoVo, localDispensableDrug);
          processMinMax(localDosingInfoVo, localDispensableDrug);
          processNeonatalDoseRanges(localDosingInfoVo, localDispensableDrug);
          localDosingInfoResultsVo.getDosingInfo().add(localDosingInfoVo);
        }
      }
      catch (FDBSQLException localFDBSQLException)
      {
        LOGGER.error("An error occurred accessing the FDB DIF Database.  " + localFDBSQLException.getMessage());
        localDosingInfoResultsVo.getDosingNotFound().add(createDosingNotFound(localDosingInfoVo, localFDBSQLException.getMessage()));
      }
      catch (Exception localException)
      {
        localDosingInfoResultsVo.getDosingNotFound().add(createDosingNotFound(localDosingInfoVo, localException.getMessage()));
      }
    }
    return localDosingInfoResultsVo;
  }

  private DosingNotFoundVo createDosingNotFound(DosingInfoVo paramDosingInfoVo, String paramString)
  {
    DosingNotFoundVo localDosingNotFoundVo = new DosingNotFoundVo();
    localDosingNotFoundVo.setGcnSeqNo(paramDosingInfoVo.getGcnSeqNo());
    localDosingNotFoundVo.setFdbdx(paramDosingInfoVo.getFdbdx());
    localDosingNotFoundVo.setNotFoundReason(paramString);
    return localDosingNotFoundVo;
  }

  private void processDoseRanges(DosingInfoVo paramDosingInfoVo, DispensableDrug paramDispensableDrug, Map<DoseRangeResultKey, DoseRangeResultVo> paramMap, FDBDosingSource paramFDBDosingSource)
  {
    try
    {
      DRCLookupResults localDRCLookupResults = paramDispensableDrug.getDRCDosing("", "", paramDosingInfoVo.getFdbdx(), 0L, FDBMedicalConditionType.fdbMCTFDBDX, "", paramFDBDosingSource, "");
      int i = localDRCLookupResults.count();
      if (i > 0)
        for (int j = 0; j < i; j++)
          createDosingResult(paramDosingInfoVo, localDRCLookupResults.item(j), paramMap);
    }
    catch (FDBException localFDBException)
    {
      LOGGER.info(localFDBException.getMessage(), localFDBException);
    }
  }

  private void processDoseRanges(DosingInfoVo paramDosingInfoVo, DispensableDrug paramDispensableDrug)
  {
    HashMap localHashMap = new HashMap();
    processDoseRanges(paramDosingInfoVo, paramDispensableDrug, localHashMap, FDBDosingSource.fdbDSCustomOnly);
    processDoseRanges(paramDosingInfoVo, paramDispensableDrug, localHashMap, FDBDosingSource.fdbDSFDBOnly);
    Iterator localIterator = localHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      DoseRangeResultVo localDoseRangeResultVo = (DoseRangeResultVo)localIterator.next();
      paramDosingInfoVo.getDoseRangeResults().add(localDoseRangeResultVo);
    }
  }

  private void processMinMax(DosingInfoVo paramDosingInfoVo, DispensableDrug paramDispensableDrug)
  {
    try
    {
      MMLookupResults localMMLookupResults = paramDispensableDrug.getMinMaxDosing(0L);
      int i = localMMLookupResults.count();
      if (i > 0)
        for (int j = 0; j < i; j++)
          createMinMaxResult(paramDosingInfoVo, localMMLookupResults.item(j));
    }
    catch (FDBException localFDBException)
    {
      LOGGER.info(localFDBException.getMessage(), localFDBException);
    }
  }

  private void processNeonatalDoseRanges(DosingInfoVo paramDosingInfoVo, DispensableDrug paramDispensableDrug)
  {
    try
    {
      NeoDRCLookupResults localNeoDRCLookupResults = paramDispensableDrug.getNeoDRCDosing("", "", paramDosingInfoVo.getFdbdx(), 0L, 0L, 0L, FDBMedicalConditionType.fdbMCTFDBDX, "", FDBDosingSource.fdbDSCustomWithFDBDefault, "");
      int i = localNeoDRCLookupResults.count();
      if (i > 0)
        for (int j = 0; j < i; j++)
          createNeoDrcResult(paramDosingInfoVo, localNeoDRCLookupResults.item(j));
    }
    catch (FDBException localFDBException)
    {
      LOGGER.info(localFDBException.getMessage(), localFDBException);
    }
  }

  private void createDosingResult(DosingInfoVo paramDosingInfoVo, DRCLookupResult paramDRCLookupResult, Map<DoseRangeResultKey, DoseRangeResultVo> paramMap)
  {
    DoseRangeResultKey localDoseRangeResultKey = buildDoseRangeKey(paramDRCLookupResult);
    if (!paramMap.containsKey(localDoseRangeResultKey))
    {
      DoseRangeResultVo localDoseRangeResultVo = new DoseRangeResultVo();
      localDoseRangeResultVo.setCustom(Boolean.valueOf(paramDRCLookupResult.getSource() != FDBSource.fdbSFDB));
      localDoseRangeResultVo.setAgeHighInDays(Long.valueOf(paramDRCLookupResult.getAgeInDaysHigh()));
      localDoseRangeResultVo.setAgeLowInDays(Long.valueOf(paramDRCLookupResult.getAgeInDaysLow()));
      localDoseRangeResultVo.setBsaRequired(Boolean.valueOf(paramDRCLookupResult.getBSARequired()));
      localDoseRangeResultVo.setCrclThreshold(new IntegerUnitVo(convertToInteger(paramDRCLookupResult.getCrClThreshold()), paramDRCLookupResult.getCrClThresholdUnit()));
      localDoseRangeResultVo.setCategory(paramDRCLookupResult.getCategory());
      localDoseRangeResultVo.setDoseFormHigh(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getDoseFormHigh()), paramDRCLookupResult.getDoseFormHighUnit()));
      localDoseRangeResultVo.setDoseFormLow(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getDoseFormLow()), paramDRCLookupResult.getDoseFormLowUnit()));
      localDoseRangeResultVo.setDoseHigh(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getDoseHigh()), paramDRCLookupResult.getDoseHighUnit()));
      localDoseRangeResultVo.setDoseLow(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getDoseLow()), paramDRCLookupResult.getDoseLowUnit()));
      localDoseRangeResultVo.setDoseRouteDescription(paramDRCLookupResult.getDoseRouteDescription());
      localDoseRangeResultVo.setDoseRouteId(paramDRCLookupResult.getDoseRouteID());
      localDoseRangeResultVo.setDoseTypeDescription(paramDRCLookupResult.getDoseTypeDescription());
      localDoseRangeResultVo.setDoseTypeId(paramDRCLookupResult.getDoseTypeID());
      localDoseRangeResultVo.setDurationHigh(Long.valueOf(paramDRCLookupResult.getDurationHigh()));
      localDoseRangeResultVo.setDurationLow(Long.valueOf(paramDRCLookupResult.getDurationLow()));
      localDoseRangeResultVo.setFrequencyHigh(Double.valueOf(paramDRCLookupResult.getFrequencyHigh()));
      localDoseRangeResultVo.setFrequencyLow(Double.valueOf(paramDRCLookupResult.getFrequencyLow()));
      localDoseRangeResultVo.setHalfLifeUnit(paramDRCLookupResult.getHalfLifeUnit());
      localDoseRangeResultVo.setHepaticImpairment(Boolean.valueOf(paramDRCLookupResult.getHepaticImpairment()));
      localDoseRangeResultVo.setHighEliminationHalfLife(Double.valueOf(paramDRCLookupResult.getHighEliminationHalfLife()));
      localDoseRangeResultVo.setHitIndicationDescription(paramDRCLookupResult.getHitIndicationDescription());
      localDoseRangeResultVo.setHitIndicationId(Integer.valueOf(paramDRCLookupResult.getHitIndicationID()));
      localDoseRangeResultVo.setIndicationDescription(paramDRCLookupResult.getIndicationDescription());
      localDoseRangeResultVo.setIndicationId(paramDRCLookupResult.getIndicationID());
      localDoseRangeResultVo.setIndicationIdType(paramDRCLookupResult.getIndicationIDType());
      localDoseRangeResultVo.setIntlDoseRouteDescription(paramDRCLookupResult.getIntlDoseRouteDescription());
      localDoseRangeResultVo.setIntlDoseTypeDescription(paramDRCLookupResult.getIntlDoseTypeDescription());
      localDoseRangeResultVo.setIntlHitIndicationDescription(paramDRCLookupResult.getIntlHitIndicationDescription());
      localDoseRangeResultVo.setLowEliminationHalfLife(Double.valueOf(paramDRCLookupResult.getLowEliminationHalfLife()));
      localDoseRangeResultVo.setMaxDailyDose(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getMaxDailyDose()), paramDRCLookupResult.getMaxDailyDoseUnit()));
      localDoseRangeResultVo.setMaxDailyDoseForm(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getMaxDailyDoseForm()), paramDRCLookupResult.getMaxDailyDoseFormUnit()));
      localDoseRangeResultVo.setMaxDuration(Long.valueOf(paramDRCLookupResult.getMaxDuration()));
      localDoseRangeResultVo.setMaxLifetimeDose(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getMaxLifetimeDose()), paramDRCLookupResult.getMaxLifetimeDoseUnit()));
      localDoseRangeResultVo.setMaxLifetimeDoseForm(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getMaxLifetimeDoseForm()), paramDRCLookupResult.getMaxLifetimeDoseFormUnit()));
      localDoseRangeResultVo.setMaxSingleDose(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getMaxSingleDose()), paramDRCLookupResult.getMaxSingleDoseUnit()));
      localDoseRangeResultVo.setMaxSingleDoseForm(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getMaxSingleDoseForm()), paramDRCLookupResult.getMaxSingleDoseFormUnit()));
      localDoseRangeResultVo.setRenalImpairment(Boolean.valueOf(paramDRCLookupResult.getRenalImpairment()));
      localDoseRangeResultVo.setWeightRequired(Boolean.valueOf(paramDRCLookupResult.getWeightRequired()));
      localDoseRangeResultVo.setMaxSingleNTEDose(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getMaxSingleNTEDose()), paramDRCLookupResult.getMaxSingleNTEDoseUnit()));
      localDoseRangeResultVo.setMaxSingleNTEDoseForm(new DecimalUnitVo(Double.valueOf(paramDRCLookupResult.getMaxSingleNTEDoseForm()), paramDRCLookupResult.getMaxSingleNTEDoseFormUnit()));
      paramMap.put(localDoseRangeResultKey, localDoseRangeResultVo);
    }
  }

  private DoseRangeResultKey buildDoseRangeKey(DRCLookupResult paramDRCLookupResult)
  {
    DoseRangeResultKey localDoseRangeResultKey = new DoseRangeResultKey();
    localDoseRangeResultKey.setAgeHighInDays(Long.valueOf(paramDRCLookupResult.getAgeInDaysHigh()));
    localDoseRangeResultKey.setAgeLowInDays(Long.valueOf(paramDRCLookupResult.getAgeInDaysLow()));
    localDoseRangeResultKey.setDoseRouteId(paramDRCLookupResult.getDoseRouteID());
    localDoseRangeResultKey.setDoseTypeId(paramDRCLookupResult.getDoseTypeID());
    localDoseRangeResultKey.setIndicationId(paramDRCLookupResult.getIndicationID());
    return localDoseRangeResultKey;
  }

  private void createMinMaxResult(DosingInfoVo paramDosingInfoVo, MMLookupResult paramMMLookupResult)
  {
    MinMaxResultVo localMinMaxResultVo = new MinMaxResultVo();
    paramDosingInfoVo.getMinMaxResults().add(localMinMaxResultVo);
    localMinMaxResultVo.setAgeInDaysHigh(Long.valueOf(paramMMLookupResult.getAgeInDaysHigh()));
    localMinMaxResultVo.setAgeInDaysLow(Long.valueOf(paramMMLookupResult.getAgeInDaysLow()));
    localMinMaxResultVo.setBsaRequired(Boolean.valueOf(paramMMLookupResult.getBSARequired()));
    localMinMaxResultVo.setDoseFormHigh(Double.valueOf(paramMMLookupResult.getDoseFormHigh()));
    localMinMaxResultVo.setDoseFormHighUnit(paramMMLookupResult.getDoseFormHighUnit());
    localMinMaxResultVo.setDoseFormLow(Double.valueOf(paramMMLookupResult.getDoseFormLow()));
    localMinMaxResultVo.setDoseFormLowUnit(paramMMLookupResult.getDoseFormLowUnit());
    localMinMaxResultVo.setDoseHigh(Double.valueOf(paramMMLookupResult.getDoseHigh()));
    localMinMaxResultVo.setDoseHighUnit(paramMMLookupResult.getDoseHighUnit());
    localMinMaxResultVo.setDoseLow(Double.valueOf(paramMMLookupResult.getDoseLow()));
    localMinMaxResultVo.setDoseLowUnit(paramMMLookupResult.getDoseLowUnit());
    localMinMaxResultVo.setMaxDailyDose(Double.valueOf(paramMMLookupResult.getMaxDailyDose()));
    localMinMaxResultVo.setMaxDailyDoseForm(Double.valueOf(paramMMLookupResult.getMaxDailyDoseForm()));
    localMinMaxResultVo.setMaxDailyDoseFormUnit(paramMMLookupResult.getMaxDailyDoseFormUnit());
    localMinMaxResultVo.setMaxDailyDoseUnit(paramMMLookupResult.getMaxDailyDoseUnit());
    localMinMaxResultVo.setResultType(paramMMLookupResult.getResultType());
    localMinMaxResultVo.setWarningCode(Integer.valueOf(paramMMLookupResult.getWarningCode()));
    localMinMaxResultVo.setWarningMessage(paramMMLookupResult.getWarningMessage());
    localMinMaxResultVo.setWeightRequired(Boolean.valueOf(paramMMLookupResult.getWeightRequired()));
  }

  private void createNeoDrcResult(DosingInfoVo paramDosingInfoVo, NeoDRCLookupResult paramNeoDRCLookupResult)
  {
    DoseRangeResultVo localDoseRangeResultVo = new DoseRangeResultVo();
    paramDosingInfoVo.getNeonatalDoseRangeResults().add(localDoseRangeResultVo);
    localDoseRangeResultVo.setCustom(Boolean.valueOf(paramNeoDRCLookupResult.getSource() != FDBSource.fdbSFDB));
    localDoseRangeResultVo.setAgeHighInDays(Long.valueOf(paramNeoDRCLookupResult.getAgeInDaysHigh()));
    localDoseRangeResultVo.setAgeLowInDays(Long.valueOf(paramNeoDRCLookupResult.getAgeInDaysLow()));
    localDoseRangeResultVo.setBsaRequired(Boolean.valueOf(paramNeoDRCLookupResult.getBSARequired()));
    localDoseRangeResultVo.setCrclThreshold(new IntegerUnitVo(convertToInteger(paramNeoDRCLookupResult.getCrClThreshold()), paramNeoDRCLookupResult.getCrClThresholdUnit()));
    localDoseRangeResultVo.setCategory(paramNeoDRCLookupResult.getCategory());
    localDoseRangeResultVo.setDoseFormHigh(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getDoseFormHigh()), paramNeoDRCLookupResult.getDoseFormHighUnit()));
    localDoseRangeResultVo.setDoseFormLow(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getDoseFormLow()), paramNeoDRCLookupResult.getDoseFormLowUnit()));
    localDoseRangeResultVo.setDoseHigh(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getDoseHigh()), paramNeoDRCLookupResult.getDoseHighUnit()));
    localDoseRangeResultVo.setDoseLow(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getDoseLow()), paramNeoDRCLookupResult.getDoseLowUnit()));
    localDoseRangeResultVo.setDoseRouteDescription(paramNeoDRCLookupResult.getDoseRouteDescription());
    localDoseRangeResultVo.setDoseRouteId(paramNeoDRCLookupResult.getDoseRouteID());
    localDoseRangeResultVo.setDoseTypeDescription(paramNeoDRCLookupResult.getDoseTypeDescription());
    localDoseRangeResultVo.setDoseTypeId(paramNeoDRCLookupResult.getDoseTypeID());
    localDoseRangeResultVo.setDurationHigh(Long.valueOf(paramNeoDRCLookupResult.getDurationHigh()));
    localDoseRangeResultVo.setDurationLow(Long.valueOf(paramNeoDRCLookupResult.getDurationLow()));
    localDoseRangeResultVo.setFrequencyHigh(Double.valueOf(paramNeoDRCLookupResult.getFrequencyHigh()));
    localDoseRangeResultVo.setFrequencyLow(Double.valueOf(paramNeoDRCLookupResult.getFrequencyLow()));
    localDoseRangeResultVo.setHalfLifeUnit(paramNeoDRCLookupResult.getHalfLifeUnit());
    localDoseRangeResultVo.setHepaticImpairment(Boolean.valueOf(paramNeoDRCLookupResult.getHepaticImpairment()));
    localDoseRangeResultVo.setHighEliminationHalfLife(Double.valueOf(paramNeoDRCLookupResult.getHighEliminationHalfLife()));
    localDoseRangeResultVo.setHitIndicationDescription(paramNeoDRCLookupResult.getHitIndicationDescription());
    localDoseRangeResultVo.setHitIndicationId(Integer.valueOf(Long.valueOf(paramNeoDRCLookupResult.getHitIndicationID()).intValue()));
    localDoseRangeResultVo.setIndicationDescription(paramNeoDRCLookupResult.getIndicationDescription());
    localDoseRangeResultVo.setIndicationId(paramNeoDRCLookupResult.getIndicationID());
    localDoseRangeResultVo.setIndicationIdType(paramNeoDRCLookupResult.getIndicationIDType());
    localDoseRangeResultVo.setIntlDoseRouteDescription(paramNeoDRCLookupResult.getIntlDoseRouteDescription());
    localDoseRangeResultVo.setIntlDoseTypeDescription(paramNeoDRCLookupResult.getIntlDoseTypeDescription());
    localDoseRangeResultVo.setIntlHitIndicationDescription(paramNeoDRCLookupResult.getIntlHitIndicationDescription());
    localDoseRangeResultVo.setLowEliminationHalfLife(Double.valueOf(paramNeoDRCLookupResult.getLowEliminationHalfLife()));
    localDoseRangeResultVo.setMaxDailyDose(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getMaxDailyDose()), paramNeoDRCLookupResult.getMaxDailyDoseUnit()));
    localDoseRangeResultVo.setMaxDailyDoseForm(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getMaxDailyDoseForm()), paramNeoDRCLookupResult.getMaxDailyDoseFormUnit()));
    localDoseRangeResultVo.setMaxDuration(Long.valueOf(paramNeoDRCLookupResult.getMaxDuration()));
    localDoseRangeResultVo.setMaxLifetimeDose(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getMaxLifetimeDose()), paramNeoDRCLookupResult.getMaxLifetimeDoseUnit()));
    localDoseRangeResultVo.setMaxLifetimeDoseForm(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getMaxLifetimeDoseForm()), paramNeoDRCLookupResult.getMaxLifetimeDoseFormUnit()));
    localDoseRangeResultVo.setMaxSingleDose(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getMaxSingleDose()), paramNeoDRCLookupResult.getMaxSingleDoseUnit()));
    localDoseRangeResultVo.setMaxSingleDoseForm(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getMaxSingleDoseForm()), paramNeoDRCLookupResult.getMaxSingleDoseFormUnit()));
    localDoseRangeResultVo.setRenalImpairment(Boolean.valueOf(paramNeoDRCLookupResult.getRenalImpairment()));
    localDoseRangeResultVo.setWeightRequired(Boolean.valueOf(paramNeoDRCLookupResult.getWeightRequired()));
    localDoseRangeResultVo.setMaxSingleNTEDose(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getMaxSingleNTEDose()), paramNeoDRCLookupResult.getMaxSingleNTEDoseUnit()));
    localDoseRangeResultVo.setMaxSingleNTEDoseForm(new DecimalUnitVo(Double.valueOf(paramNeoDRCLookupResult.getMaxSingleNTEDoseForm()), paramNeoDRCLookupResult.getMaxSingleNTEDoseFormUnit()));
  }

  private Integer convertToInteger(long paramLong)
  {
    Long localLong = Long.valueOf(paramLong);
    return Integer.valueOf(localLong.intValue());
  }

  protected final DispensableDrug newDispensableDrugInstance()
  {
    return new DispensableDrug(this.fdbDataManager);
  }

  public final void setFdbDataManager(FDBDataManager paramFDBDataManager)
  {
    this.fdbDataManager = paramFDBDataManager;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl.DosingInfoCapabilityImpl
 * JD-Core Version:    0.6.2
 */