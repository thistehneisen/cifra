package com.appsflyer.share;

import android.content.Context;
import android.os.AsyncTask;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.ServerParameters;
import io.fabric.sdk.android.a.b.C0730a;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CrossPromotionHelper {

    static class c extends AsyncTask<String, Void, Void> {

        /* renamed from: ˊ reason: contains not printable characters */
        private d f248;

        /* renamed from: ˎ reason: contains not printable characters */
        private WeakReference<Context> f249;

        /* renamed from: ॱ reason: contains not printable characters */
        private boolean f250;

        c(d dVar, Context context, boolean z) {
            this.f248 = dVar;
            this.f249 = new WeakReference<>(context);
            this.f250 = z;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
            if (r2 != null) goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0098, code lost:
            if (r2 != null) goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
            r2.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
            return null;
         */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1  */
        /* renamed from: ˎ reason: contains not printable characters */
        public Void doInBackground(String... strArr) {
            HttpURLConnection httpURLConnection;
            if (this.f250) {
                return null;
            }
            try {
                String str = strArr[0];
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(C0730a.DEFAULT_TIMEOUT);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        AFLogger.afInfoLog("Cross promotion impressions success: ".concat(String.valueOf(str)), false);
                    } else {
                        if (responseCode != 301) {
                            if (responseCode != 302) {
                                StringBuilder sb = new StringBuilder("call to ");
                                sb.append(str);
                                sb.append(" failed: ");
                                sb.append(responseCode);
                                AFLogger.afInfoLog(sb.toString());
                            }
                        }
                        AFLogger.afInfoLog("Cross promotion redirection success: ".concat(String.valueOf(str)), false);
                        if (!(this.f248 == null || this.f249.get() == null)) {
                            this.f248.m214(httpURLConnection.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD));
                            this.f248.m215((Context) this.f249.get());
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        AFLogger.afErrorLog(th.getMessage(), th, true);
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    public static void trackAndOpenStore(Context context, String str, String str2) {
        trackAndOpenStore(context, str, str2, null);
    }

    public static void trackCrossPromoteImpression(Context context, String str, String str2) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, Promote Impression is disabled", true);
            return;
        }
        LinkGenerator r4 = m208(context, str, str2, null, ServerConfigHandler.getUrl("https://%simpression.%s"));
        new c(null, null, AppsFlyerLib.getInstance().isTrackingStopped()).execute(new String[]{r4.generateLink()});
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private static LinkGenerator m208(Context context, String str, String str2, Map<String, String> map, String str3) {
        LinkGenerator linkGenerator = new LinkGenerator("af_cross_promotion");
        linkGenerator.m212(str3).m213(str).addParameter(Constants.URL_SITE_ID, context.getPackageName());
        if (str2 != null) {
            linkGenerator.setCampaign(str2);
        }
        if (map != null) {
            linkGenerator.addParameters(map);
        }
        String string = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        if (string != null) {
            linkGenerator.addParameter(Constants.URL_ADVERTISING_ID, string);
        }
        return linkGenerator;
    }

    public static void trackAndOpenStore(Context context, String str, String str2, Map<String, String> map) {
        LinkGenerator r4 = m208(context, str, str2, map, ServerConfigHandler.getUrl(Constants.BASE_URL_APP_APPSFLYER_COM));
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, track And Open Store is disabled", true);
            return;
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("af_campaign", str2);
        AppsFlyerLib.getInstance().trackEvent(context, "af_cross_promotion", hashMap);
        new c(new d(), context, AppsFlyerLib.getInstance().isTrackingStopped()).execute(new String[]{r4.generateLink()});
    }
}
