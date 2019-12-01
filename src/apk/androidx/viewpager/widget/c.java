package androidx.viewpager.widget;

import android.view.animation.Interpolator;

/* compiled from: ViewPager */
class c implements Interpolator {
    c() {
    }

    public float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        return (f3 * f3 * f3 * f3 * f3) + 1.0f;
    }
}
