package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C0300c;
import com.google.android.gms.common.b.a;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.util.d;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.cb reason: case insensitive filesystem */
public final class C0492cb extends C0503ec {

    /* renamed from: c reason: collision with root package name */
    private String f5844c;

    /* renamed from: d reason: collision with root package name */
    private String f5845d;

    /* renamed from: e reason: collision with root package name */
    private int f5846e;

    /* renamed from: f reason: collision with root package name */
    private String f5847f;

    /* renamed from: g reason: collision with root package name */
    private String f5848g;

    /* renamed from: h reason: collision with root package name */
    private long f5849h;

    /* renamed from: i reason: collision with root package name */
    private long f5850i;

    /* renamed from: j reason: collision with root package name */
    private long f5851j;

    /* renamed from: k reason: collision with root package name */
    private List<String> f5852k;

    /* renamed from: l reason: collision with root package name */
    private int f5853l;
    private String m;
    private String n;

    C0492cb(Ob ob, long j2) {
        super(ob);
        this.f5851j = j2;
    }

    private final String H() {
        try {
            Class loadClass = a().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{a()});
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    e().y().a("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                e().x().a("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x019d A[Catch:{ IllegalStateException -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x019e A[Catch:{ IllegalStateException -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a7 A[Catch:{ IllegalStateException -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01ba A[Catch:{ IllegalStateException -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x023a  */
    public final void A() {
        String str;
        boolean z;
        boolean z2;
        String a2;
        String str2;
        String packageName = a().getPackageName();
        PackageManager packageManager = a().getPackageManager();
        String str3 = "Unknown";
        String str4 = "";
        String str5 = AttributeType.UNKNOWN;
        int i2 = Integer.MIN_VALUE;
        if (packageManager == null) {
            e().t().a("PackageManager is null, app identity information might be inaccurate. appId", C0532kb.a(packageName));
        } else {
            try {
                str5 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                e().t().a("Error retrieving app installer package name. appId", C0532kb.a(packageName));
            }
            if (str5 == null) {
                str5 = "manual_install";
            } else if ("com.android.vending".equals(str5)) {
                str5 = str4;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(a().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    str = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : str3;
                    try {
                        str3 = packageInfo.versionName;
                        i2 = packageInfo.versionCode;
                    } catch (NameNotFoundException unused2) {
                        str2 = str3;
                        str3 = str;
                    }
                    this.f5844c = packageName;
                    this.f5847f = str5;
                    this.f5845d = str3;
                    this.f5846e = i2;
                    this.f5848g = str;
                    this.f5849h = 0;
                    b();
                    Status a3 = C0300c.a(a());
                    boolean z3 = true;
                    String str6 = "am";
                    z = (a3 == null && a3.h()) | (TextUtils.isEmpty(this.f5987a.n()) && str6.equals(this.f5987a.o()));
                    if (!z) {
                        if (a3 == null) {
                            e().t().a("GoogleService failed to initialize (no status)");
                        } else {
                            e().t().a("GoogleService failed to initialize, status", Integer.valueOf(a3.f()), a3.g());
                        }
                    }
                    if (z) {
                        Boolean r = g().r();
                        if (g().q()) {
                            if (this.f5987a.m()) {
                                e().z().a("Collection disabled with firebase_analytics_collection_deactivated=1");
                            }
                        } else if (r == null || r.booleanValue()) {
                            if (r != null || !C0300c.b()) {
                                e().B().a("Collection enabled");
                                z2 = true;
                                this.m = str4;
                                this.n = str4;
                                this.f5850i = 0;
                                b();
                                if (!TextUtils.isEmpty(this.f5987a.n()) && str6.equals(this.f5987a.o())) {
                                    this.n = this.f5987a.n();
                                }
                                a2 = C0300c.a();
                                if (TextUtils.isEmpty(a2)) {
                                    str4 = a2;
                                }
                                this.m = str4;
                                if (!TextUtils.isEmpty(a2)) {
                                    this.n = new u(a()).a("admob_app_id");
                                }
                                if (z2) {
                                    e().B().a("App package, google app id", this.f5844c, this.m);
                                }
                                this.f5852k = null;
                                if (g().e(this.f5844c, C0535l.Da)) {
                                    b();
                                    List<String> c2 = g().c("analytics.safelisted_events");
                                    if (c2 != null) {
                                        if (c2.size() != 0) {
                                            Iterator it = c2.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                if (!m().c("safelisted event", (String) it.next())) {
                                                    break;
                                                }
                                            }
                                        } else {
                                            e().w().a("Safelisted event list cannot be empty. Ignoring");
                                        }
                                        z3 = false;
                                    }
                                    if (z3) {
                                        this.f5852k = c2;
                                    }
                                }
                                if (VERSION.SDK_INT >= 16) {
                                    this.f5853l = 0;
                                    return;
                                } else if (packageManager != null) {
                                    this.f5853l = a.a(a()) ? 1 : 0;
                                    return;
                                } else {
                                    this.f5853l = 0;
                                    return;
                                }
                            } else {
                                e().z().a("Collection disabled with google_app_measurement_enable=0");
                            }
                        } else if (this.f5987a.m()) {
                            e().z().a("Collection disabled with firebase_analytics_collection_enabled=0");
                        }
                    }
                    z2 = false;
                    this.m = str4;
                    this.n = str4;
                    this.f5850i = 0;
                    b();
                    this.n = this.f5987a.n();
                    a2 = C0300c.a();
                    if (TextUtils.isEmpty(a2)) {
                    }
                    this.m = str4;
                    if (!TextUtils.isEmpty(a2)) {
                    }
                    if (z2) {
                    }
                    this.f5852k = null;
                    if (g().e(this.f5844c, C0535l.Da)) {
                    }
                    if (VERSION.SDK_INT >= 16) {
                    }
                }
            } catch (NameNotFoundException unused3) {
                str2 = str3;
                e().t().a("Error retrieving package info. appId, appName", C0532kb.a(packageName), str3);
                str = str3;
                str3 = str2;
                this.f5844c = packageName;
                this.f5847f = str5;
                this.f5845d = str3;
                this.f5846e = i2;
                this.f5848g = str;
                this.f5849h = 0;
                b();
                Status a32 = C0300c.a(a());
                boolean z32 = true;
                String str62 = "am";
                z = (a32 == null && a32.h()) | (TextUtils.isEmpty(this.f5987a.n()) && str62.equals(this.f5987a.o()));
                if (!z) {
                }
                if (z) {
                }
                z2 = false;
                this.m = str4;
                this.n = str4;
                this.f5850i = 0;
                b();
                this.n = this.f5987a.n();
                a2 = C0300c.a();
                if (TextUtils.isEmpty(a2)) {
                }
                this.m = str4;
                if (!TextUtils.isEmpty(a2)) {
                }
                if (z2) {
                }
                this.f5852k = null;
                if (g().e(this.f5844c, C0535l.Da)) {
                }
                if (VERSION.SDK_INT >= 16) {
                }
            }
        }
        str = str3;
        this.f5844c = packageName;
        this.f5847f = str5;
        this.f5845d = str3;
        this.f5846e = i2;
        this.f5848g = str;
        this.f5849h = 0;
        b();
        Status a322 = C0300c.a(a());
        boolean z322 = true;
        String str622 = "am";
        z = (a322 == null && a322.h()) | (TextUtils.isEmpty(this.f5987a.n()) && str622.equals(this.f5987a.o()));
        if (!z) {
        }
        if (z) {
        }
        z2 = false;
        this.m = str4;
        this.n = str4;
        this.f5850i = 0;
        b();
        this.n = this.f5987a.n();
        try {
            a2 = C0300c.a();
            if (TextUtils.isEmpty(a2)) {
            }
            this.m = str4;
            if (!TextUtils.isEmpty(a2)) {
            }
            if (z2) {
            }
        } catch (IllegalStateException e2) {
            e().t().a("getGoogleAppId or isMeasurementEnabled failed with exception. appId", C0532kb.a(packageName), e2);
        }
        this.f5852k = null;
        if (g().e(this.f5844c, C0535l.Da)) {
        }
        if (VERSION.SDK_INT >= 16) {
        }
    }

    /* access modifiers changed from: 0000 */
    public final String B() {
        x();
        return this.m;
    }

    /* access modifiers changed from: 0000 */
    public final String C() {
        x();
        return this.f5844c;
    }

    /* access modifiers changed from: 0000 */
    public final String D() {
        x();
        return this.n;
    }

    /* access modifiers changed from: 0000 */
    public final List<String> E() {
        return this.f5852k;
    }

    /* access modifiers changed from: 0000 */
    public final int F() {
        x();
        return this.f5846e;
    }

    /* access modifiers changed from: 0000 */
    public final int G() {
        x();
        return this.f5853l;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0107  */
    public final ae a(String str) {
        String str2;
        Boolean bool;
        j();
        h();
        String C = C();
        String B = B();
        x();
        String str3 = this.f5845d;
        long F = (long) F();
        x();
        String str4 = this.f5847f;
        long n2 = g().n();
        x();
        j();
        if (this.f5849h == 0) {
            this.f5849h = this.f5987a.G().a(a(), a().getPackageName());
        }
        long j2 = this.f5849h;
        boolean f2 = this.f5987a.f();
        boolean z = !f().y;
        j();
        h();
        if (!this.f5987a.f()) {
            str2 = null;
        } else {
            str2 = H();
        }
        x();
        boolean z2 = f2;
        long j3 = this.f5850i;
        long s = this.f5987a.s();
        int G = G();
        boolean booleanValue = g().s().booleanValue();
        fe g2 = g();
        g2.h();
        Boolean b2 = g2.b("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(b2 == null || b2.booleanValue()).booleanValue();
        boolean z3 = f().z();
        String D = D();
        long j4 = j3;
        if (g().e(C(), C0535l.pa)) {
            Boolean b3 = g().b("google_analytics_default_allow_ad_personalization_signals");
            if (b3 != null) {
                bool = Boolean.valueOf(!b3.booleanValue());
                ae aeVar = new ae(C, B, str3, F, str4, n2, j2, str, z2, z, str2, j4, s, G, booleanValue, booleanValue2, z3, D, bool, this.f5851j, !g().e(C(), C0535l.Da) ? this.f5852k : null);
                return aeVar;
            }
        }
        bool = null;
        ae aeVar2 = new ae(C, B, str3, F, str4, n2, j2, str, z2, z, str2, j4, s, G, booleanValue, booleanValue2, z3, D, bool, this.f5851j, !g().e(C(), C0535l.Da) ? this.f5852k : null);
        return aeVar2;
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
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

    /* access modifiers changed from: protected */
    public final boolean z() {
        return true;
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
