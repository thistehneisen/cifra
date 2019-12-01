package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import e.b.c.g;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.e reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0652e<T, R> implements g<T, R> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0648a f7327a;

    C0652e(C0648a aVar) {
        this.f7327a = aVar;
    }

    /* renamed from: a */
    public final Boolean apply(BaseResponse<Boolean> baseResponse) {
        h.b(baseResponse, "confirmationResponse");
        if (h.a((Object) (Boolean) baseResponse.d(), (Object) Boolean.valueOf(true))) {
            this.f7327a.f7313f.g().c();
        }
        return (Boolean) baseResponse.d();
    }
}
