package com.touchin.vtb.f.b;

import android.os.Build.VERSION;
import com.touchin.vtb.api.Platform;
import com.touchin.vtb.api.UserSessionCreateBody;
import e.b.b;
import e.b.c.g;
import e.b.d;
import kotlin.e.b.h;

/* compiled from: UserInfoRepository.kt */
final class ca<T, R> implements g<String, d> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ qa f7321a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7322b;

    ca(qa qaVar, String str) {
        this.f7321a = qaVar;
        this.f7322b = str;
    }

    /* renamed from: a */
    public final d apply(String str) {
        h.b(str, "sessionId");
        if (!n.a(str)) {
            return b.b();
        }
        return this.f7321a.f7358c.a(new UserSessionCreateBody(Platform.ANDROID, String.valueOf(VERSION.SDK_INT), "1.5.686", this.f7322b)).b((g<? super T, ? extends d>) new ba<Object,Object>(this));
    }
}
