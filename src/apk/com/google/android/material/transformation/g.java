package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: FabTransformationScrimBehavior */
class g extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ boolean f6628a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f6629b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ FabTransformationScrimBehavior f6630c;

    g(FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean z, View view) {
        this.f6630c = fabTransformationScrimBehavior;
        this.f6628a = z;
        this.f6629b = view;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f6628a) {
            this.f6629b.setVisibility(4);
        }
    }

    public void onAnimationStart(Animator animator) {
        if (this.f6628a) {
            this.f6629b.setVisibility(0);
        }
    }
}
