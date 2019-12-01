package com.touchin.vtb.viewcontrollers.startup;

import androidx.lifecycle.v;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.activities.MainActivity.a;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.b.h;

/* compiled from: GetAccessViewController.kt */
final class S<T> implements v<Void> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ GetAccessViewController f7701a;

    S(GetAccessViewController getAccessViewController) {
        this.f7701a = getAccessViewController;
    }

    public final void a(Void voidR) {
        ((c) this.f7701a.getActivity()).d().a(h.SUCCESS_CONNECT_BANK);
        ((c) this.f7701a.getActivity()).a(a.a(MainActivity.f6990g, this.f7701a.getActivity(), null, null, 0, 14, null));
    }
}
