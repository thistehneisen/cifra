package i.a.c;

import i.A;
import i.B;
import i.G;
import i.J;
import i.M;
import i.a.b.j;
import io.intercom.android.sdk.metrics.MetricTracker.Action;
import j.C;
import j.g;
import j.h;
import j.l;
import j.z;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* compiled from: Http1ExchangeCodec */
public final class b implements i.a.b.c {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final G f8602a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final okhttp3.internal.connection.f f8603b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final h f8604c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public final g f8605d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public int f8606e = 0;

    /* renamed from: f reason: collision with root package name */
    private long f8607f = 262144;
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public A f8608g;

    /* compiled from: Http1ExchangeCodec */
    private abstract class a implements j.A {

        /* renamed from: a reason: collision with root package name */
        protected final l f8609a;

        /* renamed from: b reason: collision with root package name */
        protected boolean f8610b;

        private a() {
            this.f8609a = new l(b.this.f8604c.timeout());
        }

        /* access modifiers changed from: 0000 */
        public final void a() {
            if (b.this.f8606e != 6) {
                if (b.this.f8606e == 5) {
                    b.this.a(this.f8609a);
                    b.this.f8606e = 6;
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("state: ");
                sb.append(b.this.f8606e);
                throw new IllegalStateException(sb.toString());
            }
        }

        public long b(j.f fVar, long j2) throws IOException {
            try {
                return b.this.f8604c.b(fVar, j2);
            } catch (IOException e2) {
                b.this.f8603b.d();
                a();
                throw e2;
            }
        }

        public C timeout() {
            return this.f8609a;
        }
    }

    /* renamed from: i.a.c.b$b reason: collision with other inner class name */
    /* compiled from: Http1ExchangeCodec */
    private final class C0095b implements z {

        /* renamed from: a reason: collision with root package name */
        private final l f8612a = new l(b.this.f8605d.timeout());

        /* renamed from: b reason: collision with root package name */
        private boolean f8613b;

        C0095b() {
        }

        public void a(j.f fVar, long j2) throws IOException {
            if (this.f8613b) {
                throw new IllegalStateException(Action.CLOSED);
            } else if (j2 != 0) {
                b.this.f8605d.f(j2);
                String str = "\r\n";
                b.this.f8605d.a(str);
                b.this.f8605d.a(fVar, j2);
                b.this.f8605d.a(str);
            }
        }

        public synchronized void close() throws IOException {
            if (!this.f8613b) {
                this.f8613b = true;
                b.this.f8605d.a("0\r\n\r\n");
                b.this.a(this.f8612a);
                b.this.f8606e = 3;
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.f8613b) {
                b.this.f8605d.flush();
            }
        }

        public C timeout() {
            return this.f8612a;
        }
    }

    /* compiled from: Http1ExchangeCodec */
    private class c extends a {

        /* renamed from: d reason: collision with root package name */
        private final B f8615d;

        /* renamed from: e reason: collision with root package name */
        private long f8616e = -1;

        /* renamed from: f reason: collision with root package name */
        private boolean f8617f = true;

        c(B b2) {
            super();
            this.f8615d = b2;
        }

        public long b(j.f fVar, long j2) throws IOException {
            if (j2 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j2);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.f8610b) {
                throw new IllegalStateException(Action.CLOSED);
            } else if (!this.f8617f) {
                return -1;
            } else {
                long j3 = this.f8616e;
                if (j3 == 0 || j3 == -1) {
                    b();
                    if (!this.f8617f) {
                        return -1;
                    }
                }
                long b2 = super.b(fVar, Math.min(j2, this.f8616e));
                if (b2 != -1) {
                    this.f8616e -= b2;
                    return b2;
                }
                b.this.f8603b.d();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            }
        }

        public void close() throws IOException {
            if (!this.f8610b) {
                if (this.f8617f && !i.a.e.a((j.A) this, 100, TimeUnit.MILLISECONDS)) {
                    b.this.f8603b.d();
                    a();
                }
                this.f8610b = true;
            }
        }

        private void b() throws IOException {
            if (this.f8616e != -1) {
                b.this.f8604c.p();
            }
            try {
                this.f8616e = b.this.f8604c.s();
                String trim = b.this.f8604c.p().trim();
                if (this.f8616e < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("expected chunk size and optional extensions but was \"");
                    sb.append(this.f8616e);
                    sb.append(trim);
                    sb.append("\"");
                    throw new ProtocolException(sb.toString());
                } else if (this.f8616e == 0) {
                    this.f8617f = false;
                    b bVar = b.this;
                    bVar.f8608g = bVar.e();
                    i.a.b.f.a(b.this.f8602a.g(), this.f8615d, b.this.f8608g);
                    a();
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }
    }

    /* compiled from: Http1ExchangeCodec */
    private class d extends a {

        /* renamed from: d reason: collision with root package name */
        private long f8619d;

        d(long j2) {
            super();
            this.f8619d = j2;
            if (this.f8619d == 0) {
                a();
            }
        }

        public long b(j.f fVar, long j2) throws IOException {
            if (j2 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j2);
                throw new IllegalArgumentException(sb.toString());
            } else if (!this.f8610b) {
                long j3 = this.f8619d;
                if (j3 == 0) {
                    return -1;
                }
                long b2 = super.b(fVar, Math.min(j3, j2));
                if (b2 != -1) {
                    this.f8619d -= b2;
                    if (this.f8619d == 0) {
                        a();
                    }
                    return b2;
                }
                b.this.f8603b.d();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            } else {
                throw new IllegalStateException(Action.CLOSED);
            }
        }

        public void close() throws IOException {
            if (!this.f8610b) {
                if (this.f8619d != 0 && !i.a.e.a((j.A) this, 100, TimeUnit.MILLISECONDS)) {
                    b.this.f8603b.d();
                    a();
                }
                this.f8610b = true;
            }
        }
    }

    /* compiled from: Http1ExchangeCodec */
    private final class e implements z {

        /* renamed from: a reason: collision with root package name */
        private final l f8621a;

        /* renamed from: b reason: collision with root package name */
        private boolean f8622b;

        private e() {
            this.f8621a = new l(b.this.f8605d.timeout());
        }

        public void a(j.f fVar, long j2) throws IOException {
            if (!this.f8622b) {
                i.a.e.a(fVar.size(), 0, j2);
                b.this.f8605d.a(fVar, j2);
                return;
            }
            throw new IllegalStateException(Action.CLOSED);
        }

        public void close() throws IOException {
            if (!this.f8622b) {
                this.f8622b = true;
                b.this.a(this.f8621a);
                b.this.f8606e = 3;
            }
        }

        public void flush() throws IOException {
            if (!this.f8622b) {
                b.this.f8605d.flush();
            }
        }

        public C timeout() {
            return this.f8621a;
        }
    }

    /* compiled from: Http1ExchangeCodec */
    private class f extends a {

        /* renamed from: d reason: collision with root package name */
        private boolean f8624d;

        private f() {
            super();
        }

        public long b(j.f fVar, long j2) throws IOException {
            if (j2 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j2);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.f8610b) {
                throw new IllegalStateException(Action.CLOSED);
            } else if (this.f8624d) {
                return -1;
            } else {
                long b2 = super.b(fVar, j2);
                if (b2 != -1) {
                    return b2;
                }
                this.f8624d = true;
                a();
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.f8610b) {
                if (!this.f8624d) {
                    a();
                }
                this.f8610b = true;
            }
        }
    }

    public b(G g2, okhttp3.internal.connection.f fVar, h hVar, g gVar) {
        this.f8602a = g2;
        this.f8603b = fVar;
        this.f8604c = hVar;
        this.f8605d = gVar;
    }

    public void cancel() {
        okhttp3.internal.connection.f fVar = this.f8603b;
        if (fVar != null) {
            fVar.a();
        }
    }

    public okhttp3.internal.connection.f connection() {
        return this.f8603b;
    }

    public void finishRequest() throws IOException {
        this.f8605d.flush();
    }

    public void flushRequest() throws IOException {
        this.f8605d.flush();
    }

    public i.M.a readResponseHeaders(boolean z) throws IOException {
        int i2 = this.f8606e;
        if (i2 == 1 || i2 == 3) {
            try {
                i.a.b.l a2 = i.a.b.l.a(d());
                i.M.a aVar = new i.M.a();
                aVar.a(a2.f8598a);
                aVar.a(a2.f8599b);
                aVar.a(a2.f8600c);
                aVar.a(e());
                if (z && a2.f8599b == 100) {
                    return null;
                }
                if (a2.f8599b == 100) {
                    this.f8606e = 3;
                    return aVar;
                }
                this.f8606e = 4;
                return aVar;
            } catch (EOFException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected end of stream on ");
                sb.append(this.f8603b.e().a().k().m());
                throw new IOException(sb.toString(), e2);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("state: ");
            sb2.append(this.f8606e);
            throw new IllegalStateException(sb2.toString());
        }
    }

    private j.A c() {
        if (this.f8606e == 4) {
            this.f8606e = 5;
            this.f8603b.d();
            return new f();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f8606e);
        throw new IllegalStateException(sb.toString());
    }

    private String d() throws IOException {
        String c2 = this.f8604c.c(this.f8607f);
        this.f8607f -= (long) c2.length();
        return c2;
    }

    /* access modifiers changed from: private */
    public A e() throws IOException {
        i.A.a aVar = new i.A.a();
        while (true) {
            String d2 = d();
            if (d2.length() == 0) {
                return aVar.a();
            }
            i.a.c.f8601a.a(aVar, d2);
        }
    }

    public long b(M m) {
        if (!i.a.b.f.b(m)) {
            return 0;
        }
        if ("chunked".equalsIgnoreCase(m.b("Transfer-Encoding"))) {
            return -1;
        }
        return i.a.b.f.a(m);
    }

    private z b() {
        if (this.f8606e == 1) {
            this.f8606e = 2;
            return new e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f8606e);
        throw new IllegalStateException(sb.toString());
    }

    public z a(J j2, long j3) throws IOException {
        if (j2.a() == null || !j2.a().c()) {
            if ("chunked".equalsIgnoreCase(j2.a("Transfer-Encoding"))) {
                return a();
            }
            if (j3 != -1) {
                return b();
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        throw new ProtocolException("Duplex connections are not supported for HTTP/1");
    }

    public void c(M m) throws IOException {
        long a2 = i.a.b.f.a(m);
        if (a2 != -1) {
            j.A a3 = a(a2);
            i.a.e.b(a3, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            a3.close();
        }
    }

    public void a(J j2) throws IOException {
        a(j2.c(), j.a(j2, this.f8603b.e().b().type()));
    }

    public j.A a(M m) {
        if (!i.a.b.f.b(m)) {
            return a(0);
        }
        if ("chunked".equalsIgnoreCase(m.b("Transfer-Encoding"))) {
            return a(m.k().g());
        }
        long a2 = i.a.b.f.a(m);
        if (a2 != -1) {
            return a(a2);
        }
        return c();
    }

    public void a(A a2, String str) throws IOException {
        if (this.f8606e == 0) {
            String str2 = "\r\n";
            this.f8605d.a(str).a(str2);
            int b2 = a2.b();
            for (int i2 = 0; i2 < b2; i2++) {
                this.f8605d.a(a2.a(i2)).a(": ").a(a2.b(i2)).a(str2);
            }
            this.f8605d.a(str2);
            this.f8606e = 1;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f8606e);
        throw new IllegalStateException(sb.toString());
    }

    private z a() {
        if (this.f8606e == 1) {
            this.f8606e = 2;
            return new C0095b();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f8606e);
        throw new IllegalStateException(sb.toString());
    }

    private j.A a(long j2) {
        if (this.f8606e == 4) {
            this.f8606e = 5;
            return new d(j2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f8606e);
        throw new IllegalStateException(sb.toString());
    }

    private j.A a(B b2) {
        if (this.f8606e == 4) {
            this.f8606e = 5;
            return new c(b2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f8606e);
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: private */
    public void a(l lVar) {
        C g2 = lVar.g();
        lVar.a(C.f10230a);
        g2.a();
        g2.b();
    }
}
