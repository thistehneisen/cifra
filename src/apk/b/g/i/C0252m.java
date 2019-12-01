package b.g.i;

import android.view.View;
import android.view.ViewParent;

/* renamed from: b.g.i.m reason: case insensitive filesystem */
/* compiled from: NestedScrollingChildHelper */
public class C0252m {

    /* renamed from: a reason: collision with root package name */
    private ViewParent f2716a;

    /* renamed from: b reason: collision with root package name */
    private ViewParent f2717b;

    /* renamed from: c reason: collision with root package name */
    private final View f2718c;

    /* renamed from: d reason: collision with root package name */
    private boolean f2719d;

    /* renamed from: e reason: collision with root package name */
    private int[] f2720e;

    public C0252m(View view) {
        this.f2718c = view;
    }

    private ViewParent d(int i2) {
        if (i2 == 0) {
            return this.f2716a;
        }
        if (i2 != 1) {
            return null;
        }
        return this.f2717b;
    }

    public void a(boolean z) {
        if (this.f2719d) {
            B.I(this.f2718c);
        }
        this.f2719d = z;
    }

    public boolean b() {
        return this.f2719d;
    }

    public void c() {
        c(0);
    }

    public boolean b(int i2) {
        return a(i2, 0);
    }

    public void c(int i2) {
        ViewParent d2 = d(i2);
        if (d2 != null) {
            H.a(d2, this.f2718c, i2);
            a(i2, (ViewParent) null);
        }
    }

    private boolean b(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        int i7;
        int i8;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (b()) {
            ViewParent d2 = d(i6);
            if (d2 == null) {
                return false;
            }
            if (i2 != 0 || i3 != 0 || i4 != 0 || i5 != 0) {
                if (iArr4 != null) {
                    this.f2718c.getLocationInWindow(iArr4);
                    i8 = iArr4[0];
                    i7 = iArr4[1];
                } else {
                    i8 = 0;
                    i7 = 0;
                }
                if (iArr2 == null) {
                    int[] d3 = d();
                    d3[0] = 0;
                    d3[1] = 0;
                    iArr3 = d3;
                } else {
                    iArr3 = iArr2;
                }
                H.a(d2, this.f2718c, i2, i3, i4, i5, i6, iArr3);
                if (iArr4 != null) {
                    this.f2718c.getLocationInWindow(iArr4);
                    iArr4[0] = iArr4[0] - i8;
                    iArr4[1] = iArr4[1] - i7;
                }
                return true;
            } else if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
        }
        return false;
    }

    private int[] d() {
        if (this.f2720e == null) {
            this.f2720e = new int[2];
        }
        return this.f2720e;
    }

    public boolean a() {
        return a(0);
    }

    public boolean a(int i2) {
        return d(i2) != null;
    }

    public boolean a(int i2, int i3) {
        if (a(i3)) {
            return true;
        }
        if (b()) {
            View view = this.f2718c;
            for (ViewParent parent = this.f2718c.getParent(); parent != null; parent = parent.getParent()) {
                if (H.b(parent, view, this.f2718c, i2, i3)) {
                    a(i3, parent);
                    H.a(parent, view, this.f2718c, i2, i3);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr) {
        return b(i2, i3, i4, i5, iArr, 0, null);
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return b(i2, i3, i4, i5, iArr, i6, null);
    }

    public void a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        b(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2) {
        return a(i2, i3, iArr, iArr2, 0);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        int i5;
        int i6;
        if (b()) {
            ViewParent d2 = d(i4);
            if (d2 == null) {
                return false;
            }
            boolean z = true;
            if (i2 != 0 || i3 != 0) {
                if (iArr2 != null) {
                    this.f2718c.getLocationInWindow(iArr2);
                    i6 = iArr2[0];
                    i5 = iArr2[1];
                } else {
                    i6 = 0;
                    i5 = 0;
                }
                if (iArr == null) {
                    iArr = d();
                }
                iArr[0] = 0;
                iArr[1] = 0;
                H.a(d2, this.f2718c, i2, i3, iArr, i4);
                if (iArr2 != null) {
                    this.f2718c.getLocationInWindow(iArr2);
                    iArr2[0] = iArr2[0] - i6;
                    iArr2[1] = iArr2[1] - i5;
                }
                if (iArr[0] == 0 && iArr[1] == 0) {
                    z = false;
                }
                return z;
            } else if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
        }
        return false;
    }

    public boolean a(float f2, float f3, boolean z) {
        if (b()) {
            ViewParent d2 = d(0);
            if (d2 != null) {
                return H.a(d2, this.f2718c, f2, f3, z);
            }
        }
        return false;
    }

    public boolean a(float f2, float f3) {
        if (b()) {
            ViewParent d2 = d(0);
            if (d2 != null) {
                return H.a(d2, this.f2718c, f2, f3);
            }
        }
        return false;
    }

    private void a(int i2, ViewParent viewParent) {
        if (i2 == 0) {
            this.f2716a = viewParent;
        } else if (i2 == 1) {
            this.f2717b = viewParent;
        }
    }
}
