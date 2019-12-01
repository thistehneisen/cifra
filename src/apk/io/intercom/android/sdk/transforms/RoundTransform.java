package io.intercom.android.sdk.transforms;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import io.intercom.android.sdk.commons.utilities.BitmapUtils;
import io.intercom.android.sdk.commons.utilities.BitmapUtils.BitmapCache;
import io.intercom.com.bumptech.glide.load.c.a.e;
import io.intercom.com.bumptech.glide.load.g;
import java.security.MessageDigest;

public class RoundTransform extends e {
    private static final String ID = "io.intercom.android.sdk.transforms.RoundTransform.1";
    private static final byte[] ID_BYTES = ID.getBytes(g.f9988a);
    private static final int VERSION = 1;

    public boolean equals(Object obj) {
        return obj instanceof RoundTransform;
    }

    public int hashCode() {
        return ID.hashCode();
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(final io.intercom.com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i2, int i3) {
        return BitmapUtils.transformRound(bitmap, new BitmapCache() {
            public Bitmap get(int i2, int i3, Config config) {
                return eVar.get(i2, i3, config);
            }
        });
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
