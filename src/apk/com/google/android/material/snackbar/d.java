package com.google.android.material.snackbar;

import android.view.View;
import b.g.i.O;
import b.g.i.r;

/* compiled from: BaseTransientBottomBar */
class d implements r {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f6521a;

    d(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6521a = baseTransientBottomBar;
    }

    public O a(View view, O o) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), o.b());
        return o;
    }
}
