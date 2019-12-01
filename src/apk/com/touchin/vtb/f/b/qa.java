package com.touchin.vtb.f.b;

import com.touchin.vtb.api.A;
import com.touchin.vtb.api.CompanyInfo;
import com.touchin.vtb.api.DaDataQueryRequest;
import com.touchin.vtb.api.DaDataSuggestionListing;
import com.touchin.vtb.api.UserProfile;
import com.touchin.vtb.api.UserRegisterConfirmResponse;
import com.touchin.vtb.api.UserRegisterResponse;
import com.touchin.vtb.api.j;
import com.touchin.vtb.f.a;
import com.touchin.vtb.f.a.c;
import e.b.b;
import e.b.c.e;
import e.b.c.g;
import e.b.d;
import e.b.o;
import e.b.q;
import io.intercom.android.sdk.views.holder.AttributeType;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: UserInfoRepository.kt */
public final class qa extends a {
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public boolean f7357b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final A f7358c;

    /* renamed from: d reason: collision with root package name */
    private final j f7359d;

    /* renamed from: e reason: collision with root package name */
    private final c f7360e;
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public final sa f7361f;

    /* renamed from: g reason: collision with root package name */
    private final i<String, String, String> f7362g;
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public final i<String, String, String> f7363h;

    /* renamed from: i reason: collision with root package name */
    private final i<String, Boolean, Boolean> f7364i;

    public qa(A a2, j jVar, c cVar, sa saVar, i<String, String, String> iVar, i<String, String, String> iVar2, i<String, Boolean, Boolean> iVar3) {
        h.b(a2, "userApi");
        h.b(jVar, "dataApi");
        h.b(cVar, "fingerprintInteractor");
        h.b(saVar, "userProfileRepository");
        h.b(iVar, "pinStorable");
        h.b(iVar2, "sessionStorable");
        h.b(iVar3, "fastEntranceEnabledStorable");
        super(iVar2);
        this.f7358c = a2;
        this.f7359d = jVar;
        this.f7360e = cVar;
        this.f7361f = saVar;
        this.f7362g = iVar;
        this.f7363h = iVar2;
        this.f7364i = iVar3;
        this.f7364i.c().a((e<? super T>) new Q<Object>(this)).i();
    }

    public final b d(String str) {
        h.b(str, "pin");
        b a2 = this.f7362g.a(str);
        h.a((Object) a2, "pinStorable.set(pin)");
        return a2;
    }

    public final o<ru.touchin.roboswag.core.utils.b<UserProfile>> e() {
        o<ru.touchin.roboswag.core.utils.b<UserProfile>> c2 = a().a((g<? super T, ? extends q<? extends R>>) new ea<Object,Object>(this)).c((g<? super T, ? extends R>) fa.f7334a).c((e<? super T>) new na<Object>(new ga(this.f7361f)));
        h.a((Object) c2, "getSessionId()\n         …epository::updateProfile)");
        return c2;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.touchin.vtb.f.b.ha, kotlin.e.a.b] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.touchin.vtb.f.b.oa] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final b f() {
        o a2 = a();
        ? r1 = ha.f7338c;
        if (r1 != 0) {
            r1 = new oa(r1);
        }
        b a3 = a2.c((g) r1).a((g<? super T, ? extends q<? extends R>>) new oa<Object,Object>(new ia(this.f7358c))).d().a((d) b.a((e.b.c.a) new ja(this))).a((d) d("")).a((d) b.a((e.b.c.a) ka.f7343a));
        h.a((Object) a3, "getSessionId()\n         …rcom.client().logout() })");
        return a3;
    }

    public final b g() {
        b d2 = e().d();
        h.a((Object) d2, "getUserProfile().ignoreElement()");
        return d2;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [kotlin.e.a.b, com.touchin.vtb.f.b.X] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.touchin.vtb.f.b.oa] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<Boolean> b() {
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new W<Object,Object>(this));
        ? r1 = X.f7304c;
        if (r1 != 0) {
            r1 = new oa(r1);
        }
        o<Boolean> c2 = a2.c((g) r1);
        h.a((Object) c2, "getSessionId()\n         …onse<Boolean>::getResult)");
        return c2;
    }

    public final o<DaDataSuggestionListing> c(String str) {
        h.b(str, "query");
        o<DaDataSuggestionListing> c2 = this.f7359d.a(new DaDataQueryRequest(str)).c((g<? super T, ? extends R>) pa.f7353a);
        h.a((Object) c2, "dataApi.searchCompany(Da…equest(query)).map { it }");
        return c2;
    }

    public final o<String> d() {
        o<String> b2 = this.f7362g.b();
        h.a((Object) b2, "pinStorable.get()");
        return b2;
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [kotlin.e.a.b, com.touchin.vtb.f.b.Z] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [com.touchin.vtb.f.b.oa] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<UserRegisterConfirmResponse> a(String str, String str2) {
        h.b(str, "smsOperationId");
        h.b(str2, "code");
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new Y<Object,Object>(this, str, str2));
        ? r4 = Z.f7308c;
        if (r4 != 0) {
            r4 = new oa(r4);
        }
        o<UserRegisterConfirmResponse> c2 = a2.c((g) r4);
        h.a((Object) c2, "getSessionId()\n         …firmResponse>::getResult)");
        return c2;
    }

    public final o<com.touchin.vtb.f.d> c() {
        o<com.touchin.vtb.f.d> a2 = o.a(d(), this.f7360e.a(), aa.f7316a);
        h.a((Object) a2, "Single.zip(\n            …ngerprintEnabled) }\n    )");
        return a2;
    }

    private final b e(String str) {
        b b2 = a().b((g<? super T, ? extends d>) new ca<Object,Object>(this, str));
        h.a((Object) b2, "getSessionId()\n         …          }\n            }");
        return b2;
    }

    public final o<com.touchin.vtb.f.i> b(String str, String str2) {
        h.b(str2, "pushToken");
        o<com.touchin.vtb.f.i> a2 = e(str).a((q<T>) o.a(e().b(new ru.touchin.roboswag.core.utils.b(null)), d(), this.f7360e.a(), a(str2), da.f7326a));
        h.a((Object) a2, "getSessionFromApiAndSave…  )\n                    )");
        return a2;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.touchin.vtb.f.b.V, kotlin.e.a.b] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.touchin.vtb.f.b.oa] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<Boolean> a(CompanyInfo companyInfo) {
        h.b(companyInfo, "companyInfo");
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new U<Object,Object>(this, companyInfo));
        ? r0 = V.f7302c;
        if (r0 != 0) {
            r0 = new oa(r0);
        }
        o<Boolean> c2 = a2.c((g) r0);
        h.a((Object) c2, "getSessionId()\n         …onse<Boolean>::getResult)");
        return c2;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [kotlin.e.a.b, com.touchin.vtb.f.b.T] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.touchin.vtb.f.b.oa] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<Boolean> a(String str) {
        h.b(str, "pushToken");
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new S<Object,Object>(this, str));
        ? r0 = T.f7299c;
        if (r0 != 0) {
            r0 = new oa(r0);
        }
        o<Boolean> c2 = a2.c((g) r0);
        h.a((Object) c2, "getSessionId()\n         …onse<Boolean>::getResult)");
        return c2;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [kotlin.e.a.b, com.touchin.vtb.f.b.ma] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.touchin.vtb.f.b.oa] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final o<UserRegisterResponse> b(String str) {
        h.b(str, AttributeType.PHONE);
        o a2 = a().a((g<? super T, ? extends q<? extends R>>) new la<Object,Object>(this, str));
        ? r0 = ma.f7347c;
        if (r0 != 0) {
            r0 = new oa(r0);
        }
        o<UserRegisterResponse> c2 = a2.c((g) r0);
        h.a((Object) c2, "getSessionId()\n         …sterResponse>::getResult)");
        return c2;
    }
}
