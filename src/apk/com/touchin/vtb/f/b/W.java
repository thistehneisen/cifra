package com.touchin.vtb.f.b;

import com.touchin.vtb.api.AppVersionBody;
import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.Platform;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* compiled from: UserInfoRepository.kt */
final class W<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ qa f7303a;

    W(qa qaVar) {
        this.f7303a = qaVar;
    }

    /* renamed from: a */
    public final o<BaseResponse<Boolean>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7303a.f7358c.a(new AppVersionBody(Platform.ANDROID, "1.5.686", str));
    }
}
