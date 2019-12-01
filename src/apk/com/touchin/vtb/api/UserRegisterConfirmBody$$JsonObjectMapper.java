package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class UserRegisterConfirmBody$$JsonObjectMapper extends JsonMapper<UserRegisterConfirmBody> {
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    public UserRegisterConfirmBody parse(e eVar) throws IOException {
        UserRegisterConfirmBody userRegisterConfirmBody = new UserRegisterConfirmBody();
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
            parseField(userRegisterConfirmBody, c2, eVar);
            eVar.G();
        }
        return userRegisterConfirmBody;
    }

    public void parseField(UserRegisterConfirmBody userRegisterConfirmBody, String str, e eVar) throws IOException {
        if ("code".equals(str)) {
            userRegisterConfirmBody.b(eVar.c(null));
        } else if ("smsOperationId".equals(str)) {
            userRegisterConfirmBody.c(eVar.c(null));
        } else {
            parentObjectMapper.parseField(userRegisterConfirmBody, str, eVar);
        }
    }

    public void serialize(UserRegisterConfirmBody userRegisterConfirmBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (userRegisterConfirmBody.c() != null) {
            cVar.a("code", userRegisterConfirmBody.c());
        }
        if (userRegisterConfirmBody.d() != null) {
            cVar.a("smsOperationId", userRegisterConfirmBody.d());
        }
        parentObjectMapper.serialize(userRegisterConfirmBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
