package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TicketInfo$$JsonObjectMapper extends JsonMapper<TicketInfo> {
    private static TypeConverter<TicketStatus> com_touchin_vtb_api_TicketStatus_type_converter;

    private static final TypeConverter<TicketStatus> getcom_touchin_vtb_api_TicketStatus_type_converter() {
        if (com_touchin_vtb_api_TicketStatus_type_converter == null) {
            com_touchin_vtb_api_TicketStatus_type_converter = LoganSquare.typeConverterFor(TicketStatus.class);
        }
        return com_touchin_vtb_api_TicketStatus_type_converter;
    }

    public TicketInfo parse(e eVar) throws IOException {
        TicketInfo ticketInfo = new TicketInfo();
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
            parseField(ticketInfo, c2, eVar);
            eVar.G();
        }
        return ticketInfo;
    }

    public void parseField(TicketInfo ticketInfo, String str, e eVar) throws IOException {
        if ("ticketId".equals(str)) {
            ticketInfo.a(eVar.c(null));
        } else if ("ticketStatus".equals(str)) {
            ticketInfo.a((TicketStatus) getcom_touchin_vtb_api_TicketStatus_type_converter().parse(eVar));
        }
    }

    public void serialize(TicketInfo ticketInfo, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (ticketInfo.b() != null) {
            cVar.a("ticketId", ticketInfo.b());
        }
        if (ticketInfo.c() != null) {
            getcom_touchin_vtb_api_TicketStatus_type_converter().serialize(ticketInfo.c(), "ticketStatus", true, cVar);
        }
        if (z) {
            cVar.c();
        }
    }
}
