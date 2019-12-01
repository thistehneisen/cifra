package e.b.d.e.c;

import e.b.b.b;
import e.b.d.c.h;
import e.b.d.e.c.s.a;
import e.b.k;
import e.b.m;

/* compiled from: ObservableJust */
public final class n<T> extends k<T> implements h<T> {

    /* renamed from: a reason: collision with root package name */
    private final T f8100a;

    public n(T t) {
        this.f8100a = t;
    }

    /* access modifiers changed from: protected */
    public void b(m<? super T> mVar) {
        a aVar = new a(mVar, this.f8100a);
        mVar.a((b) aVar);
        aVar.run();
    }

    public T call() {
        return this.f8100a;
    }
}
