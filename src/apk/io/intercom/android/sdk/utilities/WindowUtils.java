package io.intercom.android.sdk.utilities;

import android.content.res.Resources;
import android.os.Build.VERSION;
import io.fabric.sdk.android.a.b.C0730a;

public class WindowUtils {
    public static int getStatusBarHeight(Resources resources) {
        int i2 = 0;
        if (VERSION.SDK_INT < 19) {
            return 0;
        }
        int identifier = resources.getIdentifier("status_bar_height", "dimen", C0730a.ANDROID_CLIENT_TYPE);
        if (identifier > 0) {
            i2 = resources.getDimensionPixelSize(identifier);
        }
        return i2;
    }
}
