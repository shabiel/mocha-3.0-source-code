package gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.druginfo;

import gov.va.med.pharmacy.peps.common.vo.DoseRouteVo;
import gov.va.med.pharmacy.peps.common.vo.DoseTypeVo;
import gov.va.med.pharmacy.peps.common.vo.DrugInfoResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DrugInfoVo;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.DoseType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.DoseTypes;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.Drug;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.DrugInfoResponse;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.DrugNotFound;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.DrugsNotFound;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.NotFoundStatus;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.ObjectFactory;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.Route;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.Routes;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ResponseConverter
{
  public static DrugInfoResponse toDrugInfoResponse(DrugInfoResultsVo paramDrugInfoResultsVo)
  {
    ObjectFactory localObjectFactory = new ObjectFactory();
    DrugInfoResponse localDrugInfoResponse = localObjectFactory.createDrugInfoResponse();
    localDrugInfoResponse.getDrug().addAll(convertDrugs(paramDrugInfoResultsVo.getDrugs(), localObjectFactory));
    localDrugInfoResponse.setDrugsNotFound(convertDrugsNotFound(paramDrugInfoResultsVo.getDrugsNotFound(), localObjectFactory));
    return localDrugInfoResponse;
  }

  private static Collection<Drug> convertDrugs(Collection<DrugInfoVo> paramCollection, ObjectFactory paramObjectFactory)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      DrugInfoVo localDrugInfoVo = (DrugInfoVo)localIterator.next();
      Drug localDrug = paramObjectFactory.createDrug();
      localDrug.setGcnSeqNo(new BigInteger(localDrugInfoVo.getGcnSeqNo()));
      Routes localRoutes = paramObjectFactory.createRoutes();
      localDrug.setRoutes(localRoutes);
      Object localObject1 = localDrugInfoVo.getDoseRoutes().iterator();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DoseRouteVo)((Iterator)localObject1).next();
        localObject3 = paramObjectFactory.createRoute();
        ((Route)localObject3).setId(((DoseRouteVo)localObject2).getId());
        ((Route)localObject3).setName(((DoseRouteVo)localObject2).getName());
        localDrug.getRoutes().getRoute().add(localObject3);
      }
      localObject1 = paramObjectFactory.createDoseTypes();
      localDrug.setDoseTypes((DoseTypes)localObject1);
      Object localObject2 = localDrugInfoVo.getDoseTypes().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (DoseTypeVo)((Iterator)localObject2).next();
        DoseType localDoseType = paramObjectFactory.createDoseType();
        localDoseType.setId(((DoseTypeVo)localObject3).getId());
        localDoseType.setName(((DoseTypeVo)localObject3).getName());
        localDrug.getDoseTypes().getDoseType().add(localDoseType);
      }
      localDrug.setStrengthUnit(localDrugInfoVo.getStrengthUnit());
      localArrayList.add(localDrug);
    }
    return localArrayList;
  }

  private static DrugsNotFound convertDrugsNotFound(Collection<DrugInfoVo> paramCollection, ObjectFactory paramObjectFactory)
  {
    DrugsNotFound localDrugsNotFound = null;
    if (!paramCollection.isEmpty())
    {
      localDrugsNotFound = paramObjectFactory.createDrugsNotFound();
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        DrugInfoVo localDrugInfoVo = (DrugInfoVo)localIterator.next();
        DrugNotFound localDrugNotFound = paramObjectFactory.createDrugNotFound();
        Drug localDrug = paramObjectFactory.createDrug();
        localDrug.setGcnSeqNo(new BigInteger(localDrugInfoVo.getGcnSeqNo()));
        localDrugNotFound.setDrug(localDrug);
        localDrugNotFound.setStatus(NotFoundStatus.UNABLE_TO_LOAD_DRUG_FOR_GCN_SEQ_NO);
        localDrugsNotFound.getDrugNotFound().add(localDrugNotFound);
      }
    }
    return localDrugsNotFound;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.druginfo.ResponseConverter
 * JD-Core Version:    0.6.2
 */