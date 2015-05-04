package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"route"})
@XmlRootElement(name="routes")
public class Routes extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected List<Route> route;

  public List<Route> getRoute()
  {
    if (this.route == null)
      this.route = new ArrayList();
    return this.route;
  }

  public boolean isSetRoute()
  {
    return (this.route != null) && (!this.route.isEmpty());
  }

  public void unsetRoute()
  {
    this.route = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.Routes
 * JD-Core Version:    0.6.2
 */