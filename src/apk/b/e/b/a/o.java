package b.e.b.a;

import b.e.b.a.h.a;
import b.e.b.e;
import b.e.b.f;

/* compiled from: Optimizer */
public class o {

    /* renamed from: a reason: collision with root package name */
    static boolean[] f2399a = new boolean[3];

    static void a(i iVar, e eVar, h hVar) {
        if (iVar.F[0] != a.WRAP_CONTENT && hVar.F[0] == a.MATCH_PARENT) {
            int i2 = hVar.v.f2348e;
            int u = iVar.u() - hVar.x.f2348e;
            f fVar = hVar.v;
            fVar.f2353j = eVar.a((Object) fVar);
            f fVar2 = hVar.x;
            fVar2.f2353j = eVar.a((Object) fVar2);
            eVar.a(hVar.v.f2353j, i2);
            eVar.a(hVar.x.f2353j, u);
            hVar.f2374b = 2;
            hVar.a(i2, u);
        }
        if (iVar.F[1] != a.WRAP_CONTENT && hVar.F[1] == a.MATCH_PARENT) {
            int i3 = hVar.w.f2348e;
            int j2 = iVar.j() - hVar.y.f2348e;
            f fVar3 = hVar.w;
            fVar3.f2353j = eVar.a((Object) fVar3);
            f fVar4 = hVar.y;
            fVar4.f2353j = eVar.a((Object) fVar4);
            eVar.a(hVar.w.f2353j, i3);
            eVar.a(hVar.y.f2353j, j2);
            if (hVar.V > 0 || hVar.t() == 8) {
                f fVar5 = hVar.z;
                fVar5.f2353j = eVar.a((Object) fVar5);
                eVar.a(hVar.z.f2353j, hVar.V + i3);
            }
            hVar.f2375c = 2;
            hVar.d(i3, j2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x003b A[RETURN] */
    private static boolean a(h hVar, int i2) {
        a[] aVarArr = hVar.F;
        if (aVarArr[i2] != a.MATCH_CONSTRAINT) {
            return false;
        }
        char c2 = 1;
        if (hVar.J != 0.0f) {
            if (i2 != 0) {
                c2 = 0;
            }
            if (aVarArr[c2] == a.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i2 == 0) {
            if (hVar.f2378f == 0 && hVar.f2381i == 0 && hVar.f2382j == 0) {
                return true;
            }
            return false;
        } else if (hVar.f2379g != 0 || hVar.f2384l != 0 || hVar.m != 0) {
            return false;
        }
        return true;
    }

    static void a(int i2, h hVar) {
        h hVar2 = hVar;
        hVar.J();
        q d2 = hVar2.v.d();
        q d3 = hVar2.w.d();
        q d4 = hVar2.x.d();
        q d5 = hVar2.y.d();
        boolean z = (i2 & 8) == 8;
        boolean z2 = hVar2.F[0] == a.MATCH_CONSTRAINT && a(hVar2, 0);
        if (!(d2.f2406i == 4 || d4.f2406i == 4)) {
            if (hVar2.F[0] == a.FIXED || (z2 && hVar.t() == 8)) {
                if (hVar2.v.f2347d == null && hVar2.x.f2347d == null) {
                    d2.b(1);
                    d4.b(1);
                    if (z) {
                        d4.a(d2, 1, hVar.o());
                    } else {
                        d4.a(d2, hVar.u());
                    }
                } else if (hVar2.v.f2347d != null && hVar2.x.f2347d == null) {
                    d2.b(1);
                    d4.b(1);
                    if (z) {
                        d4.a(d2, 1, hVar.o());
                    } else {
                        d4.a(d2, hVar.u());
                    }
                } else if (hVar2.v.f2347d == null && hVar2.x.f2347d != null) {
                    d2.b(1);
                    d4.b(1);
                    d2.a(d4, -hVar.u());
                    if (z) {
                        d2.a(d4, -1, hVar.o());
                    } else {
                        d2.a(d4, -hVar.u());
                    }
                } else if (!(hVar2.v.f2347d == null || hVar2.x.f2347d == null)) {
                    d2.b(2);
                    d4.b(2);
                    if (z) {
                        hVar.o().a(d2);
                        hVar.o().a(d4);
                        d2.b(d4, -1, hVar.o());
                        d4.b(d2, 1, hVar.o());
                    } else {
                        d2.b(d4, (float) (-hVar.u()));
                        d4.b(d2, (float) hVar.u());
                    }
                }
            } else if (z2) {
                int u = hVar.u();
                d2.b(1);
                d4.b(1);
                if (hVar2.v.f2347d == null && hVar2.x.f2347d == null) {
                    if (z) {
                        d4.a(d2, 1, hVar.o());
                    } else {
                        d4.a(d2, u);
                    }
                } else if (hVar2.v.f2347d == null || hVar2.x.f2347d != null) {
                    if (hVar2.v.f2347d != null || hVar2.x.f2347d == null) {
                        if (!(hVar2.v.f2347d == null || hVar2.x.f2347d == null)) {
                            if (z) {
                                hVar.o().a(d2);
                                hVar.o().a(d4);
                            }
                            if (hVar2.J == 0.0f) {
                                d2.b(3);
                                d4.b(3);
                                d2.b(d4, 0.0f);
                                d4.b(d2, 0.0f);
                            } else {
                                d2.b(2);
                                d4.b(2);
                                d2.b(d4, (float) (-u));
                                d4.b(d2, (float) u);
                                hVar2.k(u);
                            }
                        }
                    } else if (z) {
                        d2.a(d4, -1, hVar.o());
                    } else {
                        d2.a(d4, -u);
                    }
                } else if (z) {
                    d4.a(d2, 1, hVar.o());
                } else {
                    d4.a(d2, u);
                }
            }
        }
        boolean z3 = hVar2.F[1] == a.MATCH_CONSTRAINT && a(hVar2, 1);
        if (d3.f2406i != 4 && d5.f2406i != 4) {
            if (hVar2.F[1] == a.FIXED || (z3 && hVar.t() == 8)) {
                if (hVar2.w.f2347d == null && hVar2.y.f2347d == null) {
                    d3.b(1);
                    d5.b(1);
                    if (z) {
                        d5.a(d3, 1, hVar.n());
                    } else {
                        d5.a(d3, hVar.j());
                    }
                    f fVar = hVar2.z;
                    if (fVar.f2347d != null) {
                        fVar.d().b(1);
                        d3.a(1, hVar2.z.d(), -hVar2.V);
                    }
                } else if (hVar2.w.f2347d != null && hVar2.y.f2347d == null) {
                    d3.b(1);
                    d5.b(1);
                    if (z) {
                        d5.a(d3, 1, hVar.n());
                    } else {
                        d5.a(d3, hVar.j());
                    }
                    if (hVar2.V > 0) {
                        hVar2.z.d().a(1, d3, hVar2.V);
                    }
                } else if (hVar2.w.f2347d == null && hVar2.y.f2347d != null) {
                    d3.b(1);
                    d5.b(1);
                    if (z) {
                        d3.a(d5, -1, hVar.n());
                    } else {
                        d3.a(d5, -hVar.j());
                    }
                    if (hVar2.V > 0) {
                        hVar2.z.d().a(1, d3, hVar2.V);
                    }
                } else if (hVar2.w.f2347d != null && hVar2.y.f2347d != null) {
                    d3.b(2);
                    d5.b(2);
                    if (z) {
                        d3.b(d5, -1, hVar.n());
                        d5.b(d3, 1, hVar.n());
                        hVar.n().a(d3);
                        hVar.o().a(d5);
                    } else {
                        d3.b(d5, (float) (-hVar.j()));
                        d5.b(d3, (float) hVar.j());
                    }
                    if (hVar2.V > 0) {
                        hVar2.z.d().a(1, d3, hVar2.V);
                    }
                }
            } else if (z3) {
                int j2 = hVar.j();
                d3.b(1);
                d5.b(1);
                if (hVar2.w.f2347d == null && hVar2.y.f2347d == null) {
                    if (z) {
                        d5.a(d3, 1, hVar.n());
                    } else {
                        d5.a(d3, j2);
                    }
                } else if (hVar2.w.f2347d == null || hVar2.y.f2347d != null) {
                    if (hVar2.w.f2347d != null || hVar2.y.f2347d == null) {
                        if (hVar2.w.f2347d != null && hVar2.y.f2347d != null) {
                            if (z) {
                                hVar.n().a(d3);
                                hVar.o().a(d5);
                            }
                            if (hVar2.J == 0.0f) {
                                d3.b(3);
                                d5.b(3);
                                d3.b(d5, 0.0f);
                                d5.b(d3, 0.0f);
                                return;
                            }
                            d3.b(2);
                            d5.b(2);
                            d3.b(d5, (float) (-j2));
                            d5.b(d3, (float) j2);
                            hVar2.c(j2);
                            if (hVar2.V > 0) {
                                hVar2.z.d().a(1, d3, hVar2.V);
                            }
                        }
                    } else if (z) {
                        d3.a(d5, -1, hVar.n());
                    } else {
                        d3.a(d5, -j2);
                    }
                } else if (z) {
                    d5.a(d3, 1, hVar.n());
                } else {
                    d5.a(d3, j2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r6.ja == 2) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        if (r6.ka == 2) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ed  */
    static boolean a(i iVar, e eVar, int i2, int i3, d dVar) {
        boolean z;
        boolean z2;
        float f2;
        int i4;
        int i5;
        int i6;
        h hVar;
        int i7;
        e eVar2 = eVar;
        d dVar2 = dVar;
        h hVar2 = dVar2.f2331a;
        h hVar3 = dVar2.f2333c;
        h hVar4 = dVar2.f2332b;
        h hVar5 = dVar2.f2334d;
        h hVar6 = dVar2.f2335e;
        float f3 = dVar2.f2341k;
        h hVar7 = dVar2.f2336f;
        h hVar8 = dVar2.f2337g;
        a aVar = iVar.F[i2];
        a aVar2 = a.WRAP_CONTENT;
        if (i2 == 0) {
            z2 = hVar6.ja == 0;
            z = hVar6.ja == 1;
        } else {
            z2 = hVar6.ka == 0;
            z = hVar6.ka == 1;
        }
        boolean z3 = true;
        h hVar9 = hVar2;
        int i8 = 0;
        boolean z4 = false;
        int i9 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        while (!z4) {
            if (hVar9.t() != 8) {
                i9++;
                if (i2 == 0) {
                    i7 = hVar9.u();
                } else {
                    i7 = hVar9.j();
                }
                f4 += (float) i7;
                if (hVar9 != hVar4) {
                    f4 += (float) hVar9.D[i3].b();
                }
                f5 = f5 + ((float) hVar9.D[i3].b()) + ((float) hVar9.D[i3 + 1].b());
            }
            f fVar = hVar9.D[i3];
            if (hVar9.t() != 8 && hVar9.F[i2] == a.MATCH_CONSTRAINT) {
                i8++;
                if (i2 == 0) {
                    if (hVar9.f2378f != 0) {
                        return false;
                    }
                    if (!(hVar9.f2381i == 0 && hVar9.f2382j == 0)) {
                        return false;
                    }
                } else if (!(hVar9.f2379g == 0 && hVar9.f2384l == 0 && hVar9.m == 0)) {
                    return false;
                }
            }
            f fVar2 = hVar9.D[i3 + 1].f2347d;
            if (fVar2 != null) {
                h hVar10 = fVar2.f2345b;
                f[] fVarArr = hVar10.D;
                i6 = i8;
                if (fVarArr[i3].f2347d != null && fVarArr[i3].f2347d.f2345b == hVar9) {
                    hVar = hVar10;
                    if (hVar == null) {
                        hVar9 = hVar;
                    } else {
                        z4 = true;
                    }
                    i8 = i6;
                }
            } else {
                i6 = i8;
            }
            hVar = null;
            if (hVar == null) {
            }
            i8 = i6;
        }
        q d2 = hVar2.D[i3].d();
        int i10 = i3 + 1;
        q d3 = hVar3.D[i10].d();
        q qVar = d2.f2402e;
        if (qVar != null) {
            h hVar11 = hVar2;
            q qVar2 = d3.f2402e;
            if (qVar2 != null) {
                if (qVar.f2412b != 1 && qVar2.f2412b != 1) {
                    return false;
                }
                if (i8 > 0 && i8 != i9) {
                    return false;
                }
                if (z3 || z2 || z) {
                    f2 = hVar4 != null ? (float) hVar4.D[i3].b() : 0.0f;
                    if (hVar5 != null) {
                        f2 += (float) hVar5.D[i10].b();
                    }
                } else {
                    f2 = 0.0f;
                }
                float f6 = d2.f2402e.f2405h;
                float f7 = d3.f2402e.f2405h;
                float f8 = (f6 < f7 ? f7 - f6 : f6 - f7) - f4;
                if (i8 <= 0 || i8 != i9) {
                    e eVar3 = eVar;
                    if (f8 < f4) {
                        return false;
                    }
                    if (z3) {
                        float k2 = f6 + ((f8 - f2) * hVar11.k());
                        while (hVar4 != null) {
                            f fVar3 = e.f2432b;
                            if (fVar3 != null) {
                                fVar3.z--;
                                fVar3.r++;
                                fVar3.x++;
                            }
                            h hVar12 = hVar4.pa[i2];
                            if (hVar12 != null || hVar4 == hVar5) {
                                if (i2 == 0) {
                                    i5 = hVar4.u();
                                } else {
                                    i5 = hVar4.j();
                                }
                                float f9 = (float) i5;
                                float b2 = k2 + ((float) hVar4.D[i3].b());
                                hVar4.D[i3].d().a(d2.f2404g, b2);
                                float f10 = b2 + f9;
                                hVar4.D[i10].d().a(d2.f2404g, f10);
                                hVar4.D[i3].d().a(eVar3);
                                hVar4.D[i10].d().a(eVar3);
                                k2 = f10 + ((float) hVar4.D[i10].b());
                            }
                            hVar4 = hVar12;
                        }
                    } else if (z2 || z) {
                        if (z2 || z) {
                            f8 -= f2;
                        }
                        float f11 = f8 / ((float) (i9 + 1));
                        if (z) {
                            f11 = f8 / (i9 > 1 ? (float) (i9 - 1) : 2.0f);
                        }
                        float f12 = f6 + f11;
                        if (z && i9 > 1) {
                            f12 = ((float) hVar4.D[i3].b()) + f6;
                        }
                        if (z2 && hVar4 != null) {
                            f12 += (float) hVar4.D[i3].b();
                        }
                        while (hVar4 != null) {
                            f fVar4 = e.f2432b;
                            if (fVar4 != null) {
                                fVar4.z--;
                                fVar4.r++;
                                fVar4.x++;
                            }
                            h hVar13 = hVar4.pa[i2];
                            if (hVar13 != null || hVar4 == hVar5) {
                                if (i2 == 0) {
                                    i4 = hVar4.u();
                                } else {
                                    i4 = hVar4.j();
                                }
                                float f13 = (float) i4;
                                hVar4.D[i3].d().a(d2.f2404g, f12);
                                hVar4.D[i10].d().a(d2.f2404g, f12 + f13);
                                hVar4.D[i3].d().a(eVar3);
                                hVar4.D[i10].d().a(eVar3);
                                f12 += f13 + f11;
                            }
                            hVar4 = hVar13;
                        }
                    }
                    return true;
                } else if (hVar9.m() != null && hVar9.m().F[i2] == a.WRAP_CONTENT) {
                    return false;
                } else {
                    float f14 = (f8 + f4) - f5;
                    if (z2) {
                        f14 -= f5 - f2;
                    }
                    if (z2) {
                        f6 += (float) hVar4.D[i10].b();
                        h hVar14 = hVar4.pa[i2];
                        if (hVar14 != null) {
                            f6 += (float) hVar14.D[i3].b();
                        }
                    }
                    while (hVar4 != null) {
                        f fVar5 = e.f2432b;
                        if (fVar5 != null) {
                            fVar5.z--;
                            fVar5.r++;
                            fVar5.x++;
                        }
                        h hVar15 = hVar4.pa[i2];
                        if (hVar15 != null || hVar4 == hVar5) {
                            float f15 = f14 / ((float) i8);
                            if (f3 > 0.0f) {
                                f15 = (hVar4.na[i2] * f14) / f3;
                            }
                            float b3 = f6 + ((float) hVar4.D[i3].b());
                            hVar4.D[i3].d().a(d2.f2404g, b3);
                            float f16 = b3 + f15;
                            hVar4.D[i10].d().a(d2.f2404g, f16);
                            e eVar4 = eVar;
                            hVar4.D[i3].d().a(eVar4);
                            hVar4.D[i10].d().a(eVar4);
                            f6 = f16 + ((float) hVar4.D[i10].b());
                        } else {
                            e eVar5 = eVar;
                        }
                        hVar4 = hVar15;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
