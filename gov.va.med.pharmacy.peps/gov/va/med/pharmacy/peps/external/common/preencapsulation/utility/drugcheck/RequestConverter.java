package gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.drugcheck;

import gov.va.med.pharmacy.peps.common.exception.InterfaceValidationException;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckHeaderVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckVo;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Body;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Checks;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Demographics;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DoseInformation;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DoseRateType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DoseTypeType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DoseUnitType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Drug;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DrugCheck;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DrugDoseCheck;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DrugTherapyCheck;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DurationRateType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Header;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.MServer;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.MUser;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.MedicationProfile;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.PEPSRequest;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.ProspectiveDrugs;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.RouteType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Time;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class RequestConverter
{
  public static OrderCheckVo toOrderCheckVo(PEPSRequest paramPEPSRequest)
  {
    OrderCheckVo localOrderCheckVo = new OrderCheckVo();
    localOrderCheckVo.setHeader(toHeader(paramPEPSRequest.getHeader()));
    if (paramPEPSRequest.isSetBody())
    {
      Checks localChecks = paramPEPSRequest.getBody().getDrugCheck().getChecks();
      if (localChecks.isSetUseCustomTables())
        localOrderCheckVo.setCustomTables(localChecks.isUseCustomTables());
      else
        localOrderCheckVo.setCustomTables(true);
      if (localChecks.isSetProspectiveOnly())
        localOrderCheckVo.setProspectiveOnly(localChecks.isProspectiveOnly());
      else
        localOrderCheckVo.setProspectiveOnly(false);
      localOrderCheckVo.setDrugDrugCheck(localChecks.isSetDrugDrugCheck());
      localOrderCheckVo.setDrugTherapyCheck(localChecks.isSetDrugTherapyCheck());
      if ((localChecks.isSetDrugTherapyCheck()) && (localChecks.getDrugTherapyCheck().isSetUseDuplicateAllowance()))
        localOrderCheckVo.setDuplicateAllowance(localChecks.getDrugTherapyCheck().isUseDuplicateAllowance());
      else
        localOrderCheckVo.setDuplicateAllowance(true);
      localOrderCheckVo.setDrugDoseCheck(localChecks.isSetDrugDoseCheck());
      localOrderCheckVo.setDrugsToScreen(new ArrayList(0));
      Object localObject;
      if (paramPEPSRequest.getBody().getDrugCheck().isSetProspectiveDrugs())
        localObject = toDrugsToScreen(paramPEPSRequest.getBody().getDrugCheck().getProspectiveDrugs().getDrug(), true);
      else
        localObject = Collections.emptyList();
      localOrderCheckVo.getDrugsToScreen().addAll((Collection)localObject);
      if ((localOrderCheckVo.isProspectiveOnly()) && (((Collection)localObject).isEmpty()))
        throw new InterfaceValidationException(InterfaceValidationException.PROSPECTIVE_DRUGS_REQUIRED);
      if (paramPEPSRequest.getBody().getDrugCheck().isSetMedicationProfile())
        localOrderCheckVo.getDrugsToScreen().addAll(toDrugsToScreen(paramPEPSRequest.getBody().getDrugCheck().getMedicationProfile().getDrug(), false));
      if (localOrderCheckVo.isDrugDoseCheck())
        addDemographicsData(localChecks.getDrugDoseCheck(), localOrderCheckVo);
    }
    return localOrderCheckVo;
  }

  private static void addDemographicsData(DrugDoseCheck paramDrugDoseCheck, OrderCheckVo paramOrderCheckVo)
  {
    paramOrderCheckVo.setAgeInDays(paramDrugDoseCheck.getDemographics().getAgeInDays());
    paramOrderCheckVo.setWeightInKg(paramDrugDoseCheck.getDemographics().getWeightInKG());
    paramOrderCheckVo.setBodySurfaceAreaInSqM(paramDrugDoseCheck.getDemographics().getBodySurfaceAreaInSqM());
  }

  private static Collection<DrugCheckVo> toDrugsToScreen(List<Drug> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Drug localDrug = (Drug)localIterator.next();
      localArrayList.add(toDrugCheckVo(localDrug, paramBoolean));
    }
    return localArrayList;
  }

  private static DrugCheckVo toDrugCheckVo(Drug paramDrug, boolean paramBoolean)
  {
    DrugCheckVo localDrugCheckVo = new DrugCheckVo();
    localDrugCheckVo.setProspective(paramBoolean);
    localDrugCheckVo.setGcnSeqNo(String.valueOf(paramDrug.getGcnSeqNo()));
    if (paramDrug.isSetIen())
      localDrugCheckVo.setIen(String.valueOf(paramDrug.getIen()));
    if (paramDrug.isSetOrderNumber())
      localDrugCheckVo.setOrderNumber(paramDrug.getOrderNumber());
    if (paramDrug.isSetVuid())
      localDrugCheckVo.setVuid(String.valueOf(paramDrug.getVuid()));
    if (paramDrug.isSetDrugName())
      localDrugCheckVo.setDrugName(paramDrug.getDrugName());
    if (paramDrug.isSetDoseInformation())
    {
      localDrugCheckVo.setDoseCheck(true);
      DoseInformation localDoseInformation = paramDrug.getDoseInformation();
      localDrugCheckVo.setDoseRate(localDoseInformation.getDoseRate().value());
      localDrugCheckVo.setDoseRoute(localDoseInformation.getRoute().value());
      localDrugCheckVo.setDoseType(localDoseInformation.getDoseType().value());
      localDrugCheckVo.setDoseUnit(localDoseInformation.getDoseUnit().value());
      localDrugCheckVo.setDuration(localDoseInformation.getDuration().longValue());
      localDrugCheckVo.setDurationRate(localDoseInformation.getDurationRate().value());
      localDrugCheckVo.setFrequency(localDoseInformation.getFrequency());
      localDrugCheckVo.setSingleDoseAmount(localDoseInformation.getDoseAmount());
    }
    return localDrugCheckVo;
  }

  private static OrderCheckHeaderVo toHeader(Header paramHeader)
  {
    OrderCheckHeaderVo localOrderCheckHeaderVo = new OrderCheckHeaderVo();
    localOrderCheckHeaderVo.setDuz(paramHeader.getMUser().getDuz());
    localOrderCheckHeaderVo.setIp(paramHeader.getMServer().getIp());
    localOrderCheckHeaderVo.setJobNumber(paramHeader.getMUser().getJobNumber());
    localOrderCheckHeaderVo.setNamespace(paramHeader.getMServer().getNamespace());
    localOrderCheckHeaderVo.setServerName(paramHeader.getMServer().getServerName());
    localOrderCheckHeaderVo.setStationNumber(paramHeader.getMServer().getStationNumber());
    localOrderCheckHeaderVo.setTime(paramHeader.getTime().getValue());
    localOrderCheckHeaderVo.setUci(paramHeader.getMServer().getUci());
    localOrderCheckHeaderVo.setUserName(paramHeader.getMUser().getUserName());
    if (paramHeader.isSetPingOnly())
      localOrderCheckHeaderVo.setPingOnly(paramHeader.isPingOnly());
    else
      localOrderCheckHeaderVo.setPingOnly(false);
    return localOrderCheckHeaderVo;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.drugcheck.RequestConverter
 * JD-Core Version:    0.6.2
 */