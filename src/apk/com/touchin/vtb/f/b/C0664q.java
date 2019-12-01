package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankOperationsListBody;
import com.touchin.vtb.api.BankOperationsListResponse;
import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.e;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.utils.b;

/* renamed from: com.touchin.vtb.f.b.q reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0664q<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0648a f7354a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f7355b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ String f7356c;

    C0664q(C0648a aVar, String str, String str2) {
        this.f7354a = aVar;
        this.f7355b = str;
        this.f7356c = str2;
    }

    /* renamed from: a */
    public final o<BaseResponse<BankOperationsListResponse>> apply(String str) {
        h.b(str, "sessionId");
        e b2 = this.f7354a.f7312e;
        b bVar = (b) this.f7354a.f7311d.k();
        BankOperationsListBody bankOperationsListBody = new BankOperationsListBody(this.f7355b, 1000, 0, bVar != null ? (String) bVar.a() : null, this.f7356c, str);
        return b2.a(bankOperationsListBody).c((e.b.c.e<? super T>) new C0663p<Object>(this));
    }
}
