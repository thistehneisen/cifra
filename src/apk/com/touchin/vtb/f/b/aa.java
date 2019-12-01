package com.touchin.vtb.f.b;

import com.touchin.vtb.f.d;
import e.b.c.b;
import kotlin.e.b.h;

/* compiled from: UserInfoRepository.kt */
final class aa<T1, T2, R> implements b<String, Boolean, d> {

    /* renamed from: a reason: collision with root package name */
    public static final aa f7316a = new aa();

    aa() {
    }

    /* renamed from: a */
    public final d apply(String str, Boolean bool) {
        h.b(str, "pin");
        h.b(bool, "isFingerprintEnabled");
        return new d(str, bool.booleanValue());
    }
}
