package com.google.android.gms.common.b;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.k;

public class b {

    /* renamed from: a reason: collision with root package name */
    private final Context f4646a;

    public b(Context context) {
        this.f4646a = context;
    }

    public ApplicationInfo a(String str, int i2) throws NameNotFoundException {
        return this.f4646a.getPackageManager().getApplicationInfo(str, i2);
    }

    public PackageInfo b(String str, int i2) throws NameNotFoundException {
        return this.f4646a.getPackageManager().getPackageInfo(str, i2);
    }

    public final PackageInfo a(String str, int i2, int i3) throws NameNotFoundException {
        return this.f4646a.getPackageManager().getPackageInfo(str, 64);
    }

    public CharSequence b(String str) throws NameNotFoundException {
        return this.f4646a.getPackageManager().getApplicationLabel(this.f4646a.getPackageManager().getApplicationInfo(str, 0));
    }

    public final String[] a(int i2) {
        return this.f4646a.getPackageManager().getPackagesForUid(i2);
    }

    @TargetApi(19)
    public final boolean a(int i2, String str) {
        if (k.e()) {
            try {
                ((AppOpsManager) this.f4646a.getSystemService("appops")).checkPackage(i2, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            String[] packagesForUid = this.f4646a.getPackageManager().getPackagesForUid(i2);
            if (!(str == null || packagesForUid == null)) {
                for (String equals : packagesForUid) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public int a(String str) {
        return this.f4646a.checkCallingOrSelfPermission(str);
    }

    public boolean a() {
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.f4646a);
        }
        if (k.i()) {
            String nameForUid = this.f4646a.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (nameForUid != null) {
                return this.f4646a.getPackageManager().isInstantApp(nameForUid);
            }
        }
        return false;
    }
}
