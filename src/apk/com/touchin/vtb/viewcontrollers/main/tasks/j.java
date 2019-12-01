package com.touchin.vtb.viewcontrollers.main.tasks;

import android.view.View;
import android.view.View.OnClickListener;
import com.touchin.vtb.activities.MainActivity;
import ru.touchin.roboswag.components.navigation.viewcontrollers.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: TasksTabsViewController.kt */
final class j implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TasksTabsViewController f7670a;

    j(TasksTabsViewController tasksTabsViewController) {
        this.f7670a = tasksTabsViewController;
    }

    public final void onClick(View view) {
        d.a(((MainActivity) this.f7670a.getActivity()).b(), TaskArchiveViewController.class, b.f11113a, false, null, null, 28, null);
    }
}
