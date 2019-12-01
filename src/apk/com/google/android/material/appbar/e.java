package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: CollapsingToolbarLayout */
class e implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ CollapsingToolbarLayout f6276a;

    e(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f6276a = collapsingToolbarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f6276a.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
