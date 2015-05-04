package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"dosingNotFound", "dosingInfo"})
@XmlRootElement(name="dosingInfoResponse")
public class DosingInfoResponse extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected DosingNotFound dosingNotFound;
  protected List<DosingInfo> dosingInfo;

  public DosingNotFound getDosingNotFound()
  {
    return this.dosingNotFound;
  }

  public void setDosingNotFound(DosingNotFound paramDosingNotFound)
  {
    this.dosingNotFound = paramDosingNotFound;
  }

  public boolean isSetDosingNotFound()
  {
    return this.dosingNotFound != null;
  }

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
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.DosingInfoResponse
 * JD-Core Version:    0.6.2
 */