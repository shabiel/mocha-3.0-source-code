package gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.druginfo;

import gov.va.med.pharmacy.peps.common.vo.DrugInfoResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DrugInfoVo;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.XmlUtility;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.request.DrugInfoRequest;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.info.response.DrugInfoResponse;
import java.util.Collection;
import javax.xml.bind.JAXBContext;

public final class DrugInfoXmlUtility extends XmlUtility
{
  private static final String REQUEST_PACKAGE = DrugInfoRequest.class.getPackage().getName();
  private static final String RESPONSE_PACKAGE = DrugInfoResponse.class.getPackage().getName();
  private static final JAXBContext REQUEST_CONTEXT = initializeJaxbContext(REQUEST_PACKAGE);
  private static final JAXBContext RESPONSE_CONTEXT = initializeJaxbContext(RESPONSE_PACKAGE);
  private static final String RESPONSE_NAMESPACE = RESPONSE_PACKAGE.replace('.', '/');
  private static final String RESPONSE_SCHEMA_LOCATION = RESPONSE_NAMESPACE + " " + "drugInfoSchemaOutput.xsd";
  private static final String REQUEST_NAMESPACE = REQUEST_PACKAGE.replace('.', '/');
  private static final String REQUEST_SCHEMA_LOCATION = REQUEST_NAMESPACE + " " + "drugInfoSchemaInput.xsd";
  private static final String[] REQUEST_CDATA_ELEMENTS = new String[0];
  private static final String[] RESPONSE_CDATA_ELEMENTS = { RESPONSE_NAMESPACE + "^references" };
  private static final String REQUEST_SCHEMA_FILE = "schema/drugInfoSchemaInput.xsd";
  private static final String RESPONSE_SCHEMA_FILE = "schema/drugInfoSchemaOutput.xsd";

  public static Collection<DrugInfoVo> toDrugInfoVo(String paramString)
  {
    return RequestConverter.toDrugInfoVo((DrugInfoRequest)unmarshal(paramString, true, REQUEST_CONTEXT, "schema/drugInfoSchemaInput.xsd", DrugInfoRequest.class));
  }

  public static String toDrugInfoResponse(DrugInfoResultsVo paramDrugInfoResultsVo)
  {
    return marshal(ResponseConverter.toDrugInfoResponse(paramDrugInfoResultsVo), false, RESPONSE_CONTEXT, RESPONSE_SCHEMA_LOCATION, "schema/drugInfoSchemaOutput.xsd", RESPONSE_CDATA_ELEMENTS);
  }

  public static String prettyPrintRequest(String paramString)
  {
    return prettyPrint(paramString, REQUEST_CONTEXT, REQUEST_SCHEMA_LOCATION, "schema/drugInfoSchemaInput.xsd", DrugInfoRequest.class, REQUEST_CDATA_ELEMENTS);
  }

  public static String prettyPrintRequest(DrugInfoRequest paramDrugInfoRequest)
  {
    return prettyPrint(paramDrugInfoRequest, REQUEST_CONTEXT, REQUEST_SCHEMA_LOCATION, "schema/drugInfoSchemaInput.xsd", REQUEST_CDATA_ELEMENTS);
  }

  public static String prettyPrintResponse(String paramString)
  {
    return prettyPrint(paramString, RESPONSE_CONTEXT, RESPONSE_SCHEMA_LOCATION, "schema/drugInfoSchemaOutput.xsd", DrugInfoResponse.class, RESPONSE_CDATA_ELEMENTS);
  }

  public static String prettyPrintResponse(DrugInfoResponse paramDrugInfoResponse)
  {
    return prettyPrint(paramDrugInfoResponse, RESPONSE_CONTEXT, RESPONSE_SCHEMA_LOCATION, "schema/drugInfoSchemaOutput.xsd", RESPONSE_CDATA_ELEMENTS);
  }

  public static String prettyPrint(String paramString)
  {
    if (paramString.contains(REQUEST_SCHEMA_LOCATION))
      return prettyPrintRequest(paramString);
    if (paramString.contains(RESPONSE_SCHEMA_LOCATION))
      return prettyPrintResponse(paramString);
    if (paramString.contains(EXCEPTION_SCHEMA_LOCATION))
      return prettyPrintException(paramString);
    return paramString;
  }

  public static boolean responseEquals(String paramString1, String paramString2)
  {
    DrugInfoResponse localDrugInfoResponse1 = (DrugInfoResponse)unmarshal(paramString1, false, RESPONSE_CONTEXT, "schema/drugInfoSchemaOutput.xsd", DrugInfoResponse.class);
    DrugInfoResponse localDrugInfoResponse2 = (DrugInfoResponse)unmarshal(paramString2, false, RESPONSE_CONTEXT, "schema/drugInfoSchemaOutput.xsd", DrugInfoResponse.class);
    return localDrugInfoResponse1.equals(localDrugInfoResponse2);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.druginfo.DrugInfoXmlUtility
 * JD-Core Version:    0.6.2
 */