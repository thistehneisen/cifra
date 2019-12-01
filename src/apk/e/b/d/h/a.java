package e.b.d.h;

import e.b.d.j.b;
import e.b.d.j.g;
import e.b.f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k.a.c;
import k.a.d;

/* compiled from: StrictSubscriber */
public class a<T> extends AtomicInteger implements f<T>, d {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final c<? super T> downstream;
    final b error = new b();
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<d> upstream = new AtomicReference<>();

    public a(c<? super T> cVar) {
        this.downstream = cVar;
    }

    public void a(long j2) {
        if (j2 <= 0) {
            cancel();
            StringBuilder sb = new StringBuilder();
            sb.append("§3.9 violated: positive request amount required but it was ");
            sb.append(j2);
            a((Throwable) new IllegalArgumentException(sb.toString()));
            return;
        }
        e.b.d.i.f.a(this.upstream, this.requested, j2);
    }

    public void c() {
        this.done = true;
        g.a(this.downstream, this, this.error);
    }

    public void cancel() {
        if (!this.done) {
            e.b.d.i.f.a(this.upstream);
        }
    }

    public void a(d dVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.a((d) this);
            e.b.d.i.f.a(this.upstream, this.requested, dVar);
            return;
        }
        dVar.cancel();
        cancel();
        a((Throwable) new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void a(T t) {
        g.a(this.downstream, t, (AtomicInteger) this, this.error);
    }

    public void a(Throwable th) {
        this.done = true;
        g.a(this.downstream, th, (AtomicInteger) this, this.error);
    }
}
