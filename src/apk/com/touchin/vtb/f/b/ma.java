package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.UserRegisterResponse;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* compiled from: UserInfoRepository.kt */
final /* synthetic */ class ma extends g implements b<BaseResponse<UserRegisterResponse>, UserRegisterResponse> {

    /* renamed from: c reason: collision with root package name */
    public static final ma f7347c = new ma();

    ma() {
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

    public final UserRegisterResponse a(BaseResponse<UserRegisterResponse> baseResponse) {
        h.b(baseResponse, "p1");
        return (UserRegisterResponse) baseResponse.d();
    }
}
