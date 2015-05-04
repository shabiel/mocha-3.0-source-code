package gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.dosinginfo;

import firstdatabank.dif.FDBMedicalConditionType;
import firstdatabank.dif.FDBMinMaxType;
import firstdatabank.dif.IString;
import gov.va.med.pharmacy.peps.common.vo.DecimalUnitVo;
import gov.va.med.pharmacy.peps.common.vo.DoseRangeResultVo;
import gov.va.med.pharmacy.peps.common.vo.DosingInfoResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DosingInfoVo;
import gov.va.med.pharmacy.peps.common.vo.DosingNotFoundVo;
import gov.va.med.pharmacy.peps.common.vo.IntegerUnitVo;
import gov.va.med.pharmacy.peps.common.vo.MinMaxResultVo;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.DoseRange;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.DoseRanges;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.DosingInfo;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.DosingInfoResponse;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.DosingNotFound;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.MinMax;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.MinMaxResults;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.NeonatalDoseRanges;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.NotFound;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.ObjectFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ResponseConverter
{
  private static final Integer ENGLISH_LANGUAGE_ID = Integer.valueOf(1);

  public static Object toDosingInfoResponse(DosingInfoResultsVo paramDosingInfoResultsVo)
  {
    ObjectFactory localObjectFactory = new ObjectFactory();
    DosingInfoResponse localDosingInfoResponse = localObjectFactory.createDosingInfoResponse();
    localDosingInfoResponse.getDosingInfo().addAll(convertDosing(paramDosingInfoResultsVo.getDosingInfo(), localObjectFactory));
    localDosingInfoResponse.setDosingNotFound(convertDosingNotFound(paramDosingInfoResultsVo.getDosingNotFound(), localObjectFactory));
    return localDosingInfoResponse;
  }

  private static Collection<DosingInfo> convertDosing(Collection<DosingInfoVo> paramCollection, ObjectFactory paramObjectFactory)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator1 = paramCollection.iterator();
    while (localIterator1.hasNext())
    {
      DosingInfoVo localDosingInfoVo = (DosingInfoVo)localIterator1.next();
      DosingInfo localDosingInfo = paramObjectFactory.createDosingInfo();
      localDosingInfo.setGcnSeqNo(localDosingInfoVo.getGcnSeqNo());
      localDosingInfo.setFdbdx(localDosingInfoVo.getFdbdx());
      localDosingInfo.setDispensableDrugName(localDosingInfoVo.getDispensableDrugName());
      localDosingInfo.setDispensableDrugDescription(localDosingInfoVo.getDispensableDrugDescription());
      Object localObject1;
      Iterator localIterator2;
      Object localObject2;
      if (localDosingInfoVo.getDoseRangeResults().size() > 0)
      {
        localObject1 = paramObjectFactory.createDoseRanges();
        localDosingInfo.getDoseRanges().add(localObject1);
        localIterator2 = localDosingInfoVo.getDoseRangeResults().iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (DoseRangeResultVo)localIterator2.next();
          ((DoseRanges)localObject1).getDoseRange().add(convertDoseRange((DoseRangeResultVo)localObject2, paramObjectFactory));
        }
      }
      if (localDosingInfoVo.getMinMaxResults().size() > 0)
      {
        localObject1 = paramObjectFactory.createMinMaxResults();
        localDosingInfo.getMinMaxResults().add(localObject1);
        localIterator2 = localDosingInfoVo.getMinMaxResults().iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (MinMaxResultVo)localIterator2.next();
          ((MinMaxResults)localObject1).getMinMax().add(convertMinMax((MinMaxResultVo)localObject2, paramObjectFactory));
        }
      }
      if (localDosingInfoVo.getNeonatalDoseRangeResults().size() > 0)
      {
        localObject1 = paramObjectFactory.createNeonatalDoseRanges();
        localDosingInfo.getNeonatalDoseRanges().add(localObject1);
        localIterator2 = localDosingInfoVo.getNeonatalDoseRangeResults().iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (DoseRangeResultVo)localIterator2.next();
          ((NeonatalDoseRanges)localObject1).getDoseRange().add(convertDoseRange((DoseRangeResultVo)localObject2, paramObjectFactory));
        }
      }
      localArrayList.add(localDosingInfo);
    }
    return localArrayList;
  }

  private static DoseRange convertDoseRange(DoseRangeResultVo paramDoseRangeResultVo, ObjectFactory paramObjectFactory)
  {
    DoseRange localDoseRange = paramObjectFactory.createDoseRange();
    localDoseRange.setCustom(paramDoseRangeResultVo.getCustom());
    localDoseRange.setAgeHighInDays(paramDoseRangeResultVo.getAgeHighInDays().longValue());
    localDoseRange.setAgeLowInDays(paramDoseRangeResultVo.getAgeLowInDays().longValue());
    localDoseRange.setBsaRequired(paramDoseRangeResultVo.getBsaRequired());
    localDoseRange.setCategory(paramDoseRangeResultVo.getCategory());
    localDoseRange.setCrclThreshold(BigInteger.valueOf(paramDoseRangeResultVo.getCrclThreshold().getValue().intValue()));
    localDoseRange.setCrclThresholdUnit(paramDoseRangeResultVo.getCrclThreshold().getUnit());
    localDoseRange.setDoseFormHigh(BigDecimal.valueOf(paramDoseRangeResultVo.getDoseFormHigh().getValue().doubleValue()));
    localDoseRange.setDoseFormHighUnit(paramDoseRangeResultVo.getDoseFormHigh().getUnit());
    localDoseRange.setDoseFormLow(BigDecimal.valueOf(paramDoseRangeResultVo.getDoseFormLow().getValue().doubleValue()));
    localDoseRange.setDoseFormLowUnit(paramDoseRangeResultVo.getDoseFormLow().getUnit());
    localDoseRange.setDoseHigh(BigDecimal.valueOf(paramDoseRangeResultVo.getDoseHigh().getValue().doubleValue()));
    localDoseRange.setDoseHighUnit(paramDoseRangeResultVo.getDoseHigh().getUnit());
    localDoseRange.setDoseLow(BigDecimal.valueOf(paramDoseRangeResultVo.getDoseLow().getValue().doubleValue()));
    localDoseRange.setDoseLowUnit(paramDoseRangeResultVo.getDoseLow().getUnit());
    localDoseRange.setDoseRouteDescription(paramDoseRangeResultVo.getDoseRouteDescription());
    localDoseRange.setDoseRouteId(paramDoseRangeResultVo.getDoseRouteId());
    localDoseRange.setDoseTypeDescription(paramDoseRangeResultVo.getDoseTypeDescription());
    localDoseRange.setDoseTypeId(paramDoseRangeResultVo.getDoseTypeId());
    localDoseRange.setDurationHigh(paramDoseRangeResultVo.getDurationHigh());
    localDoseRange.setDurationLow(paramDoseRangeResultVo.getDurationLow());
    localDoseRange.setFrequencyHigh(BigDecimal.valueOf(paramDoseRangeResultVo.getFrequencyHigh().doubleValue()));
    localDoseRange.setFrequencyLow(BigDecimal.valueOf(paramDoseRangeResultVo.getFrequencyLow().doubleValue()));
    localDoseRange.setHalfLifeUnit(paramDoseRangeResultVo.getHalfLifeUnit());
    localDoseRange.setHepaticImpairment(paramDoseRangeResultVo.getHepaticImpairment());
    localDoseRange.setHighEliminationHalfLife(BigDecimal.valueOf(paramDoseRangeResultVo.getHighEliminationHalfLife().doubleValue()));
    localDoseRange.setHitIndicationDescription(paramDoseRangeResultVo.getHitIndicationDescription());
    localDoseRange.setHitIndicationId(paramDoseRangeResultVo.getHitIndicationId().toString());
    localDoseRange.setIndicationDescription(paramDoseRangeResultVo.getIndicationDescription());
    localDoseRange.setIndicationId(paramDoseRangeResultVo.getIndicationId());
    localDoseRange.setIndicationIdType(paramDoseRangeResultVo.getIndicationIdType().toString());
    localDoseRange.setIntlDoseRouteDescription(paramDoseRangeResultVo.getIntlDoseRouteDescription().getItem(ENGLISH_LANGUAGE_ID.intValue()));
    localDoseRange.setIntlDoseTypeDescription(paramDoseRangeResultVo.getIntlDoseTypeDescription().getItem(ENGLISH_LANGUAGE_ID.intValue()));
    localDoseRange.setHitIndicationDescription(paramDoseRangeResultVo.getIntlHitIndicationDescription().getItem(ENGLISH_LANGUAGE_ID.intValue()));
    localDoseRange.setLowEliminationHalfLife(BigDecimal.valueOf(paramDoseRangeResultVo.getLowEliminationHalfLife().doubleValue()));
    localDoseRange.setMaxDailyDose(BigDecimal.valueOf(paramDoseRangeResultVo.getMaxDailyDose().getValue().doubleValue()));
    localDoseRange.setMaxDailyDoseUnit(paramDoseRangeResultVo.getMaxDailyDose().getUnit());
    localDoseRange.setMaxDailyDoseForm(BigDecimal.valueOf(paramDoseRangeResultVo.getMaxDailyDoseForm().getValue().doubleValue()));
    localDoseRange.setMaxDailyDoseFormUnit(paramDoseRangeResultVo.getMaxDailyDoseForm().getUnit());
    localDoseRange.setMaxDuration(paramDoseRangeResultVo.getMaxDuration());
    localDoseRange.setMaxLifetimeDose(BigDecimal.valueOf(paramDoseRangeResultVo.getMaxLifetimeDose().getValue().doubleValue()));
    localDoseRange.setMaxLifetimeDoseUnit(paramDoseRangeResultVo.getMaxLifetimeDose().getUnit());
    localDoseRange.setMaxLifetimeDoseForm(BigDecimal.valueOf(paramDoseRangeResultVo.getMaxLifetimeDoseForm().getValue().doubleValue()));
    localDoseRange.setMaxLifetimeDoseFormUnit(paramDoseRangeResultVo.getMaxLifetimeDoseForm().getUnit());
    localDoseRange.setMaxSingleDose(BigDecimal.valueOf(paramDoseRangeResultVo.getMaxSingleDose().getValue().doubleValue()));
    localDoseRange.setMaxSingleDoseUnit(paramDoseRangeResultVo.getMaxSingleDose().getUnit());
    localDoseRange.setMaxSingleDoseForm(BigDecimal.valueOf(paramDoseRangeResultVo.getMaxSingleDoseForm().getValue().doubleValue()));
    localDoseRange.setMaxSingleDoseFormUnit(paramDoseRangeResultVo.getMaxDailyDoseForm().getUnit());
    localDoseRange.setRenalImpairment(paramDoseRangeResultVo.getRenalImpairment());
    localDoseRange.setWeightRequired(paramDoseRangeResultVo.getWeightRequired());
    localDoseRange.setMaxSingleNTEDose(BigDecimal.valueOf(paramDoseRangeResultVo.getMaxSingleNTEDose().getValue().doubleValue()));
    localDoseRange.setMaxSingleNTEDoseUnit(paramDoseRangeResultVo.getMaxSingleNTEDose().getUnit());
    localDoseRange.setMaxSingleNTEDoseForm(BigDecimal.valueOf(paramDoseRangeResultVo.getMaxSingleNTEDoseForm().getValue().doubleValue()));
    localDoseRange.setMaxSingleNTEDoseFormUnit(paramDoseRangeResultVo.getMaxSingleNTEDoseForm().getUnit());
    return localDoseRange;
  }

  private static MinMax convertMinMax(MinMaxResultVo paramMinMaxResultVo, ObjectFactory paramObjectFactory)
  {
    MinMax localMinMax = paramObjectFactory.createMinMax();
    localMinMax.setAgeHighInDays(paramMinMaxResultVo.getAgeInDaysHigh().longValue());
    localMinMax.setAgeLowInDays(paramMinMaxResultVo.getAgeInDaysLow().longValue());
    localMinMax.setBsaRequired(paramMinMaxResultVo.getBsaRequired());
    localMinMax.setDoseFormHigh(BigDecimal.valueOf(paramMinMaxResultVo.getDoseFormHigh().doubleValue()));
    localMinMax.setDoseFormHighUnit(paramMinMaxResultVo.getDoseFormHighUnit());
    localMinMax.setDoseFormLow(BigDecimal.valueOf(paramMinMaxResultVo.getDoseFormLow().doubleValue()));
    localMinMax.setDoseFormLowUnit(paramMinMaxResultVo.getDoseFormLowUnit());
    localMinMax.setDoseHigh(BigDecimal.valueOf(paramMinMaxResultVo.getDoseHigh().doubleValue()));
    localMinMax.setDoseHighUnit(paramMinMaxResultVo.getDoseHighUnit());
    localMinMax.setDoseLow(BigDecimal.valueOf(paramMinMaxResultVo.getDoseLow().doubleValue()));
    localMinMax.setDoseLowUnit(paramMinMaxResultVo.getDoseLowUnit());
    localMinMax.setMaxDailyDose(BigDecimal.valueOf(paramMinMaxResultVo.getMaxDailyDose().doubleValue()));
    localMinMax.setMaxDailyDoseForm(BigDecimal.valueOf(paramMinMaxResultVo.getMaxDailyDoseForm().doubleValue()));
    localMinMax.setMaxDailyDoseFormUnit(paramMinMaxResultVo.getMaxDailyDoseFormUnit());
    localMinMax.setMaxDailyDoseUnit(paramMinMaxResultVo.getMaxDailyDoseUnit());
    localMinMax.setResultType(paramMinMaxResultVo.getResultType().toString());
    localMinMax.setWarningCode(BigInteger.valueOf(paramMinMaxResultVo.getWarningCode().intValue()));
    localMinMax.setWarningMessage(paramMinMaxResultVo.getWarningMessage());
    localMinMax.setWeightRequired(paramMinMaxResultVo.getWeightRequired());
    return localMinMax;
  }

  private static DosingNotFound convertDosingNotFound(Collection<DosingNotFoundVo> paramCollection, ObjectFactory paramObjectFactory)
  {
    DosingNotFound localDosingNotFound = null;
    if (!paramCollection.isEmpty())
    {
      localDosingNotFound = paramObjectFactory.createDosingNotFound();
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        DosingNotFoundVo localDosingNotFoundVo = (DosingNotFoundVo)localIterator.next();
        NotFound localNotFound = paramObjectFactory.createNotFound();
        localDosingNotFound.getNotFound().add(localNotFound);
        localNotFound.setGcnSeqNo(localDosingNotFoundVo.getGcnSeqNo());
        localNotFound.setFdbdx(localDosingNotFoundVo.getFdbdx());
        localNotFound.setNotFoundReason(localDosingNotFoundVo.getNotFoundReason());
      }
    }
    return localDosingNotFound;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.dosinginfo.ResponseConverter
 * JD-Core Version:    0.6.2
 */