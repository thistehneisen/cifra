package com.appsflyer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import io.intercom.android.sdk.views.holder.AttributeType;

final class h {

    static final class a {

        /* renamed from: ˊ reason: contains not printable characters */
        private static String f146;

        /* renamed from: ˏ reason: contains not printable characters */
        private static String f147;

        /* renamed from: ˋ reason: contains not printable characters */
        private final String f148;

        /* renamed from: ˎ reason: contains not printable characters */
        private final String f149;

        /* renamed from: ॱ reason: contains not printable characters */
        private final String f150;

        a(String str, String str2, String str3) {
            this.f149 = str;
            this.f150 = str2;
            this.f148 = str3;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ˋ reason: contains not printable characters */
        public final String m143() {
            return this.f149;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ˏ reason: contains not printable characters */
        public final String m144() {
            return this.f148;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ॱ reason: contains not printable characters */
        public final String m145() {
            return this.f150;
        }

        /* renamed from: ˋ reason: contains not printable characters */
        static void m141(String str) {
            if (f147 == null) {
                m142(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
            }
            String str2 = f147;
            if (str2 != null && str.contains(str2)) {
                AFLogger.afInfoLog(str.replace(f147, f146));
            }
        }

        /* renamed from: ˏ reason: contains not printable characters */
        static void m142(String str) {
            f147 = str;
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (i2 == 0 || i2 == str.length() - 1) {
                    sb.append(str.charAt(i2));
                } else {
                    sb.append("*");
                }
            }
            f146 = sb.toString();
        }

        a() {
        }
    }

    static final class d {

        /* renamed from: ˏ reason: contains not printable characters */
        static final h f151 = new h();
    }

    h() {
    }

    /* renamed from: ˊ reason: contains not printable characters */
    static a m140(Context context) {
        String str;
        String str2 = AttributeType.UNKNOWN;
        String str3 = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            String str4 = "MOBILE";
            String str5 = "WIFI";
            if (connectivityManager != null) {
                boolean z = false;
                if (21 <= VERSION.SDK_INT) {
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    int length = allNetworks.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i2]);
                        if (!(networkInfo != null && networkInfo.isConnectedOrConnecting())) {
                            i2++;
                        } else if (1 != networkInfo.getType()) {
                            if (networkInfo.getType() == 0) {
                            }
                        }
                    }
                } else {
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                    if (!(networkInfo2 != null && networkInfo2.isConnectedOrConnecting())) {
                        NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
                        if (!(networkInfo3 != null && networkInfo3.isConnectedOrConnecting())) {
                            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                                z = true;
                            }
                            if (z) {
                                if (1 != activeNetworkInfo.getType()) {
                                    if (activeNetworkInfo.getType() == 0) {
                                    }
                                }
                            }
                        }
                        str2 = str4;
                    }
                }
                str2 = str5;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AttributeType.PHONE);
            str = telephonyManager.getSimOperatorName();
            try {
                str3 = telephonyManager.getNetworkOperatorName();
                if ((str3 == null || str3.isEmpty()) && 2 == telephonyManager.getPhoneType()) {
                    str3 = "CDMA";
                }
            } catch (Throwable th) {
                th = th;
                AFLogger.afErrorLog("Exception while collecting network info. ", th);
                return new a(str2, str3, str);
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
            AFLogger.afErrorLog("Exception while collecting network info. ", th);
            return new a(str2, str3, str);
        }
        return new a(str2, str3, str);
    }
}
