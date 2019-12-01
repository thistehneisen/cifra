package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* renamed from: com.google.android.gms.measurement.internal.tb reason: case insensitive filesystem */
final class C0576tb extends C0528jc {

    /* renamed from: c reason: collision with root package name */
    static final Pair<String, Long> f6100c = new Pair<>("", Long.valueOf(0));
    public C0601yb A = new C0601yb(this, "deep_link_last_retrieved", -1);

    /* renamed from: d reason: collision with root package name */
    private SharedPreferences f6101d;

    /* renamed from: e reason: collision with root package name */
    public C0596xb f6102e;

    /* renamed from: f reason: collision with root package name */
    public final C0601yb f6103f = new C0601yb(this, "last_upload", 0);

    /* renamed from: g reason: collision with root package name */
    public final C0601yb f6104g = new C0601yb(this, "last_upload_attempt", 0);

    /* renamed from: h reason: collision with root package name */
    public final C0601yb f6105h = new C0601yb(this, "backoff", 0);

    /* renamed from: i reason: collision with root package name */
    public final C0601yb f6106i = new C0601yb(this, "last_delete_stale", 0);

    /* renamed from: j reason: collision with root package name */
    public final C0601yb f6107j = new C0601yb(this, "midnight_offset", 0);

    /* renamed from: k reason: collision with root package name */
    public final C0601yb f6108k = new C0601yb(this, "first_open_time", 0);

    /* renamed from: l reason: collision with root package name */
    public final C0601yb f6109l = new C0601yb(this, "app_install_time", 0);
    public final Ab m = new Ab(this, "app_instance_id", null);
    private String n;
    private boolean o;
    private long p;
    public final C0601yb q = new C0601yb(this, "time_before_start", 10000);
    public final C0601yb r = new C0601yb(this, "session_timeout", 1800000);
    public final C0586vb s = new C0586vb(this, "start_new_session", true);
    public final Ab t = new Ab(this, "non_personalized_ads", null);
    public final C0586vb u = new C0586vb(this, "use_dynamite_api", false);
    public final C0586vb v = new C0586vb(this, "allow_remote_dynamite", false);
    public final C0601yb w = new C0601yb(this, "last_pause_time", 0);
    public final C0601yb x = new C0601yb(this, "time_active", 0);
    public boolean y;
    public C0586vb z = new C0586vb(this, "app_backgrounded", false);

    C0576tb(Ob ob) {
        super(ob);
    }

    /* access modifiers changed from: private */
    public final SharedPreferences B() {
        j();
        p();
        return this.f6101d;
    }

    /* access modifiers changed from: 0000 */
    public final boolean A() {
        return this.f6101d.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: 0000 */
    public final Pair<String, Boolean> a(String str) {
        String str2 = "";
        j();
        long a2 = c().a();
        String str3 = this.n;
        if (str3 != null && a2 < this.p) {
            return new Pair<>(str3, Boolean.valueOf(this.o));
        }
        this.p = a2 + g().a(str, C0535l.m);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(a());
            if (advertisingIdInfo != null) {
                this.n = advertisingIdInfo.getId();
                this.o = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.n == null) {
                this.n = str2;
            }
        } catch (Exception e2) {
            e().A().a("Unable to get advertising id", e2);
            this.n = str2;
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.n, Boolean.valueOf(this.o));
    }

    /* access modifiers changed from: 0000 */
    public final String b(String str) {
        j();
        String str2 = (String) a(str).first;
        MessageDigest t2 = Wd.t();
        if (t2 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, t2.digest(str2.getBytes()))});
    }

    /* access modifiers changed from: 0000 */
    public final void c(String str) {
        j();
        Editor edit = B().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    public final void d(String str) {
        j();
        Editor edit = B().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void s() {
        this.f6101d = a().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        String str = "has_been_opened";
        this.y = this.f6101d.getBoolean(str, false);
        if (!this.y) {
            Editor edit = this.f6101d.edit();
            edit.putBoolean(str, true);
            edit.apply();
        }
        C0596xb xbVar = new C0596xb(this, "health_monitor", Math.max(0, ((Long) C0535l.n.a(null)).longValue()));
        this.f6102e = xbVar;
    }

    /* access modifiers changed from: 0000 */
    public final String t() {
        j();
        return B().getString("gmp_app_id", null);
    }

    /* access modifiers changed from: 0000 */
    public final String u() {
        j();
        return B().getString("admob_app_id", null);
    }

    /* access modifiers changed from: 0000 */
    public final Boolean v() {
        j();
        String str = "use_service";
        if (!B().contains(str)) {
            return null;
        }
        return Boolean.valueOf(B().getBoolean(str, false));
    }

    /* access modifiers changed from: 0000 */
    public final void w() {
        j();
        e().B().a("Clearing collection preferences.");
        if (g().a(C0535l.ra)) {
            Boolean x2 = x();
            Editor edit = B().edit();
            edit.clear();
            edit.apply();
            if (x2 != null) {
                a(x2.booleanValue());
            }
            return;
        }
        boolean contains = B().contains("measurement_enabled");
        boolean z2 = true;
        if (contains) {
            z2 = c(true);
        }
        Editor edit2 = B().edit();
        edit2.clear();
        edit2.apply();
        if (contains) {
            a(z2);
        }
    }

    /* access modifiers changed from: 0000 */
    public final Boolean x() {
        j();
        String str = "measurement_enabled";
        if (B().contains(str)) {
            return Boolean.valueOf(B().getBoolean(str, true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final String y() {
        j();
        String str = "previous_os_version";
        String string = B().getString(str, null);
        k().p();
        String str2 = VERSION.RELEASE;
        if (!TextUtils.isEmpty(str2) && !str2.equals(string)) {
            Editor edit = B().edit();
            edit.putString(str, str2);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: 0000 */
    public final boolean z() {
        j();
        return B().getBoolean("deferred_analytics_collection", false);
    }

    /* access modifiers changed from: 0000 */
    public final void b(boolean z2) {
        j();
        e().B().a("Setting useService", Boolean.valueOf(z2));
        Editor edit = B().edit();
        edit.putBoolean("use_service", z2);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    public final boolean c(boolean z2) {
        j();
        return B().getBoolean("measurement_enabled", z2);
    }

    /* access modifiers changed from: 0000 */
    public final void d(boolean z2) {
        j();
        e().B().a("Updating deferred analytics collection", Boolean.valueOf(z2));
        Editor edit = B().edit();
        edit.putBoolean("deferred_analytics_collection", z2);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    public final void a(boolean z2) {
        j();
        e().B().a("Setting measurementEnabled", Boolean.valueOf(z2));
        Editor edit = B().edit();
        edit.putBoolean("measurement_enabled", z2);
        edit.apply();
    }

    /* access modifiers changed from: 0000 */
    public final boolean a(long j2) {
        return j2 - this.r.a() > this.w.a();
    }
}
