package com.google.android.material.snackbar;

import android.view.View;

/* compiled from: BaseTransientBottomBar */
class j implements d {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f6527a;

    j(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6527a = baseTransientBottomBar;
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        this.f6527a.f6500f.setOnLayoutChangeListener(null);
        if (this.f6527a.k()) {
            this.f6527a.b();
        } else {
            this.f6527a.j();
        }
    }
}
