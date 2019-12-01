package com.touchin.vtb.api;

import e.b.o;
import retrofit2.a.a;
import retrofit2.a.l;

/* compiled from: TaxesApi.kt */
public interface y {
    @l("taxes/list")
    o<BaseResponse<TaxesListResponse>> a(@a SessionIdBody sessionIdBody);
}
