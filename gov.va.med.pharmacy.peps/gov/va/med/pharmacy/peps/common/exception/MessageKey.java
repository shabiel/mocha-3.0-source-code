package gov.va.med.pharmacy.peps.common.exception;

import java.io.Serializable;

public class MessageKey
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String key;

  public MessageKey(String paramString)
  {
    this.key = paramString;
  }

  public final String getKey()
  {
    return this.key;
  }

  public final String toString()
  {
    return this.key;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.exception.MessageKey
 * JD-Core Version:    0.6.2
 */