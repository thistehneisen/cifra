package com.touchin.vtb.viewcontrollers.startup;

import androidx.lifecycle.v;
import com.touchin.vtb.api.UserRegisterResponse;
import com.touchin.vtb.f.h;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.c;
import l.a.c.a.a.d;

/* compiled from: WelcomeViewController.kt */
final class Ea<T> implements v<a<? extends UserRegisterResponse>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ WelcomeViewController f7690a;

    Ea(WelcomeViewController welcomeViewController) {
        this.f7690a = welcomeViewController;
    }

    public final void a(a<? extends UserRegisterResponse> aVar) {
        if (aVar instanceof c) {
            this.f7690a.progressButton.setState(h.LOADING);
        } else if (aVar instanceof d) {
            this.f7690a.progressButton.setState(h.SUCCESS);
            this.f7690a.getView().postDelayed(new Ba(this, aVar), 1000);
        } else if (aVar instanceof b) {
            this.f7690a.progressButton.setState(h.FAIL);
            this.f7690a.switcher.a(this.f7690a.errorView.getId());
            this.f7690a.errorView.a(((b) aVar).b(), new Da(this.f7690a));
            this.f7690a.getView().postDelayed(new Ca(this), 2000);
        }
    }
}
