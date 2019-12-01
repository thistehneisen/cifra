package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.ConnectedBankIdBody;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.h reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0655h<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0648a f7336a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7337b;

    C0655h(C0648a aVar, String str) {
        this.f7336a = aVar;
        this.f7337b = str;
    }

    /* renamed from: a */
    public final o<BaseResponse<Boolean>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7336a.f7312e.b(new ConnectedBankIdBody(this.f7337b, str));
    }
}
