package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TaskIdBody;
import com.touchin.vtb.api.TasksTaxInfo;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* compiled from: TasksRepository.kt */
final class D<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0669w f7277a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7278b;

    D(C0669w wVar, String str) {
        this.f7277a = wVar;
        this.f7278b = str;
    }

    /* renamed from: a */
    public final o<BaseResponse<TasksTaxInfo>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7277a.f7382c.c(new TaskIdBody(this.f7278b, str));
    }
}
