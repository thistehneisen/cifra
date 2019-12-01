package com.touchin.vtb.f.b;

import com.touchin.vtb.api.BankAccountsListResponse;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BankConnectStatusesResponse;
import com.touchin.vtb.api.BankOperationsListResponse;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.api.TicketInfo;
import com.touchin.vtb.api.TicketStatus;
import com.touchin.vtb.api.e;
import com.touchin.vtb.f.a;
import com.touchin.vtb.f.c;
import e.b.c.g;
import e.b.o;
import e.b.q;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.observables.storable.i;

/* renamed from: com.touchin.vtb.f.b.a reason: case insensitive filesystem */
/* compiled from: BankRepository.kt */
public final class C0648a extends a {

    /* renamed from: b reason: collision with root package name */
    public static final C0076a f7309b = new C0076a(null);
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final e.b.j.a<ru.touchin.roboswag.core.utils.b<String>> f7310c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public final e.b.j.a<ru.touchin.roboswag.core.utils.b<String>> f7311d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public final e f7312e;
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public final qa f7313f;

    /* renamed from: g reason: collision with root package name */
    private final i<String, String, String> f7314g;

    /* renamed from: h reason: collision with root package name */
    private final i<String, Long, Long> f7315h;

    /* renamed from: com.touchin.vtb.f.b.a$a reason: collision with other inner class name */
    /* compiled from: BankRepository.kt */
    public static final class C0076a {
        private C0076a() {
        }

        public /* synthetic */ C0076a(e eVar) {
            this();
        }
    }

    /* renamed from: com.touchin.vtb.f.b.a$b */
    /* compiled from: BankRepository.kt */
    private final class b extends Exception {
        public b() {
        }
    }

    public C0648a(e eVar, qa qaVar, i<String, String, String> iVar, i<String, Long, Long> iVar2) {
        h.b(eVar, "bankApi");
        h.b(qaVar, "userInfoRepository");
        h.b(iVar, "sessionStorable");
        h.b(iVar2, "bankUsageTimeStorable");
        super(iVar);
        this.f7312e = eVar;
        this.f7313f = qaVar;
        this.f7314g = iVar;
        this.f7315h = iVar2;
        e.b.j.a<ru.touchin.roboswag.core.utils.b<String>> c2 = e.b.j.a.c(new ru.touchin.roboswag.core.utils.b(null));
        String str = "BehaviorSubject.createDe…ptional(null as String?))";
        h.a((Object) c2, str);
        this.f7310c = c2;
        e.b.j.a<ru.touchin.roboswag.core.utils.b<String>> c3 = e.b.j.a.c(new ru.touchin.roboswag.core.utils.b(null));
        h.a((Object) c3, str);
        this.f7311d = c3;
    }

    public final e.b.b e() {
        return this.f7313f.g();
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [kotlin.e.a.b, com.touchin.vtb.f.b.i] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.touchin.vtb.f.b.u] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<Boolean> b(String str) {
        h.b(str, "connectedBankId");
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new C0655h<Object,Object>(this, str));
        ? r0 = C0656i.f7339c;
        if (r0 != 0) {
            r0 = new C0667u(r0);
        }
        o<Boolean> c2 = a2.c((g) r0);
        h.a((Object) c2, "getSessionId()\n         …onse<Boolean>::getResult)");
        return c2;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [kotlin.e.a.b, com.touchin.vtb.f.b.o] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.touchin.vtb.f.b.u] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<BankConnectStatusesResponse> c() {
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new C0661n<Object,Object>(this));
        ? r1 = C0662o.f7350c;
        if (r1 != 0) {
            r1 = new C0667u(r1);
        }
        o<BankConnectStatusesResponse> c2 = a2.c((g) r1);
        h.a((Object) c2, "getSessionId()\n         …usesResponse>::getResult)");
        return c2;
    }

    public final o<Long> d() {
        o<Long> b2 = this.f7315h.b();
        h.a((Object) b2, "bankUsageTimeStorable.get()");
        return b2;
    }

    /* JADX WARNING: type inference failed for: r10v1, types: [com.touchin.vtb.f.b.g, kotlin.e.a.b] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r11v1, types: [com.touchin.vtb.f.b.u] */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<BankConnectResponse> a(BankType bankType, String str, String str2, String str3) {
        h.b(bankType, "bankType");
        h.b(str, "login");
        h.b(str2, "password");
        o a2 = a();
        C0653f fVar = new C0653f(this, str3, bankType, str, str2);
        o a3 = a2.a((g<? super T, ? extends q<? extends R>>) fVar);
        ? r10 = C0654g.f7335c;
        if (r10 != 0) {
            r10 = new C0667u(r10);
        }
        o<BankConnectResponse> c2 = a3.c((g) r10);
        h.a((Object) c2, "getSessionId()\n         …nectResponse>::getResult)");
        return c2;
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [kotlin.e.a.b, com.touchin.vtb.f.b.m] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r2v1, types: [com.touchin.vtb.f.b.u] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<BankAccountsListResponse> b() {
        o d2 = a().a((g<? super T, ? extends q<? extends R>>) new C0658k<Object,Object>(this)).d(new C0667u(new C0659l(this)));
        ? r1 = C0660m.f7346c;
        if (r1 != 0) {
            r1 = new C0667u(r1);
        }
        o<BankAccountsListResponse> c2 = d2.c((g) r1);
        h.a((Object) c2, "getSessionId()\n         …ListResponse>::getResult)");
        return c2;
    }

    public final o<Boolean> a(String str, String str2) {
        h.b(str, "connectedBankId");
        h.b(str2, "code");
        o<Boolean> c2 = a().a((g<? super T, ? extends q<? extends R>>) new C0651d<Object,Object>(this, str2, str)).c((g<? super T, ? extends R>) new C0652e<Object,Object>(this));
        h.a((Object) c2, "getSessionId()\n         …onse.result\n            }");
        return c2;
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [kotlin.e.a.b, com.touchin.vtb.f.b.s] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r0v5, types: [com.touchin.vtb.f.b.u] */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<BankOperationsListResponse> b(String str, String str2) {
        h.b(str, "accountId");
        h.b(str2, "connectedBankId");
        this.f7311d.a(new ru.touchin.roboswag.core.utils.b(null));
        o d2 = a().a((g<? super T, ? extends q<? extends R>>) new C0664q<Object,Object>(this, str, str2)).d(new C0667u(new r(this)));
        ? r5 = C0665s.f7372c;
        if (r5 != 0) {
            r5 = new C0667u(r5);
        }
        o<BankOperationsListResponse> c2 = d2.c((g) r5);
        h.a((Object) c2, "getSessionId()\n         …ListResponse>::getResult)");
        return c2;
    }

    public final o<c> a(String str) {
        h.b(str, "connectedBankId");
        o<c> c2 = a().a((g<? super T, ? extends q<? extends R>>) new C0649b<Object,Object>(this, str)).c((g<? super T, ? extends R>) new C0650c<Object,Object>(str));
        h.a((Object) c2, "getSessionId()\n         …ult!!, connectedBankId) }");
        return c2;
    }

    public final e.b.b a(long j2) {
        e.b.b a2 = this.f7315h.a(Long.valueOf(j2));
        h.a((Object) a2, "bankUsageTimeStorable.set(timeOfUsageMillis)");
        return a2;
    }

    /* access modifiers changed from: private */
    public final void a(TicketInfo ticketInfo, e.b.j.a<ru.touchin.roboswag.core.utils.b<String>> aVar) throws b {
        if ((ticketInfo != null ? ticketInfo.c() : null) != TicketStatus.WAITING) {
            aVar.a(new ru.touchin.roboswag.core.utils.b(null));
        } else {
            aVar.a(new ru.touchin.roboswag.core.utils.b(ticketInfo.b()));
            throw new b();
        }
    }

    /* access modifiers changed from: private */
    public final e.b.e<Object> a(e.b.e<Throwable> eVar) {
        e.b.e<Object> b2 = eVar.b((g<? super T, ? extends k.a.b<? extends R>>) new C0666t<Object,Object>(this));
        h.a((Object) b2, "attempts\n            .sw…          }\n            }");
        return b2;
    }
}
