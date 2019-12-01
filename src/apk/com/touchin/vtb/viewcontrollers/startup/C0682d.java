package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.view.View.OnClickListener;
import com.touchin.vtb.f.h;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.d reason: case insensitive filesystem */
/* compiled from: ConnectBankViewController.kt */
final class C0682d implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ConnectBankViewController f7711a;

    C0682d(ConnectBankViewController connectBankViewController) {
        this.f7711a = connectBankViewController;
    }

    public final void onClick(View view) {
        this.f7711a.progressButton.setState(h.LOADING);
        this.f7711a.getView().postDelayed(new C0680c(this), 1000);
    }
}
