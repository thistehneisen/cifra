package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class UserProfileBody$$JsonObjectMapper extends JsonMapper<UserProfileBody> {
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    public UserProfileBody parse(e eVar) throws IOException {
        UserProfileBody userProfileBody = new UserProfileBody();
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
            parseField(userProfileBody, c2, eVar);
            eVar.G();
        }
        return userProfileBody;
    }

    public void parseField(UserProfileBody userProfileBody, String str, e eVar) throws IOException {
        if ("phoneNumber".equals(str)) {
            userProfileBody.b(eVar.c(null));
        } else {
            parentObjectMapper.parseField(userProfileBody, str, eVar);
        }
    }

    public void serialize(UserProfileBody userProfileBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (userProfileBody.c() != null) {
            cVar.a("phoneNumber", userProfileBody.c());
        }
        parentObjectMapper.serialize(userProfileBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
