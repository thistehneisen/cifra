package retrofit2.adapter.rxjava2;

import e.b.k;
import e.b.m;
import io.reactivex.exceptions.CompositeException;
import retrofit2.d;
import retrofit2.u;

/* compiled from: CallEnqueueObservable */
final class b<T> extends k<u<T>> {

    /* renamed from: a reason: collision with root package name */
    private final retrofit2.b<T> f10970a;

    /* compiled from: CallEnqueueObservable */
    private static final class a<T> implements e.b.b.b, d<T> {

        /* renamed from: a reason: collision with root package name */
        private final retrofit2.b<?> f10971a;

        /* renamed from: b reason: collision with root package name */
        private final m<? super u<T>> f10972b;

        /* renamed from: c reason: collision with root package name */
        private volatile boolean f10973c;

        /* renamed from: d reason: collision with root package name */
        boolean f10974d = false;

        a(retrofit2.b<?> bVar, m<? super u<T>> mVar) {
            this.f10971a = bVar;
            this.f10972b = mVar;
        }

        public void a(retrofit2.b<T> bVar, u<T> uVar) {
            if (!this.f10973c) {
                try {
                    this.f10972b.a(uVar);
                    if (!this.f10973c) {
                        this.f10974d = true;
                        this.f10972b.c();
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    e.b.g.a.b((Throwable) new CompositeException(th, th));
                }
            }
        }

        public void b() {
            this.f10973c = true;
            this.f10971a.cancel();
        }

        public void a(retrofit2.b<T> bVar, Throwable th) {
            if (!bVar.isCanceled()) {
                try {
                    this.f10972b.a(th);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    e.b.g.a.b((Throwable) new CompositeException(th, th2));
                }
            }
        }

        public boolean a() {
            return this.f10973c;
        }
    }

    b(retrofit2.b<T> bVar) {
        this.f10970a = bVar;
    }

    /* access modifiers changed from: protected */
    public void b(m<? super u<T>> mVar) {
        retrofit2.b clone = this.f10970a.clone();
        a aVar = new a(clone, mVar);
        mVar.a((e.b.b.b) aVar);
        clone.a(aVar);
    }
}
