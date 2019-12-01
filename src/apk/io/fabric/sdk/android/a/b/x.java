package io.fabric.sdk.android.a.b;

import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.f;

/* compiled from: FirebaseInfo */
public class x {
    /* access modifiers changed from: 0000 */
    public String a(Context context) {
        int a2 = l.a(context, "google_app_id", "string");
        if (a2 == 0) {
            return null;
        }
        f.e().d("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
        return a(context.getResources().getString(a2));
    }

    /* access modifiers changed from: 0000 */
    public boolean b(Context context) {
        if (!TextUtils.isEmpty(new i().b(context))) {
            return true;
        }
        return !TextUtils.isEmpty(new i().c(context));
    }

    /* access modifiers changed from: 0000 */
    public boolean c(Context context) {
        int a2 = l.a(context, "google_app_id", "string");
        if (a2 == 0) {
            return false;
        }
        return !TextUtils.isEmpty(context.getResources().getString(a2));
    }

    public boolean d(Context context) {
        int a2 = l.a(context, "io.fabric.auto_initialize", "bool");
        if (a2 == 0) {
            return false;
        }
        boolean z = context.getResources().getBoolean(a2);
        if (z) {
            f.e().d("Fabric", "Found Fabric auto-initialization flag for joint Firebase/Fabric customers");
        }
        return z;
    }

    public boolean e(Context context) {
        boolean z = false;
        if (l.a(context, "com.crashlytics.useFirebaseAppId", false)) {
            return true;
        }
        if (c(context) && !b(context)) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public String a(String str) {
        return l.d(str).substring(0, 40);
    }
}
