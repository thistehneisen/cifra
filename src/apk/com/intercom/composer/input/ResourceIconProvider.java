package com.intercom.composer.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import b.g.a.a;

public class ResourceIconProvider implements IconProvider {
    private final int resId;

    public ResourceIconProvider(int i2) {
        this.resId = i2;
    }

    public Drawable getIconDrawable(String str, Context context) {
        return a.c(context, this.resId);
    }
}
