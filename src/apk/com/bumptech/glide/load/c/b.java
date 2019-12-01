package com.bumptech.glide.load.c;

import android.content.Context;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.l;
import java.security.MessageDigest;

/* compiled from: UnitTransformation */
public final class b<T> implements l<T> {

    /* renamed from: a reason: collision with root package name */
    private static final l<?> f3786a = new b();

    private b() {
    }

    public static <T> b<T> a() {
        return (b) f3786a;
    }

    public G<T> a(Context context, G<T> g2, int i2, int i3) {
        return g2;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
