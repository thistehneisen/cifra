package com.google.android.material.snackbar;

import android.os.Bundle;
import android.view.View;
import b.g.i.C0240a;
import b.g.i.a.d;

/* compiled from: BaseTransientBottomBar */
class e extends C0240a {

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f6522d;

    e(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6522d = baseTransientBottomBar;
    }

    public void a(View view, d dVar) {
        super.a(view, dVar);
        dVar.a(1048576);
        dVar.d(true);
    }

    public boolean a(View view, int i2, Bundle bundle) {
        if (i2 != 1048576) {
            return super.a(view, i2, bundle);
        }
        this.f6522d.c();
        return true;
    }
}
