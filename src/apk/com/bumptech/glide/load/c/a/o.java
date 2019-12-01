package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.e;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.l;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation */
public class o implements l<Drawable> {

    /* renamed from: a reason: collision with root package name */
    private final l<Bitmap> f3757a;

    /* renamed from: b reason: collision with root package name */
    private final boolean f3758b;

    public o(l<Bitmap> lVar, boolean z) {
        this.f3757a = lVar;
        this.f3758b = z;
    }

    public G<Drawable> a(Context context, G<Drawable> g2, int i2, int i3) {
        Drawable drawable = (Drawable) g2.get();
        G a2 = n.a(e.a(context).c(), drawable, i2, i3);
        if (a2 != null) {
            G a3 = this.f3757a.a(context, a2, i2, i3);
            if (!a3.equals(a2)) {
                return a(context, a3);
            }
            a3.a();
            return g2;
        } else if (!this.f3758b) {
            return g2;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to convert ");
            sb.append(drawable);
            sb.append(" to a Bitmap");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public l<BitmapDrawable> a() {
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        return this.f3757a.equals(((o) obj).f3757a);
    }

    public int hashCode() {
        return this.f3757a.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f3757a.updateDiskCacheKey(messageDigest);
    }

    private G<Drawable> a(Context context, G<Bitmap> g2) {
        return s.a(context.getResources(), g2);
    }
}
