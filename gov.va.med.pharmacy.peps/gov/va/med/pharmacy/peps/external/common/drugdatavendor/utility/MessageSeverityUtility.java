package gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility;

import firstdatabank.dif.FDBMessageSeverity;
import gov.va.med.pharmacy.peps.common.utility.PropertyUtility;
import org.apache.log4j.Logger;

public final class MessageSeverityUtility
{
  private static final Logger LOG = Logger.getLogger(MessageSeverityUtility.class);

  public static String convert(FDBMessageSeverity paramFDBMessageSeverity)
  {
    String str = PropertyUtility.getProperty(MessageSeverityUtility.class, paramFDBMessageSeverity.toString());
    if (str == null)
    {
      LOG.error(paramFDBMessageSeverity.toString() + " FDBMessageSeverity did not map successfully!");
      return paramFDBMessageSeverity.toString();
    }
    return str;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.MessageSeverityUtility
 * JD-Core Version:    0.6.2
 */