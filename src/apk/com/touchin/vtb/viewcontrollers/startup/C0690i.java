package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.f.e;
import com.touchin.vtb.g.c;
import com.touchin.vtb.viewcontrollers.main.more.LoginSettingsViewController;
import l.a.d.a.a.a;
import l.a.d.a.a.a.b;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.i reason: case insensitive filesystem */
/* compiled from: CreatePinViewController.kt */
final class C0690i implements b {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ CreatePinViewController f7721a;

    C0690i(CreatePinViewController createPinViewController) {
        this.f7721a = createPinViewController;
    }

    public final boolean a() {
        if (((c) this.f7721a.getState()).p()) {
            a.a(((com.touchin.vtb.activities.c) this.f7721a.getActivity()).c(), LoginSettingsViewController.class.getName(), false, 2, null);
            return true;
        } else if (((c) this.f7721a.getState()).o() != e.SECOND_PASSWORD) {
            return false;
        } else {
            this.f7721a.setViewState(e.FIRST_PASSWORD);
            return true;
        }
    }
}
