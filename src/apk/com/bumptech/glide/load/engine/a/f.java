package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* compiled from: BitmapPoolAdapter */
public class f implements e {
    public void a() {
    }

    public void a(int i2) {
    }

    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    public Bitmap get(int i2, int i3, Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    public Bitmap a(int i2, int i3, Config config) {
        return get(i2, i3, config);
    }
}
