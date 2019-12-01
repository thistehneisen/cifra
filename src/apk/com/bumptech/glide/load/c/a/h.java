package com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* compiled from: CenterInside */
public class h extends e {

    /* renamed from: a reason: collision with root package name */
    private static final byte[] f3727a = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(f.f4130a);

    /* access modifiers changed from: protected */
    public Bitmap a(e eVar, Bitmap bitmap, int i2, int i3) {
        return w.b(eVar, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof h;
    }

    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CenterInside".hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f3727a);
    }
}
