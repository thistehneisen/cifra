package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankConnectBody;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.e;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.f.b.f reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0653f<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0648a f7329a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7330b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ BankType f7331c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ String f7332d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ String f7333e;

    C0653f(C0648a aVar, String str, BankType bankType, String str2, String str3) {
        this.f7329a = aVar;
        this.f7330b = str;
        this.f7331c = bankType;
        this.f7332d = str2;
        this.f7333e = str3;
    }

    /* renamed from: a */
    public final o<BaseResponse<BankConnectResponse>> apply(String str) {
        h.b(str, "sessionId");
        e b2 = this.f7329a.f7312e;
        BankConnectBody bankConnectBody = new BankConnectBody(this.f7330b, this.f7331c, this.f7332d, this.f7333e, str);
        return b2.a(bankConnectBody);
    }
}
