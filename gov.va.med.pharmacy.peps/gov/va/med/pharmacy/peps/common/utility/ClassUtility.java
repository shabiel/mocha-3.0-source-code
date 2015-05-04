package gov.va.med.pharmacy.peps.common.utility;

import java.lang.reflect.ParameterizedType;
import org.springframework.util.StringUtils;

public final class ClassUtility
{
  public static Class<?> getGenericType(Class<?> paramClass)
  {
    return getGenericType(paramClass, 0);
  }

  public static Class<?> getGenericType(Class<?> paramClass, int paramInt)
  {
    for (Object localObject = paramClass; !(((Class)localObject).getGenericSuperclass() instanceof ParameterizedType); localObject = ((Class)localObject).getSuperclass());
    return (Class)((ParameterizedType)localObject.getGenericSuperclass()).getActualTypeArguments()[paramInt];
  }

  public static String getClassName(Class<?> paramClass)
  {
    return StringUtils.unqualify(paramClass.getName());
  }

  public static String getSpringBeanId(Class<?> paramClass)
  {
    return StringUtils.uncapitalize(getClassName(paramClass));
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.utility.ClassUtility
 * JD-Core Version:    0.6.2
 */