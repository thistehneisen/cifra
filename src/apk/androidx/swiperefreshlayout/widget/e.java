package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.b;

/* compiled from: SwipeRefreshLayout */
class e implements AnimationListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2104a;

    e(SwipeRefreshLayout swipeRefreshLayout) {
        this.f2104a = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f2104a;
        if (swipeRefreshLayout.f2066e) {
            swipeRefreshLayout.D.setAlpha(255);
            this.f2104a.D.start();
            SwipeRefreshLayout swipeRefreshLayout2 = this.f2104a;
            if (swipeRefreshLayout2.J) {
                b bVar = swipeRefreshLayout2.f2065d;
                if (bVar != null) {
                    bVar.a();
                }
            }
            SwipeRefreshLayout swipeRefreshLayout3 = this.f2104a;
            swipeRefreshLayout3.o = swipeRefreshLayout3.w.getTop();
            return;
        }
        swipeRefreshLayout.b();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
