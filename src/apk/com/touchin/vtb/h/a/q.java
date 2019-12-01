package com.touchin.vtb.h.a;

import com.touchin.vtb.api.TaxesListResponse;
import e.b.c.g;
import java.util.Comparator;
import java.util.List;
import kotlin.e.b.h;

/* compiled from: TaxesViewModel.kt */
final class q<T, R> implements g<T, R> {

    /* renamed from: a reason: collision with root package name */
    public static final q f7499a = new q();

    q() {
    }

    public final TaxesListResponse a(TaxesListResponse taxesListResponse) {
        h.b(taxesListResponse, "response");
        List c2 = taxesListResponse.c();
        h.a((Object) c2, "response.taxesList");
        taxesListResponse.a(q.a((Iterable) c2, (Comparator) new p()));
        return taxesListResponse;
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        TaxesListResponse taxesListResponse = (TaxesListResponse) obj;
        a(taxesListResponse);
        return taxesListResponse;
    }
}
