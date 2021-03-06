package gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="routeType")
@XmlEnum
public enum RouteType
{
  BUCCAL("BUCCAL"), CAUDAL_BLOCK("CAUDAL BLOCK"), CERVICAL("CERVICAL"), CONT_CAUDAL_INFUSION("CONT CAUDAL INFUSION"), CONT_INTRAARTER_INF("CONT INTRAARTER INF"), CONT_INTRAOSSEOUS("CONT INTRAOSSEOUS"), CONT_INTRATHECAL_INF("CONT INTRATHECAL INF"), CONT_NEBULIZATION("CONT NEBULIZATION"), CONT_SUBCUTAN_INFUSI("CONT SUBCUTAN INFUSI"), CONTINUOUS_EPIDURAL("CONTINUOUS EPIDURAL"), CONTINUOUS_INFILTRAT("CONTINUOUS INFILTRAT"), CONTINUOUS_INFUSION("CONTINUOUS INFUSION"), DENTAL("DENTAL"), ENDOTRACHEAL("ENDOTRACHEAL"), EPIDURAL("EPIDURAL"), EXTRACORPOREAL("EXTRACORPOREAL"), FEEDING_TUBE("FEEDING TUBE"), G_TUBE("G-TUBE"), HAND_BULB_NEBULIZER("HAND BULB NEBULIZER"), INFILTRATION("INFILTRATION"), INHALATION("INHALATION"), INTRA_ARTERIAL("INTRA-ARTERIAL"), INTRA_ARTICULAR("INTRA-ARTICULAR"), INTRA_CATHETER("INTRA-CATHETER"), INTRA_CAVERNOSAL("INTRA-CAVERNOSAL"), INTRA_URETHRAL("INTRA-URETHRAL"), INTRABURSAL("INTRABURSAL"), INTRACARDIAC("INTRACARDIAC"), INTRACAVITY("INTRACAVITY"), INTRADERMAL("INTRADERMAL"), INTRADETRUSOR("INTRADETRUSOR"), INTRADUCTAL("INTRADUCTAL"), INTRALESIONAL("INTRALESIONAL"), INTRALUMBAR("INTRALUMBAR"), INTRALYMPHATIC("INTRALYMPHATIC"), INTRAMUSCULAR("INTRAMUSCULAR"), INTRANASAL("INTRANASAL"), INTRAOCULAR("INTRAOCULAR"), INTRAOSSEOUS("INTRAOSSEOUS"), INTRAPERICARDIAL("INTRAPERICARDIAL"), INTRAPERITONEAL("INTRAPERITONEAL"), INTRAPLEURAL("INTRAPLEURAL"), INTRASPINAL("INTRASPINAL"), INTRASYNOVIAL("INTRASYNOVIAL"), INTRATHECAL("INTRATHECAL"), INTRATRACHEAL("INTRATRACHEAL"), INTRAUTERINE("INTRAUTERINE"), INTRAVARICEAL("INTRAVARICEAL"), INTRAVENOUS("INTRAVENOUS"), INTRAVENTRICULAR("INTRAVENTRICULAR"), INTRAVESICAL("INTRAVESICAL"), INTRAVITREAL("INTRAVITREAL"), IPPB("IPPB"), IRRIGATION("IRRIGATION"), J_TUBE("J-TUBE"), JUXTASCLERAL("JUXTASCLERAL"), MISCELLANEOUS("MISCELLANEOUS"), MUCOUS_MEMBRANE("MUCOUS MEMBRANE"), NEBULIZATION("NEBULIZATION"), NOT_APPLICABLE("NOT APPLICABLE"), O_2_AEROSOLIZATION("O2 AEROSOLIZATION"), OPHTHALMIC("OPHTHALMIC"), ORAL("ORAL"), OTIC("OTIC"), PERCUTANEOUS("PERCUTANEOUS"), PERFUSION("PERFUSION"), PERIBULBAR("PERIBULBAR"), RECTAL("RECTAL"), RETROBULBAR("RETROBULBAR"), SUB_TENON("SUB-TENON"), SUBCONJUNCTIVAL("SUBCONJUNCTIVAL"), SUBCUTANEOUS("SUBCUTANEOUS"), SUBDERMAL("SUBDERMAL"), SUBLESIONALLY("SUBLESIONALLY"), SUBLINGUAL("SUBLINGUAL"), SUBMUCOSAL_INJ("SUBMUCOSAL INJ"), TENDON_SHEATH_INJ("TENDON SHEATH INJ."), TOPICAL("TOPICAL"), TRANSDERMAL("TRANSDERMAL"), TRANSLINGUAL("TRANSLINGUAL"), TRANSTRACHEAL("TRANSTRACHEAL"), TRANSURETHRAL("TRANSURETHRAL"), VAGINAL("VAGINAL");

  private final String value;

  private RouteType(String paramString)
  {
    this.value = paramString;
  }

  public String value()
  {
    return this.value;
  }

  public static RouteType fromValue(String paramString)
  {
    for (RouteType localRouteType : values())
      if (localRouteType.value.equals(paramString))
        return localRouteType;
    throw new IllegalArgumentException(paramString);
  }
}

/* Location:           /Users/sam/Downloads/mocha-server-3.0.00.0073/JAR/ps_ms_common/
 * Qualified Name:     gov.va.med.pharmacy.peps.external.common.preencapsulation.vo.drug.check.request.RouteType
 * JD-Core Version:    0.6.2
 */