package io.intercom.android.sdk.utilities;

import android.text.TextUtils;
import io.intercom.com.bumptech.glide.load.engine.q;

public class ImageUtils {
    public static int getAspectHeight(int i2, double d2) {
        return (int) (((double) i2) * d2);
    }

    public static double getAspectRatio(int i2, int i3) {
        double d2 = (((double) i3) * 1.0d) / ((double) i2);
        if (Double.isNaN(d2)) {
            return 0.0d;
        }
        return d2;
    }

    public static q getDiskCacheStrategy(String str) {
        return isGif(str) ? q.f9934c : q.f9935d;
    }

    public static boolean isGif(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith(".gif");
    }
}
