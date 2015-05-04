package gov.va.med.pharmacy.peps.common.utility.profile;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class Profiler
{
  private static final Logger LOG = Logger.getLogger(Profiler.class);
  private static ThreadLocal<StopWatch> THREAD_LOCAL = new ThreadLocal()
  {
    protected synchronized StopWatch initialValue()
    {
      return new StopWatch();
    }
  };

  public Object profile(ProceedingJoinPoint paramProceedingJoinPoint)
    throws Throwable
  {
    try
    {
      getStopWatch().start(paramProceedingJoinPoint.getSignature().toLongString());
      Object localObject1 = paramProceedingJoinPoint.proceed();
      return localObject1;
    }
    finally
    {
      getStopWatch().stop(paramProceedingJoinPoint.getSignature().toLongString());
    }
  }

  public Object logProfile(ProceedingJoinPoint paramProceedingJoinPoint)
    throws Throwable
  {
    Object localObject = paramProceedingJoinPoint.proceed();
    LOG.info(getStopWatch().prettyPrint(paramProceedingJoinPoint.getSignature().toLongString()));
    return localObject;
  }

  private StopWatch getStopWatch()
  {
    return (StopWatch)THREAD_LOCAL.get();
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.utility.profile.Profiler
 * JD-Core Version:    0.6.2
 */