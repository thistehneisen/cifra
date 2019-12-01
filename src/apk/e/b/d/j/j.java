package e.b.d.j;

/* compiled from: Pow2 */
public final class j {
    public static int a(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }
}
