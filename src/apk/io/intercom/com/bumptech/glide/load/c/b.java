package io.intercom.com.bumptech.glide.load.c;

import android.content.Context;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.m;
import java.security.MessageDigest;

/* compiled from: UnitTransformation */
public final class b<T> implements m<T> {

    /* renamed from: a reason: collision with root package name */
    private static final m<?> f9650a = new b();

    private b() {
    }

    public static <T> b<T> a() {
        return (b) f9650a;
    }

    public E<T> transform(Context context, E<T> e2, int i2, int i3) {
        return e2;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
