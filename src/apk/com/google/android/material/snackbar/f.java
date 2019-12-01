package com.google.android.material.snackbar;

import android.os.Handler;

/* compiled from: BaseTransientBottomBar */
class f implements a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f6523a;

    f(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6523a = baseTransientBottomBar;
    }

    public void a(int i2) {
        Handler handler = BaseTransientBottomBar.f6495a;
        handler.sendMessage(handler.obtainMessage(1, i2, 0, this.f6523a));
    }

    public void b() {
        Handler handler = BaseTransientBottomBar.f6495a;
        handler.sendMessage(handler.obtainMessage(0, this.f6523a));
    }
}
