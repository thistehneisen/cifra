package org.joda.time.d;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.h;
import org.joda.time.t;

/* compiled from: UnsupportedDateTimeField */
public final class s extends c implements Serializable {

    /* renamed from: a reason: collision with root package name */
    private static HashMap<d, s> f10822a = null;
    private static final long serialVersionUID = -1934618396111902255L;
    private final h iDurationField;
    private final d iType;

    private s(d dVar, h hVar) {
        if (dVar == null || hVar == null) {
            throw new IllegalArgumentException();
        }
        this.iType = dVar;
        this.iDurationField = hVar;
    }

    public static synchronized s a(d dVar, h hVar) {
        s sVar;
        synchronized (s.class) {
            sVar = null;
            if (f10822a == null) {
                f10822a = new HashMap<>(7);
            } else {
                s sVar2 = (s) f10822a.get(dVar);
                if (sVar2 == null || sVar2.a() == hVar) {
                    sVar = sVar2;
                }
            }
            if (sVar == null) {
                sVar = new s(dVar, hVar);
                f10822a.put(dVar, sVar);
            }
        }
        return sVar;
    }

    private UnsupportedOperationException j() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.iType);
        sb.append(" field is unsupported");
        return new UnsupportedOperationException(sb.toString());
    }

    private Object readResolve() {
        return a(this.iType, this.iDurationField);
    }

    public String b(long j2, Locale locale) {
        throw j();
    }

    public h b() {
        return null;
    }

    public int c() {
        throw j();
    }

    public int d() {
        throw j();
    }

    public String e() {
        return this.iType.F();
    }

    public long f(long j2) {
        throw j();
    }

    public h f() {
        return null;
    }

    public d g() {
        return this.iType;
    }

    public long h(long j2) {
        throw j();
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public String toString() {
        return "UnsupportedDateTimeField";
    }

    public String b(t tVar, Locale locale) {
        throw j();
    }

    public long c(long j2) {
        throw j();
    }

    public long d(long j2) {
        throw j();
    }

    public long e(long j2) {
        throw j();
    }

    public long g(long j2) {
        throw j();
    }

    public String b(int i2, Locale locale) {
        throw j();
    }

    public long b(long j2, int i2) {
        throw j();
    }

    public boolean b(long j2) {
        throw j();
    }

    public int a(long j2) {
        throw j();
    }

    public String a(long j2, Locale locale) {
        throw j();
    }

    public String a(t tVar, Locale locale) {
        throw j();
    }

    public String a(int i2, Locale locale) {
        throw j();
    }

    public long a(long j2, int i2) {
        return a().a(j2, i2);
    }

    public long a(long j2, long j3) {
        return a().a(j2, j3);
    }

    public long a(long j2, String str, Locale locale) {
        throw j();
    }

    public h a() {
        return this.iDurationField;
    }

    public int a(Locale locale) {
        throw j();
    }
}
