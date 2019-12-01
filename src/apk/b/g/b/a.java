package b.g.b;

import android.graphics.Color;

/* compiled from: ColorUtils */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static final ThreadLocal<double[]> f2495a = new ThreadLocal<>();

    public static int a(int i2, int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int c2 = c(alpha2, alpha);
        return Color.argb(c2, a(Color.red(i2), alpha2, Color.red(i3), alpha, c2), a(Color.green(i2), alpha2, Color.green(i3), alpha, c2), a(Color.blue(i2), alpha2, Color.blue(i3), alpha, c2));
    }

    public static int b(int i2, int i3) {
        if (i3 >= 0 && i3 <= 255) {
            return (i2 & 16777215) | (i3 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int c(int i2, int i3) {
        return 255 - (((255 - i3) * (255 - i2)) / 255);
    }

    private static int a(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((i2 * 255) * i3) + ((i4 * i5) * (255 - i3))) / (i6 * 255);
    }
}
