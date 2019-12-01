package d.a;

import java.util.LinkedHashMap;

/* compiled from: DaggerCollections */
public final class a {
    public static <K, V> LinkedHashMap<K, V> a(int i2) {
        return new LinkedHashMap<>(b(i2));
    }

    private static int b(int i2) {
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((((float) i2) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
