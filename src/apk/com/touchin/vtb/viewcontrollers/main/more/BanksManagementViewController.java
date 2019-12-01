package com.touchin.vtb.viewcontrollers.main.more;

import android.content.Intent;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.C;
import androidx.recyclerview.widget.RecyclerView;
import com.touchin.vtb.R;
import com.touchin.vtb.a.m;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.api.ConnectedBank;
import com.touchin.vtb.h.b.d;
import com.touchin.vtb.h.c.i;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import com.touchin.vtb.viewcontrollers.startup.ConnectBankViewController;
import com.touchin.vtb.viewcontrollers.startup.EnterPinViewController;
import java.util.ArrayList;
import java.util.List;
import kotlin.e.b.h;
import l.a.c.c.q;
import ru.touchin.roboswag.components.navigation.viewcontrollers.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;
import ru.touchin.widget.Switcher;

/* compiled from: BanksManagementViewController.kt */
public final class BanksManagementViewController extends VTBViewController<c, b> {
    private final i fingerprintViewModel;
    private final m recyclerAdapter = new m(new d(this), new e(this));
    private final RecyclerView recyclerView = ((RecyclerView) findViewById(R.id.view_controller_bank_management_recycler_view));
    /* access modifiers changed from: private */
    public final Switcher switcher = ((Switcher) findViewById(R.id.view_controller_bank_management_switcher));
    private final d viewModel;

    public BanksManagementViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_banks_management);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(d.class);
        h.a((Object) a2, "LifecycleViewModelProvid…entViewModel::class.java)");
        this.viewModel = (d) a2;
        C a3 = q.a(q.f10391a, this, null, 2, null).a(i.class);
        h.a((Object) a3, "LifecycleViewModelProvid…intViewModel::class.java)");
        this.fingerprintViewModel = (i) a3;
        initializeToolbars();
        initializeViews();
        observeData();
    }

    /* access modifiers changed from: private */
    public final void addBank() {
        ((c) getActivity()).d().a(com.touchin.vtb.b.h.SETTINGS_ADD_BANK);
        ru.touchin.roboswag.components.navigation.viewcontrollers.d c2 = ((c) getActivity()).c();
        Class<ConnectBankViewController> cls = ConnectBankViewController.class;
        List<ConnectedBank> d2 = this.recyclerAdapter.d();
        ArrayList arrayList = new ArrayList(j.a(d2, 10));
        for (ConnectedBank b2 : d2) {
            arrayList.add(b2.b());
        }
        com.touchin.vtb.g.b bVar = new com.touchin.vtb.g.b(null, R.string.common_more_add_bank, false, arrayList, 1, null);
        ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(c2, cls, bVar, false, null, null, 28, null);
    }

    /* access modifiers changed from: private */
    public final void deleteBank(String str) {
        this.viewModel.b(str);
        ru.touchin.roboswag.components.navigation.viewcontrollers.d c2 = ((c) getActivity()).c();
        Class<EnterPinViewController> cls = EnterPinViewController.class;
        l.a.c.a.a aVar = (l.a.c.a.a) this.viewModel.h().a();
        if (aVar != null) {
            String str2 = (String) aVar.a();
            if (str2 != null) {
                com.touchin.vtb.g.d dVar = new com.touchin.vtb.g.d(str2, this.fingerprintViewModel.f(), 0, false, false, null, null, 0, null, Integer.valueOf(R.string.common_security_subtitle), 0, R.string.android_fingerprint_remove_bank, 1276, null);
                ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(c2, cls, dVar, getFragment(), 300, null, null, 48, null);
                return;
            }
        }
        throw new ShouldNotHappenException("Pin can't be null");
    }

    private final void initializeToolbars() {
        c.a((c) getActivity(), (Toolbar) findViewById(R.id.global_toolbar), getString(R.string.common_more_manage_banks), null, true, 0, 20, null);
    }

    private final void initializeViews() {
        this.recyclerView.setAdapter(this.recyclerAdapter);
    }

    private final void observeData() {
        this.viewModel.h().a(this, a.f7652a);
        this.viewModel.e().a(this, b.f7653a);
        this.viewModel.g().a(this, new c(this));
    }

    /* access modifiers changed from: private */
    public final void showConnectedBanks(List<? extends ConnectedBank> list) {
        this.recyclerAdapter.a(list);
        this.switcher.a(this.recyclerView.getId());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 300 && i3 == -1) {
            d dVar = this.viewModel;
            dVar.a(dVar.f());
        }
    }

    public void onResume() {
        super.onResume();
        this.viewModel.c();
    }
}
