package com.touchin.vtb.viewcontrollers.main.more;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.h.b.f;
import com.touchin.vtb.h.c.i;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import kotlin.e.b.h;
import l.a.b.g;
import l.a.c.c.q;
import ru.touchin.roboswag.components.navigation.viewcontrollers.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;

/* compiled from: LoginSettingsViewController.kt */
public final class LoginSettingsViewController extends VTBViewController<c, b> {
    /* access modifiers changed from: private */
    public final i fingerprintViewModel;
    private final View useFingerprintButton = findViewById(R.id.view_controller_login_settings_user_fingerprint_button);
    private final SwitchCompat useFingerprintSwitch = ((SwitchCompat) findViewById(R.id.view_controller_login_settings_use_fingerprint_switch));
    /* access modifiers changed from: private */
    public final f viewModel;

    public LoginSettingsViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_login_settings);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(f.class);
        h.a((Object) a2, "LifecycleViewModelProvid…ngsViewModel::class.java)");
        this.viewModel = (f) a2;
        C a3 = q.a(q.f10391a, this, null, 2, null).a(i.class);
        h.a((Object) a3, "LifecycleViewModelProvid…intViewModel::class.java)");
        this.fingerprintViewModel = (i) a3;
        initializeToolbars();
        initializerViews();
    }

    private final void initializeToolbars() {
        c.a((c) getActivity(), (Toolbar) findViewById(R.id.global_toolbar), getString(R.string.common_more_login_settings), null, true, 0, 20, null);
    }

    private final void initializerViews() {
        g.a(findViewById(R.id.view_controller_login_settings_change_password), new f(this));
        boolean e2 = this.fingerprintViewModel.e();
        int i2 = 0;
        this.useFingerprintSwitch.setVisibility(e2 ? 0 : 8);
        this.useFingerprintButton.setVisibility(e2 ? 0 : 8);
        findViewById(R.id.view_controller_login_settings_fingerprint_hint).setVisibility(e2 ? 0 : 8);
        findViewById(R.id.view_controller_login_settings_use_fingerprint).setVisibility(e2 ? 0 : 8);
        View findViewById = findViewById(R.id.view_controller_login_settings_divider_1);
        if (!e2) {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        this.useFingerprintButton.setEnabled(this.fingerprintViewModel.e());
        this.useFingerprintSwitch.setEnabled(this.useFingerprintButton.isEnabled());
        this.useFingerprintSwitch.setChecked(this.fingerprintViewModel.f());
        g.a(this.useFingerprintButton, new g(this.useFingerprintSwitch));
        this.useFingerprintSwitch.setOnCheckedChangeListener(new h(this));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 200) {
            if (i2 == 400 && i3 == -1) {
                l.a.d.a.a.a.a(((c) getActivity()).c(), null, false, 3, null);
            }
        } else if (i3 == -1) {
            this.useFingerprintSwitch.setChecked(true);
            i.a(this.fingerprintViewModel, true, null, 2, null);
        }
        if (i2 == 200 && i3 == -1) {
            this.useFingerprintSwitch.setChecked(true);
            i.a(this.fingerprintViewModel, true, null, 2, null);
        }
    }
}
