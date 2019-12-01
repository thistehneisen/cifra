package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class ConnectedBankIdBody$$JsonObjectMapper extends JsonMapper<ConnectedBankIdBody> {
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    public ConnectedBankIdBody parse(e eVar) throws IOException {
        ConnectedBankIdBody connectedBankIdBody = new ConnectedBankIdBody();
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
            parseField(connectedBankIdBody, c2, eVar);
            eVar.G();
        }
        return connectedBankIdBody;
    }

    public void parseField(ConnectedBankIdBody connectedBankIdBody, String str, e eVar) throws IOException {
        if ("connectedBankId".equals(str)) {
            connectedBankIdBody.b(eVar.c(null));
        } else {
            parentObjectMapper.parseField(connectedBankIdBody, str, eVar);
        }
    }

    public void serialize(ConnectedBankIdBody connectedBankIdBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (connectedBankIdBody.c() != null) {
            cVar.a("connectedBankId", connectedBankIdBody.c());
        }
        parentObjectMapper.serialize(connectedBankIdBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
