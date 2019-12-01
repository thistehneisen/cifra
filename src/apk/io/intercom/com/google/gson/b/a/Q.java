package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: TypeAdapters */
class Q extends D<Calendar> {
    Q() {
    }

    public Calendar a(b bVar) throws IOException {
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        }
        bVar.b();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (bVar.G() != c.END_OBJECT) {
            String D = bVar.D();
            int l2 = bVar.l();
            if ("year".equals(D)) {
                i2 = l2;
            } else if ("month".equals(D)) {
                i3 = l2;
            } else if ("dayOfMonth".equals(D)) {
                i4 = l2;
            } else if ("hourOfDay".equals(D)) {
                i5 = l2;
            } else if ("minute".equals(D)) {
                i6 = l2;
            } else if ("second".equals(D)) {
                i7 = l2;
            }
        }
        bVar.e();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        return gregorianCalendar;
    }

    public void a(d dVar, Calendar calendar) throws IOException {
        if (calendar == null) {
            dVar.h();
            return;
        }
        dVar.b();
        dVar.b("year");
        dVar.h((long) calendar.get(1));
        dVar.b("month");
        dVar.h((long) calendar.get(2));
        dVar.b("dayOfMonth");
        dVar.h((long) calendar.get(5));
        dVar.b("hourOfDay");
        dVar.h((long) calendar.get(11));
        dVar.b("minute");
        dVar.h((long) calendar.get(12));
        dVar.b("second");
        dVar.h((long) calendar.get(13));
        dVar.d();
    }
}
