package com.touchin.vtb.viewcontrollers.main.more;

import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.m;

/* compiled from: BanksManagementViewController.kt */
final /* synthetic */ class e extends g implements b<String, m> {
    e(BanksManagementViewController banksManagementViewController) {
        super(1, banksManagementViewController);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((String) obj);
        return m.f10346a;
    }

    public final String f() {
        return "deleteBank";
    }

    public final kotlin.g.e g() {
        return o.a(BanksManagementViewController.class);
    }

    public final String i() {
        return "deleteBank(Ljava/lang/String;)V";
    }

    public final void a(String str) {
        h.b(str, "p1");
        ((BanksManagementViewController) this.receiver).deleteBank(str);
    }
}
