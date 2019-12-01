package com.touchin.vtb.adapters.behaviors;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.TypeCastException;
import kotlin.e.a.b;
import kotlin.e.b.h;

/* compiled from: OperationsSwitcherBehavior.kt */
final class a implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ b f7031a;

    a(b bVar) {
        this.f7031a = bVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        b bVar = this.f7031a;
        h.a((Object) valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            bVar.a((Integer) animatedValue);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
