package com.intercom.input.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.b;
import b.g.a.a;

class PermissionHelper {
    private static final String ASKED_FOR_PERMISSION = "asked_for_permission";
    private static final String PREFS = "intercom_composer_permission_status_prefs";
    private final Activity activity;
    private final SharedPreferences sharedPreferences;

    PermissionHelper(Activity activity2, SharedPreferences sharedPreferences2) {
        this.activity = activity2;
        this.sharedPreferences = sharedPreferences2;
    }

    static PermissionHelper create(Activity activity2) {
        return new PermissionHelper(activity2, activity2.getSharedPreferences(PREFS, 0));
    }

    /* access modifiers changed from: 0000 */
    public int getPermissionStatus(String str) {
        if (a.a((Context) this.activity, str) == 0) {
            return 0;
        }
        if (b.a(this.activity, str)) {
            return 1;
        }
        return this.sharedPreferences.getBoolean(ASKED_FOR_PERMISSION, false) ? 2 : 3;
    }

    /* access modifiers changed from: 0000 */
    public void setAskedForPermissionPref(boolean z) {
        this.sharedPreferences.edit().putBoolean(ASKED_FOR_PERMISSION, z).apply();
    }
}
