package b.e.b.a;

import b.e.b.a.f.c;
import b.e.b.e;
import b.e.b.f;
import b.e.b.i;

/* compiled from: ResolutionAnchor */
public class q extends s {

    /* renamed from: c reason: collision with root package name */
    f f2400c;

    /* renamed from: d reason: collision with root package name */
    float f2401d;

    /* renamed from: e reason: collision with root package name */
    q f2402e;

    /* renamed from: f reason: collision with root package name */
    float f2403f;

    /* renamed from: g reason: collision with root package name */
    q f2404g;

    /* renamed from: h reason: collision with root package name */
    float f2405h;

    /* renamed from: i reason: collision with root package name */
    int f2406i = 0;

    /* renamed from: j reason: collision with root package name */
    private q f2407j;

    /* renamed from: k reason: collision with root package name */
    private float f2408k;

    /* renamed from: l reason: collision with root package name */
    private r f2409l = null;
    private int m = 1;
    private r n = null;
    private int o = 1;

    public q(f fVar) {
        this.f2400c = fVar;
    }

    /* access modifiers changed from: 0000 */
    public String a(int i2) {
        return i2 == 1 ? "DIRECT" : i2 == 2 ? "CENTER" : i2 == 3 ? "MATCH" : i2 == 4 ? "CHAIN" : i2 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void a(q qVar, float f2) {
        if (this.f2412b == 0 || !(this.f2404g == qVar || this.f2405h == f2)) {
            this.f2404g = qVar;
            this.f2405h = f2;
            if (this.f2412b == 1) {
                b();
            }
            a();
        }
    }

    public void b(int i2) {
        this.f2406i = i2;
    }

    public void d() {
        super.d();
        this.f2402e = null;
        this.f2403f = 0.0f;
        this.f2409l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.f2404g = null;
        this.f2405h = 0.0f;
        this.f2401d = 0.0f;
        this.f2407j = null;
        this.f2408k = 0.0f;
        this.f2406i = 0;
    }

    public void e() {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = true;
        if (this.f2412b != 1 && this.f2406i != 4) {
            r rVar = this.f2409l;
            if (rVar != null) {
                if (rVar.f2412b == 1) {
                    this.f2403f = ((float) this.m) * rVar.f2410c;
                } else {
                    return;
                }
            }
            r rVar2 = this.n;
            if (rVar2 != null) {
                if (rVar2.f2412b == 1) {
                    this.f2408k = ((float) this.o) * rVar2.f2410c;
                } else {
                    return;
                }
            }
            if (this.f2406i == 1) {
                q qVar = this.f2402e;
                if (qVar == null || qVar.f2412b == 1) {
                    q qVar2 = this.f2402e;
                    if (qVar2 == null) {
                        this.f2404g = this;
                        this.f2405h = this.f2403f;
                    } else {
                        this.f2404g = qVar2.f2404g;
                        this.f2405h = qVar2.f2405h + this.f2403f;
                    }
                    a();
                }
            }
            if (this.f2406i == 2) {
                q qVar3 = this.f2402e;
                if (qVar3 != null && qVar3.f2412b == 1) {
                    q qVar4 = this.f2407j;
                    if (qVar4 != null) {
                        q qVar5 = qVar4.f2402e;
                        if (qVar5 != null && qVar5.f2412b == 1) {
                            if (e.e() != null) {
                                f e2 = e.e();
                                e2.v++;
                            }
                            this.f2404g = this.f2402e.f2404g;
                            q qVar6 = this.f2407j;
                            qVar6.f2404g = qVar6.f2402e.f2404g;
                            c cVar = this.f2400c.f2346c;
                            int i2 = 0;
                            if (!(cVar == c.RIGHT || cVar == c.BOTTOM)) {
                                z = false;
                            }
                            if (z) {
                                f3 = this.f2402e.f2405h;
                                f2 = this.f2407j.f2402e.f2405h;
                            } else {
                                f3 = this.f2407j.f2402e.f2405h;
                                f2 = this.f2402e.f2405h;
                            }
                            float f6 = f3 - f2;
                            f fVar = this.f2400c;
                            c cVar2 = fVar.f2346c;
                            if (cVar2 == c.LEFT || cVar2 == c.RIGHT) {
                                f5 = f6 - ((float) this.f2400c.f2345b.u());
                                f4 = this.f2400c.f2345b.aa;
                            } else {
                                f5 = f6 - ((float) fVar.f2345b.j());
                                f4 = this.f2400c.f2345b.ba;
                            }
                            int b2 = this.f2400c.b();
                            int b3 = this.f2407j.f2400c.b();
                            if (this.f2400c.g() == this.f2407j.f2400c.g()) {
                                f4 = 0.5f;
                                b3 = 0;
                            } else {
                                i2 = b2;
                            }
                            float f7 = (float) i2;
                            float f8 = (float) b3;
                            float f9 = (f5 - f7) - f8;
                            if (z) {
                                q qVar7 = this.f2407j;
                                qVar7.f2405h = qVar7.f2402e.f2405h + f8 + (f9 * f4);
                                this.f2405h = (this.f2402e.f2405h - f7) - (f9 * (1.0f - f4));
                            } else {
                                this.f2405h = this.f2402e.f2405h + f7 + (f9 * f4);
                                q qVar8 = this.f2407j;
                                qVar8.f2405h = (qVar8.f2402e.f2405h - f8) - (f9 * (1.0f - f4));
                            }
                            a();
                            this.f2407j.a();
                        }
                    }
                }
            }
            if (this.f2406i == 3) {
                q qVar9 = this.f2402e;
                if (qVar9 != null && qVar9.f2412b == 1) {
                    q qVar10 = this.f2407j;
                    if (qVar10 != null) {
                        q qVar11 = qVar10.f2402e;
                        if (qVar11 != null && qVar11.f2412b == 1) {
                            if (e.e() != null) {
                                f e3 = e.e();
                                e3.w++;
                            }
                            q qVar12 = this.f2402e;
                            this.f2404g = qVar12.f2404g;
                            q qVar13 = this.f2407j;
                            q qVar14 = qVar13.f2402e;
                            qVar13.f2404g = qVar14.f2404g;
                            this.f2405h = qVar12.f2405h + this.f2403f;
                            qVar13.f2405h = qVar14.f2405h + qVar13.f2403f;
                            a();
                            this.f2407j.a();
                        }
                    }
                }
            }
            if (this.f2406i == 5) {
                this.f2400c.f2345b.H();
            }
        }
    }

    public float f() {
        return this.f2405h;
    }

    public void g() {
        f g2 = this.f2400c.g();
        if (g2 != null) {
            if (g2.g() == this.f2400c) {
                this.f2406i = 4;
                g2.d().f2406i = 4;
            }
            int b2 = this.f2400c.b();
            c cVar = this.f2400c.f2346c;
            if (cVar == c.RIGHT || cVar == c.BOTTOM) {
                b2 = -b2;
            }
            a(g2.d(), b2);
        }
    }

    public String toString() {
        if (this.f2412b == 1) {
            String str = ", RESOLVED: ";
            String str2 = "[";
            if (this.f2404g == this) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.f2400c);
                sb.append(str);
                sb.append(this.f2405h);
                sb.append("]  type: ");
                sb.append(a(this.f2406i));
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(this.f2400c);
            sb2.append(str);
            sb2.append(this.f2404g);
            sb2.append(":");
            sb2.append(this.f2405h);
            sb2.append("] type: ");
            sb2.append(a(this.f2406i));
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("{ ");
        sb3.append(this.f2400c);
        sb3.append(" UNRESOLVED} type: ");
        sb3.append(a(this.f2406i));
        return sb3.toString();
    }

    public void b(q qVar, float f2) {
        this.f2407j = qVar;
        this.f2408k = f2;
    }

    public void b(q qVar, int i2, r rVar) {
        this.f2407j = qVar;
        this.n = rVar;
        this.o = i2;
    }

    public void a(int i2, q qVar, int i3) {
        this.f2406i = i2;
        this.f2402e = qVar;
        this.f2403f = (float) i3;
        this.f2402e.a(this);
    }

    public void a(q qVar, int i2) {
        this.f2402e = qVar;
        this.f2403f = (float) i2;
        this.f2402e.a(this);
    }

    public void a(q qVar, int i2, r rVar) {
        this.f2402e = qVar;
        this.f2402e.a(this);
        this.f2409l = rVar;
        this.m = i2;
        this.f2409l.a(this);
    }

    /* access modifiers changed from: 0000 */
    public void a(e eVar) {
        i e2 = this.f2400c.e();
        q qVar = this.f2404g;
        if (qVar == null) {
            eVar.a(e2, (int) this.f2405h);
        } else {
            eVar.a(e2, eVar.a((Object) qVar.f2400c), (int) this.f2405h, 6);
        }
    }
}
