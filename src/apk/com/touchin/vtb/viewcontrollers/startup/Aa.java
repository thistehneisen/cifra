package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.activities.StartupActivity;
import com.touchin.vtb.b.h;
import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: WelcomeViewController.kt */
final class Aa extends i implements a<m> {
    final /* synthetic */ WelcomeViewController this$0;

    Aa(WelcomeViewController welcomeViewController) {
        this.this$0 = welcomeViewController;
        super(0);
    }

    public final void b() {
        ((StartupActivity) this.this$0.getActivity()).d().a(h.ENTER_PHONE_NUMBER);
        this.this$0.registerUser();
    }
}
