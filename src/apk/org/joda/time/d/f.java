package org.joda.time.d;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.h;
import org.joda.time.t;

/* compiled from: DelegatedDateTimeField */
public class f extends c implements Serializable {
    private static final long serialVersionUID = -4730164440214502503L;
    private final c iField;
    private final h iRangeDurationField;
    private final d iType;

    public f(c cVar) {
        this(cVar, null);
    }

    public int a(long j2) {
        return this.iField.a(j2);
    }

    public String b(long j2, Locale locale) {
        return this.iField.b(j2, locale);
    }

    public int c() {
        return this.iField.c();
    }

    public int d() {
        return this.iField.d();
    }

    public String e() {
        return this.iType.F();
    }

    public h f() {
        h hVar = this.iRangeDurationField;
        if (hVar != null) {
            return hVar;
        }
        return this.iField.f();
    }

    public d g() {
        return this.iType;
    }

    public boolean h() {
        return this.iField.h();
    }

    public boolean i() {
        return this.iField.i();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DateTimeField[");
        sb.append(e());
        sb.append(']');
        return sb.toString();
    }

    public f(c cVar, d dVar) {
        this(cVar, null, dVar);
    }

    public String a(long j2, Locale locale) {
        return this.iField.a(j2, locale);
    }

    public String b(t tVar, Locale locale) {
        return this.iField.b(tVar, locale);
    }

    public long c(long j2) {
        return this.iField.c(j2);
    }

    public long d(long j2) {
        return this.iField.d(j2);
    }

    public long e(long j2) {
        return this.iField.e(j2);
    }

    public long g(long j2) {
        return this.iField.g(j2);
    }

    public long h(long j2) {
        return this.iField.h(j2);
    }

    public f(c cVar, h hVar, d dVar) {
        if (cVar != null) {
            this.iField = cVar;
            this.iRangeDurationField = hVar;
            if (dVar == null) {
                dVar = cVar.g();
            }
            this.iType = dVar;
            return;
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    public String a(t tVar, Locale locale) {
        return this.iField.a(tVar, locale);
    }

    public String b(int i2, Locale locale) {
        return this.iField.b(i2, locale);
    }

    public long f(long j2) {
        return this.iField.f(j2);
    }

    public String a(int i2, Locale locale) {
        return this.iField.a(i2, locale);
    }

    public long b(long j2, int i2) {
        return this.iField.b(j2, i2);
    }

    public long a(long j2, int i2) {
        return this.iField.a(j2, i2);
    }

    public boolean b(long j2) {
        return this.iField.b(j2);
    }

    public long a(long j2, long j3) {
        return this.iField.a(j2, j3);
    }

    public h b() {
        return this.iField.b();
    }

    public long a(long j2, String str, Locale locale) {
        return this.iField.a(j2, str, locale);
    }

    public h a() {
        return this.iField.a();
    }

    public int a(Locale locale) {
        return this.iField.a(locale);
    }
}
