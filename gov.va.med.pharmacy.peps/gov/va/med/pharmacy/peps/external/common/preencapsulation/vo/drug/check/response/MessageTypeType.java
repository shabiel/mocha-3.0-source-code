package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="messageTypeType")
@XmlEnum
public enum MessageTypeType
{
  INVALID_DRUG_TYPE("InvalidDrugType"), MISSING_INPUT("MissingInput"), DATA_NOT_AVAILABLE("DataNotAvailable"), NOT_RECOMMENDED_FOR_AGE("NotRecommendedForAge"), DOSE_NOT_ESTABLISHED("DoseNotEstablished"), RENAL_IMPAIRMENT("RenalImpairment"), HEPATIC_IMPAIRMENT("HepaticImpairment"), NON_INDICATION_DOSING("NonIndicationDosing"), DATA_PARTIALLY_AVAILABLE("DataPartiallyAvailable"), DATA_NOT_UNIQUE("DataNotUnique"), USED_REPLACED_DRUG("UsedReplacedDrug");

  private final String value;

  private MessageTypeType(String paramString)
  {
    this.value = paramString;
  }

  public String value()
  {
    return this.value;
  }

  public static MessageTypeType fromValue(String paramString)
  {
    for (MessageTypeType localMessageTypeType : values())
      if (localMessageTypeType.value.equals(paramString))
        return localMessageTypeType;
    throw new IllegalArgumentException(paramString);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.MessageTypeType
 * JD-Core Version:    0.6.2
 */