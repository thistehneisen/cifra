package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankOperationsListResponse;
import com.touchin.vtb.api.BaseResponse;
import e.b.c.e;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.p reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0663p<T> implements e<BaseResponse<BankOperationsListResponse>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0664q f7352a;

    C0663p(C0664q qVar) {
        this.f7352a = qVar;
    }

    /* renamed from: a */
    public final void accept(BaseResponse<BankOperationsListResponse> baseResponse) {
        C0648a aVar = this.f7352a.f7354a;
        h.a((Object) baseResponse, "response");
        BankOperationsListResponse bankOperationsListResponse = (BankOperationsListResponse) baseResponse.d();
        aVar.a(bankOperationsListResponse != null ? bankOperationsListResponse.b() : null, this.f7352a.f7354a.f7311d);
    }
}
