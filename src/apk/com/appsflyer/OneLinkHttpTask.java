package com.appsflyer;

import android.text.TextUtils;
import io.fabric.sdk.android.a.b.C0730a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;

public abstract class OneLinkHttpTask implements Runnable {

    /* renamed from: ˊ reason: contains not printable characters */
    String f105;

    /* renamed from: ˋ reason: contains not printable characters */
    private HttpsUrlConnectionProvider f106;

    /* renamed from: ॱ reason: contains not printable characters */
    private AppsFlyerLib f107;

    public static class HttpsUrlConnectionProvider {
        /* renamed from: ॱ reason: contains not printable characters */
        static HttpsURLConnection m99(String str) throws IOException {
            return (HttpsURLConnection) new URL(str).openConnection();
        }
    }

    OneLinkHttpTask(AppsFlyerLib appsFlyerLib) {
        this.f107 = appsFlyerLib;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c5  */
    public void run() {
        String str;
        String str2 = "";
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String r3 = m98();
        AFLogger.afRDLog("oneLinkUrl: ".concat(String.valueOf(r3)));
        try {
            HttpsURLConnection r4 = HttpsUrlConnectionProvider.m99(r3);
            r4.addRequestProperty("content-type", C0730a.ACCEPT_JSON_VALUE);
            StringBuilder sb = new StringBuilder();
            sb.append(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
            sb.append(currentTimeMillis);
            r4.addRequestProperty("authorization", p.m175(sb.toString()));
            r4.addRequestProperty("af-timestamp", String.valueOf(currentTimeMillis));
            r4.setReadTimeout(3000);
            r4.setConnectTimeout(3000);
            m96(r4);
            int responseCode = r4.getResponseCode();
            str = AppsFlyerLib.m47((HttpURLConnection) r4);
            if (responseCode == 200) {
                try {
                    AFLogger.afInfoLog("Status 200 ok");
                } catch (Throwable th) {
                    th = th;
                    String str3 = "Error while calling ";
                    AFLogger.afErrorLog(str3.concat(String.valueOf(r3)), th);
                    StringBuilder sb2 = new StringBuilder(str3);
                    sb2.append(r3);
                    sb2.append(" stacktrace: ");
                    sb2.append(th.toString());
                    str2 = sb2.toString();
                    if (TextUtils.isEmpty(str2)) {
                    }
                }
            } else {
                StringBuilder sb3 = new StringBuilder("Response code = ");
                sb3.append(responseCode);
                sb3.append(" content = ");
                sb3.append(str);
                str2 = sb3.toString();
            }
        } catch (Throwable th2) {
            th = th2;
            str = str2;
            String str32 = "Error while calling ";
            AFLogger.afErrorLog(str32.concat(String.valueOf(r3)), th);
            StringBuilder sb22 = new StringBuilder(str32);
            sb22.append(r3);
            sb22.append(" stacktrace: ");
            sb22.append(th.toString());
            str2 = sb22.toString();
            if (TextUtils.isEmpty(str2)) {
            }
        }
        if (TextUtils.isEmpty(str2)) {
            AFLogger.afInfoLog("Connection call succeeded: ".concat(String.valueOf(str)));
            m97(str);
            return;
        }
        AFLogger.afWarnLog("Connection error: ".concat(String.valueOf(str2)));
        m95();
    }

    public void setConnProvider(HttpsUrlConnectionProvider httpsUrlConnectionProvider) {
        this.f106 = httpsUrlConnectionProvider;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ reason: contains not printable characters */
    public abstract void m95();

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ reason: contains not printable characters */
    public abstract void m96(HttpsURLConnection httpsURLConnection) throws JSONException, IOException;

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public abstract void m97(String str);

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ reason: contains not printable characters */
    public abstract String m98();
}
