package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

public final class h {

    /* renamed from: a reason: collision with root package name */
    private static Boolean f4805a;

    /* renamed from: b reason: collision with root package name */
    private static Boolean f4806b;

    /* renamed from: c reason: collision with root package name */
    private static Boolean f4807c;

    @TargetApi(21)
    public static boolean a(Context context) {
        if (f4806b == null) {
            f4806b = Boolean.valueOf(k.g() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f4806b.booleanValue();
    }

    @TargetApi(20)
    public static boolean b(Context context) {
        if (f4805a == null) {
            f4805a = Boolean.valueOf(k.f() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f4805a.booleanValue();
    }

    @TargetApi(26)
    public static boolean c(Context context) {
        return b(context) && (!k.h() || (a(context) && !k.i()));
    }

    public static boolean d(Context context) {
        if (f4807c == null) {
            f4807c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f4807c.booleanValue();
    }

    public static boolean a() {
        return "user".equals(Build.TYPE);
    }
}
