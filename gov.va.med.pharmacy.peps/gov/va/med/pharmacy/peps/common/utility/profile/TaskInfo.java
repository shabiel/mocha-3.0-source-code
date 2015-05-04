package gov.va.med.pharmacy.peps.common.utility.profile;

import org.apache.log4j.Logger;

public class TaskInfo
{
  private static final Logger LOG = Logger.getLogger(TaskInfo.class);
  private String name = null;
  private long start = 0L;
  private long total = 0L;
  private long count = 0L;
  private boolean running = false;
  private boolean paused = false;

  public TaskInfo(String paramString)
  {
    this.name = paramString;
  }

  public void start(long paramLong)
  {
    if ((this.running) || (this.paused))
    {
      LOG.trace("Can't start task " + this.name + ": it's already running. Try resuming the task!");
    }
    else
    {
      this.start = paramLong;
      this.count += 1L;
      this.running = true;
      this.paused = false;
    }
  }

  public void resume(long paramLong)
  {
    if (this.running)
    {
      LOG.trace("Can't resume task " + this.name + ": it's already running. Try pausing or stopping the task!");
    }
    else
    {
      this.start = paramLong;
      this.running = true;
      this.paused = false;
    }
  }

  public void stop(long paramLong)
  {
    if (this.running)
    {
      this.total += paramLong - this.start;
      this.running = false;
      this.paused = false;
    }
    else
    {
      LOG.trace("Can't stop task " + this.name + ": it's not running. Try starting the task!");
    }
  }

  public void pause(long paramLong)
  {
    if (this.running)
    {
      this.total += paramLong - this.start;
      this.running = false;
      this.paused = true;
    }
    else
    {
      LOG.trace("Can't pause task " + this.name + ": it's not running. Try starting the task!");
    }
  }

  public String getName()
  {
    return this.name;
  }

  public double getTotalTimeSeconds()
  {
    return this.total / 1000.0D;
  }

  public long getTotal()
  {
    return this.total;
  }

  public long getCount()
  {
    return this.count;
  }

  public String toString()
  {
    return this.name + " executed in " + this.total + " milliseconds";
  }

  public boolean isRunning()
  {
    return this.running;
  }

  public boolean isPaused()
  {
    return this.paused;
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.utility.profile.TaskInfo
 * JD-Core Version:    0.6.2
 */