package j;

import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RealBufferedSource */
class u extends InputStream {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ v f10278a;

    u(v vVar) {
        this.f10278a = vVar;
    }

    public int available() throws IOException {
        v vVar = this.f10278a;
        if (!vVar.f10281c) {
            return (int) Math.min(vVar.f10279a.f10250c, 2147483647L);
        }
        throw new IOException(Action.CLOSED);
    }

    public void close() throws IOException {
        this.f10278a.close();
    }

    public int read() throws IOException {
        v vVar = this.f10278a;
        if (!vVar.f10281c) {
            f fVar = vVar.f10279a;
            if (fVar.f10250c == 0 && vVar.f10280b.b(fVar, 8192) == -1) {
                return -1;
            }
            return this.f10278a.f10279a.readByte() & 255;
        }
        throw new IOException(Action.CLOSED);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10278a);
        sb.append(".inputStream()");
        return sb.toString();
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f10278a.f10281c) {
            D.a((long) bArr.length, (long) i2, (long) i3);
            v vVar = this.f10278a;
            f fVar = vVar.f10279a;
            if (fVar.f10250c == 0 && vVar.f10280b.b(fVar, 8192) == -1) {
                return -1;
            }
            return this.f10278a.f10279a.a(bArr, i2, i3);
        }
        throw new IOException(Action.CLOSED);
    }
}
