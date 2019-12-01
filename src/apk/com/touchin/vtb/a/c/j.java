package com.touchin.vtb.a.c;

import com.touchin.vtb.api.TaskInfo;
import kotlin.e.a.a;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: TaskInfoViewHolder.kt */
final class j extends i implements a<m> {
    final /* synthetic */ TaskInfo $taskInfo;
    final /* synthetic */ m this$0;

    j(m mVar, TaskInfo taskInfo) {
        this.this$0 = mVar;
        this.$taskInfo = taskInfo;
        super(0);
    }

    public final void b() {
        b a2 = this.this$0.p;
        String g2 = this.$taskInfo.g();
        h.a((Object) g2, "taskInfo.id");
        a2.a(g2);
        this.this$0.a(true);
    }
}
