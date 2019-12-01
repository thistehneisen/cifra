package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.C0300c;
import com.google.android.gms.common.b.c;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.g;
import com.google.android.gms.internal.measurement.Af;
import com.google.android.gms.internal.measurement.C0439ta;
import com.google.android.gms.internal.measurement.sf;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class Ob implements C0543mc {

    /* renamed from: a reason: collision with root package name */
    private static volatile Ob f5664a;
    private long A;
    private volatile Boolean B;
    private Boolean C;
    private Boolean D;
    private int E;
    private AtomicInteger F = new AtomicInteger(0);
    private final long G;

    /* renamed from: b reason: collision with root package name */
    private final Context f5665b;

    /* renamed from: c reason: collision with root package name */
    private final String f5666c;

    /* renamed from: d reason: collision with root package name */
    private final String f5667d;

    /* renamed from: e reason: collision with root package name */
    private final String f5668e;

    /* renamed from: f reason: collision with root package name */
    private final boolean f5669f;

    /* renamed from: g reason: collision with root package name */
    private final ee f5670g;

    /* renamed from: h reason: collision with root package name */
    private final fe f5671h;

    /* renamed from: i reason: collision with root package name */
    private final C0576tb f5672i;

    /* renamed from: j reason: collision with root package name */
    private final C0532kb f5673j;

    /* renamed from: k reason: collision with root package name */
    private final Ib f5674k;

    /* renamed from: l reason: collision with root package name */
    private final C0608zd f5675l;
    private final Wd m;
    private final C0522ib n;
    private final d o;
    private final Uc p;
    private final C0582uc q;
    private final C0480a r;
    private final Pc s;
    private C0512gb t;
    private Zc u;
    private C0495d v;
    private C0492cb w;
    private C0606zb x;
    private boolean y = false;
    private Boolean z;

    private Ob(C0567rc rcVar) {
        boolean z2 = false;
        q.a(rcVar);
        this.f5670g = new ee(rcVar.f6078a);
        C0535l.a(this.f5670g);
        this.f5665b = rcVar.f6078a;
        this.f5666c = rcVar.f6079b;
        this.f5667d = rcVar.f6080c;
        this.f5668e = rcVar.f6081d;
        this.f5669f = rcVar.f6085h;
        this.B = rcVar.f6082e;
        Af af = rcVar.f6084g;
        if (af != null) {
            Bundle bundle = af.f4858g;
            if (bundle != null) {
                Object obj = bundle.get("measurementEnabled");
                if (obj instanceof Boolean) {
                    this.C = (Boolean) obj;
                }
                Object obj2 = af.f4858g.get("measurementDeactivated");
                if (obj2 instanceof Boolean) {
                    this.D = (Boolean) obj2;
                }
            }
        }
        C0439ta.a(this.f5665b);
        this.o = g.c();
        this.G = this.o.currentTimeMillis();
        this.f5671h = new fe(this);
        C0576tb tbVar = new C0576tb(this);
        tbVar.n();
        this.f5672i = tbVar;
        C0532kb kbVar = new C0532kb(this);
        kbVar.n();
        this.f5673j = kbVar;
        Wd wd = new Wd(this);
        wd.n();
        this.m = wd;
        C0522ib ibVar = new C0522ib(this);
        ibVar.n();
        this.n = ibVar;
        this.r = new C0480a(this);
        Uc uc = new Uc(this);
        uc.v();
        this.p = uc;
        C0582uc ucVar = new C0582uc(this);
        ucVar.v();
        this.q = ucVar;
        C0608zd zdVar = new C0608zd(this);
        zdVar.v();
        this.f5675l = zdVar;
        Pc pc = new Pc(this);
        pc.n();
        this.s = pc;
        Ib ib = new Ib(this);
        ib.n();
        this.f5674k = ib;
        Af af2 = rcVar.f6084g;
        if (!(af2 == null || af2.f4853b == 0)) {
            z2 = true;
        }
        boolean z3 = !z2;
        ee eeVar = this.f5670g;
        if (this.f5665b.getApplicationContext() instanceof Application) {
            C0582uc y2 = y();
            if (y2.a().getApplicationContext() instanceof Application) {
                Application application = (Application) y2.a().getApplicationContext();
                if (y2.f6117c == null) {
                    y2.f6117c = new Nc(y2, null);
                }
                if (z3) {
                    application.unregisterActivityLifecycleCallbacks(y2.f6117c);
                    application.registerActivityLifecycleCallbacks(y2.f6117c);
                    y2.e().B().a("Registered activity lifecycle callback");
                }
            }
        } else {
            e().w().a("Application context is not an Application");
        }
        this.f5674k.a((Runnable) new Qb(this, rcVar));
    }

    private final void H() {
        if (!this.y) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    private final Pc I() {
        b((C0528jc) this.s);
        return this.s;
    }

    /* access modifiers changed from: private */
    public final void a(C0567rc rcVar) {
        String str;
        C0542mb mbVar;
        d().j();
        fe.o();
        C0495d dVar = new C0495d(this);
        dVar.n();
        this.v = dVar;
        C0492cb cbVar = new C0492cb(this, rcVar.f6083f);
        cbVar.v();
        this.w = cbVar;
        C0512gb gbVar = new C0512gb(this);
        gbVar.v();
        this.t = gbVar;
        Zc zc = new Zc(this);
        zc.v();
        this.u = zc;
        this.m.q();
        this.f5672i.q();
        this.x = new C0606zb(this);
        this.w.y();
        e().z().a("App measurement is starting up, version", Long.valueOf(this.f5671h.n()));
        ee eeVar = this.f5670g;
        e().z().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        ee eeVar2 = this.f5670g;
        String C2 = cbVar.C();
        if (TextUtils.isEmpty(this.f5666c)) {
            if (G().f(C2)) {
                mbVar = e().z();
                str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                mbVar = e().z();
                String str2 = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
                String valueOf = String.valueOf(C2);
                str = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            }
            mbVar.a(str);
        }
        e().A().a("Debug-level message logging enabled");
        if (this.E != this.F.get()) {
            e().t().a("Not all components initialized", Integer.valueOf(this.E), Integer.valueOf(this.F.get()));
        }
        this.y = true;
    }

    public final Zc A() {
        b((C0503ec) this.u);
        return this.u;
    }

    public final Uc B() {
        b((C0503ec) this.p);
        return this.p;
    }

    public final C0512gb C() {
        b((C0503ec) this.t);
        return this.t;
    }

    public final C0608zd D() {
        b((C0503ec) this.f5675l);
        return this.f5675l;
    }

    public final C0495d E() {
        b((C0528jc) this.v);
        return this.v;
    }

    public final C0522ib F() {
        a((C0533kc) this.n);
        return this.n;
    }

    public final Wd G() {
        a((C0533kc) this.m);
        return this.m;
    }

    public final ee b() {
        return this.f5670g;
    }

    public final d c() {
        return this.o;
    }

    public final Ib d() {
        b((C0528jc) this.f5674k);
        return this.f5674k;
    }

    public final C0532kb e() {
        b((C0528jc) this.f5673j);
        return this.f5673j;
    }

    public final boolean f() {
        boolean z2;
        d().j();
        H();
        if (this.f5671h.a(C0535l.ra)) {
            if (this.f5671h.q()) {
                return false;
            }
            Boolean bool = this.D;
            if (bool != null && bool.booleanValue()) {
                return false;
            }
            Boolean x2 = h().x();
            if (x2 != null) {
                return x2.booleanValue();
            }
            Boolean r2 = this.f5671h.r();
            if (r2 != null) {
                return r2.booleanValue();
            }
            Boolean bool2 = this.C;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            if (C0300c.b()) {
                return false;
            }
            if (!this.f5671h.a(C0535l.ma) || this.B == null) {
                return true;
            }
            return this.B.booleanValue();
        } else if (this.f5671h.q()) {
            return false;
        } else {
            Boolean r3 = this.f5671h.r();
            if (r3 != null) {
                z2 = r3.booleanValue();
            } else {
                z2 = !C0300c.b();
                if (z2 && this.B != null && ((Boolean) C0535l.ma.a(null)).booleanValue()) {
                    z2 = this.B.booleanValue();
                }
            }
            return h().c(z2);
        }
    }

    /* access modifiers changed from: protected */
    public final void g() {
        d().j();
        if (h().f6103f.a() == 0) {
            h().f6103f.a(this.o.currentTimeMillis());
        }
        if (Long.valueOf(h().f6108k.a()).longValue() == 0) {
            e().B().a("Persisting first open", Long.valueOf(this.G));
            h().f6108k.a(this.G);
        }
        if (u()) {
            ee eeVar = this.f5670g;
            if (!TextUtils.isEmpty(z().B()) || !TextUtils.isEmpty(z().D())) {
                G();
                if (Wd.a(z().B(), h().t(), z().D(), h().u())) {
                    e().z().a("Rechecking which service to use due to a GMP App Id change");
                    h().w();
                    C().B();
                    this.u.B();
                    this.u.G();
                    h().f6108k.a(this.G);
                    h().m.a(null);
                }
                h().c(z().B());
                h().d(z().D());
            }
            y().a(h().m.a());
            ee eeVar2 = this.f5670g;
            if (!TextUtils.isEmpty(z().B()) || !TextUtils.isEmpty(z().D())) {
                boolean f2 = f();
                if (!h().A() && !this.f5671h.q()) {
                    h().d(!f2);
                }
                if (f2) {
                    y().L();
                }
                A().a(new AtomicReference<>());
            }
        } else if (f()) {
            if (!G().d("android.permission.INTERNET")) {
                e().t().a("App is missing INTERNET permission");
            }
            if (!G().d("android.permission.ACCESS_NETWORK_STATE")) {
                e().t().a("App is missing ACCESS_NETWORK_STATE permission");
            }
            ee eeVar3 = this.f5670g;
            if (!c.a(this.f5665b).a() && !this.f5671h.x()) {
                if (!Eb.a(this.f5665b)) {
                    e().t().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!Wd.a(this.f5665b, false)) {
                    e().t().a("AppMeasurementService not registered/enabled");
                }
            }
            e().t().a("Uploading is not possible. App measurement disabled");
        }
        h().u.a(this.f5671h.a(C0535l.Aa));
        h().v.a(this.f5671h.a(C0535l.Ba));
    }

    public final C0576tb h() {
        a((C0533kc) this.f5672i);
        return this.f5672i;
    }

    public final fe i() {
        return this.f5671h;
    }

    public final C0532kb j() {
        C0532kb kbVar = this.f5673j;
        if (kbVar == null || !kbVar.o()) {
            return null;
        }
        return this.f5673j;
    }

    public final C0606zb k() {
        return this.x;
    }

    /* access modifiers changed from: 0000 */
    public final Ib l() {
        return this.f5674k;
    }

    public final boolean m() {
        return TextUtils.isEmpty(this.f5666c);
    }

    public final String n() {
        return this.f5666c;
    }

    public final String o() {
        return this.f5667d;
    }

    public final String p() {
        return this.f5668e;
    }

    public final boolean q() {
        return this.f5669f;
    }

    public final boolean r() {
        return this.B != null && this.B.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public final long s() {
        Long valueOf = Long.valueOf(h().f6108k.a());
        if (valueOf.longValue() == 0) {
            return this.G;
        }
        return Math.min(this.G, valueOf.longValue());
    }

    /* access modifiers changed from: 0000 */
    public final void t() {
        this.F.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        H();
        d().j();
        Boolean bool = this.z;
        if (bool == null || this.A == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.o.a() - this.A) > 1000)) {
            this.A = this.o.a();
            ee eeVar = this.f5670g;
            boolean z2 = true;
            this.z = Boolean.valueOf(G().d("android.permission.INTERNET") && G().d("android.permission.ACCESS_NETWORK_STATE") && (c.a(this.f5665b).a() || this.f5671h.x() || (Eb.a(this.f5665b) && Wd.a(this.f5665b, false))));
            if (this.z.booleanValue()) {
                if (!G().d(z().B(), z().D()) && TextUtils.isEmpty(z().D())) {
                    z2 = false;
                }
                this.z = Boolean.valueOf(z2);
            }
        }
        return this.z.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public final void v() {
        ee eeVar = this.f5670g;
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: 0000 */
    public final void w() {
        ee eeVar = this.f5670g;
    }

    public final C0480a x() {
        C0480a aVar = this.r;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public final C0582uc y() {
        b((C0503ec) this.q);
        return this.q;
    }

    public final C0492cb z() {
        b((C0503ec) this.w);
        return this.w;
    }

    private static void b(C0528jc jcVar) {
        if (jcVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!jcVar.o()) {
            String valueOf = String.valueOf(jcVar.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void b(C0503ec ecVar) {
        if (ecVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!ecVar.w()) {
            String valueOf = String.valueOf(ecVar.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    public final Context a() {
        return this.f5665b;
    }

    public static Ob a(Context context, String str, String str2, Bundle bundle) {
        Af af = new Af(0, 0, true, null, null, null, bundle);
        return a(context, af);
    }

    public static Ob a(Context context, Af af) {
        if (af != null && (af.f4856e == null || af.f4857f == null)) {
            Af af2 = new Af(af.f4852a, af.f4853b, af.f4854c, af.f4855d, null, null, af.f4858g);
            af = af2;
        }
        q.a(context);
        q.a(context.getApplicationContext());
        if (f5664a == null) {
            synchronized (Ob.class) {
                if (f5664a == null) {
                    f5664a = new Ob(new C0567rc(context, af));
                }
            }
        } else if (af != null) {
            Bundle bundle = af.f4858g;
            if (bundle != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
                f5664a.a(af.f4858g.getBoolean("dataCollectionDefaultEnabled"));
            }
        }
        return f5664a;
    }

    private static void a(C0533kc kcVar) {
        if (kcVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(boolean z2) {
        this.B = Boolean.valueOf(z2);
    }

    /* access modifiers changed from: 0000 */
    public final void a(C0528jc jcVar) {
        this.E++;
    }

    /* access modifiers changed from: 0000 */
    public final void a(C0503ec ecVar) {
        this.E++;
    }

    public final void a(sf sfVar) {
        d().j();
        b((C0528jc) I());
        String C2 = z().C();
        Pair a2 = h().a(C2);
        String str = "";
        if (!this.f5671h.s().booleanValue() || ((Boolean) a2.second).booleanValue()) {
            e().A().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            G().a(sfVar, str);
        } else if (!I().t()) {
            e().w().a("Network is not available for Deferred Deep Link request. Skipping");
            G().a(sfVar, str);
        } else {
            URL a3 = G().a(z().g().n(), C2, (String) a2.first);
            Pc I = I();
            Nb nb = new Nb(this, sfVar);
            I.j();
            I.p();
            q.a(a3);
            q.a(nb);
            Ib d2 = I.d();
            Rc rc = new Rc(I, C2, a3, null, null, nb);
            d2.b((Runnable) rc);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081 A[Catch:{ JSONException -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0096 A[Catch:{ JSONException -> 0x00b2 }] */
    public final /* synthetic */ void a(sf sfVar, String str, int i2, Throwable th, byte[] bArr, Map map) {
        String str2 = "gclid";
        String str3 = "deeplink";
        boolean z2 = true;
        String str4 = "";
        if (!((i2 == 200 || i2 == 204 || i2 == 304) && th == null)) {
            e().w().a("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
            G().a(sfVar, str4);
        } else if (bArr.length == 0) {
            G().a(sfVar, str4);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString(str3, str4);
                String optString2 = jSONObject.optString(str2, str4);
                Wd G2 = G();
                G2.h();
                if (!TextUtils.isEmpty(optString)) {
                    List queryIntentActivities = G2.a().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        if (z2) {
                            e().w().a("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                            G().a(sfVar, str4);
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString(str3, optString);
                        bundle.putString(str2, optString2);
                        this.q.b("auto", "_cmp", bundle);
                        G().a(sfVar, optString);
                        return;
                    }
                }
                z2 = false;
                if (z2) {
                }
            } catch (JSONException e2) {
                e().t().a("Failed to parse the Deferred Deep Link response. exception", e2);
                G().a(sfVar, str4);
            }
        }
    }
}
