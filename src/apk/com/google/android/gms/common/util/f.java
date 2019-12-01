package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.internal.q;

public final class f {

    /* renamed from: a reason: collision with root package name */
    private static final String[] f4798a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    /* renamed from: b reason: collision with root package name */
    private static DropBoxManager f4799b = null;

    /* renamed from: c reason: collision with root package name */
    private static boolean f4800c = false;

    /* renamed from: d reason: collision with root package name */
    private static int f4801d = -1;

    /* renamed from: e reason: collision with root package name */
    private static int f4802e = 0;

    /* renamed from: f reason: collision with root package name */
    private static int f4803f = 0;

    public static boolean a(Context context, Throwable th) {
        return a(context, th, 536870912);
    }

    private static boolean a(Context context, Throwable th, int i2) {
        try {
            q.a(context);
            q.a(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}
