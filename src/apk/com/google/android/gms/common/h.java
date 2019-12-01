package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.b.c;
import com.google.android.gms.common.internal.q;

public class h {

    /* renamed from: a reason: collision with root package name */
    private static h f4662a;

    /* renamed from: b reason: collision with root package name */
    private final Context f4663b;

    private h(Context context) {
        this.f4663b = context.getApplicationContext();
    }

    public static h a(Context context) {
        q.a(context);
        synchronized (h.class) {
            if (f4662a == null) {
                m.a(context);
                f4662a = new h(context);
            }
        }
        return f4662a;
    }

    public boolean a(int i2) {
        w wVar;
        String[] a2 = c.a(this.f4663b).a(i2);
        if (a2 != null && a2.length != 0) {
            wVar = null;
            for (String a3 : a2) {
                wVar = a(a3, i2);
                if (wVar.f4814b) {
                    break;
                }
            }
        } else {
            wVar = w.a("no pkgs");
        }
        wVar.c();
        return wVar.f4814b;
    }

    public static boolean a(PackageInfo packageInfo, boolean z) {
        o oVar;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                oVar = a(packageInfo, r.f4788a);
            } else {
                oVar = a(packageInfo, r.f4788a[0]);
            }
            if (oVar != null) {
                return true;
            }
        }
        return false;
    }

    public boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (a(packageInfo, false)) {
            return true;
        }
        if (a(packageInfo, true)) {
            if (g.honorsDebugCertificates(this.f4663b)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    private final w a(String str, int i2) {
        try {
            PackageInfo a2 = c.a(this.f4663b).a(str, 64, i2);
            boolean honorsDebugCertificates = g.honorsDebugCertificates(this.f4663b);
            if (a2 == null) {
                return w.a("null pkg");
            }
            if (a2.signatures.length != 1) {
                return w.a("single cert required");
            }
            p pVar = new p(a2.signatures[0].toByteArray());
            String str2 = a2.packageName;
            w a3 = m.a(str2, pVar, honorsDebugCertificates, false);
            return (!a3.f4814b || a2.applicationInfo == null || (a2.applicationInfo.flags & 2) == 0 || !m.a(str2, pVar, false, true).f4814b) ? a3 : w.a("debuggable release cert app rejected");
        } catch (NameNotFoundException unused) {
            String str3 = "no pkg ";
            String valueOf = String.valueOf(str);
            return w.a(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
    }

    private static o a(PackageInfo packageInfo, o... oVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        p pVar = new p(signatureArr[0].toByteArray());
        for (int i2 = 0; i2 < oVarArr.length; i2++) {
            if (oVarArr[i2].equals(pVar)) {
                return oVarArr[i2];
            }
        }
        return null;
    }
}
