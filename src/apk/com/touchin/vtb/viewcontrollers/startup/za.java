package com.touchin.vtb.viewcontrollers.startup;

import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: WelcomeViewController.kt */
final class za extends i implements a<m> {
    final /* synthetic */ WelcomeViewController this$0;

    za(WelcomeViewController welcomeViewController) {
        this.this$0 = welcomeViewController;
        super(0);
    }

    public final void b() {
        this.this$0.scrollView.smoothScrollTo(0, this.this$0.scrollYPositionWithOpenedKeyboard);
    }
}
