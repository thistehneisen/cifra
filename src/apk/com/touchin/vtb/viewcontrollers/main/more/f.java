package com.touchin.vtb.viewcontrollers.main.more;

import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.viewcontrollers.startup.EnterPinViewController;
import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/* compiled from: LoginSettingsViewController.kt */
final class f extends i implements a<m> {
    final /* synthetic */ LoginSettingsViewController this$0;

    f(LoginSettingsViewController loginSettingsViewController) {
        this.this$0 = loginSettingsViewController;
        super(0);
    }

    public final void b() {
        d c2 = ((c) this.this$0.getActivity()).c();
        Class<EnterPinViewController> cls = EnterPinViewController.class;
        l.a.c.a.a aVar = (l.a.c.a.a) this.this$0.viewModel.d().a();
        if (aVar != null) {
            String str = (String) aVar.a();
            if (str != null) {
                com.touchin.vtb.g.d dVar = new com.touchin.vtb.g.d(str, false, 0, false, true, null, null, 0, Integer.valueOf(R.string.common_more_login_settings_change_entry_code), null, R.string.common_pin_code_check_code, 0, 2796, null);
                d.a(c2, cls, dVar, this.this$0.getFragment(), 400, null, null, 48, null);
                return;
            }
        }
        throw new ShouldNotHappenException("Pin can't be null");
    }
}
