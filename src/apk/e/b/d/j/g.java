package e.b.d.j;

import e.b.g.a;
import java.util.concurrent.atomic.AtomicInteger;
import k.a.c;

/* compiled from: HalfSerializer */
public final class g {
    public static <T> void a(c<? super T> cVar, T t, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.a(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable a2 = bVar.a();
                if (a2 != null) {
                    cVar.a(a2);
                } else {
                    cVar.c();
                }
            }
        }
    }

    public static void a(c<?> cVar, Throwable th, AtomicInteger atomicInteger, b bVar) {
        if (!bVar.a(th)) {
            a.b(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            cVar.a(bVar.a());
        }
    }

    public static void a(c<?> cVar, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable a2 = bVar.a();
            if (a2 != null) {
                cVar.a(a2);
            } else {
                cVar.c();
            }
        }
    }
}
