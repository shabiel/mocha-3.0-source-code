package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl;

import firstdatabank.database.FDBDataManager;
import firstdatabank.database.FDBException;
import firstdatabank.dif.FDBDrugType;
import firstdatabank.dif.FDBUnknownIDException;
import firstdatabank.dif.GlobalObjectManager;
import firstdatabank.dif.ScreenDrug;
import firstdatabank.dif.ScreenDrugs;
import gov.va.med.pharmacy.peps.common.exception.InterfaceException;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckResultsVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckVo;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.PerformDrugChecksCapability;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.PerformDrugDoseCheckCapability;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.PerformDrugDrugCheckCapability;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.PerformDrugTherapyCheckCapability;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.DoseTypeUtility;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.RouteUtility;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class PerformDrugChecksCapabilityImpl
  implements PerformDrugChecksCapability
{
  private static final Logger LOG = Logger.getLogger(PerformDrugChecksCapabilityImpl.class);
  private PerformDrugDoseCheckCapability performDrugDoseCheckCapability;
  private PerformDrugDrugCheckCapability performDrugDrugCheckCapability;
  private PerformDrugTherapyCheckCapability performDrugTherapyCheckCapability;
  private FDBDataManager fdbDataManager;

  public final OrderCheckResultsVo performDrugChecks(OrderCheckVo paramOrderCheckVo)
  {
    OrderCheckResultsVo localOrderCheckResultsVo = new OrderCheckResultsVo();
    ScreenDrugs localScreenDrugs1 = newScreenDrugsInstance();
    ScreenDrugs localScreenDrugs2 = newScreenDrugsInstance();
    HashMap localHashMap = new HashMap();
    int i = 0;
    Iterator localIterator = paramOrderCheckVo.getDrugsToScreen().iterator();
    while (localIterator.hasNext())
    {
      DrugCheckVo localDrugCheckVo = (DrugCheckVo)localIterator.next();
      try
      {
        ScreenDrug localScreenDrug = toScreenDrug(localDrugCheckVo);
        localHashMap.put(String.valueOf(i), localDrugCheckVo);
        localScreenDrug.setCustomID(String.valueOf(i));
        i++;
        if ((localDrugCheckVo.isProspective()) && (localDrugCheckVo.isDoseCheck()))
          localScreenDrugs2.addItem(localScreenDrug);
        localScreenDrugs1.addItem(localScreenDrug);
      }
      catch (FDBUnknownIDException localFDBUnknownIDException)
      {
        LOG.warn("Drug with GCN Sequence Number " + localDrugCheckVo.getGcnSeqNo() + " was not checked");
        localOrderCheckResultsVo.getDrugsNotChecked().add(localDrugCheckVo);
      }
      catch (FDBException localFDBException)
      {
        throw new InterfaceException(localFDBException, InterfaceException.INTERFACE_ERROR, new Object[] { "Drug Data Vendor" });
      }
    }
    if (paramOrderCheckVo.isDrugDoseCheck())
      localOrderCheckResultsVo.setDrugDoseCheckResults(this.performDrugDoseCheckCapability.performDrugDoseCheck(localScreenDrugs2, localHashMap, paramOrderCheckVo.isProspectiveOnly(), paramOrderCheckVo.getAgeInDays(), paramOrderCheckVo.getWeightInKg(), paramOrderCheckVo.getBodySurfaceAreaInSqM(), paramOrderCheckVo.isCustomTables()));
    if (paramOrderCheckVo.isDrugDrugCheck())
      localOrderCheckResultsVo.setDrugDrugCheckResults(this.performDrugDrugCheckCapability.performDrugDrugCheck(localScreenDrugs1, localHashMap, paramOrderCheckVo.isProspectiveOnly(), paramOrderCheckVo.isCustomTables()));
    if (paramOrderCheckVo.isDrugTherapyCheck())
      localOrderCheckResultsVo.setDrugTherapyCheckResults(this.performDrugTherapyCheckCapability.performDrugTherapyCheck(localScreenDrugs1, localHashMap, paramOrderCheckVo.isProspectiveOnly(), paramOrderCheckVo.isDuplicateAllowance(), paramOrderCheckVo.isCustomTables()));
    return localOrderCheckResultsVo;
  }

  private ScreenDrug toScreenDrug(DrugCheckVo paramDrugCheckVo)
    throws FDBException
  {
    synchronized (GlobalObjectManager.class)
    {
      ScreenDrug localScreenDrug = newScreenDrugInstance();
      localScreenDrug.load(paramDrugCheckVo.getGcnSeqNo(), FDBDrugType.fdbDTGCNSeqNo);
      localScreenDrug.setProspective(paramDrugCheckVo.isProspective());
      if (StringUtils.isNotBlank(paramDrugCheckVo.getDrugName()))
        localScreenDrug.setDescription(paramDrugCheckVo.getDrugName());
      if (paramDrugCheckVo.isDoseCheck())
      {
        localScreenDrug.setDoseRoute(RouteUtility.routeNameToId(paramDrugCheckVo.getDoseRoute()));
        localScreenDrug.setDoseType(DoseTypeUtility.doseTypeNameToId(paramDrugCheckVo.getDoseType()));
        localScreenDrug.setDoseInfo(paramDrugCheckVo.getSingleDoseAmount(), paramDrugCheckVo.getDoseUnit(), paramDrugCheckVo.getDoseRate(), paramDrugCheckVo.getFrequency(), paramDrugCheckVo.getDuration(), paramDrugCheckVo.getDurationRate());
      }
      return localScreenDrug;
    }
  }

  protected final ScreenDrugs newScreenDrugsInstance()
  {
    return new ScreenDrugs(this.fdbDataManager);
  }

  protected final ScreenDrug newScreenDrugInstance()
  {
    return new ScreenDrug(this.fdbDataManager);
  }

  public final void setPerformDrugDoseCheckCapability(PerformDrugDoseCheckCapability paramPerformDrugDoseCheckCapability)
  {
    this.performDrugDoseCheckCapability = paramPerformDrugDoseCheckCapability;
  }

  public final void setPerformDrugDrugCheckCapability(PerformDrugDrugCheckCapability paramPerformDrugDrugCheckCapability)
  {
    this.performDrugDrugCheckCapability = paramPerformDrugDrugCheckCapability;
  }

  public final void setPerformDrugTherapyCheckCapability(PerformDrugTherapyCheckCapability paramPerformDrugTherapyCheckCapability)
  {
    this.performDrugTherapyCheckCapability = paramPerformDrugTherapyCheckCapability;
  }

  public final void setFdbDataManager(FDBDataManager paramFDBDataManager)
  {
    this.fdbDataManager = paramFDBDataManager;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl.PerformDrugChecksCapabilityImpl
 * JD-Core Version:    0.6.2
 */