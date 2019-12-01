package org.joda.time.d;

import java.util.Locale;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.h;
import org.joda.time.t;

/* compiled from: BaseDateTimeField */
public abstract class b extends c {

    /* renamed from: a reason: collision with root package name */
    private final d f10800a;

    protected b(d dVar) {
        if (dVar != null) {
            this.f10800a = dVar;
            return;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public String a(long j2, Locale locale) {
        return a(a(j2), locale);
    }

    public String b(long j2, Locale locale) {
        return b(a(j2), locale);
    }

    public h b() {
        return null;
    }

    public boolean b(long j2) {
        return false;
    }

    public long c(long j2) {
        return j2 - e(j2);
    }

    public long d(long j2) {
        long e2 = e(j2);
        return e2 != j2 ? a(e2, 1) : j2;
    }

    public final String e() {
        return this.f10800a.F();
    }

    public long f(long j2) {
        long e2 = e(j2);
        long d2 = d(j2);
        return d2 - j2 <= j2 - e2 ? d2 : e2;
    }

    public final d g() {
        return this.f10800a;
    }

    public long h(long j2) {
        long e2 = e(j2);
        long d2 = d(j2);
        return j2 - e2 <= d2 - j2 ? e2 : d2;
    }

    public int i(long j2) {
        return c();
    }

    public final boolean i() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DateTimeField[");
        sb.append(e());
        sb.append(']');
        return sb.toString();
    }

    public String a(t tVar, int i2, Locale locale) {
        return a(i2, locale);
    }

    public String b(t tVar, int i2, Locale locale) {
        return b(i2, locale);
    }

    public long g(long j2) {
        long e2 = e(j2);
        long d2 = d(j2);
        long j3 = j2 - e2;
        long j4 = d2 - j2;
        if (j3 < j4) {
            return e2;
        }
        return (j4 >= j3 && (a(d2) & 1) != 0) ? e2 : d2;
    }

    public final String a(t tVar, Locale locale) {
        return a(tVar, tVar.b(g()), locale);
    }

    public final String b(t tVar, Locale locale) {
        return b(tVar, tVar.b(g()), locale);
    }

    public String a(int i2, Locale locale) {
        return b(i2, locale);
    }

    public String b(int i2, Locale locale) {
        return Integer.toString(i2);
    }

    public long a(long j2, int i2) {
        return a().a(j2, i2);
    }

    public long a(long j2, long j3) {
        return a().a(j2, j3);
    }

    public long a(long j2, String str, Locale locale) {
        return b(j2, a(str, locale));
    }

    /* access modifiers changed from: protected */
    public int a(String str, Locale locale) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new IllegalFieldValueException(g(), str);
        }
    }

    public int a(Locale locale) {
        int c2 = c();
        if (c2 >= 0) {
            if (c2 < 10) {
                return 1;
            }
            if (c2 < 100) {
                return 2;
            }
            if (c2 < 1000) {
                return 3;
            }
        }
        return Integer.toString(c2).length();
    }
}
