package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.f.h;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.c reason: case insensitive filesystem */
/* compiled from: View.kt */
public final class C0680c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0682d f7709a;

    public C0680c(C0682d dVar) {
        this.f7709a = dVar;
    }

    public final void run() {
        this.f7709a.f7711a.progressButton.setState(h.SUCCESS);
        this.f7709a.f7711a.getView().postDelayed(new C0678b(this), 1000);
    }
}
