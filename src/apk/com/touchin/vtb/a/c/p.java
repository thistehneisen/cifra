package com.touchin.vtb.a.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.touchin.vtb.api.TaskInfo;

/* compiled from: TaskTaxViewHolder.kt */
final class p implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ q f6938a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ TaskInfo f6939b;

    p(q qVar, TaskInfo taskInfo) {
        this.f6938a = qVar;
        this.f6939b = taskInfo;
    }

    public final void onClick(View view) {
        this.f6938a.f6945f.a(this.f6939b);
    }
}
