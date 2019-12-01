package com.google.android.gms.internal.measurement;

import io.intercom.android.sdk.metrics.MetricTracker.Object;
import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.kb reason: case insensitive filesystem */
final class C0387kb implements Bc {

    /* renamed from: a reason: collision with root package name */
    private final C0381jb f5251a;

    /* renamed from: b reason: collision with root package name */
    private int f5252b;

    /* renamed from: c reason: collision with root package name */
    private int f5253c;

    /* renamed from: d reason: collision with root package name */
    private int f5254d = 0;

    private C0387kb(C0381jb jbVar) {
        Fb.a(jbVar, Object.INPUT);
        this.f5251a = jbVar;
        this.f5251a.f5232d = this;
    }

    public static C0387kb a(C0381jb jbVar) {
        C0387kb kbVar = jbVar.f5232d;
        if (kbVar != null) {
            return kbVar;
        }
        return new C0387kb(jbVar);
    }

    private final <T> T d(Ac<T> ac, C0428rb rbVar) throws IOException {
        int i2 = this.f5253c;
        this.f5253c = ((this.f5252b >>> 3) << 3) | 4;
        try {
            T a2 = ac.a();
            ac.a(a2, this, rbVar);
            ac.c(a2);
            if (this.f5252b == this.f5253c) {
                return a2;
            }
            throw zzfi.h();
        } finally {
            this.f5253c = i2;
        }
    }

    public final <T> T b(Ac<T> ac, C0428rb rbVar) throws IOException {
        a(2);
        return c(ac, rbVar);
    }

    public final int c() throws IOException {
        a(5);
        return this.f5251a.i();
    }

    public final long e() throws IOException {
        a(1);
        return this.f5251a.p();
    }

    public final long f() throws IOException {
        a(1);
        return this.f5251a.h();
    }

    public final int g() throws IOException {
        a(5);
        return this.f5251a.o();
    }

    public final int getTag() {
        return this.f5252b;
    }

    public final int h() throws IOException {
        a(0);
        return this.f5251a.g();
    }

    public final int i() throws IOException {
        a(0);
        return this.f5251a.n();
    }

    public final boolean j() throws IOException {
        if (!this.f5251a.s()) {
            int i2 = this.f5252b;
            if (i2 != this.f5253c) {
                return this.f5251a.b(i2);
            }
        }
        return false;
    }

    public final long k() throws IOException {
        a(0);
        return this.f5251a.f();
    }

    public final int l() throws IOException {
        a(0);
        return this.f5251a.m();
    }

    public final int m() throws IOException {
        int i2 = this.f5254d;
        if (i2 != 0) {
            this.f5252b = i2;
            this.f5254d = 0;
        } else {
            this.f5252b = this.f5251a.d();
        }
        int i3 = this.f5252b;
        if (i3 == 0 || i3 == this.f5253c) {
            return Integer.MAX_VALUE;
        }
        return i3 >>> 3;
    }

    public final long n() throws IOException {
        a(0);
        return this.f5251a.e();
    }

    public final Xa o() throws IOException {
        a(2);
        return this.f5251a.l();
    }

    public final String p() throws IOException {
        a(2);
        return this.f5251a.k();
    }

    public final void q(List<String> list) throws IOException {
        a(list, true);
    }

    public final double readDouble() throws IOException {
        a(1);
        return this.f5251a.a();
    }

    public final float readFloat() throws IOException {
        a(5);
        return this.f5251a.b();
    }

    public final String readString() throws IOException {
        a(2);
        return this.f5251a.c();
    }

    private final void a(int i2) throws IOException {
        if ((this.f5252b & 7) != i2) {
            throw zzfi.f();
        }
    }

    private final <T> T c(Ac<T> ac, C0428rb rbVar) throws IOException {
        int m = this.f5251a.m();
        C0381jb jbVar = this.f5251a;
        if (jbVar.f5229a < jbVar.f5230b) {
            int d2 = jbVar.d(m);
            T a2 = ac.a();
            this.f5251a.f5229a++;
            ac.a(a2, this, rbVar);
            ac.c(a2);
            this.f5251a.a(0);
            C0381jb jbVar2 = this.f5251a;
            jbVar2.f5229a--;
            jbVar2.e(d2);
            return a2;
        }
        throw zzfi.g();
    }

    public final int b() throws IOException {
        a(0);
        return this.f5251a.q();
    }

    public final void e(List<Float> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof Ab) {
            Ab ab = (Ab) list;
            int i2 = this.f5252b & 7;
            if (i2 == 2) {
                int m = this.f5251a.m();
                c(m);
                int t = this.f5251a.t() + m;
                do {
                    ab.a(this.f5251a.b());
                } while (this.f5251a.t() < t);
            } else if (i2 == 5) {
                do {
                    ab.a(this.f5251a.b());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 2) {
                int m2 = this.f5251a.m();
                c(m2);
                int t2 = this.f5251a.t() + m2;
                do {
                    list.add(Float.valueOf(this.f5251a.b()));
                } while (this.f5251a.t() < t2);
            } else if (i3 == 5) {
                do {
                    list.add(Float.valueOf(this.f5251a.b()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else {
                throw zzfi.f();
            }
        }
    }

    public final void f(List<Long> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof C0325ac) {
            C0325ac acVar = (C0325ac) list;
            int i2 = this.f5252b & 7;
            if (i2 == 1) {
                do {
                    acVar.a(this.f5251a.h());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else if (i2 == 2) {
                int m = this.f5251a.m();
                b(m);
                int t = this.f5251a.t() + m;
                do {
                    acVar.a(this.f5251a.h());
                } while (this.f5251a.t() < t);
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.f5251a.h()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else if (i3 == 2) {
                int m2 = this.f5251a.m();
                b(m2);
                int t2 = this.f5251a.t() + m2;
                do {
                    list.add(Long.valueOf(this.f5251a.h()));
                } while (this.f5251a.t() < t2);
            } else {
                throw zzfi.f();
            }
        }
    }

    public final void g(List<Long> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof C0325ac) {
            C0325ac acVar = (C0325ac) list;
            int i2 = this.f5252b & 7;
            if (i2 == 1) {
                do {
                    acVar.a(this.f5251a.p());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else if (i2 == 2) {
                int m = this.f5251a.m();
                b(m);
                int t = this.f5251a.t() + m;
                do {
                    acVar.a(this.f5251a.p());
                } while (this.f5251a.t() < t);
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.f5251a.p()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else if (i3 == 2) {
                int m2 = this.f5251a.m();
                b(m2);
                int t2 = this.f5251a.t() + m2;
                do {
                    list.add(Long.valueOf(this.f5251a.p()));
                } while (this.f5251a.t() < t2);
            } else {
                throw zzfi.f();
            }
        }
    }

    public final void h(List<Integer> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof Hb) {
            Hb hb = (Hb) list;
            int i2 = this.f5252b & 7;
            if (i2 == 0) {
                do {
                    hb.f(this.f5251a.g());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else if (i2 == 2) {
                int t = this.f5251a.t() + this.f5251a.m();
                do {
                    hb.f(this.f5251a.g());
                } while (this.f5251a.t() < t);
                d(t);
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5251a.g()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else if (i3 == 2) {
                int t2 = this.f5251a.t() + this.f5251a.m();
                do {
                    list.add(Integer.valueOf(this.f5251a.g()));
                } while (this.f5251a.t() < t2);
                d(t2);
            } else {
                throw zzfi.f();
            }
        }
    }

    public final void i(List<Integer> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof Hb) {
            Hb hb = (Hb) list;
            int i2 = this.f5252b & 7;
            if (i2 == 2) {
                int m = this.f5251a.m();
                c(m);
                int t = this.f5251a.t() + m;
                do {
                    hb.f(this.f5251a.o());
                } while (this.f5251a.t() < t);
            } else if (i2 == 5) {
                do {
                    hb.f(this.f5251a.o());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 2) {
                int m2 = this.f5251a.m();
                c(m2);
                int t2 = this.f5251a.t() + m2;
                do {
                    list.add(Integer.valueOf(this.f5251a.o()));
                } while (this.f5251a.t() < t2);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.f5251a.o()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else {
                throw zzfi.f();
            }
        }
    }

    public final void j(List<Boolean> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof Va) {
            Va va = (Va) list;
            int i2 = this.f5252b & 7;
            if (i2 == 0) {
                do {
                    va.a(this.f5251a.j());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else if (i2 == 2) {
                int t = this.f5251a.t() + this.f5251a.m();
                do {
                    va.a(this.f5251a.j());
                } while (this.f5251a.t() < t);
                d(t);
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f5251a.j()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else if (i3 == 2) {
                int t2 = this.f5251a.t() + this.f5251a.m();
                do {
                    list.add(Boolean.valueOf(this.f5251a.j()));
                } while (this.f5251a.t() < t2);
                d(t2);
            } else {
                throw zzfi.f();
            }
        }
    }

    public final void k(List<Long> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof C0325ac) {
            C0325ac acVar = (C0325ac) list;
            int i2 = this.f5252b & 7;
            if (i2 == 0) {
                do {
                    acVar.a(this.f5251a.r());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else if (i2 == 2) {
                int t = this.f5251a.t() + this.f5251a.m();
                do {
                    acVar.a(this.f5251a.r());
                } while (this.f5251a.t() < t);
                d(t);
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f5251a.r()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else if (i3 == 2) {
                int t2 = this.f5251a.t() + this.f5251a.m();
                do {
                    list.add(Long.valueOf(this.f5251a.r()));
                } while (this.f5251a.t() < t2);
                d(t2);
            } else {
                throw zzfi.f();
            }
        }
    }

    public final void l(List<Integer> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof Hb) {
            Hb hb = (Hb) list;
            int i2 = this.f5252b & 7;
            if (i2 == 2) {
                int m = this.f5251a.m();
                c(m);
                int t = this.f5251a.t() + m;
                do {
                    hb.f(this.f5251a.i());
                } while (this.f5251a.t() < t);
            } else if (i2 == 5) {
                do {
                    hb.f(this.f5251a.i());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 2) {
                int m2 = this.f5251a.m();
                c(m2);
                int t2 = this.f5251a.t() + m2;
                do {
                    list.add(Integer.valueOf(this.f5251a.i()));
                } while (this.f5251a.t() < t2);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.f5251a.i()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else {
                throw zzfi.f();
            }
        }
    }

    public final void n(List<String> list) throws IOException {
        a(list, false);
    }

    public final void o(List<Xa> list) throws IOException {
        int d2;
        if ((this.f5252b & 7) == 2) {
            do {
                list.add(o());
                if (!this.f5251a.s()) {
                    d2 = this.f5251a.d();
                } else {
                    return;
                }
            } while (d2 == this.f5252b);
            this.f5254d = d2;
            return;
        }
        throw zzfi.f();
    }

    public final void p(List<Double> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof C0405nb) {
            C0405nb nbVar = (C0405nb) list;
            int i2 = this.f5252b & 7;
            if (i2 == 1) {
                do {
                    nbVar.a(this.f5251a.a());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else if (i2 == 2) {
                int m = this.f5251a.m();
                b(m);
                int t = this.f5251a.t() + m;
                do {
                    nbVar.a(this.f5251a.a());
                } while (this.f5251a.t() < t);
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(this.f5251a.a()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else if (i3 == 2) {
                int m2 = this.f5251a.m();
                b(m2);
                int t2 = this.f5251a.t() + m2;
                do {
                    list.add(Double.valueOf(this.f5251a.a()));
                } while (this.f5251a.t() < t2);
            } else {
                throw zzfi.f();
            }
        }
    }

    public final boolean a() throws IOException {
        a(0);
        return this.f5251a.j();
    }

    public final void b(List<Long> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof C0325ac) {
            C0325ac acVar = (C0325ac) list;
            int i2 = this.f5252b & 7;
            if (i2 == 0) {
                do {
                    acVar.a(this.f5251a.e());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else if (i2 == 2) {
                int t = this.f5251a.t() + this.f5251a.m();
                do {
                    acVar.a(this.f5251a.e());
                } while (this.f5251a.t() < t);
                d(t);
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f5251a.e()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else if (i3 == 2) {
                int t2 = this.f5251a.t() + this.f5251a.m();
                do {
                    list.add(Long.valueOf(this.f5251a.e()));
                } while (this.f5251a.t() < t2);
                d(t2);
            } else {
                throw zzfi.f();
            }
        }
    }

    public final void m(List<Integer> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof Hb) {
            Hb hb = (Hb) list;
            int i2 = this.f5252b & 7;
            if (i2 == 0) {
                do {
                    hb.f(this.f5251a.q());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else if (i2 == 2) {
                int t = this.f5251a.t() + this.f5251a.m();
                do {
                    hb.f(this.f5251a.q());
                } while (this.f5251a.t() < t);
                d(t);
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5251a.q()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else if (i3 == 2) {
                int t2 = this.f5251a.t() + this.f5251a.m();
                do {
                    list.add(Integer.valueOf(this.f5251a.q()));
                } while (this.f5251a.t() < t2);
                d(t2);
            } else {
                throw zzfi.f();
            }
        }
    }

    public final <T> T a(Ac<T> ac, C0428rb rbVar) throws IOException {
        a(3);
        return d(ac, rbVar);
    }

    public final void a(List<Long> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof C0325ac) {
            C0325ac acVar = (C0325ac) list;
            int i2 = this.f5252b & 7;
            if (i2 == 0) {
                do {
                    acVar.a(this.f5251a.f());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else if (i2 == 2) {
                int t = this.f5251a.t() + this.f5251a.m();
                do {
                    acVar.a(this.f5251a.f());
                } while (this.f5251a.t() < t);
                d(t);
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f5251a.f()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else if (i3 == 2) {
                int t2 = this.f5251a.t() + this.f5251a.m();
                do {
                    list.add(Long.valueOf(this.f5251a.f()));
                } while (this.f5251a.t() < t2);
                d(t2);
            } else {
                throw zzfi.f();
            }
        }
    }

    public final long d() throws IOException {
        a(0);
        return this.f5251a.r();
    }

    public final void d(List<Integer> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof Hb) {
            Hb hb = (Hb) list;
            int i2 = this.f5252b & 7;
            if (i2 == 0) {
                do {
                    hb.f(this.f5251a.m());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else if (i2 == 2) {
                int t = this.f5251a.t() + this.f5251a.m();
                do {
                    hb.f(this.f5251a.m());
                } while (this.f5251a.t() < t);
                d(t);
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5251a.m()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else if (i3 == 2) {
                int t2 = this.f5251a.t() + this.f5251a.m();
                do {
                    list.add(Integer.valueOf(this.f5251a.m()));
                } while (this.f5251a.t() < t2);
                d(t2);
            } else {
                throw zzfi.f();
            }
        }
    }

    public final void c(List<Integer> list) throws IOException {
        int d2;
        int d3;
        if (list instanceof Hb) {
            Hb hb = (Hb) list;
            int i2 = this.f5252b & 7;
            if (i2 == 0) {
                do {
                    hb.f(this.f5251a.n());
                    if (!this.f5251a.s()) {
                        d3 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d3 == this.f5252b);
                this.f5254d = d3;
            } else if (i2 == 2) {
                int t = this.f5251a.t() + this.f5251a.m();
                do {
                    hb.f(this.f5251a.n());
                } while (this.f5251a.t() < t);
                d(t);
            } else {
                throw zzfi.f();
            }
        } else {
            int i3 = this.f5252b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5251a.n()));
                    if (!this.f5251a.s()) {
                        d2 = this.f5251a.d();
                    } else {
                        return;
                    }
                } while (d2 == this.f5252b);
                this.f5254d = d2;
            } else if (i3 == 2) {
                int t2 = this.f5251a.t() + this.f5251a.m();
                do {
                    list.add(Integer.valueOf(this.f5251a.n()));
                } while (this.f5251a.t() < t2);
                d(t2);
            } else {
                throw zzfi.f();
            }
        }
    }

    public final <T> void b(List<T> list, Ac<T> ac, C0428rb rbVar) throws IOException {
        int d2;
        int i2 = this.f5252b;
        if ((i2 & 7) == 3) {
            do {
                list.add(d(ac, rbVar));
                if (!this.f5251a.s() && this.f5254d == 0) {
                    d2 = this.f5251a.d();
                } else {
                    return;
                }
            } while (d2 == i2);
            this.f5254d = d2;
            return;
        }
        throw zzfi.f();
    }

    private final void a(List<String> list, boolean z) throws IOException {
        int d2;
        int d3;
        if ((this.f5252b & 7) != 2) {
            throw zzfi.f();
        } else if (!(list instanceof Ub) || z) {
            do {
                list.add(z ? p() : readString());
                if (!this.f5251a.s()) {
                    d2 = this.f5251a.d();
                } else {
                    return;
                }
            } while (d2 == this.f5252b);
            this.f5254d = d2;
        } else {
            Ub ub = (Ub) list;
            do {
                ub.a(o());
                if (!this.f5251a.s()) {
                    d3 = this.f5251a.d();
                } else {
                    return;
                }
            } while (d3 == this.f5252b);
            this.f5254d = d3;
        }
    }

    private static void b(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw zzfi.h();
        }
    }

    private final void d(int i2) throws IOException {
        if (this.f5251a.t() != i2) {
            throw zzfi.a();
        }
    }

    private static void c(int i2) throws IOException {
        if ((i2 & 3) != 0) {
            throw zzfi.h();
        }
    }

    public final <T> void a(List<T> list, Ac<T> ac, C0428rb rbVar) throws IOException {
        int d2;
        int i2 = this.f5252b;
        if ((i2 & 7) == 2) {
            do {
                list.add(c(ac, rbVar));
                if (!this.f5251a.s() && this.f5254d == 0) {
                    d2 = this.f5251a.d();
                } else {
                    return;
                }
            } while (d2 == i2);
            this.f5254d = d2;
            return;
        }
        throw zzfi.f();
    }
}
