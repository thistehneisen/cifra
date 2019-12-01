package b.e.b;

import b.e.b.a.f;
import b.e.b.a.f.c;
import b.e.b.a.h;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: LinearSystem */
public class e {

    /* renamed from: a reason: collision with root package name */
    private static int f2431a = 1000;

    /* renamed from: b reason: collision with root package name */
    public static f f2432b;

    /* renamed from: c reason: collision with root package name */
    int f2433c = 0;

    /* renamed from: d reason: collision with root package name */
    private HashMap<String, i> f2434d = null;

    /* renamed from: e reason: collision with root package name */
    private a f2435e;

    /* renamed from: f reason: collision with root package name */
    private int f2436f = 32;

    /* renamed from: g reason: collision with root package name */
    private int f2437g;

    /* renamed from: h reason: collision with root package name */
    b[] f2438h;

    /* renamed from: i reason: collision with root package name */
    public boolean f2439i;

    /* renamed from: j reason: collision with root package name */
    private boolean[] f2440j;

    /* renamed from: k reason: collision with root package name */
    int f2441k;

    /* renamed from: l reason: collision with root package name */
    int f2442l;
    private int m;
    final c n;
    private i[] o;
    private int p;
    private b[] q;
    private final a r;

    /* compiled from: LinearSystem */
    interface a {
        i a(e eVar, boolean[] zArr);

        void a(a aVar);

        void a(i iVar);

        void clear();

        i getKey();
    }

    public e() {
        int i2 = this.f2436f;
        this.f2437g = i2;
        this.f2438h = null;
        this.f2439i = false;
        this.f2440j = new boolean[i2];
        this.f2441k = 1;
        this.f2442l = 0;
        this.m = i2;
        this.o = new i[f2431a];
        this.p = 0;
        this.q = new b[i2];
        this.f2438h = new b[i2];
        j();
        this.n = new c();
        this.f2435e = new d(this.n);
        this.r = new b(this.n);
    }

    private final void d(b bVar) {
        if (this.f2442l > 0) {
            bVar.f2426d.a(bVar, this.f2438h);
            if (bVar.f2426d.f2320a == 0) {
                bVar.f2427e = true;
            }
        }
    }

    public static f e() {
        return f2432b;
    }

    private void h() {
        for (int i2 = 0; i2 < this.f2442l; i2++) {
            b bVar = this.f2438h[i2];
            bVar.f2423a.f2462f = bVar.f2424b;
        }
    }

    private void i() {
        this.f2436f *= 2;
        this.f2438h = (b[]) Arrays.copyOf(this.f2438h, this.f2436f);
        c cVar = this.n;
        cVar.f2430c = (i[]) Arrays.copyOf(cVar.f2430c, this.f2436f);
        int i2 = this.f2436f;
        this.f2440j = new boolean[i2];
        this.f2437g = i2;
        this.m = i2;
        f fVar = f2432b;
        if (fVar != null) {
            fVar.f2446d++;
            fVar.o = Math.max(fVar.o, (long) i2);
            f fVar2 = f2432b;
            fVar2.A = fVar2.o;
        }
    }

    private void j() {
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.f2438h;
            if (i2 < bVarArr.length) {
                b bVar = bVarArr[i2];
                if (bVar != null) {
                    this.n.f2428a.a(bVar);
                }
                this.f2438h[i2] = null;
                i2++;
            } else {
                return;
            }
        }
    }

    public i a(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f2441k + 1 >= this.f2437g) {
            i();
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            iVar = fVar.e();
            if (iVar == null) {
                fVar.a(this.n);
                iVar = fVar.e();
            }
            int i2 = iVar.f2459c;
            if (i2 == -1 || i2 > this.f2433c || this.n.f2430c[i2] == null) {
                if (iVar.f2459c != -1) {
                    iVar.b();
                }
                this.f2433c++;
                this.f2441k++;
                int i3 = this.f2433c;
                iVar.f2459c = i3;
                iVar.f2464h = b.e.b.i.a.UNRESTRICTED;
                this.n.f2430c[i3] = iVar;
            }
        }
        return iVar;
    }

    public b b() {
        b bVar = (b) this.n.f2428a.a();
        if (bVar == null) {
            bVar = new b(this.n);
        } else {
            bVar.d();
        }
        i.a();
        return bVar;
    }

    public i c() {
        f fVar = f2432b;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.f2441k + 1 >= this.f2437g) {
            i();
        }
        i a2 = a(b.e.b.i.a.SLACK, (String) null);
        this.f2433c++;
        this.f2441k++;
        int i2 = this.f2433c;
        a2.f2459c = i2;
        this.n.f2430c[i2] = a2;
        return a2;
    }

    public void f() throws Exception {
        f fVar = f2432b;
        if (fVar != null) {
            fVar.f2447e++;
        }
        if (this.f2439i) {
            f fVar2 = f2432b;
            if (fVar2 != null) {
                fVar2.q++;
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f2442l) {
                    z = true;
                    break;
                } else if (!this.f2438h[i2].f2427e) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                a(this.f2435e);
                return;
            }
            f fVar3 = f2432b;
            if (fVar3 != null) {
                fVar3.p++;
            }
            h();
            return;
        }
        a(this.f2435e);
    }

    public void g() {
        c cVar;
        int i2 = 0;
        while (true) {
            cVar = this.n;
            i[] iVarArr = cVar.f2430c;
            if (i2 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i2];
            if (iVar != null) {
                iVar.b();
            }
            i2++;
        }
        cVar.f2429b.a(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.n.f2430c, null);
        HashMap<String, i> hashMap = this.f2434d;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f2433c = 0;
        this.f2435e.clear();
        this.f2441k = 1;
        for (int i3 = 0; i3 < this.f2442l; i3++) {
            this.f2438h[i3].f2425c = false;
        }
        j();
        this.f2442l = 0;
    }

    private void b(b bVar) {
        bVar.a(this, 0);
    }

    public c d() {
        return this.n;
    }

    public int b(Object obj) {
        i e2 = ((f) obj).e();
        if (e2 != null) {
            return (int) (e2.f2462f + 0.5f);
        }
        return 0;
    }

    private int b(a aVar) throws Exception {
        float f2;
        boolean z;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.f2442l) {
                z = false;
                break;
            }
            b[] bVarArr = this.f2438h;
            if (bVarArr[i2].f2423a.f2464h != b.e.b.i.a.UNRESTRICTED && bVarArr[i2].f2424b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            f fVar = f2432b;
            if (fVar != null) {
                fVar.f2453k++;
            }
            i3++;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            float f3 = Float.MAX_VALUE;
            int i7 = 0;
            while (i4 < this.f2442l) {
                b bVar = this.f2438h[i4];
                if (bVar.f2423a.f2464h != b.e.b.i.a.UNRESTRICTED && !bVar.f2427e && bVar.f2424b < f2) {
                    int i8 = 1;
                    while (i8 < this.f2441k) {
                        i iVar = this.n.f2430c[i8];
                        float b2 = bVar.f2426d.b(iVar);
                        if (b2 > f2) {
                            int i9 = i7;
                            float f4 = f3;
                            int i10 = i6;
                            int i11 = i5;
                            for (int i12 = 0; i12 < 7; i12++) {
                                float f5 = iVar.f2463g[i12] / b2;
                                if ((f5 < f4 && i12 == i9) || i12 > i9) {
                                    i10 = i8;
                                    i11 = i4;
                                    f4 = f5;
                                    i9 = i12;
                                }
                            }
                            i5 = i11;
                            i6 = i10;
                            f3 = f4;
                            i7 = i9;
                        }
                        i8++;
                        f2 = 0.0f;
                    }
                }
                i4++;
                f2 = 0.0f;
            }
            if (i5 != -1) {
                b bVar2 = this.f2438h[i5];
                bVar2.f2423a.f2460d = -1;
                f fVar2 = f2432b;
                if (fVar2 != null) {
                    fVar2.f2452j++;
                }
                bVar2.d(this.n.f2430c[i6]);
                i iVar2 = bVar2.f2423a;
                iVar2.f2460d = i5;
                iVar2.c(bVar2);
            } else {
                z2 = true;
            }
            if (i3 > this.f2441k / 2) {
                z2 = true;
            }
            f2 = 0.0f;
        }
        return i3;
    }

    private final void c(b bVar) {
        b[] bVarArr = this.f2438h;
        int i2 = this.f2442l;
        if (bVarArr[i2] != null) {
            this.n.f2428a.a(bVarArr[i2]);
        }
        b[] bVarArr2 = this.f2438h;
        int i3 = this.f2442l;
        bVarArr2[i3] = bVar;
        i iVar = bVar.f2423a;
        iVar.f2460d = i3;
        this.f2442l = i3 + 1;
        iVar.c(bVar);
    }

    public i a() {
        f fVar = f2432b;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.f2441k + 1 >= this.f2437g) {
            i();
        }
        i a2 = a(b.e.b.i.a.SLACK, (String) null);
        this.f2433c++;
        this.f2441k++;
        int i2 = this.f2433c;
        a2.f2459c = i2;
        this.n.f2430c[i2] = a2;
        return a2;
    }

    public void c(i iVar, i iVar2, int i2, int i3) {
        b b2 = b();
        i c2 = c();
        c2.f2461e = 0;
        b2.b(iVar, iVar2, c2, i2);
        if (i3 != 6) {
            a(b2, (int) (b2.f2426d.b(c2) * -1.0f), i3);
        }
        a(b2);
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar, int i2, int i3) {
        bVar.a(a(i3, (String) null), i2);
    }

    public i a(int i2, String str) {
        f fVar = f2432b;
        if (fVar != null) {
            fVar.f2454l++;
        }
        if (this.f2441k + 1 >= this.f2437g) {
            i();
        }
        i a2 = a(b.e.b.i.a.ERROR, str);
        this.f2433c++;
        this.f2441k++;
        int i3 = this.f2433c;
        a2.f2459c = i3;
        a2.f2461e = i2;
        this.n.f2430c[i3] = a2;
        this.f2435e.a(a2);
        return a2;
    }

    public void b(i iVar, i iVar2, int i2, int i3) {
        b b2 = b();
        i c2 = c();
        c2.f2461e = 0;
        b2.a(iVar, iVar2, c2, i2);
        if (i3 != 6) {
            a(b2, (int) (b2.f2426d.b(c2) * -1.0f), i3);
        }
        a(b2);
    }

    private i a(b.e.b.i.a aVar, String str) {
        i iVar = (i) this.n.f2429b.a();
        if (iVar == null) {
            iVar = new i(aVar, str);
            iVar.a(aVar, str);
        } else {
            iVar.b();
            iVar.a(aVar, str);
        }
        int i2 = this.p;
        int i3 = f2431a;
        if (i2 >= i3) {
            f2431a = i3 * 2;
            this.o = (i[]) Arrays.copyOf(this.o, f2431a);
        }
        i[] iVarArr = this.o;
        int i4 = this.p;
        this.p = i4 + 1;
        iVarArr[i4] = iVar;
        return iVar;
    }

    public void b(i iVar, i iVar2, boolean z) {
        b b2 = b();
        i c2 = c();
        c2.f2461e = 0;
        b2.b(iVar, iVar2, c2, 0);
        if (z) {
            a(b2, (int) (b2.f2426d.b(c2) * -1.0f), 1);
        }
        a(b2);
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar) throws Exception {
        f fVar = f2432b;
        if (fVar != null) {
            fVar.s++;
            fVar.t = Math.max(fVar.t, (long) this.f2441k);
            f fVar2 = f2432b;
            fVar2.u = Math.max(fVar2.u, (long) this.f2442l);
        }
        d((b) aVar);
        b(aVar);
        a(aVar, false);
        h();
    }

    public void a(b bVar) {
        if (bVar != null) {
            f fVar = f2432b;
            if (fVar != null) {
                fVar.f2448f++;
                if (bVar.f2427e) {
                    fVar.f2449g++;
                }
            }
            if (this.f2442l + 1 >= this.m || this.f2441k + 1 >= this.f2437g) {
                i();
            }
            boolean z = false;
            if (!bVar.f2427e) {
                d(bVar);
                if (!bVar.c()) {
                    bVar.a();
                    if (bVar.a(this)) {
                        i a2 = a();
                        bVar.f2423a = a2;
                        c(bVar);
                        this.r.a((a) bVar);
                        a(this.r, true);
                        if (a2.f2460d == -1) {
                            if (bVar.f2423a == a2) {
                                i c2 = bVar.c(a2);
                                if (c2 != null) {
                                    f fVar2 = f2432b;
                                    if (fVar2 != null) {
                                        fVar2.f2452j++;
                                    }
                                    bVar.d(c2);
                                }
                            }
                            if (!bVar.f2427e) {
                                bVar.f2423a.c(bVar);
                            }
                            this.f2442l--;
                        }
                        z = true;
                    }
                    if (!bVar.b()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!z) {
                c(bVar);
            }
        }
    }

    private final int a(a aVar, boolean z) {
        f fVar = f2432b;
        if (fVar != null) {
            fVar.f2450h++;
        }
        for (int i2 = 0; i2 < this.f2441k; i2++) {
            this.f2440j[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            f fVar2 = f2432b;
            if (fVar2 != null) {
                fVar2.f2451i++;
            }
            i3++;
            if (i3 >= this.f2441k * 2) {
                return i3;
            }
            if (aVar.getKey() != null) {
                this.f2440j[aVar.getKey().f2459c] = true;
            }
            i a2 = aVar.a(this, this.f2440j);
            if (a2 != null) {
                boolean[] zArr = this.f2440j;
                int i4 = a2.f2459c;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (a2 != null) {
                int i5 = -1;
                float f2 = Float.MAX_VALUE;
                for (int i6 = 0; i6 < this.f2442l; i6++) {
                    b bVar = this.f2438h[i6];
                    if (bVar.f2423a.f2464h != b.e.b.i.a.UNRESTRICTED && !bVar.f2427e && bVar.b(a2)) {
                        float b2 = bVar.f2426d.b(a2);
                        if (b2 < 0.0f) {
                            float f3 = (-bVar.f2424b) / b2;
                            if (f3 < f2) {
                                i5 = i6;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    b bVar2 = this.f2438h[i5];
                    bVar2.f2423a.f2460d = -1;
                    f fVar3 = f2432b;
                    if (fVar3 != null) {
                        fVar3.f2452j++;
                    }
                    bVar2.d(a2);
                    i iVar = bVar2.f2423a;
                    iVar.f2460d = i5;
                    iVar.c(bVar2);
                }
            }
            z2 = true;
        }
        return i3;
    }

    public void a(i iVar, i iVar2, boolean z) {
        b b2 = b();
        i c2 = c();
        c2.f2461e = 0;
        b2.a(iVar, iVar2, c2, 0);
        if (z) {
            a(b2, (int) (b2.f2426d.b(c2) * -1.0f), 1);
        }
        a(b2);
    }

    public void a(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3, int i4) {
        int i5 = i4;
        b b2 = b();
        b2.a(iVar, iVar2, i2, f2, iVar3, iVar4, i3);
        if (i5 != 6) {
            b2.a(this, i5);
        }
        a(b2);
    }

    public void a(i iVar, i iVar2, i iVar3, i iVar4, float f2, int i2) {
        b b2 = b();
        b2.a(iVar, iVar2, iVar3, iVar4, f2);
        if (i2 != 6) {
            b2.a(this, i2);
        }
        a(b2);
    }

    public b a(i iVar, i iVar2, int i2, int i3) {
        b b2 = b();
        b2.a(iVar, iVar2, i2);
        if (i3 != 6) {
            b2.a(this, i3);
        }
        a(b2);
        return b2;
    }

    public void a(i iVar, int i2) {
        int i3 = iVar.f2460d;
        if (i3 != -1) {
            b bVar = this.f2438h[i3];
            if (bVar.f2427e) {
                bVar.f2424b = (float) i2;
            } else if (bVar.f2426d.f2320a == 0) {
                bVar.f2427e = true;
                bVar.f2424b = (float) i2;
            } else {
                b b2 = b();
                b2.c(iVar, i2);
                a(b2);
            }
        } else {
            b b3 = b();
            b3.b(iVar, i2);
            a(b3);
        }
    }

    public static b a(e eVar, i iVar, i iVar2, i iVar3, float f2, boolean z) {
        b b2 = eVar.b();
        if (z) {
            eVar.b(b2);
        }
        b2.a(iVar, iVar2, iVar3, f2);
        return b2;
    }

    public void a(h hVar, h hVar2, float f2, int i2) {
        h hVar3 = hVar;
        h hVar4 = hVar2;
        i a2 = a((Object) hVar3.a(c.LEFT));
        i a3 = a((Object) hVar3.a(c.TOP));
        i a4 = a((Object) hVar3.a(c.RIGHT));
        i a5 = a((Object) hVar3.a(c.BOTTOM));
        i a6 = a((Object) hVar4.a(c.LEFT));
        i a7 = a((Object) hVar4.a(c.TOP));
        i a8 = a((Object) hVar4.a(c.RIGHT));
        i a9 = a((Object) hVar4.a(c.BOTTOM));
        b b2 = b();
        double d2 = (double) f2;
        i iVar = a4;
        double d3 = (double) i2;
        i iVar2 = a8;
        b2.b(a3, a5, a7, a9, (float) (Math.sin(d2) * d3));
        a(b2);
        b b3 = b();
        b3.b(a2, iVar, a6, iVar2, (float) (Math.cos(d2) * d3));
        a(b3);
    }
}
