package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ud reason: case insensitive filesystem */
public final class C0448ud implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    private static final C0442td f5392a = new C0442td();

    /* renamed from: b reason: collision with root package name */
    private boolean f5393b;

    /* renamed from: c reason: collision with root package name */
    private int[] f5394c;

    /* renamed from: d reason: collision with root package name */
    private C0442td[] f5395d;

    /* renamed from: e reason: collision with root package name */
    private int f5396e;

    C0448ud() {
        this(10);
    }

    private static int c(int i2) {
        int i3 = i2 << 2;
        int i4 = 4;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            int i5 = (1 << i4) - 12;
            if (i3 <= i5) {
                i3 = i5;
                break;
            }
            i4++;
        }
        return i3 / 4;
    }

    private final int d(int i2) {
        int i3 = this.f5396e - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = this.f5394c[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    /* access modifiers changed from: 0000 */
    public final C0442td a(int i2) {
        int d2 = d(i2);
        if (d2 >= 0) {
            C0442td[] tdVarArr = this.f5395d;
            if (tdVarArr[d2] != f5392a) {
                return tdVarArr[d2];
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final int b() {
        return this.f5396e;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i2 = this.f5396e;
        C0448ud udVar = new C0448ud(i2);
        System.arraycopy(this.f5394c, 0, udVar.f5394c, 0, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            C0442td[] tdVarArr = this.f5395d;
            if (tdVarArr[i3] != null) {
                udVar.f5395d[i3] = (C0442td) tdVarArr[i3].clone();
            }
        }
        udVar.f5396e = i2;
        return udVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0448ud)) {
            return false;
        }
        C0448ud udVar = (C0448ud) obj;
        int i2 = this.f5396e;
        if (i2 != udVar.f5396e) {
            return false;
        }
        int[] iArr = this.f5394c;
        int[] iArr2 = udVar.f5394c;
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
            C0442td[] tdVarArr = this.f5395d;
            C0442td[] tdVarArr2 = udVar.f5395d;
            int i4 = this.f5396e;
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    z2 = true;
                    break;
                } else if (!tdVarArr[i5].equals(tdVarArr2[i5])) {
                    z2 = false;
                    break;
                } else {
                    i5++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = 17;
        for (int i3 = 0; i3 < this.f5396e; i3++) {
            i2 = (((i2 * 31) + this.f5394c[i3]) * 31) + this.f5395d[i3].hashCode();
        }
        return i2;
    }

    private C0448ud(int i2) {
        this.f5393b = false;
        int c2 = c(i2);
        this.f5394c = new int[c2];
        this.f5395d = new C0442td[c2];
        this.f5396e = 0;
    }

    /* access modifiers changed from: 0000 */
    public final C0442td b(int i2) {
        return this.f5395d[i2];
    }

    /* access modifiers changed from: 0000 */
    public final void a(int i2, C0442td tdVar) {
        int d2 = d(i2);
        if (d2 >= 0) {
            this.f5395d[d2] = tdVar;
            return;
        }
        int i3 = ~d2;
        if (i3 < this.f5396e) {
            C0442td[] tdVarArr = this.f5395d;
            if (tdVarArr[i3] == f5392a) {
                this.f5394c[i3] = i2;
                tdVarArr[i3] = tdVar;
                return;
            }
        }
        int i4 = this.f5396e;
        if (i4 >= this.f5394c.length) {
            int c2 = c(i4 + 1);
            int[] iArr = new int[c2];
            C0442td[] tdVarArr2 = new C0442td[c2];
            int[] iArr2 = this.f5394c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            C0442td[] tdVarArr3 = this.f5395d;
            System.arraycopy(tdVarArr3, 0, tdVarArr2, 0, tdVarArr3.length);
            this.f5394c = iArr;
            this.f5395d = tdVarArr2;
        }
        int i5 = this.f5396e;
        if (i5 - i3 != 0) {
            int[] iArr3 = this.f5394c;
            int i6 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i6, i5 - i3);
            C0442td[] tdVarArr4 = this.f5395d;
            System.arraycopy(tdVarArr4, i3, tdVarArr4, i6, this.f5396e - i3);
        }
        this.f5394c[i3] = i2;
        this.f5395d[i3] = tdVar;
        this.f5396e++;
    }

    public final boolean a() {
        return this.f5396e == 0;
    }
}
