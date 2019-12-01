package io.intercom.android.sdk.commons.utilities;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class DeviceUtils {
    public static String getAppName(Context context) {
        String packageName = context.getPackageName();
        return packageName == null ? "" : packageName;
    }

    public static String getAppVersion(Context context) {
        String str = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName != null ? packageInfo.versionName : str;
        } catch (NameNotFoundException | RuntimeException unused) {
            return str;
        }
    }

    public static boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }
}
