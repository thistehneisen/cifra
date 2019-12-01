package io.intercom.com.bumptech.glide.load.a.a;

import android.net.Uri;

/* compiled from: MediaStoreUtil */
public final class b {
    public static boolean a(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384;
    }

    public static boolean a(Uri uri) {
        return b(uri) && !d(uri);
    }

    public static boolean b(Uri uri) {
        if (uri != null) {
            if ("content".equals(uri.getScheme())) {
                if ("media".equals(uri.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(Uri uri) {
        return b(uri) && d(uri);
    }

    private static boolean d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
