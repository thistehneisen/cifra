package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TaxesListResponse;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* compiled from: TaxesRepository.kt */
final /* synthetic */ class M extends g implements b<BaseResponse<TaxesListResponse>, TaxesListResponse> {

    /* renamed from: c reason: collision with root package name */
    public static final M f7290c = new M();

    M() {
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

    public final TaxesListResponse a(BaseResponse<TaxesListResponse> baseResponse) {
        h.b(baseResponse, "p1");
        return (TaxesListResponse) baseResponse.d();
    }
}
