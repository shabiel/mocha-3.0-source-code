package gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility;

import firstdatabank.dif.FDBDOSEStatus;
import gov.va.med.pharmacy.peps.common.utility.PropertyUtility;
import org.apache.log4j.Logger;

public final class DoseStatusUtility
{
  private static final Logger LOG = Logger.getLogger(DoseStatusUtility.class);

  public static String convert(FDBDOSEStatus paramFDBDOSEStatus)
  {
    String str = PropertyUtility.getProperty(DoseStatusUtility.class, paramFDBDOSEStatus.toString());
    if (str == null)
    {
      LOG.error(paramFDBDOSEStatus.toString() + " FDBDOSEStatus did not map successfully!");
      return paramFDBDOSEStatus.toString();
    }
    return str;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.DoseStatusUtility
 * JD-Core Version:    0.6.2
 */