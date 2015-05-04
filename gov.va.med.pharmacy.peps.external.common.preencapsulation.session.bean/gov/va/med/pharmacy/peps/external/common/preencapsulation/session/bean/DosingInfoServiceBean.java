package gov.va.med.pharmacy.peps.external.common.preencapsulation.session.bean;

import gov.va.med.pharmacy.peps.external.common.preencapsulation.session.DosingInfoService;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.transaction.annotation.Transactional;

@Stateless
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class DosingInfoServiceBean
  implements DosingInfoService
{

  @Autowired
  private DosingInfoService service;

  @Transactional(readOnly=true)
  public String retrieveDosingInformation(String paramString)
  {
    return this.service.retrieveDosingInformation(paramString);
  }

  public final void setDosingInfoService(DosingInfoService paramDosingInfoService)
  {
    this.service = paramDosingInfoService;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/mocha-server-3.0.00.0073/PS_MS_EJB.jar
 * Qualified Name:     PS_MS_EJB.gov.va.med.pharmacy.peps.external.common.preencapsulation.session.bean.DosingInfoServiceBean
 * JD-Core Version:    0.6.2
 */