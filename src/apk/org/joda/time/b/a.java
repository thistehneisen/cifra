package org.joda.time.b;

import java.io.IOException;
import java.io.ObjectInputStream;
import org.joda.time.c;
import org.joda.time.g;
import org.joda.time.h;

/* compiled from: AssembledChronology */
public abstract class a extends b {
    private static final long serialVersionUID = -6728465968995518215L;
    private transient c A;
    private transient c B;
    private transient c C;
    private transient c D;
    private transient c E;
    private transient c F;
    private transient c G;
    private transient c H;
    private transient c I;
    private transient int J;

    /* renamed from: a reason: collision with root package name */
    private transient h f10695a;

    /* renamed from: b reason: collision with root package name */
    private transient h f10696b;

    /* renamed from: c reason: collision with root package name */
    private transient h f10697c;

    /* renamed from: d reason: collision with root package name */
    private transient h f10698d;

    /* renamed from: e reason: collision with root package name */
    private transient h f10699e;

    /* renamed from: f reason: collision with root package name */
    private transient h f10700f;

    /* renamed from: g reason: collision with root package name */
    private transient h f10701g;

    /* renamed from: h reason: collision with root package name */
    private transient h f10702h;

    /* renamed from: i reason: collision with root package name */
    private transient h f10703i;
    private final org.joda.time.a iBase;
    private final Object iParam;

    /* renamed from: j reason: collision with root package name */
    private transient h f10704j;

    /* renamed from: k reason: collision with root package name */
    private transient h f10705k;

    /* renamed from: l reason: collision with root package name */
    private transient h f10706l;
    private transient c m;
    private transient c n;
    private transient c o;
    private transient c p;
    private transient c q;
    private transient c r;
    private transient c s;
    private transient c t;
    private transient c u;
    private transient c v;
    private transient c w;
    private transient c x;
    private transient c y;
    private transient c z;

    /* renamed from: org.joda.time.b.a$a reason: collision with other inner class name */
    /* compiled from: AssembledChronology */
    public static final class C0124a {
        public c A;
        public c B;
        public c C;
        public c D;
        public c E;
        public c F;
        public c G;
        public c H;
        public c I;

        /* renamed from: a reason: collision with root package name */
        public h f10707a;

        /* renamed from: b reason: collision with root package name */
        public h f10708b;

        /* renamed from: c reason: collision with root package name */
        public h f10709c;

        /* renamed from: d reason: collision with root package name */
        public h f10710d;

        /* renamed from: e reason: collision with root package name */
        public h f10711e;

        /* renamed from: f reason: collision with root package name */
        public h f10712f;

        /* renamed from: g reason: collision with root package name */
        public h f10713g;

        /* renamed from: h reason: collision with root package name */
        public h f10714h;

        /* renamed from: i reason: collision with root package name */
        public h f10715i;

        /* renamed from: j reason: collision with root package name */
        public h f10716j;

        /* renamed from: k reason: collision with root package name */
        public h f10717k;

        /* renamed from: l reason: collision with root package name */
        public h f10718l;
        public c m;
        public c n;
        public c o;
        public c p;
        public c q;
        public c r;
        public c s;
        public c t;
        public c u;
        public c v;
        public c w;
        public c x;
        public c y;
        public c z;

        C0124a() {
        }

        public void a(org.joda.time.a aVar) {
            h q2 = aVar.q();
            if (a(q2)) {
                this.f10707a = q2;
            }
            h A2 = aVar.A();
            if (a(A2)) {
                this.f10708b = A2;
            }
            h v2 = aVar.v();
            if (a(v2)) {
                this.f10709c = v2;
            }
            h p2 = aVar.p();
            if (a(p2)) {
                this.f10710d = p2;
            }
            h m2 = aVar.m();
            if (a(m2)) {
                this.f10711e = m2;
            }
            h h2 = aVar.h();
            if (a(h2)) {
                this.f10712f = h2;
            }
            h C2 = aVar.C();
            if (a(C2)) {
                this.f10713g = C2;
            }
            h F2 = aVar.F();
            if (a(F2)) {
                this.f10714h = F2;
            }
            h x2 = aVar.x();
            if (a(x2)) {
                this.f10715i = x2;
            }
            h K = aVar.K();
            if (a(K)) {
                this.f10716j = K;
            }
            h a2 = aVar.a();
            if (a(a2)) {
                this.f10717k = a2;
            }
            h j2 = aVar.j();
            if (a(j2)) {
                this.f10718l = j2;
            }
            c s2 = aVar.s();
            if (a(s2)) {
                this.m = s2;
            }
            c r2 = aVar.r();
            if (a(r2)) {
                this.n = r2;
            }
            c z2 = aVar.z();
            if (a(z2)) {
                this.o = z2;
            }
            c y2 = aVar.y();
            if (a(y2)) {
                this.p = y2;
            }
            c u2 = aVar.u();
            if (a(u2)) {
                this.q = u2;
            }
            c t2 = aVar.t();
            if (a(t2)) {
                this.r = t2;
            }
            c n2 = aVar.n();
            if (a(n2)) {
                this.s = n2;
            }
            c c2 = aVar.c();
            if (a(c2)) {
                this.t = c2;
            }
            c o2 = aVar.o();
            if (a(o2)) {
                this.u = o2;
            }
            c d2 = aVar.d();
            if (a(d2)) {
                this.v = d2;
            }
            c l2 = aVar.l();
            if (a(l2)) {
                this.w = l2;
            }
            c f2 = aVar.f();
            if (a(f2)) {
                this.x = f2;
            }
            c e2 = aVar.e();
            if (a(e2)) {
                this.y = e2;
            }
            c g2 = aVar.g();
            if (a(g2)) {
                this.z = g2;
            }
            c B2 = aVar.B();
            if (a(B2)) {
                this.A = B2;
            }
            c D2 = aVar.D();
            if (a(D2)) {
                this.B = D2;
            }
            c E2 = aVar.E();
            if (a(E2)) {
                this.C = E2;
            }
            c w2 = aVar.w();
            if (a(w2)) {
                this.D = w2;
            }
            c H2 = aVar.H();
            if (a(H2)) {
                this.E = H2;
            }
            c J = aVar.J();
            if (a(J)) {
                this.F = J;
            }
            c I2 = aVar.I();
            if (a(I2)) {
                this.G = I2;
            }
            c b2 = aVar.b();
            if (a(b2)) {
                this.H = b2;
            }
            c i2 = aVar.i();
            if (a(i2)) {
                this.I = i2;
            }
        }

        private static boolean a(h hVar) {
            if (hVar == null) {
                return false;
            }
            return hVar.d();
        }

        private static boolean a(c cVar) {
            if (cVar == null) {
                return false;
            }
            return cVar.i();
        }
    }

    protected a(org.joda.time.a aVar, Object obj) {
        this.iBase = aVar;
        this.iParam = obj;
        N();
    }

    private void N() {
        C0124a aVar = new C0124a();
        org.joda.time.a aVar2 = this.iBase;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        a(aVar);
        h hVar = aVar.f10707a;
        if (hVar == null) {
            hVar = super.q();
        }
        this.f10695a = hVar;
        h hVar2 = aVar.f10708b;
        if (hVar2 == null) {
            hVar2 = super.A();
        }
        this.f10696b = hVar2;
        h hVar3 = aVar.f10709c;
        if (hVar3 == null) {
            hVar3 = super.v();
        }
        this.f10697c = hVar3;
        h hVar4 = aVar.f10710d;
        if (hVar4 == null) {
            hVar4 = super.p();
        }
        this.f10698d = hVar4;
        h hVar5 = aVar.f10711e;
        if (hVar5 == null) {
            hVar5 = super.m();
        }
        this.f10699e = hVar5;
        h hVar6 = aVar.f10712f;
        if (hVar6 == null) {
            hVar6 = super.h();
        }
        this.f10700f = hVar6;
        h hVar7 = aVar.f10713g;
        if (hVar7 == null) {
            hVar7 = super.C();
        }
        this.f10701g = hVar7;
        h hVar8 = aVar.f10714h;
        if (hVar8 == null) {
            hVar8 = super.F();
        }
        this.f10702h = hVar8;
        h hVar9 = aVar.f10715i;
        if (hVar9 == null) {
            hVar9 = super.x();
        }
        this.f10703i = hVar9;
        h hVar10 = aVar.f10716j;
        if (hVar10 == null) {
            hVar10 = super.K();
        }
        this.f10704j = hVar10;
        h hVar11 = aVar.f10717k;
        if (hVar11 == null) {
            hVar11 = super.a();
        }
        this.f10705k = hVar11;
        h hVar12 = aVar.f10718l;
        if (hVar12 == null) {
            hVar12 = super.j();
        }
        this.f10706l = hVar12;
        c cVar = aVar.m;
        if (cVar == null) {
            cVar = super.s();
        }
        this.m = cVar;
        c cVar2 = aVar.n;
        if (cVar2 == null) {
            cVar2 = super.r();
        }
        this.n = cVar2;
        c cVar3 = aVar.o;
        if (cVar3 == null) {
            cVar3 = super.z();
        }
        this.o = cVar3;
        c cVar4 = aVar.p;
        if (cVar4 == null) {
            cVar4 = super.y();
        }
        this.p = cVar4;
        c cVar5 = aVar.q;
        if (cVar5 == null) {
            cVar5 = super.u();
        }
        this.q = cVar5;
        c cVar6 = aVar.r;
        if (cVar6 == null) {
            cVar6 = super.t();
        }
        this.r = cVar6;
        c cVar7 = aVar.s;
        if (cVar7 == null) {
            cVar7 = super.n();
        }
        this.s = cVar7;
        c cVar8 = aVar.t;
        if (cVar8 == null) {
            cVar8 = super.c();
        }
        this.t = cVar8;
        c cVar9 = aVar.u;
        if (cVar9 == null) {
            cVar9 = super.o();
        }
        this.u = cVar9;
        c cVar10 = aVar.v;
        if (cVar10 == null) {
            cVar10 = super.d();
        }
        this.v = cVar10;
        c cVar11 = aVar.w;
        if (cVar11 == null) {
            cVar11 = super.l();
        }
        this.w = cVar11;
        c cVar12 = aVar.x;
        if (cVar12 == null) {
            cVar12 = super.f();
        }
        this.x = cVar12;
        c cVar13 = aVar.y;
        if (cVar13 == null) {
            cVar13 = super.e();
        }
        this.y = cVar13;
        c cVar14 = aVar.z;
        if (cVar14 == null) {
            cVar14 = super.g();
        }
        this.z = cVar14;
        c cVar15 = aVar.A;
        if (cVar15 == null) {
            cVar15 = super.B();
        }
        this.A = cVar15;
        c cVar16 = aVar.B;
        if (cVar16 == null) {
            cVar16 = super.D();
        }
        this.B = cVar16;
        c cVar17 = aVar.C;
        if (cVar17 == null) {
            cVar17 = super.E();
        }
        this.C = cVar17;
        c cVar18 = aVar.D;
        if (cVar18 == null) {
            cVar18 = super.w();
        }
        this.D = cVar18;
        c cVar19 = aVar.E;
        if (cVar19 == null) {
            cVar19 = super.H();
        }
        this.E = cVar19;
        c cVar20 = aVar.F;
        if (cVar20 == null) {
            cVar20 = super.J();
        }
        this.F = cVar20;
        c cVar21 = aVar.G;
        if (cVar21 == null) {
            cVar21 = super.I();
        }
        this.G = cVar21;
        c cVar22 = aVar.H;
        if (cVar22 == null) {
            cVar22 = super.b();
        }
        this.H = cVar22;
        c cVar23 = aVar.I;
        if (cVar23 == null) {
            cVar23 = super.i();
        }
        this.I = cVar23;
        org.joda.time.a aVar3 = this.iBase;
        int i2 = 0;
        if (aVar3 != null) {
            int i3 = ((this.s == aVar3.n() && this.q == this.iBase.u() && this.o == this.iBase.z() && this.m == this.iBase.s()) ? 1 : 0) | (this.n == this.iBase.r() ? 2 : 0);
            if (this.E == this.iBase.H() && this.D == this.iBase.w() && this.y == this.iBase.e()) {
                i2 = 4;
            }
            i2 |= i3;
        }
        this.J = i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        N();
    }

    public final h A() {
        return this.f10696b;
    }

    public final c B() {
        return this.A;
    }

    public final h C() {
        return this.f10701g;
    }

    public final c D() {
        return this.B;
    }

    public final c E() {
        return this.C;
    }

    public final h F() {
        return this.f10702h;
    }

    public final c H() {
        return this.E;
    }

    public final c I() {
        return this.G;
    }

    public final c J() {
        return this.F;
    }

    public final h K() {
        return this.f10704j;
    }

    /* access modifiers changed from: protected */
    public final org.joda.time.a L() {
        return this.iBase;
    }

    /* access modifiers changed from: protected */
    public final Object M() {
        return this.iParam;
    }

    public long a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        org.joda.time.a aVar = this.iBase;
        if (aVar == null || (this.J & 6) != 6) {
            return super.a(i2, i3, i4, i5);
        }
        return aVar.a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public abstract void a(C0124a aVar);

    public final c b() {
        return this.H;
    }

    public final c c() {
        return this.t;
    }

    public final c d() {
        return this.v;
    }

    public final c e() {
        return this.y;
    }

    public final c f() {
        return this.x;
    }

    public final c g() {
        return this.z;
    }

    public final h h() {
        return this.f10700f;
    }

    public final c i() {
        return this.I;
    }

    public final h j() {
        return this.f10706l;
    }

    public g k() {
        org.joda.time.a aVar = this.iBase;
        if (aVar != null) {
            return aVar.k();
        }
        return null;
    }

    public final c l() {
        return this.w;
    }

    public final h m() {
        return this.f10699e;
    }

    public final c n() {
        return this.s;
    }

    public final c o() {
        return this.u;
    }

    public final h p() {
        return this.f10698d;
    }

    public final h q() {
        return this.f10695a;
    }

    public final c r() {
        return this.n;
    }

    public final c s() {
        return this.m;
    }

    public final c t() {
        return this.r;
    }

    public final c u() {
        return this.q;
    }

    public final h v() {
        return this.f10697c;
    }

    public final c w() {
        return this.D;
    }

    public final h x() {
        return this.f10703i;
    }

    public final c y() {
        return this.p;
    }

    public final c z() {
        return this.o;
    }

    public long a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        org.joda.time.a aVar = this.iBase;
        if (aVar == null || (this.J & 5) != 5) {
            return super.a(i2, i3, i4, i5, i6, i7, i8);
        }
        return aVar.a(i2, i3, i4, i5, i6, i7, i8);
    }

    public final h a() {
        return this.f10705k;
    }
}
