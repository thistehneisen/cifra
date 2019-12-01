package com.touchin.vtb.viewcontrollers.main.bank;

import com.touchin.vtb.api.BankConnectStatusesResponse;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.m;
import l.a.c.a.a;

/* compiled from: BankViewController.kt */
final /* synthetic */ class e extends g implements b<a<? extends BankConnectStatusesResponse>, m> {
    e(BankViewController bankViewController) {
        super(1, bankViewController);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((a) obj);
        return m.f10346a;
    }

    public final String f() {
        return "showCheckBankStatusesEvent";
    }

    public final kotlin.g.e g() {
        return o.a(BankViewController.class);
    }

    public final String i() {
        return "showCheckBankStatusesEvent(Lru/touchin/lifecycle/event/ContentEvent;)V";
    }

    public final void a(a<? extends BankConnectStatusesResponse> aVar) {
        h.b(aVar, "p1");
        ((BankViewController) this.receiver).showCheckBankStatusesEvent(aVar);
    }
}
