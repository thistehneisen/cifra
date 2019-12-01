package com.touchin.vtb.viewcontrollers.main.tasks;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.C;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.touchin.vtb.R;
import com.touchin.vtb.a.G;
import com.touchin.vtb.a.H;
import com.touchin.vtb.a.H.d;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.api.TaskInfo;
import com.touchin.vtb.api.TaskType;
import com.touchin.vtb.h.d.e;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import com.touchin.vtb.views.GlobalErrorView;
import java.util.ArrayList;
import java.util.List;
import kotlin.e.b.h;
import l.a.c.c.q;
import ru.touchin.roboswag.components.navigation.viewcontrollers.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;
import ru.touchin.widget.Switcher;

/* compiled from: TaskArchiveViewController.kt */
public final class TaskArchiveViewController extends VTBViewController<MainActivity, b> {
    /* access modifiers changed from: private */
    public final G adapter = new G();
    private e.b.b.b archiveTasksListDisposable;
    /* access modifiers changed from: private */
    public final GlobalErrorView errorView = ((GlobalErrorView) findViewById(R.id.view_controller_tasks_archive_error));
    private final RecyclerView recycler = ((RecyclerView) findViewById(R.id.view_controller_tasks_archive_recycler));
    /* access modifiers changed from: private */
    public final SwipeRefreshLayout swipeRefreshLayout = ((SwipeRefreshLayout) findViewById(R.id.view_controller_tasks_archive_swipe));
    /* access modifiers changed from: private */
    public final Switcher switcher = ((Switcher) findViewById(R.id.view_controller_tasks_archive_switcher));
    /* access modifiers changed from: private */
    public final e viewModel;

    public TaskArchiveViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_tasks_archive);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(e.class);
        h.a((Object) a2, "LifecycleViewModelProvid…iveViewModel::class.java)");
        this.viewModel = (e) a2;
        initializeToolbars();
        this.recycler.setAdapter(this.adapter);
        this.viewModel.d().a(this, new b(this));
        this.swipeRefreshLayout.setOnRefreshListener(new c(this));
        loadData();
    }

    private final void initializeToolbars() {
        MainActivity mainActivity = (MainActivity) getActivity();
        Toolbar toolbar = (Toolbar) findViewById(R.id.global_toolbar);
        toolbar.setBackgroundColor(getColor(R.color.common_background_gray_color));
        c.a(mainActivity, toolbar, getString(R.string.common_tasks_tab_archive), null, true, 0, 20, null);
    }

    /* access modifiers changed from: private */
    public final void loadData() {
        e.b.b.b bVar = this.archiveTasksListDisposable;
        if (bVar != null) {
            bVar.b();
        }
        this.archiveTasksListDisposable = this.viewModel.c();
    }

    /* access modifiers changed from: private */
    public final List<H> mapTasksByType(List<? extends TaskInfo> list) {
        Object obj;
        ArrayList arrayList = new ArrayList(j.a(list, 10));
        for (TaskInfo taskInfo : list) {
            if (taskInfo.l() == TaskType.INFO) {
                obj = new H.b(taskInfo);
            } else {
                obj = new d(taskInfo);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
