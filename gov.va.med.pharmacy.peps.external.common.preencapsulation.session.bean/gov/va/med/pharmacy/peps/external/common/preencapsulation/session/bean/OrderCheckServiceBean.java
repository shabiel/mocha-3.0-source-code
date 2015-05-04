package gov.va.med.pharmacy.peps.external.common.preencapsulation.session.bean;

import gov.va.med.pharmacy.peps.external.common.preencapsulation.session.OrderCheckService;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.transaction.annotation.Transactional;

@Stateless
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class OrderCheckServiceBean
  implements OrderCheckService
{

  @Autowired
  private OrderCheckService orderCheckService;

  @Transactional(readOnly=true)
  public String performOrderCheck(String paramString)
  {
    return this.orderCheckService.performOrderCheck(paramString);
  }

  public final void setOrderCheckService(OrderCheckService paramOrderCheckService)
  {
    this.orderCheckService = paramOrderCheckService;
  }

  public boolean updatesRunning()
  {
    return this.orderCheckService.updatesRunning();
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/mocha-server-3.0.00.0073/PS_MS_EJB.jar
 * Qualified Name:     PS_MS_EJB.gov.va.med.pharmacy.peps.external.common.preencapsulation.session.bean.OrderCheckServiceBean
 * JD-Core Version:    0.6.2
 */