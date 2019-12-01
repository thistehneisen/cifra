package com.appsflyer;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsFlyer2dXConversionCallback implements AppsFlyerConversionListener {
    /* renamed from: ˏ reason: contains not printable characters */
    private void m19(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", "failure");
            jSONObject.put("data", str2);
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1390007222) {
                if (hashCode == 1050716216) {
                    if (str.equals("onInstallConversionFailure")) {
                        c2 = 0;
                    }
                }
            } else if (str.equals("onAttributionFailure")) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    onAttributionFailureNative(jSONObject);
                }
                return;
            }
            onInstallConversionFailureNative(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        onAppOpenAttributionNative(map);
    }

    public native void onAppOpenAttributionNative(Object obj);

    public void onAttributionFailure(String str) {
        m19("onInstallConversionFailure", str);
    }

    public native void onAttributionFailureNative(Object obj);

    public void onInstallConversionDataLoaded(Map<String, String> map) {
        onInstallConversionDataLoadedNative(map);
    }

    public native void onInstallConversionDataLoadedNative(Object obj);

    public void onInstallConversionFailure(String str) {
        m19("onAttributionFailure", str);
    }

    public native void onInstallConversionFailureNative(Object obj);
}
