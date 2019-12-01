package com.touchin.vtb.h.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.u;
import com.touchin.vtb.api.DaDataSuggestionListing;
import com.touchin.vtb.e.e;
import com.touchin.vtb.f.b.qa;
import e.b.c.i;
import e.b.k;
import java.util.concurrent.TimeUnit;
import kotlin.e.b.h;
import l.a.c.c.s;

/* compiled from: SearchViewModel.kt */
public final class v extends s {

    /* renamed from: e reason: collision with root package name */
    public static final a f7570e = new a(null);

    /* renamed from: f reason: collision with root package name */
    private final u<l.a.c.a.a<DaDataSuggestionListing>> f7571f = new u<>();

    /* renamed from: g reason: collision with root package name */
    private final LiveData<String> f7572g;

    /* renamed from: h reason: collision with root package name */
    private final e.b.j.a<String> f7573h;

    /* renamed from: i reason: collision with root package name */
    private final qa f7574i;

    /* compiled from: SearchViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [kotlin.e.a.b, com.touchin.vtb.h.c.t] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r1v2, types: [com.touchin.vtb.h.c.w] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public v(qa qaVar) {
        h.b(qaVar, "userInfoRepository");
        super(null, null, 3, null);
        this.f7574i = qaVar;
        e.b.j.a<String> c2 = e.b.j.a.c("");
        h.a((Object) c2, "BehaviorSubject.createDefault(\"\")");
        this.f7573h = c2;
        k a2 = this.f7573h.a(500, TimeUnit.MILLISECONDS);
        ? r0 = t.f7568c;
        if (r0 != 0) {
            r0 = new w(r0);
        }
        k b2 = a2.a((i) r0).b();
        h.a((Object) b2, "queryBehavior\n          …  .distinctUntilChanged()");
        this.f7572g = e.a(b2);
        this.f7572g.a((androidx.lifecycle.v<? super T>) new u<Object>(this));
    }

    public final void a(String str) {
        h.b(str, "query");
        this.f7573h.a(str);
    }

    public final u<l.a.c.a.a<DaDataSuggestionListing>> c() {
        return this.f7571f;
    }

    public final void d() {
        qa qaVar = this.f7574i;
        Object a2 = this.f7572g.a();
        if (a2 != null) {
            h.a(a2, "queryLiveData.value!!");
            a(qaVar.c((String) a2), this.f7571f);
            return;
        }
        h.a();
        throw null;
    }
}
