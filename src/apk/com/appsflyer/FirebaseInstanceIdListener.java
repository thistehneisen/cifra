package com.appsflyer;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseInstanceIdListener extends FirebaseInstanceIdService {
    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, com.google.firebase.iid.FirebaseInstanceIdService, com.appsflyer.FirebaseInstanceIdListener] */
    public void onTokenRefresh() {
        String str;
        FirebaseInstanceIdListener.super.onTokenRefresh();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str = FirebaseInstanceId.b().d();
        } catch (Throwable th) {
            AFLogger.afErrorLog("Error registering for uninstall tracking", th);
            str = null;
        }
        if (str != null) {
            AFLogger.afInfoLog("Firebase Refreshed Token = ".concat(String.valueOf(str)));
            b r3 = b.m114(AppsFlyerProperties.getInstance().getString("afUninstallToken"));
            b bVar = new b(currentTimeMillis, str);
            if (r3.m117(bVar)) {
                y.m228(getApplicationContext(), bVar);
            }
        }
    }
}
