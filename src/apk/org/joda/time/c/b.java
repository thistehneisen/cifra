package org.joda.time.c;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.joda.time.a;
import org.joda.time.b.l;
import org.joda.time.b.n;
import org.joda.time.b.t;
import org.joda.time.b.u;
import org.joda.time.b.w;
import org.joda.time.g;

/* compiled from: CalendarConverter */
final class b extends a implements h, l {

    /* renamed from: a reason: collision with root package name */
    static final b f10768a = new b();

    protected b() {
    }

    public a a(Object obj, g gVar) {
        if (obj.getClass().getName().endsWith(".BuddhistCalendar")) {
            return l.b(gVar);
        }
        if (!(obj instanceof GregorianCalendar)) {
            return u.b(gVar);
        }
        long time = ((GregorianCalendar) obj).getGregorianChange().getTime();
        if (time == Long.MIN_VALUE) {
            return t.b(gVar);
        }
        if (time == Long.MAX_VALUE) {
            return w.b(gVar);
        }
        return n.a(gVar, time, 4);
    }

    public a b(Object obj, a aVar) {
        g gVar;
        if (aVar != null) {
            return aVar;
        }
        Calendar calendar = (Calendar) obj;
        try {
            gVar = g.a(calendar.getTimeZone());
        } catch (IllegalArgumentException unused) {
            gVar = g.b();
        }
        return a((Object) calendar, gVar);
    }

    public long a(Object obj, a aVar) {
        return ((Calendar) obj).getTime().getTime();
    }

    public Class<?> a() {
        return Calendar.class;
    }
}
