package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.request;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"dosingInfo"})
@XmlRootElement(name="dosingInfoRequest")
public class DosingInfoRequest extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @XmlElement(required=true)
  protected List<DosingInfo> dosingInfo;

  public List<DosingInfo> getDosingInfo()
  {
    if (this.dosingInfo == null)
      this.dosingInfo = new ArrayList();
    return this.dosingInfo;
  }

  public boolean isSetDosingInfo()
  {
    return (this.dosingInfo != null) && (!this.dosingInfo.isEmpty());
  }

  public void unsetDosingInfo()
  {
    this.dosingInfo = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.request.DosingInfoRequest
 * JD-Core Version:    0.6.2
 */