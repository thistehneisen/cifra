package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.gms.common.a.a;
import com.google.android.gms.common.b.b;
import com.google.android.gms.common.b.c;
import com.google.android.gms.internal.measurement.Gb;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.zb reason: case insensitive filesystem */
public final class C0606zb {

    /* renamed from: a reason: collision with root package name */
    final Ob f6177a;

    C0606zb(Ob ob) {
        this.f6177a = ob;
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        if (str == null || str.isEmpty()) {
            this.f6177a.e().z().a("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.f6177a.d().j();
        if (!a()) {
            this.f6177a.e().z().a("Install Referrer Reporter is not available");
            return;
        }
        this.f6177a.e().z().a("Install Referrer Reporter is initializing");
        Cb cb = new Cb(this, str);
        this.f6177a.d().j();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        String str2 = "com.android.vending";
        intent.setComponent(new ComponentName(str2, "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.f6177a.a().getPackageManager();
        if (packageManager == null) {
            this.f6177a.e().w().a("Failed to obtain Package Manager to verify binding conditions");
            return;
        }
        List queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.f6177a.e().z().a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (serviceInfo != null) {
            String str3 = serviceInfo.packageName;
            if (resolveInfo.serviceInfo.name == null || !str2.equals(str3) || !a()) {
                this.f6177a.e().z().a("Play Store missing or incompatible. Version 8.3.73 or later required");
            } else {
                try {
                    this.f6177a.e().z().a("Install Referrer Service is", a.a().a(this.f6177a.a(), new Intent(intent), cb, 1) ? "available" : "not available");
                } catch (Exception e2) {
                    this.f6177a.e().t().a("Exception occurred while binding to Install Referrer Service", e2.getMessage());
                }
            }
        }
    }

    private final boolean a() {
        boolean z = false;
        try {
            b a2 = c.a(this.f6177a.a());
            if (a2 == null) {
                this.f6177a.e().z().a("Failed to retrieve Package Manager to check Play Store compatibility");
                return false;
            }
            if (a2.b("com.android.vending", 128).versionCode >= 80837300) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            this.f6177a.e().z().a("Failed to retrieve Play Store version", e2);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final Bundle a(String str, Gb gb) {
        this.f6177a.d().j();
        if (gb == null) {
            this.f6177a.e().w().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle d2 = gb.d(bundle);
            if (d2 != null) {
                return d2;
            }
            this.f6177a.e().t().a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e2) {
            this.f6177a.e().t().a("Exception occurred while retrieving the Install Referrer", e2.getMessage());
            return null;
        }
    }
}
