package com.touchin.vtb.viewcontrollers.main.bank;

import com.touchin.vtb.a.q;
import java.util.List;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;
import kotlin.m;
import l.a.c.a.a;

/* compiled from: BankViewController.kt */
final /* synthetic */ class d extends g implements b<a<? extends List<? extends q.a>>, m> {
    d(BankViewController bankViewController) {
        super(1, bankViewController);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((a) obj);
        return m.f10346a;
    }

    public final String f() {
        return "showOperationsList";
    }

    public final e g() {
        return o.a(BankViewController.class);
    }

    public final String i() {
        return "showOperationsList(Lru/touchin/lifecycle/event/ContentEvent;)V";
    }

    public final void a(a<? extends List<q.a>> aVar) {
        h.b(aVar, "p1");
        ((BankViewController) this.receiver).showOperationsList(aVar);
    }
}
