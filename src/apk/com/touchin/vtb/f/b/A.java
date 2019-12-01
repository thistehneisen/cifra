package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TaskListResponse;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* compiled from: TasksRepository.kt */
final /* synthetic */ class A extends g implements b<BaseResponse<TaskListResponse>, TaskListResponse> {

    /* renamed from: c reason: collision with root package name */
    public static final A f7274c = new A();

    A() {
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

    public final TaskListResponse a(BaseResponse<TaskListResponse> baseResponse) {
        h.b(baseResponse, "p1");
        return (TaskListResponse) baseResponse.d();
    }
}
