package com.touchin.vtb.viewcontrollers.startup;

import android.text.TextWatcher;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BankConnectionStatus;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.g.f;
import com.touchin.vtb.h.c.p;
import com.touchin.vtb.viewcontrollers.base.RegistrationWithToolbarViewController;
import com.touchin.vtb.viewcontrollers.base.a.C0079a;
import com.touchin.vtb.views.ProgressButton;
import com.touchin.vtb.views.focus_edit_text.FocusawareEditText;
import java.util.List;
import kotlin.e.b.h;
import l.a.c.c.q;

/* compiled from: GetAccessViewController.kt */
public final class GetAccessViewController extends RegistrationWithToolbarViewController<c, f> implements com.touchin.vtb.viewcontrollers.base.a {
    public static final a Companion = new a(null);
    private static final int REGISTRATION_PROGRESS = 100;
    private static final long SCROLLING_DELAY_MILLIS = 100;
    /* access modifiers changed from: private */
    public final View errorTextView = findViewById(R.id.view_controller_get_access_error_do_not_match_text);
    private final TextView expiredSessionTitleTextView = ((TextView) findViewById(R.id.view_controller_get_access_expired_session_title));
    /* access modifiers changed from: private */
    public final FocusawareEditText loginFocusawareEditText = ((FocusawareEditText) findViewById(R.id.view_controller_get_access_login_focusaware_edit_text));
    /* access modifiers changed from: private */
    public final FocusawareEditText passwordFocusawareEditText = ((FocusawareEditText) findViewById(R.id.view_controller_get_access_password_focusaware_edit_text));
    /* access modifiers changed from: private */
    public final ProgressButton progressButton = ((ProgressButton) findViewById(R.id.view_controller_get_access_progress_button));
    private final View restoreAccountView = findViewById(R.id.view_controller_get_access_restore_text);
    /* access modifiers changed from: private */
    public final ScrollView scrollView = ((ScrollView) findViewById(R.id.view_controller_get_access_scroll));
    /* access modifiers changed from: private */
    public String sendedLogin;
    /* access modifiers changed from: private */
    public String sendedPassword;
    private final TextView subtitleTextView = ((TextView) findViewById(R.id.view_controller_get_access_subtitle));
    /* access modifiers changed from: private */
    public final p viewModel;

    /* compiled from: GetAccessViewController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public GetAccessViewController(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_get_access);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(p.class);
        h.a((Object) a2, "LifecycleViewModelProvid…essViewModel::class.java)");
        this.viewModel = (p) a2;
        String str = "";
        this.sendedLogin = str;
        this.sendedPassword = str;
        setProgress(100);
        Integer s = ((f) getState()).s();
        if (s != null) {
            setToolbarTitle(s.intValue());
        }
        this.loginFocusawareEditText.setHint(getString(R.string.common_global_colon_template, getString(R.string.common_global_login)));
        this.passwordFocusawareEditText.setHint(getString(R.string.common_global_colon_template, getString(R.string.common_global_password)));
        if (!((f) getState()).n()) {
            c.a((c) getActivity(), getToolbar(), getString(R.string.common_more_add_bank), null, true, 0, 20, null);
        } else {
            this.expiredSessionTitleTextView.setVisibility(0);
            this.expiredSessionTitleTextView.setText(getString(R.string.common_registration_login_and_password_error_title, com.touchin.vtb.e.c.a(((f) getState()).q(), getActivity())));
            this.subtitleTextView.setTextColor(getColor(R.color.common_hint_color));
            setToolbarTitleVisible(false);
        }
        getView().setOnApplyWindowInsetsListener(new E(this));
        this.subtitleTextView.setText(getString(((f) getState()).n() ? R.string.common_registration_login_and_password_error_subtitle : R.string.common_registration_bank_description, com.touchin.vtb.e.c.a(((f) getState()).q(), getActivity())));
        initPasswordListeners();
        this.progressButton.setOnClickListener(new F(this));
        this.restoreAccountView.setOnClickListener(new G(this));
        this.passwordFocusawareEditText.setOnFocusAction(new I(this));
        this.passwordFocusawareEditText.setOnEditTextClickListener(new K(this));
        this.loginFocusawareEditText.setOnFocusAction(new M(this));
        observeData();
    }

    private final void initPasswordListeners() {
        this.passwordFocusawareEditText.a((TextWatcher) new com.touchin.vtb.utils.q(new N(this)));
    }

    private final void observeData() {
        this.viewModel.c().a(this, new Q(this));
        this.viewModel.d().a(this, new S(this));
    }

    public void navigateToGetAccess(c cVar, BankConnectionStatus bankConnectionStatus, String str, BankType bankType, List<BankConnectResponse> list) {
        h.b(cVar, "activity");
        h.b(bankConnectionStatus, "status");
        h.b(str, "connectedBankId");
        h.b(bankType, "connectedBankType");
        h.b(list, "banksToRestoreSession");
        C0079a.a(this, cVar, bankConnectionStatus, str, bankType, list);
    }

    public void navigateToSuccess(c cVar, String str) {
        h.b(cVar, "activity");
        C0079a.a(this, cVar, str);
    }
}
