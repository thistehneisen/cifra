package com.intercom.composer.input;

import android.content.Context;
import android.graphics.drawable.Drawable;

public interface IconProvider {
    Drawable getIconDrawable(String str, Context context);
}
