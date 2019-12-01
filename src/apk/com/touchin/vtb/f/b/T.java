package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* compiled from: UserInfoRepository.kt */
final /* synthetic */ class T extends g implements b<BaseResponse<Boolean>, Boolean> {

    /* renamed from: c reason: collision with root package name */
    public static final T f7299c = new T();

    T() {
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

    public final Boolean a(BaseResponse<Boolean> baseResponse) {
        h.b(baseResponse, "p1");
        return (Boolean) baseResponse.d();
    }
}
