package com.crashlytics.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.fabric.sdk.android.a.b.x;
import io.fabric.sdk.android.f;

public class CrashlyticsInitProvider extends ContentProvider {
    private static final String TAG = "CrashlyticsInitProvider";

    interface EnabledCheckStrategy {
        boolean isCrashlyticsEnabled(Context context);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        Context context = getContext();
        boolean shouldInitializeFabric = shouldInitializeFabric(context, new x(), new ManifestEnabledCheckStrategy());
        String str = TAG;
        if (shouldInitializeFabric) {
            try {
                f.a(context, new Crashlytics());
                f.e().e(str, "CrashlyticsInitProvider initialization successful");
            } catch (IllegalStateException unused) {
                f.e().e(str, "CrashlyticsInitProvider initialization unsuccessful");
                return false;
            }
        } else {
            f.e().e(str, "CrashlyticsInitProvider skipping initialization");
        }
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldInitializeFabric(Context context, x xVar, EnabledCheckStrategy enabledCheckStrategy) {
        if (xVar.e(context)) {
            return enabledCheckStrategy.isCrashlyticsEnabled(context);
        }
        return xVar.d(context);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
