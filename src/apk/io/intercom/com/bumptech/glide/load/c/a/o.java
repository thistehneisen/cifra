package io.intercom.com.bumptech.glide.load.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.m;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation */
public class o implements m<Drawable> {

    /* renamed from: a reason: collision with root package name */
    private final m<Bitmap> f9616a;

    /* renamed from: b reason: collision with root package name */
    private final boolean f9617b;

    public o(m<Bitmap> mVar, boolean z) {
        this.f9616a = mVar;
        this.f9617b = z;
    }

    private E<Drawable> a(Context context, E<Bitmap> e2) {
        return r.a(context.getResources(), e2);
    }

    public m<BitmapDrawable> a() {
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        return this.f9616a.equals(((o) obj).f9616a);
    }

    public int hashCode() {
        return this.f9616a.hashCode();
    }

    public E<Drawable> transform(Context context, E<Drawable> e2, int i2, int i3) {
        Drawable drawable = (Drawable) e2.get();
        E a2 = n.a(c.a(context).c(), drawable, i2, i3);
        if (a2 != null) {
            E transform = this.f9616a.transform(context, a2, i2, i3);
            if (!transform.equals(a2)) {
                return a(context, transform);
            }
            transform.a();
            return e2;
        } else if (!this.f9617b) {
            return e2;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to convert ");
            sb.append(drawable);
            sb.append(" to a Bitmap");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f9616a.updateDiskCacheKey(messageDigest);
    }
}
