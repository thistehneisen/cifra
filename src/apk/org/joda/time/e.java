package org.joda.time;

import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.b.u;

/* compiled from: DateTimeUtils */
public class e {

    /* renamed from: a reason: collision with root package name */
    public static final a f10824a = new b();

    /* renamed from: b reason: collision with root package name */
    private static volatile a f10825b = f10824a;

    /* renamed from: c reason: collision with root package name */
    private static final AtomicReference<Map<String, g>> f10826c = new AtomicReference<>();

    /* compiled from: DateTimeUtils */
    public interface a {
        long n();
    }

    /* compiled from: DateTimeUtils */
    static class b implements a {
        b() {
        }

        public long n() {
            return System.currentTimeMillis();
        }
    }

    public static final long a() {
        return f10825b.n();
    }

    public static final long b(r rVar) {
        if (rVar == null) {
            return a();
        }
        return rVar.n();
    }

    private static Map<String, g> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("UT", g.f10938a);
        linkedHashMap.put("UTC", g.f10938a);
        linkedHashMap.put("GMT", g.f10938a);
        String str = "America/New_York";
        a(linkedHashMap, "EST", str);
        a(linkedHashMap, "EDT", str);
        String str2 = "America/Chicago";
        a(linkedHashMap, "CST", str2);
        a(linkedHashMap, "CDT", str2);
        String str3 = "America/Denver";
        a(linkedHashMap, "MST", str3);
        a(linkedHashMap, "MDT", str3);
        String str4 = "America/Los_Angeles";
        a(linkedHashMap, "PST", str4);
        a(linkedHashMap, "PDT", str4);
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static final a a(r rVar) {
        if (rVar == null) {
            return u.N();
        }
        a chronology = rVar.getChronology();
        if (chronology == null) {
            chronology = u.N();
        }
        return chronology;
    }

    public static final Map<String, g> b() {
        Map<String, g> map = (Map) f10826c.get();
        if (map != null) {
            return map;
        }
        Map<String, g> c2 = c();
        return !f10826c.compareAndSet(null, c2) ? (Map) f10826c.get() : c2;
    }

    public static final a a(a aVar) {
        return aVar == null ? u.N() : aVar;
    }

    public static final g a(g gVar) {
        return gVar == null ? g.b() : gVar;
    }

    public static final DateFormatSymbols a(Locale locale) {
        try {
            return (DateFormatSymbols) DateFormatSymbols.class.getMethod("getInstance", new Class[]{Locale.class}).invoke(null, new Object[]{locale});
        } catch (Exception unused) {
            return new DateFormatSymbols(locale);
        }
    }

    private static void a(Map<String, g> map, String str, String str2) {
        try {
            map.put(str, g.a(str2));
        } catch (RuntimeException unused) {
        }
    }
}
