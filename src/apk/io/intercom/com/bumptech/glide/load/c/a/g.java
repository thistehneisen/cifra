package io.intercom.com.bumptech.glide.load.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import io.intercom.com.bumptech.glide.load.engine.a.e;
import java.security.MessageDigest;

/* compiled from: CenterCrop */
public class g extends e {
    private static final String ID = "io.intercom.com.bumptech.glide.load.resource.bitmap.CenterCrop";
    private static final byte[] ID_BYTES = ID.getBytes(io.intercom.com.bumptech.glide.load.g.f9988a);

    public g() {
    }

    public boolean equals(Object obj) {
        return obj instanceof g;
    }

    public int hashCode() {
        return ID.hashCode();
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(e eVar, Bitmap bitmap, int i2, int i3) {
        return v.a(eVar, bitmap, i2, i3);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }

    @Deprecated
    public g(Context context) {
        this();
    }

    @Deprecated
    public g(e eVar) {
        this();
    }
}
