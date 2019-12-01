package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.activities.c;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.b.g;
import com.touchin.vtb.b.g.C0073g;
import com.touchin.vtb.g.b;
import com.touchin.vtb.g.f;
import com.touchin.vtb.viewcontrollers.main.more.BanksManagementViewController;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.b reason: case insensitive filesystem */
/* compiled from: View.kt */
public final class C0678b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0680c f7707a;

    public C0678b(C0680c cVar) {
        this.f7707a = cVar;
    }

    public final void run() {
        BankType n = ((b) this.f7707a.f7709a.f7711a.getState()).n();
        if (n != null) {
            if (((b) this.f7707a.f7709a.f7711a.getState()).q()) {
                ((c) this.f7707a.f7709a.f7711a.getActivity()).d().a((g) new g.b(n));
            } else {
                ((c) this.f7707a.f7709a.f7711a.getActivity()).d().a((g) new C0073g(n));
            }
            d c2 = ((c) this.f7707a.f7709a.f7711a.getActivity()).c();
            Class<GetAccessViewController> cls = GetAccessViewController.class;
            f fVar = new f(n, Integer.valueOf(((b) this.f7707a.f7709a.f7711a.getState()).p()), ((b) this.f7707a.f7709a.f7711a.getState()).q(), ((b) this.f7707a.f7709a.f7711a.getState()).q() ? null : BanksManagementViewController.class.getName(), false, null, null, 112, null);
            d.a(c2, cls, fVar, false, null, null, 28, null);
            return;
        }
        throw new ShouldNotHappenException("no BankType selected");
    }
}
