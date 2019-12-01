package okhttp3.internal.connection;

import i.B;
import i.C;
import i.C0716e;
import i.C0721j;
import i.C0723l;
import i.C0725n;
import i.C0727p;
import i.G;
import i.H;
import i.J;
import i.J.a;
import i.L;
import i.M;
import i.P;
import i.a.c;
import i.a.e;
import i.a.f.d;
import i.x;
import i.z;
import io.fabric.sdk.android.a.b.C0730a;
import j.g;
import j.h;
import j.r;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.http2.k;
import okhttp3.internal.http2.k.b;
import okhttp3.internal.http2.p;

/* compiled from: RealConnection */
public final class f extends b implements C0725n {

    /* renamed from: b reason: collision with root package name */
    public final g f10485b;

    /* renamed from: c reason: collision with root package name */
    private final P f10486c;

    /* renamed from: d reason: collision with root package name */
    private Socket f10487d;

    /* renamed from: e reason: collision with root package name */
    private Socket f10488e;

    /* renamed from: f reason: collision with root package name */
    private z f10489f;

    /* renamed from: g reason: collision with root package name */
    private H f10490g;

    /* renamed from: h reason: collision with root package name */
    private k f10491h;

    /* renamed from: i reason: collision with root package name */
    private h f10492i;

    /* renamed from: j reason: collision with root package name */
    private g f10493j;

    /* renamed from: k reason: collision with root package name */
    boolean f10494k;

    /* renamed from: l reason: collision with root package name */
    int f10495l;
    int m;
    private int n;
    private int o = 1;
    final List<Reference<k>> p = new ArrayList();
    long q = Long.MAX_VALUE;

    public f(g gVar, P p2) {
        this.f10485b = gVar;
        this.f10486c = p2;
    }

    private J g() throws IOException {
        a aVar = new a();
        aVar.a(this.f10486c.a().k());
        aVar.a("CONNECT", (L) null);
        aVar.b("Host", e.a(this.f10486c.a().k(), true));
        aVar.b("Proxy-Connection", "Keep-Alive");
        aVar.b(C0730a.HEADER_USER_AGENT, i.a.f.a());
        J a2 = aVar.a();
        M.a aVar2 = new M.a();
        aVar2.a(a2);
        aVar2.a(H.HTTP_1_1);
        aVar2.a(407);
        aVar2.a("Preemptive Authenticate");
        aVar2.a(e.f8656d);
        aVar2.b(-1);
        aVar2.a(-1);
        aVar2.b("Proxy-Authenticate", "OkHttp-Preemptive");
        J a3 = this.f10486c.a().g().a(this.f10486c, aVar2.a());
        return a3 != null ? a3 : a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0143 A[EDGE_INSN: B:63:0x0143->B:56:0x0143 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public void a(int i2, int i3, int i4, int i5, boolean z, C0721j jVar, x xVar) {
        C0721j jVar2 = jVar;
        x xVar2 = xVar;
        if (this.f10490g == null) {
            List b2 = this.f10486c.a().b();
            c cVar = new c(b2);
            if (this.f10486c.a().j() == null) {
                if (b2.contains(C0727p.f8730f)) {
                    String g2 = this.f10486c.a().k().g();
                    if (!i.a.d.e.a().b(g2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("CLEARTEXT communication to ");
                        sb.append(g2);
                        sb.append(" not permitted by network security policy");
                        throw new RouteException(new UnknownServiceException(sb.toString()));
                    }
                } else {
                    throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            } else if (this.f10486c.a().e().contains(H.H2_PRIOR_KNOWLEDGE)) {
                throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            }
            RouteException routeException = null;
            do {
                try {
                    if (this.f10486c.c()) {
                        a(i2, i3, i4, jVar, xVar);
                        if (this.f10487d != null) {
                            int i6 = i2;
                            int i7 = i3;
                        } else if (!this.f10486c.c() && this.f10487d == null) {
                            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                        } else if (this.f10491h == null) {
                            synchronized (this.f10485b) {
                                this.o = this.f10491h.c();
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        try {
                            a(i2, i3, jVar2, xVar2);
                        } catch (IOException e2) {
                            e = e2;
                            int i8 = i5;
                            e.a(this.f10488e);
                            e.a(this.f10487d);
                            this.f10488e = null;
                            this.f10487d = null;
                            this.f10492i = null;
                            this.f10493j = null;
                            this.f10489f = null;
                            this.f10490g = null;
                            this.f10491h = null;
                            xVar.a(jVar, this.f10486c.d(), this.f10486c.b(), null, e);
                            if (routeException != null) {
                            }
                            if (z) {
                            }
                            throw routeException;
                        }
                    }
                    try {
                        a(cVar, i5, jVar2, xVar2);
                        xVar2.a(jVar2, this.f10486c.d(), this.f10486c.b(), this.f10490g);
                        if (!this.f10486c.c()) {
                        }
                        if (this.f10491h == null) {
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                } catch (IOException e4) {
                    e = e4;
                    int i9 = i2;
                    int i10 = i3;
                    int i82 = i5;
                    e.a(this.f10488e);
                    e.a(this.f10487d);
                    this.f10488e = null;
                    this.f10487d = null;
                    this.f10492i = null;
                    this.f10493j = null;
                    this.f10489f = null;
                    this.f10490g = null;
                    this.f10491h = null;
                    xVar.a(jVar, this.f10486c.d(), this.f10486c.b(), null, e);
                    if (routeException != null) {
                        routeException = new RouteException(e);
                    } else {
                        routeException.a(e);
                    }
                    if (z) {
                        break;
                    } else if (!cVar.a(e)) {
                    }
                    throw routeException;
                }
            } while (!cVar.a(e));
            throw routeException;
        }
        throw new IllegalStateException("already connected");
    }

    public z b() {
        return this.f10489f;
    }

    public boolean c() {
        return this.f10491h != null;
    }

    public void d() {
        synchronized (this.f10485b) {
            this.f10494k = true;
        }
    }

    public P e() {
        return this.f10486c;
    }

    public Socket f() {
        return this.f10488e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f10486c.a().k().g());
        sb.append(":");
        sb.append(this.f10486c.a().k().k());
        sb.append(", proxy=");
        sb.append(this.f10486c.b());
        sb.append(" hostAddress=");
        sb.append(this.f10486c.d());
        sb.append(" cipherSuite=");
        z zVar = this.f10489f;
        sb.append(zVar != null ? zVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f10490g);
        sb.append('}');
        return sb.toString();
    }

    private void a(int i2, int i3, int i4, C0721j jVar, x xVar) throws IOException {
        J g2 = g();
        B g3 = g2.g();
        int i5 = 0;
        while (i5 < 21) {
            a(i2, i3, jVar, xVar);
            g2 = a(i3, i4, g2, g3);
            if (g2 != null) {
                e.a(this.f10487d);
                this.f10487d = null;
                this.f10493j = null;
                this.f10492i = null;
                xVar.a(jVar, this.f10486c.d(), this.f10486c.b(), null);
                i5++;
            } else {
                return;
            }
        }
    }

    private void a(int i2, int i3, C0721j jVar, x xVar) throws IOException {
        Socket socket;
        Proxy b2 = this.f10486c.b();
        C0716e a2 = this.f10486c.a();
        if (b2.type() == Type.DIRECT || b2.type() == Type.HTTP) {
            socket = a2.i().createSocket();
        } else {
            socket = new Socket(b2);
        }
        this.f10487d = socket;
        xVar.a(jVar, this.f10486c.d(), b2);
        this.f10487d.setSoTimeout(i3);
        try {
            i.a.d.e.a().a(this.f10487d, this.f10486c.d(), i2);
            try {
                this.f10492i = r.a(r.b(this.f10487d));
                this.f10493j = r.a(r.a(this.f10487d));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to connect to ");
            sb.append(this.f10486c.d());
            ConnectException connectException = new ConnectException(sb.toString());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private void a(c cVar, int i2, C0721j jVar, x xVar) throws IOException {
        if (this.f10486c.a().j() != null) {
            xVar.g(jVar);
            a(cVar);
            xVar.a(jVar, this.f10489f);
            if (this.f10490g == H.HTTP_2) {
                a(i2);
            }
        } else if (this.f10486c.a().e().contains(H.H2_PRIOR_KNOWLEDGE)) {
            this.f10488e = this.f10487d;
            this.f10490g = H.H2_PRIOR_KNOWLEDGE;
            a(i2);
        } else {
            this.f10488e = this.f10487d;
            this.f10490g = H.HTTP_1_1;
        }
    }

    private void a(int i2) throws IOException {
        this.f10488e.setSoTimeout(0);
        k.a aVar = new k.a(true);
        aVar.a(this.f10488e, this.f10486c.a().k().g(), this.f10492i, this.f10493j);
        aVar.a((b) this);
        aVar.a(i2);
        this.f10491h = aVar.a();
        this.f10491h.d();
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0139 A[Catch:{ all -> 0x012f }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013f A[Catch:{ all -> 0x012f }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0142  */
    /* JADX WARNING: Unknown variable types count: 2 */
    private void a(c cVar) throws IOException {
        ? r1;
        ? r2;
        H h2;
        C0716e a2 = this.f10486c.a();
        String str = 0;
        try {
            SSLSocket sSLSocket = (SSLSocket) a2.j().createSocket(this.f10487d, a2.k().g(), a2.k().k(), true);
            try {
                C0727p a3 = cVar.a(sSLSocket);
                if (a3.c()) {
                    i.a.d.e.a().a(sSLSocket, a2.k().g(), a2.e());
                }
                sSLSocket.startHandshake();
                SSLSession session = sSLSocket.getSession();
                z a4 = z.a(session);
                if (!a2.d().verify(a2.k().g(), session)) {
                    List b2 = a4.b();
                    String str2 = "Hostname ";
                    if (!b2.isEmpty()) {
                        X509Certificate x509Certificate = (X509Certificate) b2.get(0);
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append(a2.k().g());
                        sb.append(" not verified:\n    certificate: ");
                        sb.append(C0723l.a((Certificate) x509Certificate));
                        sb.append("\n    DN: ");
                        sb.append(x509Certificate.getSubjectDN().getName());
                        sb.append("\n    subjectAltNames: ");
                        sb.append(d.a(x509Certificate));
                        throw new SSLPeerUnverifiedException(sb.toString());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(a2.k().g());
                    sb2.append(" not verified (no certificates)");
                    throw new SSLPeerUnverifiedException(sb2.toString());
                }
                a2.a().a(a2.k().g(), a4.b());
                if (a3.c()) {
                    str = i.a.d.e.a().b(sSLSocket);
                }
                this.f10488e = sSLSocket;
                this.f10492i = r.a(r.b(this.f10488e));
                this.f10493j = r.a(r.a(this.f10488e));
                this.f10489f = a4;
                if (str != 0) {
                    h2 = H.a(str);
                } else {
                    h2 = H.HTTP_1_1;
                }
                this.f10490g = h2;
                if (sSLSocket != 0) {
                    i.a.d.e.a().a(sSLSocket);
                }
            } catch (AssertionError e2) {
                e = e2;
                r2 = sSLSocket;
                try {
                    if (!e.a(e)) {
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = r2;
                    if (r1 != 0) {
                    }
                    e.a((Socket) r1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = sSLSocket;
                if (r1 != 0) {
                    i.a.d.e.a().a((SSLSocket) r1);
                }
                e.a((Socket) r1);
                throw th;
            }
        } catch (AssertionError e3) {
            e = e3;
            r2 = str;
            if (!e.a(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    private J a(int i2, int i3, J j2, B b2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("CONNECT ");
        sb.append(e.a(b2, true));
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        while (true) {
            i.a.c.b bVar = new i.a.c.b(null, null, this.f10492i, this.f10493j);
            this.f10492i.timeout().a((long) i2, TimeUnit.MILLISECONDS);
            this.f10493j.timeout().a((long) i3, TimeUnit.MILLISECONDS);
            bVar.a(j2.c(), sb2);
            bVar.finishRequest();
            M.a readResponseHeaders = bVar.readResponseHeaders(false);
            readResponseHeaders.a(j2);
            M a2 = readResponseHeaders.a();
            bVar.c(a2);
            int c2 = a2.c();
            if (c2 != 200) {
                if (c2 == 407) {
                    J a3 = this.f10486c.a().g().a(this.f10486c, a2);
                    if (a3 != null) {
                        if ("close".equalsIgnoreCase(a2.b("Connection"))) {
                            return a3;
                        }
                        j2 = a3;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unexpected response code for CONNECT: ");
                    sb3.append(a2.c());
                    throw new IOException(sb3.toString());
                }
            } else if (this.f10492i.getBuffer().o() && this.f10493j.n().o()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean a(C0716e eVar, List<P> list) {
        if (this.p.size() >= this.o || this.f10494k || !c.f8601a.a(this.f10486c.a(), eVar)) {
            return false;
        }
        if (eVar.k().g().equals(e().a().k().g())) {
            return true;
        }
        if (this.f10491h == null || list == null || !a(list) || eVar.d() != d.f8667a || !a(eVar.k())) {
            return false;
        }
        try {
            eVar.a().a(eVar.k().g(), b().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    private boolean a(List<P> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            P p2 = (P) list.get(i2);
            if (p2.b().type() == Type.DIRECT && this.f10486c.b().type() == Type.DIRECT && this.f10486c.d().equals(p2.d())) {
                return true;
            }
        }
        return false;
    }

    public boolean a(B b2) {
        if (b2.k() != this.f10486c.a().k().k()) {
            return false;
        }
        boolean z = true;
        if (!b2.g().equals(this.f10486c.a().k().g()) && (this.f10489f == null || !d.f8667a.verify(b2.g(), (X509Certificate) this.f10489f.b().get(0)))) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public i.a.b.c a(G g2, C.a aVar) throws SocketException {
        k kVar = this.f10491h;
        if (kVar != null) {
            return new p(g2, this, aVar, kVar);
        }
        this.f10488e.setSoTimeout(aVar.readTimeoutMillis());
        this.f10492i.timeout().a((long) aVar.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.f10493j.timeout().a((long) aVar.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new i.a.c.b(g2, this, this.f10492i, this.f10493j);
    }

    public void a() {
        e.a(this.f10487d);
    }

    public boolean a(boolean z) {
        int soTimeout;
        if (this.f10488e.isClosed() || this.f10488e.isInputShutdown() || this.f10488e.isOutputShutdown()) {
            return false;
        }
        k kVar = this.f10491h;
        if (kVar != null) {
            return !kVar.b();
        }
        if (z) {
            try {
                soTimeout = this.f10488e.getSoTimeout();
                this.f10488e.setSoTimeout(1);
                if (this.f10492i.o()) {
                    this.f10488e.setSoTimeout(soTimeout);
                    return false;
                }
                this.f10488e.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f10488e.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public void a(okhttp3.internal.http2.r rVar) throws IOException {
        rVar.a(okhttp3.internal.http2.a.REFUSED_STREAM, (IOException) null);
    }

    public void a(k kVar) {
        synchronized (this.f10485b) {
            this.o = kVar.c();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(IOException iOException) {
        synchronized (this.f10485b) {
            if (iOException instanceof StreamResetException) {
                okhttp3.internal.http2.a aVar = ((StreamResetException) iOException).errorCode;
                if (aVar == okhttp3.internal.http2.a.REFUSED_STREAM) {
                    this.n++;
                    if (this.n > 1) {
                        this.f10494k = true;
                        this.f10495l++;
                    }
                } else if (aVar != okhttp3.internal.http2.a.CANCEL) {
                    this.f10494k = true;
                    this.f10495l++;
                }
            } else if (!c() || (iOException instanceof ConnectionShutdownException)) {
                this.f10494k = true;
                if (this.m == 0) {
                    if (iOException != null) {
                        this.f10485b.a(this.f10486c, iOException);
                    }
                    this.f10495l++;
                }
            }
        }
    }
}
