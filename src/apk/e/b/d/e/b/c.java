package e.b.d.e.b;

import e.b.d.b.b;
import e.b.e;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* compiled from: FlowableError */
public final class c<T> extends e<T> {

    /* renamed from: b reason: collision with root package name */
    final Callable<? extends Throwable> f8006b;

    public c(Callable<? extends Throwable> callable) {
        this.f8006b = callable;
    }

    public void b(k.a.c<? super T> cVar) {
        try {
            Object call = this.f8006b.call();
            b.a(call, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            th = (Throwable) call;
        } catch (Throwable th) {
            th = th;
            a.b(th);
        }
        e.b.d.i.c.a(th, cVar);
    }
}
