package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SingleInstallBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2 = "referrer";
        if (intent != null) {
            try {
                str = intent.getStringExtra(str2);
            } catch (Throwable th) {
                AFLogger.afErrorLog("error in BroadcastReceiver ", th);
                str = null;
            }
            if (str != null) {
                if (str.contains("AppsFlyer_Test") && intent.getStringExtra("TestIntegrationMode") != null) {
                    AppsFlyerLib.getInstance().m79(context, intent);
                    return;
                } else if (AppsFlyerLib.m44(context).getString(str2, null) != null) {
                    AppsFlyerLib.getInstance();
                    AppsFlyerLib.m66(context, str);
                    return;
                }
            }
            String str3 = "referrer_timestamp";
            String string = AppsFlyerProperties.getInstance().getString(str3);
            long currentTimeMillis = System.currentTimeMillis();
            if (string == null || currentTimeMillis - Long.valueOf(string).longValue() >= 2000) {
                AFLogger.afInfoLog("SingleInstallBroadcastReceiver called");
                AppsFlyerLib.getInstance().m79(context, intent);
                AppsFlyerProperties.getInstance().set(str3, String.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
