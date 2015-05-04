package gov.va.med.pharmacy.peps.common.exception;

public class InterfaceException extends PharmacyRuntimeException
{
  public static final MessageKey INTERFACE_UNAVAILABLE = new MessageKey("INTERFACE_UNAVAILABLE");
  public static final MessageKey INTERFACE_ERROR = new MessageKey("INTERFACE_ERROR");
  public static final String DRUG_DATA_VENDOR = "Drug Data Vendor";
  public static final String PRE_ENCAPSULATION = "PRE Encapsulation";
  public static final String MESSAGING_SERVICE = "Messaging Service";
  private static final long serialVersionUID = 1L;

  public InterfaceException(MessageKey paramMessageKey)
  {
    super(paramMessageKey);
  }

  public InterfaceException(MessageKey paramMessageKey, Object[] paramArrayOfObject)
  {
    super(paramMessageKey, paramArrayOfObject);
  }

  public InterfaceException(Throwable paramThrowable, MessageKey paramMessageKey, Object[] paramArrayOfObject)
  {
    super(paramThrowable, paramMessageKey, paramArrayOfObject);
  }

  public InterfaceException(Throwable paramThrowable, MessageKey paramMessageKey)
  {
    super(paramThrowable, paramMessageKey);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.exception.InterfaceException
 * JD-Core Version:    0.6.2
 */