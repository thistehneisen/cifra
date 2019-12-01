package okhttp3.internal.connection;

import i.B;
import i.C0716e;
import i.C0721j;
import i.P;
import i.a.e;
import i.x;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: RouteSelector */
final class i {

    /* renamed from: a reason: collision with root package name */
    private final C0716e f10504a;

    /* renamed from: b reason: collision with root package name */
    private final h f10505b;

    /* renamed from: c reason: collision with root package name */
    private final C0721j f10506c;

    /* renamed from: d reason: collision with root package name */
    private final x f10507d;

    /* renamed from: e reason: collision with root package name */
    private List<Proxy> f10508e = Collections.emptyList();

    /* renamed from: f reason: collision with root package name */
    private int f10509f;

    /* renamed from: g reason: collision with root package name */
    private List<InetSocketAddress> f10510g = Collections.emptyList();

    /* renamed from: h reason: collision with root package name */
    private final List<P> f10511h = new ArrayList();

    /* compiled from: RouteSelector */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private final List<P> f10512a;

        /* renamed from: b reason: collision with root package name */
        private int f10513b = 0;

        a(List<P> list) {
            this.f10512a = list;
        }

        public List<P> a() {
            return new ArrayList(this.f10512a);
        }

        public boolean b() {
            return this.f10513b < this.f10512a.size();
        }

        public P c() {
            if (b()) {
                List<P> list = this.f10512a;
                int i2 = this.f10513b;
                this.f10513b = i2 + 1;
                return (P) list.get(i2);
            }
            throw new NoSuchElementException();
        }
    }

    i(C0716e eVar, h hVar, C0721j jVar, x xVar) {
        this.f10504a = eVar;
        this.f10505b = hVar;
        this.f10506c = jVar;
        this.f10507d = xVar;
        a(eVar.k(), eVar.f());
    }

    private boolean c() {
        return this.f10509f < this.f10508e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.f10508e;
            int i2 = this.f10509f;
            this.f10509f = i2 + 1;
            Proxy proxy = (Proxy) list.get(i2);
            a(proxy);
            return proxy;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No route to ");
        sb.append(this.f10504a.k().g());
        sb.append("; exhausted proxy configurations: ");
        sb.append(this.f10508e);
        throw new SocketException(sb.toString());
    }

    public boolean a() {
        return c() || !this.f10511h.isEmpty();
    }

    public a b() throws IOException {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy d2 = d();
                int size = this.f10510g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    P p = new P(this.f10504a, d2, (InetSocketAddress) this.f10510g.get(i2));
                    if (this.f10505b.c(p)) {
                        this.f10511h.add(p);
                    } else {
                        arrayList.add(p);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f10511h);
                this.f10511h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    private void a(B b2, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f10508e = Collections.singletonList(proxy);
        } else {
            List select = this.f10504a.h().select(b2.o());
            if (select == null || select.isEmpty()) {
                list = e.a((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = e.a(select);
            }
            this.f10508e = list;
        }
        this.f10509f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String str;
        int i2;
        this.f10510g = new ArrayList();
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            str = this.f10504a.k().g();
            i2 = this.f10504a.k().k();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = a(inetSocketAddress);
                i2 = inetSocketAddress.getPort();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Proxy.address() is not an InetSocketAddress: ");
                sb.append(address.getClass());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (i2 < 1 || i2 > 65535) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No route to ");
            sb2.append(str);
            sb2.append(":");
            sb2.append(i2);
            sb2.append("; port is out of range");
            throw new SocketException(sb2.toString());
        } else if (proxy.type() == Type.SOCKS) {
            this.f10510g.add(InetSocketAddress.createUnresolved(str, i2));
        } else {
            this.f10507d.a(this.f10506c, str);
            List lookup = this.f10504a.c().lookup(str);
            if (!lookup.isEmpty()) {
                this.f10507d.a(this.f10506c, str, lookup);
                int size = lookup.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f10510g.add(new InetSocketAddress((InetAddress) lookup.get(i3), i2));
                }
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f10504a.c());
            sb3.append(" returned no addresses for ");
            sb3.append(str);
            throw new UnknownHostException(sb3.toString());
        }
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
