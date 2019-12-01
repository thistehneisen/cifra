package i;

import java.io.Closeable;
import okhttp3.internal.connection.d;

/* compiled from: Response */
public final class M implements Closeable {

    /* renamed from: a reason: collision with root package name */
    final J f8517a;

    /* renamed from: b reason: collision with root package name */
    final H f8518b;

    /* renamed from: c reason: collision with root package name */
    final int f8519c;

    /* renamed from: d reason: collision with root package name */
    final String f8520d;

    /* renamed from: e reason: collision with root package name */
    final z f8521e;

    /* renamed from: f reason: collision with root package name */
    final A f8522f;

    /* renamed from: g reason: collision with root package name */
    final O f8523g;

    /* renamed from: h reason: collision with root package name */
    final M f8524h;

    /* renamed from: i reason: collision with root package name */
    final M f8525i;

    /* renamed from: j reason: collision with root package name */
    final M f8526j;

    /* renamed from: k reason: collision with root package name */
    final long f8527k;

    /* renamed from: l reason: collision with root package name */
    final long f8528l;
    final d m;
    private volatile C0720i n;

    /* compiled from: Response */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        J f8529a;

        /* renamed from: b reason: collision with root package name */
        H f8530b;

        /* renamed from: c reason: collision with root package name */
        int f8531c;

        /* renamed from: d reason: collision with root package name */
        String f8532d;

        /* renamed from: e reason: collision with root package name */
        z f8533e;

        /* renamed from: f reason: collision with root package name */
        i.A.a f8534f;

        /* renamed from: g reason: collision with root package name */
        O f8535g;

        /* renamed from: h reason: collision with root package name */
        M f8536h;

        /* renamed from: i reason: collision with root package name */
        M f8537i;

        /* renamed from: j reason: collision with root package name */
        M f8538j;

        /* renamed from: k reason: collision with root package name */
        long f8539k;

        /* renamed from: l reason: collision with root package name */
        long f8540l;
        d m;

        public a() {
            this.f8531c = -1;
            this.f8534f = new i.A.a();
        }

        private void d(M m2) {
            if (m2.f8523g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(J j2) {
            this.f8529a = j2;
            return this;
        }

        public a b(String str, String str2) {
            this.f8534f.c(str, str2);
            return this;
        }

        public a c(M m2) {
            if (m2 != null) {
                d(m2);
            }
            this.f8538j = m2;
            return this;
        }

        public a a(H h2) {
            this.f8530b = h2;
            return this;
        }

        public a b(M m2) {
            if (m2 != null) {
                a("networkResponse", m2);
            }
            this.f8536h = m2;
            return this;
        }

        public a a(int i2) {
            this.f8531c = i2;
            return this;
        }

        a(M m2) {
            this.f8531c = -1;
            this.f8529a = m2.f8517a;
            this.f8530b = m2.f8518b;
            this.f8531c = m2.f8519c;
            this.f8532d = m2.f8520d;
            this.f8533e = m2.f8521e;
            this.f8534f = m2.f8522f.a();
            this.f8535g = m2.f8523g;
            this.f8536h = m2.f8524h;
            this.f8537i = m2.f8525i;
            this.f8538j = m2.f8526j;
            this.f8539k = m2.f8527k;
            this.f8540l = m2.f8528l;
            this.m = m2.m;
        }

        public a a(String str) {
            this.f8532d = str;
            return this;
        }

        public a b(long j2) {
            this.f8539k = j2;
            return this;
        }

        public a a(z zVar) {
            this.f8533e = zVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f8534f.a(str, str2);
            return this;
        }

        public a a(A a2) {
            this.f8534f = a2.a();
            return this;
        }

        public a a(O o) {
            this.f8535g = o;
            return this;
        }

        public a a(M m2) {
            if (m2 != null) {
                a("cacheResponse", m2);
            }
            this.f8537i = m2;
            return this;
        }

        private void a(String str, M m2) {
            if (m2.f8523g != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(".body != null");
                throw new IllegalArgumentException(sb.toString());
            } else if (m2.f8524h != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(".networkResponse != null");
                throw new IllegalArgumentException(sb2.toString());
            } else if (m2.f8525i != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(".cacheResponse != null");
                throw new IllegalArgumentException(sb3.toString());
            } else if (m2.f8526j != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(".priorResponse != null");
                throw new IllegalArgumentException(sb4.toString());
            }
        }

        public a a(long j2) {
            this.f8540l = j2;
            return this;
        }

        /* access modifiers changed from: 0000 */
        public void a(d dVar) {
            this.m = dVar;
        }

        public M a() {
            if (this.f8529a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f8530b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f8531c < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("code < 0: ");
                sb.append(this.f8531c);
                throw new IllegalStateException(sb.toString());
            } else if (this.f8532d != null) {
                return new M(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }

    M(a aVar) {
        this.f8517a = aVar.f8529a;
        this.f8518b = aVar.f8530b;
        this.f8519c = aVar.f8531c;
        this.f8520d = aVar.f8532d;
        this.f8521e = aVar.f8533e;
        this.f8522f = aVar.f8534f.a();
        this.f8523g = aVar.f8535g;
        this.f8524h = aVar.f8536h;
        this.f8525i = aVar.f8537i;
        this.f8526j = aVar.f8538j;
        this.f8527k = aVar.f8539k;
        this.f8528l = aVar.f8540l;
        this.m = aVar.m;
    }

    public String a(String str, String str2) {
        String b2 = this.f8522f.b(str);
        return b2 != null ? b2 : str2;
    }

    public String b(String str) {
        return a(str, null);
    }

    public int c() {
        return this.f8519c;
    }

    public void close() {
        O o = this.f8523g;
        if (o != null) {
            o.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public z d() {
        return this.f8521e;
    }

    public A e() {
        return this.f8522f;
    }

    public boolean f() {
        int i2 = this.f8519c;
        return i2 >= 200 && i2 < 300;
    }

    public String g() {
        return this.f8520d;
    }

    public a h() {
        return new a(this);
    }

    public M i() {
        return this.f8526j;
    }

    public long j() {
        return this.f8528l;
    }

    public J k() {
        return this.f8517a;
    }

    public long l() {
        return this.f8527k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Response{protocol=");
        sb.append(this.f8518b);
        sb.append(", code=");
        sb.append(this.f8519c);
        sb.append(", message=");
        sb.append(this.f8520d);
        sb.append(", url=");
        sb.append(this.f8517a.g());
        sb.append('}');
        return sb.toString();
    }

    public O a() {
        return this.f8523g;
    }

    public C0720i b() {
        C0720i iVar = this.n;
        if (iVar != null) {
            return iVar;
        }
        C0720i a2 = C0720i.a(this.f8522f);
        this.n = a2;
        return a2;
    }
}
