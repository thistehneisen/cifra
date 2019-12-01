package com.touchin.vtb.viewcontrollers.main.tasks;

import android.view.View;
import android.view.View.OnClickListener;
import com.touchin.vtb.activities.MainActivity;

/* compiled from: TaskInfoViewController.kt */
final class d implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TaskInfoViewController f7664a;

    d(TaskInfoViewController taskInfoViewController) {
        this.f7664a = taskInfoViewController;
    }

    public final void onClick(View view) {
        ((MainActivity) this.f7664a.getActivity()).c().a();
    }
}
