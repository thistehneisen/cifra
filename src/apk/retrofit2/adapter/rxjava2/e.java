package retrofit2.adapter.rxjava2;

import e.b.b.b;
import e.b.k;
import e.b.m;
import io.reactivex.exceptions.CompositeException;
import retrofit2.u;

/* compiled from: ResultObservable */
final class e<T> extends k<d<T>> {

    /* renamed from: a reason: collision with root package name */
    private final k<u<T>> f10980a;

    /* compiled from: ResultObservable */
    private static class a<R> implements m<u<R>> {

        /* renamed from: a reason: collision with root package name */
        private final m<? super d<R>> f10981a;

        a(m<? super d<R>> mVar) {
            this.f10981a = mVar;
        }

        public void c() {
            this.f10981a.c();
        }

        public void a(b bVar) {
            this.f10981a.a(bVar);
        }

        public void a(u<R> uVar) {
            this.f10981a.a(d.a(uVar));
        }

        public void a(Throwable th) {
            try {
                this.f10981a.a(d.a(th));
                this.f10981a.c();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                e.b.g.a.b((Throwable) new CompositeException(th, th2));
            }
        }
    }

    e(k<u<T>> kVar) {
        this.f10980a = kVar;
    }

    /* access modifiers changed from: protected */
    public void b(m<? super d<T>> mVar) {
        this.f10980a.a((m<? super T>) new a<Object>(mVar));
    }
}
