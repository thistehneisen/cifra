package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.api.UserRegisterResponse;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.a.a.d;

/* compiled from: View.kt */
public final class Ba implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Ea f7684a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ a f7685b;

    public Ba(Ea ea, a aVar) {
        this.f7684a = ea;
        this.f7685b = aVar;
    }

    public final void run() {
        WelcomeViewController welcomeViewController = this.f7684a.f7690a;
        String b2 = ((UserRegisterResponse) ((d) this.f7685b).a()).b();
        h.a((Object) b2, "event.data.smsOperationId");
        welcomeViewController.navigateToConfirm(b2);
    }
}
