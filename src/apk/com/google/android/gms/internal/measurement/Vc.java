package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.d;
import java.io.IOException;
import java.util.Arrays;

public final class Vc {

    /* renamed from: a reason: collision with root package name */
    private static final Vc f5061a = new Vc(0, new int[0], new Object[0], false);

    /* renamed from: b reason: collision with root package name */
    private int f5062b;

    /* renamed from: c reason: collision with root package name */
    private int[] f5063c;

    /* renamed from: d reason: collision with root package name */
    private Object[] f5064d;

    /* renamed from: e reason: collision with root package name */
    private int f5065e;

    /* renamed from: f reason: collision with root package name */
    private boolean f5066f;

    private Vc() {
        this(0, new int[8], new Object[8], true);
    }

    static Vc a(Vc vc, Vc vc2) {
        int i2 = vc.f5062b + vc2.f5062b;
        int[] copyOf = Arrays.copyOf(vc.f5063c, i2);
        System.arraycopy(vc2.f5063c, 0, copyOf, vc.f5062b, vc2.f5062b);
        Object[] copyOf2 = Arrays.copyOf(vc.f5064d, i2);
        System.arraycopy(vc2.f5064d, 0, copyOf2, vc.f5062b, vc2.f5062b);
        return new Vc(i2, copyOf, copyOf2, true);
    }

    public static Vc c() {
        return f5061a;
    }

    static Vc d() {
        return new Vc();
    }

    public final void b(C0419pd pdVar) throws IOException {
        if (this.f5062b != 0) {
            if (pdVar.a() == d.f4926l) {
                for (int i2 = 0; i2 < this.f5062b; i2++) {
                    a(this.f5063c[i2], this.f5064d[i2], pdVar);
                }
                return;
            }
            for (int i3 = this.f5062b - 1; i3 >= 0; i3--) {
                a(this.f5063c[i3], this.f5064d[i3], pdVar);
            }
        }
    }

    public final int e() {
        int i2 = this.f5065e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f5062b; i4++) {
            i3 += zzee.d(this.f5063c[i4] >>> 3, (Xa) this.f5064d[i4]);
        }
        this.f5065e = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Vc)) {
            return false;
        }
        Vc vc = (Vc) obj;
        int i2 = this.f5062b;
        if (i2 == vc.f5062b) {
            int[] iArr = this.f5063c;
            int[] iArr2 = vc.f5063c;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    z = true;
                    break;
                } else if (iArr[i3] != iArr2[i3]) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                Object[] objArr = this.f5064d;
                Object[] objArr2 = vc.f5064d;
                int i4 = this.f5062b;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        z2 = true;
                        break;
                    } else if (!objArr[i5].equals(objArr2[i5])) {
                        z2 = false;
                        break;
                    } else {
                        i5++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i2 = this.f5062b;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f5063c;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f5064d;
        for (int i8 = 0; i8 < this.f5062b; i8++) {
            i4 = (i4 * 31) + objArr[i8].hashCode();
        }
        return i7 + i4;
    }

    private Vc(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f5065e = -1;
        this.f5062b = i2;
        this.f5063c = iArr;
        this.f5064d = objArr;
        this.f5066f = z;
    }

    public final void a() {
        this.f5066f = false;
    }

    public final int b() {
        int i2;
        int i3 = this.f5065e;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f5062b; i5++) {
            int i6 = this.f5063c[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 == 0) {
                i2 = zzee.e(i7, ((Long) this.f5064d[i5]).longValue());
            } else if (i8 == 1) {
                i2 = zzee.g(i7, ((Long) this.f5064d[i5]).longValue());
            } else if (i8 == 2) {
                i2 = zzee.c(i7, (Xa) this.f5064d[i5]);
            } else if (i8 == 3) {
                i2 = (zzee.e(i7) << 1) + ((Vc) this.f5064d[i5]).b();
            } else if (i8 == 5) {
                i2 = zzee.i(i7, ((Integer) this.f5064d[i5]).intValue());
            } else {
                throw new IllegalStateException(zzfi.f());
            }
            i4 += i2;
        }
        this.f5065e = i4;
        return i4;
    }

    /* access modifiers changed from: 0000 */
    public final void a(C0419pd pdVar) throws IOException {
        if (pdVar.a() == d.m) {
            for (int i2 = this.f5062b - 1; i2 >= 0; i2--) {
                pdVar.a(this.f5063c[i2] >>> 3, this.f5064d[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.f5062b; i3++) {
            pdVar.a(this.f5063c[i3] >>> 3, this.f5064d[i3]);
        }
    }

    private static void a(int i2, Object obj, C0419pd pdVar) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            pdVar.d(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            pdVar.c(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            pdVar.a(i3, (Xa) obj);
        } else if (i4 != 3) {
            if (i4 == 5) {
                pdVar.c(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzfi.f());
        } else if (pdVar.a() == d.f4926l) {
            pdVar.a(i3);
            ((Vc) obj).b(pdVar);
            pdVar.b(i3);
        } else {
            pdVar.b(i3);
            ((Vc) obj).b(pdVar);
            pdVar.a(i3);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f5062b; i3++) {
            C0406nc.a(sb, i2, String.valueOf(this.f5063c[i3] >>> 3), this.f5064d[i3]);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(int i2, Object obj) {
        if (this.f5066f) {
            int i3 = this.f5062b;
            if (i3 == this.f5063c.length) {
                int i4 = this.f5062b + (i3 < 4 ? 8 : i3 >> 1);
                this.f5063c = Arrays.copyOf(this.f5063c, i4);
                this.f5064d = Arrays.copyOf(this.f5064d, i4);
            }
            int[] iArr = this.f5063c;
            int i5 = this.f5062b;
            iArr[i5] = i2;
            this.f5064d[i5] = obj;
            this.f5062b = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
