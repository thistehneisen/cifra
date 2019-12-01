package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class c {
    public static int a(Context context, String str) {
        PackageInfo c2 = c(context, str);
        if (c2 != null) {
            ApplicationInfo applicationInfo = c2.applicationInfo;
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle == null) {
                    return -1;
                }
                return bundle.getInt("com.google.android.gms.version", -1);
            }
        }
        return -1;
    }

    public static boolean b(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            if ((com.google.android.gms.common.b.c.a(context).a(str, 0).flags & 2097152) != 0) {
                return true;
            }
        } catch (NameNotFoundException unused) {
        }
        return false;
    }

    private static PackageInfo c(Context context, String str) {
        try {
            return com.google.android.gms.common.b.c.a(context).b(str, 128);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }
}
