package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import b.g.i.B;

/* compiled from: BaseTransientBottomBar */
class b implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    private int f6519a = 0;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f6520b;

    b(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6520b = baseTransientBottomBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.f6496b) {
            B.c((View) this.f6520b.f6500f, intValue - this.f6519a);
        } else {
            this.f6520b.f6500f.setTranslationY((float) intValue);
        }
        this.f6519a = intValue;
    }
}
