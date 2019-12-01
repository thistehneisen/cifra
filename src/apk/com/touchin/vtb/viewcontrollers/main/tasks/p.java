package com.touchin.vtb.viewcontrollers.main.tasks;

import com.touchin.vtb.api.TaskInfo;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;
import kotlin.m;

/* compiled from: TasksTabsViewController.kt */
final /* synthetic */ class p extends g implements b<TaskInfo, m> {
    p(TasksTabsViewController tasksTabsViewController) {
        super(1, tasksTabsViewController);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((TaskInfo) obj);
        return m.f10346a;
    }

    public final String f() {
        return "openTaskInfo";
    }

    public final e g() {
        return o.a(TasksTabsViewController.class);
    }

    public final String i() {
        return "openTaskInfo(Lcom/touchin/vtb/api/TaskInfo;)V";
    }

    public final void a(TaskInfo taskInfo) {
        h.b(taskInfo, "p1");
        ((TasksTabsViewController) this.receiver).openTaskInfo(taskInfo);
    }
}
