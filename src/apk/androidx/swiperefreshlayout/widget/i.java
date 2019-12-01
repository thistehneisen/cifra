package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: SwipeRefreshLayout */
class i implements AnimationListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2110a;

    i(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2110a = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f2110a;
        if (!swipeRefreshLayout.t) {
            swipeRefreshLayout.a((AnimationListener) null);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
