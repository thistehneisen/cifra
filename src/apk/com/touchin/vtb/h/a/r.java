package com.touchin.vtb.h.a;

import androidx.lifecycle.u;
import com.touchin.vtb.api.PaymentInfo;
import com.touchin.vtb.api.TaxesListResponse;
import com.touchin.vtb.api.TaxesYearInfo;
import com.touchin.vtb.f.b.O;
import e.b.b.b;
import e.b.c.g;
import e.b.o;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.c.s;

/* compiled from: TaxesViewModel.kt */
public final class r extends s {

    /* renamed from: e reason: collision with root package name */
    private final u<a<TaxesListResponse>> f7500e = new u<>();

    /* renamed from: f reason: collision with root package name */
    private final O f7501f;

    public r(O o) {
        h.b(o, "taxesRepository");
        super(null, null, 3, null);
        this.f7501f = o;
    }

    public final List<PaymentInfo> a(int i2, List<? extends TaxesYearInfo> list) {
        Object obj;
        boolean z;
        h.b(list, "taxesList");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((TaxesYearInfo) obj).d() == i2) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        TaxesYearInfo taxesYearInfo = (TaxesYearInfo) obj;
        if (taxesYearInfo != null) {
            List b2 = taxesYearInfo.b();
            if (b2 != null) {
                List<PaymentInfo> a2 = q.a((Iterable) b2, (Comparator) new o());
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return i.a();
    }

    public final u<a<TaxesListResponse>> c() {
        return this.f7500e;
    }

    public final b d() {
        o c2 = this.f7501f.b().c((g<? super T, ? extends R>) q.f7499a);
        h.a((Object) c2, "taxesRepository.getTaxes…:getYear) }\n            }");
        return a(c2, this.f7500e);
    }
}
