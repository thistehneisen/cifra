package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.utils.b.a;

/* compiled from: View.kt */
public final class Z implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0679ba f7704a;

    public Z(C0679ba baVar) {
        this.f7704a = baVar;
    }

    public final void run() {
        a access$getTimer$p = this.f7704a.f7708a.timer;
        if (access$getTimer$p != null) {
            access$getTimer$p.a(false);
        }
    }
}
