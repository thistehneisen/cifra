package b.g.i;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompat */
class J implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ N f2652a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f2653b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ K f2654c;

    J(K k2, N n, View view) {
        this.f2654c = k2;
        this.f2652a = n;
        this.f2653b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2652a.a(this.f2653b);
    }
}
