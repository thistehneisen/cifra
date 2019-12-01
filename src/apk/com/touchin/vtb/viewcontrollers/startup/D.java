package com.touchin.vtb.viewcontrollers.startup;

import androidx.lifecycle.v;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BankConnectionStatus;
import com.touchin.vtb.g.e;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.d;

/* compiled from: GetAccessConfirmSmsViewController.kt */
final class D<T> implements v<a<? extends BankConnectResponse>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ GetAccessConfirmSmsViewController f7688a;

    D(GetAccessConfirmSmsViewController getAccessConfirmSmsViewController) {
        this.f7688a = getAccessConfirmSmsViewController;
    }

    public final void a(a<? extends BankConnectResponse> aVar) {
        if (aVar instanceof d) {
            d dVar = (d) aVar;
            ((e) this.f7688a.getState()).a(((BankConnectResponse) dVar.a()).c());
            if (((BankConnectResponse) dVar.a()).b() == BankConnectionStatus.CONNECTED) {
                this.f7688a.onBankConnected();
                return;
            }
            return;
        }
        boolean z = aVar instanceof b;
    }
}
