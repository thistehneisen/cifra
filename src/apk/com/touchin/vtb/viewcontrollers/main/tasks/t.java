package com.touchin.vtb.viewcontrollers.main.tasks;

import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.o;
import kotlin.g.e;
import kotlin.m;

/* compiled from: TasksTabsViewController.kt */
final /* synthetic */ class t extends g implements b<Integer, m> {
    t(TasksTabsViewController tasksTabsViewController) {
        super(1, tasksTabsViewController);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a(((Number) obj).intValue());
        return m.f10346a;
    }

    public final String f() {
        return "onSwiped";
    }

    public final e g() {
        return o.a(TasksTabsViewController.class);
    }

    public final String i() {
        return "onSwiped(I)V";
    }

    public final void a(int i2) {
        ((TasksTabsViewController) this.receiver).onSwiped(i2);
    }
}
