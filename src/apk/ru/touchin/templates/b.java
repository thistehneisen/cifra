package ru.touchin.templates;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import io.intercom.android.sdk.views.holder.AttributeType;

/* compiled from: DeviceUtils */
public final class b {

    /* compiled from: DeviceUtils */
    public enum a {
        MOBILE_2G("2g"),
        MOBILE_3G("3g"),
        MOBILE_LTE("lte"),
        WI_FI("Wi-Fi"),
        UNKNOWN(AttributeType.UNKNOWN),
        NONE("none");
        
        private final String name;

        private a(String str) {
            this.name = str;
        }
    }

    public static a a(Context context) {
        if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            return a.UNKNOWN;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return a.UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return a.NONE;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            return a(activeNetworkInfo);
        }
        if (type != 1) {
            return a.UNKNOWN;
        }
        return a.WI_FI;
    }

    public static boolean b(Context context) {
        return a(context) != a.NONE;
    }

    private static a a(NetworkInfo networkInfo) {
        int subtype = networkInfo.getSubtype();
        if (subtype != 19) {
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return a.MOBILE_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return a.MOBILE_3G;
                case 13:
                    break;
                default:
                    return a.UNKNOWN;
            }
        }
        return a.MOBILE_LTE;
    }
}
