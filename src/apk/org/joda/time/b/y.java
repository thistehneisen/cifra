package org.joda.time.b;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;
import org.joda.time.b.a.C0124a;
import org.joda.time.c;
import org.joda.time.g;
import org.joda.time.h;

/* compiled from: ZonedChronology */
public final class y extends a {
    private static final long serialVersionUID = -1079258847191166848L;

    /* compiled from: ZonedChronology */
    static final class a extends org.joda.time.d.b {

        /* renamed from: b reason: collision with root package name */
        final c f10762b;

        /* renamed from: c reason: collision with root package name */
        final g f10763c;

        /* renamed from: d reason: collision with root package name */
        final h f10764d;

        /* renamed from: e reason: collision with root package name */
        final boolean f10765e;

        /* renamed from: f reason: collision with root package name */
        final h f10766f;

        /* renamed from: g reason: collision with root package name */
        final h f10767g;

        a(c cVar, g gVar, h hVar, h hVar2, h hVar3) {
            super(cVar.g());
            if (cVar.i()) {
                this.f10762b = cVar;
                this.f10763c = gVar;
                this.f10764d = hVar;
                this.f10765e = y.a(hVar);
                this.f10766f = hVar2;
                this.f10767g = hVar3;
                return;
            }
            throw new IllegalArgumentException();
        }

        private int j(long j2) {
            int c2 = this.f10763c.c(j2);
            long j3 = (long) c2;
            if (((j2 + j3) ^ j2) >= 0 || (j2 ^ j3) < 0) {
                return c2;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        public int a(long j2) {
            return this.f10762b.a(this.f10763c.a(j2));
        }

        public String b(long j2, Locale locale) {
            return this.f10762b.b(this.f10763c.a(j2), locale);
        }

        public long c(long j2) {
            return this.f10762b.c(this.f10763c.a(j2));
        }

        public long d(long j2) {
            if (this.f10765e) {
                long j3 = (long) j(j2);
                return this.f10762b.d(j2 + j3) - j3;
            }
            return this.f10763c.a(this.f10762b.d(this.f10763c.a(j2)), false, j2);
        }

        public long e(long j2) {
            if (this.f10765e) {
                long j3 = (long) j(j2);
                return this.f10762b.e(j2 + j3) - j3;
            }
            return this.f10763c.a(this.f10762b.e(this.f10763c.a(j2)), false, j2);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f10762b.equals(aVar.f10762b) || !this.f10763c.equals(aVar.f10763c) || !this.f10764d.equals(aVar.f10764d) || !this.f10766f.equals(aVar.f10766f)) {
                z = false;
            }
            return z;
        }

        public final h f() {
            return this.f10766f;
        }

        public boolean h() {
            return this.f10762b.h();
        }

        public int hashCode() {
            return this.f10762b.hashCode() ^ this.f10763c.hashCode();
        }

        public String a(long j2, Locale locale) {
            return this.f10762b.a(this.f10763c.a(j2), locale);
        }

        public String b(int i2, Locale locale) {
            return this.f10762b.b(i2, locale);
        }

        public int c() {
            return this.f10762b.c();
        }

        public long b(long j2, int i2) {
            long b2 = this.f10762b.b(this.f10763c.a(j2), i2);
            long a2 = this.f10763c.a(b2, false, j2);
            if (a(a2) == i2) {
                return a2;
            }
            IllegalInstantException illegalInstantException = new IllegalInstantException(b2, this.f10763c.c());
            IllegalFieldValueException illegalFieldValueException = new IllegalFieldValueException(this.f10762b.g(), Integer.valueOf(i2), illegalInstantException.getMessage());
            illegalFieldValueException.initCause(illegalInstantException);
            throw illegalFieldValueException;
        }

        public String a(int i2, Locale locale) {
            return this.f10762b.a(i2, locale);
        }

        public long a(long j2, int i2) {
            if (this.f10765e) {
                long j3 = (long) j(j2);
                return this.f10762b.a(j2 + j3, i2) - j3;
            }
            return this.f10763c.a(this.f10762b.a(this.f10763c.a(j2), i2), false, j2);
        }

        public int d() {
            return this.f10762b.d();
        }

        public long a(long j2, long j3) {
            if (this.f10765e) {
                long j4 = (long) j(j2);
                return this.f10762b.a(j2 + j4, j3) - j4;
            }
            return this.f10763c.a(this.f10762b.a(this.f10763c.a(j2), j3), false, j2);
        }

        public boolean b(long j2) {
            return this.f10762b.b(this.f10763c.a(j2));
        }

        public final h b() {
            return this.f10767g;
        }

        public long a(long j2, String str, Locale locale) {
            return this.f10763c.a(this.f10762b.a(this.f10763c.a(j2), str, locale), false, j2);
        }

        public final h a() {
            return this.f10764d;
        }

        public int a(Locale locale) {
            return this.f10762b.a(locale);
        }
    }

    /* compiled from: ZonedChronology */
    static class b extends org.joda.time.d.c {
        private static final long serialVersionUID = -485345310999208286L;
        final h iField;
        final boolean iTimeField;
        final g iZone;

        b(h hVar, g gVar) {
            super(hVar.a());
            if (hVar.d()) {
                this.iField = hVar;
                this.iTimeField = y.a(hVar);
                this.iZone = gVar;
                return;
            }
            throw new IllegalArgumentException();
        }

        public long a(long j2, int i2) {
            int b2 = b(j2);
            long a2 = this.iField.a(j2 + ((long) b2), i2);
            if (!this.iTimeField) {
                b2 = a(a2);
            }
            return a2 - ((long) b2);
        }

        public long b() {
            return this.iField.b();
        }

        public boolean c() {
            if (this.iTimeField) {
                return this.iField.c();
            }
            return this.iField.c() && this.iZone.f();
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.iField.equals(bVar.iField) || !this.iZone.equals(bVar.iZone)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.iField.hashCode() ^ this.iZone.hashCode();
        }

        private int b(long j2) {
            int c2 = this.iZone.c(j2);
            long j3 = (long) c2;
            if (((j2 + j3) ^ j2) >= 0 || (j2 ^ j3) < 0) {
                return c2;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        public long a(long j2, long j3) {
            int b2 = b(j2);
            long a2 = this.iField.a(j2 + ((long) b2), j3);
            if (!this.iTimeField) {
                b2 = a(a2);
            }
            return a2 - ((long) b2);
        }

        private int a(long j2) {
            int d2 = this.iZone.d(j2);
            long j3 = (long) d2;
            if (((j2 - j3) ^ j2) >= 0 || (j2 ^ j3) >= 0) {
                return d2;
            }
            throw new ArithmeticException("Subtracting time zone offset caused overflow");
        }
    }

    private y(org.joda.time.a aVar, g gVar) {
        super(aVar, gVar);
    }

    public static y a(org.joda.time.a aVar, g gVar) {
        if (aVar != null) {
            org.joda.time.a G = aVar.G();
            if (G == null) {
                throw new IllegalArgumentException("UTC chronology must not be null");
            } else if (gVar != null) {
                return new y(G, gVar);
            } else {
                throw new IllegalArgumentException("DateTimeZone must not be null");
            }
        } else {
            throw new IllegalArgumentException("Must supply a chronology");
        }
    }

    public org.joda.time.a G() {
        return L();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (!L().equals(yVar.L()) || !k().equals(yVar.k())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (k().hashCode() * 11) + 326565 + (L().hashCode() * 7);
    }

    public g k() {
        return (g) M();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ZonedChronology[");
        sb.append(L());
        sb.append(", ");
        sb.append(k().c());
        sb.append(']');
        return sb.toString();
    }

    static boolean a(h hVar) {
        return hVar != null && hVar.b() < 43200000;
    }

    public org.joda.time.a a(g gVar) {
        if (gVar == null) {
            gVar = g.b();
        }
        if (gVar == M()) {
            return this;
        }
        if (gVar == g.f10938a) {
            return L();
        }
        return new y(L(), gVar);
    }

    public long a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        return a(L().a(i2, i3, i4, i5));
    }

    public long a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        return a(L().a(i2, i3, i4, i5, i6, i7, i8));
    }

    private long a(long j2) {
        if (j2 == Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        if (j2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        g k2 = k();
        int d2 = k2.d(j2);
        long j3 = j2 - ((long) d2);
        if (j2 > 604800000 && j3 < 0) {
            return Long.MAX_VALUE;
        }
        if (j2 < -604800000 && j3 > 0) {
            return Long.MIN_VALUE;
        }
        if (d2 == k2.c(j3)) {
            return j3;
        }
        throw new IllegalInstantException(j2, k2.c());
    }

    /* access modifiers changed from: protected */
    public void a(C0124a aVar) {
        HashMap hashMap = new HashMap();
        aVar.f10718l = a(aVar.f10718l, hashMap);
        aVar.f10717k = a(aVar.f10717k, hashMap);
        aVar.f10716j = a(aVar.f10716j, hashMap);
        aVar.f10715i = a(aVar.f10715i, hashMap);
        aVar.f10714h = a(aVar.f10714h, hashMap);
        aVar.f10713g = a(aVar.f10713g, hashMap);
        aVar.f10712f = a(aVar.f10712f, hashMap);
        aVar.f10711e = a(aVar.f10711e, hashMap);
        aVar.f10710d = a(aVar.f10710d, hashMap);
        aVar.f10709c = a(aVar.f10709c, hashMap);
        aVar.f10708b = a(aVar.f10708b, hashMap);
        aVar.f10707a = a(aVar.f10707a, hashMap);
        aVar.E = a(aVar.E, hashMap);
        aVar.F = a(aVar.F, hashMap);
        aVar.G = a(aVar.G, hashMap);
        aVar.H = a(aVar.H, hashMap);
        aVar.I = a(aVar.I, hashMap);
        aVar.x = a(aVar.x, hashMap);
        aVar.y = a(aVar.y, hashMap);
        aVar.z = a(aVar.z, hashMap);
        aVar.D = a(aVar.D, hashMap);
        aVar.A = a(aVar.A, hashMap);
        aVar.B = a(aVar.B, hashMap);
        aVar.C = a(aVar.C, hashMap);
        aVar.m = a(aVar.m, hashMap);
        aVar.n = a(aVar.n, hashMap);
        aVar.o = a(aVar.o, hashMap);
        aVar.p = a(aVar.p, hashMap);
        aVar.q = a(aVar.q, hashMap);
        aVar.r = a(aVar.r, hashMap);
        aVar.s = a(aVar.s, hashMap);
        aVar.u = a(aVar.u, hashMap);
        aVar.t = a(aVar.t, hashMap);
        aVar.v = a(aVar.v, hashMap);
        aVar.w = a(aVar.w, hashMap);
    }

    private h a(h hVar, HashMap<Object, Object> hashMap) {
        if (hVar == null || !hVar.d()) {
            return hVar;
        }
        if (hashMap.containsKey(hVar)) {
            return (h) hashMap.get(hVar);
        }
        b bVar = new b(hVar, k());
        hashMap.put(hVar, bVar);
        return bVar;
    }

    private c a(c cVar, HashMap<Object, Object> hashMap) {
        if (cVar == null || !cVar.i()) {
            return cVar;
        }
        if (hashMap.containsKey(cVar)) {
            return (c) hashMap.get(cVar);
        }
        a aVar = new a(cVar, k(), a(cVar.a(), hashMap), a(cVar.f(), hashMap), a(cVar.b(), hashMap));
        hashMap.put(cVar, aVar);
        return aVar;
    }
}
