package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl;

import firstdatabank.database.FDBDataManager;
import firstdatabank.database.FDBException;
import firstdatabank.database.FDBSQLException;
import firstdatabank.dif.DDIMCustomString;
import firstdatabank.dif.DDIMCustomStrings;
import firstdatabank.dif.DDIMScreenResult;
import firstdatabank.dif.DDIMScreenResults;
import firstdatabank.dif.FDBCode;
import firstdatabank.dif.FDBDDIMSeverityFilter;
import firstdatabank.dif.FDBMonographSource;
import firstdatabank.dif.FDBMonographSourceType;
import firstdatabank.dif.FDBMonographType;
import firstdatabank.dif.FDBUnknownIDException;
import firstdatabank.dif.Monograph;
import firstdatabank.dif.MonographLine;
import firstdatabank.dif.MonographLines;
import firstdatabank.dif.MonographSection;
import firstdatabank.dif.MonographSections;
import firstdatabank.dif.ScreenDrug;
import firstdatabank.dif.ScreenDrugs;
import firstdatabank.dif.Screening;
import gov.va.med.pharmacy.peps.common.exception.InterfaceException;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckVo;
import gov.va.med.pharmacy.peps.common.vo.DrugDrugCheckResultVo;
import gov.va.med.pharmacy.peps.common.vo.ProfessionalMonographVo;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.PerformDrugDrugCheckCapability;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.MessageConversionUtility;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.StringUtility;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;

public class PerformDrugDrugCheckCapabilityImpl
  implements PerformDrugDrugCheckCapability
{
  private static final Logger LOG = Logger.getLogger(PerformDrugDrugCheckCapabilityImpl.class);
  private static final String CONTINUATION_FORMAT_CODE = "0";
  private static final int SEVERITY_CODE_TYPE = 14;
  private Screening screening;
  private FDBDataManager fdbDataManager;

  public final DrugCheckResultsVo<DrugDrugCheckResultVo> performDrugDrugCheck(ScreenDrugs paramScreenDrugs, Map<String, DrugCheckVo> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      DDIMScreenResults localDDIMScreenResults = this.screening.DDIMScreen(paramScreenDrugs, paramBoolean1, FDBDDIMSeverityFilter.fdbDDIMSFUnknownModerate, paramBoolean2, paramBoolean2, paramBoolean2, "", false, "");
      return convertResults(localDDIMScreenResults, paramScreenDrugs, paramMap, paramBoolean2);
    }
    catch (FDBException localFDBException)
    {
      throw new InterfaceException(localFDBException, InterfaceException.INTERFACE_ERROR, new Object[] { "Drug Data Vendor" });
    }
    catch (SQLException localSQLException)
    {
      throw new InterfaceException(localSQLException, InterfaceException.INTERFACE_ERROR, new Object[] { "Drug Data Vendor" });
    }
  }

  private DrugCheckResultsVo<DrugDrugCheckResultVo> convertResults(DDIMScreenResults paramDDIMScreenResults, ScreenDrugs paramScreenDrugs, Map<String, DrugCheckVo> paramMap, boolean paramBoolean)
    throws FDBException, SQLException
  {
    DrugCheckResultsVo localDrugCheckResultsVo = new DrugCheckResultsVo();
    Collection localCollection = MessageConversionUtility.toDrugCheckMessages(paramDDIMScreenResults.getMessages(), paramMap, paramScreenDrugs);
    localDrugCheckResultsVo.setMessages(localCollection);
    Object localObject;
    if (paramBoolean)
    {
      localObject = filterResults(paramDDIMScreenResults);
    }
    else
    {
      localObject = new ArrayList(paramDDIMScreenResults.count());
      for (int i = 0; i < paramDDIMScreenResults.count(); i++)
        ((Collection)localObject).add(paramDDIMScreenResults.item(i));
    }
    Iterator localIterator = ((Collection)localObject).iterator();
    while (localIterator.hasNext())
    {
      DDIMScreenResult localDDIMScreenResult = (DDIMScreenResult)localIterator.next();
      if (localDDIMScreenResult.getUserInteraction())
        LOG.debug("Converting Custom DDIMScreenResult with ID " + localDDIMScreenResult.getInteractionID());
      else
        LOG.debug("Converting FDB DDIMScreenResult with ID " + localDDIMScreenResult.getInteractionID());
      DrugDrugCheckResultVo localDrugDrugCheckResultVo = new DrugDrugCheckResultVo();
      localDrugDrugCheckResultVo.setId(localDDIMScreenResult.getInteractionID());
      localDrugDrugCheckResultVo.setCustom(localDDIMScreenResult.getUserInteraction());
      localDrugDrugCheckResultVo.setDrugs(new ArrayList(2));
      DrugCheckVo localDrugCheckVo1 = (DrugCheckVo)paramMap.get(paramScreenDrugs.get(localDDIMScreenResult.getDrug1Index()).getCustomID());
      localDrugDrugCheckResultVo.getDrugs().add(localDrugCheckVo1);
      DrugCheckVo localDrugCheckVo2 = (DrugCheckVo)paramMap.get(paramScreenDrugs.get(localDDIMScreenResult.getDrug2Index()).getCustomID());
      localDrugDrugCheckResultVo.getDrugs().add(localDrugCheckVo2);
      localDrugDrugCheckResultVo.setInteractionDescription(StringUtility.nullToEmptyString(localDDIMScreenResult.getInteractionDescription()));
      localDrugDrugCheckResultVo.setShortText(StringUtility.nullToEmptyString(localDDIMScreenResult.getScreenMessage()));
      FDBCode localFDBCode = newFdbCodeInstance();
      localFDBCode.load(14, localDDIMScreenResult.getSeverityLevelCode());
      localDrugDrugCheckResultVo.setSeverity(StringUtility.nullToEmptyString(localFDBCode.getDescription()));
      try
      {
        localDrugDrugCheckResultVo.setProfessionalMonograph(loadProfessionalMonograph(localDDIMScreenResult.getMonographID(), paramBoolean));
      }
      catch (FDBUnknownIDException localFDBUnknownIDException)
      {
        LOG.warn("DDIM Professional Monograph not found with ID " + localDDIMScreenResult.getMonographID());
      }
      localDrugCheckResultsVo.getChecks().add(localDrugDrugCheckResultVo);
    }
    return localDrugCheckResultsVo;
  }

  private Collection<DDIMScreenResult> filterResults(DDIMScreenResults paramDDIMScreenResults)
  {
    HashMap localHashMap = new HashMap(paramDDIMScreenResults.count());
    for (int i = 0; i < paramDDIMScreenResults.count(); i++)
    {
      DDIMScreenResult localDDIMScreenResult1 = paramDDIMScreenResults.item(i);
      ScreenResultKey localScreenResultKey = new ScreenResultKey(localDDIMScreenResult1);
      if (localDDIMScreenResult1.getUserInteraction())
      {
        DDIMScreenResult localDDIMScreenResult2 = (DDIMScreenResult)localHashMap.put(localScreenResultKey, localDDIMScreenResult1);
        if (localDDIMScreenResult2 != null)
          LOG.debug("Filtered out FDB interaction with ID " + localDDIMScreenResult2.getInteractionID());
      }
      else if (!localHashMap.containsKey(localScreenResultKey))
      {
        localHashMap.put(localScreenResultKey, localDDIMScreenResult1);
      }
      else
      {
        LOG.debug("Filtered out FDB interaction with ID " + localDDIMScreenResult1.getInteractionID());
      }
    }
    return localHashMap.values();
  }

  private Set<Long> getMappedIds(DDIMScreenResult paramDDIMScreenResult)
  {
    HashSet localHashSet = new HashSet();
    DDIMCustomStrings localDDIMCustomStrings = paramDDIMScreenResult.getCustomStrings();
    for (int i = 0; i < localDDIMCustomStrings.count(); i++)
    {
      String str = localDDIMCustomStrings.item(i).getCustomString();
      if (NumberUtils.isNumber(str))
        localHashSet.add(Long.valueOf(str));
      else
        LOG.error("FDB ID Custom String '" + str + "' is not a number." + "The mapping will not be used!");
    }
    return localHashSet;
  }

  private ProfessionalMonographVo loadProfessionalMonograph(long paramLong, boolean paramBoolean)
    throws FDBSQLException, FDBUnknownIDException
  {
    FDBMonographSource localFDBMonographSource = FDBMonographSource.fdbMSFDBOnly;
    if (paramBoolean)
      localFDBMonographSource = FDBMonographSource.fdbMSCustomWithFDBDefault;
    Monograph localMonograph = newMonographInstance();
    localMonograph.load(FDBMonographType.fdbMTDDIM, "FDB-PE", paramLong, localFDBMonographSource);
    MonographSections localMonographSections = localMonograph.getSections();
    ProfessionalMonographVo localProfessionalMonographVo = new ProfessionalMonographVo();
    if (FDBMonographSourceType.fdbMSTFDB.equals(localMonograph.getMonographSourceType()))
      localProfessionalMonographVo.setFdbMonographSourceType(true);
    else
      localProfessionalMonographVo.setFdbMonographSourceType(false);
    localProfessionalMonographVo.setDisclaimer(getMonographSectionText(localMonographSections.getItemBySectionID("Z")));
    localProfessionalMonographVo.setMonographTitle(getMonographSectionText(localMonographSections.getItemBySectionID("T")));
    localProfessionalMonographVo.setSeverityLevel(getMonographSectionText(localMonographSections.getItemBySectionID("L")));
    localProfessionalMonographVo.setMechanismOfAction(getMonographSectionText(localMonographSections.getItemBySectionID("A")));
    localProfessionalMonographVo.setClinicalEffects(getMonographSectionText(localMonographSections.getItemBySectionID("E")));
    localProfessionalMonographVo.setPredisposingFactors(getMonographSectionText(localMonographSections.getItemBySectionID("P")));
    localProfessionalMonographVo.setPatientManagement(getMonographSectionText(localMonographSections.getItemBySectionID("M")));
    localProfessionalMonographVo.setDiscussion(getMonographSectionText(localMonographSections.getItemBySectionID("D")));
    localProfessionalMonographVo.setReferences(getReferences(localMonographSections.getItemBySectionID("R")));
    return localProfessionalMonographVo;
  }

  protected final FDBCode newFdbCodeInstance()
  {
    return new FDBCode(this.fdbDataManager);
  }

  protected final Monograph newMonographInstance()
  {
    return new Monograph(this.fdbDataManager);
  }

  private String getMonographSectionText(MonographSection paramMonographSection)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramMonographSection != null) && (paramMonographSection.getLines() != null))
      for (int i = 0; i < paramMonographSection.getLines().count(); i++)
      {
        MonographLine localMonographLine = paramMonographSection.getLines().item(i);
        if (localMonographLine != null)
          localStringBuffer.append(localMonographLine.getLineText());
      }
    return localStringBuffer.toString();
  }

  private List<String> getReferences(MonographSection paramMonographSection)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMonographSection != null) && (paramMonographSection.getLines() != null))
    {
      StringBuffer localStringBuffer = null;
      for (int i = 0; i < paramMonographSection.getLines().count(); i++)
      {
        MonographLine localMonographLine = paramMonographSection.getLines().item(i);
        if (localMonographLine != null)
        {
          if (!"0".equals(localMonographLine.getFormatCode()))
          {
            if (localStringBuffer != null)
              localArrayList.add(localStringBuffer.toString());
            localStringBuffer = new StringBuffer();
          }
          localStringBuffer.append(localMonographLine.getLineText());
        }
      }
      if (localStringBuffer != null)
        localArrayList.add(localStringBuffer.toString());
    }
    return localArrayList;
  }

  public final void setScreening(Screening paramScreening)
  {
    this.screening = paramScreening;
  }

  public final void setFdbDataManager(FDBDataManager paramFDBDataManager)
  {
    this.fdbDataManager = paramFDBDataManager;
  }

  private class ScreenResultKey
  {
    private Set<String> drugCustomIds = new HashSet(2);
    private Long interactionId = null;
    private Set<Long> mappedInteractionIds;
    private boolean fdbInteraction;

    public ScreenResultKey(DDIMScreenResult arg2)
    {
      DDIMScreenResult localDDIMScreenResult;
      this.drugCustomIds.add(localDDIMScreenResult.getDrug1CustomID());
      this.drugCustomIds.add(localDDIMScreenResult.getDrug2CustomID());
      this.fdbInteraction = (!localDDIMScreenResult.getUserInteraction());
      this.interactionId = Long.valueOf(localDDIMScreenResult.getInteractionID());
      if (this.fdbInteraction)
        this.mappedInteractionIds = PerformDrugDrugCheckCapabilityImpl.this.getMappedIds(localDDIMScreenResult);
    }

    private boolean isFdbInteraction()
    {
      return this.fdbInteraction;
    }

    public int hashCode()
    {
      return this.drugCustomIds.hashCode();
    }

    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if ((paramObject instanceof ScreenResultKey))
      {
        ScreenResultKey localScreenResultKey = (ScreenResultKey)paramObject;
        if (this.drugCustomIds.equals(localScreenResultKey.drugCustomIds))
          if ((isFdbInteraction()) && (!localScreenResultKey.isFdbInteraction()))
            bool = this.mappedInteractionIds.contains(localScreenResultKey.interactionId);
          else if ((!isFdbInteraction()) && (localScreenResultKey.isFdbInteraction()))
            bool = localScreenResultKey.mappedInteractionIds.contains(this.interactionId);
          else
            bool = this.interactionId.equals(localScreenResultKey.interactionId);
      }
      return bool;
    }
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl.PerformDrugDrugCheckCapabilityImpl
 * JD-Core Version:    0.6.2
 */