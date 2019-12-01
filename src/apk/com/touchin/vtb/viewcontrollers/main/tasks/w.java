package com.touchin.vtb.viewcontrollers.main.tasks;

import androidx.lifecycle.u;
import androidx.lifecycle.v;
import com.touchin.vtb.R;
import com.touchin.vtb.api.TaskListResponse;
import com.touchin.vtb.g.l;
import java.util.List;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.c;
import l.a.c.a.a.d;

/* compiled from: TasksTabsViewController.kt */
final class w<T> implements v<a<? extends TaskListResponse>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TasksTabsViewController f7676a;

    w(TasksTabsViewController tasksTabsViewController) {
        this.f7676a = tasksTabsViewController;
    }

    public final void a(a<? extends TaskListResponse> aVar) {
        List list;
        if (aVar instanceof c) {
            this.f7676a.switcher.a(R.id.global_loader);
        } else if (aVar instanceof d) {
            this.f7676a.swipeRefreshLayout.setRefreshing(false);
            TasksTabsViewController tasksTabsViewController = this.f7676a;
            if (tasksTabsViewController.isUrgentTaskTab()) {
                list = ((TaskListResponse) ((d) aVar).a()).c();
                if (list == null) {
                    list = i.a();
                }
            } else {
                list = ((TaskListResponse) ((d) aVar).a()).b();
                h.a((Object) list, "event.data.taskList");
            }
            tasksTabsViewController.submitAdapterList(tasksTabsViewController.mapTasksByType(list));
            if (((l) this.f7676a.getState()).n() != null) {
                u i2 = this.f7676a.viewModel.i();
                TasksTabsViewController tasksTabsViewController2 = this.f7676a;
                List c2 = ((TaskListResponse) ((d) aVar).a()).c();
                if (c2 == null) {
                    c2 = i.a();
                }
                i2.b(Boolean.valueOf(tasksTabsViewController2.isPushTaskUrgent(c2)));
            }
        } else if (aVar instanceof b) {
            this.f7676a.swipeRefreshLayout.setRefreshing(false);
            this.f7676a.switcher.a(R.id.view_controller_tasks_error);
            this.f7676a.errorView.a(((b) aVar).b(), new v(this.f7676a.viewModel));
        }
    }
}
