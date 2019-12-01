package com.touchin.vtb.viewcontrollers.startup;

import androidx.lifecycle.v;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.f.h;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.c;
import l.a.c.a.a.d;

/* compiled from: GetAccessViewController.kt */
final class Q<T> implements v<a<? extends BankConnectResponse>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ GetAccessViewController f7700a;

    Q(GetAccessViewController getAccessViewController) {
        this.f7700a = getAccessViewController;
    }

    public final void a(a<? extends BankConnectResponse> aVar) {
        if (aVar instanceof c) {
            this.f7700a.progressButton.setState(h.LOADING);
        } else if (aVar instanceof d) {
            this.f7700a.progressButton.setState(h.SUCCESS);
            this.f7700a.getView().postDelayed(new O(this, aVar), 1000);
        } else if (aVar instanceof b) {
            this.f7700a.progressButton.setState(h.FAIL);
            this.f7700a.getView().postDelayed(new P(this), 1000);
            this.f7700a.errorTextView.setVisibility(0);
            this.f7700a.loginFocusawareEditText.setErrorSet(true);
            this.f7700a.passwordFocusawareEditText.setErrorSet(true);
        }
    }
}
