package com.touchin.vtb.viewcontrollers.startup;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.StartupActivity;
import com.touchin.vtb.g.h;
import com.touchin.vtb.h.c.C0673a;
import com.touchin.vtb.views.separated_edit_text.SeparatedEditText;
import l.a.b.g;
import l.a.c.c.q;
import l.a.d.a.b.a.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c;

/* compiled from: RegistrationConfirmSmsViewController.kt */
public final class RegistrationConfirmSmsViewController extends c<StartupActivity, h> {
    public static final a Companion = new a(null);
    private static final long DEFAULT_SMS_CODE_REPEAT_TIME_MILLIS = 30000;
    private static final String HARDCODED_EXPIRED_TIME_MINUTES = "3 ";
    private static final String HARDCODED_REPEAT_TIME_SECONDS = "30";
    public static final long ONE_SECOND_MS = 1000;
    private static final long STATE_CHANGING_DELAY_MILLIS = 1000;
    private final View closeButton = findViewById(R.id.view_controller_registration_confirm_close);
    /* access modifiers changed from: private */
    public final View loader = findViewById(R.id.view_controller_registration_confirm_sms_loader);
    /* access modifiers changed from: private */
    public final TextView repeatTextView = ((TextView) findViewById(R.id.view_controller_registration_confirm_sms_repeat));
    /* access modifiers changed from: private */
    public final SeparatedEditText separatedEditText = ((SeparatedEditText) findViewById(R.id.view_controller_registration_confirm_sms_separated_edit_text));
    /* access modifiers changed from: private */
    public com.touchin.vtb.utils.b.a timer;
    private final TextView titleTextView = ((TextView) findViewById(R.id.view_controller_registration_confirm_sms_title));
    /* access modifiers changed from: private */
    public final C0673a viewModel;

    /* compiled from: RegistrationConfirmSmsViewController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public RegistrationConfirmSmsViewController(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar) {
        kotlin.e.b.h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_registration_confirm_sms);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(C0673a.class);
        kotlin.e.b.h.a((Object) a2, "LifecycleViewModelProvid…SmsViewModel::class.java)");
        this.viewModel = (C0673a) a2;
        TextView textView = this.titleTextView;
        StringBuilder sb = new StringBuilder();
        sb.append(HARDCODED_EXPIRED_TIME_MINUTES);
        sb.append(getString(R.string.common_global_minutes_two));
        textView.setText(getString(R.string.common_registration_code_sent_description, ((h) getState()).o(), sb.toString()));
        if (this.timer == null) {
            this.repeatTextView.setText(getString(R.string.common_registration_code_send_after_button_title, HARDCODED_REPEAT_TIME_SECONDS));
            startTimer();
        }
        this.separatedEditText.setOnCodeEnteredAction(new T(this));
        initListeners();
        initObservers();
    }

    private final com.touchin.vtb.utils.b.a createCountdownTimer(long j2) {
        if (j2 < 0) {
            this.loader.setVisibility(0);
            makeResendActive();
            return null;
        }
        this.repeatTextView.setVisibility(0);
        com.touchin.vtb.utils.b.a aVar = new com.touchin.vtb.utils.b.a(getActivity(), this.repeatTextView, new U(this), j2, 1000);
        return aVar;
    }

    private final void initListeners() {
        g.a(this.repeatTextView, new V(this));
        g.a(this.closeButton, new W(this));
    }

    private final void initObservers() {
        this.viewModel.d().a(this, new X(this));
        observerConfirmRegisterUserProgress();
    }

    /* access modifiers changed from: private */
    public final void makeResendActive() {
        if (this.loader.getVisibility() == 4) {
            TextView textView = this.repeatTextView;
            textView.setText(getString(R.string.common_registration_code_resend_button_title));
            textView.setEnabled(true);
            textView.setVisibility(0);
            textView.setTextColor(getColor(R.color.common_action_color));
        }
        this.timer = null;
    }

    private final void observerConfirmRegisterUserProgress() {
        this.viewModel.c().a(this, new C0679ba(this));
    }

    /* access modifiers changed from: private */
    public final void onCodeEntered() {
        ((StartupActivity) getActivity()).d().a(com.touchin.vtb.b.h.ENTER_PHONE_CONFIRM_SMS);
        this.viewModel.a(((h) getState()).q(), String.valueOf(this.separatedEditText.getInvisibleEditText().getText()));
    }

    /* access modifiers changed from: private */
    public final void startTimer() {
        this.timer = createCountdownTimer((((h) getState()).n() - System.currentTimeMillis()) + DEFAULT_SMS_CODE_REPEAT_TIME_MILLIS);
        com.touchin.vtb.utils.b.a aVar = this.timer;
        if (aVar != null) {
            aVar.start();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.touchin.vtb.utils.b.a aVar = this.timer;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public void onStart() {
        super.onStart();
        b.b(this.separatedEditText.getInvisibleEditText());
    }
}
