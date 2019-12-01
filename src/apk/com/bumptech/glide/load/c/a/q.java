package com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* compiled from: FitCenter */
public class q extends e {

    /* renamed from: a reason: collision with root package name */
    private static final byte[] f3759a = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(f.f4130a);

    /* access modifiers changed from: protected */
    public Bitmap a(e eVar, Bitmap bitmap, int i2, int i3) {
        return w.c(eVar, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof q;
    }

    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.FitCenter".hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f3759a);
    }
}
