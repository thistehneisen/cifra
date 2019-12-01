package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import b.g.i.B;

/* compiled from: BaseTransientBottomBar */
class l implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    private int f6529a = this.f6530b;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f6530b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f6531c;

    l(BaseTransientBottomBar baseTransientBottomBar, int i2) {
        this.f6531c = baseTransientBottomBar;
        this.f6530b = i2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.f6496b) {
            B.c((View) this.f6531c.f6500f, intValue - this.f6529a);
        } else {
            this.f6531c.f6500f.setTranslationY((float) intValue);
        }
        this.f6529a = intValue;
    }
}
