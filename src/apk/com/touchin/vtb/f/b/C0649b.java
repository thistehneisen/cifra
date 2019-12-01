package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankConnectCheckResponse;
import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.ConnectedBankIdBody;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.b reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0649b<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0648a f7317a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7318b;

    C0649b(C0648a aVar, String str) {
        this.f7317a = aVar;
        this.f7318b = str;
    }

    /* renamed from: a */
    public final o<BaseResponse<BankConnectCheckResponse>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7317a.f7312e.a(new ConnectedBankIdBody(this.f7318b, str));
    }
}
