package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.activities.c;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BankConnectionStatus;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.g.e;
import com.touchin.vtb.g.f;
import com.touchin.vtb.h.c.p;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.a.a.d;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/* compiled from: View.kt */
public final class O implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Q f7697a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ a f7698b;

    public O(Q q, a aVar) {
        this.f7697a = q;
        this.f7698b = aVar;
    }

    public final void run() {
        if (((BankConnectResponse) ((d) this.f7698b).a()).b() == BankConnectionStatus.SMS_CODE_REQUIRED) {
            e eVar = new e(((BankConnectResponse) ((d) this.f7698b).a()).c(), ((f) this.f7697a.f7700a.getState()).q(), this.f7697a.f7700a.sendedLogin, this.f7697a.f7700a.sendedPassword, 0, ((f) this.f7697a.f7700a.getState()).r(), ((f) this.f7697a.f7700a.getState()).n(), ((f) this.f7697a.f7700a.getState()).o(), 16, null);
            ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(((c) this.f7697a.f7700a.getActivity()).c(), GetAccessConfirmSmsViewController.class, eVar, false, null, null, 28, null);
        } else if (!((f) this.f7697a.f7700a.getState()).o().isEmpty()) {
            BankConnectResponse bankConnectResponse = (BankConnectResponse) ((f) this.f7697a.f7700a.getState()).o().get(0);
            ((f) this.f7697a.f7700a.getState()).o().remove(bankConnectResponse);
            GetAccessViewController getAccessViewController = this.f7697a.f7700a;
            c cVar = (c) getAccessViewController.getActivity();
            BankConnectionStatus b2 = bankConnectResponse.b();
            h.a((Object) b2, "bankToNextRestoreSession.bankConnectionStatus");
            String c2 = bankConnectResponse.c();
            String str = "bankToNextRestoreSession.connectedBankId";
            h.a((Object) c2, str);
            p access$getViewModel$p = this.f7697a.f7700a.viewModel;
            String c3 = bankConnectResponse.c();
            h.a((Object) c3, str);
            BankType a2 = access$getViewModel$p.a(c3);
            if (a2 != null) {
                getAccessViewController.navigateToGetAccess(cVar, b2, c2, a2, ((f) this.f7697a.f7700a.getState()).o());
                return;
            }
            throw new ShouldNotHappenException("BankType is not init");
        } else if (((f) this.f7697a.f7700a.getState()).t()) {
            this.f7697a.f7700a.viewModel.e();
        } else {
            GetAccessViewController getAccessViewController2 = this.f7697a.f7700a;
            getAccessViewController2.navigateToSuccess((c) getAccessViewController2.getActivity(), ((f) this.f7697a.f7700a.getState()).r());
        }
    }
}
