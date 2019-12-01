package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TicketStatus$$JsonTypeConverter implements TypeConverter<TicketStatus> {
    public TicketStatus parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("complete")) {
            return TicketStatus.COMPLETE;
        }
        if (E.equals("waiting")) {
            return TicketStatus.WAITING;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(TicketStatus ticketStatus, String str, boolean z, c cVar) throws IOException {
        String str2 = "waiting";
        String str3 = "complete";
        if (str != null) {
            if (ticketStatus == null) {
                cVar.d(str);
                return;
            }
            int i2 = z.f7135a[ticketStatus.ordinal()];
            if (i2 == 1) {
                cVar.a(str, str3);
            } else if (i2 == 2) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(ticketStatus.name());
            }
        } else if (ticketStatus == null) {
            cVar.d();
        } else {
            int i3 = z.f7135a[ticketStatus.ordinal()];
            if (i3 == 1) {
                cVar.f(str3);
            } else if (i3 == 2) {
                cVar.f(str2);
            } else {
                throw new IllegalArgumentException(ticketStatus.name());
            }
        }
    }
}
