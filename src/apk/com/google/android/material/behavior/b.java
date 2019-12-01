package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewParent;
import b.g.i.B;
import b.i.b.g.a;

/* compiled from: SwipeDismissBehavior */
class b extends a {

    /* renamed from: a reason: collision with root package name */
    private int f6317a;

    /* renamed from: b reason: collision with root package name */
    private int f6318b = -1;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ SwipeDismissBehavior f6319c;

    b(SwipeDismissBehavior swipeDismissBehavior) {
        this.f6319c = swipeDismissBehavior;
    }

    public void a(View view, int i2) {
        this.f6318b = i2;
        this.f6317a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public boolean b(View view, int i2) {
        return this.f6318b == -1 && this.f6319c.a(view);
    }

    public void c(int i2) {
        SwipeDismissBehavior.a aVar = this.f6319c.f6304b;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public int b(View view, int i2, int i3) {
        return view.getTop();
    }

    public void a(View view, float f2, float f3) {
        boolean z;
        int i2;
        this.f6318b = -1;
        int width = view.getWidth();
        if (a(view, f2)) {
            int left = view.getLeft();
            int i3 = this.f6317a;
            i2 = left < i3 ? i3 - width : i3 + width;
            z = true;
        } else {
            i2 = this.f6317a;
            z = false;
        }
        if (this.f6319c.f6303a.c(i2, view.getTop())) {
            B.a(view, (Runnable) new b(view, z));
        } else if (z) {
            SwipeDismissBehavior.a aVar = this.f6319c.f6304b;
            if (aVar != null) {
                aVar.a(view);
            }
        }
    }

    private boolean a(View view, float f2) {
        boolean z = false;
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            boolean z2 = B.m(view) == 1;
            int i3 = this.f6319c.f6308f;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 0) {
                return z2 ? z : z;
                z = true;
            }
            if (i3 == 1) {
                if (z2) {
                }
                z = true;
            }
            return z;
        }
        if (Math.abs(view.getLeft() - this.f6317a) >= Math.round(((float) view.getWidth()) * this.f6319c.f6309g)) {
            z = true;
        }
        return z;
    }

    public int a(View view) {
        return view.getWidth();
    }

    public int a(View view, int i2, int i3) {
        int i4;
        int i5;
        int width;
        boolean z = B.m(view) == 1;
        int i6 = this.f6319c.f6308f;
        if (i6 != 0) {
            if (i6 != 1) {
                i4 = this.f6317a - view.getWidth();
                i5 = view.getWidth() + this.f6317a;
            } else if (z) {
                i4 = this.f6317a;
                width = view.getWidth();
            } else {
                i4 = this.f6317a - view.getWidth();
                i5 = this.f6317a;
            }
            return SwipeDismissBehavior.a(i4, i2, i5);
        } else if (z) {
            i4 = this.f6317a - view.getWidth();
            i5 = this.f6317a;
            return SwipeDismissBehavior.a(i4, i2, i5);
        } else {
            i4 = this.f6317a;
            width = view.getWidth();
        }
        i5 = width + i4;
        return SwipeDismissBehavior.a(i4, i2, i5);
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        float width = ((float) this.f6317a) + (((float) view.getWidth()) * this.f6319c.f6310h);
        float width2 = ((float) this.f6317a) + (((float) view.getWidth()) * this.f6319c.f6311i);
        float f2 = (float) i2;
        if (f2 <= width) {
            view.setAlpha(1.0f);
        } else if (f2 >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f2), 1.0f));
        }
    }
}
