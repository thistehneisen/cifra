package com.appsflyer;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class s {

    /* renamed from: ˊ reason: contains not printable characters */
    private static s f216;

    /* renamed from: ʻ reason: contains not printable characters */
    private final String f217;

    /* renamed from: ʻॱ reason: contains not printable characters */
    private final String f218;

    /* renamed from: ʼ reason: contains not printable characters */
    private final String f219;

    /* renamed from: ʼॱ reason: contains not printable characters */
    private final String f220;

    /* renamed from: ʽ reason: contains not printable characters */
    private final String f221;

    /* renamed from: ʽॱ reason: contains not printable characters */
    private final String f222;

    /* renamed from: ʾ reason: contains not printable characters */
    private final String f223;

    /* renamed from: ʿ reason: contains not printable characters */
    private final String f224;

    /* renamed from: ˈ reason: contains not printable characters */
    private final String f225;

    /* renamed from: ˉ reason: contains not printable characters */
    private JSONArray f226;

    /* renamed from: ˊˊ reason: contains not printable characters */
    private int f227;

    /* renamed from: ˊˋ reason: contains not printable characters */
    private JSONObject f228;

    /* renamed from: ˊॱ reason: contains not printable characters */
    private final String f229;

    /* renamed from: ˊᐝ reason: contains not printable characters */
    private final String f230;

    /* renamed from: ˋ reason: contains not printable characters */
    private final String f231;

    /* renamed from: ˋˊ reason: contains not printable characters */
    private final String f232;

    /* renamed from: ˋॱ reason: contains not printable characters */
    private final String f233;

    /* renamed from: ˍ reason: contains not printable characters */
    private String f234;

    /* renamed from: ˎ reason: contains not printable characters */
    private boolean f235;

    /* renamed from: ˎˎ reason: contains not printable characters */
    private boolean f236;

    /* renamed from: ˏ reason: contains not printable characters */
    private boolean f237;

    /* renamed from: ˏॱ reason: contains not printable characters */
    private final String f238;

    /* renamed from: ͺ reason: contains not printable characters */
    private final String f239;

    /* renamed from: ॱ reason: contains not printable characters */
    private final String f240;

    /* renamed from: ॱˊ reason: contains not printable characters */
    private final String f241;

    /* renamed from: ॱˋ reason: contains not printable characters */
    private final String f242;

    /* renamed from: ॱˎ reason: contains not printable characters */
    private final String f243;

    /* renamed from: ॱॱ reason: contains not printable characters */
    private final String f244;

    /* renamed from: ॱᐝ reason: contains not printable characters */
    private final String f245;

    /* renamed from: ᐝ reason: contains not printable characters */
    private final String f246;

    /* renamed from: ᐝॱ reason: contains not printable characters */
    private final String f247;

    private s() {
        this.f235 = true;
        this.f237 = true;
        this.f240 = "brand";
        this.f231 = "model";
        this.f217 = "platform";
        this.f244 = "platform_version";
        this.f221 = ServerParameters.ADVERTISING_ID_PARAM;
        this.f219 = "imei";
        this.f246 = "android_id";
        this.f239 = "sdk_version";
        this.f233 = "devkey";
        this.f241 = "originalAppsFlyerId";
        this.f238 = "uid";
        this.f229 = "app_id";
        this.f243 = "app_version";
        this.f218 = AppsFlyerProperties.CHANNEL;
        this.f242 = "preInstall";
        this.f245 = "data";
        this.f247 = "r_debugging_off";
        this.f224 = "r_debugging_on";
        this.f222 = "public_api_call";
        this.f225 = "exception";
        this.f220 = "server_request";
        this.f223 = "server_response";
        this.f232 = "yyyy-MM-dd HH:mm:ssZ";
        this.f230 = "MM-dd HH:mm:ss.SSS";
        this.f227 = 0;
        this.f234 = "-1";
        this.f226 = new JSONArray();
        this.f227 = 0;
        this.f236 = false;
    }

    /* renamed from: ʼ reason: contains not printable characters */
    private synchronized void m187() {
        this.f226 = null;
        this.f226 = new JSONArray();
        this.f227 = 0;
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private synchronized void m189(String str, String str2, String str3, String str4) {
        try {
            this.f228.put("sdk_version", str);
            if (str2 != null && str2.length() > 0) {
                this.f228.put("devkey", str2);
            }
            if (str3 != null && str3.length() > 0) {
                this.f228.put("originalAppsFlyerId", str3);
            }
            if (str4 != null && str4.length() > 0) {
                this.f228.put("uid", str4);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ˏ reason: contains not printable characters */
    static s m191() {
        if (f216 == null) {
            f216 = new s();
        }
        return f216;
    }

    /* renamed from: ॱॱ reason: contains not printable characters */
    private synchronized String m195() {
        String str;
        str = null;
        try {
            this.f228.put("data", this.f226);
            str = this.f228.toString();
            m187();
        } catch (JSONException unused) {
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ʻ reason: contains not printable characters */
    public final boolean m196() {
        return this.f236;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ reason: contains not printable characters */
    public final synchronized void m197() {
        m194("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.f236 = false;
        this.f235 = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ reason: contains not printable characters */
    public final synchronized void m203(String str) {
        this.f234 = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ reason: contains not printable characters */
    public final synchronized void m206() {
        this.f228 = null;
        this.f226 = null;
        f216 = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ᐝ reason: contains not printable characters */
    public final void m207() {
        this.f237 = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ reason: contains not printable characters */
    public final synchronized void m202() {
        this.f236 = true;
        m194("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
    }

    /* renamed from: ˏ reason: contains not printable characters */
    private synchronized void m193(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            this.f228.put("brand", str);
            this.f228.put("model", str2);
            this.f228.put("platform", "Android");
            this.f228.put("platform_version", str3);
            if (str4 != null && str4.length() > 0) {
                this.f228.put(ServerParameters.ADVERTISING_ID_PARAM, str4);
            }
            if (str5 != null && str5.length() > 0) {
                this.f228.put("imei", str5);
            }
            if (str6 != null && str6.length() > 0) {
                this.f228.put("android_id", str6);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
        return;
     */
    /* renamed from: ॱ reason: contains not printable characters */
    private synchronized void m194(String str, String str2, String... strArr) {
        String str3;
        if ((this.f237 && (this.f235 || this.f236)) && this.f227 < 98304) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String str4 = "";
                if (strArr.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int length = strArr.length - 1; length > 0; length--) {
                        sb.append(strArr[length]);
                        sb.append(", ");
                    }
                    sb.append(strArr[0]);
                    str4 = sb.toString();
                }
                String format = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.ENGLISH).format(Long.valueOf(currentTimeMillis));
                if (str != null) {
                    str3 = String.format("%18s %5s _/%s [%s] %s %s", new Object[]{format, Long.valueOf(Thread.currentThread().getId()), AppsFlyerLib.LOG_TAG, str, str2, str4});
                } else {
                    str3 = String.format("%18s %5s %s/%s %s", new Object[]{format, Long.valueOf(Thread.currentThread().getId()), str2, AppsFlyerLib.LOG_TAG, str4});
                }
                this.f226.put(str3);
                this.f227 += str3.getBytes().length;
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ reason: contains not printable characters */
    public final void m199(String str, String... strArr) {
        m194("public_api_call", str, strArr);
    }

    /* renamed from: ˎ reason: contains not printable characters */
    private synchronized void m190(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.f228.put("app_id", str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str2 != null && str2.length() > 0) {
            this.f228.put("app_version", str2);
        }
        if (str3 != null && str3.length() > 0) {
            this.f228.put(AppsFlyerProperties.CHANNEL, str3);
        }
        if (str4 != null && str4.length() > 0) {
            this.f228.put("preInstall", str4);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ reason: contains not printable characters */
    public final void m198(String str, String str2) {
        m194("server_request", str, str2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ reason: contains not printable characters */
    public final void m201(String str, String str2) {
        m194(null, str, str2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ reason: contains not printable characters */
    public final synchronized void m200() {
        this.f235 = false;
        m187();
    }

    /* renamed from: ˋ reason: contains not printable characters */
    static void m188(String str, PackageManager packageManager) {
        try {
            if (f216 == null) {
                f216 = new s();
            }
            f216.m192(str, packageManager);
            if (f216 == null) {
                f216 = new s();
            }
            String r5 = f216.m195();
            o oVar = new o(null, AppsFlyerLib.getInstance().isTrackingStopped());
            oVar.f197 = r5;
            oVar.m174();
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl("https://%smonitorsdk.%s/remote-debug?app_id="));
            sb.append(str);
            oVar.execute(new String[]{sb.toString()});
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final void m205(Throwable th) {
        String[] strArr;
        Throwable cause = th.getCause();
        String simpleName = th.getClass().getSimpleName();
        String message = cause == null ? th.getMessage() : cause.getMessage();
        StackTraceElement[] stackTrace = cause == null ? th.getStackTrace() : cause.getStackTrace();
        if (stackTrace == null) {
            strArr = new String[]{message};
        } else {
            String[] strArr2 = new String[(stackTrace.length + 1)];
            strArr2[0] = message;
            for (int i2 = 1; i2 < stackTrace.length; i2++) {
                strArr2[i2] = stackTrace[i2].toString();
            }
            strArr = strArr2;
        }
        m194("exception", simpleName, strArr);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final void m204(String str, int i2, String str2) {
        m194("server_response", str, String.valueOf(i2), str2);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0070 */
    /* renamed from: ˏ reason: contains not printable characters */
    private synchronized void m192(String str, PackageManager packageManager) {
        AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
        AppsFlyerLib instance2 = AppsFlyerLib.getInstance();
        String string = instance.getString("remote_debug_static_data");
        if (string != null) {
            this.f228 = new JSONObject(string);
        } else {
            this.f228 = new JSONObject();
            m193(Build.BRAND, Build.MODEL, VERSION.RELEASE, instance.getString(ServerParameters.ADVERTISING_ID_PARAM), instance2.f54, instance2.f45);
            m189("4.9.0.184", instance.getString(AppsFlyerProperties.AF_KEY), instance.getString("KSAppsFlyerId"), instance.getString("uid"));
            try {
                int i2 = packageManager.getPackageInfo(str, 0).versionCode;
                m190(str, String.valueOf(i2), instance.getString(AppsFlyerProperties.CHANNEL), instance.getString("preInstallName"));
            } catch (Throwable unused) {
            }
            instance.set("remote_debug_static_data", this.f228.toString());
        }
        try {
            this.f228.put("launch_counter", this.f234);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
