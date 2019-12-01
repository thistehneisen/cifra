package io.fabric.sdk.android.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import io.fabric.sdk.android.f;

/* compiled from: DataCollectionArbiter */
public class o {

    /* renamed from: a reason: collision with root package name */
    private static o f8836a;

    /* renamed from: b reason: collision with root package name */
    private static Object f8837b = new Object();

    /* renamed from: c reason: collision with root package name */
    private final SharedPreferences f8838c;

    /* renamed from: d reason: collision with root package name */
    private volatile boolean f8839d;

    /* renamed from: e reason: collision with root package name */
    private volatile boolean f8840e;

    /* renamed from: f reason: collision with root package name */
    private final v f8841f;

    /* renamed from: g reason: collision with root package name */
    private boolean f8842g = false;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    private o(Context context) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (context != null) {
            this.f8838c = context.getSharedPreferences("com.google.firebase.crashlytics.prefs", 0);
            this.f8841f = w.a(context);
            String str = "firebase_crashlytics_collection_enabled";
            if (this.f8838c.contains(str)) {
                z2 = this.f8838c.getBoolean(str, true);
            } else {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null) {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                        if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(str))) {
                            z2 = applicationInfo.metaData.getBoolean(str);
                        }
                    }
                } catch (NameNotFoundException e2) {
                    f.e().c("Fabric", "Unable to get PackageManager. Falling through", e2);
                }
                z2 = true;
                z = false;
                this.f8840e = z2;
                this.f8839d = z;
                if (l.o(context) != null) {
                    z3 = true;
                }
                this.f8842g = z3;
                return;
            }
            z = true;
            this.f8840e = z2;
            this.f8839d = z;
            if (l.o(context) != null) {
            }
            this.f8842g = z3;
            return;
        }
        throw new RuntimeException("null context");
    }

    public static o a(Context context) {
        o oVar;
        synchronized (f8837b) {
            if (f8836a == null) {
                f8836a = new o(context);
            }
            oVar = f8836a;
        }
        return oVar;
    }

    public boolean b() {
        return this.f8840e;
    }

    public boolean a() {
        if (this.f8842g && this.f8839d) {
            return this.f8840e;
        }
        v vVar = this.f8841f;
        if (vVar != null) {
            return vVar.a();
        }
        return true;
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void a(boolean z) {
        this.f8840e = z;
        this.f8839d = true;
        this.f8838c.edit().putBoolean("firebase_crashlytics_collection_enabled", z).commit();
    }
}
