package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class UserRegisterConfirmResponse$$JsonObjectMapper extends JsonMapper<UserRegisterConfirmResponse> {
    private static final JsonMapper<BaseUserRegisterResponse> parentObjectMapper = LoganSquare.mapperFor(BaseUserRegisterResponse.class);

    public UserRegisterConfirmResponse parse(e eVar) throws IOException {
        UserRegisterConfirmResponse userRegisterConfirmResponse = new UserRegisterConfirmResponse();
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
            parseField(userRegisterConfirmResponse, c2, eVar);
            eVar.G();
        }
        return userRegisterConfirmResponse;
    }

    public void parseField(UserRegisterConfirmResponse userRegisterConfirmResponse, String str, e eVar) throws IOException {
        if ("success".equals(str)) {
            userRegisterConfirmResponse.a(eVar.k());
        } else {
            parentObjectMapper.parseField(userRegisterConfirmResponse, str, eVar);
        }
    }

    public void serialize(UserRegisterConfirmResponse userRegisterConfirmResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        cVar.a("success", userRegisterConfirmResponse.c());
        parentObjectMapper.serialize(userRegisterConfirmResponse, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
