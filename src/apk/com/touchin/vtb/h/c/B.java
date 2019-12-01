package com.touchin.vtb.h.c;

import androidx.lifecycle.u;
import com.touchin.vtb.api.UserRegisterResponse;
import com.touchin.vtb.f.b.qa;
import e.b.b.b;
import io.intercom.android.sdk.views.holder.AttributeType;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.b.c;
import l.a.c.c.s;

/* compiled from: WelcomeViewModel.kt */
public final class B extends s {

    /* renamed from: e reason: collision with root package name */
    private final c<a<UserRegisterResponse>> f7526e = new c<>();

    /* renamed from: f reason: collision with root package name */
    private final qa f7527f;

    public B(qa qaVar) {
        h.b(qaVar, "userInfoRepository");
        super(null, null, 3, null);
        this.f7527f = qaVar;
    }

    public final b a(String str) {
        h.b(str, AttributeType.PHONE);
        return a(this.f7527f.b(str), (u<a<T>>) this.f7526e);
    }

    public final c<a<UserRegisterResponse>> c() {
        return this.f7526e;
    }
}
