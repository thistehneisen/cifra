package com.touchin.vtb.h.a;

import com.touchin.vtb.api.AccountInfo;
import com.touchin.vtb.api.BankAccountsListResponse;
import com.touchin.vtb.f.b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.e.b.h;

/* compiled from: BankViewModel.kt */
final class g<T, R> implements e.b.c.g<T, R> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ d f7489a;

    g(d dVar) {
        this.f7489a = dVar;
    }

    /* renamed from: a */
    public final List<b> apply(BankAccountsListResponse bankAccountsListResponse) {
        List list;
        h.b(bankAccountsListResponse, "response");
        List<AccountInfo> c2 = bankAccountsListResponse.c();
        if (c2 != null) {
            d dVar = this.f7489a;
            list = new ArrayList(j.a(c2, 10));
            for (AccountInfo a2 : c2) {
                list.add(dVar.a(a2));
            }
        } else {
            list = null;
        }
        if (list == null) {
            list = i.a();
        }
        return q.a((Iterable) list, (Comparator) new f());
    }
}
