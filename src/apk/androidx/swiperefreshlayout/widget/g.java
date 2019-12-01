package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class g extends Animation {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2106a;

    g(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2106a = swipeRefreshLayout;
    }

    public void applyTransformation(float f2, Transformation transformation) {
        this.f2106a.setAnimationProgress(1.0f - f2);
    }
}
