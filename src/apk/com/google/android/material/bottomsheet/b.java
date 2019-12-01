package com.google.android.material.bottomsheet;

import android.view.View;
import b.g.i.B;
import b.i.b.g.a;
import java.lang.ref.WeakReference;

/* compiled from: BottomSheetBehavior */
class b extends a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BottomSheetBehavior f6359a;

    b(BottomSheetBehavior bottomSheetBehavior) {
        this.f6359a = bottomSheetBehavior;
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        this.f6359a.a(i3);
    }

    public boolean b(View view, int i2) {
        BottomSheetBehavior bottomSheetBehavior = this.f6359a;
        int i3 = bottomSheetBehavior.f6351l;
        boolean z = true;
        if (i3 == 1 || bottomSheetBehavior.x) {
            return false;
        }
        if (i3 == 3 && bottomSheetBehavior.v == i2) {
            View view2 = (View) bottomSheetBehavior.s.get();
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        WeakReference<V> weakReference = this.f6359a.r;
        if (weakReference == null || weakReference.get() != view) {
            z = false;
        }
        return z;
    }

    public void c(int i2) {
        if (i2 == 1) {
            this.f6359a.d(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e6  */
    public void a(View view, float f2, float f3) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 4;
        if (f3 >= 0.0f) {
            BottomSheetBehavior bottomSheetBehavior = this.f6359a;
            if (bottomSheetBehavior.f6349j && bottomSheetBehavior.a(view, f3) && (view.getTop() > this.f6359a.f6348i || Math.abs(f2) < Math.abs(f3))) {
                i2 = this.f6359a.q;
                i6 = 5;
                if (!this.f6359a.m.c(view.getLeft(), i2)) {
                }
            } else if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                int top = view.getTop();
                if (!this.f6359a.f6340a) {
                    BottomSheetBehavior bottomSheetBehavior2 = this.f6359a;
                    int i7 = bottomSheetBehavior2.f6347h;
                    if (top < i7) {
                        if (top >= Math.abs(top - bottomSheetBehavior2.f6348i)) {
                            i3 = this.f6359a.f6347h;
                        }
                        i2 = 0;
                    } else if (Math.abs(top - i7) < Math.abs(top - this.f6359a.f6348i)) {
                        i3 = this.f6359a.f6347h;
                    } else {
                        i5 = this.f6359a.f6348i;
                    }
                    i4 = i3;
                    i6 = 6;
                    if (!this.f6359a.m.c(view.getLeft(), i2)) {
                    }
                } else if (Math.abs(top - this.f6359a.f6346g) < Math.abs(top - this.f6359a.f6348i)) {
                    i2 = this.f6359a.f6346g;
                } else {
                    i5 = this.f6359a.f6348i;
                }
                i2 = i5;
                if (!this.f6359a.m.c(view.getLeft(), i2)) {
                }
            } else {
                i2 = this.f6359a.f6348i;
                if (!this.f6359a.m.c(view.getLeft(), i2)) {
                }
            }
        } else if (this.f6359a.f6340a) {
            i2 = this.f6359a.f6346g;
        } else {
            int top2 = view.getTop();
            int i8 = this.f6359a.f6347h;
            if (top2 > i8) {
                i4 = i8;
                i6 = 6;
                if (!this.f6359a.m.c(view.getLeft(), i2)) {
                    this.f6359a.d(2);
                    B.a(view, (Runnable) new c(view, i6));
                    return;
                }
                this.f6359a.d(i6);
                return;
            }
            i2 = 0;
        }
        i6 = 3;
        if (!this.f6359a.m.c(view.getLeft(), i2)) {
        }
    }

    public int b(View view, int i2, int i3) {
        int b2 = this.f6359a.d();
        BottomSheetBehavior bottomSheetBehavior = this.f6359a;
        return b.g.e.a.a(i2, b2, bottomSheetBehavior.f6349j ? bottomSheetBehavior.q : bottomSheetBehavior.f6348i);
    }

    public int b(View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f6359a;
        if (bottomSheetBehavior.f6349j) {
            return bottomSheetBehavior.q;
        }
        return bottomSheetBehavior.f6348i;
    }

    public int a(View view, int i2, int i3) {
        return view.getLeft();
    }
}
