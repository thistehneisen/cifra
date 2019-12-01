package com.touchin.vtb.api;

import e.b.o;
import retrofit2.a.a;
import retrofit2.a.l;

/* compiled from: UserApi.kt */
public interface A {
    @l("app/version")
    o<BaseResponse<Boolean>> a(@a AppVersionBody appVersionBody);

    @l("user/company/change")
    o<BaseResponse<Boolean>> a(@a CompanyChangeBody companyChangeBody);

    @l("user/profile")
    o<BaseResponse<UserProfileResponse>> a(@a SessionIdBody sessionIdBody);

    @l("user/push/change")
    o<BaseResponse<Boolean>> a(@a TokenAddBody tokenAddBody);

    @l("user/register")
    o<BaseResponse<UserRegisterResponse>> a(@a UserRegisterBody userRegisterBody);

    @l("user/register/confirm")
    o<BaseResponse<UserRegisterConfirmResponse>> a(@a UserRegisterConfirmBody userRegisterConfirmBody);

    @l("user/session/create")
    o<BaseResponse<SessionIdBody>> a(@a UserSessionCreateBody userSessionCreateBody);

    @l("user/logout")
    o<BaseResponse<Boolean>> b(@a SessionIdBody sessionIdBody);
}
