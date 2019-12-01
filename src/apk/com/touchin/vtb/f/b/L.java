package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BaseResponse;
import com.touchin.vtb.api.SessionIdBody;
import com.touchin.vtb.api.TaxesListResponse;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;

/* compiled from: TaxesRepository.kt */
final class L<T, R> implements g<T, q<? extends R>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ O f7289a;

    L(O o) {
        this.f7289a = o;
    }

    /* renamed from: a */
    public final o<BaseResponse<TaxesListResponse>> apply(String str) {
        h.b(str, "sessionId");
        return this.f7289a.f7292b.a(new SessionIdBody(str));
    }
}
