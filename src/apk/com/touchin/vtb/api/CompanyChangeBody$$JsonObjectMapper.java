package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class CompanyChangeBody$$JsonObjectMapper extends JsonMapper<CompanyChangeBody> {
    private static final JsonMapper<CompanyInfo> COM_TOUCHIN_VTB_API_COMPANYINFO__JSONOBJECTMAPPER = LoganSquare.mapperFor(CompanyInfo.class);
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    public CompanyChangeBody parse(e eVar) throws IOException {
        CompanyChangeBody companyChangeBody = new CompanyChangeBody();
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
            parseField(companyChangeBody, c2, eVar);
            eVar.G();
        }
        return companyChangeBody;
    }

    public void parseField(CompanyChangeBody companyChangeBody, String str, e eVar) throws IOException {
        if ("companyInfo".equals(str)) {
            companyChangeBody.a((CompanyInfo) COM_TOUCHIN_VTB_API_COMPANYINFO__JSONOBJECTMAPPER.parse(eVar));
        } else {
            parentObjectMapper.parseField(companyChangeBody, str, eVar);
        }
    }

    public void serialize(CompanyChangeBody companyChangeBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (companyChangeBody.c() != null) {
            cVar.c("companyInfo");
            COM_TOUCHIN_VTB_API_COMPANYINFO__JSONOBJECTMAPPER.serialize(companyChangeBody.c(), cVar, true);
        }
        parentObjectMapper.serialize(companyChangeBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
