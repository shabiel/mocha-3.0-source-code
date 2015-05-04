package gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.drugcheck;

import gov.va.med.pharmacy.peps.common.exception.InterfaceException;
import gov.va.med.pharmacy.peps.common.vo.CalculatedDoseVo;
import gov.va.med.pharmacy.peps.common.vo.ConsumerMonographVo;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckMessageVo;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckVo;
import gov.va.med.pharmacy.peps.common.vo.DrugDataVendorVersionVo;
import gov.va.med.pharmacy.peps.common.vo.DrugDoseCheckResultVo;
import gov.va.med.pharmacy.peps.common.vo.DrugDrugCheckResultVo;
import gov.va.med.pharmacy.peps.common.vo.DrugTherapyCheckResultVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckHeaderVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckResultsVo;
import gov.va.med.pharmacy.peps.common.vo.ProfessionalMonographVo;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.Body;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.CalculatedDose;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.ConsumerMonograph;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DoseStatus;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.Drug;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugCheck;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugDoseCheck;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugDoseChecks;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugDrugCheck;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugDrugChecks;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugNotChecked;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugTherapyCheck;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugTherapyChecks;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugsNotChecked;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.Header;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.InteractedDrugList;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.MServer;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.MUser;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.Message;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.MessageSeverity;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.MessageTypeType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.NotCheckedStatus;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.ObjectFactory;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.PEPSResponse;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.PEPSVersion;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.ProfessionalMonograph;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.ReferencesType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.SourceType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.Time;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.apache.commons.lang.StringUtils;

public final class ResponseConverter
{
  public static PEPSResponse toPepsResponse(OrderCheckResultsVo paramOrderCheckResultsVo)
  {
    try
    {
      ObjectFactory localObjectFactory = new ObjectFactory();
      PEPSResponse localPEPSResponse = localObjectFactory.createPEPSResponse();
      localPEPSResponse.setHeader(toHeader(paramOrderCheckResultsVo.getHeader(), paramOrderCheckResultsVo.getDrugDataVendorVersion(), localObjectFactory));
      localPEPSResponse.setBody(toBody(paramOrderCheckResultsVo, localObjectFactory));
      return localPEPSResponse;
    }
    catch (JAXBException localJAXBException)
    {
      throw new InterfaceException(localJAXBException, InterfaceException.INTERFACE_ERROR, new Object[] { "PRE Encapsulation" });
    }
  }

  private static Body toBody(OrderCheckResultsVo paramOrderCheckResultsVo, ObjectFactory paramObjectFactory)
    throws JAXBException
  {
    Body localBody = paramObjectFactory.createBody();
    DrugCheck localDrugCheck = paramObjectFactory.createDrugCheck();
    localBody.setDrugCheck(localDrugCheck);
    if ((paramOrderCheckResultsVo.getDrugsNotChecked() != null) && (!paramOrderCheckResultsVo.getDrugsNotChecked().isEmpty()))
      localDrugCheck.setDrugsNotChecked(toDrugsNotChecked(paramOrderCheckResultsVo.getDrugsNotChecked(), paramObjectFactory));
    if (paramOrderCheckResultsVo.getDrugDrugCheckResults() != null)
      localDrugCheck.setDrugDrugChecks(toDrugDrugChecks(paramOrderCheckResultsVo.getDrugDrugCheckResults(), paramObjectFactory));
    if (paramOrderCheckResultsVo.getDrugTherapyCheckResults() != null)
      localDrugCheck.setDrugTherapyChecks(toDrugTherapyChecks(paramOrderCheckResultsVo.getDrugTherapyCheckResults(), paramObjectFactory));
    if (paramOrderCheckResultsVo.getDrugDoseCheckResults() != null)
      localDrugCheck.setDrugDoseChecks(toDrugDoseChecks(paramOrderCheckResultsVo.getDrugDoseCheckResults(), paramObjectFactory));
    return localBody;
  }

  private static DrugDoseChecks toDrugDoseChecks(DrugCheckResultsVo<DrugDoseCheckResultVo> paramDrugCheckResultsVo, ObjectFactory paramObjectFactory)
    throws JAXBException
  {
    DrugDoseChecks localDrugDoseChecks = paramObjectFactory.createDrugDoseChecks();
    if (!paramDrugCheckResultsVo.getChecks().isEmpty())
    {
      Iterator localIterator1 = paramDrugCheckResultsVo.getChecks().iterator();
      while (localIterator1.hasNext())
      {
        DrugDoseCheckResultVo localDrugDoseCheckResultVo = (DrugDoseCheckResultVo)localIterator1.next();
        DrugDoseCheck localDrugDoseCheck = paramObjectFactory.createDrugDoseCheck();
        if (localDrugDoseCheckResultVo.isCustom())
          localDrugDoseCheck.setSource(SourceType.CUSTOM);
        else
          localDrugDoseCheck.setSource(SourceType.FDB);
        localDrugDoseCheck.setDrug(toDrug(localDrugDoseCheckResultVo.getDrug(), paramObjectFactory));
        if (!paramDrugCheckResultsVo.getMessages().isEmpty())
        {
          Iterator localIterator2 = paramDrugCheckResultsVo.getMessages().iterator();
          while (localIterator2.hasNext())
          {
            DrugCheckMessageVo localDrugCheckMessageVo = (DrugCheckMessageVo)localIterator2.next();
            if (localDrugCheckMessageVo.getDrug().getGcnSeqNo().equals(localDrugDoseCheckResultVo.getDrug().getGcnSeqNo()))
            {
              localDrugDoseCheck.getMessage().add(toMessage(localDrugCheckMessageVo, paramObjectFactory));
              localIterator2.remove();
            }
          }
        }
        localDrugDoseCheck.setChemoInjectable(Boolean.valueOf(localDrugDoseCheckResultVo.isChemoInjectable()));
        localDrugDoseCheck.setSingleDoseStatus(DoseStatus.fromValue(localDrugDoseCheckResultVo.getSingleDoseStatus()));
        localDrugDoseCheck.setSingleDoseStatusCode(localDrugDoseCheckResultVo.getSingleDoseStatusCode());
        localDrugDoseCheck.setSingleDoseMessage(localDrugDoseCheckResultVo.getSingleDoseMessage());
        localDrugDoseCheck.setSingleDoseMax(localDrugDoseCheckResultVo.getSingleDoseMax());
        localDrugDoseCheck.setRangeDoseStatus(DoseStatus.fromValue(localDrugDoseCheckResultVo.getRangeDoseStatus()));
        localDrugDoseCheck.setRangeDoseStatusCode(localDrugDoseCheckResultVo.getRangeDoseStatusCode());
        localDrugDoseCheck.setRangeDoseMessage(localDrugDoseCheckResultVo.getRangeDoseMessage());
        localDrugDoseCheck.setRangeDoseLow(localDrugDoseCheckResultVo.getRangeDoseLow());
        localDrugDoseCheck.setRangeDoseHigh(localDrugDoseCheckResultVo.getRangeDoseHigh());
        localDrugDoseCheck.setDurationStatus(DoseStatus.fromValue(localDrugDoseCheckResultVo.getDurationStatus()));
        localDrugDoseCheck.setDurationStatusCode(localDrugDoseCheckResultVo.getDurationStatusCode());
        localDrugDoseCheck.setDurationMessage(localDrugDoseCheckResultVo.getDurationMessage());
        localDrugDoseCheck.setFrequencyStatus(DoseStatus.fromValue(localDrugDoseCheckResultVo.getFrequencyStatus()));
        localDrugDoseCheck.setFrequencyStatusCode(localDrugDoseCheckResultVo.getFrequencyStatusCode());
        localDrugDoseCheck.setFrequencyMessage(localDrugDoseCheckResultVo.getFrequencyMessage());
        localDrugDoseCheck.setFrequencyHigh(localDrugDoseCheckResultVo.getDoseFrequencyHigh());
        localDrugDoseCheck.setFrequencyLow(localDrugDoseCheckResultVo.getDoseFrequencyLow());
        localDrugDoseCheck.setDailyDoseStatus(DoseStatus.fromValue(localDrugDoseCheckResultVo.getDailyDoseStatus()));
        localDrugDoseCheck.setDailyDoseStatusCode(localDrugDoseCheckResultVo.getDailyDoseStatusCode());
        localDrugDoseCheck.setDailyDoseMessage(localDrugDoseCheckResultVo.getDailyDoseMessage());
        localDrugDoseCheck.setMaxDailyDoseStatus(DoseStatus.fromValue(localDrugDoseCheckResultVo.getMaxDailyDoseStatus()));
        localDrugDoseCheck.setMaxDailyDoseStatusCode(localDrugDoseCheckResultVo.getMaxDailyDoseStatusCode());
        localDrugDoseCheck.setMaxDailyDoseMessage(localDrugDoseCheckResultVo.getMaxDailyDoseMessage());
        localDrugDoseCheck.setMaxLifetimeDose(localDrugDoseCheckResultVo.getMaxLifetimeDose());
        localDrugDoseCheck.setDoseHigh(localDrugDoseCheckResultVo.getDoseHigh());
        localDrugDoseCheck.setDoseHighUnit(localDrugDoseCheckResultVo.getDoseHighUnit());
        localDrugDoseCheck.setDoseLow(localDrugDoseCheckResultVo.getDoseLow());
        localDrugDoseCheck.setDoseLowUnit(localDrugDoseCheckResultVo.getDoseLowUnit());
        localDrugDoseCheck.setDoseFormHigh(localDrugDoseCheckResultVo.getDoseFormHigh());
        localDrugDoseCheck.setDoseFormHighUnit(localDrugDoseCheckResultVo.getDoseFormHighUnit());
        localDrugDoseCheck.setDoseFormLow(localDrugDoseCheckResultVo.getDoseFormLow());
        localDrugDoseCheck.setDoseFormLowUnit(localDrugDoseCheckResultVo.getDoseFormLowUnit());
        localDrugDoseCheck.setDoseRouteDescription(localDrugDoseCheckResultVo.getDoseRouteDescription());
        localDrugDoseCheck.setMaxSingleNTEDose(localDrugDoseCheckResultVo.getMaxSingleNTEDose());
        localDrugDoseCheck.setMaxSingleNTEDoseUnit(localDrugDoseCheckResultVo.getMaxSingleNTEDoseUnit());
        localDrugDoseCheck.setMaxSingleNTEDoseForm(localDrugDoseCheckResultVo.getMaxSingleNTEDoseForm());
        localDrugDoseCheck.setMaxSingleNTEDoseFormUnit(localDrugDoseCheckResultVo.getMaxSingleNTEDoseFormUnit());
        localDrugDoseCheck.setMaxLifetimeOrderMessage(localDrugDoseCheckResultVo.getMaxLifetimeOrderMessage());
        localDrugDoseCheck.setMaxLifetimeOrderStatus(localDrugDoseCheckResultVo.getMaxLifetimeOrderStatus());
        localDrugDoseCheck.setMaxLifetimeOrderStatusCode(localDrugDoseCheckResultVo.getMaxLifetimeOrderStatusCode());
        localDrugDoseCheck.setDaily(convertToCalculatedDose(localDrugDoseCheckResultVo.getDaily()));
        localDrugDoseCheck.setMaxDaily(convertToCalculatedDose(localDrugDoseCheckResultVo.getMaxDaily()));
        localDrugDoseCheck.setRangeLow(convertToCalculatedDose(localDrugDoseCheckResultVo.getRangeLow()));
        localDrugDoseCheck.setRangeHigh(convertToCalculatedDose(localDrugDoseCheckResultVo.getRangeHigh()));
        localDrugDoseCheck.setMaxLifetime(convertToCalculatedDose(localDrugDoseCheckResultVo.getMaxLifetime()));
        localDrugDoseCheck.setMaxLifetimeOrder(convertToCalculatedDose(localDrugDoseCheckResultVo.getMaxLifetimeOrder()));
        localDrugDoseCheck.setSingle(convertToCalculatedDose(localDrugDoseCheckResultVo.getSingle()));
        localDrugDoseCheck.setMaxDailyDose(localDrugDoseCheckResultVo.getMaxDailyDose());
        localDrugDoseCheck.setMaxDailyDoseUnit(localDrugDoseCheckResultVo.getMaxDailyDoseUnit());
        localDrugDoseCheck.setMaxDailyDoseForm(localDrugDoseCheckResultVo.getMaxDailyDoseForm());
        localDrugDoseCheck.setMaxDailyDoseFormUnit(localDrugDoseCheckResultVo.getMaxDailyDoseFormUnit());
        localDrugDoseChecks.getDrugDoseCheck().add(localDrugDoseCheck);
      }
    }
    if (!paramDrugCheckResultsVo.getMessages().isEmpty())
      localDrugDoseChecks.getMessage().addAll(toMessages(paramDrugCheckResultsVo.getMessages(), paramObjectFactory));
    return localDrugDoseChecks;
  }

  private static CalculatedDose convertToCalculatedDose(CalculatedDoseVo paramCalculatedDoseVo)
  {
    CalculatedDose localCalculatedDose = new CalculatedDose();
    localCalculatedDose.setDatabaseValue(paramCalculatedDoseVo.getDatabaseValue());
    localCalculatedDose.setDoseValue(paramCalculatedDoseVo.getDoseValue());
    localCalculatedDose.setPercentError(paramCalculatedDoseVo.getPercentError());
    localCalculatedDose.setUnitOfMeasure(paramCalculatedDoseVo.getUnitOfMeasure());
    return localCalculatedDose;
  }

  private static Drug toDrug(DrugCheckVo paramDrugCheckVo, ObjectFactory paramObjectFactory)
  {
    Drug localDrug = paramObjectFactory.createDrug();
    localDrug.setGcnSeqNo(new BigInteger(paramDrugCheckVo.getGcnSeqNo()));
    localDrug.setOrderNumber(paramDrugCheckVo.getOrderNumber());
    if (StringUtils.isNotBlank(paramDrugCheckVo.getIen()))
      localDrug.setIen(new BigInteger(paramDrugCheckVo.getIen()));
    if (StringUtils.isNotBlank(paramDrugCheckVo.getVuid()))
      localDrug.setVuid(new BigInteger(paramDrugCheckVo.getVuid()));
    if (StringUtils.isNotBlank(paramDrugCheckVo.getDrugName()))
      localDrug.setDrugName(paramDrugCheckVo.getDrugName());
    return localDrug;
  }

  private static DrugTherapyChecks toDrugTherapyChecks(DrugCheckResultsVo<DrugTherapyCheckResultVo> paramDrugCheckResultsVo, ObjectFactory paramObjectFactory)
    throws JAXBException
  {
    DrugTherapyChecks localDrugTherapyChecks = paramObjectFactory.createDrugTherapyChecks();
    if (!paramDrugCheckResultsVo.getChecks().isEmpty())
    {
      Iterator localIterator = paramDrugCheckResultsVo.getChecks().iterator();
      while (localIterator.hasNext())
      {
        DrugTherapyCheckResultVo localDrugTherapyCheckResultVo = (DrugTherapyCheckResultVo)localIterator.next();
        DrugTherapyCheck localDrugTherapyCheck = paramObjectFactory.createDrugTherapyCheck();
        localDrugTherapyCheck.setId(String.valueOf(localDrugTherapyCheckResultVo.getId()));
        if (localDrugTherapyCheckResultVo.isCustom())
          localDrugTherapyCheck.setSource(SourceType.CUSTOM);
        else
          localDrugTherapyCheck.setSource(SourceType.FDB);
        localDrugTherapyCheck.setClassification(localDrugTherapyCheckResultVo.getDuplicateClass());
        localDrugTherapyCheck.setShortText(localDrugTherapyCheckResultVo.getShortText());
        localDrugTherapyCheck.setDuplicateAllowance(localDrugTherapyCheckResultVo.getAllowance());
        localDrugTherapyCheck.setInteractedDrugList(toInteractedDrugList(localDrugTherapyCheckResultVo.getDrugs(), paramObjectFactory));
        localDrugTherapyChecks.getDrugTherapyCheck().add(localDrugTherapyCheck);
      }
    }
    if (!paramDrugCheckResultsVo.getMessages().isEmpty())
      localDrugTherapyChecks.getMessage().addAll(toMessages(paramDrugCheckResultsVo.getMessages(), paramObjectFactory));
    return localDrugTherapyChecks;
  }

  private static DrugDrugChecks toDrugDrugChecks(DrugCheckResultsVo<DrugDrugCheckResultVo> paramDrugCheckResultsVo, ObjectFactory paramObjectFactory)
    throws JAXBException
  {
    DrugDrugChecks localDrugDrugChecks = paramObjectFactory.createDrugDrugChecks();
    if (!paramDrugCheckResultsVo.getChecks().isEmpty())
    {
      Iterator localIterator = paramDrugCheckResultsVo.getChecks().iterator();
      while (localIterator.hasNext())
      {
        DrugDrugCheckResultVo localDrugDrugCheckResultVo = (DrugDrugCheckResultVo)localIterator.next();
        DrugDrugCheck localDrugDrugCheck = paramObjectFactory.createDrugDrugCheck();
        localDrugDrugCheck.setId(String.valueOf(localDrugDrugCheckResultVo.getId()));
        if (localDrugDrugCheckResultVo.isCustom())
          localDrugDrugCheck.setSource(SourceType.CUSTOM);
        else
          localDrugDrugCheck.setSource(SourceType.FDB);
        localDrugDrugCheck.setSeverity(localDrugDrugCheckResultVo.getSeverity());
        localDrugDrugCheck.setShortText(localDrugDrugCheckResultVo.getShortText());
        localDrugDrugCheck.setInteraction(localDrugDrugCheckResultVo.getInteractionDescription());
        Object localObject;
        ReferencesType localReferencesType;
        if (localDrugDrugCheckResultVo.getProfessionalMonograph() != null)
        {
          localDrugDrugCheck.setProfessionalMonograph(paramObjectFactory.createProfessionalMonograph());
          localObject = localDrugDrugCheck.getProfessionalMonograph();
          if (localDrugDrugCheckResultVo.getProfessionalMonograph().isFdbMonographSourceType())
            ((ProfessionalMonograph)localObject).setMonographSource(SourceType.FDB);
          else
            ((ProfessionalMonograph)localObject).setMonographSource(SourceType.CUSTOM);
          ((ProfessionalMonograph)localObject).setDisclaimer(localDrugDrugCheckResultVo.getProfessionalMonograph().getDisclaimer());
          ((ProfessionalMonograph)localObject).setMonographTitle(localDrugDrugCheckResultVo.getProfessionalMonograph().getMonographTitle());
          ((ProfessionalMonograph)localObject).setSeverityLevel(localDrugDrugCheckResultVo.getProfessionalMonograph().getSeverityLevel());
          ((ProfessionalMonograph)localObject).setMechanismOfAction(localDrugDrugCheckResultVo.getProfessionalMonograph().getMechanismOfAction());
          ((ProfessionalMonograph)localObject).setClinicalEffects(localDrugDrugCheckResultVo.getProfessionalMonograph().getClinicalEffects());
          ((ProfessionalMonograph)localObject).setPredisposingFactors(localDrugDrugCheckResultVo.getProfessionalMonograph().getPredisposingFactors());
          ((ProfessionalMonograph)localObject).setPatientManagement(localDrugDrugCheckResultVo.getProfessionalMonograph().getPatientManagement());
          ((ProfessionalMonograph)localObject).setDiscussion(localDrugDrugCheckResultVo.getProfessionalMonograph().getDiscussion());
          localReferencesType = paramObjectFactory.createReferencesType();
          localReferencesType.getReference().addAll(localDrugDrugCheckResultVo.getProfessionalMonograph().getReferences());
          ((ProfessionalMonograph)localObject).setReferences(localReferencesType);
        }
        if (localDrugDrugCheckResultVo.getConsumerMonograph() != null)
        {
          localDrugDrugCheck.setConsumerMonograph(paramObjectFactory.createConsumerMonograph());
          localObject = localDrugDrugCheck.getConsumerMonograph();
          if (localDrugDrugCheckResultVo.getConsumerMonograph().isFdbMonographSourceType())
            ((ConsumerMonograph)localObject).setMonographSource(SourceType.FDB);
          else
            ((ConsumerMonograph)localObject).setMonographSource(SourceType.CUSTOM);
          ((ConsumerMonograph)localObject).setDisclaimer(localDrugDrugCheckResultVo.getConsumerMonograph().getDisclaimer());
          ((ConsumerMonograph)localObject).setHowOccurs(localDrugDrugCheckResultVo.getConsumerMonograph().getHowOccurs());
          ((ConsumerMonograph)localObject).setMedicalWarning(localDrugDrugCheckResultVo.getConsumerMonograph().getMedicalWarning());
          ((ConsumerMonograph)localObject).setMonographTitle(localDrugDrugCheckResultVo.getConsumerMonograph().getMonographTitle());
          localReferencesType = paramObjectFactory.createReferencesType();
          localReferencesType.getReference().addAll(localDrugDrugCheckResultVo.getConsumerMonograph().getReferences());
          ((ConsumerMonograph)localObject).setReferences(localReferencesType);
          ((ConsumerMonograph)localObject).setWhatMightHappen(localDrugDrugCheckResultVo.getConsumerMonograph().getWhatMightHappen());
          ((ConsumerMonograph)localObject).setWhatToDo(localDrugDrugCheckResultVo.getConsumerMonograph().getWhatToDo());
        }
        localDrugDrugCheck.setInteractedDrugList(toInteractedDrugList(localDrugDrugCheckResultVo.getDrugs(), paramObjectFactory));
        localDrugDrugChecks.getDrugDrugCheck().add(localDrugDrugCheck);
      }
    }
    if (!paramDrugCheckResultsVo.getMessages().isEmpty())
      localDrugDrugChecks.getMessage().addAll(toMessages(paramDrugCheckResultsVo.getMessages(), paramObjectFactory));
    return localDrugDrugChecks;
  }

  private static InteractedDrugList toInteractedDrugList(Collection<DrugCheckVo> paramCollection, ObjectFactory paramObjectFactory)
    throws JAXBException
  {
    InteractedDrugList localInteractedDrugList = paramObjectFactory.createInteractedDrugList();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      DrugCheckVo localDrugCheckVo = (DrugCheckVo)localIterator.next();
      Drug localDrug = toDrug(localDrugCheckVo, paramObjectFactory);
      localInteractedDrugList.getDrug().add(localDrug);
    }
    return localInteractedDrugList;
  }

  private static Collection<Message> toMessages(Collection<DrugCheckMessageVo> paramCollection, ObjectFactory paramObjectFactory)
    throws JAXBException
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      DrugCheckMessageVo localDrugCheckMessageVo = (DrugCheckMessageVo)localIterator.next();
      localArrayList.add(toMessage(localDrugCheckMessageVo, paramObjectFactory));
    }
    return localArrayList;
  }

  private static Message toMessage(DrugCheckMessageVo paramDrugCheckMessageVo, ObjectFactory paramObjectFactory)
  {
    Message localMessage = paramObjectFactory.createMessage();
    localMessage.setDrug(toDrug(paramDrugCheckMessageVo.getDrug(), paramObjectFactory));
    localMessage.setSeverity(MessageSeverity.fromValue(paramDrugCheckMessageVo.getSeverity()));
    localMessage.setType(MessageTypeType.fromValue(paramDrugCheckMessageVo.getType()));
    localMessage.setDrugName(paramDrugCheckMessageVo.getDrugName());
    localMessage.setText(paramDrugCheckMessageVo.getText());
    return localMessage;
  }

  private static DrugsNotChecked toDrugsNotChecked(Collection<DrugCheckVo> paramCollection, ObjectFactory paramObjectFactory)
    throws JAXBException
  {
    DrugsNotChecked localDrugsNotChecked = paramObjectFactory.createDrugsNotChecked();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      DrugCheckVo localDrugCheckVo = (DrugCheckVo)localIterator.next();
      DrugNotChecked localDrugNotChecked = paramObjectFactory.createDrugNotChecked();
      localDrugNotChecked.setStatus(NotCheckedStatus.UNABLE_TO_LOAD_DRUG_FOR_GCN_SEQ_NO);
      localDrugNotChecked.setDrug(toDrug(localDrugCheckVo, paramObjectFactory));
      localDrugsNotChecked.getDrugNotChecked().add(localDrugNotChecked);
    }
    return localDrugsNotChecked;
  }

  private static Header toHeader(OrderCheckHeaderVo paramOrderCheckHeaderVo, DrugDataVendorVersionVo paramDrugDataVendorVersionVo, ObjectFactory paramObjectFactory)
    throws JAXBException
  {
    Header localHeader = paramObjectFactory.createHeader();
    MServer localMServer = paramObjectFactory.createMServer();
    localMServer.setIp(paramOrderCheckHeaderVo.getIp());
    localMServer.setNamespace(paramOrderCheckHeaderVo.getNamespace());
    localMServer.setServerName(paramOrderCheckHeaderVo.getServerName());
    localMServer.setStationNumber(paramOrderCheckHeaderVo.getStationNumber());
    localMServer.setUci(paramOrderCheckHeaderVo.getUci());
    localHeader.setMServer(localMServer);
    MUser localMUser = paramObjectFactory.createMUser();
    localMUser.setDuz(paramOrderCheckHeaderVo.getDuz());
    localMUser.setJobNumber(paramOrderCheckHeaderVo.getJobNumber());
    localMUser.setUserName(paramOrderCheckHeaderVo.getUserName());
    localHeader.setMUser(localMUser);
    Time localTime = paramObjectFactory.createTime();
    localTime.setValue(paramOrderCheckHeaderVo.getTime());
    localHeader.setTime(localTime);
    PEPSVersion localPEPSVersion = paramObjectFactory.createPEPSVersion();
    localPEPSVersion.setDifBuildVersion(paramDrugDataVendorVersionVo.getBuildVersion());
    localPEPSVersion.setDifDbVersion(paramDrugDataVendorVersionVo.getDataVersion());
    localPEPSVersion.setDifIssueDate(paramDrugDataVendorVersionVo.getIssueDate());
    localPEPSVersion.setCustomBuildVersion(paramDrugDataVendorVersionVo.getCustomBuildVersion());
    localPEPSVersion.setCustomDbVersion(paramDrugDataVendorVersionVo.getCustomDataVersion());
    localPEPSVersion.setCustomIssueDate(paramDrugDataVendorVersionVo.getCustomIssueDate());
    localHeader.setPEPSVersion(localPEPSVersion);
    return localHeader;
  }

  public static PEPSResponse createPingResponse(OrderCheckHeaderVo paramOrderCheckHeaderVo, DrugDataVendorVersionVo paramDrugDataVendorVersionVo)
  {
    try
    {
      ObjectFactory localObjectFactory = new ObjectFactory();
      PEPSResponse localPEPSResponse = localObjectFactory.createPEPSResponse();
      localPEPSResponse.setHeader(toHeader(paramOrderCheckHeaderVo, paramDrugDataVendorVersionVo, localObjectFactory));
      return localPEPSResponse;
    }
    catch (JAXBException localJAXBException)
    {
      throw new InterfaceException(localJAXBException, InterfaceException.INTERFACE_ERROR, new Object[] { "PRE Encapsulation" });
    }
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.drugcheck.ResponseConverter
 * JD-Core Version:    0.6.2
 */