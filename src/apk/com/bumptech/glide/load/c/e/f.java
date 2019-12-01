package com.bumptech.glide.load.c.e;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.e;
import com.bumptech.glide.load.c.a.d;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.l;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation */
public class f implements l<c> {

    /* renamed from: a reason: collision with root package name */
    private final l<Bitmap> f3814a;

    public f(l<Bitmap> lVar) {
        com.bumptech.glide.h.l.a(lVar);
        this.f3814a = lVar;
    }

    public G<c> a(Context context, G<c> g2, int i2, int i3) {
        c cVar = (c) g2.get();
        d dVar = new d(cVar.c(), e.a(context).c());
        G a2 = this.f3814a.a(context, dVar, i2, i3);
        if (!dVar.equals(a2)) {
            dVar.a();
        }
        cVar.a(this.f3814a, (Bitmap) a2.get());
        return g2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        return this.f3814a.equals(((f) obj).f3814a);
    }

    public int hashCode() {
        return this.f3814a.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f3814a.updateDiskCacheKey(messageDigest);
    }
}
