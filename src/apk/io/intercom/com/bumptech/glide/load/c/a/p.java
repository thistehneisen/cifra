package io.intercom.com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import io.intercom.com.bumptech.glide.load.engine.a.e;
import io.intercom.com.bumptech.glide.load.g;
import java.security.MessageDigest;

/* compiled from: FitCenter */
public class p extends e {

    /* renamed from: a reason: collision with root package name */
    private static final byte[] f9618a = "io.intercom.com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(g.f9988a);

    public boolean equals(Object obj) {
        return obj instanceof p;
    }

    public int hashCode() {
        return "io.intercom.com.bumptech.glide.load.resource.bitmap.FitCenter".hashCode();
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(e eVar, Bitmap bitmap, int i2, int i3) {
        return v.c(eVar, bitmap, i2, i3);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f9618a);
    }
}
