package b.i.b;

import android.view.animation.Interpolator;

/* compiled from: ViewDragHelper */
class e implements Interpolator {
    e() {
    }

    public float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        return (f3 * f3 * f3 * f3 * f3) + 1.0f;
    }
}
