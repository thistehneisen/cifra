package com.crashlytics.android;

import android.content.Context;
import io.fabric.sdk.android.a.b.o;

class ManifestEnabledCheckStrategy implements EnabledCheckStrategy {
    ManifestEnabledCheckStrategy() {
    }

    public boolean isCrashlyticsEnabled(Context context) {
        return o.a(context).b();
    }
}
