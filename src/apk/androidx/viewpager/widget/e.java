package androidx.viewpager.widget;

import android.graphics.Rect;
import android.view.View;
import b.g.i.B;
import b.g.i.O;
import b.g.i.r;

/* compiled from: ViewPager */
class e implements r {

    /* renamed from: a reason: collision with root package name */
    private final Rect f2143a = new Rect();

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ViewPager f2144b;

    e(ViewPager viewPager) {
        this.f2144b = viewPager;
    }

    public O a(View view, O o) {
        O b2 = B.b(view, o);
        if (b2.f()) {
            return b2;
        }
        Rect rect = this.f2143a;
        rect.left = b2.c();
        rect.top = b2.e();
        rect.right = b2.d();
        rect.bottom = b2.b();
        int childCount = this.f2144b.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            O a2 = B.a(this.f2144b.getChildAt(i2), b2);
            rect.left = Math.min(a2.c(), rect.left);
            rect.top = Math.min(a2.e(), rect.top);
            rect.right = Math.min(a2.d(), rect.right);
            rect.bottom = Math.min(a2.b(), rect.bottom);
        }
        return b2.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
