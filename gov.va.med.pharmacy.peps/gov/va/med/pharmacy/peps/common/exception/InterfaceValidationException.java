package gov.va.med.pharmacy.peps.common.exception;

public class InterfaceValidationException extends InterfaceException
{
  public static final MessageKey VALIDATION_ERROR = new MessageKey("VALIDATION_ERROR");
  public static final MessageKey DRUGS_TO_SCREEN_REQUIRED = new MessageKey("DRUGS_TO_SCREEN_REQUIRED");
  public static final MessageKey ORDER_CHECK_REQUERED = new MessageKey("ORDER_CHECK_REQUERED");
  public static final MessageKey PROSPECTIVE_DRUGS_REQUIRED = new MessageKey("PROSPECTIVE_DRUGS_REQUIRED");
  public static final MessageKey XML_REQUEST_REQUIRED = new MessageKey("XML_REQUEST_REQUIRED");
  public static final MessageKey FDB_VERIFICATION = new MessageKey("FDB_VERIFICATION");
  private static final long serialVersionUID = 1L;

  public InterfaceValidationException(MessageKey paramMessageKey)
  {
    super(paramMessageKey);
  }

  public InterfaceValidationException(MessageKey paramMessageKey, Object[] paramArrayOfObject)
  {
    super(paramMessageKey, paramArrayOfObject);
  }

  public InterfaceValidationException(Throwable paramThrowable, MessageKey paramMessageKey, Object[] paramArrayOfObject)
  {
    super(paramThrowable, paramMessageKey, paramArrayOfObject);
  }

  public InterfaceValidationException(Throwable paramThrowable, MessageKey paramMessageKey)
  {
    super(paramThrowable, paramMessageKey);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.exception.InterfaceValidationException
 * JD-Core Version:    0.6.2
 */