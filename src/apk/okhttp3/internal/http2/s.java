package okhttp3.internal.http2;

import i.a.e;
import io.intercom.android.sdk.metrics.MetricTracker.Action;
import j.f;
import j.g;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Writer */
final class s implements Closeable {

    /* renamed from: a reason: collision with root package name */
    private static final Logger f10670a = Logger.getLogger(d.class.getName());

    /* renamed from: b reason: collision with root package name */
    private final g f10671b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f10672c;

    /* renamed from: d reason: collision with root package name */
    private final f f10673d = new f();

    /* renamed from: e reason: collision with root package name */
    private int f10674e = 16384;

    /* renamed from: f reason: collision with root package name */
    private boolean f10675f;

    /* renamed from: g reason: collision with root package name */
    final b f10676g = new b(this.f10673d);

    s(g gVar, boolean z) {
        this.f10671b = gVar;
        this.f10672c = z;
    }

    public synchronized void a() throws IOException {
        if (this.f10675f) {
            throw new IOException(Action.CLOSED);
        } else if (this.f10672c) {
            if (f10670a.isLoggable(Level.FINE)) {
                f10670a.fine(e.a(">> CONNECTION %s", d.f10569a.b()));
            }
            this.f10671b.write(d.f10569a.f());
            this.f10671b.flush();
        }
    }

    public int b() {
        return this.f10674e;
    }

    public synchronized void close() throws IOException {
        this.f10675f = true;
        this.f10671b.close();
    }

    public synchronized void flush() throws IOException {
        if (!this.f10675f) {
            this.f10671b.flush();
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public synchronized void b(w wVar) throws IOException {
        if (!this.f10675f) {
            int i2 = 0;
            a(0, wVar.d() * 6, 4, 0);
            while (i2 < 10) {
                if (wVar.d(i2)) {
                    int i3 = i2 == 4 ? 3 : i2 == 7 ? 4 : i2;
                    this.f10671b.writeShort(i3);
                    this.f10671b.writeInt(wVar.a(i2));
                }
                i2++;
            }
            this.f10671b.flush();
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public synchronized void a(w wVar) throws IOException {
        if (!this.f10675f) {
            this.f10674e = wVar.c(this.f10674e);
            if (wVar.b() != -1) {
                this.f10676g.a(wVar.b());
            }
            a(0, 0, 4, 1);
            this.f10671b.flush();
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    private void b(int i2, long j2) throws IOException {
        while (j2 > 0) {
            int min = (int) Math.min((long) this.f10674e, j2);
            long j3 = (long) min;
            j2 -= j3;
            a(i2, min, 9, j2 == 0 ? (byte) 4 : 0);
            this.f10671b.a(this.f10673d, j3);
        }
    }

    public synchronized void a(int i2, int i3, List<b> list) throws IOException {
        if (!this.f10675f) {
            this.f10676g.a(list);
            long size = this.f10673d.size();
            int min = (int) Math.min((long) (this.f10674e - 4), size);
            long j2 = (long) min;
            int i4 = (size > j2 ? 1 : (size == j2 ? 0 : -1));
            a(i2, min + 4, 5, i4 == 0 ? (byte) 4 : 0);
            this.f10671b.writeInt(i3 & Integer.MAX_VALUE);
            this.f10671b.a(this.f10673d, j2);
            if (i4 > 0) {
                b(i2, size - j2);
            }
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public synchronized void a(int i2, a aVar) throws IOException {
        if (this.f10675f) {
            throw new IOException(Action.CLOSED);
        } else if (aVar.httpCode != -1) {
            a(i2, 4, 3, 0);
            this.f10671b.writeInt(aVar.httpCode);
            this.f10671b.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void a(boolean z, int i2, f fVar, int i3) throws IOException {
        if (!this.f10675f) {
            byte b2 = 0;
            if (z) {
                b2 = (byte) 1;
            }
            a(i2, b2, fVar, i3);
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, byte b2, f fVar, int i3) throws IOException {
        a(i2, i3, 0, b2);
        if (i3 > 0) {
            this.f10671b.a(fVar, (long) i3);
        }
    }

    public synchronized void a(boolean z, int i2, int i3) throws IOException {
        if (!this.f10675f) {
            a(0, 8, 6, z ? (byte) 1 : 0);
            this.f10671b.writeInt(i2);
            this.f10671b.writeInt(i3);
            this.f10671b.flush();
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public synchronized void a(int i2, a aVar, byte[] bArr) throws IOException {
        if (this.f10675f) {
            throw new IOException(Action.CLOSED);
        } else if (aVar.httpCode != -1) {
            a(0, bArr.length + 8, 7, 0);
            this.f10671b.writeInt(i2);
            this.f10671b.writeInt(aVar.httpCode);
            if (bArr.length > 0) {
                this.f10671b.write(bArr);
            }
            this.f10671b.flush();
        } else {
            d.a("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }

    public synchronized void a(int i2, long j2) throws IOException {
        if (this.f10675f) {
            throw new IOException(Action.CLOSED);
        } else if (j2 == 0 || j2 > 2147483647L) {
            d.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
            throw null;
        } else {
            a(i2, 4, 8, 0);
            this.f10671b.writeInt((int) j2);
            this.f10671b.flush();
        }
    }

    public void a(int i2, int i3, byte b2, byte b3) throws IOException {
        if (f10670a.isLoggable(Level.FINE)) {
            f10670a.fine(d.a(false, i2, i3, b2, b3));
        }
        int i4 = this.f10674e;
        if (i3 > i4) {
            d.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            throw null;
        } else if ((Integer.MIN_VALUE & i2) == 0) {
            a(this.f10671b, i3);
            this.f10671b.writeByte(b2 & 255);
            this.f10671b.writeByte(b3 & 255);
            this.f10671b.writeInt(i2 & Integer.MAX_VALUE);
        } else {
            d.a("reserved bit set: %s", Integer.valueOf(i2));
            throw null;
        }
    }

    private static void a(g gVar, int i2) throws IOException {
        gVar.writeByte((i2 >>> 16) & 255);
        gVar.writeByte((i2 >>> 8) & 255);
        gVar.writeByte(i2 & 255);
    }

    public synchronized void a(boolean z, int i2, List<b> list) throws IOException {
        if (!this.f10675f) {
            this.f10676g.a(list);
            long size = this.f10673d.size();
            int min = (int) Math.min((long) this.f10674e, size);
            long j2 = (long) min;
            int i3 = (size > j2 ? 1 : (size == j2 ? 0 : -1));
            byte b2 = i3 == 0 ? (byte) 4 : 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i2, min, 1, b2);
            this.f10671b.a(this.f10673d, j2);
            if (i3 > 0) {
                b(i2, size - j2);
            }
        } else {
            throw new IOException(Action.CLOSED);
        }
    }
}
