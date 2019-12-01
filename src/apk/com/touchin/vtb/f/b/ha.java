package com.touchin.vtb.f.b;

import com.touchin.vtb.api.SessionIdBody;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;

/* compiled from: UserInfoRepository.kt */
final /* synthetic */ class ha extends g implements b<String, SessionIdBody> {

    /* renamed from: c reason: collision with root package name */
    public static final ha f7338c = new ha();

    ha() {
        super(1);
    }

    public final String f() {
        return "<init>";
    }

    public final e g() {
        return o.a(SessionIdBody.class);
    }

    public final String i() {
        return "<init>(Ljava/lang/String;)V";
    }

    public final SessionIdBody a(String str) {
        h.b(str, "p1");
        return new SessionIdBody(str);
    }
}
