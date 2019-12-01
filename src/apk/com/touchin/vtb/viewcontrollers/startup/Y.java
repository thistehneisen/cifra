package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.activities.StartupActivity;
import com.touchin.vtb.activities.StartupActivity.a;

/* compiled from: View.kt */
public final class Y implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0679ba f7703a;

    public Y(C0679ba baVar) {
        this.f7703a = baVar;
    }

    public final void run() {
        ((StartupActivity) this.f7703a.f7708a.getActivity()).a(a.a(StartupActivity.f6994g, this.f7703a.f7708a.getActivity(), true, null, null, null, 0, 60, null));
    }
}
