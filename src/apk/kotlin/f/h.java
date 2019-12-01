package kotlin.f;

/* compiled from: _Ranges.kt */
class h extends g {
    public static int a(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    public static int a(int i2, int i3, int i4) {
        if (i3 > i4) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot coerce value to an empty range: maximum ");
            sb.append(i4);
            sb.append(" is less than minimum ");
            sb.append(i3);
            sb.append('.');
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 < i3) {
            return i3;
        } else {
            return i2 > i4 ? i4 : i2;
        }
    }

    public static int b(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    public static b c(int i2, int i3) {
        return b.f10311a.a(i2, i3, -1);
    }

    public static d d(int i2, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            return d.f10320f.a();
        }
        return new d(i2, i3 - 1);
    }
}
