package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class k extends Animation {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2112a;

    k(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2112a = swipeRefreshLayout;
    }

    public void applyTransformation(float f2, Transformation transformation) {
        this.f2112a.a(f2);
    }
}
