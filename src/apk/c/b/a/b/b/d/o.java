package c.b.a.b.b.d;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class o {

    /* renamed from: a reason: collision with root package name */
    private final ConcurrentHashMap<n, List<Throwable>> f3063a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b reason: collision with root package name */
    private final ReferenceQueue<Throwable> f3064b = new ReferenceQueue<>();

    o() {
    }

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference poll = this.f3064b.poll();
        while (poll != null) {
            this.f3063a.remove(poll);
            poll = this.f3064b.poll();
        }
        List<Throwable> list = (List) this.f3063a.get(new n(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> list2 = (List) this.f3063a.putIfAbsent(new n(th, this.f3064b), vector);
        return list2 == null ? vector : list2;
    }
}
