package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import b.d.b;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import java.util.Map;

public final class Uc extends C0503ec {

    /* renamed from: c reason: collision with root package name */
    protected Vc f5731c;

    /* renamed from: d reason: collision with root package name */
    private volatile Vc f5732d;

    /* renamed from: e reason: collision with root package name */
    private Vc f5733e;

    /* renamed from: f reason: collision with root package name */
    private final Map<Activity, Vc> f5734f = new b();

    /* renamed from: g reason: collision with root package name */
    private Vc f5735g;

    /* renamed from: h reason: collision with root package name */
    private String f5736h;

    public Uc(Ob ob) {
        super(ob);
    }

    private final Vc d(Activity activity) {
        q.a(activity);
        Vc vc = (Vc) this.f5734f.get(activity);
        if (vc != null) {
            return vc;
        }
        Vc vc2 = new Vc(null, a(activity.getClass().getCanonicalName()), m().u());
        this.f5734f.put(activity, vc2);
        return vc2;
    }

    public final Vc B() {
        x();
        j();
        return this.f5731c;
    }

    public final Vc C() {
        h();
        return this.f5732d;
    }

    public final void a(Activity activity, String str, String str2) {
        if (this.f5732d == null) {
            e().y().a("setCurrentScreen cannot be called while no activity active");
        } else if (this.f5734f.get(activity) == null) {
            e().y().a("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = a(activity.getClass().getCanonicalName());
            }
            boolean equals = this.f5732d.f5744b.equals(str2);
            boolean e2 = Wd.e(this.f5732d.f5743a, str);
            if (equals && e2) {
                e().y().a("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                e().y().a("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                e().B().a("Setting current screen to name, class", str == null ? "null" : str, str2);
                Vc vc = new Vc(str, str2, m().u());
                this.f5734f.put(activity, vc);
                a(activity, vc, true);
            } else {
                e().y().a("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final void b(Activity activity) {
        Vc d2 = d(activity);
        this.f5733e = this.f5732d;
        this.f5732d = null;
        d().a((Runnable) new Wc(this, d2));
    }

    public final void c(Activity activity) {
        a(activity, d(activity), false);
        C0480a o = o();
        o.d().a((Runnable) new C0502eb(o, o.c().a()));
    }

    public final /* bridge */ /* synthetic */ C0532kb e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ C0576tb f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ fe g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ C0495d k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ C0522ib l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ Wd m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ C0480a o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ C0582uc p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ C0492cb q() {
        return super.q();
    }

    public final /* bridge */ /* synthetic */ Zc r() {
        return super.r();
    }

    public final /* bridge */ /* synthetic */ C0608zd u() {
        return super.u();
    }

    /* access modifiers changed from: protected */
    public final boolean z() {
        return false;
    }

    public final void b(Activity activity, Bundle bundle) {
        if (bundle != null) {
            Vc vc = (Vc) this.f5734f.get(activity);
            if (vc != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("id", vc.f5745c);
                bundle2.putString("name", vc.f5743a);
                bundle2.putString("referrer_name", vc.f5744b);
                bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
            }
        }
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    private final void a(Activity activity, Vc vc, boolean z) {
        Vc vc2 = this.f5732d == null ? this.f5733e : this.f5732d;
        if (vc.f5744b == null) {
            vc = new Vc(vc.f5743a, a(activity.getClass().getCanonicalName()), vc.f5745c);
        }
        this.f5733e = this.f5732d;
        this.f5732d = vc;
        d().a((Runnable) new Xc(this, z, vc2, vc));
    }

    /* access modifiers changed from: private */
    public final void a(Vc vc, boolean z) {
        o().a(c().a());
        if (u().a(vc.f5746d, z)) {
            vc.f5746d = false;
        }
    }

    public static void a(Vc vc, Bundle bundle, boolean z) {
        String str = "_si";
        String str2 = "_sn";
        String str3 = "_sc";
        if (bundle == null || vc == null || (bundle.containsKey(str3) && !z)) {
            if (bundle != null && vc == null && z) {
                bundle.remove(str2);
                bundle.remove(str3);
                bundle.remove(str);
            }
            return;
        }
        String str4 = vc.f5743a;
        if (str4 != null) {
            bundle.putString(str2, str4);
        } else {
            bundle.remove(str2);
        }
        bundle.putString(str3, vc.f5744b);
        bundle.putLong(str, vc.f5745c);
    }

    public final void a(String str, Vc vc) {
        j();
        synchronized (this) {
            if (this.f5736h == null || this.f5736h.equals(str) || vc != null) {
                this.f5736h = str;
                this.f5735g = vc;
            }
        }
    }

    private static String a(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    public final void a(Activity activity, Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("com.google.app_measurement.screen_service");
            if (bundle2 != null) {
                this.f5734f.put(activity, new Vc(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
            }
        }
    }

    public final void a(Activity activity) {
        this.f5734f.remove(activity);
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
