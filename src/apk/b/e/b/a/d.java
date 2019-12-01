package b.e.b.a;

import b.e.b.a.h.a;
import java.util.ArrayList;

/* compiled from: ChainHead */
public class d {

    /* renamed from: a reason: collision with root package name */
    protected h f2331a;

    /* renamed from: b reason: collision with root package name */
    protected h f2332b;

    /* renamed from: c reason: collision with root package name */
    protected h f2333c;

    /* renamed from: d reason: collision with root package name */
    protected h f2334d;

    /* renamed from: e reason: collision with root package name */
    protected h f2335e;

    /* renamed from: f reason: collision with root package name */
    protected h f2336f;

    /* renamed from: g reason: collision with root package name */
    protected h f2337g;

    /* renamed from: h reason: collision with root package name */
    protected ArrayList<h> f2338h;

    /* renamed from: i reason: collision with root package name */
    protected int f2339i;

    /* renamed from: j reason: collision with root package name */
    protected int f2340j;

    /* renamed from: k reason: collision with root package name */
    protected float f2341k = 0.0f;

    /* renamed from: l reason: collision with root package name */
    private int f2342l;
    private boolean m = false;
    protected boolean n;
    protected boolean o;
    protected boolean p;
    private boolean q;

    public d(h hVar, int i2, boolean z) {
        this.f2331a = hVar;
        this.f2342l = i2;
        this.m = z;
    }

    private static boolean a(h hVar, int i2) {
        if (hVar.t() != 8 && hVar.F[i2] == a.MATCH_CONSTRAINT) {
            int[] iArr = hVar.f2380h;
            if (iArr[i2] == 0 || iArr[i2] == 3) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        int i2 = this.f2342l * 2;
        boolean z = false;
        h hVar = this.f2331a;
        boolean z2 = false;
        while (!z2) {
            this.f2339i++;
            h[] hVarArr = hVar.pa;
            int i3 = this.f2342l;
            h hVar2 = null;
            hVarArr[i3] = null;
            hVar.oa[i3] = null;
            if (hVar.t() != 8) {
                if (this.f2332b == null) {
                    this.f2332b = hVar;
                }
                h hVar3 = this.f2334d;
                if (hVar3 != null) {
                    hVar3.pa[this.f2342l] = hVar;
                }
                this.f2334d = hVar;
                a[] aVarArr = hVar.F;
                int i4 = this.f2342l;
                if (aVarArr[i4] == a.MATCH_CONSTRAINT) {
                    int[] iArr = hVar.f2380h;
                    if (iArr[i4] == 0 || iArr[i4] == 3 || iArr[i4] == 2) {
                        this.f2340j++;
                        float[] fArr = hVar.na;
                        int i5 = this.f2342l;
                        float f2 = fArr[i5];
                        if (f2 > 0.0f) {
                            this.f2341k += fArr[i5];
                        }
                        if (a(hVar, this.f2342l)) {
                            if (f2 < 0.0f) {
                                this.n = true;
                            } else {
                                this.o = true;
                            }
                            if (this.f2338h == null) {
                                this.f2338h = new ArrayList<>();
                            }
                            this.f2338h.add(hVar);
                        }
                        if (this.f2336f == null) {
                            this.f2336f = hVar;
                        }
                        h hVar4 = this.f2337g;
                        if (hVar4 != null) {
                            hVar4.oa[this.f2342l] = hVar;
                        }
                        this.f2337g = hVar;
                    }
                }
            }
            f fVar = hVar.D[i2 + 1].f2347d;
            if (fVar != null) {
                h hVar5 = fVar.f2345b;
                f[] fVarArr = hVar5.D;
                if (fVarArr[i2].f2347d != null && fVarArr[i2].f2347d.f2345b == hVar) {
                    hVar2 = hVar5;
                }
            }
            if (hVar2 != null) {
                hVar = hVar2;
            } else {
                z2 = true;
            }
        }
        this.f2333c = hVar;
        if (this.f2342l != 0 || !this.m) {
            this.f2335e = this.f2331a;
        } else {
            this.f2335e = this.f2333c;
        }
        if (this.o && this.n) {
            z = true;
        }
        this.p = z;
    }

    public void a() {
        if (!this.q) {
            b();
        }
        this.q = true;
    }
}
