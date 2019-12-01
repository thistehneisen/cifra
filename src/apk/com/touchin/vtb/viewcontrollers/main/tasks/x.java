package com.touchin.vtb.viewcontrollers.main.tasks;

import androidx.lifecycle.v;
import l.a.c.a.a;
import l.a.c.a.a.d;

/* compiled from: TasksTabsViewController.kt */
final class x<T> implements v<a<? extends String>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TasksTabsViewController f7677a;

    x(TasksTabsViewController tasksTabsViewController) {
        this.f7677a = tasksTabsViewController;
    }

    public final void a(a<String> aVar) {
        if (aVar instanceof d) {
            this.f7677a.onTaskDeleted((String) ((d) aVar).a());
        }
    }
}
