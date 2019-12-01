package retrofit2.adapter.rxjava2;

import e.b.b.b;
import e.b.k;
import e.b.m;
import io.reactivex.exceptions.CompositeException;
import retrofit2.u;

/* compiled from: BodyObservable */
final class a<T> extends k<T> {

    /* renamed from: a reason: collision with root package name */
    private final k<u<T>> f10967a;

    /* renamed from: retrofit2.adapter.rxjava2.a$a reason: collision with other inner class name */
    /* compiled from: BodyObservable */
    private static class C0129a<R> implements m<u<R>> {

        /* renamed from: a reason: collision with root package name */
        private final m<? super R> f10968a;

        /* renamed from: b reason: collision with root package name */
        private boolean f10969b;

        C0129a(m<? super R> mVar) {
            this.f10968a = mVar;
        }

        public void c() {
            if (!this.f10969b) {
                this.f10968a.c();
            }
        }

        public void a(b bVar) {
            this.f10968a.a(bVar);
        }

        public void a(u<R> uVar) {
            if (uVar.c()) {
                this.f10968a.a(uVar.a());
                return;
            }
            this.f10969b = true;
            HttpException httpException = new HttpException(uVar);
            try {
                this.f10968a.a((Throwable) httpException);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                e.b.g.a.b((Throwable) new CompositeException(httpException, th));
            }
        }

        public void a(Throwable th) {
            if (!this.f10969b) {
                this.f10968a.a(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            e.b.g.a.b((Throwable) assertionError);
        }
    }

    a(k<u<T>> kVar) {
        this.f10967a = kVar;
    }

    /* access modifiers changed from: protected */
    public void b(m<? super T> mVar) {
        this.f10967a.a((m<? super T>) new C0129a<Object>(mVar));
    }
}
