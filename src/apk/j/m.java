package j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource */
public final class m implements A {

    /* renamed from: a reason: collision with root package name */
    private int f10258a = 0;

    /* renamed from: b reason: collision with root package name */
    private final h f10259b;

    /* renamed from: c reason: collision with root package name */
    private final Inflater f10260c;

    /* renamed from: d reason: collision with root package name */
    private final n f10261d;

    /* renamed from: e reason: collision with root package name */
    private final CRC32 f10262e = new CRC32();

    public m(A a2) {
        if (a2 != null) {
            this.f10260c = new Inflater(true);
            this.f10259b = r.a(a2);
            this.f10261d = new n(this.f10259b, this.f10260c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a() throws IOException {
        this.f10259b.e(10);
        byte h2 = this.f10259b.n().h(3);
        boolean z = ((h2 >> 1) & 1) == 1;
        if (z) {
            a(this.f10259b.n(), 0, 10);
        }
        a("ID1ID2", 8075, (int) this.f10259b.readShort());
        this.f10259b.skip(8);
        if (((h2 >> 2) & 1) == 1) {
            this.f10259b.e(2);
            if (z) {
                a(this.f10259b.n(), 0, 2);
            }
            long r = (long) this.f10259b.n().r();
            this.f10259b.e(r);
            if (z) {
                a(this.f10259b.n(), 0, r);
            }
            this.f10259b.skip(r);
        }
        if (((h2 >> 3) & 1) == 1) {
            long a2 = this.f10259b.a(0);
            if (a2 != -1) {
                if (z) {
                    a(this.f10259b.n(), 0, a2 + 1);
                }
                this.f10259b.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((h2 >> 4) & 1) == 1) {
            long a3 = this.f10259b.a(0);
            if (a3 != -1) {
                if (z) {
                    a(this.f10259b.n(), 0, a3 + 1);
                }
                this.f10259b.skip(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", (int) this.f10259b.r(), (int) (short) ((int) this.f10262e.getValue()));
            this.f10262e.reset();
        }
    }

    public long b(f fVar, long j2) throws IOException {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 == 0) {
            return 0;
        } else {
            if (this.f10258a == 0) {
                a();
                this.f10258a = 1;
            }
            if (this.f10258a == 1) {
                long j3 = fVar.f10250c;
                long b2 = this.f10261d.b(fVar, j2);
                if (b2 != -1) {
                    a(fVar, j3, b2);
                    return b2;
                }
                this.f10258a = 2;
            }
            if (this.f10258a == 2) {
                b();
                this.f10258a = 3;
                if (!this.f10259b.o()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public void close() throws IOException {
        this.f10261d.close();
    }

    public C timeout() {
        return this.f10259b.timeout();
    }

    private void b() throws IOException {
        a("CRC", this.f10259b.q(), (int) this.f10262e.getValue());
        a("ISIZE", this.f10259b.q(), (int) this.f10260c.getBytesWritten());
    }

    private void a(f fVar, long j2, long j3) {
        w wVar = fVar.f10249b;
        while (true) {
            int i2 = wVar.f10284c;
            int i3 = wVar.f10283b;
            if (j2 < ((long) (i2 - i3))) {
                break;
            }
            j2 -= (long) (i2 - i3);
            wVar = wVar.f10287f;
        }
        while (j3 > 0) {
            int i4 = (int) (((long) wVar.f10283b) + j2);
            int min = (int) Math.min((long) (wVar.f10284c - i4), j3);
            this.f10262e.update(wVar.f10282a, i4, min);
            j3 -= (long) min;
            wVar = wVar.f10287f;
            j2 = 0;
        }
    }

    private void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}));
        }
    }
}
