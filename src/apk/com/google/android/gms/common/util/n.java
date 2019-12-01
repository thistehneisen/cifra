package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.b.c;
import com.google.android.gms.common.h;

public final class n {
    public static boolean a(Context context, int i2) {
        String str = "com.google.android.gms";
        if (!a(context, i2, str)) {
            return false;
        }
        try {
            return h.a(context).a(context.getPackageManager().getPackageInfo(str, 64));
        } catch (NameNotFoundException unused) {
            String str2 = "UidVerifier";
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    @TargetApi(19)
    public static boolean a(Context context, int i2, String str) {
        return c.a(context).a(i2, str);
    }
}
