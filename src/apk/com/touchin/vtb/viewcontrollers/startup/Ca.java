package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.R;
import com.touchin.vtb.f.h;

/* compiled from: View.kt */
public final class Ca implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Ea f7687a;

    public Ca(Ea ea) {
        this.f7687a = ea;
    }

    public final void run() {
        this.f7687a.f7690a.progressButton.setState(h.NORMAL);
        this.f7687a.f7690a.switcher.a(R.id.welcome_view_controller_content_container);
    }
}
