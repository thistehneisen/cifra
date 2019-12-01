package com.appsflyer;

import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;

public class GcmInstanceIdListener extends InstanceIDListenerService {
    /* JADX WARNING: type inference failed for: r6v0, types: [android.content.Context, com.appsflyer.GcmInstanceIdListener, com.google.android.gms.iid.InstanceIDListenerService] */
    public void onTokenRefresh() {
        GcmInstanceIdListener.super.onTokenRefresh();
        String string = AppsFlyerProperties.getInstance().getString("gcmProjectNumber");
        long currentTimeMillis = System.currentTimeMillis();
        String str = null;
        try {
            str = InstanceID.getInstance(getApplicationContext()).getToken(string, "GCM", null);
        } catch (Throwable th) {
            AFLogger.afErrorLog("Error registering for uninstall tracking", th);
        }
        if (str != null) {
            AFLogger.afInfoLog("GCM Refreshed Token = ".concat(String.valueOf(str)));
            b r0 = b.m114(AppsFlyerProperties.getInstance().getString("afUninstallToken"));
            b bVar = new b(currentTimeMillis, str);
            if (r0.m117(bVar)) {
                y.m228(getApplicationContext(), bVar);
            }
        }
    }
}
