package i;

import i.a.e;
import i.a.f.c;
import i.a.f.d;
import io.fabric.sdk.android.a.b.C0730a;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: OkHttpClient */
public class G implements Cloneable, i.C0721j.a, S {

    /* renamed from: a reason: collision with root package name */
    static final List<H> f8463a = e.a((T[]) new H[]{H.HTTP_2, H.HTTP_1_1});

    /* renamed from: b reason: collision with root package name */
    static final List<C0727p> f8464b = e.a((T[]) new C0727p[]{C0727p.f8728d, C0727p.f8730f});
    final int A;
    final int B;
    final int C;
    final int D;

    /* renamed from: c reason: collision with root package name */
    final t f8465c;

    /* renamed from: d reason: collision with root package name */
    final Proxy f8466d;

    /* renamed from: e reason: collision with root package name */
    final List<H> f8467e;

    /* renamed from: f reason: collision with root package name */
    final List<C0727p> f8468f;

    /* renamed from: g reason: collision with root package name */
    final List<C> f8469g;

    /* renamed from: h reason: collision with root package name */
    final List<C> f8470h;

    /* renamed from: i reason: collision with root package name */
    final i.x.a f8471i;

    /* renamed from: j reason: collision with root package name */
    final ProxySelector f8472j;

    /* renamed from: k reason: collision with root package name */
    final C0729s f8473k;

    /* renamed from: l reason: collision with root package name */
    final C0719h f8474l;
    final i.a.a.e m;
    final SocketFactory n;
    final SSLSocketFactory o;
    final c p;
    final HostnameVerifier q;
    final C0723l r;
    final C0718g s;
    final C0718g t;
    final C0726o u;
    final v v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    /* compiled from: OkHttpClient */
    public static final class a {
        int A;
        int B;

        /* renamed from: a reason: collision with root package name */
        t f8475a = new t();

        /* renamed from: b reason: collision with root package name */
        Proxy f8476b;

        /* renamed from: c reason: collision with root package name */
        List<H> f8477c = G.f8463a;

        /* renamed from: d reason: collision with root package name */
        List<C0727p> f8478d = G.f8464b;

        /* renamed from: e reason: collision with root package name */
        final List<C> f8479e = new ArrayList();

        /* renamed from: f reason: collision with root package name */
        final List<C> f8480f = new ArrayList();

        /* renamed from: g reason: collision with root package name */
        i.x.a f8481g = x.a(x.f8769a);

        /* renamed from: h reason: collision with root package name */
        ProxySelector f8482h = ProxySelector.getDefault();

        /* renamed from: i reason: collision with root package name */
        C0729s f8483i;

        /* renamed from: j reason: collision with root package name */
        C0719h f8484j;

        /* renamed from: k reason: collision with root package name */
        i.a.a.e f8485k;

        /* renamed from: l reason: collision with root package name */
        SocketFactory f8486l;
        SSLSocketFactory m;
        c n;
        HostnameVerifier o;
        C0723l p;
        C0718g q;
        C0718g r;
        C0726o s;
        v t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            if (this.f8482h == null) {
                this.f8482h = new i.a.e.a();
            }
            this.f8483i = C0729s.f8760a;
            this.f8486l = SocketFactory.getDefault();
            this.o = d.f8667a;
            this.p = C0723l.f8704a;
            C0718g gVar = C0718g.f8682a;
            this.q = gVar;
            this.r = gVar;
            this.s = new C0726o();
            this.t = v.f8768a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = C0730a.DEFAULT_TIMEOUT;
            this.z = C0730a.DEFAULT_TIMEOUT;
            this.A = C0730a.DEFAULT_TIMEOUT;
            this.B = 0;
        }

        public a a(long j2, TimeUnit timeUnit) {
            this.y = e.a("timeout", j2, timeUnit);
            return this;
        }

        public a b(long j2, TimeUnit timeUnit) {
            this.z = e.a("timeout", j2, timeUnit);
            return this;
        }

        public a c(long j2, TimeUnit timeUnit) {
            this.A = e.a("timeout", j2, timeUnit);
            return this;
        }

        public a a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            } else if (x509TrustManager != null) {
                this.m = sSLSocketFactory;
                this.n = c.a(x509TrustManager);
                return this;
            } else {
                throw new NullPointerException("trustManager == null");
            }
        }

        public a a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.o = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public a a(C0723l lVar) {
            if (lVar != null) {
                this.p = lVar;
                return this;
            }
            throw new NullPointerException("certificatePinner == null");
        }

        public a a(C c2) {
            if (c2 != null) {
                this.f8479e.add(c2);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public G a() {
            return new G(this);
        }
    }

    static {
        i.a.c.f8601a = new F();
    }

    public G() {
        this(new a());
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext b2 = i.a.d.e.a().b();
            b2.init(null, new TrustManager[]{x509TrustManager}, null);
            return b2.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS", e2);
        }
    }

    public SSLSocketFactory B() {
        return this.o;
    }

    public int C() {
        return this.C;
    }

    public int b() {
        return this.z;
    }

    public C0723l c() {
        return this.r;
    }

    public int d() {
        return this.A;
    }

    public C0726o e() {
        return this.u;
    }

    public List<C0727p> f() {
        return this.f8468f;
    }

    public C0729s g() {
        return this.f8473k;
    }

    public t h() {
        return this.f8465c;
    }

    public v i() {
        return this.v;
    }

    public i.x.a j() {
        return this.f8471i;
    }

    public boolean k() {
        return this.x;
    }

    public boolean l() {
        return this.w;
    }

    public HostnameVerifier m() {
        return this.q;
    }

    public List<C> n() {
        return this.f8469g;
    }

    /* access modifiers changed from: 0000 */
    public i.a.a.e o() {
        C0719h hVar = this.f8474l;
        return hVar != null ? hVar.f8683a : this.m;
    }

    public List<C> p() {
        return this.f8470h;
    }

    public int q() {
        return this.D;
    }

    public List<H> r() {
        return this.f8467e;
    }

    public Proxy s() {
        return this.f8466d;
    }

    public C0718g t() {
        return this.s;
    }

    public ProxySelector u() {
        return this.f8472j;
    }

    public int v() {
        return this.B;
    }

    public boolean w() {
        return this.y;
    }

    public SocketFactory x() {
        return this.n;
    }

    G(a aVar) {
        boolean z2;
        this.f8465c = aVar.f8475a;
        this.f8466d = aVar.f8476b;
        this.f8467e = aVar.f8477c;
        this.f8468f = aVar.f8478d;
        this.f8469g = e.a(aVar.f8479e);
        this.f8470h = e.a(aVar.f8480f);
        this.f8471i = aVar.f8481g;
        this.f8472j = aVar.f8482h;
        this.f8473k = aVar.f8483i;
        this.f8474l = aVar.f8484j;
        this.m = aVar.f8485k;
        this.n = aVar.f8486l;
        Iterator it = this.f8468f.iterator();
        loop0:
        while (true) {
            z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                C0727p pVar = (C0727p) it.next();
                if (z2 || pVar.b()) {
                    z2 = true;
                }
            }
        }
        if (aVar.m != null || !z2) {
            this.o = aVar.m;
            this.p = aVar.n;
        } else {
            X509TrustManager a2 = e.a();
            this.o = a(a2);
            this.p = c.a(a2);
        }
        if (this.o != null) {
            i.a.d.e.a().a(this.o);
        }
        this.q = aVar.o;
        this.r = aVar.p.a(this.p);
        this.s = aVar.q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        this.D = aVar.B;
        if (this.f8469g.contains(null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Null interceptor: ");
            sb.append(this.f8469g);
            throw new IllegalStateException(sb.toString());
        } else if (this.f8470h.contains(null)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Null network interceptor: ");
            sb2.append(this.f8470h);
            throw new IllegalStateException(sb2.toString());
        }
    }

    public C0718g a() {
        return this.t;
    }

    public C0721j a(J j2) {
        return I.a(this, j2, false);
    }
}
