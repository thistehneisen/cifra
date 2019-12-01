package com.appsflyer;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerConfigHandler {
    public static String getUrl(String str) {
        return String.format(str, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AppsFlyerLib.getInstance().getHostName()});
    }

    /* renamed from: ˋ reason: contains not printable characters */
    static JSONObject m100(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            try {
                if (jSONObject.optBoolean("monitor", false)) {
                    s.m191().m202();
                } else {
                    s.m191().m200();
                    s.m191().m197();
                }
            } catch (JSONException unused) {
                s.m191().m200();
                s.m191().m197();
                return jSONObject;
            } catch (Throwable th) {
                th = th;
                AFLogger.afErrorLog(th.getMessage(), th);
                s.m191().m200();
                s.m191().m197();
                return jSONObject;
            }
        } catch (JSONException unused2) {
            jSONObject = null;
            s.m191().m200();
            s.m191().m197();
            return jSONObject;
        } catch (Throwable th2) {
            th = th2;
            jSONObject = null;
            AFLogger.afErrorLog(th.getMessage(), th);
            s.m191().m200();
            s.m191().m197();
            return jSONObject;
        }
        return jSONObject;
    }
}
