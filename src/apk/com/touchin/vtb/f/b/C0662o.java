package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankConnectStatusesResponse;
import com.touchin.vtb.api.BaseResponse;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* renamed from: com.touchin.vtb.f.b.o reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final /* synthetic */ class C0662o extends g implements b<BaseResponse<BankConnectStatusesResponse>, BankConnectStatusesResponse> {

    /* renamed from: c reason: collision with root package name */
    public static final C0662o f7350c = new C0662o();

    C0662o() {
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

    public final BankConnectStatusesResponse a(BaseResponse<BankConnectStatusesResponse> baseResponse) {
        h.b(baseResponse, "p1");
        return (BankConnectStatusesResponse) baseResponse.d();
    }
}
