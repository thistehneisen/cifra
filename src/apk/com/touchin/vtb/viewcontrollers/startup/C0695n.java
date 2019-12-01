package com.touchin.vtb.viewcontrollers.startup;

import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;
import kotlin.m;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.n reason: case insensitive filesystem */
/* compiled from: EnterPinViewController.kt */
final /* synthetic */ class C0695n extends g implements b<String, m> {
    C0695n(EnterPinViewController enterPinViewController) {
        super(1, enterPinViewController);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((String) obj);
        return m.f10346a;
    }

    public final String f() {
        return "onPasswordEntered";
    }

    public final e g() {
        return o.a(EnterPinViewController.class);
    }

    public final String i() {
        return "onPasswordEntered(Ljava/lang/String;)V";
    }

    public final void a(String str) {
        h.b(str, "p1");
        ((EnterPinViewController) this.receiver).onPasswordEntered(str);
    }
}
