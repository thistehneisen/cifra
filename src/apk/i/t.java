package i;

import i.a.e;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Dispatcher */
public final class t {

    /* renamed from: a reason: collision with root package name */
    private int f8761a = 64;

    /* renamed from: b reason: collision with root package name */
    private int f8762b = 5;

    /* renamed from: c reason: collision with root package name */
    private Runnable f8763c;

    /* renamed from: d reason: collision with root package name */
    private ExecutorService f8764d;

    /* renamed from: e reason: collision with root package name */
    private final Deque<a> f8765e = new ArrayDeque();

    /* renamed from: f reason: collision with root package name */
    private final Deque<a> f8766f = new ArrayDeque();

    /* renamed from: g reason: collision with root package name */
    private final Deque<I> f8767g = new ArrayDeque();

    private boolean c() {
        int i2;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f8765e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a aVar = (a) it.next();
                if (this.f8766f.size() >= this.f8761a) {
                    break;
                } else if (aVar.b().get() < this.f8762b) {
                    it.remove();
                    aVar.b().incrementAndGet();
                    arrayList.add(aVar);
                    this.f8766f.add(aVar);
                }
            }
            z = b() > 0;
        }
        int size = arrayList.size();
        for (i2 = 0; i2 < size; i2++) {
            ((a) arrayList.get(i2)).a(a());
        }
        return z;
    }

    public synchronized ExecutorService a() {
        if (this.f8764d == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), e.a("OkHttp Dispatcher", false));
            this.f8764d = threadPoolExecutor;
        }
        return this.f8764d;
    }

    /* access modifiers changed from: 0000 */
    public void b(a aVar) {
        aVar.b().decrementAndGet();
        a(this.f8766f, aVar);
    }

    /* access modifiers changed from: 0000 */
    public void b(I i2) {
        a(this.f8767g, i2);
    }

    public synchronized int b() {
        return this.f8766f.size() + this.f8767g.size();
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        synchronized (this) {
            this.f8765e.add(aVar);
            if (!aVar.c().f8497d) {
                a a2 = a(aVar.d());
                if (a2 != null) {
                    aVar.a(a2);
                }
            }
        }
        c();
    }

    private a a(String str) {
        for (a aVar : this.f8766f) {
            if (aVar.d().equals(str)) {
                return aVar;
            }
        }
        for (a aVar2 : this.f8765e) {
            if (aVar2.d().equals(str)) {
                return aVar2;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void a(I i2) {
        this.f8767g.add(i2);
    }

    private <T> void a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f8763c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!c() && runnable != null) {
            runnable.run();
        }
    }
}
