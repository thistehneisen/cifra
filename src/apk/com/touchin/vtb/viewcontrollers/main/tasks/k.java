package com.touchin.vtb.viewcontrollers.main.tasks;

import androidx.lifecycle.v;
import com.google.android.material.tabs.TabLayout.f;
import kotlin.e.b.h;

/* compiled from: TasksTabsViewController.kt */
final class k<T> implements v<Boolean> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TasksTabsViewController f7671a;

    k(TasksTabsViewController tasksTabsViewController) {
        this.f7671a = tasksTabsViewController;
    }

    public final void a(Boolean bool) {
        h.a((Object) bool, "isUrgent");
        if (bool.booleanValue()) {
            f b2 = this.f7671a.tabLayout.b(1);
            if (b2 != null) {
                b2.g();
            }
        }
    }
}
