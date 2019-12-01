package com.touchin.vtb.b;

import com.appsflyer.AppsFlyerConversionListener;
import java.util.Map;
import kotlin.e.b.h;

/* compiled from: AppsFlyerController.kt */
public final class a implements AppsFlyerConversionListener {
    a() {
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        h.b(map, "conversionData");
    }

    public void onAttributionFailure(String str) {
        h.b(str, "errorMessage");
    }

    public void onInstallConversionDataLoaded(Map<String, String> map) {
        h.b(map, "conversionData");
    }

    public void onInstallConversionFailure(String str) {
        h.b(str, "errorMessage");
    }
}
