package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: TabLayout */
class d extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ int f6599a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ e f6600b;

    d(e eVar, int i2) {
        this.f6600b = eVar;
        this.f6599a = i2;
    }

    public void onAnimationEnd(Animator animator) {
        e eVar = this.f6600b;
        eVar.f6562d = this.f6599a;
        eVar.f6563e = 0.0f;
    }
}
