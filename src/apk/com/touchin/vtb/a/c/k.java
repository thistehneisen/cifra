package com.touchin.vtb.a.c;

import com.touchin.vtb.api.TaskInfo;
import kotlin.e.a.a;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: TaskInfoViewHolder.kt */
final class k extends i implements a<m> {
    final /* synthetic */ TaskInfo $taskInfo;
    final /* synthetic */ m this$0;

    k(m mVar, TaskInfo taskInfo) {
        this.this$0 = mVar;
        this.$taskInfo = taskInfo;
        super(0);
    }

    public final void b() {
        b d2 = this.this$0.q;
        String g2 = this.$taskInfo.g();
        h.a((Object) g2, "taskInfo.id");
        d2.a(g2);
        this.this$0.a(false);
    }
}
