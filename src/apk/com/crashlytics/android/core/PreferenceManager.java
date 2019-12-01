package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import io.fabric.sdk.android.a.d.c;
import io.fabric.sdk.android.a.d.d;

@SuppressLint({"CommitPrefEdits"})
class PreferenceManager {
    static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final String PREF_MIGRATION_COMPLETE = "preferences_migration_complete";
    private static final boolean SHOULD_ALWAYS_SEND_REPORTS_DEFAULT = false;
    private final CrashlyticsCore kit;
    private final c preferenceStore;

    public PreferenceManager(c cVar, CrashlyticsCore crashlyticsCore) {
        this.preferenceStore = cVar;
        this.kit = crashlyticsCore;
    }

    public static PreferenceManager create(c cVar, CrashlyticsCore crashlyticsCore) {
        return new PreferenceManager(cVar, crashlyticsCore);
    }

    /* access modifiers changed from: 0000 */
    public void setShouldAlwaysSendReports(boolean z) {
        c cVar = this.preferenceStore;
        cVar.a(cVar.edit().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldAlwaysSendReports() {
        SharedPreferences sharedPreferences = this.preferenceStore.get();
        String str = PREF_MIGRATION_COMPLETE;
        boolean contains = sharedPreferences.contains(str);
        String str2 = PREF_ALWAYS_SEND_REPORTS_KEY;
        if (!contains) {
            d dVar = new d(this.kit);
            if (!this.preferenceStore.get().contains(str2) && dVar.get().contains(str2)) {
                boolean z = dVar.get().getBoolean(str2, false);
                c cVar = this.preferenceStore;
                cVar.a(cVar.edit().putBoolean(str2, z));
            }
            c cVar2 = this.preferenceStore;
            cVar2.a(cVar2.edit().putBoolean(str, true));
        }
        return this.preferenceStore.get().getBoolean(str2, false);
    }
}
