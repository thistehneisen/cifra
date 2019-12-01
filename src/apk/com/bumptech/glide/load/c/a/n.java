package com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.a.e;
import java.util.concurrent.locks.Lock;

/* compiled from: DrawableToBitmapConverter */
final class n {

    /* renamed from: a reason: collision with root package name */
    private static final e f3756a = new m();

    static G<Bitmap> a(e eVar, Drawable drawable, int i2, int i3) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = b(eVar, current, i2, i3);
            z = true;
        } else {
            bitmap = null;
        }
        if (!z) {
            eVar = f3756a;
        }
        return d.a(bitmap, eVar);
    }

    private static Bitmap b(e eVar, Drawable drawable, int i2, int i3) {
        String str = "Unable to draw ";
        String str2 = "DrawableToBitmap";
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(str2, 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(drawable);
                sb.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                Log.w(str2, sb.toString());
            }
            return null;
        } else if (i3 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i2 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Lock a2 = w.a();
            a2.lock();
            Bitmap bitmap = eVar.get(i2, i3, Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, i2, i3);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return bitmap;
            } finally {
                a2.unlock();
            }
        } else {
            if (Log.isLoggable(str2, 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(drawable);
                sb2.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                Log.w(str2, sb2.toString());
            }
            return null;
        }
    }
}
