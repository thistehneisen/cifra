package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class BaseUserRegisterResponse$$JsonObjectMapper extends JsonMapper<BaseUserRegisterResponse> {
    private static final JsonMapper<UserProfile> COM_TOUCHIN_VTB_API_USERPROFILE__JSONOBJECTMAPPER = LoganSquare.mapperFor(UserProfile.class);

    public BaseUserRegisterResponse parse(e eVar) throws IOException {
        BaseUserRegisterResponse baseUserRegisterResponse = new BaseUserRegisterResponse();
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
            parseField(baseUserRegisterResponse, c2, eVar);
            eVar.G();
        }
        return baseUserRegisterResponse;
    }

    public void parseField(BaseUserRegisterResponse baseUserRegisterResponse, String str, e eVar) throws IOException {
        if ("userProfile".equals(str)) {
            baseUserRegisterResponse.a((UserProfile) COM_TOUCHIN_VTB_API_USERPROFILE__JSONOBJECTMAPPER.parse(eVar));
        }
    }

    public void serialize(BaseUserRegisterResponse baseUserRegisterResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (baseUserRegisterResponse.b() != null) {
            cVar.c("userProfile");
            COM_TOUCHIN_VTB_API_USERPROFILE__JSONOBJECTMAPPER.serialize(baseUserRegisterResponse.b(), cVar, true);
        }
        if (z) {
            cVar.c();
        }
    }
}
