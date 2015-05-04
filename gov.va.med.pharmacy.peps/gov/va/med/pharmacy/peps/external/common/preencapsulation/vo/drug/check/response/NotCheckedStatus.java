package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="notCheckedStatus")
@XmlEnum
public enum NotCheckedStatus
{
  UNABLE_TO_LOAD_DRUG_FOR_GCN_SEQ_NO("UnableToLoadDrugForGcnSeqNo");

  private final String value;

  private NotCheckedStatus(String paramString)
  {
    this.value = paramString;
  }

  public String value()
  {
    return this.value;
  }

  public static NotCheckedStatus fromValue(String paramString)
  {
    for (NotCheckedStatus localNotCheckedStatus : values())
      if (localNotCheckedStatus.value.equals(paramString))
        return localNotCheckedStatus;
    throw new IllegalArgumentException(paramString);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.NotCheckedStatus
 * JD-Core Version:    0.6.2
 */