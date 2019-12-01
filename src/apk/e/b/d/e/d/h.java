package e.b.d.e.d;

import e.b.b.b;
import e.b.b.c;
import e.b.o;
import e.b.p;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* compiled from: SingleFromCallable */
public final class h<T> extends o<T> {

    /* renamed from: a reason: collision with root package name */
    final Callable<? extends T> f8163a;

    public h(Callable<? extends T> callable) {
        this.f8163a = callable;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super T> pVar) {
        b b2 = c.b();
        pVar.a(b2);
        if (!b2.a()) {
            try {
                Object call = this.f8163a.call();
                e.b.d.b.b.a(call, "The callable returned a null value");
                if (!b2.a()) {
                    pVar.b(call);
                }
            } catch (Throwable th) {
                a.b(th);
                if (!b2.a()) {
                    pVar.a(th);
                } else {
                    e.b.g.a.b(th);
                }
            }
        }
    }
}
