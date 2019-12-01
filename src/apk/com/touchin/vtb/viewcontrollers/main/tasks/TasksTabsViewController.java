package com.touchin.vtb.viewcontrollers.main.tasks;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.C;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.g.a.a.h;
import c.c.a.k;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.c;
import com.google.android.material.tabs.TabLayout.f;
import com.touchin.vtb.R;
import com.touchin.vtb.a.B;
import com.touchin.vtb.a.H;
import com.touchin.vtb.a.H.d;
import com.touchin.vtb.a.a.b;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.api.TaskInfo;
import com.touchin.vtb.api.TaskListResponse;
import com.touchin.vtb.api.TaskType;
import com.touchin.vtb.g.i;
import com.touchin.vtb.g.j;
import com.touchin.vtb.g.l;
import com.touchin.vtb.h.d.g;
import com.touchin.vtb.viewcontrollers.base.VTBBottomMenuViewController;
import com.touchin.vtb.viewcontrollers.startup.ConnectBankViewController;
import com.touchin.vtb.viewcontrollers.startup.SearchCompanyViewController;
import com.touchin.vtb.views.GlobalErrorView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import l.a.c.c.q;
import ru.touchin.widget.Switcher;

/* compiled from: TasksTabsViewController.kt */
public final class TasksTabsViewController extends VTBBottomMenuViewController<MainActivity, l> implements c {
    private final B adapter;
    private final View archiveImageView = findViewById(R.id.view_controller_tasks_tabs_archive_icon);
    private final b callback = new b(new t(this));
    /* access modifiers changed from: private */
    public final GlobalErrorView errorView = ((GlobalErrorView) findViewById(R.id.view_controller_tasks_error));
    private final RecyclerView recycler = ((RecyclerView) findViewById(R.id.view_controller_tasks_recycler));
    private final Typeface rubikLightFont = h.a(getActivity(), R.font.rubik_light);
    private final Typeface rubikMediumFont = h.a(getActivity(), R.font.rubik_medium);
    /* access modifiers changed from: private */
    public final SwipeRefreshLayout swipeRefreshLayout = ((SwipeRefreshLayout) findViewById(R.id.view_controller_task_swipe));
    /* access modifiers changed from: private */
    public final Switcher switcher = ((Switcher) findViewById(R.id.view_controller_tasks_switcher));
    /* access modifiers changed from: private */
    public final TabLayout tabLayout = ((TabLayout) findViewById(R.id.view_controller_tasks_tabs_tab_layout));
    private final k touchHelper = new k(this.callback);
    /* access modifiers changed from: private */
    public final g viewModel;

    /* compiled from: TasksTabsViewController.kt */
    private enum a {
        ACTIVE_TAB_TASKS(R.string.common_tasks_tab_active),
        URGENT_TAB_TASKS(R.string.common_tasks_tab_urgent);
        
        private final int titleResId;

        private a(int i2) {
            this.titleResId = i2;
        }

        public final int a() {
            return this.titleResId;
        }
    }

    public TasksTabsViewController(ru.touchin.roboswag.components.navigation.viewcontrollers.c.a aVar) {
        kotlin.e.b.h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_tasks_tabs);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(g.class);
        kotlin.e.b.h.a((Object) a2, "LifecycleViewModelProvid…sksViewModel::class.java)");
        this.viewModel = (g) a2;
        B b2 = new B(new n(this), new o(this), new p(this), new q(this), new r(this), s.f7674a);
        this.adapter = b2;
        if (n.a(this.viewModel.f())) {
            this.archiveImageView.setVisibility(8);
        }
        initTabLayout();
        this.archiveImageView.setOnClickListener(new j(this));
        this.viewModel.i().a(this, new k(this));
        this.recycler.setAdapter(this.adapter);
        this.recycler.setItemAnimator(new g.a.a.a.h());
        this.touchHelper.a(this.recycler);
        initObservers();
        this.swipeRefreshLayout.setOnRefreshListener(new l(this));
        addBottomMenuAnimation(this.recycler, true);
    }

    /* access modifiers changed from: private */
    public final void deleteTaskAction(String str) {
        this.touchHelper.a();
        this.viewModel.a(str);
        ((MainActivity) getActivity()).d().a(com.touchin.vtb.b.h.MOVE_TASK_TO_ARCHIVE);
    }

    private final TaskInfo findPushTaskInfo(List<? extends H> list) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.e.b.h.a((Object) ((H) obj).a().g(), (Object) ((l) getState()).n())) {
                break;
            }
        }
        H h2 = (H) obj;
        if (h2 != null) {
            return h2.a();
        }
        return null;
    }

    private final void initDeleteTaskObserver() {
        this.viewModel.c().a(this, u.f7675a);
    }

    private final void initGetTaskObserver() {
        this.viewModel.d().a(this, new w(this));
    }

    private final void initObservers() {
        initGetTaskObserver();
        initDeleteTaskObserver();
        initRestoreTaskObserver();
        initRestoreHidingEventObserver();
    }

    private final void initRestoreHidingEventObserver() {
        this.viewModel.e().a(this, new x(this));
    }

    private final void initRestoreTaskObserver() {
        this.viewModel.g().a(this, y.f7678a);
    }

    private final void initTabLayout() {
        a[] values = a.values();
        int length = values.length;
        int i2 = 0;
        while (i2 < length) {
            a aVar = values[i2];
            f b2 = this.tabLayout.b();
            View a2 = l.a.d.a.b.a.a(R.layout.view_tab_task, this.tabLayout);
            if (a2 != null) {
                TextView textView = (TextView) a2;
                textView.setText(aVar.a());
                textView.setTypeface(aVar.ordinal() == ((l) getState()).o() ? this.rubikMediumFont : this.rubikLightFont);
                b2.a((View) textView);
                logActiveTasksAnalytics(b2);
                kotlin.e.b.h.a((Object) b2, "tabLayout.newTab().apply…ytics(this)\n            }");
                this.tabLayout.a(b2);
                i2++;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
        }
        this.tabLayout.a((TabLayout.b) this);
    }

    /* access modifiers changed from: private */
    public final boolean isPushTaskUrgent(List<? extends TaskInfo> list) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.e.b.h.a((Object) ((TaskInfo) obj).g(), (Object) ((l) getState()).n())) {
                break;
            }
        }
        return obj != null;
    }

    /* access modifiers changed from: private */
    public final boolean isUrgentTaskTab() {
        return this.tabLayout.getSelectedTabPosition() == a.URGENT_TAB_TASKS.ordinal();
    }

    private final void logActiveTasksAnalytics(f fVar) {
        if (fVar != null && fVar.c() == a.ACTIVE_TAB_TASKS.ordinal()) {
            ((MainActivity) getActivity()).d().a(com.touchin.vtb.b.h.ACTIVE_TASKS);
        }
    }

    /* access modifiers changed from: private */
    public final List<H> mapTasksByType(List<? extends TaskInfo> list) {
        Object obj;
        ArrayList arrayList = new ArrayList(j.a(list, 10));
        for (TaskInfo taskInfo : list) {
            int i2 = m.f7673a[taskInfo.l().ordinal()];
            if (i2 == 1) {
                obj = new H.b(taskInfo);
            } else if (i2 == 2) {
                obj = new d(taskInfo);
            } else if (i2 == 3) {
                obj = new com.touchin.vtb.a.H.a(taskInfo);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void onSwiped(int i2) {
        this.swipeRefreshLayout.setEnabled(i2 == 0);
    }

    /* access modifiers changed from: private */
    public final void onTaskDeleted(String str) {
        List d2 = this.adapter.d();
        ArrayList arrayList = new ArrayList();
        for (Object next : d2) {
            if (!kotlin.e.b.h.a((Object) ((H) next).a().g(), (Object) str)) {
                arrayList.add(next);
            }
        }
        submitAdapterList(arrayList);
    }

    /* access modifiers changed from: private */
    public final void openBankConnectionTask() {
        if (n.a(this.viewModel.f())) {
            i iVar = new i(null, null, null, null, null, null, 63, null);
            ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(((MainActivity) getActivity()).c(), SearchCompanyViewController.class, iVar, false, null, null, 28, null);
            return;
        }
        com.touchin.vtb.g.b bVar = new com.touchin.vtb.g.b(null, R.string.common_more_add_bank, false, null, 13, null);
        ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(((MainActivity) getActivity()).c(), ConnectBankViewController.class, bVar, false, null, null, 28, null);
    }

    private final void openDeadlinePush(List<? extends H> list) {
        if (kotlin.e.b.h.a((Object) ((l) getState()).p(), (Object) Boolean.valueOf(true))) {
            TaskInfo findPushTaskInfo = findPushTaskInfo(list);
            if (findPushTaskInfo != null) {
                ((l) getState()).a(Boolean.valueOf(false));
                if (findPushTaskInfo.l() == TaskType.INFO) {
                    openTaskTax(findPushTaskInfo);
                } else {
                    openTaskInfo(findPushTaskInfo);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void openTaskInfo(TaskInfo taskInfo) {
        ((MainActivity) getActivity()).d().a((com.touchin.vtb.b.g) new com.touchin.vtb.b.g.f(TaskType.INFO));
        ru.touchin.roboswag.components.navigation.viewcontrollers.d c2 = ((MainActivity) getActivity()).c();
        Class<TaskInfoViewController> cls = TaskInfoViewController.class;
        String g2 = taskInfo.g();
        kotlin.e.b.h.a((Object) g2, "item.id");
        String k2 = taskInfo.k();
        kotlin.e.b.h.a((Object) k2, "item.title");
        String e2 = taskInfo.e();
        if (e2 == null) {
            e2 = "";
        }
        j jVar = new j(g2, k2, e2, null, 8, null);
        ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(c2, cls, jVar, false, null, null, 28, null);
    }

    /* access modifiers changed from: private */
    public final void openTaskTax(TaskInfo taskInfo) {
        ((MainActivity) getActivity()).d().a((com.touchin.vtb.b.g) new com.touchin.vtb.b.g.f(TaskType.TAX));
        String g2 = taskInfo.g();
        kotlin.e.b.h.a((Object) g2, "item.id");
        ru.touchin.roboswag.components.navigation.viewcontrollers.d.a(((MainActivity) getActivity()).c(), TaskTaxViewController.class, new com.touchin.vtb.g.k(g2), false, null, null, 28, null);
    }

    /* access modifiers changed from: private */
    public final void restoreTaskAction(String str) {
        this.touchHelper.a();
        this.viewModel.c(str);
        ((MainActivity) getActivity()).d().a(com.touchin.vtb.b.h.RESTORE_TASK);
    }

    /* access modifiers changed from: private */
    public final void submitAdapterList(List<? extends H> list) {
        if (list == null || list.isEmpty()) {
            this.switcher.a(R.id.view_controller_tasks_empty_text);
            return;
        }
        this.switcher.a(R.id.view_controller_tasks_recycler);
        this.adapter.a(list);
        openDeadlinePush(list);
    }

    public void onTabReselected(f fVar) {
        View a2 = fVar != null ? fVar.a() : null;
        if (!(a2 instanceof TextView)) {
            a2 = null;
        }
        TextView textView = (TextView) a2;
        if (textView != null) {
            textView.setTypeface(this.rubikMediumFont);
        }
    }

    public void onTabSelected(f fVar) {
        List list = null;
        View a2 = fVar != null ? fVar.a() : null;
        if (!(a2 instanceof TextView)) {
            a2 = null;
        }
        TextView textView = (TextView) a2;
        if (textView != null) {
            textView.setTypeface(this.rubikMediumFont);
        }
        logActiveTasksAnalytics(fVar);
        l.a.c.a.a aVar = (l.a.c.a.a) this.viewModel.d().a();
        if (aVar != null) {
            if (isUrgentTaskTab()) {
                TaskListResponse taskListResponse = (TaskListResponse) aVar.a();
                if (taskListResponse != null) {
                    list = taskListResponse.c();
                }
                if (list == null) {
                    list = i.a();
                }
            } else {
                TaskListResponse taskListResponse2 = (TaskListResponse) aVar.a();
                if (taskListResponse2 != null) {
                    list = taskListResponse2.b();
                }
                if (list == null) {
                    list = i.a();
                }
            }
            submitAdapterList(mapTasksByType(list));
        }
    }

    public void onTabUnselected(f fVar) {
        View a2 = fVar != null ? fVar.a() : null;
        if (!(a2 instanceof TextView)) {
            a2 = null;
        }
        TextView textView = (TextView) a2;
        if (textView != null) {
            textView.setTypeface(this.rubikLightFont);
        }
    }
}
