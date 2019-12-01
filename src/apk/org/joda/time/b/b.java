package org.joda.time.b;

import java.io.Serializable;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.d.s;
import org.joda.time.d.t;
import org.joda.time.h;
import org.joda.time.i;

/* compiled from: BaseChronology */
public abstract class b extends a implements Serializable {
    private static final long serialVersionUID = -7310865996721419676L;

    protected b() {
    }

    public h A() {
        return t.a(i.j());
    }

    public c B() {
        return s.a(d.Q(), C());
    }

    public h C() {
        return t.a(i.k());
    }

    public c D() {
        return s.a(d.R(), F());
    }

    public c E() {
        return s.a(d.S(), F());
    }

    public h F() {
        return t.a(i.l());
    }

    public c H() {
        return s.a(d.T(), K());
    }

    public c I() {
        return s.a(d.U(), K());
    }

    public c J() {
        return s.a(d.V(), K());
    }

    public h K() {
        return t.a(i.m());
    }

    public long a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        return r().b(e().b(w().b(H().b(0, i2), i3), i4), i5);
    }

    public c b() {
        return s.a(d.x(), a());
    }

    public c c() {
        return s.a(d.y(), p());
    }

    public c d() {
        return s.a(d.z(), p());
    }

    public c e() {
        return s.a(d.A(), h());
    }

    public c f() {
        return s.a(d.B(), h());
    }

    public c g() {
        return s.a(d.C(), h());
    }

    public h h() {
        return t.a(i.b());
    }

    public c i() {
        return s.a(d.D(), j());
    }

    public h j() {
        return t.a(i.c());
    }

    public c l() {
        return s.a(d.G(), m());
    }

    public h m() {
        return t.a(i.e());
    }

    public c n() {
        return s.a(d.H(), p());
    }

    public c o() {
        return s.a(d.I(), p());
    }

    public h p() {
        return t.a(i.f());
    }

    public h q() {
        return t.a(i.g());
    }

    public c r() {
        return s.a(d.J(), q());
    }

    public c s() {
        return s.a(d.K(), q());
    }

    public c t() {
        return s.a(d.L(), v());
    }

    public c u() {
        return s.a(d.M(), v());
    }

    public h v() {
        return t.a(i.h());
    }

    public c w() {
        return s.a(d.N(), x());
    }

    public h x() {
        return t.a(i.i());
    }

    public c y() {
        return s.a(d.O(), A());
    }

    public c z() {
        return s.a(d.P(), A());
    }

    public long a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        return s().b(z().b(u().b(n().b(e().b(w().b(H().b(0, i2), i3), i4), i5), i6), i7), i8);
    }

    public long a(org.joda.time.t tVar, long j2) {
        int size = tVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            j2 = tVar.a(i2).a(this).b(j2, tVar.getValue(i2));
        }
        return j2;
    }

    public h a() {
        return t.a(i.a());
    }
}
