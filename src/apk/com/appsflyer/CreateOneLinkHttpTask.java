package com.appsflyer;

import android.content.Context;
import com.appsflyer.share.Constants;
import com.appsflyer.share.LinkGenerator;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateOneLinkHttpTask extends OneLinkHttpTask {

    /* renamed from: ʻ reason: contains not printable characters */
    private Context f99;

    /* renamed from: ʽ reason: contains not printable characters */
    private boolean f100 = false;

    /* renamed from: ˋ reason: contains not printable characters */
    private String f101 = "";

    /* renamed from: ˎ reason: contains not printable characters */
    private String f102;

    /* renamed from: ˏ reason: contains not printable characters */
    private Map<String, String> f103;

    /* renamed from: ॱ reason: contains not printable characters */
    private ResponseListener f104;

    public interface ResponseListener {
        void onResponse(String str);

        void onResponseError(String str);
    }

    public CreateOneLinkHttpTask(String str, Map<String, String> map, AppsFlyerLib appsFlyerLib, Context context, boolean z) {
        super(appsFlyerLib);
        this.f100 = z;
        this.f99 = context;
        if (this.f99 != null) {
            this.f101 = context.getPackageName();
        } else {
            AFLogger.afWarnLog("CreateOneLinkHttpTask: context can't be null");
        }
        this.f105 = str;
        this.f102 = "-1";
        this.f103 = map;
    }

    public void setListener(ResponseListener responseListener) {
        this.f104 = responseListener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ reason: contains not printable characters */
    public final void m91() {
        LinkGenerator addParameters = new LinkGenerator(Constants.USER_INVITE_LINK_TYPE).setBaseURL(this.f105, AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_DOMAIN), this.f101).addParameter(Constants.URL_SITE_ID, this.f101).addParameters(this.f103);
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string != null) {
            addParameters.setReferrerCustomerId(string);
        }
        this.f104.onResponse(addParameters.generateLink());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ reason: contains not printable characters */
    public final void m92(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        if (!this.f100) {
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject(this.f103);
            jSONObject.put("ttl", this.f102);
            jSONObject.put("data", jSONObject2);
            httpsURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            dataOutputStream.writeBytes(jSONObject.toString());
            dataOutputStream.flush();
            dataOutputStream.close();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final void m93(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                this.f104.onResponse(jSONObject.optString((String) keys.next()));
            }
        } catch (JSONException e2) {
            this.f104.onResponseError("Can't parse one link data");
            AFLogger.afErrorLog("Error while parsing to json ".concat(String.valueOf(str)), e2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ reason: contains not printable characters */
    public final String m94() {
        StringBuilder sb = new StringBuilder();
        sb.append(ServerConfigHandler.getUrl("https://%sonelink.%s/shortlink-sdk/v1"));
        sb.append(Constants.URL_PATH_DELIMITER);
        sb.append(this.f105);
        return sb.toString();
    }
}
