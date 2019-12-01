package c.c.a;

import android.view.animation.Interpolator;

/* compiled from: ItemTouchHelperExtension */
class i implements Interpolator {
    i() {
    }

    public float getInterpolation(float f2) {
        return f2 * f2 * f2 * f2 * f2;
    }
}
