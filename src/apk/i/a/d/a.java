package i.a.d;

import android.os.Build.VERSION;
import android.util.Log;
import i.H;
import i.a.f.e;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* compiled from: AndroidPlatform */
class a extends e {

    /* renamed from: c reason: collision with root package name */
    private final Class<?> f8627c;

    /* renamed from: d reason: collision with root package name */
    private final Class<?> f8628d;

    /* renamed from: e reason: collision with root package name */
    private final Method f8629e;

    /* renamed from: f reason: collision with root package name */
    private final Method f8630f;

    /* renamed from: g reason: collision with root package name */
    private final Method f8631g;

    /* renamed from: h reason: collision with root package name */
    private final Method f8632h;

    /* renamed from: i reason: collision with root package name */
    private final b f8633i = b.a();

    /* renamed from: i.a.d.a$a reason: collision with other inner class name */
    /* compiled from: AndroidPlatform */
    static final class C0096a extends i.a.f.c {

        /* renamed from: a reason: collision with root package name */
        private final Object f8634a;

        /* renamed from: b reason: collision with root package name */
        private final Method f8635b;

        C0096a(Object obj, Method method) {
            this.f8634a = obj;
            this.f8635b = method;
        }

        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.f8635b.invoke(this.f8634a, new Object[]{x509CertificateArr, "RSA", str});
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0096a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* compiled from: AndroidPlatform */
    static final class b {

        /* renamed from: a reason: collision with root package name */
        private final Method f8636a;

        /* renamed from: b reason: collision with root package name */
        private final Method f8637b;

        /* renamed from: c reason: collision with root package name */
        private final Method f8638c;

        b(Method method, Method method2, Method method3) {
            this.f8636a = method;
            this.f8637b = method2;
            this.f8638c = method3;
        }

        /* access modifiers changed from: 0000 */
        public Object a(String str) {
            Method method = this.f8636a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f8637b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f8638c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static b a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new b(method3, method, method2);
        }
    }

    /* compiled from: AndroidPlatform */
    static final class c implements e {

        /* renamed from: a reason: collision with root package name */
        private final X509TrustManager f8639a;

        /* renamed from: b reason: collision with root package name */
        private final Method f8640b;

        c(X509TrustManager x509TrustManager, Method method) {
            this.f8640b = method;
            this.f8639a = x509TrustManager;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f8639a.equals(cVar.f8639a) || !this.f8640b.equals(cVar.f8640b)) {
                z = false;
            }
            return z;
        }

        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f8640b.invoke(this.f8639a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw new AssertionError("unable to get issues and signature", e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public int hashCode() {
            return this.f8639a.hashCode() + (this.f8640b.hashCode() * 31);
        }
    }

    a(Class<?> cls, Class<?> cls2, Method method, Method method2, Method method3, Method method4) {
        this.f8627c = cls;
        this.f8628d = cls2;
        this.f8629e = method;
        this.f8630f = method2;
        this.f8631g = method3;
        this.f8632h = method4;
    }

    public static e d() {
        try {
            Class cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            Class cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            if (VERSION.SDK_INT >= 21) {
                try {
                    Method declaredMethod = cls2.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
                    Method method = cls2.getMethod("setHostname", new Class[]{String.class});
                    Method method2 = cls2.getMethod("getAlpnSelectedProtocol", new Class[0]);
                    a aVar = new a(cls, cls2, declaredMethod, method, method2, cls2.getMethod("setAlpnProtocols", new Class[]{byte[].class}));
                    return aVar;
                } catch (NoSuchMethodException unused) {
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected Android API level 21+ but was ");
            sb.append(VERSION.SDK_INT);
            throw new IllegalStateException(sb.toString());
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e2) {
            if (i.a.e.a(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        } catch (ClassCastException e3) {
            if (VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e3);
            }
            throw e3;
        }
    }

    public String b(SSLSocket sSLSocket) {
        String str = null;
        if (!this.f8628d.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f8631g.invoke(sSLSocket, new Object[0]);
            if (bArr != null) {
                str = new String(bArr, StandardCharsets.UTF_8);
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean b(String str) {
        try {
            Class cls = Class.forName("android.security.NetworkSecurityPolicy");
            return b(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            throw new AssertionError("unable to determine cleartext support", e2);
        }
    }

    public void a(SSLSocket sSLSocket, String str, List<H> list) {
        if (this.f8628d.isInstance(sSLSocket)) {
            if (str != null) {
                try {
                    this.f8629e.invoke(sSLSocket, new Object[]{Boolean.valueOf(true)});
                    this.f8630f.invoke(sSLSocket, new Object[]{str});
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    throw new AssertionError(e2);
                }
            }
            this.f8632h.invoke(sSLSocket, new Object[]{e.b(list)});
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return a(str, cls, obj);
        }
    }

    public void a(int i2, String str, Throwable th) {
        int min;
        int i3 = 5;
        if (i2 != 5) {
            i3 = 3;
        }
        if (th != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(10);
            sb.append(Log.getStackTraceString(th));
            str = sb.toString();
        }
        int i4 = 0;
        int length = str.length();
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + 4000);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }

    public e b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new c(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    public Object a(String str) {
        return this.f8633i.a(str);
    }

    public void a(String str, Object obj) {
        if (!this.f8633i.a(obj)) {
            a(5, str, (Throwable) null);
        }
    }

    public SSLContext b() {
        boolean z = true;
        try {
            if (VERSION.SDK_INT < 16 || VERSION.SDK_INT >= 22) {
                z = false;
            }
        } catch (NoClassDefFoundError unused) {
        }
        if (z) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    public i.a.f.c a(X509TrustManager x509TrustManager) {
        try {
            Class cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0096a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }
}
