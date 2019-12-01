package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankConnectConfirmBody;
import com.touchin.vtb.api.BaseResponse;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.d reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0651d<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0648a f7323a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7324b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ String f7325c;

    C0651d(C0648a aVar, String str, String str2) {
        this.f7323a = aVar;
        this.f7324b = str;
        this.f7325c = str2;
    }

    /* renamed from: a */
    public final o<BaseResponse<Boolean>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7323a.f7312e.a(new BankConnectConfirmBody(this.f7324b, this.f7325c, str));
    }
}
