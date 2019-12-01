package b.g.a.a;

import java.lang.reflect.Array;

/* compiled from: GrowingArrayUtils */
final class e {
    public static int a(int i2) {
        if (i2 <= 4) {
            return 8;
        }
        return i2 * 2;
    }

    public static <T> T[] a(T[] tArr, int i2, T t) {
        if (i2 + 1 > tArr.length) {
            T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a(i2));
            System.arraycopy(tArr, 0, tArr2, 0, i2);
            tArr = tArr2;
        }
        tArr[i2] = t;
        return tArr;
    }

    public static int[] a(int[] iArr, int i2, int i3) {
        if (i2 + 1 > iArr.length) {
            int[] iArr2 = new int[a(i2)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            iArr = iArr2;
        }
        iArr[i2] = i3;
        return iArr;
    }
}
