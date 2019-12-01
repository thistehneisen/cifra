package i.a.d;

import i.G;
import i.H;
import i.a.f.a;
import i.a.f.b;
import i.a.f.c;
import j.f;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: Platform */
public class e {

    /* renamed from: a reason: collision with root package name */
    private static final e f8651a = d();

    /* renamed from: b reason: collision with root package name */
    private static final Logger f8652b = Logger.getLogger(G.class.getName());

    public static e a() {
        return f8651a;
    }

    static byte[] b(List<H> list) {
        f fVar = new f();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h2 = (H) list.get(i2);
            if (h2 != H.HTTP_1_0) {
                fVar.writeByte(h2.toString().length());
                fVar.a(h2.toString());
            }
        }
        return fVar.c();
    }

    public static boolean c() {
        if ("conscrypt".equals(i.a.e.a("okhttp.platform", (String) null))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    private static e d() {
        e d2 = a.d();
        if (d2 != null) {
            return d2;
        }
        if (c()) {
            b d3 = b.d();
            if (d3 != null) {
                return d3;
            }
        }
        d d4 = d.d();
        if (d4 != null) {
            return d4;
        }
        e d5 = c.d();
        if (d5 != null) {
            return d5;
        }
        return new e();
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<H> list) {
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public boolean b(String str) {
        return true;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        socket.connect(inetSocketAddress, i2);
    }

    public void a(int i2, String str, Throwable th) {
        f8652b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (f8652b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
            str = sb.toString();
        }
        a(5, str, (Throwable) obj);
    }

    public SSLContext b() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    public static List<String> a(List<H> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h2 = (H) list.get(i2);
            if (h2 != H.HTTP_1_0) {
                arrayList.add(h2.toString());
            }
        }
        return arrayList;
    }

    public i.a.f.e b(X509TrustManager x509TrustManager) {
        return new b(x509TrustManager.getAcceptedIssuers());
    }

    public c a(X509TrustManager x509TrustManager) {
        return new a(b(x509TrustManager));
    }
}
