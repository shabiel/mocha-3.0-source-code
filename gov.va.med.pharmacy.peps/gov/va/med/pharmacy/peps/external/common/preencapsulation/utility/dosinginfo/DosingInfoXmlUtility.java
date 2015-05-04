package gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.dosinginfo;

import gov.va.med.pharmacy.peps.common.vo.DosingInfoResultsVo;
import gov.va.med.pharmacy.peps.common.vo.DosingInfoVo;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.XmlUtility;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.request.DosingInfoRequest;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.dosing.info.response.DosingInfoResponse;
import java.util.Collection;
import javax.xml.bind.JAXBContext;

public final class DosingInfoXmlUtility extends XmlUtility
{
  private static final String REQUEST_PACKAGE = DosingInfoRequest.class.getPackage().getName();
  private static final String RESPONSE_PACKAGE = DosingInfoResponse.class.getPackage().getName();
  private static final JAXBContext REQUEST_CONTEXT = initializeJaxbContext(REQUEST_PACKAGE);
  private static final JAXBContext RESPONSE_CONTEXT = initializeJaxbContext(RESPONSE_PACKAGE);
  private static final String RESPONSE_NAMESPACE = RESPONSE_PACKAGE.replace('.', '/');
  private static final String RESPONSE_SCHEMA_LOCATION = RESPONSE_NAMESPACE + " " + "dosingInfoSchemaOutput.xsd";
  private static final String REQUEST_NAMESPACE = REQUEST_PACKAGE.replace('.', '/');
  private static final String REQUEST_SCHEMA_LOCATION = REQUEST_NAMESPACE + " " + "dosingInfoSchemaInput.xsd";
  private static final String[] REQUEST_CDATA_ELEMENTS = new String[0];
  private static final String[] RESPONSE_CDATA_ELEMENTS = { RESPONSE_NAMESPACE + "^references" };
  private static final String REQUEST_SCHEMA_FILE = "schema/dosingInfoSchemaInput.xsd";
  private static final String RESPONSE_SCHEMA_FILE = "schema/dosingInfoSchemaOutput.xsd";

  public static Collection<DosingInfoVo> toDosingInfoVo(String paramString)
  {
    return RequestConverter.toDosingInfoVo((DosingInfoRequest)unmarshal(paramString, true, REQUEST_CONTEXT, "schema/dosingInfoSchemaInput.xsd", DosingInfoRequest.class));
  }

  public static String toDosingInfoResponse(DosingInfoResultsVo paramDosingInfoResultsVo)
  {
    return marshal(ResponseConverter.toDosingInfoResponse(paramDosingInfoResultsVo), false, RESPONSE_CONTEXT, RESPONSE_SCHEMA_LOCATION, "schema/dosingInfoSchemaOutput.xsd", RESPONSE_CDATA_ELEMENTS);
  }

  public static String prettyPrintRequest(String paramString)
  {
    return prettyPrint(paramString, REQUEST_CONTEXT, REQUEST_SCHEMA_LOCATION, "schema/dosingInfoSchemaInput.xsd", DosingInfoRequest.class, REQUEST_CDATA_ELEMENTS);
  }

  public static String prettyPrintRequest(DosingInfoRequest paramDosingInfoRequest)
  {
    return prettyPrint(paramDosingInfoRequest, REQUEST_CONTEXT, REQUEST_SCHEMA_LOCATION, "schema/dosingInfoSchemaInput.xsd", REQUEST_CDATA_ELEMENTS);
  }

  public static String prettyPrintResponse(String paramString)
  {
    return prettyPrint(paramString, RESPONSE_CONTEXT, RESPONSE_SCHEMA_LOCATION, "schema/dosingInfoSchemaOutput.xsd", DosingInfoResponse.class, RESPONSE_CDATA_ELEMENTS);
  }

  public static String prettyPrintResponse(DosingInfoResponse paramDosingInfoResponse)
  {
    return prettyPrint(paramDosingInfoResponse, RESPONSE_CONTEXT, RESPONSE_SCHEMA_LOCATION, "schema/dosingInfoSchemaOutput.xsd", RESPONSE_CDATA_ELEMENTS);
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
    DosingInfoResponse localDosingInfoResponse1 = (DosingInfoResponse)unmarshal(paramString1, false, RESPONSE_CONTEXT, "schema/dosingInfoSchemaOutput.xsd", DosingInfoResponse.class);
    DosingInfoResponse localDosingInfoResponse2 = (DosingInfoResponse)unmarshal(paramString2, false, RESPONSE_CONTEXT, "schema/dosingInfoSchemaOutput.xsd", DosingInfoResponse.class);
    return localDosingInfoResponse1.equals(localDosingInfoResponse2);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.dosinginfo.DosingInfoXmlUtility
 * JD-Core Version:    0.6.2
 */