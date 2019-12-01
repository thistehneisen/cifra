package okhttp3.internal.connection;

import i.P;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: RouteDatabase */
final class h {

    /* renamed from: a reason: collision with root package name */
    private final Set<P> f10503a = new LinkedHashSet();

    h() {
    }

    public synchronized void a(P p) {
        this.f10503a.remove(p);
    }

    public synchronized void b(P p) {
        this.f10503a.add(p);
    }

    public synchronized boolean c(P p) {
        return this.f10503a.contains(p);
    }
}
