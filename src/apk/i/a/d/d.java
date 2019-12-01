package i.a.d;

import i.H;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* compiled from: Jdk9Platform */
final class d extends e {

    /* renamed from: c reason: collision with root package name */
    final Method f8649c;

    /* renamed from: d reason: collision with root package name */
    final Method f8650d;

    d(Method method, Method method2) {
        this.f8649c = method;
        this.f8650d = method2;
    }

    public static d d() {
        try {
            return new d(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public void a(SSLSocket sSLSocket, String str, List<H> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List a2 = e.a(list);
            this.f8649c.invoke(sSLParameters, new Object[]{a2.toArray(new String[a2.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to set SSL parameters", e2);
        }
    }

    public String b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f8650d.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
