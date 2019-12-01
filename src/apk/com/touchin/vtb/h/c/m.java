package com.touchin.vtb.h.c;

import androidx.lifecycle.u;
import com.touchin.vtb.f.b.C0648a;
import com.touchin.vtb.f.b.sa;
import e.b.b.b;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.b.c;
import l.a.c.c.l;

/* compiled from: GetAccessConfirmSmsViewModel.kt */
public final class m extends p {

    /* renamed from: i reason: collision with root package name */
    private final c<a<Boolean>> f7555i = new c<>();

    /* renamed from: j reason: collision with root package name */
    private final C0648a f7556j;

    public m(C0648a aVar, sa saVar) {
        h.b(aVar, "bankRepository");
        h.b(saVar, "userProfileRepository");
        super(aVar, saVar);
        this.f7556j = aVar;
    }

    public final b a(String str, String str2) {
        h.b(str, "connectedBankId");
        h.b(str2, "code");
        return a(this.f7556j.a(str, str2), (u<a<T>>) this.f7555i);
    }

    public final b b(String str) {
        h.b(str, "connectedBankId");
        return l.a.a((l) this, this.f7556j.a(str), (kotlin.e.a.b) null, (kotlin.e.a.b) null, 3, (Object) null);
    }

    public final c<a<Boolean>> f() {
        return this.f7555i;
    }
}
