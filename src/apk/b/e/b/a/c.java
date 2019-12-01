package b.e.b.a;

import b.e.b.a.h.a;
import b.e.b.b;
import b.e.b.e;
import b.e.b.i;
import java.util.ArrayList;

/* compiled from: Chain */
class c {
    static void a(i iVar, e eVar, int i2) {
        int i3;
        d[] dVarArr;
        int i4;
        if (i2 == 0) {
            int i5 = iVar.Aa;
            dVarArr = iVar.Da;
            i3 = i5;
            i4 = 0;
        } else {
            i4 = 2;
            int i6 = iVar.Ba;
            i3 = i6;
            dVarArr = iVar.Ca;
        }
        for (int i7 = 0; i7 < i3; i7++) {
            d dVar = dVarArr[i7];
            dVar.a();
            if (!iVar.p(4)) {
                a(iVar, eVar, i2, i4, dVar);
            } else if (!o.a(iVar, eVar, i2, i4, dVar)) {
                a(iVar, eVar, i2, i4, dVar);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r20v1 */
    /* JADX WARNING: type inference failed for: r4v11, types: [b.e.b.i] */
    /* JADX WARNING: type inference failed for: r20v2 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v13, types: [b.e.b.i] */
    /* JADX WARNING: type inference failed for: r4v44 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.ja == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r2.ka == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x041e  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0474  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0477  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x047d  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0480  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0484  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0493  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x016b  */
    /* JADX WARNING: Unknown variable types count: 3 */
    static void a(i iVar, e eVar, int i2, int i3, d dVar) {
        boolean z;
        boolean z2;
        h hVar;
        ArrayList<h> arrayList;
        i iVar2;
        i iVar3;
        h hVar2;
        f fVar;
        f fVar2;
        f fVar3;
        h hVar3;
        h hVar4;
        i iVar4;
        i iVar5;
        f fVar4;
        i iVar6;
        i iVar7;
        f fVar5;
        float f2;
        ArrayList<h> arrayList2;
        int i4;
        float f3;
        boolean z3;
        int i5;
        h hVar5;
        boolean z4;
        int i6;
        i iVar8 = iVar;
        e eVar2 = eVar;
        d dVar2 = dVar;
        h hVar6 = dVar2.f2331a;
        h hVar7 = dVar2.f2333c;
        h hVar8 = dVar2.f2332b;
        h hVar9 = dVar2.f2334d;
        h hVar10 = dVar2.f2335e;
        float f4 = dVar2.f2341k;
        h hVar11 = dVar2.f2336f;
        h hVar12 = dVar2.f2337g;
        boolean z5 = iVar8.F[i2] == a.WRAP_CONTENT;
        if (i2 == 0) {
            z2 = hVar10.ja == 0;
            z = hVar10.ja == 1;
        } else {
            z2 = hVar10.ka == 0;
            z = hVar10.ka == 1;
        }
        boolean z6 = true;
        boolean z7 = z2;
        h hVar13 = hVar6;
        boolean z8 = z;
        boolean z9 = z6;
        boolean z10 = false;
        while (true) {
            hVar = 0;
            if (z10) {
                break;
            }
            f fVar6 = hVar13.D[i3];
            int i7 = (z5 || z9) ? 1 : 4;
            int b2 = fVar6.b();
            f fVar7 = fVar6.f2347d;
            if (!(fVar7 == null || hVar13 == hVar6)) {
                b2 += fVar7.b();
            }
            int i8 = b2;
            if (z9 && hVar13 != hVar6 && hVar13 != hVar8) {
                f3 = f4;
                z3 = z10;
                i5 = 6;
            } else if (!z7 || !z5) {
                f3 = f4;
                i5 = i7;
                z3 = z10;
            } else {
                f3 = f4;
                z3 = z10;
                i5 = 4;
            }
            f fVar8 = fVar6.f2347d;
            if (fVar8 != null) {
                if (hVar13 == hVar8) {
                    z4 = z7;
                    hVar5 = hVar10;
                    eVar2.b(fVar6.f2353j, fVar8.f2353j, i8, 5);
                } else {
                    hVar5 = hVar10;
                    z4 = z7;
                    eVar2.b(fVar6.f2353j, fVar8.f2353j, i8, 6);
                }
                eVar2.a(fVar6.f2353j, fVar6.f2347d.f2353j, i8, i5);
            } else {
                hVar5 = hVar10;
                z4 = z7;
            }
            if (z5) {
                if (hVar13.t() == 8 || hVar13.F[i2] != a.MATCH_CONSTRAINT) {
                    i6 = 0;
                } else {
                    f[] fVarArr = hVar13.D;
                    i6 = 0;
                    eVar2.b(fVarArr[i3 + 1].f2353j, fVarArr[i3].f2353j, 0, 5);
                }
                eVar2.b(hVar13.D[i3].f2353j, iVar8.D[i3].f2353j, i6, 6);
            }
            f fVar9 = hVar13.D[i3 + 1].f2347d;
            if (fVar9 != null) {
                h hVar14 = fVar9.f2345b;
                f[] fVarArr2 = hVar14.D;
                if (fVarArr2[i3].f2347d != null && fVarArr2[i3].f2347d.f2345b == hVar13) {
                    hVar = hVar14;
                }
            }
            if (hVar != null) {
                hVar13 = hVar;
                z10 = z3;
            } else {
                z10 = true;
            }
            f4 = f3;
            z7 = z4;
            hVar10 = hVar5;
        }
        h hVar15 = hVar10;
        float f5 = f4;
        boolean z11 = z7;
        if (hVar9 != null) {
            f[] fVarArr3 = hVar7.D;
            int i9 = i3 + 1;
            if (fVarArr3[i9].f2347d != null) {
                f fVar10 = hVar9.D[i9];
                eVar2.c(fVar10.f2353j, fVarArr3[i9].f2347d.f2353j, -fVar10.b(), 5);
                if (z5) {
                    int i10 = i3 + 1;
                    i iVar9 = iVar8.D[i10].f2353j;
                    f[] fVarArr4 = hVar7.D;
                    eVar2.b(iVar9, fVarArr4[i10].f2353j, fVarArr4[i10].b(), 6);
                }
                arrayList = dVar2.f2338h;
                if (arrayList != null) {
                    int size = arrayList.size();
                    if (size > 1) {
                        float f6 = (!dVar2.n || dVar2.p) ? f5 : (float) dVar2.f2340j;
                        float f7 = 0.0f;
                        h hVar16 = null;
                        int i11 = 0;
                        float f8 = 0.0f;
                        while (i11 < size) {
                            h hVar17 = (h) arrayList.get(i11);
                            float f9 = hVar17.na[i2];
                            if (f9 < f7) {
                                if (dVar2.p) {
                                    f[] fVarArr5 = hVar17.D;
                                    eVar2.a(fVarArr5[i3 + 1].f2353j, fVarArr5[i3].f2353j, 0, 4);
                                    arrayList2 = arrayList;
                                    i4 = size;
                                    i11++;
                                    size = i4;
                                    arrayList = arrayList2;
                                    f7 = 0.0f;
                                } else {
                                    f9 = 1.0f;
                                    f7 = 0.0f;
                                }
                            }
                            if (f9 == f7) {
                                f[] fVarArr6 = hVar17.D;
                                eVar2.a(fVarArr6[i3 + 1].f2353j, fVarArr6[i3].f2353j, 0, 6);
                                arrayList2 = arrayList;
                                i4 = size;
                                i11++;
                                size = i4;
                                arrayList = arrayList2;
                                f7 = 0.0f;
                            } else {
                                if (hVar16 != null) {
                                    f[] fVarArr7 = hVar16.D;
                                    i iVar10 = fVarArr7[i3].f2353j;
                                    int i12 = i3 + 1;
                                    i iVar11 = fVarArr7[i12].f2353j;
                                    f[] fVarArr8 = hVar17.D;
                                    arrayList2 = arrayList;
                                    i iVar12 = fVarArr8[i3].f2353j;
                                    i iVar13 = fVarArr8[i12].f2353j;
                                    i4 = size;
                                    b b3 = eVar.b();
                                    b3.a(f8, f6, f9, iVar10, iVar11, iVar12, iVar13);
                                    eVar2.a(b3);
                                } else {
                                    arrayList2 = arrayList;
                                    i4 = size;
                                }
                                f8 = f9;
                                hVar16 = hVar17;
                                i11++;
                                size = i4;
                                arrayList = arrayList2;
                                f7 = 0.0f;
                            }
                        }
                    }
                }
                if (hVar8 == null && (hVar8 == hVar9 || z9)) {
                    f[] fVarArr9 = hVar6.D;
                    f fVar11 = fVarArr9[i3];
                    int i13 = i3 + 1;
                    f fVar12 = hVar7.D[i13];
                    i iVar14 = fVarArr9[i3].f2347d != null ? fVarArr9[i3].f2347d.f2353j : null;
                    f[] fVarArr10 = hVar7.D;
                    i iVar15 = fVarArr10[i13].f2347d != null ? fVarArr10[i13].f2347d.f2353j : null;
                    if (hVar8 == hVar9) {
                        f[] fVarArr11 = hVar8.D;
                        fVar11 = fVarArr11[i3];
                        fVar12 = fVarArr11[i13];
                    }
                    if (!(iVar14 == null || iVar15 == null)) {
                        if (i2 == 0) {
                            f2 = hVar15.aa;
                        } else {
                            f2 = hVar15.ba;
                        }
                        eVar.a(fVar11.f2353j, iVar14, fVar11.b(), f2, iVar15, fVar12.f2353j, fVar12.b(), 5);
                    }
                } else if (!z11 && hVar8 != null) {
                    int i14 = dVar2.f2340j;
                    boolean z12 = i14 > 0 && dVar2.f2339i == i14;
                    h hVar18 = hVar8;
                    h hVar19 = hVar18;
                    while (hVar19 != null) {
                        h hVar20 = hVar19.pa[i2];
                        if (hVar20 != null || hVar19 == hVar9) {
                            f fVar13 = hVar19.D[i3];
                            i iVar16 = fVar13.f2353j;
                            f fVar14 = fVar13.f2347d;
                            i iVar17 = fVar14 != null ? fVar14.f2353j : null;
                            if (hVar18 != hVar19) {
                                iVar17 = hVar18.D[i3 + 1].f2353j;
                            } else if (hVar19 == hVar8 && hVar18 == hVar19) {
                                f[] fVarArr12 = hVar6.D;
                                iVar17 = fVarArr12[i3].f2347d != null ? fVarArr12[i3].f2347d.f2353j : null;
                            }
                            int b4 = fVar13.b();
                            int i15 = i3 + 1;
                            int b5 = hVar19.D[i15].b();
                            if (hVar20 != null) {
                                fVar5 = hVar20.D[i3];
                                iVar7 = fVar5.f2353j;
                                iVar6 = hVar19.D[i15].f2353j;
                            } else {
                                fVar5 = hVar7.D[i15].f2347d;
                                iVar7 = fVar5 != null ? fVar5.f2353j : null;
                                iVar6 = hVar19.D[i15].f2353j;
                            }
                            if (fVar5 != null) {
                                b5 += fVar5.b();
                            }
                            if (hVar18 != null) {
                                b4 += hVar18.D[i15].b();
                            }
                            if (!(iVar16 == null || iVar17 == null || iVar7 == null || iVar6 == null)) {
                                eVar.a(iVar16, iVar17, hVar19 == hVar8 ? hVar8.D[i3].b() : b4, 0.5f, iVar7, iVar6, hVar19 == hVar9 ? hVar9.D[i15].b() : b5, z12 ? 6 : 4);
                                hVar18 = hVar19;
                                hVar19 = hVar20;
                            }
                        }
                        hVar18 = hVar19;
                        hVar19 = hVar20;
                    }
                } else if (z8 && hVar8 != null) {
                    int i16 = dVar2.f2340j;
                    boolean z13 = i16 <= 0 && dVar2.f2339i == i16;
                    h hVar21 = hVar8;
                    hVar2 = hVar21;
                    while (hVar2 != null) {
                        h hVar22 = hVar2.pa[i2];
                        if (hVar2 == hVar8 || hVar2 == hVar9 || hVar22 == null) {
                            hVar3 = hVar2;
                            hVar4 = hVar22;
                        } else {
                            hVar4 = hVar22 == hVar9 ? null : hVar22;
                            f fVar15 = hVar2.D[i3];
                            i iVar18 = fVar15.f2353j;
                            f fVar16 = fVar15.f2347d;
                            if (fVar16 != null) {
                                i iVar19 = fVar16.f2353j;
                            }
                            int i17 = i3 + 1;
                            i iVar20 = hVar21.D[i17].f2353j;
                            int b6 = fVar15.b();
                            int b7 = hVar2.D[i17].b();
                            if (hVar4 != null) {
                                fVar4 = hVar4.D[i3];
                                iVar5 = fVar4.f2353j;
                                f fVar17 = fVar4.f2347d;
                                iVar4 = fVar17 != null ? fVar17.f2353j : null;
                            } else {
                                fVar4 = hVar2.D[i17].f2347d;
                                iVar5 = fVar4 != null ? fVar4.f2353j : null;
                                iVar4 = hVar2.D[i17].f2353j;
                            }
                            if (fVar4 != null) {
                                b7 += fVar4.b();
                            }
                            int i18 = b7;
                            if (hVar21 != null) {
                                b6 += hVar21.D[i17].b();
                            }
                            int i19 = b6;
                            int i20 = z13 ? 6 : 4;
                            if (iVar18 == null || iVar20 == null || iVar5 == null || iVar4 == null) {
                                hVar3 = hVar2;
                            } else {
                                hVar3 = hVar2;
                                eVar.a(iVar18, iVar20, i19, 0.5f, iVar5, iVar4, i18, i20);
                            }
                        }
                        hVar21 = hVar3;
                        hVar2 = hVar4;
                    }
                    f fVar18 = hVar8.D[i3];
                    fVar = hVar6.D[i3].f2347d;
                    int i21 = i3 + 1;
                    fVar2 = hVar9.D[i21];
                    fVar3 = hVar7.D[i21].f2347d;
                    if (fVar != null) {
                        if (hVar8 != hVar9) {
                            eVar2.a(fVar18.f2353j, fVar.f2353j, fVar18.b(), 5);
                        } else if (fVar3 != null) {
                            eVar.a(fVar18.f2353j, fVar.f2353j, fVar18.b(), 0.5f, fVar2.f2353j, fVar3.f2353j, fVar2.b(), 5);
                        }
                    }
                    if (!(fVar3 == null || hVar8 == hVar9)) {
                        eVar2.a(fVar2.f2353j, fVar3.f2353j, -fVar2.b(), 5);
                    }
                }
                if ((!z11 || z8) && hVar8 != null) {
                    f fVar19 = hVar8.D[i3];
                    int i22 = i3 + 1;
                    f fVar20 = hVar9.D[i22];
                    f fVar21 = fVar19.f2347d;
                    iVar2 = fVar21 == null ? fVar21.f2353j : null;
                    f fVar22 = fVar20.f2347d;
                    ? r4 = fVar22 == null ? fVar22.f2353j : 0;
                    if (hVar7 == hVar9) {
                        f fVar23 = hVar7.D[i22].f2347d;
                        if (fVar23 != null) {
                            hVar = fVar23.f2353j;
                        }
                        iVar3 = hVar;
                    } else {
                        iVar3 = r4;
                    }
                    if (hVar8 == hVar9) {
                        f[] fVarArr13 = hVar8.D;
                        f fVar24 = fVarArr13[i3];
                        fVar20 = fVarArr13[i22];
                        fVar19 = fVar24;
                    }
                    if (iVar2 != null && iVar3 != 0) {
                        int b8 = fVar19.b();
                        if (hVar9 != null) {
                            hVar7 = hVar9;
                        }
                        eVar.a(fVar19.f2353j, iVar2, b8, 0.5f, iVar3, fVar20.f2353j, hVar7.D[i22].b(), 5);
                        return;
                    }
                }
                return;
            }
        }
        if (z5) {
        }
        arrayList = dVar2.f2338h;
        if (arrayList != null) {
        }
        if (hVar8 == null) {
        }
        if (!z11) {
        }
        int i162 = dVar2.f2340j;
        if (i162 <= 0) {
        }
        h hVar212 = hVar8;
        hVar2 = hVar212;
        while (hVar2 != null) {
        }
        f fVar182 = hVar8.D[i3];
        fVar = hVar6.D[i3].f2347d;
        int i212 = i3 + 1;
        fVar2 = hVar9.D[i212];
        fVar3 = hVar7.D[i212].f2347d;
        if (fVar != null) {
        }
        eVar2.a(fVar2.f2353j, fVar3.f2353j, -fVar2.b(), 5);
        if (!z11) {
        }
        f fVar192 = hVar8.D[i3];
        int i222 = i3 + 1;
        f fVar202 = hVar9.D[i222];
        f fVar212 = fVar192.f2347d;
        if (fVar212 == null) {
        }
        f fVar222 = fVar202.f2347d;
        if (fVar222 == null) {
        }
        if (hVar7 == hVar9) {
        }
        if (hVar8 == hVar9) {
        }
        if (iVar2 != null) {
        }
    }
}
