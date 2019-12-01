package com.google.android.gms.common.b;

import android.content.Context;
import com.google.android.gms.common.util.k;

public class a {

    /* renamed from: a reason: collision with root package name */
    private static Context f4644a;

    /* renamed from: b reason: collision with root package name */
    private static Boolean f4645b;

    public static synchronized boolean a(Context context) {
        synchronized (a.class) {
            Context applicationContext = context.getApplicationContext();
            if (f4644a == null || f4645b == null || f4644a != applicationContext) {
                f4645b = null;
                if (k.i()) {
                    f4645b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        f4645b = Boolean.valueOf(true);
                    } catch (ClassNotFoundException unused) {
                        f4645b = Boolean.valueOf(false);
                    }
                }
                f4644a = applicationContext;
                boolean booleanValue = f4645b.booleanValue();
                return booleanValue;
            }
            boolean booleanValue2 = f4645b.booleanValue();
            return booleanValue2;
        }
    }
}
