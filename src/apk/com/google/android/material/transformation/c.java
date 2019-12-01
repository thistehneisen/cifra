package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: FabTransformationBehavior */
class c extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ boolean f6617a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f6618b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ View f6619c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f6620d;

    c(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
        this.f6620d = fabTransformationBehavior;
        this.f6617a = z;
        this.f6618b = view;
        this.f6619c = view2;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f6617a) {
            this.f6618b.setVisibility(4);
            this.f6619c.setAlpha(1.0f);
            this.f6619c.setVisibility(0);
        }
    }

    public void onAnimationStart(Animator animator) {
        if (this.f6617a) {
            this.f6618b.setVisibility(0);
            this.f6619c.setAlpha(0.0f);
            this.f6619c.setVisibility(4);
        }
    }
}
