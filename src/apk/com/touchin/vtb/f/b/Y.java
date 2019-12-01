package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.UserRegisterConfirmBody;
import com.touchin.vtb.api.UserRegisterConfirmResponse;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* compiled from: UserInfoRepository.kt */
final class Y<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ qa f7305a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7306b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ String f7307c;

    Y(qa qaVar, String str, String str2) {
        this.f7305a = qaVar;
        this.f7306b = str;
        this.f7307c = str2;
    }

    /* renamed from: a */
    public final o<BaseResponse<UserRegisterConfirmResponse>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7305a.f7358c.a(new UserRegisterConfirmBody(this.f7306b, this.f7307c, str));
    }
}
