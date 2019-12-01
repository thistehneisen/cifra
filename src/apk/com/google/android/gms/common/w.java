package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.i;
import java.util.concurrent.Callable;

class w {

    /* renamed from: a reason: collision with root package name */
    private static final w f4813a = new w(true, null, null);

    /* renamed from: b reason: collision with root package name */
    final boolean f4814b;

    /* renamed from: c reason: collision with root package name */
    private final String f4815c;

    /* renamed from: d reason: collision with root package name */
    private final Throwable f4816d;

    w(boolean z, String str, Throwable th) {
        this.f4814b = z;
        this.f4815c = str;
        this.f4816d = th;
    }

    static w a(Callable<String> callable) {
        return new y(callable);
    }

    static w b() {
        return f4813a;
    }

    /* access modifiers changed from: 0000 */
    public final void c() {
        if (!this.f4814b) {
            String str = "GoogleCertificatesRslt";
            if (Log.isLoggable(str, 3)) {
                if (this.f4816d != null) {
                    Log.d(str, a(), this.f4816d);
                    return;
                }
                Log.d(str, a());
            }
        }
    }

    static w a(String str) {
        return new w(false, str, null);
    }

    static w a(String str, Throwable th) {
        return new w(false, str, th);
    }

    /* access modifiers changed from: 0000 */
    public String a() {
        return this.f4815c;
    }

    static String a(String str, o oVar, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", new Object[]{z2 ? "debug cert rejected" : "not whitelisted", str, i.a(a.a("SHA-1").digest(oVar.h())), Boolean.valueOf(z), "12451009.false"});
    }
}
