package e.b.d.e.d;

import e.b.d.a.c;
import e.b.d.b.b;
import e.b.o;
import e.b.p;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* compiled from: SingleError */
public final class e<T> extends o<T> {

    /* renamed from: a reason: collision with root package name */
    final Callable<? extends Throwable> f8156a;

    public e(Callable<? extends Throwable> callable) {
        this.f8156a = callable;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super T> pVar) {
        try {
            Object call = this.f8156a.call();
            b.a(call, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            th = (Throwable) call;
        } catch (Throwable th) {
            th = th;
            a.b(th);
        }
        c.a(th, pVar);
    }
}
