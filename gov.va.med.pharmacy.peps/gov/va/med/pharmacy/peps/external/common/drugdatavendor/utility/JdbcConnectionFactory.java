package gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility;

import firstdatabank.database.JDBCConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class JdbcConnectionFactory
  implements JDBCConnectionFactory
{
  private DataSource dataSource;

  public final Connection getConnection()
    throws SQLException
  {
    return this.dataSource.getConnection();
  }

  public final void returnConnection(Connection paramConnection)
    throws SQLException
  {
    paramConnection.close();
  }

  public final void setDataSource(DataSource paramDataSource)
  {
    this.dataSource = paramDataSource;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.drugdatavendor.utility.JdbcConnectionFactory
 * JD-Core Version:    0.6.2
 */