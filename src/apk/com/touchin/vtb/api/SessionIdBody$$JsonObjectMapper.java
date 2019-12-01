package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class SessionIdBody$$JsonObjectMapper extends JsonMapper<SessionIdBody> {
    public SessionIdBody parse(e eVar) throws IOException {
        SessionIdBody sessionIdBody = new SessionIdBody();
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
            parseField(sessionIdBody, c2, eVar);
            eVar.G();
        }
        return sessionIdBody;
    }

    public void parseField(SessionIdBody sessionIdBody, String str, e eVar) throws IOException {
        if ("sessionId".equals(str)) {
            sessionIdBody.a(eVar.c(null));
        }
    }

    public void serialize(SessionIdBody sessionIdBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (sessionIdBody.b() != null) {
            cVar.a("sessionId", sessionIdBody.b());
        }
        if (z) {
            cVar.c();
        }
    }
}
