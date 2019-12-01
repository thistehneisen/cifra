package com.appsflyer;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

final class b {

    static final class a {

        /* renamed from: ॱ reason: contains not printable characters */
        static final b f121 = new b();
    }

    b() {
    }

    /* renamed from: ˏ reason: contains not printable characters */
    private static boolean m118(Context context, String[] strArr) {
        for (String r3 : strArr) {
            if (AnonymousClass5.m5(context, r3)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r8 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        if (60000 >= (r3.getTime() - r8.getTime())) goto L_0x0051;
     */
    /* renamed from: ॱ reason: contains not printable characters */
    static Location m119(Context context) {
        String str = "android.permission.ACCESS_FINE_LOCATION";
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Location lastKnownLocation = m118(context, new String[]{str, "android.permission.ACCESS_COARSE_LOCATION"}) ? locationManager.getLastKnownLocation("network") : null;
            Location lastKnownLocation2 = m118(context, new String[]{str}) ? locationManager.getLastKnownLocation("gps") : null;
            if (lastKnownLocation2 == null && lastKnownLocation == null) {
                lastKnownLocation2 = null;
            } else {
                if (lastKnownLocation2 != null || lastKnownLocation == null) {
                    if (lastKnownLocation == null) {
                    }
                }
                lastKnownLocation2 = lastKnownLocation;
            }
            if (lastKnownLocation2 != null) {
                return lastKnownLocation2;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
