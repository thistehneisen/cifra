package com.touchin.vtb.f.b;

import com.touchin.vtb.api.TaxesListResponse;
import com.touchin.vtb.api.y;
import com.touchin.vtb.f.a;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: TaxesRepository.kt */
public final class O extends a {
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final y f7292b;

    /* renamed from: c reason: collision with root package name */
    private final i<String, String, String> f7293c;

    public O(y yVar, i<String, String, String> iVar) {
        h.b(yVar, "taxesApi");
        h.b(iVar, "sessionStorable");
        super(iVar);
        this.f7292b = yVar;
        this.f7293c = iVar;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [kotlin.e.a.b, com.touchin.vtb.f.b.M] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.touchin.vtb.f.b.N] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<TaxesListResponse> b() {
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new L<Object,Object>(this));
        ? r1 = M.f7290c;
        if (r1 != 0) {
            r1 = new N(r1);
        }
        o<TaxesListResponse> c2 = a2.c((g) r1);
        h.a((Object) c2, "getSessionId()\n         …ListResponse>::getResult)");
        return c2;
    }
}
