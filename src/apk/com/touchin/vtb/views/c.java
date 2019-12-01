package com.touchin.vtb.views;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.TypeCastException;
import kotlin.e.b.h;

/* compiled from: BankSwipeButton.kt */
final class c implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BankSwipeButton f7780a;

    c(BankSwipeButton bankSwipeButton) {
        this.f7780a = bankSwipeButton;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        BankSwipeButton bankSwipeButton = this.f7780a;
        h.a((Object) valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            bankSwipeButton.setDragProgress(((Float) animatedValue).floatValue());
            this.f7780a.f7750j = true;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
}
