package gov.va.med.pharmacy.peps.common.utility.profile;

import gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.ProcessOrderChecksCapability;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class ProfileRunner
{
  private static final Logger LOG = Logger.getLogger(ProfileRunner.class);

  public static void main(String[] paramArrayOfString)
    throws IOException
  {
    if (paramArrayOfString.length != 1)
    {
      LOG.error("Command line usage: ProfileRunner [xmlFilePath]");
      return;
    }
    LOG.info("Executing order check with XML file " + paramArrayOfString[0]);
    ClassPathXmlApplicationContext localClassPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[] { "xml/spring/peps/test/InterfaceContext.xml", "xml/spring/mocha/ProfileContextDynamic.xml" });
    ProcessOrderChecksCapability localProcessOrderChecksCapability = (ProcessOrderChecksCapability)localClassPathXmlApplicationContext.getBean("ProcessOrderChecksCapability");
    InputStream localInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(paramArrayOfString[0]);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
    StringBuffer localStringBuffer = new StringBuffer();
    for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine())
      localStringBuffer.append(str);
    localProcessOrderChecksCapability.handleRequest(localStringBuffer.toString());
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.common.utility.profile.ProfileRunner
 * JD-Core Version:    0.6.2
 */