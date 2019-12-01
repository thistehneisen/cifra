package com.appsflyer;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import com.appsflyer.share.Constants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.util.Map;

final class n {

    static class e extends IllegalStateException {
        e(String str) {
            super(str);
        }
    }

    n() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r8.length() == 0) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008c A[SYNTHETIC, Splitter:B:34:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: ˎ reason: contains not printable characters */
    static void m168(Context context, Map<String, Object> map) {
        int i2;
        boolean z;
        String str;
        String str2 = "advertiserIdEnabled";
        String str3 = ServerParameters.ADVERTISING_ID_PARAM;
        AFLogger.afInfoLog("Trying to fetch GAID..");
        StringBuilder sb = new StringBuilder();
        try {
            i2 = com.google.android.gms.common.e.a().b(context);
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            i2 = -1;
        }
        String str4 = null;
        boolean z2 = false;
        try {
            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                str = advertisingIdInfo.getId();
                try {
                    str4 = Boolean.toString(!advertisingIdInfo.isLimitAdTrackingEnabled());
                    if (str != null) {
                        try {
                        } catch (Throwable th2) {
                            th = th2;
                            z = true;
                            AFLogger.afErrorLog(th.getMessage(), th);
                            sb.append(th.getClass().getSimpleName());
                            String str5 = " |";
                            sb.append(str5);
                            AFLogger.afInfoLog("WARNING: Google Play Services is missing.");
                            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.ENABLE_GPS_FALLBACK, true)) {
                                try {
                                    b r5 = f.m125(context);
                                    str = r5.m126();
                                    if (!r5.m127()) {
                                        z2 = true;
                                    }
                                    str4 = Boolean.toString(z2);
                                    if (str == null || str.length() == 0) {
                                        sb.append("emptyOrNull (bypass) |");
                                    }
                                } catch (Throwable th3) {
                                    AFLogger.afErrorLog(th3.getMessage(), th3);
                                    sb.append(th3.getClass().getSimpleName());
                                    sb.append(str5);
                                    str = AppsFlyerProperties.getInstance().getString(str3);
                                    String string = AppsFlyerProperties.getInstance().getString(str2);
                                    if (th3.getLocalizedMessage() != null) {
                                        AFLogger.afInfoLog(th3.getLocalizedMessage());
                                    } else {
                                        AFLogger.afInfoLog(th3.toString());
                                    }
                                    str4 = string;
                                }
                            }
                            if (context.getClass().getName().equals("android.app.ReceiverRestrictedContext")) {
                            }
                            if (sb.length() > 0) {
                            }
                            if (str != null) {
                                return;
                            }
                            return;
                        }
                    }
                    sb.append("emptyOrNull |");
                    z = true;
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                    AFLogger.afErrorLog(th.getMessage(), th);
                    sb.append(th.getClass().getSimpleName());
                    String str52 = " |";
                    sb.append(str52);
                    AFLogger.afInfoLog("WARNING: Google Play Services is missing.");
                    if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.ENABLE_GPS_FALLBACK, true)) {
                    }
                    if (context.getClass().getName().equals("android.app.ReceiverRestrictedContext")) {
                    }
                    if (sb.length() > 0) {
                    }
                    if (str != null) {
                    }
                }
                if (context.getClass().getName().equals("android.app.ReceiverRestrictedContext")) {
                    str = AppsFlyerProperties.getInstance().getString(str3);
                    str4 = AppsFlyerProperties.getInstance().getString(str2);
                    sb.append("context = android.app.ReceiverRestrictedContext |");
                }
                if (sb.length() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i2);
                    sb2.append(": ");
                    sb2.append(sb);
                    map.put("gaidError", sb2.toString());
                }
                if (str != null && str4 != null) {
                    map.put(str3, str);
                    map.put(str2, str4);
                    AppsFlyerProperties.getInstance().set(str3, str);
                    AppsFlyerProperties.getInstance().set(str2, str4);
                    map.put("isGaidWithGps", String.valueOf(z));
                    return;
                }
                return;
            }
            sb.append("gpsAdInfo-null |");
            throw new e("GpsAdIndo is null");
        } catch (Throwable th5) {
            th = th5;
            str = null;
            z = false;
            AFLogger.afErrorLog(th.getMessage(), th);
            sb.append(th.getClass().getSimpleName());
            String str522 = " |";
            sb.append(str522);
            AFLogger.afInfoLog("WARNING: Google Play Services is missing.");
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.ENABLE_GPS_FALLBACK, true)) {
            }
            if (context.getClass().getName().equals("android.app.ReceiverRestrictedContext")) {
            }
            if (sb.length() > 0) {
            }
            if (str != null) {
            }
        }
    }

    /* renamed from: ॱ reason: contains not printable characters */
    static l m169(ContentResolver contentResolver) {
        String str;
        l lVar = null;
        if (contentResolver == null) {
            return null;
        }
        if (AppsFlyerProperties.getInstance().getString("amazon_aid") == null) {
            if ("Amazon".equals(Build.MANUFACTURER)) {
                int i2 = Secure.getInt(contentResolver, "limit_ad_tracking", 2);
                String str2 = Constants.URL_ADVERTISING_ID;
                if (i2 == 0) {
                    lVar = new l(e.AMAZON, Secure.getString(contentResolver, str2), false);
                } else if (i2 != 2) {
                    try {
                        str = Secure.getString(contentResolver, str2);
                    } catch (Throwable th) {
                        AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
                        str = "";
                    }
                    lVar = new l(e.AMAZON, str, true);
                }
            }
        }
        return lVar;
    }
}
