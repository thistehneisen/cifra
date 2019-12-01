package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: AppBarLayout */
class b implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ CoordinatorLayout f6272a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ AppBarLayout f6273b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ BaseBehavior f6274c;

    b(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f6274c = baseBehavior;
        this.f6272a = coordinatorLayout;
        this.f6273b = appBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f6274c.c(this.f6272a, this.f6273b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
