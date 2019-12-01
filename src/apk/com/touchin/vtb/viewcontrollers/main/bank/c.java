package com.touchin.vtb.viewcontrollers.main.bank;

import java.util.List;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;
import kotlin.m;
import l.a.c.a.a;

/* compiled from: BankViewController.kt */
final /* synthetic */ class c extends g implements b<a<? extends List<? extends com.touchin.vtb.f.b>>, m> {
    c(BankViewController bankViewController) {
        super(1, bankViewController);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((a) obj);
        return m.f10346a;
    }

    public final String f() {
        return "showAccountsList";
    }

    public final e g() {
        return o.a(BankViewController.class);
    }

    public final String i() {
        return "showAccountsList(Lru/touchin/lifecycle/event/ContentEvent;)V";
    }

    public final void a(a<? extends List<com.touchin.vtb.f.b>> aVar) {
        h.b(aVar, "p1");
        ((BankViewController) this.receiver).showAccountsList(aVar);
    }
}
