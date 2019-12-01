package e.b.d.g;

import e.b.n;
import e.b.n.b;
import java.util.concurrent.ThreadFactory;

/* compiled from: NewThreadScheduler */
public final class f extends n {

    /* renamed from: b reason: collision with root package name */
    private static final i f8246b = new i("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: c reason: collision with root package name */
    final ThreadFactory f8247c;

    public f() {
        this(f8246b);
    }

    public b a() {
        return new g(this.f8247c);
    }

    public f(ThreadFactory threadFactory) {
        this.f8247c = threadFactory;
    }
}
