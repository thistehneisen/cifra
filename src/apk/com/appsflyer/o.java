package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import io.fabric.sdk.android.a.b.C0730a;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

final class o extends AsyncTask<String, Void, String> {

    /* renamed from: ʻ reason: contains not printable characters */
    private boolean f193;

    /* renamed from: ʼ reason: contains not printable characters */
    private boolean f194;

    /* renamed from: ʽ reason: contains not printable characters */
    private HttpURLConnection f195;

    /* renamed from: ˊ reason: contains not printable characters */
    Map<String, String> f196;

    /* renamed from: ˋ reason: contains not printable characters */
    String f197;

    /* renamed from: ˎ reason: contains not printable characters */
    private String f198 = "";

    /* renamed from: ˏ reason: contains not printable characters */
    private boolean f199 = false;

    /* renamed from: ॱ reason: contains not printable characters */
    private boolean f200 = false;

    /* renamed from: ॱॱ reason: contains not printable characters */
    private WeakReference<Context> f201;

    /* renamed from: ᐝ reason: contains not printable characters */
    private URL f202;

    o(Context context, boolean z) {
        this.f201 = new WeakReference<>(context);
        this.f194 = true;
        this.f193 = true;
        this.f200 = z;
    }

    /* access modifiers changed from: protected */
    public final void onCancelled() {
    }

    /* access modifiers changed from: protected */
    public final void onPreExecute() {
        if (this.f197 == null) {
            this.f197 = new JSONObject(this.f196).toString();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ reason: contains not printable characters */
    public final String doInBackground(String... strArr) {
        if (this.f200) {
            return null;
        }
        try {
            this.f202 = new URL(strArr[0]);
            String str = "UTF-8";
            if (this.f194) {
                s.m191().m198(this.f202.toString(), this.f197);
                int length = this.f197.getBytes(str).length;
                StringBuilder sb = new StringBuilder("call = ");
                sb.append(this.f202);
                sb.append("; size = ");
                sb.append(length);
                sb.append(" byte");
                sb.append(length > 1 ? "s" : "");
                sb.append("; body = ");
                sb.append(this.f197);
                a.m141(sb.toString());
            }
            this.f195 = (HttpURLConnection) this.f202.openConnection();
            this.f195.setReadTimeout(30000);
            this.f195.setConnectTimeout(30000);
            this.f195.setRequestMethod("POST");
            this.f195.setDoInput(true);
            this.f195.setDoOutput(true);
            this.f195.setRequestProperty("Content-Type", C0730a.ACCEPT_JSON_VALUE);
            OutputStream outputStream = this.f195.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, str));
            bufferedWriter.write(this.f197);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            this.f195.connect();
            int responseCode = this.f195.getResponseCode();
            if (this.f193) {
                AppsFlyerLib.getInstance();
                this.f198 = AppsFlyerLib.m47(this.f195);
            }
            if (this.f194) {
                s.m191().m204(this.f202.toString(), responseCode, this.f198);
            }
            if (responseCode == 200) {
                AFLogger.afInfoLog("Status 200 ok");
                Context context = (Context) this.f201.get();
                if (this.f202.toString().startsWith(ServerConfigHandler.getUrl(AppsFlyerLib.f30)) && context != null) {
                    Editor edit = AppsFlyerLib.m44(context).edit();
                    edit.putBoolean("sentRegisterRequestToAF", true);
                    edit.apply();
                    AFLogger.afDebugLog("Successfully registered for Uninstall Tracking");
                }
            } else {
                this.f199 = true;
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("Error while calling ");
            sb2.append(this.f202.toString());
            AFLogger.afErrorLog(sb2.toString(), th);
            this.f199 = true;
        }
        return this.f198;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ reason: contains not printable characters */
    public final HttpURLConnection m172() {
        return this.f195;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final void m173() {
        this.f193 = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ reason: contains not printable characters */
    public final void m174() {
        this.f194 = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ reason: contains not printable characters */
    public final void onPostExecute(String str) {
        if (this.f199) {
            AFLogger.afInfoLog("Connection error: ".concat(String.valueOf(str)));
            return;
        }
        AFLogger.afInfoLog("Connection call succeeded: ".concat(String.valueOf(str)));
    }
}
