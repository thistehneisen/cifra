package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: TabLayout */
class b implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TabLayout f6593a;

    b(TabLayout tabLayout) {
        this.f6593a = tabLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f6593a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
    }
}
