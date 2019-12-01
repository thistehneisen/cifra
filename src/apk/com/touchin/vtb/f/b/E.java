package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TasksTaxInfo;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* compiled from: TasksRepository.kt */
final /* synthetic */ class E extends g implements b<BaseResponse<TasksTaxInfo>, TasksTaxInfo> {

    /* renamed from: c reason: collision with root package name */
    public static final E f7279c = new E();

    E() {
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

    public final TasksTaxInfo a(BaseResponse<TasksTaxInfo> baseResponse) {
        h.b(baseResponse, "p1");
        return (TasksTaxInfo) baseResponse.d();
    }
}
