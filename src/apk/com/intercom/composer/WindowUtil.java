package com.intercom.composer;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.Window;
import b.g.a.a;

public class WindowUtil {
    @TargetApi(19)
    public static void setFullscreenWindow(Window window, int i2) {
        if (VERSION.SDK_INT > 19) {
            window.getDecorView().setSystemUiVisibility(1280);
            setStatusBarColorRes(window, i2);
        }
    }

    @TargetApi(21)
    private static void setStatusBarColor(Window window, int i2) {
        if (VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i2);
        }
    }

    @TargetApi(21)
    private static void setStatusBarColorRes(Window window, int i2) {
        setStatusBarColor(window, a.a(window.getContext(), i2));
    }
}
