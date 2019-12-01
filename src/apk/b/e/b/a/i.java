package b.e.b.a;

import b.e.b.a.f.c;
import b.e.b.a.h.a;
import b.e.b.e;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ConstraintWidgetContainer */
public class i extends u {
    int Aa = 0;
    int Ba = 0;
    d[] Ca = new d[4];
    d[] Da = new d[4];
    public List<j> Ea = new ArrayList();
    public boolean Fa = false;
    public boolean Ga = false;
    public boolean Ha = false;
    public int Ia = 0;
    public int Ja = 0;
    private int Ka = 3;
    public boolean La = false;
    private boolean Ma = false;
    private boolean Na = false;
    int Oa = 0;
    private boolean ta = false;
    protected e ua = new e();
    private t va;
    int wa;
    int xa;
    int ya;
    int za;

    private void W() {
        this.Aa = 0;
        this.Ba = 0;
    }

    public void E() {
        this.ua.g();
        this.wa = 0;
        this.ya = 0;
        this.xa = 0;
        this.za = 0;
        this.Ea.clear();
        this.La = false;
        super.E();
    }

    /* JADX WARNING: type inference failed for: r7v10, types: [boolean] */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r7v15 */
    /* JADX WARNING: type inference failed for: r7v44 */
    /* JADX WARNING: type inference failed for: r7v45 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v10, types: [boolean]
      assigns: []
      uses: [?[int, short, byte, char], boolean]
      mth insns count: 313
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0251  */
    /* JADX WARNING: Unknown variable types count: 3 */
    public void L() {
        int i2;
        boolean z;
        boolean z2;
        char c2;
        int i3;
        boolean z3;
        boolean z4;
        int max;
        int max2;
        ? r7;
        boolean z5;
        int i4 = this.L;
        int i5 = this.M;
        int max3 = Math.max(0, u());
        int max4 = Math.max(0, j());
        this.Ma = false;
        this.Na = false;
        if (this.G != null) {
            if (this.va == null) {
                this.va = new t(this);
            }
            this.va.b(this);
            n(this.wa);
            o(this.xa);
            F();
            a(this.ua.d());
        } else {
            this.L = 0;
            this.M = 0;
        }
        if (this.Ka != 0) {
            if (!p(8)) {
                T();
            }
            S();
            this.ua.f2439i = true;
        } else {
            this.ua.f2439i = false;
        }
        a[] aVarArr = this.F;
        a aVar = aVarArr[1];
        a aVar2 = aVarArr[0];
        W();
        if (this.Ea.size() == 0) {
            this.Ea.clear();
            this.Ea.add(0, new j(this.sa));
        }
        int size = this.Ea.size();
        ArrayList<h> arrayList = this.sa;
        boolean z6 = l() == a.WRAP_CONTENT || s() == a.WRAP_CONTENT;
        boolean z7 = false;
        int i6 = 0;
        while (i6 < size && !this.La) {
            this.sa = (ArrayList) ((j) this.Ea.get(i6)).f2390a;
            W();
            int size2 = this.sa.size();
            for (int i7 = 0; i7 < size2; i7++) {
                h hVar = (h) this.sa.get(i7);
                if (hVar instanceof u) {
                    ((u) hVar).L();
                }
            }
            boolean z8 = z7;
            int i8 = 0;
            boolean z9 = true;
            while (z9) {
                boolean z10 = z9;
                int i9 = i8 + 1;
                try {
                    this.ua.g();
                    b(this.ua);
                    int i10 = 0;
                    while (i10 < size2) {
                        z = z8;
                        try {
                            ((h) this.sa.get(i10)).b(this.ua);
                            i10++;
                            z8 = z;
                        } catch (Exception e2) {
                            e = e2;
                            z5 = z10;
                            e.printStackTrace();
                            PrintStream printStream = System.out;
                            z2 = z5;
                            StringBuilder sb = new StringBuilder();
                            i2 = size;
                            sb.append("EXCEPTION : ");
                            sb.append(e);
                            printStream.println(sb.toString());
                            if (!z2) {
                            }
                            c2 = 2;
                            if (z6) {
                            }
                            i3 = i9;
                            z3 = z;
                            z4 = false;
                            max = Math.max(this.W, u());
                            if (max > u()) {
                            }
                            max2 = Math.max(this.X, j());
                            if (max2 > j()) {
                            }
                            if (!z3) {
                            }
                            z9 = z4;
                            z8 = z3;
                            i8 = i3;
                            size = i2;
                        }
                    }
                    z = z8;
                    z5 = d(this.ua);
                    if (z5) {
                        try {
                            this.ua.f();
                        } catch (Exception e3) {
                            e = e3;
                        }
                    }
                    z2 = z5;
                    i2 = size;
                } catch (Exception e4) {
                    e = e4;
                    z = z8;
                    z5 = z10;
                    e.printStackTrace();
                    PrintStream printStream2 = System.out;
                    z2 = z5;
                    StringBuilder sb2 = new StringBuilder();
                    i2 = size;
                    sb2.append("EXCEPTION : ");
                    sb2.append(e);
                    printStream2.println(sb2.toString());
                    if (!z2) {
                    }
                    c2 = 2;
                    if (z6) {
                    }
                    i3 = i9;
                    z3 = z;
                    z4 = false;
                    max = Math.max(this.W, u());
                    if (max > u()) {
                    }
                    max2 = Math.max(this.X, j());
                    if (max2 > j()) {
                    }
                    if (!z3) {
                    }
                    z9 = z4;
                    z8 = z3;
                    i8 = i3;
                    size = i2;
                }
                if (!z2) {
                    c(this.ua);
                    int i11 = 0;
                    while (true) {
                        if (i11 >= size2) {
                            break;
                        }
                        h hVar2 = (h) this.sa.get(i11);
                        if (hVar2.F[0] != a.MATCH_CONSTRAINT || hVar2.u() >= hVar2.w()) {
                            if (hVar2.F[1] == a.MATCH_CONSTRAINT && hVar2.j() < hVar2.v()) {
                                c2 = 2;
                                o.f2399a[2] = true;
                                break;
                            }
                            i11++;
                        } else {
                            o.f2399a[2] = true;
                            break;
                        }
                    }
                } else {
                    a(this.ua, o.f2399a);
                }
                c2 = 2;
                if (z6 || i9 >= 8 || !o.f2399a[c2]) {
                    i3 = i9;
                    z3 = z;
                    z4 = false;
                } else {
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    while (i12 < size2) {
                        h hVar3 = (h) this.sa.get(i12);
                        int i15 = i9;
                        i13 = Math.max(i13, hVar3.L + hVar3.u());
                        i14 = Math.max(i14, hVar3.M + hVar3.j());
                        i12++;
                        i9 = i15;
                    }
                    i3 = i9;
                    int max5 = Math.max(this.W, i13);
                    int max6 = Math.max(this.X, i14);
                    if (aVar2 != a.WRAP_CONTENT || u() >= max5) {
                        z4 = false;
                    } else {
                        k(max5);
                        this.F[0] = a.WRAP_CONTENT;
                        z4 = true;
                        z = true;
                    }
                    if (aVar != a.WRAP_CONTENT || j() >= max6) {
                        z3 = z;
                    } else {
                        c(max6);
                        this.F[1] = a.WRAP_CONTENT;
                        z4 = true;
                        z3 = true;
                    }
                }
                max = Math.max(this.W, u());
                if (max > u()) {
                    k(max);
                    this.F[0] = a.FIXED;
                    z4 = true;
                    z3 = true;
                }
                max2 = Math.max(this.X, j());
                if (max2 > j()) {
                    c(max2);
                    this.F[1] = a.FIXED;
                    z4 = true;
                    z3 = true;
                    r7 = 1;
                } else {
                    r7 = 1;
                }
                if (!z3) {
                    if (this.F[0] == a.WRAP_CONTENT && max3 > 0 && u() > max3) {
                        this.Ma = r7;
                        this.F[0] = a.FIXED;
                        k(max3);
                        z4 = true;
                        z3 = true;
                    }
                    if (this.F[r7] == a.WRAP_CONTENT && max4 > 0 && j() > max4) {
                        this.Na = r7;
                        this.F[r7] = a.FIXED;
                        c(max4);
                        z9 = true;
                        z8 = true;
                        i8 = i3;
                        size = i2;
                    }
                }
                z9 = z4;
                z8 = z3;
                i8 = i3;
                size = i2;
            }
            int i16 = size;
            i6++;
            z7 = z8;
        }
        this.sa = arrayList;
        if (this.G != null) {
            int max7 = Math.max(this.W, u());
            int max8 = Math.max(this.X, j());
            this.va.a(this);
            k(max7 + this.wa + this.ya);
            c(max8 + this.xa + this.za);
        } else {
            this.L = i4;
            this.M = i5;
        }
        if (z7) {
            a[] aVarArr2 = this.F;
            aVarArr2[0] = aVar2;
            aVarArr2[1] = aVar;
        }
        a(this.ua.d());
        if (this == K()) {
            I();
        }
    }

    public int N() {
        return this.Ka;
    }

    public boolean O() {
        return false;
    }

    public boolean P() {
        return this.Na;
    }

    public boolean Q() {
        return this.ta;
    }

    public boolean R() {
        return this.Ma;
    }

    public void S() {
        if (!p(8)) {
            a(this.Ka);
        }
        V();
    }

    public void T() {
        int size = this.sa.size();
        G();
        for (int i2 = 0; i2 < size; i2++) {
            ((h) this.sa.get(i2)).G();
        }
    }

    public void U() {
        T();
        a(this.Ka);
    }

    public void V() {
        q d2 = a(c.LEFT).d();
        q d3 = a(c.TOP).d();
        d2.a((q) null, 0.0f);
        d3.a((q) null, 0.0f);
    }

    public void a(e eVar, boolean[] zArr) {
        zArr[2] = false;
        c(eVar);
        int size = this.sa.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.sa.get(i2);
            hVar.c(eVar);
            if (hVar.F[0] == a.MATCH_CONSTRAINT && hVar.u() < hVar.w()) {
                zArr[2] = true;
            }
            if (hVar.F[1] == a.MATCH_CONSTRAINT && hVar.j() < hVar.v()) {
                zArr[2] = true;
            }
        }
    }

    public void c(boolean z) {
        this.ta = z;
    }

    public boolean d(e eVar) {
        a(eVar);
        int size = this.sa.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.sa.get(i2);
            if (hVar instanceof i) {
                a[] aVarArr = hVar.F;
                a aVar = aVarArr[0];
                a aVar2 = aVarArr[1];
                if (aVar == a.WRAP_CONTENT) {
                    hVar.a(a.FIXED);
                }
                if (aVar2 == a.WRAP_CONTENT) {
                    hVar.b(a.FIXED);
                }
                hVar.a(eVar);
                if (aVar == a.WRAP_CONTENT) {
                    hVar.a(aVar);
                }
                if (aVar2 == a.WRAP_CONTENT) {
                    hVar.b(aVar2);
                }
            } else {
                o.a(this, eVar, hVar);
                hVar.a(eVar);
            }
        }
        if (this.Aa > 0) {
            c.a(this, eVar, 0);
        }
        if (this.Ba > 0) {
            c.a(this, eVar, 1);
        }
        return true;
    }

    public void e(int i2, int i3) {
        if (this.F[0] != a.WRAP_CONTENT) {
            r rVar = this.f2376d;
            if (rVar != null) {
                rVar.a(i2);
            }
        }
        if (this.F[1] != a.WRAP_CONTENT) {
            r rVar2 = this.f2377e;
            if (rVar2 != null) {
                rVar2.a(i3);
            }
        }
    }

    public boolean p(int i2) {
        return (this.Ka & i2) == i2;
    }

    public void q(int i2) {
        this.Ka = i2;
    }

    private void e(h hVar) {
        int i2 = this.Ba + 1;
        d[] dVarArr = this.Ca;
        if (i2 >= dVarArr.length) {
            this.Ca = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.Ca[this.Ba] = new d(hVar, 1, Q());
        this.Ba++;
    }

    public void a(int i2) {
        super.a(i2);
        int size = this.sa.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((h) this.sa.get(i3)).a(i2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(h hVar, int i2) {
        if (i2 == 0) {
            d(hVar);
        } else if (i2 == 1) {
            e(hVar);
        }
    }

    private void d(h hVar) {
        int i2 = this.Aa + 1;
        d[] dVarArr = this.Da;
        if (i2 >= dVarArr.length) {
            this.Da = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.Da[this.Aa] = new d(hVar, 0, Q());
        this.Aa++;
    }
}
