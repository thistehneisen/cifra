package com.touchin.vtb.h.a;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import com.touchin.vtb.api.AccountInfo;
import com.touchin.vtb.api.AccountType;
import com.touchin.vtb.api.Amount;
import com.touchin.vtb.api.BankConnectStatusesResponse;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.api.PaymentSystem;
import com.touchin.vtb.e.e;
import com.touchin.vtb.f.b;
import com.touchin.vtb.f.b.C0648a;
import com.touchin.vtb.f.b.sa;
import e.b.c.g;
import e.b.k;
import e.b.o;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.e.b.h;
import kotlin.e.b.q;
import l.a.c.b.c;

/* compiled from: BankViewModel.kt */
public final class d extends a {

    /* renamed from: f reason: collision with root package name */
    public static final a f7481f = new a(null);

    /* renamed from: g reason: collision with root package name */
    private final c<l.a.c.a.a<List<b>>> f7482g = new c<>();

    /* renamed from: h reason: collision with root package name */
    private final c<l.a.c.a.a<List<com.touchin.vtb.a.q.a>>> f7483h = new c<>();

    /* renamed from: i reason: collision with root package name */
    private final c<l.a.c.a.a<BankConnectStatusesResponse>> f7484i = new c<>();

    /* renamed from: j reason: collision with root package name */
    private final LiveData<b> f7485j;

    /* renamed from: k reason: collision with root package name */
    private final e.b.j.a<b> f7486k;
    /* access modifiers changed from: private */

    /* renamed from: l reason: collision with root package name */
    public e.b.b.b f7487l;
    private final sa m;
    private final C0648a n;

    /* compiled from: BankViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public d(sa saVar, C0648a aVar) {
        h.b(saVar, "userProfileRepository");
        h.b(aVar, "bankRepository");
        super(aVar);
        this.m = saVar;
        this.n = aVar;
        e.b.j.a<b> j2 = e.b.j.a.j();
        h.a((Object) j2, "BehaviorSubject.create()");
        this.f7486k = j2;
        k a2 = this.f7486k.a(300, TimeUnit.MILLISECONDS);
        h.a((Object) a2, "currentAccountBehavior\n …S, TimeUnit.MILLISECONDS)");
        this.f7485j = e.a(a2);
        this.f7485j.a((v<? super T>) new c<Object>(this));
    }

    /* access modifiers changed from: private */
    public final e.b.b.b b(b bVar) {
        o c2 = this.n.b(bVar.h(), bVar.g()).c((g<? super T, ? extends R>) i.f7490a);
        h.a((Object) c2, "bankRepository.getOperat…tem::BankOperationItem) }");
        return a(c2, (u<l.a.c.a.a<T>>) this.f7483h);
    }

    public final e.b.b.b d() {
        o c2 = this.n.b().b((e.b.c.e<? super e.b.b.b>) new e<Object>(this)).c((g<? super T, ? extends R>) new g<Object,Object>(this));
        h.a((Object) c2, "bankRepository.getAccoun…edBy(BankCardModel::id) }");
        return a(c2, (u<l.a.c.a.a<T>>) this.f7482g);
    }

    public final c<l.a.c.a.a<List<b>>> e() {
        return this.f7482g;
    }

    public final e.b.b.b f() {
        return a(this.n.c(), (u<l.a.c.a.a<T>>) this.f7484i);
    }

    public final c<l.a.c.a.a<BankConnectStatusesResponse>> g() {
        return this.f7484i;
    }

    public final c<l.a.c.a.a<List<com.touchin.vtb.a.q.a>>> h() {
        return this.f7483h;
    }

    public final String i() {
        return this.m.b();
    }

    public final void a(b bVar) {
        h.b(bVar, "model");
        this.f7486k.a(bVar);
    }

    public final BankType a(String str) {
        h.b(str, "connectedBankId");
        return this.m.a(str);
    }

    /* access modifiers changed from: private */
    public final b a(AccountInfo accountInfo) {
        String d2 = accountInfo.d();
        String str = "accountInfo.connectedBankId";
        h.a((Object) d2, str);
        BankType a2 = a(d2);
        String e2 = accountInfo.e();
        h.a((Object) e2, "accountInfo.id");
        String d3 = accountInfo.d();
        h.a((Object) d3, str);
        String h2 = accountInfo.h();
        h.a((Object) h2, "accountInfo.title");
        Integer valueOf = a2 != null ? Integer.valueOf(com.touchin.vtb.e.c.c(a2)) : null;
        Integer valueOf2 = a2 != null ? Integer.valueOf(com.touchin.vtb.e.c.a(a2)) : null;
        Integer valueOf3 = a2 != null ? Integer.valueOf(com.touchin.vtb.e.c.d(a2)) : null;
        Amount c2 = accountInfo.c();
        h.a((Object) c2, "accountInfo.amount");
        String a3 = com.touchin.vtb.e.a.a(c2, false, false, null, 7, null);
        q qVar = q.f10310a;
        String b2 = accountInfo.b();
        h.a((Object) b2, "accountInfo.accountNumberMask");
        Object[] objArr = {u.a(b2, 4)};
        String format = String.format("••••%s", Arrays.copyOf(objArr, objArr.length));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        Integer valueOf4 = a2 != null ? Integer.valueOf(com.touchin.vtb.e.c.b(a2)) : null;
        PaymentSystem g2 = accountInfo.g();
        Integer valueOf5 = g2 != null ? Integer.valueOf(com.touchin.vtb.e.g.a(g2)) : null;
        AccountType i2 = accountInfo.i();
        h.a((Object) i2, "accountInfo.type");
        b bVar = new b(e2, d3, h2, valueOf, valueOf2, valueOf3, a3, format, valueOf4, valueOf5, i2);
        return bVar;
    }
}
