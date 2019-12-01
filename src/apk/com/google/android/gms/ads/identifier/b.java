package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.g;

public final class b {

    /* renamed from: a reason: collision with root package name */
    private SharedPreferences f4490a;

    public b(Context context) {
        try {
            Context remoteContext = g.getRemoteContext(context);
            this.f4490a = remoteContext == null ? null : remoteContext.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.f4490a = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final float a(String str, float f2) {
        try {
            if (this.f4490a == null) {
                return 0.0f;
            }
            return this.f4490a.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }

    /* access modifiers changed from: 0000 */
    public final String a(String str, String str2) {
        try {
            return this.f4490a == null ? str2 : this.f4490a.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }

    public final boolean a(String str, boolean z) {
        try {
            if (this.f4490a == null) {
                return false;
            }
            return this.f4490a.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }
}
