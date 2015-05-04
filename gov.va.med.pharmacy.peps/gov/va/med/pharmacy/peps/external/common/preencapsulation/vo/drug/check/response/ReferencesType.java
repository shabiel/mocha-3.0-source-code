package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response;

import gov.va.med.pharmacy.peps.common.vo.ValueObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="referencesType", propOrder={"reference"})
public class ReferencesType extends ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected List<String> reference;

  public List<String> getReference()
  {
    if (this.reference == null)
      this.reference = new ArrayList();
    return this.reference;
  }

  public boolean isSetReference()
  {
    return (this.reference != null) && (!this.reference.isEmpty());
  }

  public void unsetReference()
  {
    this.reference = null;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.ReferencesType
 * JD-Core Version:    0.6.2
 */