package b.p;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

/* renamed from: b.p.u reason: case insensitive filesystem */
/* compiled from: ObjectAnimatorUtils */
class C0274u {
    static <T> ObjectAnimator a(T t, Property<T, PointF> property, Path path) {
        if (VERSION.SDK_INT >= 21) {
            return ObjectAnimator.ofObject(t, property, null, path);
        }
        return ObjectAnimator.ofFloat(t, new C0276w(property, path), new float[]{0.0f, 1.0f});
    }
}
