package io.intercom.android.sdk.conversation.composer.galleryinput;

import android.graphics.Bitmap;
import io.intercom.com.bumptech.glide.load.c.a.g;
import io.intercom.com.bumptech.glide.load.engine.a.e;

class DownscaleOnlyCenterCrop extends g {
    static final DownscaleOnlyCenterCrop INSTANCE = new DownscaleOnlyCenterCrop();

    DownscaleOnlyCenterCrop() {
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(e eVar, Bitmap bitmap, int i2, int i3) {
        if (bitmap.getHeight() > i3 || bitmap.getWidth() > i2) {
            return super.transform(eVar, bitmap, i2, i3);
        }
        return bitmap;
    }
}
