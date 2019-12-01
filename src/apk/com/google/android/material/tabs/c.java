package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import c.b.a.c.a.a;

/* compiled from: TabLayout */
class c implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ int f6594a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f6595b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ int f6596c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ int f6597d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ e f6598e;

    c(e eVar, int i2, int i3, int i4, int i5) {
        this.f6598e = eVar;
        this.f6594a = i2;
        this.f6595b = i3;
        this.f6596c = i4;
        this.f6597d = i5;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.f6598e.b(a.a(this.f6594a, this.f6595b, animatedFraction), a.a(this.f6596c, this.f6597d, animatedFraction));
    }
}
