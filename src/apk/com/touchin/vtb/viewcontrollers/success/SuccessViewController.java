package com.touchin.vtb.viewcontrollers.success;

import android.content.Intent;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.h.a.m;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import com.touchin.vtb.viewcontrollers.main.bank.BankViewController;
import kotlin.e.b.h;
import l.a.c.c.q;
import l.a.d.a.a.a.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;

/* compiled from: SuccessViewController.kt */
public final class SuccessViewController extends VTBViewController<c, a> {
    private final b onBackPressedListener = new c(this);
    private final m viewModel;

    public SuccessViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_success);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(m.class);
        h.a((Object) a2, "LifecycleViewModelProvid…essViewModel::class.java)");
        this.viewModel = (m) a2;
        ((c) getActivity()).a(this.onBackPressedListener);
        this.viewModel.d();
        ((TextView) findViewById(R.id.view_controller_success_title)).setText(((a) getState()).p());
        ((TextView) findViewById(R.id.view_controller_success_subtitle)).setText(((a) getState()).o());
        this.viewModel.c().a(this, new b(this));
    }

    /* access modifiers changed from: private */
    public final void closeSuccessScreen() {
        if (h.a((Object) ((a) getState()).n(), (Object) BankViewController.class.getName())) {
            ((c) getActivity()).a(MainActivity.a.a(MainActivity.f6990g, getActivity(), null, null, R.id.main_navigation_bank, 6, null));
            return;
        }
        Fragment targetFragment = getFragment().getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(400, -1, new Intent());
        }
        l.a.d.a.a.a.a(((c) getActivity()).c(), ((a) getState()).n(), false, 2, null);
    }

    public void onStop() {
        ((c) getActivity()).b(this.onBackPressedListener);
        super.onStop();
    }
}
