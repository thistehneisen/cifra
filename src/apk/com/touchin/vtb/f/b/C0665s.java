package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankOperationsListResponse;
import com.touchin.vtb.api.BaseResponse;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* renamed from: com.touchin.vtb.f.b.s reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final /* synthetic */ class C0665s extends g implements b<BaseResponse<BankOperationsListResponse>, BankOperationsListResponse> {

    /* renamed from: c reason: collision with root package name */
    public static final C0665s f7372c = new C0665s();

    C0665s() {
        super(1);
    }

    public final String f() {
        return "getResult";
    }

    public final e g() {
        return o.a(BaseResponse.class);
    }

    public final String i() {
        return "getResult()Ljava/lang/Object;";
    }

    public final BankOperationsListResponse a(BaseResponse<BankOperationsListResponse> baseResponse) {
        h.b(baseResponse, "p1");
        return (BankOperationsListResponse) baseResponse.d();
    }
}
