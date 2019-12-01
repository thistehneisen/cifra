package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BaseResponse;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* renamed from: com.touchin.vtb.f.b.g reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final /* synthetic */ class C0654g extends g implements b<BaseResponse<BankConnectResponse>, BankConnectResponse> {

    /* renamed from: c reason: collision with root package name */
    public static final C0654g f7335c = new C0654g();

    C0654g() {
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

    public final BankConnectResponse a(BaseResponse<BankConnectResponse> baseResponse) {
        h.b(baseResponse, "p1");
        return (BankConnectResponse) baseResponse.d();
    }
}
