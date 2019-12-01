package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.b.c;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.l;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public final class fe extends C0533kc {

    /* renamed from: b reason: collision with root package name */
    private Boolean f5917b;

    /* renamed from: c reason: collision with root package name */
    private he f5918c = ie.f5952a;

    /* renamed from: d reason: collision with root package name */
    private Boolean f5919d;

    fe(Ob ob) {
        super(ob);
        C0535l.a(ob);
    }

    static String o() {
        return (String) C0535l.f6014l.a(null);
    }

    public static long t() {
        return ((Long) C0535l.O.a(null)).longValue();
    }

    public static long u() {
        return ((Long) C0535l.o.a(null)).longValue();
    }

    public static boolean w() {
        return ((Boolean) C0535l.f6013k.a(null)).booleanValue();
    }

    static boolean y() {
        return ((Boolean) C0535l.ea.a(null)).booleanValue();
    }

    private final Bundle z() {
        try {
            if (a().getPackageManager() == null) {
                e().t().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo a2 = c.a(a()).a(a().getPackageName(), 128);
            if (a2 != null) {
                return a2.metaData;
            }
            e().t().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (NameNotFoundException e2) {
            e().t().a("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(he heVar) {
        this.f5918c = heVar;
    }

    public final int b(String str, Za<Integer> za) {
        if (str == null) {
            return ((Integer) za.a(null)).intValue();
        }
        String a2 = this.f5918c.a(str, za.a());
        if (TextUtils.isEmpty(a2)) {
            return ((Integer) za.a(null)).intValue();
        }
        try {
            return ((Integer) za.a(Integer.valueOf(Integer.parseInt(a2)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) za.a(null)).intValue();
        }
    }

    public final double c(String str, Za<Double> za) {
        if (str == null) {
            return ((Double) za.a(null)).doubleValue();
        }
        String a2 = this.f5918c.a(str, za.a());
        if (TextUtils.isEmpty(a2)) {
            return ((Double) za.a(null)).doubleValue();
        }
        try {
            return ((Double) za.a(Double.valueOf(Double.parseDouble(a2)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) za.a(null)).doubleValue();
        }
    }

    public final boolean d(String str, Za<Boolean> za) {
        if (str == null) {
            return ((Boolean) za.a(null)).booleanValue();
        }
        String a2 = this.f5918c.a(str, za.a());
        if (TextUtils.isEmpty(a2)) {
            return ((Boolean) za.a(null)).booleanValue();
        }
        return ((Boolean) za.a(Boolean.valueOf(Boolean.parseBoolean(a2)))).booleanValue();
    }

    public final boolean e(String str, Za<Boolean> za) {
        return d(str, za);
    }

    /* access modifiers changed from: 0000 */
    public final boolean f(String str) {
        return d(str, C0535l.Y);
    }

    /* access modifiers changed from: 0000 */
    public final boolean g(String str) {
        return d(str, C0535l.S);
    }

    /* access modifiers changed from: 0000 */
    public final String h(String str) {
        Za<String> za = C0535l.T;
        if (str == null) {
            return (String) za.a(null);
        }
        return (String) za.a(this.f5918c.a(str, za.a()));
    }

    /* access modifiers changed from: 0000 */
    public final boolean i(String str) {
        return d(str, C0535l.Z);
    }

    /* access modifiers changed from: 0000 */
    public final boolean j(String str) {
        return d(str, C0535l.aa);
    }

    /* access modifiers changed from: 0000 */
    public final boolean k(String str) {
        return d(str, C0535l.ba);
    }

    /* access modifiers changed from: 0000 */
    public final boolean l(String str) {
        return d(str, C0535l.da);
    }

    /* access modifiers changed from: 0000 */
    public final boolean m(String str) {
        return d(str, C0535l.ca);
    }

    public final long n() {
        b();
        return 16250;
    }

    public final boolean p() {
        if (this.f5919d == null) {
            synchronized (this) {
                if (this.f5919d == null) {
                    ApplicationInfo applicationInfo = a().getApplicationInfo();
                    String a2 = l.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f5919d = Boolean.valueOf(str != null && str.equals(a2));
                    }
                    if (this.f5919d == null) {
                        this.f5919d = Boolean.TRUE;
                        e().t().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f5919d.booleanValue();
    }

    public final boolean q() {
        b();
        Boolean b2 = b("firebase_analytics_collection_deactivated");
        return b2 != null && b2.booleanValue();
    }

    public final Boolean r() {
        b();
        return b("firebase_analytics_collection_enabled");
    }

    public final Boolean s() {
        h();
        Boolean b2 = b("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(b2 == null || b2.booleanValue());
    }

    public final String v() {
        String str = "";
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"debug.firebase.analytics.app", str});
        } catch (ClassNotFoundException e2) {
            e().t().a("Could not find SystemProperties class", e2);
            return str;
        } catch (NoSuchMethodException e3) {
            e().t().a("Could not find SystemProperties.get() method", e3);
            return str;
        } catch (IllegalAccessException e4) {
            e().t().a("Could not access SystemProperties.get()", e4);
            return str;
        } catch (InvocationTargetException e5) {
            e().t().a("SystemProperties.get() threw an exception", e5);
            return str;
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean x() {
        if (this.f5917b == null) {
            this.f5917b = b("app_measurement_lite");
            if (this.f5917b == null) {
                this.f5917b = Boolean.valueOf(false);
            }
        }
        if (this.f5917b.booleanValue() || !this.f5987a.q()) {
            return true;
        }
        return false;
    }

    public final int a(String str) {
        return b(str, C0535l.z);
    }

    public final boolean e(String str) {
        return "1".equals(this.f5918c.a(str, "measurement.event_sampling_enabled"));
    }

    public final /* bridge */ /* synthetic */ C0576tb f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ fe g() {
        return super.g();
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

    /* access modifiers changed from: 0000 */
    public final boolean n(String str) {
        return d(str, C0535l.fa);
    }

    public final long a(String str, Za<Long> za) {
        if (str == null) {
            return ((Long) za.a(null)).longValue();
        }
        String a2 = this.f5918c.a(str, za.a());
        if (TextUtils.isEmpty(a2)) {
            return ((Long) za.a(null)).longValue();
        }
        try {
            return ((Long) za.a(Long.valueOf(Long.parseLong(a2)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) za.a(null)).longValue();
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean r(String str) {
        return d(str, C0535l.na);
    }

    public final /* bridge */ /* synthetic */ C0532kb e() {
        return super.e();
    }

    /* access modifiers changed from: 0000 */
    public final boolean o(String str) {
        return d(str, C0535l.ga);
    }

    /* access modifiers changed from: 0000 */
    public final boolean q(String str) {
        return d(str, C0535l.ia);
    }

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final boolean d(String str) {
        return "1".equals(this.f5918c.a(str, "gaia_collection_enabled"));
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
    }

    /* access modifiers changed from: 0000 */
    public final Boolean b(String str) {
        q.b(str);
        Bundle z = z();
        if (z == null) {
            e().t().a("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!z.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(z.getBoolean(str));
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b A[SYNTHETIC, Splitter:B:9:0x002b] */
    public final List<String> c(String str) {
        Integer num;
        q.b(str);
        Bundle z = z();
        if (z == null) {
            e().t().a("Failed to load metadata: Metadata bundle is null");
        } else if (z.containsKey(str)) {
            num = Integer.valueOf(z.getInt(str));
            if (num != null) {
                return null;
            }
            try {
                String[] stringArray = a().getResources().getStringArray(num.intValue());
                if (stringArray == null) {
                    return null;
                }
                return Arrays.asList(stringArray);
            } catch (NotFoundException e2) {
                e().t().a("Failed to load string array from metadata: resource not found", e2);
                return null;
            }
        }
        num = null;
        if (num != null) {
        }
    }

    public final boolean a(Za<Boolean> za) {
        return d(null, za);
    }

    /* access modifiers changed from: 0000 */
    public final boolean p(String str) {
        return d(str, C0535l.ha);
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }
}
