package io.intercom.com.bumptech.glide.load.c.e;

import android.content.Context;
import android.graphics.Bitmap;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.c.a.d;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.m;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation */
public class f implements m<c> {

    /* renamed from: a reason: collision with root package name */
    private final m<Bitmap> f9677a;

    public f(m<Bitmap> mVar) {
        h.a(mVar);
        this.f9677a = mVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        return this.f9677a.equals(((f) obj).f9677a);
    }

    public int hashCode() {
        return this.f9677a.hashCode();
    }

    public E<c> transform(Context context, E<c> e2, int i2, int i3) {
        c cVar = (c) e2.get();
        d dVar = new d(cVar.c(), c.a(context).c());
        E transform = this.f9677a.transform(context, dVar, i2, i3);
        if (!dVar.equals(transform)) {
            dVar.a();
        }
        cVar.a(this.f9677a, (Bitmap) transform.get());
        return e2;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f9677a.updateDiskCacheKey(messageDigest);
    }
}
