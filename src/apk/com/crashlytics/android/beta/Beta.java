package com.crashlytics.android.beta;

import io.fabric.sdk.android.a.b.q;
import io.fabric.sdk.android.a.b.y.a;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import java.util.Collections;
import java.util.Map;

public class Beta extends l<Boolean> implements q {
    public static final String TAG = "Beta";

    public static Beta getInstance() {
        return (Beta) f.a(Beta.class);
    }

    public Map<a, String> getDeviceIdentifiers() {
        return Collections.emptyMap();
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String getVersion() {
        return "1.2.10.27";
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground() {
        f.e().d(TAG, "Beta kit initializing...");
        return Boolean.valueOf(true);
    }
}
