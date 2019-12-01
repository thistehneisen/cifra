package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import com.google.android.gms.common.internal.L;
import com.google.android.gms.common.internal.M;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import java.util.concurrent.Callable;

final class m {

    /* renamed from: a reason: collision with root package name */
    private static volatile L f4778a;

    /* renamed from: b reason: collision with root package name */
    private static final Object f4779b = new Object();

    /* renamed from: c reason: collision with root package name */
    private static Context f4780c;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return;
     */
    static synchronized void a(Context context) {
        synchronized (m.class) {
            if (f4780c != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f4780c = context.getApplicationContext();
            }
        }
    }

    private static w b(String str, o oVar, boolean z, boolean z2) {
        try {
            if (f4778a == null) {
                q.a(f4780c);
                synchronized (f4779b) {
                    if (f4778a == null) {
                        f4778a = M.a(DynamiteModule.a(f4780c, DynamiteModule.f4829k, "com.google.android.gms.googlecertificates").a("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            q.a(f4780c);
            try {
                if (f4778a.a(new u(str, oVar, z, z2), b.a(f4780c.getPackageManager()))) {
                    return w.b();
                }
                return w.a((Callable<String>) new n<String>(z, str, oVar));
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return w.a("module call", e2);
            }
        } catch (LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            String str2 = "module init: ";
            String valueOf = String.valueOf(e3.getMessage());
            return w.a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e3);
        }
    }

    static w a(String str, o oVar, boolean z, boolean z2) {
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return b(str, oVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static final /* synthetic */ String a(boolean z, String str, o oVar) throws Exception {
        boolean z2 = true;
        if (z || !b(str, oVar, true, false).f4814b) {
            z2 = false;
        }
        return w.a(str, oVar, z, z2);
    }
}
