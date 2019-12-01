package androidx.core.widget;

import android.os.Build.VERSION;
import android.widget.EdgeEffect;

/* compiled from: EdgeEffectCompat */
public final class d {
    public static void a(EdgeEffect edgeEffect, float f2, float f3) {
        if (VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f2, f3);
        } else {
            edgeEffect.onPull(f2);
        }
    }
}
