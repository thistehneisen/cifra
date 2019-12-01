package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.b.c;

public final class O {

    /* renamed from: a reason: collision with root package name */
    private static Object f4685a = new Object();

    /* renamed from: b reason: collision with root package name */
    private static boolean f4686b;

    /* renamed from: c reason: collision with root package name */
    private static String f4687c;

    /* renamed from: d reason: collision with root package name */
    private static int f4688d;

    public static String a(Context context) {
        c(context);
        return f4687c;
    }

    public static int b(Context context) {
        c(context);
        return f4688d;
    }

    private static void c(Context context) {
        synchronized (f4685a) {
            if (!f4686b) {
                f4686b = true;
                try {
                    Bundle bundle = c.a(context).a(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f4687c = bundle.getString("com.google.app.id");
                        f4688d = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (NameNotFoundException e2) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e2);
                }
            }
        }
    }
}
