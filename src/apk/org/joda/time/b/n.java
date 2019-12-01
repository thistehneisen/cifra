package org.joda.time.b;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.b.a.C0124a;
import org.joda.time.d.e;
import org.joda.time.g;
import org.joda.time.h;
import org.joda.time.j;
import org.joda.time.l;
import org.joda.time.r;

/* compiled from: GJChronology */
public final class n extends a {
    static final j K = new j(-12219292800000L);
    private static final ConcurrentHashMap<m, n> L = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -2545574827706931671L;
    private j iCutoverInstant;
    private long iCutoverMillis;
    /* access modifiers changed from: private */
    public long iGapDuration;
    /* access modifiers changed from: private */
    public t iGregorianChronology;
    private w iJulianChronology;

    /* compiled from: GJChronology */
    private class a extends org.joda.time.d.b {

        /* renamed from: b reason: collision with root package name */
        final org.joda.time.c f10733b;

        /* renamed from: c reason: collision with root package name */
        final org.joda.time.c f10734c;

        /* renamed from: d reason: collision with root package name */
        final long f10735d;

        /* renamed from: e reason: collision with root package name */
        final boolean f10736e;

        /* renamed from: f reason: collision with root package name */
        protected h f10737f;

        /* renamed from: g reason: collision with root package name */
        protected h f10738g;

        a(n nVar, org.joda.time.c cVar, org.joda.time.c cVar2, long j2) {
            this(nVar, cVar, cVar2, j2, false);
        }

        public int a(long j2) {
            if (j2 >= this.f10735d) {
                return this.f10734c.a(j2);
            }
            return this.f10733b.a(j2);
        }

        public String b(long j2, Locale locale) {
            if (j2 >= this.f10735d) {
                return this.f10734c.b(j2, locale);
            }
            return this.f10733b.b(j2, locale);
        }

        public int c() {
            return this.f10734c.c();
        }

        public int d() {
            return this.f10733b.d();
        }

        public long e(long j2) {
            if (j2 < this.f10735d) {
                return this.f10733b.e(j2);
            }
            long e2 = this.f10734c.e(j2);
            if (e2 >= this.f10735d || n.this.iGapDuration + e2 >= this.f10735d) {
                return e2;
            }
            return j(e2);
        }

        public h f() {
            return this.f10738g;
        }

        public boolean h() {
            return false;
        }

        /* access modifiers changed from: protected */
        public long j(long j2) {
            if (this.f10736e) {
                return n.this.a(j2);
            }
            return n.this.b(j2);
        }

        /* access modifiers changed from: protected */
        public long k(long j2) {
            if (this.f10736e) {
                return n.this.c(j2);
            }
            return n.this.d(j2);
        }

        a(n nVar, org.joda.time.c cVar, org.joda.time.c cVar2, long j2, boolean z) {
            this(cVar, cVar2, null, j2, z);
        }

        public long d(long j2) {
            if (j2 >= this.f10735d) {
                return this.f10734c.d(j2);
            }
            long d2 = this.f10733b.d(j2);
            return (d2 < this.f10735d || d2 - n.this.iGapDuration < this.f10735d) ? d2 : k(d2);
        }

        a(org.joda.time.c cVar, org.joda.time.c cVar2, h hVar, long j2, boolean z) {
            super(cVar2.g());
            this.f10733b = cVar;
            this.f10734c = cVar2;
            this.f10735d = j2;
            this.f10736e = z;
            this.f10737f = cVar2.a();
            if (hVar == null) {
                hVar = cVar2.f();
                if (hVar == null) {
                    hVar = cVar.f();
                }
            }
            this.f10738g = hVar;
        }

        public String a(long j2, Locale locale) {
            if (j2 >= this.f10735d) {
                return this.f10734c.a(j2, locale);
            }
            return this.f10733b.a(j2, locale);
        }

        public String b(int i2, Locale locale) {
            return this.f10734c.b(i2, locale);
        }

        public long b(long j2, int i2) {
            long j3;
            if (j2 >= this.f10735d) {
                j3 = this.f10734c.b(j2, i2);
                if (j3 < this.f10735d) {
                    if (n.this.iGapDuration + j3 < this.f10735d) {
                        j3 = j(j3);
                    }
                    if (a(j3) != i2) {
                        throw new IllegalFieldValueException(this.f10734c.g(), Integer.valueOf(i2), null, null);
                    }
                }
            } else {
                j3 = this.f10733b.b(j2, i2);
                if (j3 >= this.f10735d) {
                    if (j3 - n.this.iGapDuration >= this.f10735d) {
                        j3 = k(j3);
                    }
                    if (a(j3) != i2) {
                        throw new IllegalFieldValueException(this.f10733b.g(), Integer.valueOf(i2), null, null);
                    }
                }
            }
            return j3;
        }

        public String a(int i2, Locale locale) {
            return this.f10734c.a(i2, locale);
        }

        public long a(long j2, int i2) {
            return this.f10734c.a(j2, i2);
        }

        public long a(long j2, long j3) {
            return this.f10734c.a(j2, j3);
        }

        public long a(long j2, String str, Locale locale) {
            if (j2 >= this.f10735d) {
                long a2 = this.f10734c.a(j2, str, locale);
                if (a2 >= this.f10735d || n.this.iGapDuration + a2 >= this.f10735d) {
                    return a2;
                }
                return j(a2);
            }
            long a3 = this.f10733b.a(j2, str, locale);
            return (a3 < this.f10735d || a3 - n.this.iGapDuration < this.f10735d) ? a3 : k(a3);
        }

        public h a() {
            return this.f10737f;
        }

        public int a(Locale locale) {
            return Math.max(this.f10733b.a(locale), this.f10734c.a(locale));
        }

        public boolean b(long j2) {
            if (j2 >= this.f10735d) {
                return this.f10734c.b(j2);
            }
            return this.f10733b.b(j2);
        }

        public h b() {
            return this.f10734c.b();
        }
    }

    /* compiled from: GJChronology */
    private final class b extends a {
        b(n nVar, org.joda.time.c cVar, org.joda.time.c cVar2, long j2) {
            this(cVar, cVar2, (h) null, j2, false);
        }

        public long a(long j2, int i2) {
            if (j2 >= this.f10735d) {
                long a2 = this.f10734c.a(j2, i2);
                if (a2 >= this.f10735d || n.this.iGapDuration + a2 >= this.f10735d) {
                    return a2;
                }
                if (this.f10736e) {
                    if (n.this.iGregorianChronology.D().a(a2) <= 0) {
                        a2 = n.this.iGregorianChronology.D().a(a2, -1);
                    }
                } else if (n.this.iGregorianChronology.H().a(a2) <= 0) {
                    a2 = n.this.iGregorianChronology.H().a(a2, -1);
                }
                return j(a2);
            }
            long a3 = this.f10733b.a(j2, i2);
            return (a3 < this.f10735d || a3 - n.this.iGapDuration < this.f10735d) ? a3 : k(a3);
        }

        b(n nVar, org.joda.time.c cVar, org.joda.time.c cVar2, h hVar, long j2) {
            this(cVar, cVar2, hVar, j2, false);
        }

        b(n nVar, org.joda.time.c cVar, org.joda.time.c cVar2, h hVar, h hVar2, long j2) {
            this(cVar, cVar2, hVar, j2, false);
            this.f10738g = hVar2;
        }

        b(org.joda.time.c cVar, org.joda.time.c cVar2, h hVar, long j2, boolean z) {
            super(n.this, cVar, cVar2, j2, z);
            if (hVar == null) {
                hVar = new c(this.f10737f, this);
            }
            this.f10737f = hVar;
        }

        public long a(long j2, long j3) {
            if (j2 >= this.f10735d) {
                long a2 = this.f10734c.a(j2, j3);
                if (a2 >= this.f10735d || n.this.iGapDuration + a2 >= this.f10735d) {
                    return a2;
                }
                if (this.f10736e) {
                    if (n.this.iGregorianChronology.D().a(a2) <= 0) {
                        a2 = n.this.iGregorianChronology.D().a(a2, -1);
                    }
                } else if (n.this.iGregorianChronology.H().a(a2) <= 0) {
                    a2 = n.this.iGregorianChronology.H().a(a2, -1);
                }
                return j(a2);
            }
            long a3 = this.f10733b.a(j2, j3);
            return (a3 < this.f10735d || a3 - n.this.iGapDuration < this.f10735d) ? a3 : k(a3);
        }
    }

    /* compiled from: GJChronology */
    private static class c extends e {
        private static final long serialVersionUID = 4097975388007713084L;
        private final b iField;

        c(h hVar, b bVar) {
            super(hVar, hVar.a());
            this.iField = bVar;
        }

        public long a(long j2, int i2) {
            return this.iField.a(j2, i2);
        }

        public long a(long j2, long j3) {
            return this.iField.a(j2, j3);
        }
    }

    private n(w wVar, t tVar, j jVar) {
        super(null, new Object[]{wVar, tVar, jVar});
    }

    private Object readResolve() {
        return a(k(), (r) this.iCutoverInstant, N());
    }

    public org.joda.time.a G() {
        return a(g.f10938a);
    }

    public int N() {
        return this.iGregorianChronology.Y();
    }

    /* access modifiers changed from: 0000 */
    public long c(long j2) {
        return a(j2, (org.joda.time.a) this.iJulianChronology, (org.joda.time.a) this.iGregorianChronology);
    }

    /* access modifiers changed from: 0000 */
    public long d(long j2) {
        return b(j2, this.iJulianChronology, this.iGregorianChronology);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (!(this.iCutoverMillis == nVar.iCutoverMillis && N() == nVar.N() && k().equals(nVar.k()))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ("GJ".hashCode() * 11) + k().hashCode() + N() + this.iCutoverInstant.hashCode();
    }

    public g k() {
        org.joda.time.a L2 = L();
        if (L2 != null) {
            return L2.k();
        }
        return g.f10938a;
    }

    public String toString() {
        org.joda.time.e.b bVar;
        StringBuffer stringBuffer = new StringBuffer(60);
        stringBuffer.append("GJChronology");
        stringBuffer.append('[');
        stringBuffer.append(k().c());
        if (this.iCutoverMillis != K.n()) {
            stringBuffer.append(",cutover=");
            if (G().g().c(this.iCutoverMillis) == 0) {
                bVar = org.joda.time.e.j.a();
            } else {
                bVar = org.joda.time.e.j.b();
            }
            bVar.a(G()).a(stringBuffer, this.iCutoverMillis);
        }
        if (N() != 4) {
            stringBuffer.append(",mdfw=");
            stringBuffer.append(N());
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    private n(org.joda.time.a aVar, w wVar, t tVar, j jVar) {
        super(aVar, new Object[]{wVar, tVar, jVar});
    }

    private static long a(long j2, org.joda.time.a aVar, org.joda.time.a aVar2) {
        return aVar2.r().b(aVar2.f().b(aVar2.B().b(aVar2.D().b(0, aVar.D().a(j2)), aVar.B().a(j2)), aVar.f().a(j2)), aVar.r().a(j2));
    }

    private static long b(long j2, org.joda.time.a aVar, org.joda.time.a aVar2) {
        return aVar2.a(aVar.H().a(j2), aVar.w().a(j2), aVar.e().a(j2), aVar.r().a(j2));
    }

    public static n a(g gVar, r rVar) {
        return a(gVar, rVar, 4);
    }

    public static n a(g gVar, r rVar, int i2) {
        j jVar;
        n nVar;
        g a2 = org.joda.time.e.a(gVar);
        if (rVar == null) {
            jVar = K;
        } else {
            jVar = rVar.toInstant();
            if (new l(jVar.n(), t.b(a2)).b() <= 0) {
                throw new IllegalArgumentException("Cutover too early. Must be on or after 0001-01-01.");
            }
        }
        m mVar = new m(a2, jVar, i2);
        n nVar2 = (n) L.get(mVar);
        if (nVar2 != null) {
            return nVar2;
        }
        g gVar2 = g.f10938a;
        if (a2 == gVar2) {
            nVar = new n(w.a(a2, i2), t.a(a2, i2), jVar);
        } else {
            n a3 = a(gVar2, (r) jVar, i2);
            nVar = new n(y.a((org.joda.time.a) a3, a2), a3.iJulianChronology, a3.iGregorianChronology, a3.iCutoverInstant);
        }
        n nVar3 = (n) L.putIfAbsent(mVar, nVar);
        return nVar3 != null ? nVar3 : nVar;
    }

    /* access modifiers changed from: 0000 */
    public long b(long j2) {
        return b(j2, this.iGregorianChronology, this.iJulianChronology);
    }

    public static n a(g gVar, long j2, int i2) {
        r rVar;
        if (j2 == K.n()) {
            rVar = null;
        } else {
            rVar = new j(j2);
        }
        return a(gVar, rVar, i2);
    }

    public org.joda.time.a a(g gVar) {
        if (gVar == null) {
            gVar = g.b();
        }
        if (gVar == k()) {
            return this;
        }
        return a(gVar, (r) this.iCutoverInstant, N());
    }

    public long a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        org.joda.time.a L2 = L();
        if (L2 != null) {
            return L2.a(i2, i3, i4, i5);
        }
        long a2 = this.iGregorianChronology.a(i2, i3, i4, i5);
        if (a2 < this.iCutoverMillis) {
            a2 = this.iJulianChronology.a(i2, i3, i4, i5);
            if (a2 >= this.iCutoverMillis) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
        }
        return a2;
    }

    public long a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        long j2;
        org.joda.time.a L2 = L();
        if (L2 != null) {
            return L2.a(i2, i3, i4, i5, i6, i7, i8);
        }
        try {
            j2 = this.iGregorianChronology.a(i2, i3, i4, i5, i6, i7, i8);
            int i9 = i3;
            int i10 = i4;
        } catch (IllegalFieldValueException e2) {
            if (i3 == 2 && i4 == 29) {
                j2 = this.iGregorianChronology.a(i2, i3, 28, i5, i6, i7, i8);
                if (j2 >= this.iCutoverMillis) {
                    throw e2;
                }
            } else {
                throw e2;
            }
        }
        if (j2 < this.iCutoverMillis) {
            j2 = this.iJulianChronology.a(i2, i3, i4, i5, i6, i7, i8);
            if (j2 >= this.iCutoverMillis) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
        }
        return j2;
    }

    /* access modifiers changed from: protected */
    public void a(C0124a aVar) {
        Object[] objArr = (Object[]) M();
        w wVar = (w) objArr[0];
        t tVar = (t) objArr[1];
        j jVar = (j) objArr[2];
        this.iCutoverMillis = jVar.n();
        this.iJulianChronology = wVar;
        this.iGregorianChronology = tVar;
        this.iCutoverInstant = jVar;
        if (L() == null) {
            if (wVar.Y() == tVar.Y()) {
                long j2 = this.iCutoverMillis;
                this.iGapDuration = j2 - d(j2);
                aVar.a((org.joda.time.a) tVar);
                if (tVar.r().a(this.iCutoverMillis) == 0) {
                    a aVar2 = new a(this, wVar.s(), aVar.m, this.iCutoverMillis);
                    aVar.m = aVar2;
                    a aVar3 = new a(this, wVar.r(), aVar.n, this.iCutoverMillis);
                    aVar.n = aVar3;
                    a aVar4 = new a(this, wVar.z(), aVar.o, this.iCutoverMillis);
                    aVar.o = aVar4;
                    a aVar5 = new a(this, wVar.y(), aVar.p, this.iCutoverMillis);
                    aVar.p = aVar5;
                    a aVar6 = new a(this, wVar.u(), aVar.q, this.iCutoverMillis);
                    aVar.q = aVar6;
                    a aVar7 = new a(this, wVar.t(), aVar.r, this.iCutoverMillis);
                    aVar.r = aVar7;
                    a aVar8 = new a(this, wVar.n(), aVar.s, this.iCutoverMillis);
                    aVar.s = aVar8;
                    a aVar9 = new a(this, wVar.o(), aVar.u, this.iCutoverMillis);
                    aVar.u = aVar9;
                    a aVar10 = new a(this, wVar.c(), aVar.t, this.iCutoverMillis);
                    aVar.t = aVar10;
                    a aVar11 = new a(this, wVar.d(), aVar.v, this.iCutoverMillis);
                    aVar.v = aVar11;
                    a aVar12 = new a(this, wVar.l(), aVar.w, this.iCutoverMillis);
                    aVar.w = aVar12;
                }
                a aVar13 = new a(this, wVar.i(), aVar.I, this.iCutoverMillis);
                aVar.I = aVar13;
                b bVar = new b(this, wVar.H(), aVar.E, this.iCutoverMillis);
                aVar.E = bVar;
                aVar.f10716j = aVar.E.a();
                b bVar2 = new b(this, wVar.J(), aVar.F, aVar.f10716j, this.iCutoverMillis);
                aVar.F = bVar2;
                b bVar3 = new b(this, wVar.b(), aVar.H, this.iCutoverMillis);
                aVar.H = bVar3;
                aVar.f10717k = aVar.H.a();
                b bVar4 = new b(this, wVar.I(), aVar.G, aVar.f10716j, aVar.f10717k, this.iCutoverMillis);
                aVar.G = bVar4;
                b bVar5 = new b(this, wVar.w(), aVar.D, (h) null, aVar.f10716j, this.iCutoverMillis);
                aVar.D = bVar5;
                aVar.f10715i = aVar.D.a();
                b bVar6 = new b(wVar.D(), aVar.B, (h) null, this.iCutoverMillis, true);
                aVar.B = bVar6;
                aVar.f10714h = aVar.B.a();
                b bVar7 = new b(this, wVar.E(), aVar.C, aVar.f10714h, aVar.f10717k, this.iCutoverMillis);
                aVar.C = bVar7;
                a aVar14 = new a(wVar.g(), aVar.z, aVar.f10716j, tVar.H().d(this.iCutoverMillis), false);
                aVar.z = aVar14;
                a aVar15 = new a(wVar.B(), aVar.A, aVar.f10714h, tVar.D().d(this.iCutoverMillis), true);
                aVar.A = aVar15;
                a aVar16 = new a(this, wVar.e(), aVar.y, this.iCutoverMillis);
                aVar16.f10738g = aVar.f10715i;
                aVar.y = aVar16;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: 0000 */
    public long a(long j2) {
        return a(j2, (org.joda.time.a) this.iGregorianChronology, (org.joda.time.a) this.iJulianChronology);
    }
}
