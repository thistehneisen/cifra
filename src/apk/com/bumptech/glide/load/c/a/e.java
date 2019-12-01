package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.h.n;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.l;

/* compiled from: BitmapTransformation */
public abstract class e implements l<Bitmap> {
    /* access modifiers changed from: protected */
    public abstract Bitmap a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i2, int i3);

    public final G<Bitmap> a(Context context, G<Bitmap> g2, int i2, int i3) {
        if (n.b(i2, i3)) {
            com.bumptech.glide.load.engine.a.e c2 = com.bumptech.glide.e.a(context).c();
            Bitmap bitmap = (Bitmap) g2.get();
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getHeight();
            }
            Bitmap a2 = a(c2, bitmap, i2, i3);
            return bitmap.equals(a2) ? g2 : d.a(a2, c2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot apply transformation on width: ");
        sb.append(i2);
        sb.append(" or height: ");
        sb.append(i3);
        sb.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
        throw new IllegalArgumentException(sb.toString());
    }
}
