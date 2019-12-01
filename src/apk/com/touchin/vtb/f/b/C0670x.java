package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TaskIdBody;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.x reason: case insensitive filesystem */
/* compiled from: TasksRepository.kt */
final class C0670x<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0669w f7384a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7385b;

    C0670x(C0669w wVar, String str) {
        this.f7384a = wVar;
        this.f7385b = str;
    }

    /* renamed from: a */
    public final o<BaseResponse<Boolean>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7384a.f7382c.a(new TaskIdBody(this.f7385b, str));
    }
}
