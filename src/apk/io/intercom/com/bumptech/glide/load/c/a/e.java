package io.intercom.com.bumptech.glide.load.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.m;

/* compiled from: BitmapTransformation */
public abstract class e implements m<Bitmap> {
    public e() {
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap transform(io.intercom.com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i2, int i3);

    public final E<Bitmap> transform(Context context, E<Bitmap> e2, int i2, int i3) {
        if (j.b(i2, i3)) {
            io.intercom.com.bumptech.glide.load.engine.a.e c2 = c.a(context).c();
            Bitmap bitmap = (Bitmap) e2.get();
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getHeight();
            }
            Bitmap transform = transform(c2, bitmap, i2, i3);
            return bitmap.equals(transform) ? e2 : d.a(transform, c2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot apply transformation on width: ");
        sb.append(i2);
        sb.append(" or height: ");
        sb.append(i3);
        sb.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
        throw new IllegalArgumentException(sb.toString());
    }

    @Deprecated
    public e(Context context) {
        this();
    }

    @Deprecated
    public e(io.intercom.com.bumptech.glide.load.engine.a.e eVar) {
        this();
    }
}
