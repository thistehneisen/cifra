package kotlin.a;

import java.util.NoSuchElementException;
import kotlin.e.b.h;

/* compiled from: _Arrays.kt */
class e extends d {
    public static <T> boolean a(T[] tArr, T t) {
        h.b(tArr, "$this$contains");
        return b(tArr, t) >= 0;
    }

    public static final <T> int b(T[] tArr, T t) {
        h.b(tArr, "$this$indexOf");
        int i2 = 0;
        if (t == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
        } else {
            int length2 = tArr.length;
            while (i2 < length2) {
                if (h.a((Object) t, (Object) tArr[i2])) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public static char a(char[] cArr) {
        h.b(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }
}
