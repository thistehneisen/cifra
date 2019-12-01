package com.touchin.vtb.viewcontrollers.main.more;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.touchin.vtb.h.c.i;

/* compiled from: LoginSettingsViewController.kt */
final class h implements OnCheckedChangeListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ LoginSettingsViewController f7655a;

    h(LoginSettingsViewController loginSettingsViewController) {
        this.f7655a = loginSettingsViewController;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        i.a(this.f7655a.fingerprintViewModel, z, null, 2, null);
    }
}
