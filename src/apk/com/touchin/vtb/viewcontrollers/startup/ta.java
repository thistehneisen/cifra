package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.activities.StartupActivity;
import l.a.d.a.a.a.b;

/* compiled from: UpdateViewController.kt */
final class ta implements b {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ UpdateViewController f7728a;

    ta(UpdateViewController updateViewController) {
        this.f7728a = updateViewController;
    }

    public final boolean a() {
        if (this.f7728a.isCancelable) {
            ((StartupActivity) this.f7728a.getActivity()).f();
        } else {
            ((StartupActivity) this.f7728a.getActivity()).finish();
        }
        return true;
    }
}
