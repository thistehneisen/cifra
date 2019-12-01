package com.touchin.vtb.f.b;

import com.touchin.vtb.api.A;
import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.SessionIdBody;
import e.b.o;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.g.e;

/* compiled from: UserInfoRepository.kt */
final /* synthetic */ class ia extends g implements b<SessionIdBody, o<BaseResponse<Boolean>>> {
    ia(A a2) {
        super(1, a2);
    }

    public final String f() {
        return "logout";
    }

    public final e g() {
        return kotlin.e.b.o.a(A.class);
    }

    public final String i() {
        return "logout(Lcom/touchin/vtb/api/SessionIdBody;)Lio/reactivex/Single;";
    }

    public final o<BaseResponse<Boolean>> a(SessionIdBody sessionIdBody) {
        h.b(sessionIdBody, "p1");
        return ((A) this.receiver).b(sessionIdBody);
    }
}
