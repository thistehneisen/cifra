package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TaskFilter;
import com.touchin.vtb.api.TaskListBody;
import com.touchin.vtb.api.TaskListResponse;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* compiled from: TasksRepository.kt */
final class B<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0669w f7275a;

    B(C0669w wVar) {
        this.f7275a = wVar;
    }

    /* renamed from: a */
    public final o<BaseResponse<TaskListResponse>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7275a.f7382c.a(new TaskListBody(TaskFilter.ACTIVE, 1000, 0, str));
    }
}
