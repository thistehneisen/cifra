package io.intercom.android.sdk.conversation.composer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import b.g.a.a;
import io.intercom.android.sdk.R;

public class InputDrawableManager {
    private static final int[][] STATES = {new int[]{16842919}, new int[]{16842913}, new int[0]};
    private final ColorStateList colorStateList;

    public InputDrawableManager(Context context, int i2) {
        this.colorStateList = new ColorStateList(STATES, new int[]{i2, i2, a.a(context, R.color.intercom_input_default_color)});
    }

    public Drawable createDrawable(Context context, int i2) {
        Drawable i3 = androidx.core.graphics.drawable.a.i(a.c(context, i2));
        androidx.core.graphics.drawable.a.a(i3, this.colorStateList);
        return i3;
    }
}
