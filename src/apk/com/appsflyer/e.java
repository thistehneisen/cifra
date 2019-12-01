package com.appsflyer;

import android.content.Context;
import c.a.a.a.b;
import c.a.a.a.f;
import java.util.HashMap;

final class e implements c.a.a.a.e {

    /* renamed from: ˋ reason: contains not printable characters */
    private d f131;

    /* renamed from: ˎ reason: contains not printable characters */
    private b f132;

    e() {
    }

    public final void onInstallReferrerServiceDisconnected() {
        AFLogger.afDebugLog("Install Referrer service disconnected");
    }

    public final void onInstallReferrerSetupFinished(int i2) {
        String str = "ReferrerClient: InstallReferrer is not ready";
        String str2 = "install";
        String str3 = "clk";
        String str4 = "val";
        String str5 = "err";
        HashMap hashMap = new HashMap();
        hashMap.put("code", String.valueOf(i2));
        f fVar = null;
        if (i2 != 0) {
            String str6 = "InstallReferrer not supported";
            if (i2 == 1) {
                AFLogger.afWarnLog(str6);
            } else if (i2 != 2) {
                AFLogger.afWarnLog("responseCode not found.");
            } else {
                AFLogger.afWarnLog(str6);
            }
        } else {
            try {
                AFLogger.afDebugLog("InstallReferrer connected");
                if (this.f132.c()) {
                    fVar = this.f132.b();
                    this.f132.a();
                } else {
                    AFLogger.afWarnLog(str);
                    hashMap.put(str5, str);
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("Failed to get install referrer: ");
                sb.append(th.getMessage());
                AFLogger.afWarnLog(sb.toString());
                hashMap.put(str5, th.getMessage());
            }
        }
        if (fVar != null) {
            try {
                if (fVar.b() != null) {
                    hashMap.put(str4, fVar.b());
                }
                hashMap.put(str3, Long.toString(fVar.c()));
                hashMap.put(str2, Long.toString(fVar.a()));
            } catch (Exception e2) {
                e2.printStackTrace();
                String str7 = "-1";
                hashMap.put(str4, str7);
                hashMap.put(str3, str7);
                hashMap.put(str2, str7);
            }
        }
        d dVar = this.f131;
        if (dVar != null) {
            dVar.onHandleReferrer(hashMap);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ reason: contains not printable characters */
    public final void m124(Context context, d dVar) {
        this.f131 = dVar;
        try {
            this.f132 = b.a(context).a();
            this.f132.a((c.a.a.a.e) this);
        } catch (Throwable th) {
            AFLogger.afErrorLog("referrerClient -> startConnection", th);
        }
    }
}
