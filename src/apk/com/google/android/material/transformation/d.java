package com.google.android.material.transformation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: FabTransformationBehavior */
class d implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ View f6621a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f6622b;

    d(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.f6622b = fabTransformationBehavior;
        this.f6621a = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f6621a.invalidate();
    }
}
