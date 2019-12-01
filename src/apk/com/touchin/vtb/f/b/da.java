package com.touchin.vtb.f.b;

import com.touchin.vtb.api.UserProfile;
import com.touchin.vtb.f.i;
import e.b.c.f;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.utils.b;

/* compiled from: UserInfoRepository.kt */
final class da<T1, T2, T3, T4, R> implements f<b<UserProfile>, String, Boolean, Boolean, i> {

    /* renamed from: a reason: collision with root package name */
    public static final da f7326a = new da();

    da() {
    }

    public final i a(b<UserProfile> bVar, String str, Boolean bool, Boolean bool2) {
        h.b(bVar, "userProfile");
        h.b(str, "pin");
        h.b(bool, "isFingerprintEnabled");
        h.b(bool2, "isPushTokenAdded");
        return new i(bVar, str, bool.booleanValue(), bool2.booleanValue());
    }
}
