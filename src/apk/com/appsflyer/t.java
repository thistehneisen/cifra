package com.appsflyer;

import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

final class t extends OneLinkHttpTask {

    /* renamed from: ˋ reason: contains not printable characters */
    private static List<String> f265 = Arrays.asList(new String[]{"onelink.me", "onelnk.com", "app.aflink.com"});

    /* renamed from: ˎ reason: contains not printable characters */
    private c f266;

    /* renamed from: ˏ reason: contains not printable characters */
    private String f267;

    interface c {
        /* renamed from: ˊ reason: contains not printable characters */
        void m222(Map<String, String> map);

        /* renamed from: ˏ reason: contains not printable characters */
        void m223(String str);
    }

    t(Uri uri, AppsFlyerLib appsFlyerLib) {
        super(appsFlyerLib);
        if (!TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            boolean z = false;
            for (String contains : f265) {
                if (uri.getHost().contains(contains)) {
                    z = true;
                }
            }
            String[] split = uri.getPath().split(Constants.URL_PATH_DELIMITER);
            if (z && split.length == 3) {
                this.f105 = split[1];
                this.f267 = split[2];
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ reason: contains not printable characters */
    public final void m216() {
        this.f266.m223("Can't get one link data");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ reason: contains not printable characters */
    public final void m217(c cVar) {
        this.f266 = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ reason: contains not printable characters */
    public final void m218(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        httpsURLConnection.setRequestMethod("GET");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final boolean m220() {
        return !TextUtils.isEmpty(this.f105) && !TextUtils.isEmpty(this.f267);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ reason: contains not printable characters */
    public final String m221() {
        StringBuilder sb = new StringBuilder();
        sb.append(ServerConfigHandler.getUrl("https://%sonelink.%s/shortlink-sdk/v1"));
        sb.append(Constants.URL_PATH_DELIMITER);
        sb.append(this.f105);
        sb.append("?id=");
        sb.append(this.f267);
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final void m219(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, jSONObject.optString(str2));
            }
            this.f266.m222(hashMap);
        } catch (JSONException e2) {
            this.f266.m223("Can't parse one link data");
            AFLogger.afErrorLog("Error while parsing to json ".concat(String.valueOf(str)), e2);
        }
    }
}
