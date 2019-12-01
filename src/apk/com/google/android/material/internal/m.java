package com.google.android.material.internal;

import android.graphics.PorterDuff.Mode;
import android.view.View;
import b.g.i.B;

/* compiled from: ViewUtils */
public class m {
    public static Mode a(int i2, Mode mode) {
        if (i2 == 3) {
            return Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return Mode.SRC_IN;
        }
        if (i2 == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    public static boolean a(View view) {
        return B.m(view) == 1;
    }
}
