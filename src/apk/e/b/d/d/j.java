package e.b.d.d;

import e.b.b.b;
import e.b.p;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResumeSingleObserver */
public final class j<T> implements p<T> {

    /* renamed from: a reason: collision with root package name */
    final AtomicReference<b> f7981a;

    /* renamed from: b reason: collision with root package name */
    final p<? super T> f7982b;

    public j(AtomicReference<b> atomicReference, p<? super T> pVar) {
        this.f7981a = atomicReference;
        this.f7982b = pVar;
    }

    public void a(b bVar) {
        e.b.d.a.b.a(this.f7981a, bVar);
    }

    public void b(T t) {
        this.f7982b.b(t);
    }

    public void a(Throwable th) {
        this.f7982b.a(th);
    }
}
