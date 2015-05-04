package gov.va.med.pharmacy.peps.common.utility.profile;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.apache.log4j.Logger;

public class StopWatch
{
  private static final Logger LOG = Logger.getLogger(StopWatch.class);
  private static final String LINE_SEPARATOR = System.getProperty("line.separator");
  private long start = 0L;
  private long total = 0L;
  private Map<String, TaskInfo> tasks = new LinkedHashMap();
  private Stack<String> taskNames = new Stack();

  public void start(String paramString)
  {
    long l = System.currentTimeMillis();
    if (!this.tasks.containsKey(paramString))
      this.tasks.put(paramString, new TaskInfo(paramString));
    if (this.start == 0L)
      this.start = l;
    if (!this.taskNames.isEmpty())
      ((TaskInfo)this.tasks.get(this.taskNames.peek())).pause(l);
    ((TaskInfo)this.tasks.get(paramString)).start(l);
    this.taskNames.push(paramString);
  }

  public void stop(String paramString)
  {
    long l = System.currentTimeMillis();
    this.total = (l - this.start);
    if (this.tasks.containsKey(paramString))
    {
      if (!this.taskNames.isEmpty())
      {
        this.taskNames.pop();
        if (!this.taskNames.isEmpty())
          ((TaskInfo)this.tasks.get(this.taskNames.peek())).resume(l);
      }
      ((TaskInfo)this.tasks.get(paramString)).stop(l);
    }
    else
    {
      LOG.warn("Unable to find task " + paramString + " to stop profile stop watch");
    }
  }

  public long getTotal()
  {
    return this.total;
  }

  public void reset()
  {
    this.start = 0L;
    this.total = 0L;
    this.tasks = new LinkedHashMap();
    this.taskNames = new Stack();
  }

  public String prettyPrint(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(LINE_SEPARATOR);
    localStringBuffer.append(getTotal());
    localStringBuffer.append(" milliseconds total execution time for ");
    localStringBuffer.append(paramString);
    localStringBuffer.append(LINE_SEPARATOR);
    localStringBuffer.append("-------------------------------------------------");
    localStringBuffer.append(LINE_SEPARATOR);
    localStringBuffer.append("ms     %     Count  Task name");
    localStringBuffer.append(LINE_SEPARATOR);
    localStringBuffer.append("-------------------------------------------------");
    localStringBuffer.append(LINE_SEPARATOR);
    NumberFormat localNumberFormat1 = NumberFormat.getNumberInstance();
    localNumberFormat1.setMinimumIntegerDigits(5);
    localNumberFormat1.setGroupingUsed(false);
    NumberFormat localNumberFormat2 = NumberFormat.getPercentInstance();
    localNumberFormat2.setMinimumIntegerDigits(3);
    localNumberFormat2.setGroupingUsed(false);
    Iterator localIterator = this.tasks.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      TaskInfo localTaskInfo = (TaskInfo)this.tasks.get(str);
      localStringBuffer.append(localNumberFormat1.format(localTaskInfo.getTotal()));
      localStringBuffer.append("  ");
      if (getTotal() == 0L)
        localStringBuffer.append(localNumberFormat2.format(1.0D));
      else
        localStringBuffer.append(localNumberFormat2.format(1.0D * localTaskInfo.getTotal() / getTotal()));
      localStringBuffer.append("  ");
      localStringBuffer.append(localNumberFormat1.format(localTaskInfo.getCount()));
      localStringBuffer.append("  ");
      localStringBuffer.append(localTaskInfo.getName());
      localStringBuffer.append(LINE_SEPARATOR);
    }
    reset();
    return localStringBuffer.toString();
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.utility.profile.StopWatch
 * JD-Core Version:    0.6.2
 */