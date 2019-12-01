package com.google.android.material.snackbar;

import android.view.View;

/* compiled from: BaseTransientBottomBar */
class i implements c {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f6526a;

    i(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6526a = baseTransientBottomBar;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        if (this.f6526a.i()) {
            BaseTransientBottomBar.f6495a.post(new h(this));
        }
    }
}
