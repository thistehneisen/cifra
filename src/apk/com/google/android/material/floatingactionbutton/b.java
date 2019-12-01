package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: FloatingActionButtonImpl */
class b extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    private boolean f6422a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ boolean f6423b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ d f6424c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ e f6425d;

    b(e eVar, boolean z, d dVar) {
        this.f6425d = eVar;
        this.f6423b = z;
        this.f6424c = dVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f6422a = true;
    }

    public void onAnimationEnd(Animator animator) {
        e eVar = this.f6425d;
        eVar.f6437h = 0;
        eVar.f6438i = null;
        if (!this.f6422a) {
            eVar.B.a(this.f6423b ? 8 : 4, this.f6423b);
            d dVar = this.f6424c;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f6425d.B.a(0, this.f6423b);
        e eVar = this.f6425d;
        eVar.f6437h = 1;
        eVar.f6438i = animator;
        this.f6422a = false;
    }
}
