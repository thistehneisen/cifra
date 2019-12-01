package b.e.b.a;

import b.e.b.a.h.a;
import b.e.b.e;
import b.e.b.f;
import b.e.b.i;
import java.util.ArrayList;

/* compiled from: Barrier */
public class b extends n {
    private int ua = 0;
    private ArrayList<q> va = new ArrayList<>(4);
    private boolean wa = true;

    public void G() {
        super.G();
        this.va.clear();
    }

    public void H() {
        q qVar;
        float f2;
        q qVar2;
        int i2 = this.ua;
        float f3 = Float.MAX_VALUE;
        if (i2 != 0) {
            if (i2 == 1) {
                qVar = this.x.d();
            } else if (i2 == 2) {
                qVar = this.w.d();
            } else if (i2 == 3) {
                qVar = this.y.d();
            } else {
                return;
            }
            f3 = 0.0f;
        } else {
            qVar = this.v.d();
        }
        int size = this.va.size();
        q qVar3 = null;
        int i3 = 0;
        while (i3 < size) {
            q qVar4 = (q) this.va.get(i3);
            if (qVar4.f2412b == 1) {
                int i4 = this.ua;
                if (i4 == 0 || i4 == 2) {
                    f2 = qVar4.f2405h;
                    if (f2 < f3) {
                        qVar2 = qVar4.f2404g;
                    } else {
                        i3++;
                    }
                } else {
                    f2 = qVar4.f2405h;
                    if (f2 > f3) {
                        qVar2 = qVar4.f2404g;
                    } else {
                        i3++;
                    }
                }
                qVar3 = qVar2;
                f3 = f2;
                i3++;
            } else {
                return;
            }
        }
        if (e.e() != null) {
            f e2 = e.e();
            e2.y++;
        }
        qVar.f2404g = qVar3;
        qVar.f2405h = f3;
        qVar.a();
        int i5 = this.ua;
        if (i5 == 0) {
            this.x.d().a(qVar3, f3);
        } else if (i5 == 1) {
            this.v.d().a(qVar3, f3);
        } else if (i5 == 2) {
            this.y.d().a(qVar3, f3);
        } else if (i5 == 3) {
            this.w.d().a(qVar3, f3);
        }
    }

    public boolean K() {
        return this.wa;
    }

    public void a(int i2) {
        q qVar;
        s sVar;
        h hVar = this.G;
        if (hVar != null && ((i) hVar).p(2)) {
            int i3 = this.ua;
            if (i3 == 0) {
                qVar = this.v.d();
            } else if (i3 == 1) {
                qVar = this.x.d();
            } else if (i3 == 2) {
                qVar = this.w.d();
            } else if (i3 == 3) {
                qVar = this.y.d();
            } else {
                return;
            }
            qVar.b(5);
            int i4 = this.ua;
            if (i4 == 0 || i4 == 1) {
                this.w.d().a((q) null, 0.0f);
                this.y.d().a((q) null, 0.0f);
            } else {
                this.v.d().a((q) null, 0.0f);
                this.x.d().a((q) null, 0.0f);
            }
            this.va.clear();
            for (int i5 = 0; i5 < this.ta; i5++) {
                h hVar2 = this.sa[i5];
                if (this.wa || hVar2.b()) {
                    int i6 = this.ua;
                    if (i6 == 0) {
                        sVar = hVar2.v.d();
                    } else if (i6 == 1) {
                        sVar = hVar2.x.d();
                    } else if (i6 == 2) {
                        sVar = hVar2.w.d();
                    } else if (i6 != 3) {
                        sVar = null;
                    } else {
                        sVar = hVar2.y.d();
                    }
                    if (sVar != null) {
                        this.va.add(sVar);
                        sVar.a(qVar);
                    }
                }
            }
        }
    }

    public boolean b() {
        return true;
    }

    public void c(boolean z) {
        this.wa = z;
    }

    public void p(int i2) {
        this.ua = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        r1 = true;
     */
    public void a(e eVar) {
        f[] fVarArr;
        boolean z;
        f[] fVarArr2 = this.D;
        fVarArr2[0] = this.v;
        fVarArr2[2] = this.w;
        fVarArr2[1] = this.x;
        fVarArr2[3] = this.y;
        int i2 = 0;
        while (true) {
            fVarArr = this.D;
            if (i2 >= fVarArr.length) {
                break;
            }
            fVarArr[i2].f2353j = eVar.a((Object) fVarArr[i2]);
            i2++;
        }
        int i3 = this.ua;
        if (i3 >= 0 && i3 < 4) {
            f fVar = fVarArr[i3];
            int i4 = 0;
            while (true) {
                if (i4 >= this.ta) {
                    z = false;
                    break;
                }
                h hVar = this.sa[i4];
                if (this.wa || hVar.b()) {
                    int i5 = this.ua;
                    if ((i5 != 0 && i5 != 1) || hVar.l() != a.MATCH_CONSTRAINT) {
                        int i6 = this.ua;
                        if ((i6 == 2 || i6 == 3) && hVar.s() == a.MATCH_CONSTRAINT) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i4++;
            }
            int i7 = this.ua;
            if (i7 == 0 || i7 == 1 ? m().l() == a.WRAP_CONTENT : m().s() == a.WRAP_CONTENT) {
                z = false;
            }
            for (int i8 = 0; i8 < this.ta; i8++) {
                h hVar2 = this.sa[i8];
                if (this.wa || hVar2.b()) {
                    i a2 = eVar.a((Object) hVar2.D[this.ua]);
                    f[] fVarArr3 = hVar2.D;
                    int i9 = this.ua;
                    fVarArr3[i9].f2353j = a2;
                    if (i9 == 0 || i9 == 2) {
                        eVar.b(fVar.f2353j, a2, z);
                    } else {
                        eVar.a(fVar.f2353j, a2, z);
                    }
                }
            }
            int i10 = this.ua;
            if (i10 == 0) {
                eVar.a(this.x.f2353j, this.v.f2353j, 0, 6);
                if (!z) {
                    eVar.a(this.v.f2353j, this.G.x.f2353j, 0, 5);
                }
            } else if (i10 == 1) {
                eVar.a(this.v.f2353j, this.x.f2353j, 0, 6);
                if (!z) {
                    eVar.a(this.v.f2353j, this.G.v.f2353j, 0, 5);
                }
            } else if (i10 == 2) {
                eVar.a(this.y.f2353j, this.w.f2353j, 0, 6);
                if (!z) {
                    eVar.a(this.w.f2353j, this.G.y.f2353j, 0, 5);
                }
            } else if (i10 == 3) {
                eVar.a(this.w.f2353j, this.y.f2353j, 0, 6);
                if (!z) {
                    eVar.a(this.w.f2353j, this.G.w.f2353j, 0, 5);
                }
            }
        }
    }
}
