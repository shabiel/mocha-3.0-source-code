package gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility;

import gov.va.med.pharmacy.peps.common.utility.PropertyUtility;

public final class DoseTypeUtility
{
  public static String doseTypeNameToId(String paramString)
  {
    String str = PropertyUtility.getProperty(DoseTypeUtility.class, paramString);
    return StringUtility.nullToEmptyString(str);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.DoseTypeUtility
 * JD-Core Version:    0.6.2
 */