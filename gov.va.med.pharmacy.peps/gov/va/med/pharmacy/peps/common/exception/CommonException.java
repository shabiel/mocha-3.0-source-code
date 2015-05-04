package gov.va.med.pharmacy.peps.common.exception;

public class CommonException extends PharmacyRuntimeException
{
  public static final MessageKey PROPERTY_FILE_UNAVAILABLE = new MessageKey("PROPERTY_FILE_UNAVAILABLE");
  public static final MessageKey RESOURCE_UNAVAILABLE = new MessageKey("RESOURCE_UNAVAILABLE");
  public static final MessageKey CONFIGURATION_FILE_UNAVAILABLE = new MessageKey("CONFIGURATION_FILE_UNAVAILABLE");
  private static final long serialVersionUID = 1L;

  public CommonException(MessageKey paramMessageKey)
  {
    super(paramMessageKey);
  }

  public CommonException(MessageKey paramMessageKey, Object[] paramArrayOfObject)
  {
    super(paramMessageKey, paramArrayOfObject);
  }

  public CommonException(Throwable paramThrowable, MessageKey paramMessageKey, Object[] paramArrayOfObject)
  {
    super(paramThrowable, paramMessageKey, paramArrayOfObject);
  }

  public CommonException(Throwable paramThrowable, MessageKey paramMessageKey)
  {
    super(paramMessageKey, new Object[] { paramThrowable });
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.exception.CommonException
 * JD-Core Version:    0.6.2
 */