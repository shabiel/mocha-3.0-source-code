package gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility;

import firstdatabank.dif.FDBMessageType;
import gov.va.med.pharmacy.peps.common.utility.PropertyUtility;
import org.apache.log4j.Logger;

public final class MessageTypeUtility
{
  private static final Logger LOG = Logger.getLogger(MessageTypeUtility.class);

  public static String convert(FDBMessageType paramFDBMessageType)
  {
    String str = PropertyUtility.getProperty(MessageTypeUtility.class, paramFDBMessageType.toString());
    if (str == null)
    {
      LOG.error(paramFDBMessageType.toString() + " FDBMessageType did not map successfully!");
      return paramFDBMessageType.toString();
    }
    return str;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.MessageTypeUtility
 * JD-Core Version:    0.6.2
 */