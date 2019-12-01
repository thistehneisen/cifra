package e.a.b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource */
public final class n implements B {

    /* renamed from: a reason: collision with root package name */
    private int f7896a = 0;

    /* renamed from: b reason: collision with root package name */
    private final i f7897b;

    /* renamed from: c reason: collision with root package name */
    private final Inflater f7898c;

    /* renamed from: d reason: collision with root package name */
    private final o f7899d;

    /* renamed from: e reason: collision with root package name */
    private final CRC32 f7900e = new CRC32();

    public n(B b2) {
        if (b2 != null) {
            this.f7898c = new Inflater(true);
            this.f7897b = t.a(b2);
            this.f7899d = new o(this.f7897b, this.f7898c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a() throws IOException {
        this.f7897b.e(10);
        byte h2 = this.f7897b.n().h(3);
        boolean z = ((h2 >> 1) & 1) == 1;
        if (z) {
            a(this.f7897b.n(), 0, 10);
        }
        a("ID1ID2", 8075, (int) this.f7897b.readShort());
        this.f7897b.skip(8);
        if (((h2 >> 2) & 1) == 1) {
            this.f7897b.e(2);
            if (z) {
                a(this.f7897b.n(), 0, 2);
            }
            long r = (long) this.f7897b.n().r();
            this.f7897b.e(r);
            if (z) {
                a(this.f7897b.n(), 0, r);
            }
            this.f7897b.skip(r);
        }
        if (((h2 >> 3) & 1) == 1) {
            long a2 = this.f7897b.a(0);
            if (a2 != -1) {
                if (z) {
                    a(this.f7897b.n(), 0, a2 + 1);
                }
                this.f7897b.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((h2 >> 4) & 1) == 1) {
            long a3 = this.f7897b.a(0);
            if (a3 != -1) {
                if (z) {
                    a(this.f7897b.n(), 0, a3 + 1);
                }
                this.f7897b.skip(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", (int) this.f7897b.r(), (int) (short) ((int) this.f7900e.getValue()));
            this.f7900e.reset();
        }
    }

    private void b() throws IOException {
        a("CRC", this.f7897b.q(), (int) this.f7900e.getValue());
        a("ISIZE", this.f7897b.q(), (int) this.f7898c.getBytesWritten());
    }

    public void close() throws IOException {
        this.f7899d.close();
    }

    public long read(g gVar, long j2) throws IOException {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 == 0) {
            return 0;
        } else {
            if (this.f7896a == 0) {
                a();
                this.f7896a = 1;
            }
            if (this.f7896a == 1) {
                long j3 = gVar.f7883c;
                long read = this.f7899d.read(gVar, j2);
                if (read != -1) {
                    a(gVar, j3, read);
                    return read;
                }
                this.f7896a = 2;
            }
            if (this.f7896a == 2) {
                b();
                this.f7896a = 3;
                if (!this.f7897b.o()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public D timeout() {
        return this.f7897b.timeout();
    }

    private void a(g gVar, long j2, long j3) {
        x xVar = gVar.f7882b;
        while (true) {
            int i2 = xVar.f7920c;
            int i3 = xVar.f7919b;
            if (j2 < ((long) (i2 - i3))) {
                break;
            }
            j2 -= (long) (i2 - i3);
            xVar = xVar.f7923f;
        }
        while (j3 > 0) {
            int i4 = (int) (((long) xVar.f7919b) + j2);
            int min = (int) Math.min((long) (xVar.f7920c - i4), j3);
            this.f7900e.update(xVar.f7918a, i4, min);
            j3 -= (long) min;
            xVar = xVar.f7923f;
            j2 = 0;
        }
    }

    private void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}));
        }
    }
}
