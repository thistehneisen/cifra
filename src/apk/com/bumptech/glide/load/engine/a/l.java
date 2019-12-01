package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* compiled from: LruPoolStrategy */
interface l {
    String a(int i2, int i3, Config config);

    void a(Bitmap bitmap);

    int b(Bitmap bitmap);

    String c(Bitmap bitmap);

    Bitmap get(int i2, int i3, Config config);

    Bitmap removeLast();
}
