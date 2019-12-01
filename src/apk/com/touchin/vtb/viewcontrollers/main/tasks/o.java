package com.touchin.vtb.viewcontrollers.main.tasks;

import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.g.e;
import kotlin.m;

/* compiled from: TasksTabsViewController.kt */
final /* synthetic */ class o extends g implements b<String, m> {
    o(TasksTabsViewController tasksTabsViewController) {
        super(1, tasksTabsViewController);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((String) obj);
        return m.f10346a;
    }

    public final String f() {
        return "restoreTaskAction";
    }

    public final e g() {
        return kotlin.e.b.o.a(TasksTabsViewController.class);
    }

    public final String i() {
        return "restoreTaskAction(Ljava/lang/String;)V";
    }

    public final void a(String str) {
        h.b(str, "p1");
        ((TasksTabsViewController) this.receiver).restoreTaskAction(str);
    }
}
