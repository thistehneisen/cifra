package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.share.Constants;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class AFDeepLinkManager {

    /* renamed from: ʽ reason: contains not printable characters */
    private static Uri f0 = null;

    /* renamed from: ˊ reason: contains not printable characters */
    static String[] f1;

    /* renamed from: ˋ reason: contains not printable characters */
    private static Uri f2 = null;

    /* renamed from: ˎ reason: contains not printable characters */
    private static AFDeepLinkManager f3 = null;

    /* renamed from: ˏ reason: contains not printable characters */
    static final int f4 = ((int) TimeUnit.MILLISECONDS.toMillis(1500));

    /* renamed from: ॱ reason: contains not printable characters */
    static volatile boolean f5;
    protected int currentActivityHash = -1;

    /* renamed from: com.appsflyer.AFDeepLinkManager$3 reason: invalid class name */
    class AnonymousClass3 implements Runnable {

        /* renamed from: ˋ reason: contains not printable characters */
        private /* synthetic */ Uri f6;

        /* renamed from: ˏ reason: contains not printable characters */
        private /* synthetic */ Map f8;

        /* renamed from: ॱ reason: contains not printable characters */
        private /* synthetic */ Context f9;

        AnonymousClass3(Uri uri, Map map, Context context) {
            this.f6 = uri;
            this.f8 = map;
            this.f9 = context;
        }

        /* renamed from: ॱ reason: contains not printable characters */
        static void m1(Context context) {
            Context applicationContext = context.getApplicationContext();
            AFLogger.afInfoLog("onBecameBackground");
            AppsFlyerLib.getInstance().m78();
            AFLogger.afInfoLog("callStatsBackground background call");
            AppsFlyerLib.getInstance().m77(new WeakReference<>(applicationContext));
            s r0 = s.m191();
            if (r0.m196()) {
                r0.m197();
                if (applicationContext != null) {
                    s.m188(applicationContext.getPackageName(), applicationContext.getPackageManager());
                }
                r0.m206();
            } else {
                AFLogger.afDebugLog("RD status is OFF");
            }
            AFExecutor.getInstance().m3();
        }

        public final void run() {
            long j2;
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            Uri uri = null;
            try {
                StringBuilder sb = new StringBuilder("ESP deeplink resoling is started: ");
                sb.append(this.f6.toString());
                AFLogger.afRDLog(sb.toString());
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f6.toString()).openConnection();
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setReadTimeout(AFDeepLinkManager.f4);
                httpURLConnection.setConnectTimeout(AFDeepLinkManager.f4);
                httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
                httpURLConnection.connect();
                AFLogger.afRDLog("ESP deeplink resoling is finished");
                hashMap.put("status", String.valueOf(httpURLConnection.getResponseCode()));
                if (httpURLConnection.getResponseCode() >= 300 && httpURLConnection.getResponseCode() <= 305) {
                    uri = Uri.parse(httpURLConnection.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD));
                }
                j2 = System.currentTimeMillis() - currentTimeMillis;
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                hashMap.put("error", th.getLocalizedMessage());
                hashMap.put("status", "-1");
                j2 = System.currentTimeMillis() - currentTimeMillis;
                AFLogger.afErrorLog(th.getMessage(), th);
            }
            hashMap.put("latency", Long.toString(j2));
            if (uri != null) {
                hashMap.put("res", uri.toString());
            } else {
                hashMap.put("res", "");
            }
            StringBuilder sb2 = new StringBuilder("ESP deeplink results: ");
            sb2.append(new JSONObject(hashMap).toString());
            AFLogger.afRDLog(sb2.toString());
            synchronized (this.f8) {
                this.f8.put("af_deeplink_r", hashMap);
                this.f8.put("af_deeplink", this.f6.toString());
            }
            AFDeepLinkManager.f5 = false;
            if (uri == null) {
                uri = this.f6;
            }
            AppsFlyerLib.getInstance().handleDeepLinkCallback(this.f9, this.f8, uri);
        }

        AnonymousClass3() {
        }
    }

    private AFDeepLinkManager() {
    }

    public static AFDeepLinkManager getInstance() {
        if (f3 == null) {
            f3 = new AFDeepLinkManager();
        }
        return f3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0089  */
    /* renamed from: ˏ reason: contains not printable characters */
    private void m0(Context context, Map<String, Object> map, Uri uri) {
        boolean z;
        String uri2 = uri.toString();
        if (f1 != null) {
            StringBuilder sb = new StringBuilder("Validate ESP deeplinks : ");
            sb.append(Arrays.asList(f1));
            AFLogger.afRDLog(sb.toString());
            if (!uri2.contains("af_tranid=")) {
                Iterator it = Arrays.asList(f1).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (uri2.contains("://".concat(String.valueOf(str)))) {
                        z = true;
                        break;
                    } else {
                        AFLogger.afRDLog("Validate ESP: reject ".concat(String.valueOf(str)));
                    }
                }
                if (!z) {
                    StringBuilder sb2 = new StringBuilder("Validation ESP succeeded for: ");
                    sb2.append(uri.toString());
                    AFLogger.afRDLog(sb2.toString());
                    f5 = true;
                    AFExecutor.getInstance().getSerialExecutor().execute(new AnonymousClass3(uri, map, context));
                    return;
                }
                AppsFlyerLib.getInstance().handleDeepLinkCallback(context, map, uri);
                return;
            }
        }
        z = false;
        if (!z) {
        }
    }

    /* access modifiers changed from: protected */
    public void collectIntentsFromActivities(Intent intent) {
        Uri uri;
        if (intent != null) {
            if ("android.intent.action.VIEW".equals(intent.getAction())) {
                uri = intent.getData();
                if (uri != null && intent.getData() != f0) {
                    f0 = intent.getData();
                    return;
                }
            }
        }
        uri = null;
        if (uri != null) {
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    public void processIntentForDeepLink(Intent intent, Context context, Map<String, Object> map) {
        Uri uri;
        if (intent != null) {
            if ("android.intent.action.VIEW".equals(intent.getAction())) {
                uri = intent.getData();
                if (uri == null) {
                    boolean z = AppsFlyerProperties.getInstance().getBoolean("consumeAfDeepLink", false);
                    boolean z2 = (intent.getFlags() & 4194304) == 0;
                    String str = "appsflyer_click_ts";
                    String str2 = "skipping re-use of previously consumed deep link: ";
                    if (intent.hasExtra(str) && !z) {
                        long longExtra = intent.getLongExtra(str, 0);
                        String str3 = "appsflyer_click_consumed_ts";
                        long j2 = AppsFlyerProperties.getInstance().getLong(str3, 0);
                        if (longExtra == 0 || longExtra == j2) {
                            StringBuilder sb = new StringBuilder(str2);
                            sb.append(uri.toString());
                            sb.append(" w/Ex: ");
                            sb.append(String.valueOf(longExtra));
                            AFLogger.afInfoLog(sb.toString());
                            return;
                        }
                        m0(context, map, uri);
                        AppsFlyerProperties.getInstance().set(str3, longExtra);
                        return;
                    } else if (z || z2) {
                        Boolean valueOf = Boolean.valueOf(z2);
                        Uri uri2 = f2;
                        if (uri2 == null || !uri.equals(uri2)) {
                            m0(context, map, uri);
                            f2 = uri;
                            return;
                        }
                        StringBuilder sb2 = new StringBuilder(str2);
                        sb2.append(uri.toString());
                        sb2.append(valueOf.booleanValue() ? " w/sT" : " w/cAPI");
                        AFLogger.afInfoLog(sb2.toString());
                        return;
                    } else {
                        String str4 = "lastActivityHash";
                        if (this.currentActivityHash != AppsFlyerProperties.getInstance().getInt(str4, 0)) {
                            m0(context, map, uri);
                            AppsFlyerProperties.getInstance().set(str4, this.currentActivityHash);
                            return;
                        }
                        StringBuilder sb3 = new StringBuilder(str2);
                        sb3.append(uri.toString());
                        sb3.append(" w/hC: ");
                        sb3.append(String.valueOf(this.currentActivityHash));
                        AFLogger.afInfoLog(sb3.toString());
                        return;
                    }
                } else {
                    Uri uri3 = f0;
                    if (uri3 != null) {
                        m0(context, map, uri3);
                        StringBuilder sb4 = new StringBuilder("using trampoline Intent fallback with URI : ");
                        sb4.append(f0.toString());
                        AFLogger.afInfoLog(sb4.toString());
                        f0 = null;
                        return;
                    }
                    if (AppsFlyerLib.getInstance().latestDeepLink != null) {
                        m0(context, map, AppsFlyerLib.getInstance().latestDeepLink);
                    }
                    return;
                }
            }
        }
        uri = null;
        if (uri == null) {
        }
    }
}
