package okhttp3.internal.connection;

import i.C0721j;
import i.J;
import i.M;
import i.O;
import i.a.b.c;
import i.a.b.i;
import i.x;
import io.intercom.android.sdk.metrics.MetricTracker.Action;
import j.A;
import j.f;
import j.j;
import j.k;
import j.r;
import j.z;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: Exchange */
public final class d {

    /* renamed from: a reason: collision with root package name */
    final k f10460a;

    /* renamed from: b reason: collision with root package name */
    final C0721j f10461b;

    /* renamed from: c reason: collision with root package name */
    final x f10462c;

    /* renamed from: d reason: collision with root package name */
    final e f10463d;

    /* renamed from: e reason: collision with root package name */
    final c f10464e;

    /* renamed from: f reason: collision with root package name */
    private boolean f10465f;

    /* compiled from: Exchange */
    private final class a extends j {

        /* renamed from: b reason: collision with root package name */
        private boolean f10466b;

        /* renamed from: c reason: collision with root package name */
        private long f10467c;

        /* renamed from: d reason: collision with root package name */
        private long f10468d;

        /* renamed from: e reason: collision with root package name */
        private boolean f10469e;

        a(z zVar, long j2) {
            super(zVar);
            this.f10467c = j2;
        }

        public void a(f fVar, long j2) throws IOException {
            if (!this.f10469e) {
                long j3 = this.f10467c;
                if (j3 == -1 || this.f10468d + j2 <= j3) {
                    try {
                        super.a(fVar, j2);
                        this.f10468d += j2;
                    } catch (IOException e2) {
                        throw a(e2);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("expected ");
                    sb.append(this.f10467c);
                    sb.append(" bytes but received ");
                    sb.append(this.f10468d + j2);
                    throw new ProtocolException(sb.toString());
                }
            } else {
                throw new IllegalStateException(Action.CLOSED);
            }
        }

        public void close() throws IOException {
            if (!this.f10469e) {
                this.f10469e = true;
                long j2 = this.f10467c;
                if (j2 == -1 || this.f10468d == j2) {
                    try {
                        super.close();
                        a(null);
                    } catch (IOException e2) {
                        throw a(e2);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e2) {
                throw a(e2);
            }
        }

        private IOException a(IOException iOException) {
            if (this.f10466b) {
                return iOException;
            }
            this.f10466b = true;
            return d.this.a(this.f10468d, false, true, iOException);
        }
    }

    /* compiled from: Exchange */
    final class b extends k {

        /* renamed from: b reason: collision with root package name */
        private final long f10471b;

        /* renamed from: c reason: collision with root package name */
        private long f10472c;

        /* renamed from: d reason: collision with root package name */
        private boolean f10473d;

        /* renamed from: e reason: collision with root package name */
        private boolean f10474e;

        b(A a2, long j2) {
            super(a2);
            this.f10471b = j2;
            if (j2 == 0) {
                a(null);
            }
        }

        /* access modifiers changed from: 0000 */
        public IOException a(IOException iOException) {
            if (this.f10473d) {
                return iOException;
            }
            this.f10473d = true;
            return d.this.a(this.f10472c, true, false, iOException);
        }

        public long b(f fVar, long j2) throws IOException {
            if (!this.f10474e) {
                try {
                    long b2 = a().b(fVar, j2);
                    if (b2 == -1) {
                        a(null);
                        return -1;
                    }
                    long j3 = this.f10472c + b2;
                    if (this.f10471b != -1) {
                        if (j3 > this.f10471b) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("expected ");
                            sb.append(this.f10471b);
                            sb.append(" bytes but received ");
                            sb.append(j3);
                            throw new ProtocolException(sb.toString());
                        }
                    }
                    this.f10472c = j3;
                    if (j3 == this.f10471b) {
                        a(null);
                    }
                    return b2;
                } catch (IOException e2) {
                    throw a(e2);
                }
            } else {
                throw new IllegalStateException(Action.CLOSED);
            }
        }

        public void close() throws IOException {
            if (!this.f10474e) {
                this.f10474e = true;
                try {
                    super.close();
                    a(null);
                } catch (IOException e2) {
                    throw a(e2);
                }
            }
        }
    }

    public d(k kVar, C0721j jVar, x xVar, e eVar, c cVar) {
        this.f10460a = kVar;
        this.f10461b = jVar;
        this.f10462c = xVar;
        this.f10463d = eVar;
        this.f10464e = cVar;
    }

    public void a(J j2) throws IOException {
        try {
            this.f10462c.d(this.f10461b);
            this.f10464e.a(j2);
            this.f10462c.a(this.f10461b, j2);
        } catch (IOException e2) {
            this.f10462c.b(this.f10461b, e2);
            a(e2);
            throw e2;
        }
    }

    public f b() {
        return this.f10464e.connection();
    }

    public void c() {
        this.f10464e.cancel();
        this.f10460a.a(this, true, true, null);
    }

    public void d() throws IOException {
        try {
            this.f10464e.finishRequest();
        } catch (IOException e2) {
            this.f10462c.b(this.f10461b, e2);
            a(e2);
            throw e2;
        }
    }

    public void e() throws IOException {
        try {
            this.f10464e.flushRequest();
        } catch (IOException e2) {
            this.f10462c.b(this.f10461b, e2);
            a(e2);
            throw e2;
        }
    }

    public boolean f() {
        return this.f10465f;
    }

    public void g() {
        this.f10464e.connection().d();
    }

    public void h() {
        this.f10460a.a(this, true, false, null);
    }

    public void i() {
        this.f10462c.f(this.f10461b);
    }

    public void b(M m) {
        this.f10462c.a(this.f10461b, m);
    }

    public z a(J j2, boolean z) throws IOException {
        this.f10465f = z;
        long a2 = j2.a().a();
        this.f10462c.c(this.f10461b);
        return new a(this.f10464e.a(j2, a2), a2);
    }

    public i.M.a a(boolean z) throws IOException {
        try {
            i.M.a readResponseHeaders = this.f10464e.readResponseHeaders(z);
            if (readResponseHeaders != null) {
                i.a.c.f8601a.a(readResponseHeaders, this);
            }
            return readResponseHeaders;
        } catch (IOException e2) {
            this.f10462c.c(this.f10461b, e2);
            a(e2);
            throw e2;
        }
    }

    public O a(M m) throws IOException {
        try {
            this.f10462c.e(this.f10461b);
            String b2 = m.b("Content-Type");
            long b3 = this.f10464e.b(m);
            return new i(b2, b3, r.a((A) new b(this.f10464e.a(m), b3)));
        } catch (IOException e2) {
            this.f10462c.c(this.f10461b, e2);
            a(e2);
            throw e2;
        }
    }

    public void a() {
        this.f10464e.cancel();
    }

    /* access modifiers changed from: 0000 */
    public void a(IOException iOException) {
        this.f10463d.d();
        this.f10464e.connection().a(iOException);
    }

    /* access modifiers changed from: 0000 */
    public IOException a(long j2, boolean z, boolean z2, IOException iOException) {
        if (iOException != null) {
            a(iOException);
        }
        if (z2) {
            if (iOException != null) {
                this.f10462c.b(this.f10461b, iOException);
            } else {
                this.f10462c.a(this.f10461b, j2);
            }
        }
        if (z) {
            if (iOException != null) {
                this.f10462c.c(this.f10461b, iOException);
            } else {
                this.f10462c.b(this.f10461b, j2);
            }
        }
        return this.f10460a.a(this, z2, z, iOException);
    }
}
