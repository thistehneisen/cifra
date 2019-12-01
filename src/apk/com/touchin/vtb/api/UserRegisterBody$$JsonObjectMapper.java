package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class UserRegisterBody$$JsonObjectMapper extends JsonMapper<UserRegisterBody> {
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    public UserRegisterBody parse(e eVar) throws IOException {
        UserRegisterBody userRegisterBody = new UserRegisterBody();
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
            parseField(userRegisterBody, c2, eVar);
            eVar.G();
        }
        return userRegisterBody;
    }

    public void parseField(UserRegisterBody userRegisterBody, String str, e eVar) throws IOException {
        if ("phoneNumber".equals(str)) {
            userRegisterBody.b(eVar.c(null));
        } else {
            parentObjectMapper.parseField(userRegisterBody, str, eVar);
        }
    }

    public void serialize(UserRegisterBody userRegisterBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (userRegisterBody.c() != null) {
            cVar.a("phoneNumber", userRegisterBody.c());
        }
        parentObjectMapper.serialize(userRegisterBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
