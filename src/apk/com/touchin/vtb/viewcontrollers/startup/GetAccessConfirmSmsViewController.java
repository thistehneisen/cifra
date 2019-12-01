package com.touchin.vtb.viewcontrollers.startup;

import android.os.CountDownTimer;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BankConnectionStatus;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.g.e;
import com.touchin.vtb.h.c.m;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import com.touchin.vtb.viewcontrollers.base.a.C0079a;
import com.touchin.vtb.views.ProgressButton;
import java.util.List;
import kotlin.e.b.h;
import l.a.b.g;
import l.a.c.c.q;
import l.a.d.a.b.a.b;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/* compiled from: GetAccessConfirmSmsViewController.kt */
public final class GetAccessConfirmSmsViewController extends VTBViewController<c, e> implements com.touchin.vtb.viewcontrollers.base.a {
    public static final a Companion = new a(null);
    private static final long DEFAULT_SMS_CODE_REPEAT_TIME_MILLIS = 30000;
    private static final String HARDCODED_REPEAT_TIME_SECONDS = "30";
    private static final long ONE_SECOND_MILLIS = 1000;
    private static final long SCROLLING_DELAY_MILLIS = 100;
    /* access modifiers changed from: private */
    public final EditText editText = ((EditText) findViewById(R.id.view_controller_get_access_confirm_sms_edit_text));
    /* access modifiers changed from: private */
    public final ProgressButton progressButton = ((ProgressButton) findViewById(R.id.view_controller_get_access_confirm_sms_progress_button));
    /* access modifiers changed from: private */
    public final TextView repeatTextView = ((TextView) findViewById(R.id.view_controller_get_access_confirm_sms_repeat));
    /* access modifiers changed from: private */
    public final ScrollView scrollView = ((ScrollView) findViewById(R.id.view_controller_get_access_confirm_sms_scroll));
    private final TextView subtitle = ((TextView) findViewById(R.id.view_controller_get_access_confirm_sms_subtitle));
    private CountDownTimer timer;
    /* access modifiers changed from: private */
    public final m viewModel;

    /* compiled from: GetAccessConfirmSmsViewController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public GetAccessConfirmSmsViewController(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_get_access_confirm_sms);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(m.class);
        h.a((Object) a2, "LifecycleViewModelProvid…SmsViewModel::class.java)");
        this.viewModel = (m) a2;
        this.subtitle.setText(getString(((e) getState()).n() ? R.string.common_registration_bank_sms_code_error_subtitle : R.string.common_registration_bank_sms_code_subtitle, com.touchin.vtb.e.c.a(((e) getState()).o(), getActivity())));
        this.repeatTextView.setText(getString(R.string.common_registration_code_send_after_button_title, HARDCODED_REPEAT_TIME_SECONDS));
        initListeners();
        initObservers();
        initTimer();
        getView().setOnApplyWindowInsetsListener(new r(this));
    }

    private final CountDownTimer createCountdownTimer(long j2) {
        if (j2 < 0) {
            this.repeatTextView.setText(getString(R.string.common_registration_code_resend_button_title));
            return null;
        }
        com.touchin.vtb.utils.b.a aVar = new com.touchin.vtb.utils.b.a(getActivity(), this.repeatTextView, new C0699s(this), j2, 1000);
        return aVar;
    }

    private final void initListeners() {
        this.editText.addTextChangedListener(new com.touchin.vtb.utils.q(new C0700t(this)));
        this.editText.setOnFocusChangeListener(new C0702v(this));
        this.editText.setOnClickListener(new C0704x(this));
        g.a(this.repeatTextView, new C0705y(this));
        g.a(this.progressButton, new C0706z(this));
    }

    private final void initObservers() {
        this.viewModel.f().a(this, new C(this));
        this.viewModel.c().a(this, new D(this));
    }

    private final void initTimer() {
        if (this.timer == null) {
            this.repeatTextView.setText(getString(R.string.common_registration_code_send_after_button_title, HARDCODED_REPEAT_TIME_SECONDS));
            startTimer();
        }
    }

    /* access modifiers changed from: private */
    public final void onBankConnected() {
        if (((e) getState()).t() != null) {
            ((c) getActivity()).d().a(com.touchin.vtb.b.h.SUCCESS_CONNECT_BANK);
            if (!((e) getState()).p().isEmpty()) {
                BankConnectResponse bankConnectResponse = (BankConnectResponse) ((e) getState()).p().get(0);
                ((e) getState()).p().remove(bankConnectResponse);
                c cVar = (c) getActivity();
                BankConnectionStatus b2 = bankConnectResponse.b();
                h.a((Object) b2, "bankToNextRestoreSession.bankConnectionStatus");
                String c2 = bankConnectResponse.c();
                String str = "bankToNextRestoreSession.connectedBankId";
                h.a((Object) c2, str);
                m mVar = this.viewModel;
                String c3 = bankConnectResponse.c();
                h.a((Object) c3, str);
                BankType a2 = mVar.a(c3);
                if (a2 != null) {
                    navigateToGetAccess(cVar, b2, c2, a2, ((e) getState()).p());
                    return;
                }
                throw new ShouldNotHappenException("BankType is not init");
            }
            navigateToSuccess((c) getActivity(), ((e) getState()).t());
            return;
        }
        ((c) getActivity()).d().a(com.touchin.vtb.b.h.SUCCESS_CONNECT_BANK);
        ((c) getActivity()).a(com.touchin.vtb.activities.MainActivity.a.a(MainActivity.f6990g, getActivity(), null, null, 0, 14, null));
    }

    /* access modifiers changed from: private */
    public final void startTimer() {
        ((e) getState()).a(System.currentTimeMillis());
        this.timer = createCountdownTimer((((e) getState()).r() - System.currentTimeMillis()) + DEFAULT_SMS_CODE_REPEAT_TIME_MILLIS);
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
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

    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void onStart() {
        super.onStart();
        b.b(this.editText);
    }
}
