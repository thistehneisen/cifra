package com.google.android.material.bottomsheet;

import android.view.View;

/* compiled from: BottomSheetBehavior */
class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ View f6356a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f6357b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ BottomSheetBehavior f6358c;

    a(BottomSheetBehavior bottomSheetBehavior, View view, int i2) {
        this.f6358c = bottomSheetBehavior;
        this.f6356a = view;
        this.f6357b = i2;
    }

    public void run() {
        this.f6358c.a(this.f6356a, this.f6357b);
    }
}
