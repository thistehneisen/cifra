package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: FloatingActionButtonImpl */
class c extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ boolean f6426a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ d f6427b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ e f6428c;

    c(e eVar, boolean z, d dVar) {
        this.f6428c = eVar;
        this.f6426a = z;
        this.f6427b = dVar;
    }

    public void onAnimationEnd(Animator animator) {
        e eVar = this.f6428c;
        eVar.f6437h = 0;
        eVar.f6438i = null;
        d dVar = this.f6427b;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f6428c.B.a(0, this.f6426a);
        e eVar = this.f6428c;
        eVar.f6437h = 2;
        eVar.f6438i = animator;
    }
}
