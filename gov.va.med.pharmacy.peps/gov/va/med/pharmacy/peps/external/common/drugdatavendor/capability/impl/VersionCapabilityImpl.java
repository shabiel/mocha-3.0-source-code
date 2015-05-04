package gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl;

import firstdatabank.database.FDBException;
import firstdatabank.dif.FWStatus;
import firstdatabank.dif.Navigation;
import gov.va.med.pharmacy.peps.common.exception.InterfaceException;
import gov.va.med.pharmacy.peps.common.vo.DrugDataVendorVersionVo;
import gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.VersionCapability;
import java.util.Collections;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class VersionCapabilityImpl
  implements VersionCapability
{
  private static final Logger LOG = Logger.getLogger(VersionCapabilityImpl.class);
  private static final String BUILD_VERSION = "BUILDVERSION";
  private static final String DB_VERSION = "DBVERSION";
  private static final String ISSUE_DATE = "ISSUEDATE";
  private static final String SQL = "SELECT BUILDVERSION, DBVERSION, ISSUEDATE FROM CT_VERSION";
  private static final String NOT_AVAILABLE = "NOT AVAILABLE";
  private Navigation navigation;
  private JdbcTemplate jdbcTemplate;

  public final DrugDataVendorVersionVo retrieveDrugDataVendorVersion()
  {
    DrugDataVendorVersionVo localDrugDataVendorVersionVo = new DrugDataVendorVersionVo();
    FWStatus localFWStatus = null;
    try
    {
      localFWStatus = this.navigation.getStatus();
    }
    catch (FDBException localFDBException)
    {
      throw new InterfaceException(localFDBException, InterfaceException.INTERFACE_ERROR, new Object[] { "Drug Data Vendor" });
    }
    localDrugDataVendorVersionVo.setBuildVersion(!"".equals(localFWStatus.getDatabaseBuildVersion()) ? localFWStatus.getDatabaseBuildVersion() : "NOT AVAILABLE");
    localDrugDataVendorVersionVo.setDataVersion(!"".equals(localFWStatus.getDatabaseDataVersion()) ? localFWStatus.getDatabaseDataVersion() : "NOT AVAILABLE");
    localDrugDataVendorVersionVo.setIssueDate(!"".equals(localFWStatus.getDatabaseIssueDate()) ? localFWStatus.getDatabaseIssueDate() : "NOT AVAILABLE");
    Map localMap = Collections.EMPTY_MAP;
    try
    {
      localMap = this.jdbcTemplate.queryForMap("SELECT BUILDVERSION, DBVERSION, ISSUEDATE FROM CT_VERSION");
    }
    catch (DataAccessException localDataAccessException)
    {
      LOG.warn("Unable to query CT_VERSION table for custom data version information. Returning 'NOT AVAILABLE' for all values!", localDataAccessException);
    }
    localDrugDataVendorVersionVo.setCustomBuildVersion(getValue(localMap, "BUILDVERSION"));
    localDrugDataVendorVersionVo.setCustomDataVersion(getValue(localMap, "DBVERSION"));
    localDrugDataVendorVersionVo.setCustomIssueDate(getValue(localMap, "ISSUEDATE"));
    return localDrugDataVendorVersionVo;
  }

  private String getValue(Map paramMap, String paramString)
  {
    Object localObject = paramMap.get(paramString);
    if (localObject == null)
      localObject = paramMap.get(paramString.toLowerCase());
    if (localObject == null)
      localObject = "NOT AVAILABLE";
    return (String)localObject;
  }

  public final void setNavigation(Navigation paramNavigation)
  {
    this.navigation = paramNavigation;
  }

  public final void setDataSource(DataSource paramDataSource)
  {
    this.jdbcTemplate = new JdbcTemplate(paramDataSource);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.capability.impl.VersionCapabilityImpl
 * JD-Core Version:    0.6.2
 */