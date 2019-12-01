package com.touchin.vtb.viewcontrollers.startup;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.C0200o;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.b.f;
import com.touchin.vtb.b.g;
import com.touchin.vtb.b.i;
import com.touchin.vtb.g.d;
import com.touchin.vtb.h.c.e;
import com.touchin.vtb.viewcontrollers.base.RegistrationWithTitleViewController;
import com.touchin.vtb.views.pincode.PincodeView;
import java.util.Arrays;
import kotlin.e.b.h;
import l.a.c.c.q;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/* compiled from: EnterPinViewController.kt */
public final class EnterPinViewController extends RegistrationWithTitleViewController<c, d> {
    private final TextView attemptsCountTextView = ((TextView) findViewById(R.id.view_controller_enter_pin_attempts));
    private final PincodeView pincodeView = ((PincodeView) findViewById(R.id.view_controller_enter_pin_pincode));
    private final TextView subTitleTextView = ((TextView) findViewById(R.id.view_controller_enter_pin_subtitle));
    /* access modifiers changed from: private */
    public final e viewModel;

    public EnterPinViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_enter_pin);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(e.class);
        h.a((Object) a2, "LifecycleViewModelProvid…PinViewModel::class.java)");
        this.viewModel = (e) a2;
        initializeToolbars();
        updateAttemptsString(((d) getState()).n());
        this.subTitleTextView.setText(getString(((d) getState()).s()));
        int i2 = 8;
        findViewById(R.id.registration_title).setVisibility(((d) getState()).x() ? 0 : 8);
        View findViewById = findViewById(R.id.global_app_bar_layout);
        if (((d) getState()).w()) {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
        if (((d) getState()).o() != null) {
            TextView textView = (TextView) findViewById(R.id.view_controller_enter_pin_hint);
            textView.setText(getString(((d) getState()).o().intValue()));
            textView.setVisibility(0);
        }
        initializePincodeView();
        this.viewModel.c().a(this, new C0694m(this));
    }

    private final void initializePincodeView() {
        this.pincodeView.setOnPincodeEnteredListener(new C0695n(this));
        if (((d) getState()).v()) {
            this.pincodeView.setOnFingerprintClickListener(new C0696o(this));
        }
        this.pincodeView.setOnForgotPasswordClickListener(new C0698q(this));
    }

    private final void initializeToolbars() {
        c cVar = (c) getActivity();
        Toolbar toolbar = (Toolbar) findViewById(R.id.global_toolbar);
        toolbar.setVisibility(((d) getState()).x() ^ true ? 0 : 8);
        Integer t = ((d) getState()).t();
        String string = t != null ? getString(t.intValue()) : null;
        if (string == null) {
            string = "";
        }
        c.a(cVar, toolbar, string, null, true, ((d) getState()).t() == null ? R.drawable.common_navigation_item_close : R.drawable.common_navigation_icon_selector, 4, null);
    }

    private final boolean isConfirmState() {
        return ((d) getState()).s() == R.string.android_confirm_task_pay_title;
    }

    private final void navigateToMainActivity() {
        i d2 = ((c) getActivity()).d();
        d2.a((g) new g.d());
        d2.a((g) new g.e());
        ((c) getActivity()).a(MainActivity.f6990g.a(getActivity(), ((d) getState()).r(), ((d) getState()).u(), ((d) getState()).p()));
    }

    private final void onAuthenticated(boolean z) {
        if (((d) getState()).w()) {
            ru.touchin.roboswag.components.navigation.viewcontrollers.d c2 = ((c) getActivity()).c();
            Class<CreatePinViewController> cls = CreatePinViewController.class;
            com.touchin.vtb.g.c cVar = new com.touchin.vtb.g.c(null, null, true, 3, null);
            Fragment targetFragment = getFragment().getTargetFragment();
            if (targetFragment != null) {
                ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(c2, cls, cVar, targetFragment, 400, null, null, 48, null);
                return;
            }
            throw new ShouldNotHappenException("Target fragment should be specified");
        }
        Fragment targetFragment2 = getFragment().getTargetFragment();
        if (targetFragment2 != null) {
            targetFragment2.onActivityResult(isConfirmState() ? 301 : 300, z ? -1 : 0, null);
            ((c) getActivity()).c().a();
            return;
        }
        navigateToMainActivity();
    }

    static /* synthetic */ void onAuthenticated$default(EnterPinViewController enterPinViewController, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        enterPinViewController.onAuthenticated(z);
    }

    /* access modifiers changed from: private */
    public final void onPasswordEntered(String str) {
        if (validatePin(str)) {
            this.pincodeView.b();
            onAuthenticated$default(this, false, 1, null);
            return;
        }
        ((c) getActivity()).d().a(f.INVALID_ENTER_PIN);
        this.pincodeView.d();
        d dVar = (d) getState();
        dVar.a(dVar.n() - 1);
        updateAttemptsString(dVar.n());
        if (((d) getState()).n() != 0) {
            return;
        }
        if (((d) getState()).w()) {
            ((c) getActivity()).c().a();
        } else {
            this.viewModel.d();
        }
    }

    /* access modifiers changed from: private */
    public final void openFingerprintDialog() {
        com.touchin.vtb.utils.h hVar = com.touchin.vtb.utils.h.f7619a;
        C0200o requireFragmentManager = getFragment().requireFragmentManager();
        h.a((Object) requireFragmentManager, "fragment.requireFragmentManager()");
        com.touchin.vtb.utils.h.a(hVar, requireFragmentManager, 0, (Fragment) getFragment(), (String) null, getString(R.string.android_fingerprint_authorized_title), getString(R.string.android_fingerprint_authorized_action), 10, (Object) null);
    }

    private final void updateAttemptsString(int i2) {
        String str;
        kotlin.e.b.q qVar = kotlin.e.b.q.f10310a;
        String quantityString = ((c) getActivity()).getResources().getQuantityString(R.plurals.attempts_left, i2);
        h.a((Object) quantityString, "activity.resources.getQu…empts_left, attemptsLeft)");
        Object[] objArr = new Object[0];
        String format = String.format(quantityString, Arrays.copyOf(objArr, objArr.length));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        TextView textView = this.attemptsCountTextView;
        if (i2 == 1) {
            str = getString(R.string.common_pin_code_attempts_last);
        } else if (i2 != 5) {
            str = getString(R.string.android_pin_code_attempts_left, Integer.valueOf(i2), format);
        } else {
            str = getString(R.string.android_pin_code_attempts_current, Integer.valueOf(i2), format);
        }
        textView.setText(str);
    }

    private final boolean validatePin(String str) {
        return h.a((Object) str, (Object) ((d) getState()).q());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 200) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            onAuthenticated$default(this, false, 1, null);
        } else if (i3 != 201) {
            super.onActivityResult(i2, i3, intent);
        } else {
            this.pincodeView.c();
        }
    }
}
