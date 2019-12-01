package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior.a;

/* compiled from: BaseTransientBottomBar */
class g implements a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f6524a;

    g(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6524a = baseTransientBottomBar;
    }

    public void a(View view) {
        view.setVisibility(8);
        this.f6524a.a(0);
    }

    public void a(int i2) {
        if (i2 == 0) {
            q.a().e(this.f6524a.f6506l);
        } else if (i2 == 1 || i2 == 2) {
            q.a().d(this.f6524a.f6506l);
        }
    }
}
