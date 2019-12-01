package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankAccountsListResponse;
import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.TicketIdBody;
import e.b.c.e;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.utils.b;

/* renamed from: com.touchin.vtb.f.b.k reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
final class C0658k<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0648a f7342a;

    C0658k(C0648a aVar) {
        this.f7342a = aVar;
    }

    /* renamed from: a */
    public final o<BaseResponse<BankAccountsListResponse>> apply(String str) {
        h.b(str, "sessionId");
        b bVar = (b) this.f7342a.f7310c.k();
        return this.f7342a.f7312e.a(new TicketIdBody(bVar != null ? (String) bVar.a() : null, str)).c((e<? super T>) new C0657j<Object>(this));
    }
}
