package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.CompanyChangeBody;
import com.touchin.vtb.api.CompanyInfo;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* compiled from: UserInfoRepository.kt */
final class U<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ qa f7300a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ CompanyInfo f7301b;

    U(qa qaVar, CompanyInfo companyInfo) {
        this.f7300a = qaVar;
        this.f7301b = companyInfo;
    }

    /* renamed from: a */
    public final o<BaseResponse<Boolean>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7300a.f7358c.a(new CompanyChangeBody(this.f7301b, str));
    }
}
