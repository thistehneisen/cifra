package com.touchin.vtb.a.c;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.touchin.vtb.R;
import com.touchin.vtb.api.TaskInfo;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.m;
import l.a.b.c;

/* compiled from: TaskRegistrationViewHolder.kt */
public final class o extends x {

    /* renamed from: a reason: collision with root package name */
    private final TextView f6935a = ((TextView) c.a(this, R.id.item_task_registration_title));

    /* renamed from: b reason: collision with root package name */
    private final TextView f6936b = ((TextView) c.a(this, R.id.item_task_registration_description));
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final a<m> f6937c;

    public o(View view, a<m> aVar) {
        h.b(view, "itemView");
        h.b(aVar, "onRegistrationClickAction");
        super(view);
        this.f6937c = aVar;
    }

    public final void a(TaskInfo taskInfo) {
        h.b(taskInfo, "taskInfo");
        this.f6935a.setText(taskInfo.k());
        this.f6936b.setText(taskInfo.i());
        this.itemView.setOnClickListener(new n(this));
    }
}
