package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankConnectCheckResponse;
import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.f.c;
import e.b.c.g;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.c reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0650c<T, R> implements g<T, R> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ String f7320a;

    C0650c(String str) {
        this.f7320a = str;
    }

    /* renamed from: a */
    public final c apply(BaseResponse<BankConnectCheckResponse> baseResponse) {
        h.b(baseResponse, "response");
        Object d2 = baseResponse.d();
        if (d2 != null) {
            h.a(d2, "response.result!!");
            return new c((BankConnectCheckResponse) d2, this.f7320a);
        }
        h.a();
        throw null;
    }
}
