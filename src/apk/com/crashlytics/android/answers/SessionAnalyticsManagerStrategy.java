package com.crashlytics.android.answers;

import io.fabric.sdk.android.a.c.f;
import io.fabric.sdk.android.a.e.b;

interface SessionAnalyticsManagerStrategy extends f {
    void deleteAllEvents();

    void processEvent(Builder builder);

    void sendEvents();

    void setAnalyticsSettingsData(b bVar, String str);
}
