package com.touchin.vtb.viewcontrollers.main.bank;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

/* compiled from: BankViewController.kt */
final class g implements OnLayoutChangeListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BankViewController f7648a;

    g(BankViewController bankViewController) {
        this.f7648a = bankViewController;
    }

    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i5 < i9) {
            this.f7648a.hideBottomMenu(false);
        } else if (i5 > i9) {
            this.f7648a.showBottomMenu();
        }
    }
}
