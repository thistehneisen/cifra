package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TokenAddBody;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* compiled from: UserInfoRepository.kt */
final class S<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ qa f7297a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7298b;

    S(qa qaVar, String str) {
        this.f7297a = qaVar;
        this.f7298b = str;
    }

    /* renamed from: a */
    public final o<BaseResponse<Boolean>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7297a.f7358c.a(new TokenAddBody(this.f7298b, str));
    }
}
