package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TicketInfoResponse$$JsonObjectMapper extends JsonMapper<TicketInfoResponse> {
    private static final JsonMapper<TicketInfo> COM_TOUCHIN_VTB_API_TICKETINFO__JSONOBJECTMAPPER = LoganSquare.mapperFor(TicketInfo.class);

    public TicketInfoResponse parse(e eVar) throws IOException {
        TicketInfoResponse ticketInfoResponse = new TicketInfoResponse();
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
            parseField(ticketInfoResponse, c2, eVar);
            eVar.G();
        }
        return ticketInfoResponse;
    }

    public void parseField(TicketInfoResponse ticketInfoResponse, String str, e eVar) throws IOException {
        if ("ticketInfo".equals(str)) {
            ticketInfoResponse.a((TicketInfo) COM_TOUCHIN_VTB_API_TICKETINFO__JSONOBJECTMAPPER.parse(eVar));
        }
    }

    public void serialize(TicketInfoResponse ticketInfoResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (ticketInfoResponse.b() != null) {
            cVar.c("ticketInfo");
            COM_TOUCHIN_VTB_API_TICKETINFO__JSONOBJECTMAPPER.serialize(ticketInfoResponse.b(), cVar, true);
        }
        if (z) {
            cVar.c();
        }
    }
}
