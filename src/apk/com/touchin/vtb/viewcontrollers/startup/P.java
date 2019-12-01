package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.f.h;

/* compiled from: View.kt */
public final class P implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Q f7699a;

    public P(Q q) {
        this.f7699a = q;
    }

    public final void run() {
        this.f7699a.f7700a.progressButton.setState(h.NORMAL);
    }
}
