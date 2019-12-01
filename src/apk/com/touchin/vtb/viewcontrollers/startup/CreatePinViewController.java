package com.touchin.vtb.viewcontrollers.startup;

import android.content.Intent;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.f.e;
import com.touchin.vtb.h.c.C0675c;
import com.touchin.vtb.h.c.i;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import com.touchin.vtb.viewcontrollers.main.more.LoginSettingsViewController;
import com.touchin.vtb.viewcontrollers.success.SuccessViewController;
import com.touchin.vtb.views.pincode.PincodeView;
import kotlin.TypeCastException;
import kotlin.e.b.h;
import kotlin.m;
import l.a.c.c.q;
import l.a.d.a.a.a.b;
import l.a.d.a.b.a.C0122a;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/* compiled from: CreatePinViewController.kt */
public final class CreatePinViewController extends VTBViewController<c, com.touchin.vtb.g.c> {
    public static final a Companion = new a(null);
    private static final float PIN_CHANGE_TITLE_BOTTOM_MARGIN = 0.0f;
    private static final float PIN_CHANGE_TITLE_END_MARGIN = 16.0f;
    private static final float PIN_CHANGE_TITLE_START_MARGIN = 16.0f;
    private static final float PIN_CHANGE_TITLE_TOP_MARGIN = 8.0f;
    private static final float PIN_CHANGE_WITHOUT_TITLE_TOP_MARGIN = 64.0f;
    private final b backPressListener = new C0690i(this);
    /* access modifiers changed from: private */
    public final i fingerprintViewModel;
    private final PincodeView pincodeView = ((PincodeView) findViewById(R.id.view_controller_create_pin_pincode));
    private final TextView title = ((TextView) findViewById(R.id.view_controller_create_pin_title));
    private final C0675c viewModel;

    /* compiled from: CreatePinViewController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public CreatePinViewController(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_create_pin);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(C0675c.class);
        h.a((Object) a2, "LifecycleViewModelProvid…PinViewModel::class.java)");
        this.viewModel = (C0675c) a2;
        C a3 = q.a(q.f10391a, this, null, 2, null).a(i.class);
        h.a((Object) a3, "LifecycleViewModelProvid…intViewModel::class.java)");
        this.fingerprintViewModel = (i) a3;
        initializeToolbars$default(this, false, 1, null);
        initializePincodeView();
        this.viewModel.c().a(this, new C0688g(this));
    }

    private final void initializePincodeView() {
        this.pincodeView.setOnPincodeEnteredListener(new C0691j(this));
    }

    private final void initializeToolbars(boolean z) {
        c cVar = (c) getActivity();
        Toolbar toolbar = (Toolbar) findViewById(R.id.global_toolbar);
        toolbar.setVisibility(((com.touchin.vtb.g.c) getState()).p() ? 0 : 8);
        c.a(cVar, toolbar, (!z || !((com.touchin.vtb.g.c) getState()).p()) ? "" : getString(R.string.common_more_login_settings_change_entry_code), null, true, 0, 20, null);
        if (((com.touchin.vtb.g.c) getState()).p()) {
            setTitleMargin(true);
        }
    }

    static /* synthetic */ void initializeToolbars$default(CreatePinViewController createPinViewController, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = ((com.touchin.vtb.g.c) createPinViewController.getState()).p();
        }
        createPinViewController.initializeToolbars(z);
    }

    /* access modifiers changed from: private */
    public final void navigateToMainViewController() {
        ((c) getActivity()).a(com.touchin.vtb.activities.MainActivity.a.a(MainActivity.f6990g, getActivity(), null, null, 0, 14, null));
    }

    /* access modifiers changed from: private */
    public final void onPasswordEntered(String str) {
        int i2 = C0689h.f7719a[((com.touchin.vtb.g.c) getState()).o().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                ((com.touchin.vtb.g.c) getState()).a(str);
                setViewState(e.SECOND_PASSWORD);
            }
        } else if (validatePin(str)) {
            ((com.touchin.vtb.g.c) getState()).a(e.SET_FINGERPRINT);
            this.pincodeView.setEnabled(false);
            this.viewModel.a(str);
        } else {
            this.pincodeView.d();
        }
    }

    /* access modifiers changed from: private */
    public final void onPinSetSuccessfully() {
        if (((com.touchin.vtb.g.c) getState()).p()) {
            d c2 = ((c) getActivity()).c();
            Class<SuccessViewController> cls = SuccessViewController.class;
            com.touchin.vtb.viewcontrollers.success.a aVar = new com.touchin.vtb.viewcontrollers.success.a(getString(R.string.common_pin_code_success_title), getString(R.string.common_more_add_bank_success_description), LoginSettingsViewController.class.getName());
            Fragment targetFragment = getFragment().getTargetFragment();
            if (targetFragment != null) {
                d.a(c2, cls, aVar, targetFragment, 400, null, null, 48, null);
                return;
            }
            throw new ShouldNotHappenException("Target fragment should be specified");
        }
        ((c) getActivity()).d().a(com.touchin.vtb.b.h.FIRST_LOGIN);
        this.viewModel.a((kotlin.e.a.a<m>) new C0693l<m>(this));
    }

    private final void setTitleMargin(boolean z) {
        LayoutParams layoutParams = this.title.getLayoutParams();
        if (layoutParams != null) {
            androidx.constraintlayout.widget.ConstraintLayout.a aVar = (androidx.constraintlayout.widget.ConstraintLayout.a) layoutParams;
            aVar.setMargins((int) C0122a.a(getActivity(), 16.0f), (int) C0122a.a(getActivity(), z ? PIN_CHANGE_TITLE_TOP_MARGIN : PIN_CHANGE_WITHOUT_TITLE_TOP_MARGIN), (int) C0122a.a(getActivity(), 16.0f), (int) C0122a.a(getActivity(), PIN_CHANGE_TITLE_BOTTOM_MARGIN));
            this.title.setLayoutParams(aVar);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    /* access modifiers changed from: private */
    public final void setViewState(e eVar) {
        int i2;
        this.pincodeView.a();
        ((com.touchin.vtb.g.c) getState()).a(eVar);
        TextView textView = this.title;
        if (eVar == e.FIRST_PASSWORD) {
            initializeToolbars$default(this, false, 1, null);
            ((com.touchin.vtb.g.c) getState()).a("");
            if (((com.touchin.vtb.g.c) getState()).p()) {
                i2 = R.string.common_pin_code_new_code;
            } else {
                setTitleMargin(false);
                i2 = R.string.common_pin_code_create_code;
            }
        } else {
            initializeToolbars(true);
            setTitleMargin(((com.touchin.vtb.g.c) getState()).p());
            i2 = ((com.touchin.vtb.g.c) getState()).p() ? R.string.common_pin_code_confirm_new_code : R.string.common_pin_code_confirm_code;
        }
        textView.setText(getString(i2));
    }

    private final boolean validatePin(String str) {
        return h.a((Object) str, (Object) ((com.touchin.vtb.g.c) getState()).n());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 200) {
            super.onActivityResult(i2, i3, intent);
            return;
        }
        this.fingerprintViewModel.a(i3 == -1, new C0692k(this));
        onPinSetSuccessfully();
    }

    public void onStart() {
        super.onStart();
        setViewState(((com.touchin.vtb.g.c) getState()).o());
        ((c) getActivity()).a(this.backPressListener);
    }

    public void onStop() {
        super.onStop();
        ((c) getActivity()).b(this.backPressListener);
    }
}
