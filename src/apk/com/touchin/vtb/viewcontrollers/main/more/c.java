package com.touchin.vtb.viewcontrollers.main.more;

import androidx.lifecycle.v;
import com.touchin.vtb.R;
import com.touchin.vtb.api.ConnectedBank;
import java.util.List;
import l.a.c.a.a;
import l.a.c.a.a.C0118a;
import l.a.c.a.a.b;
import l.a.c.a.a.d;

/* compiled from: BanksManagementViewController.kt */
final class c<T> implements v<a<? extends List<? extends ConnectedBank>>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BanksManagementViewController f7654a;

    c(BanksManagementViewController banksManagementViewController) {
        this.f7654a = banksManagementViewController;
    }

    public final void a(a<? extends List<? extends ConnectedBank>> aVar) {
        if (aVar instanceof l.a.c.a.a.c) {
            this.f7654a.switcher.a(R.id.global_loader);
        } else if (aVar instanceof d) {
            this.f7654a.showConnectedBanks((List) ((d) aVar).a());
        } else if (aVar instanceof C0118a) {
            List list = (List) aVar.a();
            if (list != null) {
                this.f7654a.showConnectedBanks(list);
            }
        } else {
            boolean z = aVar instanceof b;
        }
    }
}
