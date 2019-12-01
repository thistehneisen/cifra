package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TaskFilter;
import com.touchin.vtb.api.TaskListBody;
import com.touchin.vtb.api.TaskListResponse;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.z reason: case insensitive filesystem */
/* compiled from: TasksRepository.kt */
final class C0672z<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0669w f7387a;

    C0672z(C0669w wVar) {
        this.f7387a = wVar;
    }

    /* renamed from: a */
    public final o<BaseResponse<TaskListResponse>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7387a.f7382c.a(new TaskListBody(TaskFilter.ARCHIVED, 1000, 0, str));
    }
}
