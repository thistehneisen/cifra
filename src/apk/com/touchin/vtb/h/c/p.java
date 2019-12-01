package com.touchin.vtb.h.c;

import androidx.lifecycle.u;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.f.b.C0648a;
import com.touchin.vtb.f.b.sa;
import e.b.b.b;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.b.c;
import l.a.c.c.l;
import l.a.c.c.s;

/* compiled from: GetAccessViewModel.kt */
public class p extends s {

    /* renamed from: e reason: collision with root package name */
    private final c<a<BankConnectResponse>> f7559e = new c<>();

    /* renamed from: f reason: collision with root package name */
    private final l.a.c.b.a f7560f = new l.a.c.b.a();

    /* renamed from: g reason: collision with root package name */
    private final C0648a f7561g;

    /* renamed from: h reason: collision with root package name */
    private final sa f7562h;

    public p(C0648a aVar, sa saVar) {
        h.b(aVar, "bankRepository");
        h.b(saVar, "userProfileRepository");
        super(null, null, 3, null);
        this.f7561g = aVar;
        this.f7562h = saVar;
    }

    public final b a(BankType bankType, String str, String str2, String str3) {
        h.b(bankType, "bankType");
        h.b(str, "login");
        h.b(str2, "password");
        return a(this.f7561g.a(bankType, str, str2, str3), (u<a<T>>) this.f7559e);
    }

    public final c<a<BankConnectResponse>> c() {
        return this.f7559e;
    }

    public final l.a.c.b.a d() {
        return this.f7560f;
    }

    public final b e() {
        return l.a.a((l) this, this.f7561g.e(), (kotlin.e.a.a) new o(this), (kotlin.e.a.b) null, 2, (Object) null);
    }

    public final BankType a(String str) {
        h.b(str, "connectedBankId");
        return this.f7562h.a(str);
    }
}
