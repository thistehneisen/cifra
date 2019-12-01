package kotlin.d;

/* compiled from: progressionUtil.kt */
public final class a {
    private static final int a(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    private static final int b(int i2, int i3, int i4) {
        return a(a(i2, i4) - a(i3, i4), i4);
    }

    public static final int a(int i2, int i3, int i4) {
        if (i4 > 0) {
            if (i2 >= i3) {
                return i3;
            }
            return i3 - b(i3, i2, i4);
        } else if (i4 < 0) {
            return i2 <= i3 ? i3 : i3 + b(i2, i3, -i4);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
