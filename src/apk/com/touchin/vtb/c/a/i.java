package com.touchin.vtb.c.a;

import com.touchin.vtb.api.A;
import com.touchin.vtb.api.d;
import com.touchin.vtb.api.e;
import com.touchin.vtb.api.j;
import com.touchin.vtb.api.m;
import com.touchin.vtb.api.v;
import com.touchin.vtb.api.y;
import e.b.i.b;
import i.C;
import i.G;
import java.util.concurrent.TimeUnit;
import kotlin.e.b.h;
import retrofit2.adapter.rxjava2.g;
import retrofit2.w;
import ru.touchin.templates.a.c;

/* compiled from: NetworkModule.kt */
public final class i {

    /* renamed from: a reason: collision with root package name */
    private static final c f7205a = new c();

    /* renamed from: b reason: collision with root package name */
    private static final g f7206b = g.a(b.b());

    /* renamed from: c reason: collision with root package name */
    public static final a f7207c = new a(null);

    /* compiled from: NetworkModule.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    private final String a() {
        return "https://api.cifra.pw/api/v2/";
    }

    public final e a(w wVar) {
        h.b(wVar, "retrofit");
        Object a2 = wVar.a(e.class);
        h.a(a2, "retrofit.create(BankApi::class.java)");
        return (e) a2;
    }

    public final j b(w wVar) {
        h.b(wVar, "retrofit");
        Object a2 = wVar.a(j.class);
        h.a(a2, "retrofit.create(DaDataApi::class.java)");
        return (j) a2;
    }

    public final v c(w wVar) {
        h.b(wVar, "retrofit");
        Object a2 = wVar.a(v.class);
        h.a(a2, "retrofit.create(TasksApi::class.java)");
        return (v) a2;
    }

    public final y d(w wVar) {
        h.b(wVar, "retrofit");
        Object a2 = wVar.a(y.class);
        h.a(a2, "retrofit.create(TaxesApi::class.java)");
        return (y) a2;
    }

    public final A e(w wVar) {
        h.b(wVar, "retrofit");
        Object a2 = wVar.a(A.class);
        h.a(a2, "retrofit.create(UserApi::class.java)");
        return (A) a2;
    }

    private final G b(m mVar) {
        i.G.a aVar = new i.G.a();
        aVar.a(30, TimeUnit.SECONDS);
        aVar.b(30, TimeUnit.SECONDS);
        aVar.c(30, TimeUnit.SECONDS);
        aVar.a((C) mVar);
        a(aVar);
        G a2 = aVar.a();
        h.a((Object) a2, "OkHttpClient.Builder()\n …  }\n            }.build()");
        return a2;
    }

    public final w a(G g2, d dVar) {
        h.b(g2, "client");
        h.b(dVar, "apiJsonFactory");
        return a(g2, a(), dVar);
    }

    public final w a(G g2) {
        h.b(g2, "client");
        return a(g2, "https://suggestions.dadata.ru", f7205a);
    }

    public final G a(m mVar) {
        h.b(mVar, "exceptionsInterceptor");
        return b(mVar);
    }

    private final w a(G g2, String str, retrofit2.e.a aVar) {
        retrofit2.w.a aVar2 = new retrofit2.w.a();
        aVar2.a(str);
        aVar2.a(g2);
        aVar2.a((retrofit2.c.a) f7206b);
        aVar2.a(aVar);
        w a2 = aVar2.a();
        h.a((Object) a2, "Retrofit.Builder()\n     …ory)\n            .build()");
        return a2;
    }

    private final void a(i.G.a aVar) {
        Boolean bool = com.touchin.vtb.a.f6883a;
        h.a((Object) bool, "BuildConfig.WITH_SSL_PINNING");
        if (bool.booleanValue()) {
            i.C0723l.a aVar2 = new i.C0723l.a();
            StringBuilder sb = new StringBuilder();
            sb.append("sha1/");
            sb.append(j.i.b("6B2B422760D6BF441DD6BD62F14FEE781D0701A8").a());
            aVar2.a("*.cifra.pw", sb.toString());
            aVar.a(aVar2.a());
            return;
        }
        aVar.a(com.touchin.vtb.api.a.c.f7112d.b(), com.touchin.vtb.api.a.c.f7112d.c());
        aVar.a(com.touchin.vtb.api.a.c.f7112d.a());
    }
}
