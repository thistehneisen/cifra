package e.a.b;

import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RealBufferedSource */
class v extends InputStream {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ w f7914a;

    v(w wVar) {
        this.f7914a = wVar;
    }

    public int available() throws IOException {
        w wVar = this.f7914a;
        if (!wVar.f7917c) {
            return (int) Math.min(wVar.f7915a.f7883c, 2147483647L);
        }
        throw new IOException(Action.CLOSED);
    }

    public void close() throws IOException {
        this.f7914a.close();
    }

    public int read() throws IOException {
        w wVar = this.f7914a;
        if (!wVar.f7917c) {
            g gVar = wVar.f7915a;
            if (gVar.f7883c == 0 && wVar.f7916b.read(gVar, 8192) == -1) {
                return -1;
            }
            return this.f7914a.f7915a.readByte() & 255;
        }
        throw new IOException(Action.CLOSED);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7914a);
        sb.append(".inputStream()");
        return sb.toString();
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f7914a.f7917c) {
            E.a((long) bArr.length, (long) i2, (long) i3);
            w wVar = this.f7914a;
            g gVar = wVar.f7915a;
            if (gVar.f7883c == 0 && wVar.f7916b.read(gVar, 8192) == -1) {
                return -1;
            }
            return this.f7914a.f7915a.a(bArr, i2, i3);
        }
        throw new IOException(Action.CLOSED);
    }
}
