package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class l extends Animation {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2113a;

    l(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2113a = swipeRefreshLayout;
    }

    public void applyTransformation(float f2, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f2113a;
        float f3 = swipeRefreshLayout.z;
        swipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
        this.f2113a.a(f2);
    }
}
