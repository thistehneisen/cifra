package com.touchin.vtb.h.c;

import androidx.lifecycle.u;
import com.touchin.vtb.api.UserRegisterConfirmResponse;
import com.touchin.vtb.api.UserRegisterResponse;
import com.touchin.vtb.f.b.qa;
import e.b.b.b;
import io.intercom.android.sdk.views.holder.AttributeType;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.b.c;
import l.a.c.c.s;

/* renamed from: com.touchin.vtb.h.c.a reason: case insensitive filesystem */
/* compiled from: ConfirmSmsViewModel.kt */
public final class C0673a extends s {

    /* renamed from: e reason: collision with root package name */
    private final c<a<UserRegisterConfirmResponse>> f7529e = new c<>();

    /* renamed from: f reason: collision with root package name */
    private final c<a<UserRegisterResponse>> f7530f = new c<>();

    /* renamed from: g reason: collision with root package name */
    private final qa f7531g;

    public C0673a(qa qaVar) {
        h.b(qaVar, "userInfoRepository");
        super(null, null, 3, null);
        this.f7531g = qaVar;
    }

    public final b a(String str) {
        h.b(str, AttributeType.PHONE);
        return a(this.f7531g.b(str), (u<a<T>>) this.f7530f);
    }

    public final c<a<UserRegisterConfirmResponse>> c() {
        return this.f7529e;
    }

    public final c<a<UserRegisterResponse>> d() {
        return this.f7530f;
    }

    public final b a(String str, String str2) {
        h.b(str, "smsOperationId");
        h.b(str2, "code");
        return a(this.f7531g.a(str, str2), (u<a<T>>) this.f7529e);
    }
}
