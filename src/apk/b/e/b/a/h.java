package b.e.b.a;

import b.e.b.a.f.b;
import b.e.b.a.f.c;
import b.e.b.e;
import b.e.b.f;
import b.e.b.i;
import java.util.ArrayList;

/* compiled from: ConstraintWidget */
public class h {

    /* renamed from: a reason: collision with root package name */
    public static float f2373a = 0.5f;
    f A = new f(this, c.CENTER_X);
    f B = new f(this, c.CENTER_Y);
    f C = new f(this, c.CENTER);
    protected f[] D = {this.v, this.x, this.w, this.y, this.z, this.C};
    protected ArrayList<f> E = new ArrayList<>();
    protected a[] F;
    h G;
    int H;
    int I;
    protected float J;
    protected int K;
    protected int L;
    protected int M;
    int N;
    int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    protected int T;
    protected int U;
    int V;
    protected int W;
    protected int X;
    private int Y;
    private int Z;
    float aa;

    /* renamed from: b reason: collision with root package name */
    public int f2374b = -1;
    float ba;

    /* renamed from: c reason: collision with root package name */
    public int f2375c = -1;
    private Object ca;

    /* renamed from: d reason: collision with root package name */
    r f2376d;
    private int da;

    /* renamed from: e reason: collision with root package name */
    r f2377e;
    private int ea;

    /* renamed from: f reason: collision with root package name */
    int f2378f = 0;
    private String fa;

    /* renamed from: g reason: collision with root package name */
    int f2379g = 0;
    private String ga;

    /* renamed from: h reason: collision with root package name */
    int[] f2380h = new int[2];
    boolean ha;

    /* renamed from: i reason: collision with root package name */
    int f2381i = 0;
    boolean ia;

    /* renamed from: j reason: collision with root package name */
    int f2382j = 0;
    int ja;

    /* renamed from: k reason: collision with root package name */
    float f2383k = 1.0f;
    int ka;

    /* renamed from: l reason: collision with root package name */
    int f2384l = 0;
    boolean la;
    int m = 0;
    boolean ma;
    float n = 1.0f;
    float[] na;
    boolean o;
    protected h[] oa;
    boolean p;
    protected h[] pa;
    int q = -1;
    h qa;
    float r = 1.0f;
    h ra;
    j s = null;
    private int[] t = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float u = 0.0f;
    f v = new f(this, c.LEFT);
    f w = new f(this, c.TOP);
    f x = new f(this, c.RIGHT);
    f y = new f(this, c.BOTTOM);
    f z = new f(this, c.BASELINE);

    /* compiled from: ConstraintWidget */
    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public h() {
        a aVar = a.FIXED;
        this.F = new a[]{aVar, aVar};
        this.G = null;
        this.H = 0;
        this.I = 0;
        this.J = 0.0f;
        this.K = -1;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        float f2 = f2373a;
        this.aa = f2;
        this.ba = f2;
        this.da = 0;
        this.ea = 0;
        this.fa = null;
        this.ga = null;
        this.ja = 0;
        this.ka = 0;
        this.na = new float[]{-1.0f, -1.0f};
        this.oa = new h[]{null, null};
        this.pa = new h[]{null, null};
        this.qa = null;
        this.ra = null;
        K();
    }

    private void K() {
        this.E.add(this.v);
        this.E.add(this.w);
        this.E.add(this.x);
        this.E.add(this.y);
        this.E.add(this.A);
        this.E.add(this.B);
        this.E.add(this.C);
        this.E.add(this.z);
    }

    public boolean A() {
        f fVar = this.v;
        f fVar2 = fVar.f2347d;
        if (fVar2 == null || fVar2.f2347d != fVar) {
            f fVar3 = this.x;
            f fVar4 = fVar3.f2347d;
            if (fVar4 == null || fVar4.f2347d != fVar3) {
                return false;
            }
        }
        return true;
    }

    public boolean B() {
        f fVar = this.w;
        f fVar2 = fVar.f2347d;
        if (fVar2 == null || fVar2.f2347d != fVar) {
            f fVar3 = this.y;
            f fVar4 = fVar3.f2347d;
            if (fVar4 == null || fVar4.f2347d != fVar3) {
                return false;
            }
        }
        return true;
    }

    public boolean C() {
        return this.f2379g == 0 && this.J == 0.0f && this.f2384l == 0 && this.m == 0 && this.F[1] == a.MATCH_CONSTRAINT;
    }

    public boolean D() {
        return this.f2378f == 0 && this.J == 0.0f && this.f2381i == 0 && this.f2382j == 0 && this.F[0] == a.MATCH_CONSTRAINT;
    }

    public void E() {
        this.v.j();
        this.w.j();
        this.x.j();
        this.y.j();
        this.z.j();
        this.A.j();
        this.B.j();
        this.C.j();
        this.G = null;
        this.u = 0.0f;
        this.H = 0;
        this.I = 0;
        this.J = 0.0f;
        this.K = -1;
        this.L = 0;
        this.M = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        float f2 = f2373a;
        this.aa = f2;
        this.ba = f2;
        a[] aVarArr = this.F;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.ca = null;
        this.da = 0;
        this.ea = 0;
        this.ga = null;
        this.ha = false;
        this.ia = false;
        this.ja = 0;
        this.ka = 0;
        this.la = false;
        this.ma = false;
        float[] fArr = this.na;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f2374b = -1;
        this.f2375c = -1;
        int[] iArr = this.t;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f2378f = 0;
        this.f2379g = 0;
        this.f2383k = 1.0f;
        this.n = 1.0f;
        this.f2382j = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.f2381i = 0;
        this.f2384l = 0;
        this.q = -1;
        this.r = 1.0f;
        r rVar = this.f2376d;
        if (rVar != null) {
            rVar.d();
        }
        r rVar2 = this.f2377e;
        if (rVar2 != null) {
            rVar2.d();
        }
        this.s = null;
    }

    public void F() {
        h m2 = m();
        if (m2 == null || !(m2 instanceof i) || !((i) m()).O()) {
            int size = this.E.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((f) this.E.get(i2)).j();
            }
        }
    }

    public void G() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.D[i2].d().d();
        }
    }

    public void H() {
    }

    public void I() {
        int i2 = this.L;
        int i3 = this.M;
        int i4 = this.H + i2;
        int i5 = this.I + i3;
        this.P = i2;
        this.Q = i3;
        this.R = i4 - i2;
        this.S = i5 - i3;
    }

    public void J() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.D[i2].d().g();
        }
    }

    public void a(int i2) {
        o.a(i2, this);
    }

    public void b(h hVar) {
        this.G = hVar;
    }

    public ArrayList<f> c() {
        return this.E;
    }

    public int d() {
        return this.V;
    }

    public void e(int i2) {
        this.t[1] = i2;
    }

    public void f(int i2) {
        this.t[0] = i2;
    }

    public String g() {
        return this.fa;
    }

    public int h() {
        return this.P + this.T;
    }

    public int i() {
        return this.Q + this.U;
    }

    public void j(int i2) {
        this.ea = i2;
    }

    public float k() {
        return this.aa;
    }

    public void l(int i2) {
        this.Z = i2;
    }

    public h m() {
        return this.G;
    }

    public r n() {
        if (this.f2377e == null) {
            this.f2377e = new r();
        }
        return this.f2377e;
    }

    public r o() {
        if (this.f2376d == null) {
            this.f2376d = new r();
        }
        return this.f2376d;
    }

    public int p() {
        return x() + this.H;
    }

    /* access modifiers changed from: protected */
    public int q() {
        return this.L + this.T;
    }

    /* access modifiers changed from: protected */
    public int r() {
        return this.M + this.U;
    }

    public a s() {
        return this.F[1];
    }

    public int t() {
        return this.ea;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = " ";
        String str3 = "";
        if (this.ga != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("type: ");
            sb2.append(this.ga);
            sb2.append(str2);
            str = sb2.toString();
        } else {
            str = str3;
        }
        sb.append(str);
        if (this.fa != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("id: ");
            sb3.append(this.fa);
            sb3.append(str2);
            str3 = sb3.toString();
        }
        sb.append(str3);
        sb.append("(");
        sb.append(this.L);
        sb.append(", ");
        sb.append(this.M);
        sb.append(") - (");
        sb.append(this.H);
        String str4 = " x ";
        sb.append(str4);
        sb.append(this.I);
        sb.append(") wrap: (");
        sb.append(this.Y);
        sb.append(str4);
        sb.append(this.Z);
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        if (this.ea == 8) {
            return 0;
        }
        return this.H;
    }

    public int v() {
        return this.Z;
    }

    public int w() {
        return this.Y;
    }

    public int x() {
        return this.L;
    }

    public int y() {
        return this.M;
    }

    public boolean z() {
        return this.V > 0;
    }

    private boolean p(int i2) {
        int i3 = i2 * 2;
        f[] fVarArr = this.D;
        if (!(fVarArr[i3].f2347d == null || fVarArr[i3].f2347d.f2347d == fVarArr[i3])) {
            int i4 = i3 + 1;
            if (fVarArr[i4].f2347d != null && fVarArr[i4].f2347d.f2347d == fVarArr[i4]) {
                return true;
            }
        }
        return false;
    }

    public void a(b.e.b.c cVar) {
        this.v.a(cVar);
        this.w.a(cVar);
        this.x.a(cVar);
        this.y.a(cVar);
        this.z.a(cVar);
        this.C.a(cVar);
        this.A.a(cVar);
        this.B.a(cVar);
    }

    public void b(boolean z2) {
        this.o = z2;
    }

    public void c(int i2, int i3) {
        this.L = i2;
        this.M = i3;
    }

    public void d(int i2, int i3) {
        this.M = i2;
        this.I = i3 - i2;
        int i4 = this.I;
        int i5 = this.X;
        if (i4 < i5) {
            this.I = i5;
        }
    }

    public int e() {
        return y() + this.I;
    }

    public Object f() {
        return this.ca;
    }

    public void g(int i2) {
        if (i2 < 0) {
            this.X = 0;
        } else {
            this.X = i2;
        }
    }

    public void h(int i2) {
        if (i2 < 0) {
            this.W = 0;
        } else {
            this.W = i2;
        }
    }

    public void i(int i2) {
        this.ka = i2;
    }

    public int j() {
        if (this.ea == 8) {
            return 0;
        }
        return this.I;
    }

    public void k(int i2) {
        this.H = i2;
        int i3 = this.H;
        int i4 = this.W;
        if (i3 < i4) {
            this.H = i4;
        }
    }

    public a l() {
        return this.F[0];
    }

    public void m(int i2) {
        this.Y = i2;
    }

    public void b(e eVar) {
        eVar.a((Object) this.v);
        eVar.a((Object) this.w);
        eVar.a((Object) this.x);
        eVar.a((Object) this.y);
        if (this.V > 0) {
            eVar.a((Object) this.z);
        }
    }

    public void c(int i2) {
        this.I = i2;
        int i3 = this.I;
        int i4 = this.X;
        if (i3 < i4) {
            this.I = i4;
        }
    }

    public void n(int i2) {
        this.L = i2;
    }

    public void o(int i2) {
        this.M = i2;
    }

    public void d(float f2) {
        this.na[1] = f2;
    }

    public void c(float f2) {
        this.ba = f2;
    }

    public void d(int i2) {
        this.ja = i2;
    }

    public void c(e eVar) {
        int b2 = eVar.b((Object) this.v);
        int b3 = eVar.b((Object) this.w);
        int b4 = eVar.b((Object) this.x);
        int b5 = eVar.b((Object) this.y);
        int i2 = b5 - b3;
        if (b4 - b2 < 0 || i2 < 0 || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE || b5 == Integer.MIN_VALUE || b5 == Integer.MAX_VALUE) {
            b5 = 0;
            b2 = 0;
            b3 = 0;
            b4 = 0;
        }
        a(b2, b3, b4, b5);
    }

    public void b(int i2, int i3) {
        this.T = i2;
        this.U = i3;
    }

    public void a(boolean z2) {
        this.p = z2;
    }

    public void a(h hVar, float f2, int i2) {
        c cVar = c.CENTER;
        a(cVar, hVar, cVar, i2, 0);
        this.u = f2;
    }

    public void b(int i2, int i3, int i4, float f2) {
        this.f2379g = i2;
        this.f2384l = i3;
        this.m = i4;
        this.n = f2;
        if (f2 < 1.0f && this.f2379g == 0) {
            this.f2379g = 2;
        }
    }

    public void a(int i2, int i3, int i4, float f2) {
        this.f2378f = i2;
        this.f2381i = i3;
        this.f2382j = i4;
        this.f2383k = f2;
        if (f2 < 1.0f && this.f2378f == 0) {
            this.f2378f = 2;
        }
    }

    public void b(int i2) {
        this.V = i2;
    }

    public void b(float f2) {
        this.na[0] = f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    public void a(String str) {
        float f2;
        if (str == null || str.length() == 0) {
            this.J = 0.0f;
            return;
        }
        int i2 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i3 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i2 = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i2 = 1;
            }
            i3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i3);
            if (substring2.length() > 0) {
                f2 = Float.parseFloat(substring2);
                if (f2 > 0.0f) {
                    this.J = f2;
                    this.K = i2;
                }
            }
        } else {
            String substring3 = str.substring(i3, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                try {
                    float parseFloat = Float.parseFloat(substring3);
                    float parseFloat2 = Float.parseFloat(substring4);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        f2 = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        if (f2 > 0.0f) {
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        f2 = 0.0f;
        if (f2 > 0.0f) {
        }
    }

    public boolean b() {
        return this.ea != 8;
    }

    public void b(a aVar) {
        this.F[1] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            c(this.Z);
        }
    }

    public void a(float f2) {
        this.aa = f2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r5 < r3) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r4 < r2) goto L_0x0020;
     */
    public void a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.L = i2;
        this.M = i3;
        if (this.ea == 8) {
            this.H = 0;
            this.I = 0;
            return;
        }
        if (this.F[0] == a.FIXED) {
            i6 = this.H;
        }
        i6 = i8;
        if (this.F[1] == a.FIXED) {
            i7 = this.I;
        }
        i7 = i9;
        this.H = i6;
        this.I = i7;
        int i10 = this.I;
        int i11 = this.X;
        if (i10 < i11) {
            this.I = i11;
        }
        int i12 = this.H;
        int i13 = this.W;
        if (i12 < i13) {
            this.H = i13;
        }
    }

    public void a(int i2, int i3, int i4) {
        if (i4 == 0) {
            a(i2, i3);
        } else if (i4 == 1) {
            d(i2, i3);
        }
    }

    public void a(int i2, int i3) {
        this.L = i2;
        this.H = i3 - i2;
        int i4 = this.H;
        int i5 = this.W;
        if (i4 < i5) {
            this.H = i5;
        }
    }

    public void a(Object obj) {
        this.ca = obj;
    }

    public void a(c cVar, h hVar, c cVar2, int i2, int i3) {
        a(cVar).a(hVar.a(cVar2), i2, i3, b.STRONG, 0, true);
    }

    public f a(c cVar) {
        switch (g.f2371a[cVar.ordinal()]) {
            case 1:
                return this.v;
            case 2:
                return this.w;
            case 3:
                return this.x;
            case 4:
                return this.y;
            case 5:
                return this.z;
            case 6:
                return this.C;
            case 7:
                return this.A;
            case 8:
                return this.B;
            case 9:
                return null;
            default:
                throw new AssertionError(cVar.name());
        }
    }

    public void a(a aVar) {
        this.F[0] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            k(this.Y);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01b0, code lost:
        if (r1 == -1) goto L_0x01b4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0254 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0337  */
    public void a(e eVar) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        int i3;
        boolean z6;
        int i4;
        int i5;
        i iVar;
        boolean z7;
        i iVar2;
        i iVar3;
        boolean z8;
        i iVar4;
        i iVar5;
        boolean z9;
        boolean z10;
        e eVar2;
        i iVar6;
        h hVar;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z11;
        boolean z12;
        e eVar3 = eVar;
        i a2 = eVar3.a((Object) this.v);
        i a3 = eVar3.a((Object) this.x);
        i a4 = eVar3.a((Object) this.w);
        i a5 = eVar3.a((Object) this.y);
        i a6 = eVar3.a((Object) this.z);
        h hVar2 = this.G;
        if (hVar2 != null) {
            z5 = hVar2 != null && hVar2.F[0] == a.WRAP_CONTENT;
            h hVar3 = this.G;
            boolean z13 = hVar3 != null && hVar3.F[1] == a.WRAP_CONTENT;
            if (p(0)) {
                ((i) this.G).a(this, 0);
                z11 = true;
            } else {
                z11 = A();
            }
            if (p(1)) {
                ((i) this.G).a(this, 1);
                z12 = true;
            } else {
                z12 = B();
            }
            if (z5 && this.ea != 8 && this.v.f2347d == null && this.x.f2347d == null) {
                eVar3.b(eVar3.a((Object) this.G.x), a3, 0, 1);
            }
            if (z13 && this.ea != 8 && this.w.f2347d == null && this.y.f2347d == null && this.z == null) {
                eVar3.b(eVar3.a((Object) this.G.y), a5, 0, 1);
            }
            z4 = z13;
            z3 = z11;
            z2 = z12;
        } else {
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
        }
        int i10 = this.H;
        int i11 = this.W;
        if (i10 < i11) {
            i10 = i11;
        }
        int i12 = this.I;
        int i13 = this.X;
        if (i12 < i13) {
            i12 = i13;
        }
        boolean z14 = this.F[0] != a.MATCH_CONSTRAINT;
        boolean z15 = this.F[1] != a.MATCH_CONSTRAINT;
        this.q = this.K;
        float f2 = this.J;
        this.r = f2;
        int i14 = this.f2378f;
        int i15 = this.f2379g;
        if (f2 <= 0.0f || this.ea == 8) {
            iVar = a6;
            i6 = i14;
            i7 = i10;
            i8 = i12;
            i4 = i15;
        } else {
            iVar = a6;
            if (this.F[0] == a.MATCH_CONSTRAINT && i14 == 0) {
                i14 = 3;
            }
            if (this.F[1] == a.MATCH_CONSTRAINT && i15 == 0) {
                i15 = 3;
            }
            a[] aVarArr = this.F;
            a aVar = aVarArr[0];
            a aVar2 = a.MATCH_CONSTRAINT;
            if (aVar == aVar2 && aVarArr[1] == aVar2) {
                i9 = 3;
                if (i14 == 3 && i15 == 3) {
                    a(z5, z4, z14, z15);
                    i5 = i14;
                    i3 = i10;
                    i2 = i12;
                    i4 = i15;
                    z6 = true;
                    int[] iArr = this.f2380h;
                    iArr[0] = i5;
                    iArr[1] = i4;
                    if (z6) {
                        int i16 = this.q;
                        if (i16 != 0) {
                        }
                        z7 = true;
                        boolean z16 = this.F[0] != a.WRAP_CONTENT && (this instanceof i);
                        boolean z17 = !this.C.i();
                        if (this.f2374b == 2) {
                            h hVar4 = this.G;
                            i a7 = hVar4 != null ? eVar3.a((Object) hVar4.x) : null;
                            h hVar5 = this.G;
                            z8 = z4;
                            iVar3 = iVar;
                            iVar5 = a5;
                            iVar2 = a4;
                            boolean z18 = z16;
                            iVar4 = a3;
                            a(eVar, z5, hVar5 != null ? eVar3.a((Object) hVar5.v) : null, a7, this.F[0], z18, this.v, this.x, this.L, i3, this.W, this.t[0], this.aa, z7, z3, i5, this.f2381i, this.f2382j, this.f2383k, z17);
                        } else {
                            iVar2 = a4;
                            iVar4 = a3;
                            z8 = z4;
                            iVar3 = iVar;
                            iVar5 = a5;
                        }
                        if (this.f2375c == 2) {
                            boolean z19 = this.F[1] == a.WRAP_CONTENT && (this instanceof i);
                            if (z6) {
                                int i17 = this.q;
                                if (i17 == 1 || i17 == -1) {
                                    z9 = true;
                                    if (this.V > 0) {
                                        eVar2 = eVar;
                                    } else if (this.z.d().f2412b == 1) {
                                        eVar2 = eVar;
                                        this.z.d().a(eVar2);
                                    } else {
                                        eVar2 = eVar;
                                        i iVar7 = iVar3;
                                        iVar6 = iVar2;
                                        eVar2.a(iVar7, iVar6, d(), 6);
                                        f fVar = this.z.f2347d;
                                        if (fVar != null) {
                                            eVar2.a(iVar7, eVar2.a((Object) fVar), 0, 6);
                                            z10 = false;
                                            h hVar6 = this.G;
                                            i a8 = hVar6 == null ? eVar2.a((Object) hVar6.y) : null;
                                            h hVar7 = this.G;
                                            i iVar8 = iVar6;
                                            a(eVar, z8, hVar7 == null ? eVar2.a((Object) hVar7.w) : null, a8, this.F[1], z19, this.w, this.y, this.M, i2, this.X, this.t[1], this.ba, z9, z2, i4, this.f2384l, this.m, this.n, z10);
                                            if (!z6) {
                                                hVar = this;
                                                if (hVar.q == 1) {
                                                    eVar.a(iVar5, iVar8, iVar4, a2, hVar.r, 6);
                                                } else {
                                                    eVar.a(iVar4, a2, iVar5, iVar8, hVar.r, 6);
                                                }
                                            } else {
                                                hVar = this;
                                            }
                                            if (hVar.C.i()) {
                                                eVar.a(hVar, hVar.C.g().c(), (float) Math.toRadians((double) (hVar.u + 90.0f)), hVar.C.b());
                                            }
                                            return;
                                        }
                                        z10 = z17;
                                        h hVar62 = this.G;
                                        if (hVar62 == null) {
                                        }
                                        h hVar72 = this.G;
                                        i iVar82 = iVar6;
                                        a(eVar, z8, hVar72 == null ? eVar2.a((Object) hVar72.w) : null, a8, this.F[1], z19, this.w, this.y, this.M, i2, this.X, this.t[1], this.ba, z9, z2, i4, this.f2384l, this.m, this.n, z10);
                                        if (!z6) {
                                        }
                                        if (hVar.C.i()) {
                                        }
                                        return;
                                    }
                                    iVar6 = iVar2;
                                    z10 = z17;
                                    h hVar622 = this.G;
                                    if (hVar622 == null) {
                                    }
                                    h hVar722 = this.G;
                                    i iVar822 = iVar6;
                                    a(eVar, z8, hVar722 == null ? eVar2.a((Object) hVar722.w) : null, a8, this.F[1], z19, this.w, this.y, this.M, i2, this.X, this.t[1], this.ba, z9, z2, i4, this.f2384l, this.m, this.n, z10);
                                    if (!z6) {
                                    }
                                    if (hVar.C.i()) {
                                    }
                                    return;
                                }
                            }
                            z9 = false;
                            if (this.V > 0) {
                            }
                            iVar6 = iVar2;
                            z10 = z17;
                            h hVar6222 = this.G;
                            if (hVar6222 == null) {
                            }
                            h hVar7222 = this.G;
                            i iVar8222 = iVar6;
                            a(eVar, z8, hVar7222 == null ? eVar2.a((Object) hVar7222.w) : null, a8, this.F[1], z19, this.w, this.y, this.M, i2, this.X, this.t[1], this.ba, z9, z2, i4, this.f2384l, this.m, this.n, z10);
                            if (!z6) {
                            }
                            if (hVar.C.i()) {
                            }
                            return;
                        }
                        return;
                    }
                    z7 = false;
                    if (this.F[0] != a.WRAP_CONTENT) {
                    }
                    boolean z172 = !this.C.i();
                    if (this.f2374b == 2) {
                    }
                    if (this.f2375c == 2) {
                    }
                }
            } else {
                i9 = 3;
            }
            a[] aVarArr2 = this.F;
            a aVar3 = aVarArr2[0];
            a aVar4 = a.MATCH_CONSTRAINT;
            if (aVar3 == aVar4 && i14 == i9) {
                this.q = 0;
                int i18 = (int) (this.r * ((float) this.I));
                if (aVarArr2[1] != aVar4) {
                    i7 = i18;
                    i8 = i12;
                    i4 = i15;
                    i6 = 4;
                } else {
                    i3 = i18;
                    i5 = i14;
                    i2 = i12;
                    i4 = i15;
                    z6 = true;
                    int[] iArr2 = this.f2380h;
                    iArr2[0] = i5;
                    iArr2[1] = i4;
                    if (z6) {
                    }
                    z7 = false;
                    if (this.F[0] != a.WRAP_CONTENT) {
                    }
                    boolean z1722 = !this.C.i();
                    if (this.f2374b == 2) {
                    }
                    if (this.f2375c == 2) {
                    }
                }
            } else {
                if (this.F[1] == a.MATCH_CONSTRAINT && i15 == 3) {
                    this.q = 1;
                    if (this.K == -1) {
                        this.r = 1.0f / this.r;
                    }
                    int i19 = (int) (this.r * ((float) this.H));
                    if (this.F[0] != a.MATCH_CONSTRAINT) {
                        i8 = i19;
                        i6 = i14;
                        i7 = i10;
                        i4 = 4;
                    } else {
                        i2 = i19;
                        i5 = i14;
                        i3 = i10;
                        i4 = i15;
                        z6 = true;
                        int[] iArr22 = this.f2380h;
                        iArr22[0] = i5;
                        iArr22[1] = i4;
                        if (z6) {
                        }
                        z7 = false;
                        if (this.F[0] != a.WRAP_CONTENT) {
                        }
                        boolean z17222 = !this.C.i();
                        if (this.f2374b == 2) {
                        }
                        if (this.f2375c == 2) {
                        }
                    }
                }
                i5 = i14;
                i3 = i10;
                i2 = i12;
                i4 = i15;
                z6 = true;
                int[] iArr222 = this.f2380h;
                iArr222[0] = i5;
                iArr222[1] = i4;
                if (z6) {
                }
                z7 = false;
                if (this.F[0] != a.WRAP_CONTENT) {
                }
                boolean z172222 = !this.C.i();
                if (this.f2374b == 2) {
                }
                if (this.f2375c == 2) {
                }
            }
        }
        z6 = false;
        int[] iArr2222 = this.f2380h;
        iArr2222[0] = i5;
        iArr2222[1] = i4;
        if (z6) {
        }
        z7 = false;
        if (this.F[0] != a.WRAP_CONTENT) {
        }
        boolean z1722222 = !this.C.i();
        if (this.f2374b == 2) {
        }
        if (this.f2375c == 2) {
        }
    }

    public void a(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.q == -1) {
            if (z4 && !z5) {
                this.q = 0;
            } else if (!z4 && z5) {
                this.q = 1;
                if (this.K == -1) {
                    this.r = 1.0f / this.r;
                }
            }
        }
        if (this.q == 0 && (!this.w.i() || !this.y.i())) {
            this.q = 1;
        } else if (this.q == 1 && (!this.v.i() || !this.x.i())) {
            this.q = 0;
        }
        if (this.q == -1 && (!this.w.i() || !this.y.i() || !this.v.i() || !this.x.i())) {
            if (this.w.i() && this.y.i()) {
                this.q = 0;
            } else if (this.v.i() && this.x.i()) {
                this.r = 1.0f / this.r;
                this.q = 1;
            }
        }
        if (this.q == -1) {
            if (z2 && !z3) {
                this.q = 0;
            } else if (!z2 && z3) {
                this.r = 1.0f / this.r;
                this.q = 1;
            }
        }
        if (this.q == -1) {
            if (this.f2381i > 0 && this.f2384l == 0) {
                this.q = 0;
            } else if (this.f2381i == 0 && this.f2384l > 0) {
                this.r = 1.0f / this.r;
                this.q = 1;
            }
        }
        if (this.q == -1 && z2 && z3) {
            this.r = 1.0f / this.r;
            this.q = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:163:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02fb  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01e9  */
    private void a(e eVar, boolean z2, i iVar, i iVar2, a aVar, boolean z3, f fVar, f fVar2, int i2, int i3, int i4, int i5, float f2, boolean z4, boolean z5, int i6, int i7, int i8, float f3, boolean z6) {
        boolean z7;
        int i9;
        int i10;
        i iVar3;
        i iVar4;
        int i11;
        int i12;
        int i13;
        int i14;
        i iVar5;
        int i15;
        int i16;
        boolean z8;
        i iVar6;
        boolean z9;
        i iVar7;
        i iVar8;
        int i17;
        boolean z10;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z11;
        boolean z12;
        i iVar9;
        i iVar10;
        int i23;
        e eVar2 = eVar;
        i iVar11 = iVar;
        i iVar12 = iVar2;
        int i24 = i4;
        int i25 = i5;
        i a2 = eVar2.a((Object) fVar);
        i a3 = eVar2.a((Object) fVar2);
        i a4 = eVar2.a((Object) fVar.g());
        i a5 = eVar2.a((Object) fVar2.g());
        if (eVar2.f2439i && fVar.d().f2412b == 1 && fVar2.d().f2412b == 1) {
            if (e.e() != null) {
                f e2 = e.e();
                e2.r++;
            }
            fVar.d().a(eVar2);
            fVar2.d().a(eVar2);
            if (!z5 && z2) {
                eVar2.b(iVar12, a3, 0, 6);
            }
            return;
        }
        if (e.e() != null) {
            f e3 = e.e();
            e3.z++;
        }
        boolean i26 = fVar.i();
        boolean i27 = fVar2.i();
        boolean i28 = this.C.i();
        int i29 = i26 ? 1 : 0;
        if (i27) {
            i29++;
        }
        if (i28) {
            i29++;
        }
        int i30 = i29;
        int i31 = z4 ? 3 : i6;
        int i32 = g.f2372b[aVar.ordinal()];
        boolean z13 = (i32 == 1 || i32 == 2 || i32 == 3 || i32 != 4 || i31 == 4) ? false : true;
        if (this.ea == 8) {
            i9 = 0;
            z7 = false;
        } else {
            z7 = z13;
            i9 = i3;
        }
        if (z6) {
            if (!i26 && !i27 && !i28) {
                eVar2.a(a2, i2);
            } else if (i26 && !i27) {
                eVar2.a(a2, a4, fVar.b(), 6);
                if (z7) {
                    if (z3) {
                        eVar2.a(a3, a2, 0, 3);
                        if (i24 > 0) {
                            i23 = 6;
                            eVar2.b(a3, a2, i24, 6);
                        } else {
                            i23 = 6;
                        }
                        if (i25 < Integer.MAX_VALUE) {
                            eVar2.c(a3, a2, i25, i23);
                        }
                    } else {
                        eVar2.a(a3, a2, i9, 6);
                    }
                    i11 = i7;
                    i12 = i8;
                    i10 = i31;
                    i14 = i30;
                    iVar3 = a5;
                    iVar4 = a4;
                    i13 = 0;
                } else {
                    int i33 = i7;
                    if (i33 == -2) {
                        i19 = i8;
                        i11 = i9;
                    } else {
                        i11 = i33;
                        i19 = i8;
                    }
                    if (i19 == -2) {
                        i19 = i9;
                    }
                    if (i11 > 0) {
                        if (z2) {
                            i20 = 6;
                            eVar2.b(a3, a2, i11, 6);
                        } else {
                            i20 = 6;
                            eVar2.b(a3, a2, i11, 6);
                        }
                        i9 = Math.max(i9, i11);
                    } else {
                        i20 = 6;
                    }
                    if (i19 > 0) {
                        if (z2) {
                            eVar2.c(a3, a2, i19, 1);
                        } else {
                            eVar2.c(a3, a2, i19, i20);
                        }
                        i9 = Math.min(i9, i19);
                    }
                    if (i31 != 1) {
                        z12 = z7;
                        if (i31 == 2) {
                            if (fVar.h() == c.TOP || fVar.h() == c.BOTTOM) {
                                iVar9 = eVar2.a((Object) this.G.a(c.TOP));
                                iVar10 = eVar2.a((Object) this.G.a(c.BOTTOM));
                            } else {
                                iVar9 = eVar2.a((Object) this.G.a(c.LEFT));
                                iVar10 = eVar2.a((Object) this.G.a(c.RIGHT));
                            }
                            i iVar13 = iVar9;
                            i iVar14 = iVar10;
                            b.e.b.b b2 = eVar.b();
                            b.e.b.b bVar = b2;
                            i10 = i31;
                            iVar4 = a4;
                            i22 = i9;
                            i14 = i30;
                            i13 = 0;
                            i iVar15 = iVar14;
                            i21 = i19;
                            iVar3 = a5;
                            b2.a(a3, a2, iVar15, iVar13, f3);
                            eVar2.a(b2);
                            z11 = false;
                            if (z11) {
                            }
                            i12 = i21;
                            z7 = z11;
                        }
                    } else if (z2) {
                        eVar2.a(a3, a2, i9, 6);
                        i10 = i31;
                        i14 = i30;
                        iVar3 = a5;
                        iVar4 = a4;
                        z12 = z7;
                        i13 = 0;
                        i22 = i9;
                        i21 = i19;
                        z11 = z12;
                        if (z11 || i14 == 2 || z4) {
                            i12 = i21;
                            z7 = z11;
                        } else {
                            int max = Math.max(i11, i22);
                            if (i21 > 0) {
                                max = Math.min(i21, max);
                            }
                            eVar2.a(a3, a2, max, 6);
                            i12 = i21;
                            z7 = false;
                        }
                    } else if (z5) {
                        z12 = z7;
                        eVar2.a(a3, a2, i9, 4);
                    } else {
                        z12 = z7;
                        eVar2.a(a3, a2, i9, 1);
                    }
                    i10 = i31;
                    i14 = i30;
                    i21 = i19;
                    iVar3 = a5;
                    iVar4 = a4;
                    i13 = 0;
                    i22 = i9;
                    z11 = z12;
                    if (z11) {
                    }
                    i12 = i21;
                    z7 = z11;
                }
                if (z6 || z5) {
                    i iVar16 = a3;
                    i iVar17 = iVar12;
                    if (i14 < 2 && z2) {
                        eVar2.b(a2, iVar11, 0, 6);
                        eVar2.b(iVar17, iVar16, 0, 6);
                    }
                }
                int i34 = 5;
                if (i26 || i27 || i28) {
                    if (!i26 || i27) {
                        if (i26 || !i27) {
                            i iVar18 = iVar3;
                            if (i26 && i27) {
                                if (z7) {
                                    if (z2) {
                                        if (i4 == 0) {
                                            eVar2.b(a3, a2, 0, 6);
                                        }
                                    }
                                    if (i10 == 0) {
                                        if (i12 > 0 || i11 > 0) {
                                            i18 = 4;
                                            z10 = true;
                                        } else {
                                            i18 = 6;
                                            z10 = false;
                                        }
                                        iVar6 = iVar4;
                                        eVar2.a(a2, iVar6, fVar.b(), i18);
                                        eVar2.a(a3, iVar18, -fVar2.b(), i18);
                                        boolean z14 = i12 > 0 || i11 > 0;
                                        z8 = z10;
                                        z9 = z14;
                                    } else {
                                        int i35 = i10;
                                        iVar6 = iVar4;
                                        z9 = true;
                                        if (i35 == 1) {
                                            i34 = 6;
                                            z8 = true;
                                        } else if (i35 == 3) {
                                            if (!z4) {
                                                if (this.q != -1 && i12 <= 0) {
                                                    i17 = 6;
                                                    eVar2.a(a2, iVar6, fVar.b(), i17);
                                                    eVar2.a(a3, iVar18, -fVar2.b(), i17);
                                                    z8 = true;
                                                }
                                            }
                                            i17 = 4;
                                            eVar2.a(a2, iVar6, fVar.b(), i17);
                                            eVar2.a(a3, iVar18, -fVar2.b(), i17);
                                            z8 = true;
                                        } else {
                                            z9 = false;
                                        }
                                    }
                                    if (!z9) {
                                        iVar7 = iVar18;
                                        iVar8 = iVar6;
                                        iVar5 = a3;
                                        eVar.a(a2, iVar6, fVar.b(), f2, iVar18, a3, fVar2.b(), i34);
                                    } else {
                                        iVar8 = iVar6;
                                        iVar7 = iVar18;
                                        iVar5 = a3;
                                    }
                                    if (!z8) {
                                        i16 = 6;
                                        eVar2.b(a2, iVar8, fVar.b(), 6);
                                        eVar2.c(iVar5, iVar7, -fVar2.b(), 6);
                                    } else {
                                        i16 = 6;
                                    }
                                    if (z2) {
                                        i15 = 0;
                                        eVar2.b(a2, iVar11, 0, i16);
                                        if (z2) {
                                            eVar2.b(iVar2, iVar5, i15, i16);
                                        }
                                        return;
                                    }
                                    i15 = 0;
                                    if (z2) {
                                    }
                                    return;
                                }
                                iVar6 = iVar4;
                                z9 = true;
                                if (z2) {
                                    eVar2.b(a2, iVar6, fVar.b(), 5);
                                    eVar2.c(a3, iVar18, -fVar2.b(), 5);
                                }
                                z8 = false;
                                if (!z9) {
                                }
                                if (!z8) {
                                }
                                if (z2) {
                                }
                                i15 = 0;
                                if (z2) {
                                }
                                return;
                            }
                        } else {
                            eVar2.a(a3, iVar3, -fVar2.b(), 6);
                            if (z2) {
                                eVar2.b(a2, iVar11, i13, 5);
                            }
                        }
                    } else if (z2) {
                        eVar2.b(iVar12, a3, i13, 5);
                    }
                } else if (z2) {
                    eVar2.b(iVar12, a3, i13, 5);
                }
                iVar5 = a3;
                i16 = 6;
                i15 = 0;
                if (z2) {
                }
                return;
            }
        }
        if (z7) {
        }
        if (z6) {
        }
        i iVar162 = a3;
        i iVar172 = iVar12;
        eVar2.b(a2, iVar11, 0, 6);
        eVar2.b(iVar172, iVar162, 0, 6);
    }
}
