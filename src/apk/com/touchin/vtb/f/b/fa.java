package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.UserProfile;
import com.touchin.vtb.api.UserProfileResponse;
import e.b.c.g;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.utils.b;

/* compiled from: UserInfoRepository.kt */
final class fa<T, R> implements g<T, R> {

    /* renamed from: a reason: collision with root package name */
    public static final fa f7334a = new fa();

    fa() {
    }

    /* renamed from: a */
    public final b<UserProfile> apply(BaseResponse<UserProfileResponse> baseResponse) {
        h.b(baseResponse, "it");
        UserProfileResponse userProfileResponse = (UserProfileResponse) baseResponse.d();
        return new b<>(userProfileResponse != null ? userProfileResponse.b() : null);
    }
}
