package com.touchin.vtb.a.c;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.touchin.vtb.R;
import com.touchin.vtb.api.TaskInfo;
import kotlin.e.a.a;
import kotlin.m;
import l.a.b.c;

/* compiled from: TaskBankConnectionViewHolder.kt */
public final class h extends x {

    /* renamed from: a reason: collision with root package name */
    private final TextView f6920a = ((TextView) c.a(this, R.id.item_task_bank_connection_title));

    /* renamed from: b reason: collision with root package name */
    private final TextView f6921b = ((TextView) c.a(this, R.id.item_task_bank_connection_description));
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final a<m> f6922c;

    public h(View view, a<m> aVar) {
        kotlin.e.b.h.b(view, "itemView");
        kotlin.e.b.h.b(aVar, "onBankConnectionItemClickAction");
        super(view);
        this.f6922c = aVar;
    }

    public final void a(TaskInfo taskInfo) {
        kotlin.e.b.h.b(taskInfo, "taskInfo");
        this.f6920a.setText(taskInfo.k());
        this.f6921b.setText(taskInfo.i());
        this.itemView.setOnClickListener(new g(this));
    }
}
