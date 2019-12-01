package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.SessionIdBody;
import com.touchin.vtb.api.UserProfileResponse;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* compiled from: UserInfoRepository.kt */
final class ea<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ qa f7328a;

    ea(qa qaVar) {
        this.f7328a = qaVar;
    }

    /* renamed from: a */
    public final o<BaseResponse<UserProfileResponse>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7328a.f7358c.a(new SessionIdBody(str));
    }
}
