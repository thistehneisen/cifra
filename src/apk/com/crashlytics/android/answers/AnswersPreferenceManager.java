package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.a.d.c;
import io.fabric.sdk.android.a.d.d;

class AnswersPreferenceManager {
    static final String PREFKEY_ANALYTICS_LAUNCHED = "analytics_launched";
    static final String PREF_STORE_NAME = "settings";
    private final c prefStore;

    AnswersPreferenceManager(c cVar) {
        this.prefStore = cVar;
    }

    public static AnswersPreferenceManager build(Context context) {
        return new AnswersPreferenceManager(new d(context, PREF_STORE_NAME));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean hasAnalyticsLaunched() {
        return this.prefStore.get().getBoolean(PREFKEY_ANALYTICS_LAUNCHED, false);
    }

    @SuppressLint({"CommitPrefEdits"})
    public void setAnalyticsLaunched() {
        c cVar = this.prefStore;
        cVar.a(cVar.edit().putBoolean(PREFKEY_ANALYTICS_LAUNCHED, true));
    }
}
