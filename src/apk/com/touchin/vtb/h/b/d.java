package com.touchin.vtb.h.b;

import androidx.lifecycle.u;
import com.touchin.vtb.api.ConnectedBank;
import com.touchin.vtb.api.UserProfile;
import com.touchin.vtb.f.b.C0648a;
import com.touchin.vtb.f.b.qa;
import com.touchin.vtb.f.b.sa;
import e.b.c.g;
import e.b.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.a.b;
import l.a.c.b.c;
import l.a.c.c.s;

/* compiled from: BanksManagementViewModel.kt */
public final class d extends s {

    /* renamed from: e reason: collision with root package name */
    private final u<a<String>> f7506e = new u<>();

    /* renamed from: f reason: collision with root package name */
    private final c<b> f7507f = new c<>();

    /* renamed from: g reason: collision with root package name */
    private final c<a<List<ConnectedBank>>> f7508g = new c<>();

    /* renamed from: h reason: collision with root package name */
    private String f7509h = "";

    /* renamed from: i reason: collision with root package name */
    private final C0648a f7510i;

    /* renamed from: j reason: collision with root package name */
    private final qa f7511j;

    /* renamed from: k reason: collision with root package name */
    private final sa f7512k;

    public d(C0648a aVar, qa qaVar, sa saVar) {
        h.b(aVar, "bankRepository");
        h.b(qaVar, "userInfoRepository");
        h.b(saVar, "userProfileRepository");
        super(null, null, 3, null);
        this.f7510i = aVar;
        this.f7511j = qaVar;
        this.f7512k = saVar;
        d();
        c();
    }

    public final void a(String str) {
        h.b(str, "id");
        ru.touchin.roboswag.core.utils.b bVar = (ru.touchin.roboswag.core.utils.b) this.f7512k.f().k();
        if (bVar != null) {
            UserProfile userProfile = (UserProfile) bVar.a();
            if (userProfile != null) {
                sa saVar = this.f7512k;
                List c2 = userProfile.c();
                h.a((Object) c2, "connectedBanksList");
                ArrayList arrayList = new ArrayList();
                for (Object next : c2) {
                    ConnectedBank connectedBank = (ConnectedBank) next;
                    h.a((Object) connectedBank, "bank");
                    if (!h.a((Object) connectedBank.c(), (Object) str)) {
                        arrayList.add(next);
                    }
                }
                userProfile.a((List<ConnectedBank>) arrayList);
                saVar.a(new ru.touchin.roboswag.core.utils.b<>(userProfile));
            }
        }
        e.b.b d2 = this.f7510i.b(str).d();
        h.a((Object) d2, "bankRepository\n         …         .ignoreElement()");
        a(d2, (u<b>) this.f7507f);
    }

    public final void b(String str) {
        h.b(str, "<set-?>");
        this.f7509h = str;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [kotlin.e.a.b, com.touchin.vtb.h.b.a] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v3, types: [com.touchin.vtb.h.b.b, kotlin.e.a.b] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.touchin.vtb.h.b.c] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r2v1, types: [com.touchin.vtb.h.b.c] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 4 */
    public final void c() {
        e.b.j.a f2 = this.f7512k.f();
        ? r1 = a.f7503c;
        if (r1 != 0) {
            r1 = new c(r1);
        }
        k b2 = f2.b((g) r1);
        ? r12 = b.f7504c;
        if (r12 != 0) {
            r12 = new c(r12);
        }
        k b3 = b2.b((g) r12);
        h.a((Object) b3, "userProfileRepository.us…e::getConnectedBanksList)");
        a(b3, (u<a<T>>) this.f7508g);
    }

    public final void d() {
        a(this.f7511j.d(), this.f7506e);
    }

    public final c<b> e() {
        return this.f7507f;
    }

    public final String f() {
        return this.f7509h;
    }

    public final c<a<List<ConnectedBank>>> g() {
        return this.f7508g;
    }

    public final u<a<String>> h() {
        return this.f7506e;
    }
}
