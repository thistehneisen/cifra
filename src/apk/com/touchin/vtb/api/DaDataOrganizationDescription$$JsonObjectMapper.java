package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class DaDataOrganizationDescription$$JsonObjectMapper extends JsonMapper<DaDataOrganizationDescription> {
    private static final JsonMapper<DaDataAddress> COM_TOUCHIN_VTB_API_DADATAADDRESS__JSONOBJECTMAPPER = LoganSquare.mapperFor(DaDataAddress.class);
    private static final JsonMapper<DaDataOpf> COM_TOUCHIN_VTB_API_DADATAOPF__JSONOBJECTMAPPER = LoganSquare.mapperFor(DaDataOpf.class);
    private static final JsonMapper<DaDataStatus> COM_TOUCHIN_VTB_API_DADATASTATUS__JSONOBJECTMAPPER = LoganSquare.mapperFor(DaDataStatus.class);

    public DaDataOrganizationDescription parse(e eVar) throws IOException {
        DaDataOrganizationDescription daDataOrganizationDescription = new DaDataOrganizationDescription();
        if (eVar.d() == null) {
            eVar.F();
        }
        if (eVar.d() != g.START_OBJECT) {
            eVar.G();
            return null;
        }
        while (eVar.F() != g.END_OBJECT) {
            String c2 = eVar.c();
            eVar.F();
            parseField(daDataOrganizationDescription, c2, eVar);
            eVar.G();
        }
        return daDataOrganizationDescription;
    }

    public void parseField(DaDataOrganizationDescription daDataOrganizationDescription, String str, e eVar) throws IOException {
        if ("address".equals(str)) {
            daDataOrganizationDescription.a((DaDataAddress) COM_TOUCHIN_VTB_API_DADATAADDRESS__JSONOBJECTMAPPER.parse(eVar));
        } else if ("inn".equals(str)) {
            daDataOrganizationDescription.a(eVar.c(null));
        } else if ("opf".equals(str)) {
            daDataOrganizationDescription.a((DaDataOpf) COM_TOUCHIN_VTB_API_DADATAOPF__JSONOBJECTMAPPER.parse(eVar));
        } else if ("ogrn".equals(str)) {
            daDataOrganizationDescription.b(eVar.c(null));
        } else if ("state".equals(str)) {
            daDataOrganizationDescription.a((DaDataStatus) COM_TOUCHIN_VTB_API_DADATASTATUS__JSONOBJECTMAPPER.parse(eVar));
        }
    }

    public void serialize(DaDataOrganizationDescription daDataOrganizationDescription, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (daDataOrganizationDescription.b() != null) {
            cVar.c("address");
            COM_TOUCHIN_VTB_API_DADATAADDRESS__JSONOBJECTMAPPER.serialize(daDataOrganizationDescription.b(), cVar, true);
        }
        if (daDataOrganizationDescription.c() != null) {
            cVar.a("inn", daDataOrganizationDescription.c());
        }
        if (daDataOrganizationDescription.d() != null) {
            cVar.c("opf");
            COM_TOUCHIN_VTB_API_DADATAOPF__JSONOBJECTMAPPER.serialize(daDataOrganizationDescription.d(), cVar, true);
        }
        if (daDataOrganizationDescription.e() != null) {
            cVar.a("ogrn", daDataOrganizationDescription.e());
        }
        if (daDataOrganizationDescription.f() != null) {
            cVar.c("state");
            COM_TOUCHIN_VTB_API_DADATASTATUS__JSONOBJECTMAPPER.serialize(daDataOrganizationDescription.f(), cVar, true);
        }
        if (z) {
            cVar.c();
        }
    }
}
