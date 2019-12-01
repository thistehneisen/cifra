package com.touchin.vtb.viewcontrollers.startup;

import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;
import kotlin.m;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.j reason: case insensitive filesystem */
/* compiled from: CreatePinViewController.kt */
final /* synthetic */ class C0691j extends g implements b<String, m> {
    C0691j(CreatePinViewController createPinViewController) {
        super(1, createPinViewController);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((String) obj);
        return m.f10346a;
    }

    public final String f() {
        return "onPasswordEntered";
    }

    public final e g() {
        return o.a(CreatePinViewController.class);
    }

    public final String i() {
        return "onPasswordEntered(Ljava/lang/String;)V";
    }

    public final void a(String str) {
        h.b(str, "p1");
        ((CreatePinViewController) this.receiver).onPasswordEntered(str);
    }
}
