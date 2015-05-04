package gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility;

import firstdatabank.dif.Message;
import firstdatabank.dif.Messages;
import firstdatabank.dif.ScreenDrug;
import firstdatabank.dif.ScreenDrugs;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckMessageVo;
import gov.va.med.pharmacy.peps.common.vo.DrugCheckVo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MessageConversionUtility
{
  public static Collection<DrugCheckMessageVo> toDrugCheckMessages(Messages paramMessages, Map<String, DrugCheckVo> paramMap, ScreenDrugs paramScreenDrugs)
  {
    ArrayList localArrayList = new ArrayList(paramMessages.count());
    for (int i = 0; i < paramMessages.count(); i++)
    {
      Message localMessage = paramMessages.item(i);
      DrugCheckMessageVo localDrugCheckMessageVo = new DrugCheckMessageVo();
      localDrugCheckMessageVo.setDrug((DrugCheckVo)paramMap.get(paramScreenDrugs.get(localMessage.getDrugIndex()).getCustomID()));
      localDrugCheckMessageVo.setDrugName(StringUtility.nullToEmptyString(localMessage.getDrugDescription()));
      localDrugCheckMessageVo.setSeverity(StringUtility.nullToEmptyString(MessageSeverityUtility.convert(localMessage.getSeverity())));
      localDrugCheckMessageVo.setText(StringUtility.nullToEmptyString(localMessage.getMessageText()));
      localDrugCheckMessageVo.setType(StringUtility.nullToEmptyString(MessageTypeUtility.convert(localMessage.getMessageType())));
      localArrayList.add(localDrugCheckMessageVo);
    }
    return localArrayList;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.MessageConversionUtility
 * JD-Core Version:    0.6.2
 */