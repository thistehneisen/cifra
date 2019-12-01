package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TaxPaymentResponse;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* compiled from: TasksRepository.kt */
final /* synthetic */ class G extends g implements b<BaseResponse<TaxPaymentResponse>, TaxPaymentResponse> {

    /* renamed from: c reason: collision with root package name */
    public static final G f7282c = new G();

    G() {
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

    public final TaxPaymentResponse a(BaseResponse<TaxPaymentResponse> baseResponse) {
        h.b(baseResponse, "p1");
        return (TaxPaymentResponse) baseResponse.d();
    }
}
