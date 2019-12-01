package com.touchin.vtb.viewcontrollers.main.more;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.h.b.i;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import kotlin.e.b.h;
import l.a.b.g;
import l.a.c.c.q;
import ru.touchin.roboswag.components.navigation.viewcontrollers.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;

/* compiled from: MoreViewController.kt */
public final class MoreViewController extends VTBViewController<c, b> {
    /* access modifiers changed from: private */
    public final View manageBankButton = findViewById(R.id.view_controller_more_manage_banks);
    /* access modifiers changed from: private */
    public final TextView organizationTitle = ((TextView) findViewById(R.id.view_controller_more_organization_title));
    private final TextView privatePolicyButton = ((TextView) findViewById(R.id.view_controller_more_personal_data_agreement));
    /* access modifiers changed from: private */
    public final i viewModel;

    public MoreViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_more);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(i.class);
        h.a((Object) a2, "LifecycleViewModelProvid…oreViewModel::class.java)");
        this.viewModel = (i) a2;
        initializeViews();
        observeData();
    }

    private final void initializeViews() {
        g.a(this.manageBankButton, new i(this));
        g.a(findViewById(R.id.view_controller_more_login_settings), new j(this));
        g.a(findViewById(R.id.view_controller_more_facebook_button), new k(this));
        g.a(findViewById(R.id.view_controller_more_telegram_button), new l(this));
        g.a(findViewById(R.id.view_controller_more_phone_button), new m(this));
        g.a(findViewById(R.id.view_controller_more_logout), new o(this));
        this.privatePolicyButton.setOnClickListener(new p(this));
    }

    private final void observeData() {
        this.viewModel.d().a(this, new q(this));
        this.viewModel.c().a(this, new r(this));
    }
}
