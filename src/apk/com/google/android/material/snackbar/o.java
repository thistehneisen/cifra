package com.google.android.material.snackbar;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: Snackbar */
class o implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ OnClickListener f6533a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Snackbar f6534b;

    o(Snackbar snackbar, OnClickListener onClickListener) {
        this.f6534b = snackbar;
        this.f6533a = onClickListener;
    }

    public void onClick(View view) {
        this.f6533a.onClick(view);
        this.f6534b.a(1);
    }
}
