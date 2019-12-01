package com.touchin.vtb.viewcontrollers.main.tasks;

import androidx.lifecycle.v;
import com.touchin.vtb.R;
import com.touchin.vtb.a.G;
import com.touchin.vtb.api.TaskListResponse;
import java.util.List;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.a.a.c;
import l.a.c.a.a.d;

/* compiled from: TaskArchiveViewController.kt */
final class b<T> implements v<a<? extends TaskListResponse>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TaskArchiveViewController f7662a;

    b(TaskArchiveViewController taskArchiveViewController) {
        this.f7662a = taskArchiveViewController;
    }

    public final void a(a<? extends TaskListResponse> aVar) {
        if (aVar instanceof c) {
            this.f7662a.switcher.a(R.id.global_loader);
        } else if (aVar instanceof d) {
            this.f7662a.swipeRefreshLayout.setRefreshing(false);
            d dVar = (d) aVar;
            if (((TaskListResponse) dVar.a()).b().isEmpty()) {
                this.f7662a.switcher.a(R.id.view_controller_tasks_archive_empty_text);
                return;
            }
            this.f7662a.switcher.a(R.id.view_controller_tasks_archive_recycler);
            G access$getAdapter$p = this.f7662a.adapter;
            TaskArchiveViewController taskArchiveViewController = this.f7662a;
            List b2 = ((TaskListResponse) dVar.a()).b();
            h.a((Object) b2, "event.data.taskList");
            access$getAdapter$p.a(taskArchiveViewController.mapTasksByType(b2));
        } else if (aVar instanceof l.a.c.a.a.b) {
            this.f7662a.swipeRefreshLayout.setRefreshing(false);
            this.f7662a.switcher.a(R.id.view_controller_tasks_archive_error);
            this.f7662a.errorView.a(((l.a.c.a.a.b) aVar).b(), new a(this.f7662a));
        }
    }
}
