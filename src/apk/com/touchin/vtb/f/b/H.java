package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TaskIdBody;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* compiled from: TasksRepository.kt */
final class H<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0669w f7283a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7284b;

    H(C0669w wVar, String str) {
        this.f7283a = wVar;
        this.f7284b = str;
    }

    /* renamed from: a */
    public final o<BaseResponse<Boolean>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7283a.f7382c.b(new TaskIdBody(this.f7284b, str));
    }
}
