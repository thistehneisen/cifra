package b.g.i;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: b.g.i.g reason: case insensitive filesystem */
/* compiled from: MarginLayoutParamsCompat */
public final class C0246g {
    public static int a(MarginLayoutParams marginLayoutParams) {
        if (VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginEnd();
        }
        return marginLayoutParams.rightMargin;
    }

    public static int b(MarginLayoutParams marginLayoutParams) {
        if (VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }

    public static void a(MarginLayoutParams marginLayoutParams, int i2) {
        if (VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginEnd(i2);
        } else {
            marginLayoutParams.rightMargin = i2;
        }
    }

    public static void b(MarginLayoutParams marginLayoutParams, int i2) {
        if (VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginStart(i2);
        } else {
            marginLayoutParams.leftMargin = i2;
        }
    }
}
