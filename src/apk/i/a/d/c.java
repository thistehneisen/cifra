package i.a.d;

import i.H;
import i.a.e;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: Jdk8WithJettyBootPlatform */
class c extends e {

    /* renamed from: c reason: collision with root package name */
    private final Method f8641c;

    /* renamed from: d reason: collision with root package name */
    private final Method f8642d;

    /* renamed from: e reason: collision with root package name */
    private final Method f8643e;

    /* renamed from: f reason: collision with root package name */
    private final Class<?> f8644f;

    /* renamed from: g reason: collision with root package name */
    private final Class<?> f8645g;

    /* compiled from: Jdk8WithJettyBootPlatform */
    private static class a implements InvocationHandler {

        /* renamed from: a reason: collision with root package name */
        private final List<String> f8646a;

        /* renamed from: b reason: collision with root package name */
        boolean f8647b;

        /* renamed from: c reason: collision with root package name */
        String f8648c;

        a(List<String> list) {
            this.f8646a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<String> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = e.f8654b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f8647b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f8646a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = (String) list.get(i2);
                        if (this.f8646a.contains(str)) {
                            this.f8648c = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f8646a.get(0);
                    this.f8648c = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f8648c = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f8641c = method;
        this.f8642d = method2;
        this.f8643e = method3;
        this.f8644f = cls;
        this.f8645g = cls2;
    }

    public static e d() {
        String str = "org.eclipse.jetty.alpn.ALPN";
        try {
            Class cls = Class.forName(str, true, null);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("$Provider");
            Class cls2 = Class.forName(sb.toString(), true, null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("$ClientProvider");
            Class cls3 = Class.forName(sb2.toString(), true, null);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("$ServerProvider");
            Class cls4 = Class.forName(sb3.toString(), true, null);
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            Method method2 = method;
            c cVar = new c(method2, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
            return cVar;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    public void a(SSLSocket sSLSocket, String str, List<H> list) {
        List a2 = e.a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f8644f, this.f8645g}, new a(a2));
            this.f8641c.invoke(null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    public String b(SSLSocket sSLSocket) {
        try {
            Object[] objArr = {sSLSocket};
            String str = null;
            a aVar = (a) Proxy.getInvocationHandler(this.f8642d.invoke(null, objArr));
            if (aVar.f8647b || aVar.f8648c != null) {
                if (!aVar.f8647b) {
                    str = aVar.f8648c;
                }
                return str;
            }
            e.a().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }

    public void a(SSLSocket sSLSocket) {
        try {
            this.f8643e.invoke(null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }
}
