package gov.va.med.pharmacy.peps.external.common.preencapsulation.session;

public abstract interface OrderCheckService
{
  public abstract String performOrderCheck(String paramString);

  public abstract boolean updatesRunning();
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.session.OrderCheckService
 * JD-Core Version:    0.6.2
 */