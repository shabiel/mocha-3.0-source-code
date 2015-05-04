package gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.impl;

import gov.va.med.pharmacy.peps.common.exception.InterfaceException;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.DrugCheckType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.RandomOrderCheckCapability;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.drugcheck.DrugCheckXmlUtility;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Body;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Checks;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Demographics;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DoseInformation;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DoseRateType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DoseTypeType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DoseUnitType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Drug;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DrugCheck;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DrugDoseCheck;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.DurationRateType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Header;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.MServer;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.MUser;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.MedicationProfile;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.ObjectFactory;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.PEPSRequest;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.ProspectiveDrugs;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.RouteType;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.Time;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class RandomOrderCheckCapabilityImpl
  implements RandomOrderCheckCapability
{
  private static final int MIN_PROSPECTIVE_DRUGS = 2;
  private static final int MAX_PROSPECTIVE_DRUGS = 10;
  private static final int MIN_PROFILE_DRUGS = 0;
  private static final int MAX_PROFILE_DRUGS = 10;
  private static final Random RANDOM = new Random(System.currentTimeMillis());
  private static final List<BigInteger> AVAILABLE_GCN = Collections.synchronizedList(new ArrayList(23815));
  private static final List<BigInteger> AVAILABLE_DOSING_GCN = Collections.synchronizedList(new ArrayList(12496));
  private static final Set<String> USED_ORDER_NUMBERS = Collections.synchronizedSet(new HashSet());
  private static final String LINE_SEPARATOR = System.getProperty("line.separator");
  private JdbcTemplate jdbcTemplate;

  private void writeRandomOrderChecks(String paramString, DrugCheckType paramDrugCheckType)
    throws IOException
  {
    FileWriter localFileWriter = new FileWriter(paramString);
    BufferedWriter localBufferedWriter = new BufferedWriter(localFileWriter);
    for (int i = 0; i < 200; i++)
    {
      localBufferedWriter.write(getRandomOrderCheck(paramDrugCheckType));
      localBufferedWriter.write(LINE_SEPARATOR);
      System.out.println(StringUtils.leftPad(String.valueOf(i + 1), 4));
    }
    System.out.println();
    localBufferedWriter.close();
  }

  protected final void initialize()
  {
    if (AVAILABLE_GCN.isEmpty())
      AVAILABLE_GCN.addAll(getAvailableGcnSequenceNumbers());
    if (AVAILABLE_DOSING_GCN.isEmpty())
      AVAILABLE_DOSING_GCN.addAll(getAvailableDosingGcnSequenceNumbers());
  }

  public final String getRandomOrderCheck(DrugCheckType paramDrugCheckType)
  {
    try
    {
      initialize();
      ObjectFactory localObjectFactory = new ObjectFactory();
      PEPSRequest localPEPSRequest = localObjectFactory.createPEPSRequest();
      localPEPSRequest.setHeader(randomHeader(localObjectFactory));
      localPEPSRequest.setBody(randomBody(localObjectFactory, paramDrugCheckType));
      String str = DrugCheckXmlUtility.toPepsResponse(localPEPSRequest);
      str = str.replaceAll("[\\r\\n]", "");
      return str;
    }
    catch (JAXBException localJAXBException)
    {
      throw new InterfaceException(localJAXBException, InterfaceException.INTERFACE_ERROR, new Object[] { "PRE Encapsulation" });
    }
  }

  private Header randomHeader(ObjectFactory paramObjectFactory)
    throws JAXBException
  {
    Header localHeader = paramObjectFactory.createHeader();
    MServer localMServer = paramObjectFactory.createMServer();
    localMServer.setIp(randomPositiveInt(256) + "." + randomPositiveInt(256) + "." + randomPositiveInt(256) + "." + randomPositiveInt(256));
    localMServer.setNamespace(randomAlphabetic(10));
    localMServer.setServerName(randomAlphabetic(10));
    localMServer.setStationNumber(new BigInteger(String.valueOf(randomPositiveInt())));
    localMServer.setUci(randomAlphabetic(10));
    localHeader.setMServer(localMServer);
    MUser localMUser = paramObjectFactory.createMUser();
    localMUser.setDuz(new BigInteger(String.valueOf(randomPositiveInt())));
    localMUser.setJobNumber(new BigInteger(String.valueOf(randomPositiveInt())));
    localMUser.setUserName(randomAlphabetic(10));
    localHeader.setMUser(localMUser);
    Time localTime = paramObjectFactory.createTime();
    localTime.setValue(new Date().toString());
    localHeader.setTime(localTime);
    return localHeader;
  }

  private Body randomBody(ObjectFactory paramObjectFactory, DrugCheckType paramDrugCheckType)
    throws JAXBException
  {
    Body localBody = paramObjectFactory.createBody();
    DrugCheck localDrugCheck = paramObjectFactory.createDrugCheck();
    localBody.setDrugCheck(localDrugCheck);
    Checks localChecks = paramObjectFactory.createChecks();
    localDrugCheck.setChecks(localChecks);
    localChecks.setProspectiveOnly(RANDOM.nextBoolean());
    boolean bool1 = (DrugCheckType.ALL.equals(paramDrugCheckType)) || (DrugCheckType.DRUG_DRUG.equals(paramDrugCheckType));
    boolean bool2 = (DrugCheckType.ALL.equals(paramDrugCheckType)) || (DrugCheckType.DRUG_THERAPY.equals(paramDrugCheckType));
    for (boolean bool3 = (DrugCheckType.ALL.equals(paramDrugCheckType)) || (DrugCheckType.DRUG_DOSE.equals(paramDrugCheckType)); (!bool1) && (!bool2) && (!bool3); bool3 = RANDOM.nextBoolean())
    {
      bool1 = RANDOM.nextBoolean();
      bool2 = RANDOM.nextBoolean();
    }
    if (bool1)
      localChecks.setDrugDrugCheck(paramObjectFactory.createDrugDrugCheck());
    if (bool2)
      localChecks.setDrugTherapyCheck(paramObjectFactory.createDrugTherapyCheck());
    if (bool3)
      localChecks.setDrugDoseCheck(randomDrugDoseCheck(paramObjectFactory));
    localDrugCheck.setProspectiveDrugs(randomProspectiveDrugs(paramObjectFactory, bool3));
    localDrugCheck.setMedicationProfile(randomMedicationProfile(paramObjectFactory));
    return localBody;
  }

  private DrugDoseCheck randomDrugDoseCheck(ObjectFactory paramObjectFactory)
  {
    DrugDoseCheck localDrugDoseCheck = paramObjectFactory.createDrugDoseCheck();
    Demographics localDemographics = paramObjectFactory.createDemographics();
    localDemographics.setAgeInDays(randomPositiveInt(6570, 23725));
    localDemographics.setBodySurfaceAreaInSqM(randomPositiveDouble(1.5D, 3.5D));
    localDemographics.setWeightInKG(randomPositiveDouble(50.0D, 225.0D));
    localDrugDoseCheck.setDemographics(localDemographics);
    return localDrugDoseCheck;
  }

  private DoseInformation randomDoseInformation(BigInteger paramBigInteger, ObjectFactory paramObjectFactory)
  {
    DoseInformation localDoseInformation = paramObjectFactory.createDoseInformation();
    populateDoseInformation(paramBigInteger, localDoseInformation);
    localDoseInformation.setDoseAmount(randomPositiveDouble(3) + 1.0D);
    int i = randomPositiveInt(6);
    localDoseInformation.setDoseRate(DoseRateType.values()[i]);
    localDoseInformation.setDuration(BigInteger.valueOf(randomPositiveLong()));
    localDoseInformation.setDurationRate(DurationRateType.fromValue(localDoseInformation.getDoseRate().value()));
    localDoseInformation.setFrequency(String.valueOf(randomPositiveInt()));
    return localDoseInformation;
  }

  private MedicationProfile randomMedicationProfile(ObjectFactory paramObjectFactory)
    throws JAXBException
  {
    MedicationProfile localMedicationProfile = null;
    int i = RANDOM.nextInt(10);
    if (i > 0)
    {
      localMedicationProfile = paramObjectFactory.createMedicationProfile();
      for (int j = 0; j < i; j++)
        localMedicationProfile.getDrug().add(randomDrug(paramObjectFactory, false));
    }
    return localMedicationProfile;
  }

  private ProspectiveDrugs randomProspectiveDrugs(ObjectFactory paramObjectFactory, boolean paramBoolean)
    throws JAXBException
  {
    ProspectiveDrugs localProspectiveDrugs = paramObjectFactory.createProspectiveDrugs();
    int i = RANDOM.nextInt(8) + 8;
    for (int j = 0; j < i; j++)
    {
      boolean bool = (paramBoolean) && (randomBoolean());
      localProspectiveDrugs.getDrug().add(randomDrug(paramObjectFactory, bool));
    }
    return localProspectiveDrugs;
  }

  private Drug randomDrug(ObjectFactory paramObjectFactory, boolean paramBoolean)
  {
    Drug localDrug = paramObjectFactory.createDrug();
    BigInteger localBigInteger;
    if (paramBoolean)
    {
      localBigInteger = getRandomDosingGcnSequenceNumber();
      localDrug.setDoseInformation(randomDoseInformation(localBigInteger, paramObjectFactory));
    }
    else
    {
      localBigInteger = getRandomGcnSequenceNumber();
    }
    localDrug.setGcnSeqNo(localBigInteger);
    localDrug.setIen(BigInteger.valueOf(randomPositiveLong()));
    String str;
    do
      str = String.valueOf(randomPositiveInt());
    while (USED_ORDER_NUMBERS.contains(str));
    USED_ORDER_NUMBERS.add(str);
    localDrug.setOrderNumber(str);
    return localDrug;
  }

  private List<BigInteger> getAvailableGcnSequenceNumbers()
  {
    String str = "SELECT GCNSEQNO FROM FDB_GENERIC_DISPENSABLE WHERE GCNSEQNO > 0";
    return this.jdbcTemplate.queryForList(str, BigInteger.class);
  }

  private List<BigInteger> getAvailableDosingGcnSequenceNumbers()
  {
    String str = "SELECT DISTINCT GCNSEQNO FROM FDB_DOSERANGECHECK WHERE DOSELOWUNITS IS NOT NULL";
    return this.jdbcTemplate.queryForList(str, BigInteger.class);
  }

  private void populateDoseInformation(BigInteger paramBigInteger, DoseInformation paramDoseInformation)
  {
    String str1 = "SELECT COUNT(1) FROM FDB_DOSERANGECHECK WHERE GCNSEQNO = ? AND DOSELOWUNITS IS NOT NULL";
    int i = this.jdbcTemplate.queryForInt(str1, new Object[] { Integer.valueOf(paramBigInteger.intValue()) });
    String str2 = "SELECT DOSEROUTEID, DOSETYPEID, DOSELOWUNITS FROM FDB_DOSERANGECHECK WHERE GCNSEQNO = ? AND DOSELOWUNITS IS NOT NULL";
    SqlRowSet localSqlRowSet = this.jdbcTemplate.queryForRowSet(str2, new Object[] { Integer.valueOf(paramBigInteger.intValue()) });
    localSqlRowSet.absolute(randomPositiveInt(i) + 1);
    String str3 = localSqlRowSet.getString(1);
    String str4 = localSqlRowSet.getString(2);
    String str5 = localSqlRowSet.getString(3);
    paramDoseInformation.setRoute(getDoseRoute(str3));
    paramDoseInformation.setDoseType(getDoseType(str4));
    paramDoseInformation.setDoseUnit(getDoseUnit(str5));
  }

  private RouteType getDoseRoute(String paramString)
  {
    String str1 = "SELECT DESCRIPTION1 FROM FDB_DOSEROUTE WHERE DOSEROUTEID = ?";
    String str2 = (String)this.jdbcTemplate.queryForObject(str1, new Object[] { paramString }, String.class);
    return RouteType.fromValue(str2);
  }

  private DoseTypeType getDoseType(String paramString)
  {
    String str1 = "SELECT DESCRIPTION1 FROM FDB_DOSETYPE WHERE DOSETYPEID = ?";
    String str2 = (String)this.jdbcTemplate.queryForObject(str1, new Object[] { paramString }, String.class);
    return DoseTypeType.fromValue(str2);
  }

  private DoseUnitType getDoseUnit(String paramString)
  {
    int i = paramString.indexOf(47);
    String str;
    if (i < 0)
      str = paramString;
    else
      str = paramString.substring(0, i);
    return DoseUnitType.fromValue(str);
  }

  private BigInteger getRandomGcnSequenceNumber()
  {
    return (BigInteger)AVAILABLE_GCN.get(randomPositiveInt(AVAILABLE_GCN.size()));
  }

  private BigInteger getRandomDosingGcnSequenceNumber()
  {
    return (BigInteger)AVAILABLE_DOSING_GCN.get(randomPositiveInt(AVAILABLE_DOSING_GCN.size()));
  }

  private boolean randomBoolean()
  {
    return randomPositiveInt(2) == 0;
  }

  private int randomPositiveInt(int paramInt)
  {
    if ((paramInt == -2147483648) || (paramInt == 0))
      paramInt = 1;
    return Math.abs(RANDOM.nextInt(Math.abs(paramInt)));
  }

  private int randomPositiveInt(int paramInt1, int paramInt2)
  {
    return (int)randomPositiveDouble(paramInt1, paramInt2);
  }

  private int randomPositiveInt()
  {
    return randomPositiveInt(2147483647);
  }

  private long randomPositiveLong()
  {
    return Math.abs(RANDOM.nextLong());
  }

  private double randomPositiveDouble(int paramInt)
  {
    long l = 0xA ^ paramInt;
    return Math.abs(RANDOM.nextDouble() * l);
  }

  private double randomPositiveDouble(double paramDouble1, double paramDouble2)
  {
    double d = RANDOM.nextDouble();
    return d * (paramDouble2 - paramDouble1) + paramDouble1;
  }

  private String randomAlphabetic(int paramInt)
  {
    return RandomStringUtils.randomAlphabetic(paramInt);
  }

  public final void setDataSource(DataSource paramDataSource)
  {
    this.jdbcTemplate = new JdbcTemplate(paramDataSource);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.capability.impl.RandomOrderCheckCapabilityImpl
 * JD-Core Version:    0.6.2
 */