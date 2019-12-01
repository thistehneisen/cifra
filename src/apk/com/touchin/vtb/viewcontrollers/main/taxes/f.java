package com.touchin.vtb.viewcontrollers.main.taxes;

import com.touchin.vtb.api.TaxesListResponse;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;
import kotlin.m;
import l.a.c.a.a;

/* compiled from: TaxesViewController.kt */
final /* synthetic */ class f extends g implements b<a<? extends TaxesListResponse>, m> {
    f(TaxesViewController taxesViewController) {
        super(1, taxesViewController);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((a) obj);
        return m.f10346a;
    }

    public final String f() {
        return "showTaxesListEvent";
    }

    public final e g() {
        return o.a(TaxesViewController.class);
    }

    public final String i() {
        return "showTaxesListEvent(Lru/touchin/lifecycle/event/ContentEvent;)V";
    }

    public final void a(a<? extends TaxesListResponse> aVar) {
        h.b(aVar, "p1");
        ((TaxesViewController) this.receiver).showTaxesListEvent(aVar);
    }
}
