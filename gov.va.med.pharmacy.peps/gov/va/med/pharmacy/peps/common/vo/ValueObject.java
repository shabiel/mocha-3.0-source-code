package gov.va.med.pharmacy.peps.common.vo;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ValueObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  public boolean equals(Object paramObject)
  {
    return EqualsBuilder.reflectionEquals(this, paramObject);
  }

  public int hashCode()
  {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.vo.ValueObject
 * JD-Core Version:    0.6.2
 */