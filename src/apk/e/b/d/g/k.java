package e.b.d.g;

import e.b.b.b;
import e.b.d.a.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ScheduledRunnable */
public final class k extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, b {

    /* renamed from: a reason: collision with root package name */
    static final Object f8250a = new Object();

    /* renamed from: b reason: collision with root package name */
    static final Object f8251b = new Object();

    /* renamed from: c reason: collision with root package name */
    static final Object f8252c = new Object();

    /* renamed from: d reason: collision with root package name */
    static final Object f8253d = new Object();
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    public k(Runnable runnable, a aVar) {
        super(3);
        this.actual = runnable;
        lazySet(0, aVar);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != f8253d) {
                if (obj == f8251b) {
                    future.cancel(false);
                    return;
                } else if (obj == f8252c) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
    public void b() {
        Object obj;
        Object obj2;
        while (true) {
            Object obj3 = get(1);
            if (obj3 == f8253d || obj3 == f8251b || obj3 == f8252c) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (compareAndSet(1, obj3, z ? f8252c : f8251b)) {
                if (obj3 != null) {
                    ((Future) obj3).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj != f8253d) {
                obj2 = f8250a;
                if (obj == obj2 || obj == null) {
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((a) obj).c(this);
    }

    public Object call() {
        run();
        return null;
    }

    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } catch (Throwable th) {
            lazySet(2, null);
            Object obj3 = get(0);
            if (!(obj3 == f8250a || !compareAndSet(0, obj3, f8253d) || obj3 == null)) {
                ((a) obj3).c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == f8251b || obj2 == f8252c) {
                    throw th;
                }
            } while (!compareAndSet(1, obj2, f8253d));
            throw th;
        }
        lazySet(2, null);
        Object obj4 = get(0);
        if (!(obj4 == f8250a || !compareAndSet(0, obj4, f8253d) || obj4 == null)) {
            ((a) obj4).c(this);
        }
        do {
            obj = get(1);
            if (obj == f8251b || obj == f8252c) {
                return;
            }
        } while (!compareAndSet(1, obj, f8253d));
    }

    public boolean a() {
        Object obj = get(0);
        if (obj == f8250a || obj == f8253d) {
            return true;
        }
        return false;
    }
}
