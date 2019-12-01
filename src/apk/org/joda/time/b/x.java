package org.joda.time.b;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.b.a.C0124a;
import org.joda.time.d.d;
import org.joda.time.d.e;
import org.joda.time.e.j;
import org.joda.time.g;
import org.joda.time.h;
import org.joda.time.m;
import org.joda.time.p;

/* compiled from: LimitChronology */
public final class x extends a {
    private static final long serialVersionUID = 7670866536893052522L;
    private transient x K;
    final org.joda.time.b iLowerLimit;
    final org.joda.time.b iUpperLimit;

    /* compiled from: LimitChronology */
    private class a extends d {

        /* renamed from: c reason: collision with root package name */
        private final h f10758c;

        /* renamed from: d reason: collision with root package name */
        private final h f10759d;

        /* renamed from: e reason: collision with root package name */
        private final h f10760e;

        a(org.joda.time.c cVar, h hVar, h hVar2, h hVar3) {
            super(cVar, cVar.g());
            this.f10758c = hVar;
            this.f10759d = hVar2;
            this.f10760e = hVar3;
        }

        public int a(long j2) {
            x.this.a(j2, (String) null);
            return j().a(j2);
        }

        public String b(long j2, Locale locale) {
            x.this.a(j2, (String) null);
            return j().b(j2, locale);
        }

        public long c(long j2) {
            x.this.a(j2, (String) null);
            long c2 = j().c(j2);
            x.this.a(c2, "resulting");
            return c2;
        }

        public long d(long j2) {
            x.this.a(j2, (String) null);
            long d2 = j().d(j2);
            x.this.a(d2, "resulting");
            return d2;
        }

        public long e(long j2) {
            x.this.a(j2, (String) null);
            long e2 = j().e(j2);
            x.this.a(e2, "resulting");
            return e2;
        }

        public final h f() {
            return this.f10759d;
        }

        public long g(long j2) {
            x.this.a(j2, (String) null);
            long g2 = j().g(j2);
            x.this.a(g2, "resulting");
            return g2;
        }

        public long h(long j2) {
            x.this.a(j2, (String) null);
            long h2 = j().h(j2);
            x.this.a(h2, "resulting");
            return h2;
        }

        public long f(long j2) {
            x.this.a(j2, (String) null);
            long f2 = j().f(j2);
            x.this.a(f2, "resulting");
            return f2;
        }

        public String a(long j2, Locale locale) {
            x.this.a(j2, (String) null);
            return j().a(j2, locale);
        }

        public long b(long j2, int i2) {
            x.this.a(j2, (String) null);
            long b2 = j().b(j2, i2);
            x.this.a(b2, "resulting");
            return b2;
        }

        public long a(long j2, int i2) {
            x.this.a(j2, (String) null);
            long a2 = j().a(j2, i2);
            x.this.a(a2, "resulting");
            return a2;
        }

        public boolean b(long j2) {
            x.this.a(j2, (String) null);
            return j().b(j2);
        }

        public long a(long j2, long j3) {
            x.this.a(j2, (String) null);
            long a2 = j().a(j2, j3);
            x.this.a(a2, "resulting");
            return a2;
        }

        public final h b() {
            return this.f10760e;
        }

        public long a(long j2, String str, Locale locale) {
            x.this.a(j2, (String) null);
            long a2 = j().a(j2, str, locale);
            x.this.a(a2, "resulting");
            return a2;
        }

        public final h a() {
            return this.f10758c;
        }

        public int a(Locale locale) {
            return j().a(locale);
        }
    }

    /* compiled from: LimitChronology */
    private class b extends e {
        private static final long serialVersionUID = 8049297699408782284L;

        b(h hVar) {
            super(hVar, hVar.a());
        }

        public long a(long j2, int i2) {
            x.this.a(j2, (String) null);
            long a2 = f().a(j2, i2);
            x.this.a(a2, "resulting");
            return a2;
        }

        public long a(long j2, long j3) {
            x.this.a(j2, (String) null);
            long a2 = f().a(j2, j3);
            x.this.a(a2, "resulting");
            return a2;
        }
    }

    /* compiled from: LimitChronology */
    private class c extends IllegalArgumentException {
        private static final long serialVersionUID = -5924689995607498581L;
        private final boolean iIsLow;

        c(String str, boolean z) {
            super(str);
            this.iIsLow = z;
        }

        public String getMessage() {
            StringBuffer stringBuffer = new StringBuffer(85);
            stringBuffer.append("The");
            String message = super.getMessage();
            if (message != null) {
                stringBuffer.append(' ');
                stringBuffer.append(message);
            }
            stringBuffer.append(" instant is ");
            org.joda.time.e.b a2 = j.b().a(x.this.L());
            if (this.iIsLow) {
                stringBuffer.append("below the supported minimum of ");
                a2.a(stringBuffer, x.this.N().n());
            } else {
                stringBuffer.append("above the supported maximum of ");
                a2.a(stringBuffer, x.this.O().n());
            }
            stringBuffer.append(" (");
            stringBuffer.append(x.this.L());
            stringBuffer.append(')');
            return stringBuffer.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("IllegalArgumentException: ");
            sb.append(getMessage());
            return sb.toString();
        }
    }

    private x(org.joda.time.a aVar, org.joda.time.b bVar, org.joda.time.b bVar2) {
        super(aVar, null);
        this.iLowerLimit = bVar;
        this.iUpperLimit = bVar2;
    }

    public static x a(org.joda.time.a aVar, p pVar, p pVar2) {
        if (aVar != null) {
            org.joda.time.b bVar = null;
            org.joda.time.b p = pVar == null ? null : pVar.p();
            if (pVar2 != null) {
                bVar = pVar2.p();
            }
            if (p == null || bVar == null || p.a(bVar)) {
                return new x(aVar, p, bVar);
            }
            throw new IllegalArgumentException("The lower limit must be come before than the upper limit");
        }
        throw new IllegalArgumentException("Must supply a chronology");
    }

    public org.joda.time.a G() {
        return a(g.f10938a);
    }

    public org.joda.time.b N() {
        return this.iLowerLimit;
    }

    public org.joda.time.b O() {
        return this.iUpperLimit;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (!L().equals(xVar.L()) || !org.joda.time.d.h.a((Object) N(), (Object) xVar.N()) || !org.joda.time.d.h.a((Object) O(), (Object) xVar.O())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i2 = 0;
        int hashCode = (N() != null ? N().hashCode() : 0) + 317351877;
        if (O() != null) {
            i2 = O().hashCode();
        }
        return hashCode + i2 + (L().hashCode() * 7);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LimitChronology[");
        sb.append(L().toString());
        String str = ", ";
        sb.append(str);
        String str2 = "NoLimit";
        sb.append(N() == null ? str2 : N().toString());
        sb.append(str);
        if (O() != null) {
            str2 = O().toString();
        }
        sb.append(str2);
        sb.append(']');
        return sb.toString();
    }

    public org.joda.time.a a(g gVar) {
        if (gVar == null) {
            gVar = g.b();
        }
        if (gVar == k()) {
            return this;
        }
        if (gVar == g.f10938a) {
            x xVar = this.K;
            if (xVar != null) {
                return xVar;
            }
        }
        org.joda.time.b bVar = this.iLowerLimit;
        if (bVar != null) {
            m b2 = bVar.b();
            b2.a(gVar);
            bVar = b2.p();
        }
        org.joda.time.b bVar2 = this.iUpperLimit;
        if (bVar2 != null) {
            m b3 = bVar2.b();
            b3.a(gVar);
            bVar2 = b3.p();
        }
        x a2 = a(L().a(gVar), bVar, bVar2);
        if (gVar == g.f10938a) {
            this.K = a2;
        }
        return a2;
    }

    public long a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        long a2 = L().a(i2, i3, i4, i5);
        a(a2, "resulting");
        return a2;
    }

    public long a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        long a2 = L().a(i2, i3, i4, i5, i6, i7, i8);
        a(a2, "resulting");
        return a2;
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
        b bVar = new b(hVar);
        hashMap.put(hVar, bVar);
        return bVar;
    }

    private org.joda.time.c a(org.joda.time.c cVar, HashMap<Object, Object> hashMap) {
        if (cVar == null || !cVar.i()) {
            return cVar;
        }
        if (hashMap.containsKey(cVar)) {
            return (org.joda.time.c) hashMap.get(cVar);
        }
        a aVar = new a(cVar, a(cVar.a(), hashMap), a(cVar.f(), hashMap), a(cVar.b(), hashMap));
        hashMap.put(cVar, aVar);
        return aVar;
    }

    /* access modifiers changed from: 0000 */
    public void a(long j2, String str) {
        org.joda.time.b bVar = this.iLowerLimit;
        if (bVar == null || j2 >= bVar.n()) {
            org.joda.time.b bVar2 = this.iUpperLimit;
            if (bVar2 != null && j2 >= bVar2.n()) {
                throw new c(str, false);
            }
            return;
        }
        throw new c(str, true);
    }
}
