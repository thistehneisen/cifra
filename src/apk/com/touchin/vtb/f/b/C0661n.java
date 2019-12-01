package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankConnectStatusesBody;
import com.touchin.vtb.api.BankConnectStatusesResponse;
import com.touchin.vtb.api.BaseResponse;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.n reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0661n<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0648a f7348a;

    C0661n(C0648a aVar) {
        this.f7348a = aVar;
    }

    /* renamed from: a */
    public final o<BaseResponse<BankConnectStatusesResponse>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7348a.f7312e.a(new BankConnectStatusesBody(null, str));
    }
}
