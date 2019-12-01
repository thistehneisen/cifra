package e.b.d.d;

import e.b.b.b;
import e.b.c;
import e.b.d.j.f;
import e.b.h;
import e.b.p;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingMultiObserver */
public final class d<T> extends CountDownLatch implements p<T>, c, h<T> {

    /* renamed from: a reason: collision with root package name */
    T f7977a;

    /* renamed from: b reason: collision with root package name */
    Throwable f7978b;

    /* renamed from: c reason: collision with root package name */
    b f7979c;

    /* renamed from: d reason: collision with root package name */
    volatile boolean f7980d;

    public d() {
        super(1);
    }

    public void a(b bVar) {
        this.f7979c = bVar;
        if (this.f7980d) {
            bVar.b();
        }
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        this.f7980d = true;
        b bVar = this.f7979c;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void c() {
        countDown();
    }

    public void a(Throwable th) {
        this.f7978b = th;
        countDown();
    }

    public void b(T t) {
        this.f7977a = t;
        countDown();
    }

    public T a() {
        if (getCount() != 0) {
            try {
                e.b.d.j.d.a();
                await();
            } catch (InterruptedException e2) {
                b();
                throw f.a((Throwable) e2);
            }
        }
        Throwable th = this.f7978b;
        if (th == null) {
            return this.f7977a;
        }
        throw f.a(th);
    }
}
