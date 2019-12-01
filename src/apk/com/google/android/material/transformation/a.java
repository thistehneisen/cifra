package com.google.android.material.transformation;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import c.b.a.c.f.b;

/* compiled from: ExpandableBehavior */
class a implements OnPreDrawListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ View f6612a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f6613b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ b f6614c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ ExpandableBehavior f6615d;

    a(ExpandableBehavior expandableBehavior, View view, int i2, b bVar) {
        this.f6615d = expandableBehavior;
        this.f6612a = view;
        this.f6613b = i2;
        this.f6614c = bVar;
    }

    public boolean onPreDraw() {
        this.f6612a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f6615d.f6601a == this.f6613b) {
            ExpandableBehavior expandableBehavior = this.f6615d;
            b bVar = this.f6614c;
            expandableBehavior.a((View) bVar, this.f6612a, bVar.a(), false);
        }
        return false;
    }
}
