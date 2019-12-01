package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

/* compiled from: BottomAppBar */
class c extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public boolean f6335a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ActionMenuView f6336b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ int f6337c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ boolean f6338d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ BottomAppBar f6339e;

    c(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i2, boolean z) {
        this.f6339e = bottomAppBar;
        this.f6336b = actionMenuView;
        this.f6337c = i2;
        this.f6338d = z;
    }

    public void onAnimationCancel(Animator animator) {
        this.f6335a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f6335a) {
            this.f6339e.a(this.f6336b, this.f6337c, this.f6338d);
        }
    }
}
