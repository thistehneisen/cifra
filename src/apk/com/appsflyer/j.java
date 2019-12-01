package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class j implements Runnable {

    /* renamed from: ʻ reason: contains not printable characters */
    private static String f168;

    /* renamed from: ʼ reason: contains not printable characters */
    private String f169;

    /* renamed from: ʽ reason: contains not printable characters */
    private final Intent f170;

    /* renamed from: ˊ reason: contains not printable characters */
    private String f171;

    /* renamed from: ˋ reason: contains not printable characters */
    private String f172;

    /* renamed from: ˎ reason: contains not printable characters */
    private String f173;

    /* renamed from: ˏ reason: contains not printable characters */
    private String f174;
    /* access modifiers changed from: private */

    /* renamed from: ॱ reason: contains not printable characters */
    public WeakReference<Context> f175;

    /* renamed from: ॱॱ reason: contains not printable characters */
    private String f176;
    /* access modifiers changed from: private */

    /* renamed from: ᐝ reason: contains not printable characters */
    public Map<String, String> f177;

    static {
        StringBuilder sb = new StringBuilder("https://%svalidate.%s/api/v");
        sb.append(AppsFlyerLib.f33);
        sb.append("/androidevent?buildnumber=4.9.0&app_id=");
        f168 = sb.toString();
    }

    j(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, Intent intent) {
        this.f175 = new WeakReference<>(context);
        this.f174 = str;
        this.f171 = str2;
        this.f172 = str4;
        this.f169 = str5;
        this.f176 = str6;
        this.f177 = map;
        this.f173 = str3;
        this.f170 = intent;
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private static HttpURLConnection m153(String str, String str2) throws IOException {
        try {
            o oVar = new o(null, AppsFlyerLib.getInstance().isTrackingStopped());
            oVar.f197 = str;
            oVar.m173();
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                StringBuilder sb = new StringBuilder("Main thread detected. Calling ");
                sb.append(str2);
                sb.append(" in a new thread.");
                AFLogger.afDebugLog(sb.toString());
                oVar.execute(new String[]{str2});
            } else {
                StringBuilder sb2 = new StringBuilder("Calling ");
                sb2.append(str2);
                sb2.append(" (on current thread: ");
                sb2.append(Thread.currentThread().toString());
                sb2.append(" )");
                AFLogger.afDebugLog(sb2.toString());
                oVar.onPreExecute();
                oVar.onPostExecute(oVar.doInBackground(str2));
            }
            return oVar.m172();
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not send callStats request", th);
            return null;
        }
    }

    public final void run() {
        String str = "result";
        String str2 = ServerParameters.ADVERTISING_ID_PARAM;
        String str3 = this.f174;
        if (str3 != null && str3.length() != 0 && !AppsFlyerLib.getInstance().isTrackingStopped()) {
            HttpURLConnection httpURLConnection = null;
            try {
                Context context = (Context) this.f175.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.f171);
                    hashMap.put("sig-data", this.f172);
                    hashMap.put("signature", this.f173);
                    final HashMap hashMap2 = new HashMap();
                    hashMap2.putAll(hashMap);
                    Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
                        public final void run() {
                            j jVar = j.this;
                            j.m154(jVar, hashMap2, jVar.f177, j.this.f175);
                        }
                    }, 5, TimeUnit.MILLISECONDS);
                    hashMap.put("dev_key", this.f174);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    hashMap.put(str2, AppsFlyerProperties.getInstance().getString(str2));
                    String jSONObject = new JSONObject(hashMap).toString();
                    String url = ServerConfigHandler.getUrl("https://%ssdk-services.%s/validate-android-signature");
                    s.m191().m198(url, jSONObject);
                    HttpURLConnection r2 = m153(jSONObject, url);
                    int i2 = -1;
                    if (r2 != null) {
                        i2 = r2.getResponseCode();
                    }
                    AppsFlyerLib.getInstance();
                    String r5 = AppsFlyerLib.m47(r2);
                    s.m191().m204(url, i2, r5);
                    JSONObject jSONObject2 = new JSONObject(r5);
                    jSONObject2.put("code", i2);
                    if (i2 == 200) {
                        StringBuilder sb = new StringBuilder("Validate response 200 ok: ");
                        sb.append(jSONObject2.toString());
                        AFLogger.afInfoLog(sb.toString());
                        m155(jSONObject2.optBoolean(str) ? jSONObject2.getBoolean(str) : false, this.f172, this.f169, this.f176, jSONObject2.toString());
                    } else {
                        AFLogger.afInfoLog("Failed Validate request");
                        m155(false, this.f172, this.f169, this.f176, jSONObject2.toString());
                    }
                    if (r2 != null) {
                        r2.disconnect();
                    }
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private static void m155(boolean z, String str, String str2, String str3, String str4) {
        if (AppsFlyerLib.f32 != null) {
            StringBuilder sb = new StringBuilder("Validate callback parameters: ");
            sb.append(str);
            String str5 = " ";
            sb.append(str5);
            sb.append(str2);
            sb.append(str5);
            sb.append(str3);
            AFLogger.afDebugLog(sb.toString());
            if (z) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AppsFlyerLib.f32.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AppsFlyerLib.f32;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [java.net.HttpURLConnection, java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v7, types: [java.net.HttpURLConnection, java.lang.String]
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [java.lang.String, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.net.HttpURLConnection]
      mth insns count: 114
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: ॱ reason: contains not printable characters */
    static /* synthetic */ void m154(j jVar, Map map, Map map2, WeakReference weakReference) {
        j jVar2 = jVar;
        if (weakReference.get() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl(f168));
            sb.append(((Context) weakReference.get()).getPackageName());
            String sb2 = sb.toString();
            SharedPreferences r10 = AppsFlyerLib.m44((Context) weakReference.get());
            ? r2 = 0;
            String string = r10.getString("referrer", r2);
            if (string == null) {
                string = "";
            }
            String str = string;
            Map r3 = AppsFlyerLib.getInstance().m74((Context) weakReference.get(), jVar2.f174, AFInAppEventType.PURCHASE, "", str, true, r10, false, jVar2.f170, null);
            r3.put("price", jVar2.f169);
            r3.put("currency", jVar2.f176);
            JSONObject jSONObject = new JSONObject(r3);
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
                jSONObject.put("receipt_data", jSONObject2);
            } catch (JSONException e2) {
                AFLogger.afErrorLog("Failed to build 'receipt_data'", e2);
            }
            if (map2 != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    for (Entry entry2 : map2.entrySet()) {
                        jSONObject3.put((String) entry2.getKey(), entry2.getValue());
                    }
                    jSONObject.put("extra_prms", jSONObject3);
                } catch (JSONException e3) {
                    AFLogger.afErrorLog("Failed to build 'extra_prms'", e3);
                }
            }
            String jSONObject4 = jSONObject.toString();
            s.m191().m198(sb2, jSONObject4);
            try {
                HttpURLConnection r22 = m153(jSONObject4, sb2);
                int i2 = -1;
                if (r22 != null) {
                    i2 = r22.getResponseCode();
                }
                AppsFlyerLib.getInstance();
                String r32 = AppsFlyerLib.m47(r22);
                s.m191().m204(sb2, i2, r32);
                JSONObject jSONObject5 = new JSONObject(r32);
                if (i2 == 200) {
                    StringBuilder sb3 = new StringBuilder("Validate-WH response - 200: ");
                    sb3.append(jSONObject5.toString());
                    AFLogger.afInfoLog(sb3.toString());
                } else {
                    StringBuilder sb4 = new StringBuilder("Validate-WH response failed - ");
                    sb4.append(i2);
                    sb4.append(": ");
                    sb4.append(jSONObject5.toString());
                    AFLogger.afWarnLog(sb4.toString());
                }
                if (r22 != null) {
                    r22.disconnect();
                }
            } catch (Throwable th) {
                if (r2 != 0) {
                    r2.disconnect();
                }
                throw th;
            }
        }
    }
}
