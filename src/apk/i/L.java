package i;

import i.a.e;
import j.g;
import java.io.IOException;

/* compiled from: RequestBody */
public abstract class L {
    public static L a(D d2, byte[] bArr) {
        return a(d2, bArr, 0, bArr.length);
    }

    public long a() throws IOException {
        return -1;
    }

    public abstract void a(g gVar) throws IOException;

    public abstract D b();

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public static L a(D d2, byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            e.a((long) bArr.length, (long) i2, (long) i3);
            return new K(d2, i3, bArr, i2);
        }
        throw new NullPointerException("content == null");
    }
}
