package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.StateListDrawable;

public class ButtonSelector extends StateListDrawable {
    private final int color;

    public ButtonSelector(Context context, int i2, int i3) {
        this.color = i3;
        addState(new int[]{16842910}, context.getResources().getDrawable(i2));
        addState(new int[]{16842908}, context.getResources().getDrawable(i2));
        addState(new int[]{16842919}, context.getResources().getDrawable(i2));
    }

    private static int darken(int i2, double d2) {
        return Color.argb(255, (int) (((double) Color.red(i2)) * d2), (int) (((double) Color.green(i2)) * d2), (int) (((double) Color.blue(i2)) * d2));
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i2 : iArr) {
            if (i2 == 16842919 || i2 == 16842908) {
                z = true;
            }
        }
        if (z) {
            setColorFilter(darken(this.color, 0.9d), Mode.SRC);
        } else {
            setColorFilter(this.color, Mode.SRC);
        }
        return super.onStateChange(iArr);
    }
}
