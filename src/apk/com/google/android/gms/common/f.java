package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.b.c;
import com.google.android.gms.common.internal.G;
import com.google.android.gms.common.util.h;

public class f {

    /* renamed from: a reason: collision with root package name */
    public static final int f4660a = g.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    /* renamed from: b reason: collision with root package name */
    private static final f f4661b = new f();

    f() {
    }

    public static f a() {
        return f4661b;
    }

    public int b(Context context) {
        return a(context, f4660a);
    }

    public int a(Context context, int i2) {
        int isGooglePlayServicesAvailable = g.isGooglePlayServicesAvailable(context, i2);
        if (g.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }

    public boolean b(int i2) {
        return g.isUserRecoverableError(i2);
    }

    public Intent a(Context context, int i2, String str) {
        String str2 = "com.google.android.gms";
        if (i2 == 1 || i2 == 2) {
            if (context == null || !h.c(context)) {
                return G.a(str2, a(context, str));
            }
            return G.a();
        } else if (i2 != 3) {
            return null;
        } else {
            return G.a(str2);
        }
    }

    public PendingIntent a(Context context, int i2, int i3) {
        return a(context, i2, i3, null);
    }

    public PendingIntent a(Context context, int i2, int i3, String str) {
        Intent a2 = a(context, i2, str);
        if (a2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i3, a2, 134217728);
    }

    public int a(Context context) {
        return g.getApkVersion(context);
    }

    public String a(int i2) {
        return g.getErrorString(i2);
    }

    private static String a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f4660a);
        String str2 = "-";
        sb.append(str2);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(str2);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append(str2);
        if (context != null) {
            try {
                sb.append(c.a(context).b(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }
}
