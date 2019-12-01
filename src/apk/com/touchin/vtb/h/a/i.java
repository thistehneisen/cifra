package com.touchin.vtb.h.a;

import com.touchin.vtb.a.q.a;
import com.touchin.vtb.api.BankOperationsListResponse;
import com.touchin.vtb.api.OperationInfo;
import e.b.c.g;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.e.b.h;

/* compiled from: BankViewModel.kt */
final class i<T, R> implements g<T, R> {

    /* renamed from: a reason: collision with root package name */
    public static final i f7490a = new i();

    i() {
    }

    /* renamed from: a */
    public final List<a> apply(BankOperationsListResponse bankOperationsListResponse) {
        h.b(bankOperationsListResponse, "response");
        List c2 = bankOperationsListResponse.c();
        if (c2 == null) {
            c2 = i.a();
        }
        List<OperationInfo> a2 = q.a((Iterable) c2, (Comparator) new h());
        ArrayList arrayList = new ArrayList(j.a(a2, 10));
        for (OperationInfo aVar : a2) {
            arrayList.add(new a(aVar));
        }
        return arrayList;
    }
}
