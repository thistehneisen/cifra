package b.e.b.a;

import b.e.b.a.f.c;
import b.e.b.a.h.a;
import b.e.b.e;
import b.e.b.i;
import java.util.ArrayList;

/* compiled from: Guideline */
public class l extends h {
    private int Aa;
    protected float sa = -1.0f;
    protected int ta = -1;
    protected int ua = -1;
    private f va = this.w;
    private int wa;
    private boolean xa;
    private int ya;
    private p za;

    public l() {
        this.wa = 0;
        this.xa = false;
        this.ya = 0;
        this.za = new p();
        this.Aa = 8;
        this.E.clear();
        this.E.add(this.va);
        int length = this.D.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.D[i2] = this.va;
        }
    }

    public int K() {
        return this.wa;
    }

    public f a(c cVar) {
        switch (k.f2398a[cVar.ordinal()]) {
            case 1:
            case 2:
                if (this.wa == 1) {
                    return this.va;
                }
                break;
            case 3:
            case 4:
                if (this.wa == 0) {
                    return this.va;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(cVar.name());
    }

    public boolean b() {
        return true;
    }

    public ArrayList<f> c() {
        return this.E;
    }

    public void e(float f2) {
        if (f2 > -1.0f) {
            this.sa = f2;
            this.ta = -1;
            this.ua = -1;
        }
    }

    public void p(int i2) {
        if (i2 > -1) {
            this.sa = -1.0f;
            this.ta = i2;
            this.ua = -1;
        }
    }

    public void q(int i2) {
        if (i2 > -1) {
            this.sa = -1.0f;
            this.ta = -1;
            this.ua = i2;
        }
    }

    public void r(int i2) {
        if (this.wa != i2) {
            this.wa = i2;
            this.E.clear();
            if (this.wa == 1) {
                this.va = this.v;
            } else {
                this.va = this.w;
            }
            this.E.add(this.va);
            int length = this.D.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.D[i3] = this.va;
            }
        }
    }

    public void c(e eVar) {
        if (m() != null) {
            int b2 = eVar.b((Object) this.va);
            if (this.wa == 1) {
                n(b2);
                o(0);
                c(m().j());
                k(0);
            } else {
                n(0);
                o(b2);
                k(m().u());
                c(0);
            }
        }
    }

    public void a(int i2) {
        h m = m();
        if (m != null) {
            if (K() == 1) {
                this.w.d().a(1, m.w.d(), 0);
                this.y.d().a(1, m.w.d(), 0);
                if (this.ta != -1) {
                    this.v.d().a(1, m.v.d(), this.ta);
                    this.x.d().a(1, m.v.d(), this.ta);
                } else if (this.ua != -1) {
                    this.v.d().a(1, m.x.d(), -this.ua);
                    this.x.d().a(1, m.x.d(), -this.ua);
                } else if (this.sa != -1.0f && m.l() == a.FIXED) {
                    int i3 = (int) (((float) m.H) * this.sa);
                    this.v.d().a(1, m.v.d(), i3);
                    this.x.d().a(1, m.v.d(), i3);
                }
            } else {
                this.v.d().a(1, m.v.d(), 0);
                this.x.d().a(1, m.v.d(), 0);
                if (this.ta != -1) {
                    this.w.d().a(1, m.w.d(), this.ta);
                    this.y.d().a(1, m.w.d(), this.ta);
                } else if (this.ua != -1) {
                    this.w.d().a(1, m.y.d(), -this.ua);
                    this.y.d().a(1, m.y.d(), -this.ua);
                } else if (this.sa != -1.0f && m.s() == a.FIXED) {
                    int i4 = (int) (((float) m.I) * this.sa);
                    this.w.d().a(1, m.w.d(), i4);
                    this.y.d().a(1, m.w.d(), i4);
                }
            }
        }
    }

    public void a(e eVar) {
        i iVar = (i) m();
        if (iVar != null) {
            f a2 = iVar.a(c.LEFT);
            f a3 = iVar.a(c.RIGHT);
            h hVar = this.G;
            boolean z = hVar != null && hVar.F[0] == a.WRAP_CONTENT;
            if (this.wa == 0) {
                a2 = iVar.a(c.TOP);
                a3 = iVar.a(c.BOTTOM);
                h hVar2 = this.G;
                z = hVar2 != null && hVar2.F[1] == a.WRAP_CONTENT;
            }
            if (this.ta != -1) {
                i a4 = eVar.a((Object) this.va);
                eVar.a(a4, eVar.a((Object) a2), this.ta, 6);
                if (z) {
                    eVar.b(eVar.a((Object) a3), a4, 0, 5);
                }
            } else if (this.ua != -1) {
                i a5 = eVar.a((Object) this.va);
                i a6 = eVar.a((Object) a3);
                eVar.a(a5, a6, -this.ua, 6);
                if (z) {
                    eVar.b(a5, eVar.a((Object) a2), 0, 5);
                    eVar.b(a6, a5, 0, 5);
                }
            } else if (this.sa != -1.0f) {
                eVar.a(e.a(eVar, eVar.a((Object) this.va), eVar.a((Object) a2), eVar.a((Object) a3), this.sa, this.xa));
            }
        }
    }
}
