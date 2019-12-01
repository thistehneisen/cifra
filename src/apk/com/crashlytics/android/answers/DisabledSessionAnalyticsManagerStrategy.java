package com.crashlytics.android.answers;

import io.fabric.sdk.android.a.e.b;
import java.io.IOException;

class DisabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    DisabledSessionAnalyticsManagerStrategy() {
    }

    public void cancelTimeBasedFileRollOver() {
    }

    public void deleteAllEvents() {
    }

    public void processEvent(Builder builder) {
    }

    public boolean rollFileOver() throws IOException {
        return false;
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
    }

    public void sendEvents() {
    }

    public void setAnalyticsSettingsData(b bVar, String str) {
    }
}
