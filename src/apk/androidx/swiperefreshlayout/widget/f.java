package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class f extends Animation {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2105a;

    f(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2105a = swipeRefreshLayout;
    }

    public void applyTransformation(float f2, Transformation transformation) {
        this.f2105a.setAnimationProgress(f2);
    }
}
