package i;

import i.a.e;
import j.f;
import j.h;
import java.io.Closeable;
import java.io.InputStream;

/* compiled from: ResponseBody */
public abstract class O implements Closeable {
    public final InputStream a() {
        return d().t();
    }

    public abstract long b();

    public abstract D c();

    public void close() {
        e.a((Closeable) d());
    }

    public abstract h d();

    public static O a(D d2, byte[] bArr) {
        f fVar = new f();
        fVar.write(bArr);
        return a(d2, (long) bArr.length, fVar);
    }

    public static O a(D d2, long j2, h hVar) {
        if (hVar != null) {
            return new N(d2, j2, hVar);
        }
        throw new NullPointerException("source == null");
    }
}
