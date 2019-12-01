package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.UserRegisterBody;
import com.touchin.vtb.api.UserRegisterResponse;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* compiled from: UserInfoRepository.kt */
final class la<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ qa f7344a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7345b;

    la(qa qaVar, String str) {
        this.f7344a = qaVar;
        this.f7345b = str;
    }

    /* renamed from: a */
    public final o<BaseResponse<UserRegisterResponse>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7344a.f7358c.a(new UserRegisterBody(this.f7345b, str));
    }
}
