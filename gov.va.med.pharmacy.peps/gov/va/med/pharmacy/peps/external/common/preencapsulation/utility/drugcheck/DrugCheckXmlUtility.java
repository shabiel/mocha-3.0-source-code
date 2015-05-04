package gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.drugcheck;

import gov.va.med.pharmacy.peps.common.vo.DrugDataVendorVersionVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckHeaderVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckResultsVo;
import gov.va.med.pharmacy.peps.common.vo.OrderCheckVo;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.XmlUtility;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.PEPSRequest;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.Body;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.DrugCheck;
import gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.response.PEPSResponse;
import javax.xml.bind.JAXBContext;

public final class DrugCheckXmlUtility extends XmlUtility
{
  private static final String REQUEST_PACKAGE = PEPSRequest.class.getPackage().getName();
  private static final String RESPONSE_PACKAGE = PEPSResponse.class.getPackage().getName();
  private static final JAXBContext REQUEST_CONTEXT = initializeJaxbContext(REQUEST_PACKAGE);
  private static final JAXBContext RESPONSE_CONTEXT = initializeJaxbContext(RESPONSE_PACKAGE);
  private static final String RESPONSE_NAMESPACE = RESPONSE_PACKAGE.replace('.', '/');
  private static final String RESPONSE_SCHEMA_LOCATION = RESPONSE_NAMESPACE + " " + "drugCheckSchemaOutput.xsd";
  private static final String REQUEST_NAMESPACE = REQUEST_PACKAGE.replace('.', '/');
  private static final String REQUEST_SCHEMA_LOCATION = REQUEST_NAMESPACE + " " + "drugCheckSchemaInput.xsd";
  private static final String[] REQUEST_CDATA_ELEMENTS = new String[0];
  private static final String[] RESPONSE_CDATA_ELEMENTS = { RESPONSE_NAMESPACE + "^reference" };
  private static final String REQUEST_SCHEMA_FILE = "schema/drugCheckSchemaInput.xsd";
  private static final String RESPONSE_SCHEMA_FILE = "schema/drugCheckSchemaOutput.xsd";

  public static boolean responseEquals(String paramString1, String paramString2)
  {
    PEPSResponse localPEPSResponse1 = unmarshalPepsResponse(paramString1, false);
    PEPSResponse localPEPSResponse2 = unmarshalPepsResponse(paramString2, false);
    boolean bool = true;
    bool &= localPEPSResponse1.isSetHeader() == localPEPSResponse2.isSetHeader();
    bool &= localPEPSResponse1.isSetBody() == localPEPSResponse2.isSetBody();
    if (bool)
    {
      Body localBody1 = localPEPSResponse2.getBody();
      Body localBody2 = localPEPSResponse1.getBody();
      if ((localBody1 != null) && (localBody2 != null))
      {
        DrugCheck localDrugCheck1 = localBody1.getDrugCheck();
        DrugCheck localDrugCheck2 = localBody2.getDrugCheck();
        if ((localDrugCheck1 != null) && (localDrugCheck2 != null))
        {
          bool &= localDrugCheck1.isSetDrugDoseChecks() == localDrugCheck2.isSetDrugDoseChecks();
          bool &= localDrugCheck1.isSetDrugDrugChecks() == localDrugCheck2.isSetDrugDrugChecks();
          bool &= localDrugCheck1.isSetDrugTherapyChecks() == localDrugCheck2.isSetDrugTherapyChecks();
          bool &= localDrugCheck1.isSetDrugsNotChecked() == localDrugCheck2.isSetDrugsNotChecked();
        }
      }
    }
    return bool;
  }

  private static PEPSResponse unmarshalPepsResponse(String paramString, boolean paramBoolean)
  {
    return (PEPSResponse)unmarshal(paramString, paramBoolean, RESPONSE_CONTEXT, "schema/drugCheckSchemaOutput.xsd", PEPSResponse.class);
  }

  private static PEPSRequest unmarshalPepsRequest(String paramString, boolean paramBoolean)
  {
    return (PEPSRequest)unmarshal(paramString, paramBoolean, REQUEST_CONTEXT, "schema/drugCheckSchemaInput.xsd", PEPSRequest.class);
  }

  public static OrderCheckVo toOrderCheckVo(String paramString)
  {
    return RequestConverter.toOrderCheckVo(unmarshalPepsRequest(paramString, true));
  }

  public static String toPepsResponse(OrderCheckResultsVo paramOrderCheckResultsVo)
  {
    return marshal(ResponseConverter.toPepsResponse(paramOrderCheckResultsVo), false);
  }

  public static String toPepsResponse(PEPSRequest paramPEPSRequest)
  {
    return marshal(paramPEPSRequest, false);
  }

  private static String marshal(PEPSRequest paramPEPSRequest, boolean paramBoolean)
  {
    return marshal(paramPEPSRequest, paramBoolean, REQUEST_CONTEXT, REQUEST_SCHEMA_LOCATION, "schema/drugCheckSchemaInput.xsd", REQUEST_CDATA_ELEMENTS);
  }

  private static String marshal(PEPSResponse paramPEPSResponse, boolean paramBoolean)
  {
    return marshal(paramPEPSResponse, paramBoolean, RESPONSE_CONTEXT, RESPONSE_SCHEMA_LOCATION, "schema/drugCheckSchemaOutput.xsd", RESPONSE_CDATA_ELEMENTS);
  }

  public static String createPingResponse(OrderCheckHeaderVo paramOrderCheckHeaderVo, DrugDataVendorVersionVo paramDrugDataVendorVersionVo)
  {
    return marshal(ResponseConverter.createPingResponse(paramOrderCheckHeaderVo, paramDrugDataVendorVersionVo), false);
  }

  public static boolean validatePepsRequest(String paramString)
  {
    unmarshalPepsRequest(paramString, true);
    return true;
  }

  public static String prettyPrintRequest(String paramString)
  {
    return prettyPrint(paramString, REQUEST_CONTEXT, REQUEST_SCHEMA_LOCATION, "schema/drugCheckSchemaInput.xsd", PEPSRequest.class, REQUEST_CDATA_ELEMENTS);
  }

  public static String prettyPrintRequest(PEPSRequest paramPEPSRequest)
  {
    return prettyPrint(paramPEPSRequest, REQUEST_CONTEXT, REQUEST_SCHEMA_LOCATION, "schema/drugCheckSchemaInput.xsd", REQUEST_CDATA_ELEMENTS);
  }

  public static String prettyPrintResponse(String paramString)
  {
    return prettyPrint(paramString, RESPONSE_CONTEXT, RESPONSE_SCHEMA_LOCATION, "schema/drugCheckSchemaOutput.xsd", PEPSResponse.class, RESPONSE_CDATA_ELEMENTS);
  }

  public static String prettyPrintResponse(PEPSResponse paramPEPSResponse)
  {
    return prettyPrint(paramPEPSResponse, RESPONSE_CONTEXT, RESPONSE_SCHEMA_LOCATION, "schema/drugCheckSchemaOutput.xsd", RESPONSE_CDATA_ELEMENTS);
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
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.utility.drugcheck.DrugCheckXmlUtility
 * JD-Core Version:    0.6.2
 */