package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

/* renamed from: com.google.android.gms.internal.measurement.ia reason: case insensitive filesystem */
public class C0374ia {

    /* renamed from: a reason: collision with root package name */
    private static UserManager f5219a;

    /* renamed from: b reason: collision with root package name */
    private static volatile boolean f5220b = (!a());

    /* renamed from: c reason: collision with root package name */
    private static boolean f5221c = false;

    private C0374ia() {
    }

    public static boolean a() {
        return VERSION.SDK_INT >= 24;
    }

    @TargetApi(24)
    private static boolean b(Context context) {
        boolean z;
        int i2 = 1;
        while (true) {
            z = false;
            if (i2 > 2) {
                break;
            }
            if (f5219a == null) {
                f5219a = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = f5219a;
            if (userManager == null) {
                return true;
            }
            try {
                if (userManager.isUserUnlocked() || !userManager.isUserRunning(Process.myUserHandle())) {
                    z = true;
                }
            } catch (NullPointerException e2) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e2);
                f5219a = null;
                i2++;
            }
        }
        if (z) {
            f5219a = null;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        return r3;
     */
    @TargetApi(24)
    private static boolean c(Context context) {
        if (f5220b) {
            return true;
        }
        synchronized (C0374ia.class) {
            if (f5220b) {
                return true;
            }
            boolean b2 = b(context);
            if (b2) {
                f5220b = b2;
            }
        }
    }

    public static boolean a(Context context) {
        return !a() || c(context);
    }
}
