package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnClickListener;
import com.touchin.vtb.g.f;

/* compiled from: GetAccessViewController.kt */
final class F implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ GetAccessViewController f7691a;

    F(GetAccessViewController getAccessViewController) {
        this.f7691a = getAccessViewController;
    }

    public final void onClick(View view) {
        GetAccessViewController getAccessViewController = this.f7691a;
        getAccessViewController.sendedLogin = getAccessViewController.loginFocusawareEditText.getText();
        GetAccessViewController getAccessViewController2 = this.f7691a;
        getAccessViewController2.sendedPassword = getAccessViewController2.passwordFocusawareEditText.getText();
        this.f7691a.viewModel.a(((f) this.f7691a.getState()).q(), this.f7691a.sendedLogin, this.f7691a.sendedPassword, ((f) this.f7691a.getState()).p());
    }
}
