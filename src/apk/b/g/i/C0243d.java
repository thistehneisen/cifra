package b.g.i;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

/* renamed from: b.g.i.d reason: case insensitive filesystem */
/* compiled from: GravityCompat */
public final class C0243d {
    public static void a(int i2, int i3, int i4, Rect rect, Rect rect2, int i5) {
        if (VERSION.SDK_INT >= 17) {
            Gravity.apply(i2, i3, i4, rect, rect2, i5);
        } else {
            Gravity.apply(i2, i3, i4, rect, rect2);
        }
    }

    public static int a(int i2, int i3) {
        return VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i2, i3) : i2 & -8388609;
    }
}
