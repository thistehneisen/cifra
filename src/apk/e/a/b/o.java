package e.a.b;

import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource */
public final class o implements B {

    /* renamed from: a reason: collision with root package name */
    private final i f7901a;

    /* renamed from: b reason: collision with root package name */
    private final Inflater f7902b;

    /* renamed from: c reason: collision with root package name */
    private int f7903c;

    /* renamed from: d reason: collision with root package name */
    private boolean f7904d;

    o(i iVar, Inflater inflater) {
        if (iVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f7901a = iVar;
            this.f7902b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    private void b() throws IOException {
        int i2 = this.f7903c;
        if (i2 != 0) {
            int remaining = i2 - this.f7902b.getRemaining();
            this.f7903c -= remaining;
            this.f7901a.skip((long) remaining);
        }
    }

    public boolean a() throws IOException {
        if (!this.f7902b.needsInput()) {
            return false;
        }
        b();
        if (this.f7902b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f7901a.o()) {
            return true;
        } else {
            x xVar = this.f7901a.n().f7882b;
            int i2 = xVar.f7920c;
            int i3 = xVar.f7919b;
            this.f7903c = i2 - i3;
            this.f7902b.setInput(xVar.f7918a, i3, this.f7903c);
            return false;
        }
    }

    public void close() throws IOException {
        if (!this.f7904d) {
            this.f7902b.end();
            this.f7904d = true;
            this.f7901a.close();
        }
    }

    public long read(g gVar, long j2) throws IOException {
        x b2;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f7904d) {
            throw new IllegalStateException(Action.CLOSED);
        } else if (i2 == 0) {
            return 0;
        } else {
            while (true) {
                boolean a2 = a();
                try {
                    b2 = gVar.b(1);
                    int inflate = this.f7902b.inflate(b2.f7918a, b2.f7920c, (int) Math.min(j2, (long) (8192 - b2.f7920c)));
                    if (inflate > 0) {
                        b2.f7920c += inflate;
                        long j3 = (long) inflate;
                        gVar.f7883c += j3;
                        return j3;
                    } else if (this.f7902b.finished()) {
                        break;
                    } else if (this.f7902b.needsDictionary()) {
                        break;
                    } else if (a2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            b();
            if (b2.f7919b == b2.f7920c) {
                gVar.f7882b = b2.b();
                y.a(b2);
            }
            return -1;
        }
    }

    public D timeout() {
        return this.f7901a.timeout();
    }
}
