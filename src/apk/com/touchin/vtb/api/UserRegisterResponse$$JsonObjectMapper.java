package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class UserRegisterResponse$$JsonObjectMapper extends JsonMapper<UserRegisterResponse> {
    public UserRegisterResponse parse(e eVar) throws IOException {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
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
            parseField(userRegisterResponse, c2, eVar);
            eVar.G();
        }
        return userRegisterResponse;
    }

    public void parseField(UserRegisterResponse userRegisterResponse, String str, e eVar) throws IOException {
        if ("smsOperationId".equals(str)) {
            userRegisterResponse.a(eVar.c(null));
        }
    }

    public void serialize(UserRegisterResponse userRegisterResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (userRegisterResponse.b() != null) {
            cVar.a("smsOperationId", userRegisterResponse.b());
        }
        if (z) {
            cVar.c();
        }
    }
}
