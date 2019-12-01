package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.SessionIdBody;
import e.b.b;
import e.b.c.g;
import e.b.d;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.observables.storable.i;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/* compiled from: UserInfoRepository.kt */
final class ba<T, R> implements g<BaseResponse<SessionIdBody>, d> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ca f7319a;

    ba(ca caVar) {
        this.f7319a = caVar;
    }

    /* renamed from: a */
    public final b apply(BaseResponse<SessionIdBody> baseResponse) {
        h.b(baseResponse, "it");
        i a2 = this.f7319a.f7321a.f7363h;
        SessionIdBody sessionIdBody = (SessionIdBody) baseResponse.d();
        if (sessionIdBody != null) {
            String b2 = sessionIdBody.b();
            if (b2 != null) {
                return a2.a(b2);
            }
        }
        throw new ShouldNotHappenException("Session is empty");
    }
}
