package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.g.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.da reason: case insensitive filesystem */
/* compiled from: View.kt */
public final class C0683da implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0687fa f7712a;

    public C0683da(C0687fa faVar) {
        this.f7712a = faVar;
    }

    public final void run() {
        b bVar = new b(null, R.string.common_more_add_bank, false, null, 13, null);
        d.a(((c) this.f7712a.f7716a.getActivity()).c(), ConnectBankViewController.class, bVar, false, null, null, 28, null);
    }
}
