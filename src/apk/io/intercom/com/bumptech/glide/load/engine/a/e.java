package io.intercom.com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* compiled from: BitmapPool */
public interface e {
    Bitmap a(int i2, int i3, Config config);

    void a();

    void a(int i2);

    void a(Bitmap bitmap);

    Bitmap get(int i2, int i3, Config config);
}
