package e.b.d.e.b;

import e.b.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k.a.b;
import k.a.d;

/* compiled from: FlowableRepeatWhen */
final class i<T, U> extends AtomicInteger implements f<Object>, d {
    private static final long serialVersionUID = 2827772011130406689L;
    final AtomicLong requested = new AtomicLong();
    final b<T> source;
    j<T, U> subscriber;
    final AtomicReference<d> upstream = new AtomicReference<>();

    i(b<T> bVar) {
        this.source = bVar;
    }

    public void a(d dVar) {
        e.b.d.i.f.a(this.upstream, this.requested, dVar);
    }

    public void c() {
        this.subscriber.cancel();
        this.subscriber.downstream.c();
    }

    public void cancel() {
        e.b.d.i.f.a(this.upstream);
    }

    public void a(Object obj) {
        if (getAndIncrement() == 0) {
            while (this.upstream.get() != e.b.d.i.f.CANCELLED) {
                this.source.a(this.subscriber);
                if (decrementAndGet() == 0) {
                }
            }
        }
    }

    public void a(Throwable th) {
        this.subscriber.cancel();
        this.subscriber.downstream.a(th);
    }

    public void a(long j2) {
        e.b.d.i.f.a(this.upstream, this.requested, j2);
    }
}
