package okhttp3.internal.http2;

import i.a.e;
import j.A;
import j.C;
import j.f;
import j.h;
import j.i;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Reader */
final class q implements Closeable {

    /* renamed from: a reason: collision with root package name */
    static final Logger f10634a = Logger.getLogger(d.class.getName());

    /* renamed from: b reason: collision with root package name */
    private final h f10635b;

    /* renamed from: c reason: collision with root package name */
    private final a f10636c = new a(this.f10635b);

    /* renamed from: d reason: collision with root package name */
    private final boolean f10637d;

    /* renamed from: e reason: collision with root package name */
    final a f10638e = new a(CodedOutputStream.DEFAULT_BUFFER_SIZE, this.f10636c);

    /* compiled from: Http2Reader */
    static final class a implements A {

        /* renamed from: a reason: collision with root package name */
        private final h f10639a;

        /* renamed from: b reason: collision with root package name */
        int f10640b;

        /* renamed from: c reason: collision with root package name */
        byte f10641c;

        /* renamed from: d reason: collision with root package name */
        int f10642d;

        /* renamed from: e reason: collision with root package name */
        int f10643e;

        /* renamed from: f reason: collision with root package name */
        short f10644f;

        a(h hVar) {
            this.f10639a = hVar;
        }

        private void a() throws IOException {
            int i2 = this.f10642d;
            int a2 = q.a(this.f10639a);
            this.f10643e = a2;
            this.f10640b = a2;
            byte readByte = (byte) (this.f10639a.readByte() & 255);
            this.f10641c = (byte) (this.f10639a.readByte() & 255);
            if (q.f10634a.isLoggable(Level.FINE)) {
                q.f10634a.fine(d.a(true, this.f10642d, this.f10640b, readByte, this.f10641c));
            }
            this.f10642d = this.f10639a.readInt() & Integer.MAX_VALUE;
            if (readByte != 9) {
                d.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (this.f10642d != i2) {
                d.b("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }

        public long b(f fVar, long j2) throws IOException {
            while (true) {
                int i2 = this.f10643e;
                if (i2 == 0) {
                    this.f10639a.skip((long) this.f10644f);
                    this.f10644f = 0;
                    if ((this.f10641c & 4) != 0) {
                        return -1;
                    }
                    a();
                } else {
                    long b2 = this.f10639a.b(fVar, Math.min(j2, (long) i2));
                    if (b2 == -1) {
                        return -1;
                    }
                    this.f10643e = (int) (((long) this.f10643e) - b2);
                    return b2;
                }
            }
        }

        public void close() throws IOException {
        }

        public C timeout() {
            return this.f10639a.timeout();
        }
    }

    /* compiled from: Http2Reader */
    interface b {
        void a(int i2, a aVar);

        void a(int i2, a aVar, i iVar);

        void a(boolean z, int i2, h hVar, int i3) throws IOException;

        void a(boolean z, w wVar);

        void ackSettings();

        void headers(boolean z, int i2, int i3, List<b> list);

        void ping(boolean z, int i2, int i3);

        void priority(int i2, int i3, int i4, boolean z);

        void pushPromise(int i2, int i3, List<b> list) throws IOException;

        void windowUpdate(int i2, long j2);
    }

    q(h hVar, boolean z) {
        this.f10635b = hVar;
        this.f10637d = z;
    }

    private void b(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 < 8) {
            d.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            int readInt = this.f10635b.readInt();
            int readInt2 = this.f10635b.readInt();
            int i4 = i2 - 8;
            a b3 = a.b(readInt2);
            if (b3 != null) {
                i iVar = i.f10252b;
                if (i4 > 0) {
                    iVar = this.f10635b.b((long) i4);
                }
                bVar.a(readInt, b3, iVar);
                return;
            }
            d.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        } else {
            d.b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    private void c(b bVar, int i2, byte b2, int i3) throws IOException {
        short s = 0;
        if (i3 != 0) {
            boolean z = (b2 & 1) != 0;
            if ((b2 & 8) != 0) {
                s = (short) (this.f10635b.readByte() & 255);
            }
            if ((b2 & 32) != 0) {
                a(bVar, i3);
                i2 -= 5;
            }
            bVar.headers(z, i3, -1, a(a(i2, b2, s), s, b2, i3));
            return;
        }
        d.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    private void d(b bVar, int i2, byte b2, int i3) throws IOException {
        boolean z = false;
        if (i2 != 8) {
            d.b("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            int readInt = this.f10635b.readInt();
            int readInt2 = this.f10635b.readInt();
            if ((b2 & 1) != 0) {
                z = true;
            }
            bVar.ping(z, readInt, readInt2);
        } else {
            d.b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    private void e(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 5) {
            d.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            a(bVar, i3);
        } else {
            d.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void f(b bVar, int i2, byte b2, int i3) throws IOException {
        short s = 0;
        if (i3 != 0) {
            if ((b2 & 8) != 0) {
                s = (short) (this.f10635b.readByte() & 255);
            }
            bVar.pushPromise(i3, this.f10635b.readInt() & Integer.MAX_VALUE, a(a(i2 - 4, b2, s), s, b2, i3));
            return;
        }
        d.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    private void g(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            d.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            int readInt = this.f10635b.readInt();
            a b3 = a.b(readInt);
            if (b3 != null) {
                bVar.a(i3, b3);
                return;
            }
            d.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            throw null;
        } else {
            d.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void h(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            d.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b2 & 1) != 0) {
            if (i2 == 0) {
                bVar.ackSettings();
                return;
            }
            d.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            throw null;
        } else if (i2 % 6 == 0) {
            w wVar = new w();
            for (int i4 = 0; i4 < i2; i4 += 6) {
                short readShort = this.f10635b.readShort() & 65535;
                int readInt = this.f10635b.readInt();
                switch (readShort) {
                    case 2:
                        if (!(readInt == 0 || readInt == 1)) {
                            d.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            throw null;
                        }
                    case 3:
                        readShort = 4;
                        break;
                    case 4:
                        readShort = 7;
                        if (readInt >= 0) {
                            break;
                        } else {
                            d.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    case 5:
                        if (readInt >= 16384 && readInt <= 16777215) {
                            break;
                        } else {
                            d.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                            throw null;
                        }
                        break;
                }
                wVar.a(readShort, readInt);
            }
            bVar.a(false, wVar);
        } else {
            d.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            throw null;
        }
    }

    private void i(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 == 4) {
            long readInt = ((long) this.f10635b.readInt()) & 2147483647L;
            if (readInt != 0) {
                bVar.windowUpdate(i3, readInt);
                return;
            }
            d.b("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
        d.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
        throw null;
    }

    public void a(b bVar) throws IOException {
        if (!this.f10637d) {
            i b2 = this.f10635b.b((long) d.f10569a.size());
            if (f10634a.isLoggable(Level.FINE)) {
                f10634a.fine(e.a("<< CONNECTION %s", b2.b()));
            }
            if (!d.f10569a.equals(b2)) {
                d.b("Expected a connection header but was %s", b2.g());
                throw null;
            }
        } else if (!a(true, bVar)) {
            d.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
    }

    public void close() throws IOException {
        this.f10635b.close();
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.f10635b.e(9);
            int a2 = a(this.f10635b);
            if (a2 < 0 || a2 > 16384) {
                d.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
                throw null;
            }
            byte readByte = (byte) (this.f10635b.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.f10635b.readByte() & 255);
                int readInt = this.f10635b.readInt() & Integer.MAX_VALUE;
                if (f10634a.isLoggable(Level.FINE)) {
                    f10634a.fine(d.a(true, readInt, a2, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        a(bVar, a2, readByte2, readInt);
                        break;
                    case 1:
                        c(bVar, a2, readByte2, readInt);
                        break;
                    case 2:
                        e(bVar, a2, readByte2, readInt);
                        break;
                    case 3:
                        g(bVar, a2, readByte2, readInt);
                        break;
                    case 4:
                        h(bVar, a2, readByte2, readInt);
                        break;
                    case 5:
                        f(bVar, a2, readByte2, readInt);
                        break;
                    case 6:
                        d(bVar, a2, readByte2, readInt);
                        break;
                    case 7:
                        b(bVar, a2, readByte2, readInt);
                        break;
                    case 8:
                        i(bVar, a2, readByte2, readInt);
                        break;
                    default:
                        this.f10635b.skip((long) a2);
                        break;
                }
                return true;
            }
            d.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            throw null;
        } catch (EOFException unused) {
            return false;
        }
    }

    private List<b> a(int i2, short s, byte b2, int i3) throws IOException {
        a aVar = this.f10636c;
        aVar.f10643e = i2;
        aVar.f10640b = i2;
        aVar.f10644f = s;
        aVar.f10641c = b2;
        aVar.f10642d = i3;
        this.f10638e.c();
        return this.f10638e.a();
    }

    private void a(b bVar, int i2, byte b2, int i3) throws IOException {
        short s = 0;
        if (i3 != 0) {
            boolean z = true;
            boolean z2 = (b2 & 1) != 0;
            if ((b2 & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b2 & 8) != 0) {
                    s = (short) (this.f10635b.readByte() & 255);
                }
                bVar.a(z2, i3, this.f10635b, a(i2, b2, s));
                this.f10635b.skip((long) s);
                return;
            }
            d.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        d.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        throw null;
    }

    private void a(b bVar, int i2) throws IOException {
        int readInt = this.f10635b.readInt();
        bVar.priority(i2, readInt & Integer.MAX_VALUE, (this.f10635b.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    static int a(h hVar) throws IOException {
        return (hVar.readByte() & 255) | ((hVar.readByte() & 255) << 16) | ((hVar.readByte() & 255) << 8);
    }

    static int a(int i2, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        d.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
        throw null;
    }
}
