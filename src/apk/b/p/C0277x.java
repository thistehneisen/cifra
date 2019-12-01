package b.p;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

/* renamed from: b.p.x reason: case insensitive filesystem */
/* compiled from: PropertyValuesHolderUtils */
class C0277x {
    static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        if (VERSION.SDK_INT >= 21) {
            return PropertyValuesHolder.ofObject(property, null, path);
        }
        return PropertyValuesHolder.ofFloat(new C0276w(property, path), new float[]{0.0f, 1.0f});
    }
}
