package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankAccountsListResponse;
import com.touchin.vtb.api.BaseResponse;
import e.b.c.e;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.j reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0657j<T> implements e<BaseResponse<BankAccountsListResponse>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0658k f7340a;

    C0657j(C0658k kVar) {
        this.f7340a = kVar;
    }

    /* renamed from: a */
    public final void accept(BaseResponse<BankAccountsListResponse> baseResponse) {
        C0648a aVar = this.f7340a.f7342a;
        h.a((Object) baseResponse, "response");
        BankAccountsListResponse bankAccountsListResponse = (BankAccountsListResponse) baseResponse.d();
        aVar.a(bankAccountsListResponse != null ? bankAccountsListResponse.b() : null, this.f7340a.f7342a.f7310c);
    }
}
