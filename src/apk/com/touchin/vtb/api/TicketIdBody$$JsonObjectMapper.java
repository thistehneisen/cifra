package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TicketIdBody$$JsonObjectMapper extends JsonMapper<TicketIdBody> {
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    public TicketIdBody parse(e eVar) throws IOException {
        TicketIdBody ticketIdBody = new TicketIdBody();
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
            parseField(ticketIdBody, c2, eVar);
            eVar.G();
        }
        return ticketIdBody;
    }

    public void parseField(TicketIdBody ticketIdBody, String str, e eVar) throws IOException {
        if ("ticketId".equals(str)) {
            ticketIdBody.b(eVar.c(null));
        } else {
            parentObjectMapper.parseField(ticketIdBody, str, eVar);
        }
    }

    public void serialize(TicketIdBody ticketIdBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (ticketIdBody.c() != null) {
            cVar.a("ticketId", ticketIdBody.c());
        }
        parentObjectMapper.serialize(ticketIdBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
