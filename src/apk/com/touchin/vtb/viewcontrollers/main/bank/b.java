package com.touchin.vtb.viewcontrollers.main.bank;

import android.view.View;
import android.view.View.OnClickListener;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.g.i;
import com.touchin.vtb.viewcontrollers.startup.ConnectBankViewController;
import com.touchin.vtb.viewcontrollers.startup.SearchCompanyViewController;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: BankViewController.kt */
final class b implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BankViewController f7645a;

    b(BankViewController bankViewController) {
        this.f7645a = bankViewController;
    }

    public final void onClick(View view) {
        if (n.a(this.f7645a.viewModel.i())) {
            i iVar = new i(null, null, null, null, null, null, 63, null);
            d.a(((c) this.f7645a.getActivity()).c(), SearchCompanyViewController.class, iVar, false, null, null, 28, null);
            return;
        }
        com.touchin.vtb.g.b bVar = new com.touchin.vtb.g.b(null, R.string.common_more_add_bank, false, null, 13, null);
        d.a(((c) this.f7645a.getActivity()).c(), ConnectBankViewController.class, bVar, false, null, null, 28, null);
    }
}
