package j;

import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource */
public final class n implements A {

    /* renamed from: a reason: collision with root package name */
    private final h f10263a;

    /* renamed from: b reason: collision with root package name */
    private final Inflater f10264b;

    /* renamed from: c reason: collision with root package name */
    private int f10265c;

    /* renamed from: d reason: collision with root package name */
    private boolean f10266d;

    n(h hVar, Inflater inflater) {
        if (hVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f10263a = hVar;
            this.f10264b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public final boolean a() throws IOException {
        if (!this.f10264b.needsInput()) {
            return false;
        }
        b();
        if (this.f10264b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f10263a.o()) {
            return true;
        } else {
            w wVar = this.f10263a.n().f10249b;
            int i2 = wVar.f10284c;
            int i3 = wVar.f10283b;
            this.f10265c = i2 - i3;
            this.f10264b.setInput(wVar.f10282a, i3, this.f10265c);
            return false;
        }
    }

    public long b(f fVar, long j2) throws IOException {
        w b2;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f10266d) {
            throw new IllegalStateException(Action.CLOSED);
        } else if (i2 == 0) {
            return 0;
        } else {
            while (true) {
                boolean a2 = a();
                try {
                    b2 = fVar.b(1);
                    int inflate = this.f10264b.inflate(b2.f10282a, b2.f10284c, (int) Math.min(j2, (long) (8192 - b2.f10284c)));
                    if (inflate > 0) {
                        b2.f10284c += inflate;
                        long j3 = (long) inflate;
                        fVar.f10250c += j3;
                        return j3;
                    } else if (this.f10264b.finished()) {
                        break;
                    } else if (this.f10264b.needsDictionary()) {
                        break;
                    } else if (a2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            b();
            if (b2.f10283b == b2.f10284c) {
                fVar.f10249b = b2.b();
                x.a(b2);
            }
            return -1;
        }
    }

    public void close() throws IOException {
        if (!this.f10266d) {
            this.f10264b.end();
            this.f10266d = true;
            this.f10263a.close();
        }
    }

    public C timeout() {
        return this.f10263a.timeout();
    }

    private void b() throws IOException {
        int i2 = this.f10265c;
        if (i2 != 0) {
            int remaining = i2 - this.f10264b.getRemaining();
            this.f10265c -= remaining;
            this.f10263a.skip((long) remaining);
        }
    }
}
