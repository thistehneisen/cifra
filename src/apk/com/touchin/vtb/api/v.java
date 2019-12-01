package com.touchin.vtb.api;

import e.b.o;
import retrofit2.a.a;
import retrofit2.a.l;

/* compiled from: TasksApi.kt */
public interface v {
    @l("tasks/delete")
    o<BaseResponse<Boolean>> a(@a TaskIdBody taskIdBody);

    @l("tasks/list")
    o<BaseResponse<TaskListResponse>> a(@a TaskListBody taskListBody);

    @l("tasks/restore")
    o<BaseResponse<Boolean>> b(@a TaskIdBody taskIdBody);

    @l("tasks/tax/info")
    o<BaseResponse<TasksTaxInfo>> c(@a TaskIdBody taskIdBody);

    @l("tasks/tax/pay")
    o<BaseResponse<TaxPaymentResponse>> d(@a TaskIdBody taskIdBody);
}
