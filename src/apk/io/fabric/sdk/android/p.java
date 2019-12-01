package io.fabric.sdk.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import io.fabric.sdk.android.a.b.l;
import io.fabric.sdk.android.a.b.o;
import io.fabric.sdk.android.a.e.A;
import io.fabric.sdk.android.a.e.d;
import io.fabric.sdk.android.a.e.e;
import io.fabric.sdk.android.a.e.i;
import io.fabric.sdk.android.a.e.s;
import io.fabric.sdk.android.a.e.v;
import io.fabric.sdk.android.services.network.c;
import io.fabric.sdk.android.services.network.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: Onboarding */
class p extends l<Boolean> {

    /* renamed from: a reason: collision with root package name */
    private final g f9028a = new c();

    /* renamed from: b reason: collision with root package name */
    private PackageManager f9029b;

    /* renamed from: c reason: collision with root package name */
    private String f9030c;

    /* renamed from: d reason: collision with root package name */
    private PackageInfo f9031d;

    /* renamed from: e reason: collision with root package name */
    private String f9032e;

    /* renamed from: f reason: collision with root package name */
    private String f9033f;

    /* renamed from: g reason: collision with root package name */
    private String f9034g;

    /* renamed from: h reason: collision with root package name */
    private String f9035h;

    /* renamed from: i reason: collision with root package name */
    private String f9036i;

    /* renamed from: j reason: collision with root package name */
    private final Future<Map<String, n>> f9037j;

    /* renamed from: k reason: collision with root package name */
    private final Collection<l> f9038k;

    public p(Future<Map<String, n>> future, Collection<l> collection) {
        this.f9037j = future;
        this.f9038k = collection;
    }

    private v a() {
        try {
            s b2 = s.b();
            b2.a(this, this.idManager, this.f9028a, this.f9032e, this.f9033f, getOverridenSpiEndpoint(), o.a(getContext()));
            b2.c();
            return s.b().a();
        } catch (Exception e2) {
            f.e().b("Fabric", "Error dealing with settings", e2);
            return null;
        }
    }

    private boolean b(String str, e eVar, Collection<n> collection) {
        return new i(this, getOverridenSpiEndpoint(), eVar.f8923c, this.f9028a).a(a(io.fabric.sdk.android.a.e.o.a(getContext(), str), collection));
    }

    private boolean c(String str, e eVar, Collection<n> collection) {
        return a(eVar, io.fabric.sdk.android.a.e.o.a(getContext(), str), collection);
    }

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    /* access modifiers changed from: 0000 */
    public String getOverridenSpiEndpoint() {
        return l.b(getContext(), "com.crashlytics.ApiEndpoint");
    }

    public String getVersion() {
        return "1.4.8.32";
    }

    /* access modifiers changed from: protected */
    public boolean onPreExecute() {
        try {
            this.f9034g = getIdManager().f();
            this.f9029b = getContext().getPackageManager();
            this.f9030c = getContext().getPackageName();
            this.f9031d = this.f9029b.getPackageInfo(this.f9030c, 0);
            this.f9032e = Integer.toString(this.f9031d.versionCode);
            this.f9033f = this.f9031d.versionName == null ? "0.0" : this.f9031d.versionName;
            this.f9035h = this.f9029b.getApplicationLabel(getContext().getApplicationInfo()).toString();
            this.f9036i = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (NameNotFoundException e2) {
            f.e().b("Fabric", "Failed init", e2);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground() {
        boolean z;
        Map map;
        String c2 = l.c(getContext());
        v a2 = a();
        if (a2 != null) {
            try {
                if (this.f9037j != null) {
                    map = (Map) this.f9037j.get();
                } else {
                    map = new HashMap();
                }
                a(map, this.f9038k);
                z = a(c2, a2.f8971a, map.values());
            } catch (Exception e2) {
                f.e().b("Fabric", "Error performing auto configuration.", e2);
            }
            return Boolean.valueOf(z);
        }
        z = false;
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: 0000 */
    public Map<String, n> a(Map<String, n> map, Collection<l> collection) {
        for (l lVar : collection) {
            if (!map.containsKey(lVar.getIdentifier())) {
                map.put(lVar.getIdentifier(), new n(lVar.getIdentifier(), lVar.getVersion(), "binary"));
            }
        }
        return map;
    }

    private boolean a(String str, e eVar, Collection<n> collection) {
        String str2 = "Fabric";
        if (!"new".equals(eVar.f8922b)) {
            if ("configured".equals(eVar.f8922b)) {
                return s.b().d();
            }
            if (eVar.f8926f) {
                f.e().d(str2, "Server says an update is required - forcing a full App update.");
                c(str, eVar, collection);
            }
            return true;
        } else if (b(str, eVar, collection)) {
            return s.b().d();
        } else {
            f.e().b(str2, "Failed to create app with Crashlytics service.", null);
            return false;
        }
    }

    private boolean a(e eVar, io.fabric.sdk.android.a.e.o oVar, Collection<n> collection) {
        return new A(this, getOverridenSpiEndpoint(), eVar.f8923c, this.f9028a).a(a(oVar, collection));
    }

    private d a(io.fabric.sdk.android.a.e.o oVar, Collection<n> collection) {
        Context context = getContext();
        d dVar = new d(new io.fabric.sdk.android.a.b.i().d(context), getIdManager().c(), this.f9033f, this.f9032e, l.a(l.n(context)), this.f9035h, io.fabric.sdk.android.a.b.p.a(this.f9034g).getId(), this.f9036i, "0", oVar, collection);
        return dVar;
    }
}
