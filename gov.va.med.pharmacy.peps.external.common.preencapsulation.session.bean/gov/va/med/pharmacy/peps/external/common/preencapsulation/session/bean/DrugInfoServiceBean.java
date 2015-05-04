package gov.va.med.pharmacy.peps.external.common.preencapsulation.session.bean;

import gov.va.med.pharmacy.peps.external.common.preencapsulation.session.DrugInfoService;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.transaction.annotation.Transactional;

@Stateless
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class DrugInfoServiceBean
  implements DrugInfoService
{

  @Autowired
  private DrugInfoService drugInfoService;

  @Transactional(readOnly=true)
  public String retrieveDrugInformation(String paramString)
  {
    return this.drugInfoService.retrieveDrugInformation(paramString);
  }

  public final void setDrugInfoService(DrugInfoService paramDrugInfoService)
  {
    this.drugInfoService = paramDrugInfoService;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/mocha-server-3.0.00.0073/PS_MS_EJB.jar
 * Qualified Name:     PS_MS_EJB.gov.va.med.pharmacy.peps.external.common.preencapsulation.session.bean.DrugInfoServiceBean
 * JD-Core Version:    0.6.2
 */