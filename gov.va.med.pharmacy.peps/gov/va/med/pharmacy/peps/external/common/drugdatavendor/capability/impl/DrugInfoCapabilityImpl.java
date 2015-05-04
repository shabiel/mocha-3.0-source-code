package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl;

import firstdatabank.database.FDBDataManager;
import firstdatabank.database.FDBException;
import firstdatabank.dif.DispensableDrug;
import firstdatabank.dif.DoseRoute;
import firstdatabank.dif.DoseRoutes;
import firstdatabank.dif.DoseType;
import firstdatabank.dif.DoseTypes;
import firstdatabank.dif.FDBDispensableDrugLoadType;
import firstdatabank.dif.FDBDrugType;
import firstdatabank.dif.GlobalObjectManager;
import firstdatabank.dif.ScreenDrug;
import gov.va.med.pharmacy.peps.common.vo.DoseRouteVo;
import gov.va.med.pharmacy.peps.common.vo.DoseTypeVo;
import gov.va.med.pharmacy.peps.common.vo.DrugInfoResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DrugInfoVo;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.DrugInfoCapability;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DrugInfoCapabilityImpl
  implements DrugInfoCapability
{
  private FDBDataManager fdbDataManager;

  public final DrugInfoResultsVo processDrugInfoRequest(Collection<DrugInfoVo> paramCollection)
  {
    DrugInfoResultsVo localDrugInfoResultsVo = new DrugInfoResultsVo();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      DrugInfoVo localDrugInfoVo = (DrugInfoVo)localIterator.next();
      try
      {
        synchronized (GlobalObjectManager.class)
        {
          ScreenDrug localScreenDrug = newScreenDrugInstance();
          localScreenDrug.load(localDrugInfoVo.getGcnSeqNo(), FDBDrugType.fdbDTGCNSeqNo);
          localDrugInfoVo.setDoseRoutes(convertDoseRoutes(localScreenDrug.getDoseRoutes()));
          localDrugInfoVo.setDoseTypes(convertDoseTypes(localScreenDrug.getDoseTypes()));
          DispensableDrug localDispensableDrug = newDispensableDrugInstance();
          localDispensableDrug.load(Long.valueOf(localDrugInfoVo.getGcnSeqNo()).longValue(), FDBDispensableDrugLoadType.fdbDDLTGCNSeqNo, "", "", "");
          String str = localDispensableDrug.getStrengthUnit();
          if (str != null)
            str = str.toUpperCase();
          localDrugInfoVo.setStrengthUnit(str);
        }
        localDrugInfoResultsVo.getDrugs().add(localDrugInfoVo);
      }
      catch (FDBException localFDBException)
      {
        localDrugInfoResultsVo.getDrugsNotFound().add(localDrugInfoVo);
      }
    }
    return localDrugInfoResultsVo;
  }

  private Collection<DoseTypeVo> convertDoseTypes(DoseTypes paramDoseTypes)
  {
    ArrayList localArrayList = new ArrayList(paramDoseTypes.count());
    for (int i = 0; i < paramDoseTypes.count(); i++)
    {
      DoseTypeVo localDoseTypeVo = new DoseTypeVo();
      localDoseTypeVo.setId(paramDoseTypes.item(i).getID());
      localDoseTypeVo.setName(paramDoseTypes.item(i).getDescription());
      localArrayList.add(localDoseTypeVo);
    }
    return localArrayList;
  }

  private Collection<DoseRouteVo> convertDoseRoutes(DoseRoutes paramDoseRoutes)
  {
    ArrayList localArrayList = new ArrayList(paramDoseRoutes.count());
    for (int i = 0; i < paramDoseRoutes.count(); i++)
    {
      DoseRouteVo localDoseRouteVo = new DoseRouteVo();
      localDoseRouteVo.setId(paramDoseRoutes.item(i).getID());
      localDoseRouteVo.setName(paramDoseRoutes.item(i).getDescription());
      localArrayList.add(localDoseRouteVo);
    }
    return localArrayList;
  }

  protected final ScreenDrug newScreenDrugInstance()
  {
    return new ScreenDrug(this.fdbDataManager);
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
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl.DrugInfoCapabilityImpl
 * JD-Core Version:    0.6.2
 */