package io.intercom.android.sdk.transforms;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import io.intercom.android.sdk.commons.utilities.BitmapUtils;
import io.intercom.android.sdk.commons.utilities.BitmapUtils.BitmapCache;
import io.intercom.com.bumptech.glide.load.c.a.e;
import io.intercom.com.bumptech.glide.load.g;
import java.security.MessageDigest;

public class RoundedCornersTransform extends e {
    private static final int VERSION = 1;
    private final String id;
    private final byte[] idBytes = this.id.getBytes(g.f9988a);
    private final int radius;

    public RoundedCornersTransform(int i2) {
        this.radius = i2;
        StringBuilder sb = new StringBuilder();
        sb.append("io.intercom.android.sdk.transforms.RoundedCornersTransform.(radius=");
        sb.append(i2);
        sb.append(")");
        sb.append(1);
        this.id = sb.toString();
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(final io.intercom.com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i2, int i3) {
        return BitmapUtils.transformRoundCorners(bitmap, new BitmapCache() {
            public Bitmap get(int i2, int i3, Config config) {
                return eVar.get(i2, i3, config);
            }
        }, this.radius);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.idBytes);
    }
}
