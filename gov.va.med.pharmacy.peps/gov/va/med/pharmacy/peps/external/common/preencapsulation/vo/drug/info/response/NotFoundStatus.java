package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="notFoundStatus")
@XmlEnum
public enum NotFoundStatus
{
  UNABLE_TO_LOAD_DRUG_FOR_GCN_SEQ_NO("UnableToLoadDrugForGcnSeqNo");

  private final String value;

  private NotFoundStatus(String paramString)
  {
    this.value = paramString;
  }

  public String value()
  {
    return this.value;
  }

  public static NotFoundStatus fromValue(String paramString)
  {
    for (NotFoundStatus localNotFoundStatus : values())
      if (localNotFoundStatus.value.equals(paramString))
        return localNotFoundStatus;
    throw new IllegalArgumentException(paramString);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.NotFoundStatus
 * JD-Core Version:    0.6.2
 */