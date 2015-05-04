package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="exceptionCodeType")
@XmlEnum
public enum ExceptionCodeType
{
  PRE, FDB, JAVA, SYSTEM, FDBUPDATE;

  public String value()
  {
    return name();
  }

  public static ExceptionCodeType fromValue(String paramString)
  {
    return valueOf(paramString);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.exception.ExceptionCodeType
 * JD-Core Version:    0.6.2
 */