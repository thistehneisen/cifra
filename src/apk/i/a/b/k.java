package i.a.b;

import com.appsflyer.share.Constants;
import i.B;
import i.C;
import i.C.a;
import i.G;
import i.J;
import i.L;
import i.M;
import i.O;
import i.P;
import i.a.c;
import i.a.e;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.d;
import okhttp3.internal.http2.ConnectionShutdownException;

/* compiled from: RetryAndFollowUpInterceptor */
public final class k implements C {

    /* renamed from: a reason: collision with root package name */
    private final G f8597a;

    public k(G g2) {
        this.f8597a = g2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b1, code lost:
        r1.d();
     */
    public M a(a aVar) throws IOException {
        J request = aVar.request();
        h hVar = (h) aVar;
        okhttp3.internal.connection.k b2 = hVar.b();
        M m = null;
        int i2 = 0;
        while (true) {
            b2.a(request);
            if (!b2.f()) {
                try {
                    M a2 = hVar.a(request, b2, null);
                    if (m != null) {
                        M.a h2 = a2.h();
                        M.a h3 = m.h();
                        h3.a((O) null);
                        h2.c(h3.a());
                        a2 = h2.a();
                    }
                    m = a2;
                    d a3 = c.f8601a.a(m);
                    J a4 = a(m, a3 != null ? a3.b().e() : null);
                    if (a4 == null) {
                        if (a3 != null && a3.f()) {
                            b2.h();
                        }
                        return m;
                    }
                    L a5 = a4.a();
                    if (a5 != null && a5.d()) {
                        return m;
                    }
                    e.a((Closeable) m.a());
                    if (b2.e()) {
                        a3.c();
                    }
                    i2++;
                    if (i2 <= 20) {
                        request = a4;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Too many follow-up requests: ");
                        sb.append(i2);
                        throw new ProtocolException(sb.toString());
                    }
                } catch (RouteException e2) {
                    if (!a(e2.b(), b2, false, request)) {
                        throw e2.a();
                    }
                } catch (IOException e3) {
                    if (!a(e3, b2, !(e3 instanceof ConnectionShutdownException), request)) {
                        throw e3;
                    }
                } catch (Throwable th) {
                    b2.d();
                    throw th;
                }
            } else {
                throw new IOException("Canceled");
            }
        }
    }

    private boolean a(IOException iOException, okhttp3.internal.connection.k kVar, boolean z, J j2) {
        if (!this.f8597a.w()) {
            return false;
        }
        if ((!z || !a(iOException, j2)) && a(iOException, z) && kVar.b()) {
            return true;
        }
        return false;
    }

    private boolean a(IOException iOException, J j2) {
        L a2 = j2.a();
        return (a2 != null && a2.d()) || (iOException instanceof FileNotFoundException);
    }

    private boolean a(IOException iOException, boolean z) {
        boolean z2 = false;
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if ((iOException instanceof SocketTimeoutException) && !z) {
                z2 = true;
            }
            return z2;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private J a(M m, P p) throws IOException {
        Proxy proxy;
        if (m != null) {
            int c2 = m.c();
            String e2 = m.k().e();
            String str = "GET";
            L l2 = null;
            if (c2 == 307 || c2 == 308) {
                if (!e2.equals(str) && !e2.equals("HEAD")) {
                    return null;
                }
            } else if (c2 == 401) {
                return this.f8597a.a().a(p, m);
            } else {
                if (c2 != 503) {
                    if (c2 == 407) {
                        if (p != null) {
                            proxy = p.b();
                        } else {
                            proxy = this.f8597a.s();
                        }
                        if (proxy.type() == Type.HTTP) {
                            return this.f8597a.t().a(p, m);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (c2 != 408) {
                        switch (c2) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.f8597a.w()) {
                        return null;
                    } else {
                        L a2 = m.k().a();
                        if (a2 != null && a2.d()) {
                            return null;
                        }
                        if ((m.i() == null || m.i().c() != 408) && a(m, 0) <= 0) {
                            return m.k();
                        }
                        return null;
                    }
                } else if ((m.i() == null || m.i().c() != 503) && a(m, Integer.MAX_VALUE) == 0) {
                    return m.k();
                } else {
                    return null;
                }
            }
            if (!this.f8597a.k()) {
                return null;
            }
            String b2 = m.b(Constants.HTTP_REDIRECT_URL_HEADER_FIELD);
            if (b2 == null) {
                return null;
            }
            B f2 = m.k().g().f(b2);
            if (f2 == null) {
                return null;
            }
            if (!f2.n().equals(m.k().g().n()) && !this.f8597a.l()) {
                return null;
            }
            J.a f3 = m.k().f();
            if (g.b(e2)) {
                boolean d2 = g.d(e2);
                if (g.c(e2)) {
                    f3.a(str, (L) null);
                } else {
                    if (d2) {
                        l2 = m.k().a();
                    }
                    f3.a(e2, l2);
                }
                if (!d2) {
                    f3.a("Transfer-Encoding");
                    f3.a("Content-Length");
                    f3.a("Content-Type");
                }
            }
            if (!e.a(m.k().g(), f2)) {
                f3.a("Authorization");
            }
            f3.a(f2);
            return f3.a();
        }
        throw new IllegalStateException();
    }

    private int a(M m, int i2) {
        String b2 = m.b("Retry-After");
        if (b2 == null) {
            return i2;
        }
        if (b2.matches("\\d+")) {
            return Integer.valueOf(b2).intValue();
        }
        return Integer.MAX_VALUE;
    }
}
