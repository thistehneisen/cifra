package b.e.b.a;

import b.e.b.a.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Analyzer */
public class a {
    public static void a(i iVar) {
        if ((iVar.N() & 32) != 32) {
            b(iVar);
            return;
        }
        iVar.La = true;
        iVar.Fa = false;
        iVar.Ga = false;
        iVar.Ha = false;
        ArrayList<h> arrayList = iVar.sa;
        List<j> list = iVar.Ea;
        boolean z = iVar.l() == b.e.b.a.h.a.WRAP_CONTENT;
        boolean z2 = iVar.s() == b.e.b.a.h.a.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (h hVar : arrayList) {
            hVar.s = null;
            hVar.w.d().f2411a.clear();
            hVar.y.d().f2411a.clear();
            hVar.v.d().f2411a.clear();
            hVar.x.d().f2411a.clear();
            hVar.z.d().f2411a.clear();
            hVar.C.d().f2411a.clear();
        }
        for (h hVar2 : arrayList) {
            if (hVar2.s == null && !a(hVar2, list, z3)) {
                b(iVar);
                iVar.La = false;
                return;
            }
        }
        if (iVar.La) {
            int i2 = 0;
            int i3 = 0;
            for (j jVar : list) {
                if (z || !z3) {
                    i2 = Math.max(i2, a(jVar, 0));
                }
                if (z2 || !z3) {
                    i3 = Math.max(i3, a(jVar, 1));
                }
            }
            if (z) {
                iVar.a(b.e.b.a.h.a.FIXED);
                iVar.k(i2);
                iVar.Fa = true;
                iVar.Ga = true;
                iVar.Ia = i2;
            }
            if (z2) {
                iVar.b(b.e.b.a.h.a.FIXED);
                iVar.c(i3);
                iVar.Fa = true;
                iVar.Ha = true;
                iVar.Ja = i3;
            }
            if ((!z2 || !z) && z3) {
                iVar.La = false;
            } else {
                iVar.La = true;
                a(list, 0, i2);
                a(list, 1, i3);
            }
        }
    }

    private static void b(i iVar) {
        iVar.Ea.clear();
        iVar.Ea.add(0, new j(iVar.sa));
    }

    private static boolean a(h hVar, List<j> list, boolean z) {
        j jVar = new j(new ArrayList());
        list.add(jVar);
        return a(hVar, jVar, list, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e2, code lost:
        if (r2.f2345b == r8.G) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0111, code lost:
        if (r2.f2345b == r8.G) goto L_0x0113;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011c  */
    private static boolean a(h hVar, j jVar, List<j> list, boolean z) {
        f fVar;
        if (hVar == null) {
            return true;
        }
        i iVar = (i) hVar.m();
        j jVar2 = hVar.s;
        if (jVar2 == null) {
            jVar.f2390a.add(hVar);
            hVar.s = jVar;
            if (hVar.v.f2347d == null && hVar.x.f2347d == null && hVar.w.f2347d == null && hVar.y.f2347d == null && hVar.z.f2347d == null && hVar.C.f2347d == null) {
                iVar.La = false;
                if (z) {
                    return false;
                }
            }
            if (!(hVar.w.f2347d == null || hVar.y.f2347d == null)) {
                iVar.La = false;
                if (z) {
                    return false;
                }
            }
            if (!(hVar.v.f2347d == null || hVar.x.f2347d == null)) {
                iVar.La = false;
                if (z) {
                    return false;
                }
            }
            if (!((hVar.l() == b.e.b.a.h.a.MATCH_CONSTRAINT) ^ (hVar.s() == b.e.b.a.h.a.MATCH_CONSTRAINT)) || hVar.J == 0.0f) {
                if (hVar.l() == b.e.b.a.h.a.MATCH_CONSTRAINT || hVar.s() == b.e.b.a.h.a.MATCH_CONSTRAINT) {
                    iVar.La = false;
                    if (z) {
                        return false;
                    }
                }
            } else if (hVar.l() == b.e.b.a.h.a.MATCH_CONSTRAINT) {
                hVar.k((int) (((float) hVar.j()) / hVar.J));
            } else if (hVar.s() == b.e.b.a.h.a.MATCH_CONSTRAINT) {
                hVar.c((int) (((float) hVar.u()) / hVar.J));
            }
            if (!(hVar.v.f2347d == null && hVar.x.f2347d == null)) {
                f fVar2 = hVar.v.f2347d;
                if (fVar2 == null || fVar2.f2345b != hVar.G) {
                    f fVar3 = hVar.x.f2347d;
                    if (fVar3 != null) {
                    }
                    if (!(hVar.w.f2347d == null && hVar.y.f2347d == null && hVar.z.f2347d == null)) {
                        f fVar4 = hVar.w.f2347d;
                        if (fVar4 == null || fVar4.f2345b != hVar.G) {
                            fVar = hVar.y.f2347d;
                            if (fVar != null) {
                            }
                            if (hVar instanceof n) {
                                iVar.La = false;
                                if (z) {
                                    return false;
                                }
                                n nVar = (n) hVar;
                                for (int i2 = 0; i2 < nVar.ta; i2++) {
                                    if (!a(nVar.sa[i2], jVar, list, z)) {
                                        return false;
                                    }
                                }
                            }
                            for (f fVar5 : hVar.D) {
                                f fVar6 = fVar5.f2347d;
                                if (!(fVar6 == null || fVar6.f2345b == hVar.m())) {
                                    if (fVar5.f2346c == c.CENTER) {
                                        iVar.La = false;
                                        if (z) {
                                            return false;
                                        }
                                    } else {
                                        a(fVar5);
                                    }
                                    if (!a(fVar5.f2347d.f2345b, jVar, list, z)) {
                                        return false;
                                    }
                                }
                            }
                            return true;
                        }
                    }
                    jVar.f2395f.add(hVar);
                    if (hVar instanceof n) {
                    }
                    while (r4 < r2) {
                    }
                    return true;
                }
            }
            jVar.f2394e.add(hVar);
            f fVar42 = hVar.w.f2347d;
            fVar = hVar.y.f2347d;
            if (fVar != null) {
            }
            if (hVar instanceof n) {
            }
            while (r4 < r2) {
            }
            return true;
        }
        if (jVar2 != jVar) {
            jVar.f2390a.addAll(jVar2.f2390a);
            jVar.f2394e.addAll(hVar.s.f2394e);
            jVar.f2395f.addAll(hVar.s.f2395f);
            list.remove(hVar.s);
            for (h hVar2 : hVar.s.f2390a) {
                hVar2.s = jVar;
            }
        }
        return true;
    }

    private static int a(j jVar, int i2) {
        Iterator it = jVar.a(i2).iterator();
        int i3 = 0;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            boolean z = true;
            if (hVar.D[(i2 * 2) + 1].f2347d != null) {
                z = false;
            }
            i3 = Math.max(i3, a(hVar, i2, z, 0));
        }
        jVar.f2393d[i2] = i3;
        return i3;
    }

    private static int a(h hVar, int i2, boolean z, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int u;
        int i10;
        int i11;
        int i12;
        h hVar2 = hVar;
        int i13 = i2;
        boolean z2 = z;
        boolean z3 = hVar2.z.f2347d != null && i13 == 1;
        if (z2) {
            i7 = hVar.d();
            i6 = hVar.j() - hVar.d();
            i5 = i13 * 2;
            i4 = i5 + 1;
        } else {
            i7 = hVar.j() - hVar.d();
            i6 = hVar.d();
            i4 = i13 * 2;
            i5 = i4 + 1;
        }
        f[] fVarArr = hVar2.D;
        if (fVarArr[i4].f2347d == null || fVarArr[i5].f2347d != null) {
            i8 = i4;
            i9 = 1;
        } else {
            i8 = i5;
            i5 = i4;
            i9 = -1;
        }
        int i14 = z3 ? i3 - i7 : i3;
        int b2 = hVar2.D[i5].b() * i9;
        int i15 = b2 + i14;
        int u2 = (i13 == 0 ? hVar.u() : hVar.j()) * i9;
        Iterator it = hVar2.D[i5].d().f2411a.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            i16 = Math.max(i16, a(((q) it.next()).f2400c.f2345b, i13, z2, i15));
        }
        Iterator it2 = hVar2.D[i8].d().f2411a.iterator();
        int i17 = 0;
        while (it2.hasNext()) {
            Iterator it3 = it2;
            i17 = Math.max(i17, a(((q) it2.next()).f2400c.f2345b, i13, z2, u2 + i15));
            it2 = it3;
        }
        if (z3) {
            i16 -= i7;
            u = i17 + i6;
        } else {
            u = i17 + ((i13 == 0 ? hVar.u() : hVar.j()) * i9);
        }
        int i18 = 1;
        if (i13 == 1) {
            Iterator it4 = hVar2.z.d().f2411a.iterator();
            int i19 = 0;
            while (it4.hasNext()) {
                Iterator it5 = it4;
                q qVar = (q) it4.next();
                if (i9 == i18) {
                    i19 = Math.max(i19, a(qVar.f2400c.f2345b, i13, z2, i7 + i15));
                    i12 = u2;
                } else {
                    i12 = u2;
                    i19 = Math.max(i19, a(qVar.f2400c.f2345b, i13, z2, (i6 * i9) + i15));
                }
                it4 = it5;
                u2 = i12;
                i18 = 1;
            }
            i10 = u2;
            i11 = i19;
            if (hVar2.z.d().f2411a.size() > 0 && !z3) {
                i11 = i9 == 1 ? i11 + i7 : i11 - i6;
            }
        } else {
            i10 = u2;
            i11 = 0;
        }
        int max = b2 + Math.max(i16, Math.max(u, i11));
        int b3 = i14 + (hVar2.D[i5].b() * i9);
        int i20 = b3 + i10;
        if (i9 != -1) {
            int i21 = b3;
            b3 = i20;
            i20 = i21;
        }
        if (z2) {
            hVar2.a(i20, b3, i13);
        } else if (i13 == 0) {
            hVar2.s.f2396g.add(hVar2);
            hVar2.N = i20;
        } else if (i13 == 1) {
            hVar2.s.f2397h.add(hVar2);
            hVar2.O = i20;
        }
        return max;
    }

    private static void a(f fVar) {
        q d2 = fVar.d();
        f fVar2 = fVar.f2347d;
        if (fVar2 != null && fVar2.f2347d != fVar) {
            fVar2.d().a(d2);
        }
    }

    public static void a(List<j> list, int i2, int i3) {
        for (j b2 : list) {
            Iterator it = b2.b(i2).iterator();
            while (it.hasNext()) {
                a((h) it.next(), i2, i3);
            }
        }
    }

    private static void a(h hVar, int i2, int i3) {
        if (i2 == 0) {
            int u = i3 - (hVar.N + hVar.u());
            hVar.a(u, hVar.u() + u);
        } else if (i2 == 1) {
            int j2 = i3 - (hVar.O + hVar.j());
            hVar.d(j2, hVar.j() + j2);
        }
    }
}
