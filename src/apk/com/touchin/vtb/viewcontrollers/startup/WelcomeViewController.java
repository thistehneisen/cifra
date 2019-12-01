package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.widget.ScrollView;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.StartupActivity;
import com.touchin.vtb.g.o;
import com.touchin.vtb.h.c.B;
import com.touchin.vtb.utils.s;
import com.touchin.vtb.viewcontrollers.base.RegistrationWithTitleViewController;
import com.touchin.vtb.views.GlobalErrorView;
import com.touchin.vtb.views.ProgressButton;
import com.touchin.vtb.views.maskededittext.FocusawarePhoneMaskedEditText;
import kotlin.e.b.h;
import l.a.b.g;
import l.a.c.c.q;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;
import ru.touchin.widget.Switcher;

/* compiled from: WelcomeViewController.kt */
public final class WelcomeViewController extends RegistrationWithTitleViewController<StartupActivity, o> {
    public static final a Companion = new a(null);
    private static final int PHONE_RAW_LENGTH = 10;
    /* access modifiers changed from: private */
    public final GlobalErrorView errorView = ((GlobalErrorView) findViewById(R.id.welcome_view_controller_error));
    /* access modifiers changed from: private */
    public final FocusawarePhoneMaskedEditText phoneMaskedEditText = ((FocusawarePhoneMaskedEditText) findViewById(R.id.welcome_view_controller_phone_masked_edit_text));
    /* access modifiers changed from: private */
    public final ProgressButton progressButton = ((ProgressButton) findViewById(R.id.welcome_view_controller_progress_button));
    private final View rulesTextView = findViewById(R.id.welcome_view_controller_personal_rules_text_view);
    /* access modifiers changed from: private */
    public final ScrollView scrollView = ((ScrollView) findViewById(R.id.welcome_view_controller_scroll));
    /* access modifiers changed from: private */
    public int scrollYPositionWithOpenedKeyboard;
    /* access modifiers changed from: private */
    public final Switcher switcher = ((Switcher) findViewById(R.id.welcome_view_controller_switcher));
    private final B viewModel;

    /* compiled from: WelcomeViewController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public WelcomeViewController(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_welcome);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(B.class);
        h.a((Object) a2, "LifecycleViewModelProvid…omeViewModel::class.java)");
        this.viewModel = (B) a2;
        if (((o) getState()).n()) {
            com.touchin.vtb.utils.h.a(com.touchin.vtb.utils.h.f7619a, getActivity(), getString(R.string.common_pin_code_exit_alert_title), getString(R.string.common_pin_code_exit_alert_description), getString(R.string.common_global_ok), "", va.f7731a, null, false, R.layout.dialog_alert, 64, null);
        }
        setRegistrationToolbarVisible(true);
        this.phoneMaskedEditText.setTextChangedListener(new com.touchin.vtb.utils.q(new wa(this)));
        getView().setOnApplyWindowInsetsListener(new ya(this));
        this.phoneMaskedEditText.setOnClickAction(new za(this));
        g.a(this.progressButton, new Aa(this));
        this.viewModel.c().a(this, new Ea(this));
        this.rulesTextView.setOnClickListener(new Fa(this));
    }

    /* access modifiers changed from: private */
    public final void navigateToConfirm(String str) {
        String b2 = s.f7640a.b(this.phoneMaskedEditText.getRaw());
        com.touchin.vtb.g.h hVar = new com.touchin.vtb.g.h(str, s.f7640a.a(this.phoneMaskedEditText.getTextString()), b2, 0, 8, null);
        d.a(((StartupActivity) getActivity()).c(), RegistrationConfirmSmsViewController.class, hVar, false, null, null, 28, null);
        this.phoneMaskedEditText.a();
    }

    /* access modifiers changed from: private */
    public final void registerUser() {
        this.viewModel.a(s.f7640a.a(this.phoneMaskedEditText.getTextString()));
    }
}
