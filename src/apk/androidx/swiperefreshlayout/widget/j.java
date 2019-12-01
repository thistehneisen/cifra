package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class j extends Animation {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2111a;

    j(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2111a = swipeRefreshLayout;
    }

    public void applyTransformation(float f2, Transformation transformation) {
        int i2;
        SwipeRefreshLayout swipeRefreshLayout = this.f2111a;
        if (!swipeRefreshLayout.L) {
            i2 = swipeRefreshLayout.B - Math.abs(swipeRefreshLayout.A);
        } else {
            i2 = swipeRefreshLayout.B;
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.f2111a;
        int i3 = swipeRefreshLayout2.y;
        this.f2111a.setTargetOffsetTopAndBottom((i3 + ((int) (((float) (i2 - i3)) * f2))) - swipeRefreshLayout2.w.getTop());
        this.f2111a.D.a(1.0f - f2);
    }
}
