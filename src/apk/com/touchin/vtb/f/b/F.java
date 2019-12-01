package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TaskIdBody;
import com.touchin.vtb.api.TaxPaymentResponse;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* compiled from: TasksRepository.kt */
final class F<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0669w f7280a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7281b;

    F(C0669w wVar, String str) {
        this.f7280a = wVar;
        this.f7281b = str;
    }

    /* renamed from: a */
    public final o<BaseResponse<TaxPaymentResponse>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7280a.f7382c.d(new TaskIdBody(this.f7281b, str));
    }
}
