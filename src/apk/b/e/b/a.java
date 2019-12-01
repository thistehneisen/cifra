package b.e.b;

import java.util.Arrays;

/* compiled from: ArrayLinkedVariables */
public class a {

    /* renamed from: a reason: collision with root package name */
    int f2320a = 0;

    /* renamed from: b reason: collision with root package name */
    private final b f2321b;

    /* renamed from: c reason: collision with root package name */
    private final c f2322c;

    /* renamed from: d reason: collision with root package name */
    private int f2323d = 8;

    /* renamed from: e reason: collision with root package name */
    private i f2324e = null;

    /* renamed from: f reason: collision with root package name */
    private int[] f2325f;

    /* renamed from: g reason: collision with root package name */
    private int[] f2326g;

    /* renamed from: h reason: collision with root package name */
    private float[] f2327h;

    /* renamed from: i reason: collision with root package name */
    private int f2328i;

    /* renamed from: j reason: collision with root package name */
    private int f2329j;

    /* renamed from: k reason: collision with root package name */
    private boolean f2330k;

    a(b bVar, c cVar) {
        int i2 = this.f2323d;
        this.f2325f = new int[i2];
        this.f2326g = new int[i2];
        this.f2327h = new float[i2];
        this.f2328i = -1;
        this.f2329j = -1;
        this.f2330k = false;
        this.f2321b = bVar;
        this.f2322c = cVar;
    }

    public final void a(i iVar, float f2) {
        if (f2 == 0.0f) {
            a(iVar, true);
            return;
        }
        int i2 = this.f2328i;
        if (i2 == -1) {
            this.f2328i = 0;
            float[] fArr = this.f2327h;
            int i3 = this.f2328i;
            fArr[i3] = f2;
            this.f2325f[i3] = iVar.f2459c;
            this.f2326g[i3] = -1;
            iVar.f2467k++;
            iVar.a(this.f2321b);
            this.f2320a++;
            if (!this.f2330k) {
                this.f2329j++;
                int i4 = this.f2329j;
                int[] iArr = this.f2325f;
                if (i4 >= iArr.length) {
                    this.f2330k = true;
                    this.f2329j = iArr.length - 1;
                }
            }
            return;
        }
        int i5 = 0;
        int i6 = -1;
        while (i2 != -1 && i5 < this.f2320a) {
            int[] iArr2 = this.f2325f;
            int i7 = iArr2[i2];
            int i8 = iVar.f2459c;
            if (i7 == i8) {
                this.f2327h[i2] = f2;
                return;
            }
            if (iArr2[i2] < i8) {
                i6 = i2;
            }
            i2 = this.f2326g[i2];
            i5++;
        }
        int i9 = this.f2329j;
        int i10 = i9 + 1;
        if (this.f2330k) {
            int[] iArr3 = this.f2325f;
            if (iArr3[i9] != -1) {
                i9 = iArr3.length;
            }
        } else {
            i9 = i10;
        }
        int[] iArr4 = this.f2325f;
        if (i9 >= iArr4.length && this.f2320a < iArr4.length) {
            int i11 = 0;
            while (true) {
                int[] iArr5 = this.f2325f;
                if (i11 >= iArr5.length) {
                    break;
                } else if (iArr5[i11] == -1) {
                    i9 = i11;
                    break;
                } else {
                    i11++;
                }
            }
        }
        int[] iArr6 = this.f2325f;
        if (i9 >= iArr6.length) {
            i9 = iArr6.length;
            this.f2323d *= 2;
            this.f2330k = false;
            this.f2329j = i9 - 1;
            this.f2327h = Arrays.copyOf(this.f2327h, this.f2323d);
            this.f2325f = Arrays.copyOf(this.f2325f, this.f2323d);
            this.f2326g = Arrays.copyOf(this.f2326g, this.f2323d);
        }
        this.f2325f[i9] = iVar.f2459c;
        this.f2327h[i9] = f2;
        if (i6 != -1) {
            int[] iArr7 = this.f2326g;
            iArr7[i9] = iArr7[i6];
            iArr7[i6] = i9;
        } else {
            this.f2326g[i9] = this.f2328i;
            this.f2328i = i9;
        }
        iVar.f2467k++;
        iVar.a(this.f2321b);
        this.f2320a++;
        if (!this.f2330k) {
            this.f2329j++;
        }
        if (this.f2320a >= this.f2325f.length) {
            this.f2330k = true;
        }
        int i12 = this.f2329j;
        int[] iArr8 = this.f2325f;
        if (i12 >= iArr8.length) {
            this.f2330k = true;
            this.f2329j = iArr8.length - 1;
        }
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        int i2 = this.f2328i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2320a) {
            float[] fArr = this.f2327h;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.f2326g[i2];
            i3++;
        }
    }

    public String toString() {
        int i2 = this.f2328i;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2320a) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" -> ");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(this.f2327h[i2]);
            sb3.append(" : ");
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append(this.f2322c.f2430c[this.f2325f[i2]]);
            str = sb5.toString();
            i2 = this.f2326g[i2];
            i3++;
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    public final float b(int i2) {
        int i3 = this.f2328i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f2320a) {
            if (i4 == i2) {
                return this.f2327h[i3];
            }
            i3 = this.f2326g[i3];
            i4++;
        }
        return 0.0f;
    }

    public final float b(i iVar) {
        int i2 = this.f2328i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2320a) {
            if (this.f2325f[i2] == iVar.f2459c) {
                return this.f2327h[i2];
            }
            i2 = this.f2326g[i2];
            i3++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: 0000 */
    public final void a(i iVar, float f2, boolean z) {
        if (f2 != 0.0f) {
            int i2 = this.f2328i;
            if (i2 == -1) {
                this.f2328i = 0;
                float[] fArr = this.f2327h;
                int i3 = this.f2328i;
                fArr[i3] = f2;
                this.f2325f[i3] = iVar.f2459c;
                this.f2326g[i3] = -1;
                iVar.f2467k++;
                iVar.a(this.f2321b);
                this.f2320a++;
                if (!this.f2330k) {
                    this.f2329j++;
                    int i4 = this.f2329j;
                    int[] iArr = this.f2325f;
                    if (i4 >= iArr.length) {
                        this.f2330k = true;
                        this.f2329j = iArr.length - 1;
                    }
                }
                return;
            }
            int i5 = 0;
            int i6 = -1;
            while (i2 != -1 && i5 < this.f2320a) {
                int[] iArr2 = this.f2325f;
                int i7 = iArr2[i2];
                int i8 = iVar.f2459c;
                if (i7 == i8) {
                    float[] fArr2 = this.f2327h;
                    fArr2[i2] = fArr2[i2] + f2;
                    if (fArr2[i2] == 0.0f) {
                        if (i2 == this.f2328i) {
                            this.f2328i = this.f2326g[i2];
                        } else {
                            int[] iArr3 = this.f2326g;
                            iArr3[i6] = iArr3[i2];
                        }
                        if (z) {
                            iVar.b(this.f2321b);
                        }
                        if (this.f2330k) {
                            this.f2329j = i2;
                        }
                        iVar.f2467k--;
                        this.f2320a--;
                    }
                    return;
                }
                if (iArr2[i2] < i8) {
                    i6 = i2;
                }
                i2 = this.f2326g[i2];
                i5++;
            }
            int i9 = this.f2329j;
            int i10 = i9 + 1;
            if (this.f2330k) {
                int[] iArr4 = this.f2325f;
                if (iArr4[i9] != -1) {
                    i9 = iArr4.length;
                }
            } else {
                i9 = i10;
            }
            int[] iArr5 = this.f2325f;
            if (i9 >= iArr5.length && this.f2320a < iArr5.length) {
                int i11 = 0;
                while (true) {
                    int[] iArr6 = this.f2325f;
                    if (i11 >= iArr6.length) {
                        break;
                    } else if (iArr6[i11] == -1) {
                        i9 = i11;
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            int[] iArr7 = this.f2325f;
            if (i9 >= iArr7.length) {
                i9 = iArr7.length;
                this.f2323d *= 2;
                this.f2330k = false;
                this.f2329j = i9 - 1;
                this.f2327h = Arrays.copyOf(this.f2327h, this.f2323d);
                this.f2325f = Arrays.copyOf(this.f2325f, this.f2323d);
                this.f2326g = Arrays.copyOf(this.f2326g, this.f2323d);
            }
            this.f2325f[i9] = iVar.f2459c;
            this.f2327h[i9] = f2;
            if (i6 != -1) {
                int[] iArr8 = this.f2326g;
                iArr8[i9] = iArr8[i6];
                iArr8[i6] = i9;
            } else {
                this.f2326g[i9] = this.f2328i;
                this.f2328i = i9;
            }
            iVar.f2467k++;
            iVar.a(this.f2321b);
            this.f2320a++;
            if (!this.f2330k) {
                this.f2329j++;
            }
            int i12 = this.f2329j;
            int[] iArr9 = this.f2325f;
            if (i12 >= iArr9.length) {
                this.f2330k = true;
                this.f2329j = iArr9.length - 1;
            }
        }
    }

    public final float a(i iVar, boolean z) {
        if (this.f2324e == iVar) {
            this.f2324e = null;
        }
        int i2 = this.f2328i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f2320a) {
            if (this.f2325f[i2] == iVar.f2459c) {
                if (i2 == this.f2328i) {
                    this.f2328i = this.f2326g[i2];
                } else {
                    int[] iArr = this.f2326g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    iVar.b(this.f2321b);
                }
                iVar.f2467k--;
                this.f2320a--;
                this.f2325f[i2] = -1;
                if (this.f2330k) {
                    this.f2329j = i2;
                }
                return this.f2327h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f2326g[i2];
        }
        return 0.0f;
    }

    public final void a() {
        int i2 = this.f2328i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2320a) {
            i iVar = this.f2322c.f2430c[this.f2325f[i2]];
            if (iVar != null) {
                iVar.b(this.f2321b);
            }
            i2 = this.f2326g[i2];
            i3++;
        }
        this.f2328i = -1;
        this.f2329j = -1;
        this.f2330k = false;
        this.f2320a = 0;
    }

    /* access modifiers changed from: 0000 */
    public final boolean a(i iVar) {
        int i2 = this.f2328i;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2320a) {
            if (this.f2325f[i2] == iVar.f2459c) {
                return true;
            }
            i2 = this.f2326g[i2];
            i3++;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2) {
        int i2 = this.f2328i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2320a) {
            float[] fArr = this.f2327h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f2326g[i2];
            i3++;
        }
    }

    private boolean a(i iVar, e eVar) {
        return iVar.f2467k <= 1;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008f A[SYNTHETIC] */
    public i a(e eVar) {
        boolean a2;
        boolean a3;
        int i2 = this.f2328i;
        i iVar = null;
        int i3 = 0;
        i iVar2 = null;
        float f2 = 0.0f;
        boolean z = false;
        float f3 = 0.0f;
        boolean z2 = false;
        while (i2 != -1 && i3 < this.f2320a) {
            float[] fArr = this.f2327h;
            float f4 = fArr[i2];
            i iVar3 = this.f2322c.f2430c[this.f2325f[i2]];
            if (f4 < 0.0f) {
                if (f4 > -0.001f) {
                    fArr[i2] = 0.0f;
                    iVar3.b(this.f2321b);
                }
                if (f4 != 0.0f) {
                    if (iVar3.f2464h == b.e.b.i.a.UNRESTRICTED) {
                        if (iVar2 == null) {
                            a3 = a(iVar3, eVar);
                        } else if (f2 > f4) {
                            a3 = a(iVar3, eVar);
                        } else if (!z && a(iVar3, eVar)) {
                            f2 = f4;
                            iVar2 = iVar3;
                            z = true;
                        }
                        z = a3;
                        f2 = f4;
                        iVar2 = iVar3;
                    } else if (iVar2 == null && f4 < 0.0f) {
                        if (iVar == null) {
                            a2 = a(iVar3, eVar);
                        } else if (f3 > f4) {
                            a2 = a(iVar3, eVar);
                        } else if (!z2 && a(iVar3, eVar)) {
                            f3 = f4;
                            iVar = iVar3;
                            z2 = true;
                        }
                        z2 = a2;
                        f3 = f4;
                        iVar = iVar3;
                    }
                }
                i2 = this.f2326g[i2];
                i3++;
            } else {
                if (f4 < 0.001f) {
                    fArr[i2] = 0.0f;
                    iVar3.b(this.f2321b);
                }
                if (f4 != 0.0f) {
                }
                i2 = this.f2326g[i2];
                i3++;
            }
            f4 = 0.0f;
            if (f4 != 0.0f) {
            }
            i2 = this.f2326g[i2];
            i3++;
        }
        return iVar2 != null ? iVar2 : iVar;
    }

    /* access modifiers changed from: 0000 */
    public final void a(b bVar, b bVar2, boolean z) {
        int i2 = this.f2328i;
        while (true) {
            int i3 = 0;
            while (i2 != -1 && i3 < this.f2320a) {
                int i4 = this.f2325f[i2];
                i iVar = bVar2.f2423a;
                if (i4 == iVar.f2459c) {
                    float f2 = this.f2327h[i2];
                    a(iVar, z);
                    a aVar = bVar2.f2426d;
                    int i5 = aVar.f2328i;
                    int i6 = 0;
                    while (i5 != -1 && i6 < aVar.f2320a) {
                        a(this.f2322c.f2430c[aVar.f2325f[i5]], aVar.f2327h[i5] * f2, z);
                        i5 = aVar.f2326g[i5];
                        i6++;
                    }
                    bVar.f2424b += bVar2.f2424b * f2;
                    if (z) {
                        bVar2.f2423a.b(bVar);
                    }
                    i2 = this.f2328i;
                } else {
                    i2 = this.f2326g[i2];
                    i3++;
                }
            }
            return;
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar, b[] bVarArr) {
        int i2 = this.f2328i;
        while (true) {
            int i3 = 0;
            while (i2 != -1 && i3 < this.f2320a) {
                i iVar = this.f2322c.f2430c[this.f2325f[i2]];
                if (iVar.f2460d != -1) {
                    float f2 = this.f2327h[i2];
                    a(iVar, true);
                    b bVar2 = bVarArr[iVar.f2460d];
                    if (!bVar2.f2427e) {
                        a aVar = bVar2.f2426d;
                        int i4 = aVar.f2328i;
                        int i5 = 0;
                        while (i4 != -1 && i5 < aVar.f2320a) {
                            a(this.f2322c.f2430c[aVar.f2325f[i4]], aVar.f2327h[i4] * f2, true);
                            i4 = aVar.f2326g[i4];
                            i5++;
                        }
                    }
                    bVar.f2424b += bVar2.f2424b * f2;
                    bVar2.f2423a.b(bVar);
                    i2 = this.f2328i;
                } else {
                    i2 = this.f2326g[i2];
                    i3++;
                }
            }
            return;
        }
    }

    /* access modifiers changed from: 0000 */
    public i a(boolean[] zArr, i iVar) {
        int i2 = this.f2328i;
        int i3 = 0;
        i iVar2 = null;
        float f2 = 0.0f;
        while (i2 != -1 && i3 < this.f2320a) {
            if (this.f2327h[i2] < 0.0f) {
                i iVar3 = this.f2322c.f2430c[this.f2325f[i2]];
                if ((zArr == null || !zArr[iVar3.f2459c]) && iVar3 != iVar) {
                    b.e.b.i.a aVar = iVar3.f2464h;
                    if (aVar == b.e.b.i.a.SLACK || aVar == b.e.b.i.a.ERROR) {
                        float f3 = this.f2327h[i2];
                        if (f3 < f2) {
                            iVar2 = iVar3;
                            f2 = f3;
                        }
                    }
                }
            }
            i2 = this.f2326g[i2];
            i3++;
        }
        return iVar2;
    }

    /* access modifiers changed from: 0000 */
    public final i a(int i2) {
        int i3 = this.f2328i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f2320a) {
            if (i4 == i2) {
                return this.f2322c.f2430c[this.f2325f[i3]];
            }
            i3 = this.f2326g[i3];
            i4++;
        }
        return null;
    }
}
