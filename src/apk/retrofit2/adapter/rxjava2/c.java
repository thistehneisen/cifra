package retrofit2.adapter.rxjava2;

import e.b.k;
import e.b.m;
import io.reactivex.exceptions.CompositeException;
import retrofit2.b;
import retrofit2.u;

/* compiled from: CallExecuteObservable */
final class c<T> extends k<u<T>> {

    /* renamed from: a reason: collision with root package name */
    private final b<T> f10975a;

    /* compiled from: CallExecuteObservable */
    private static final class a implements e.b.b.b {

        /* renamed from: a reason: collision with root package name */
        private final b<?> f10976a;

        /* renamed from: b reason: collision with root package name */
        private volatile boolean f10977b;

        a(b<?> bVar) {
            this.f10976a = bVar;
        }

        public boolean a() {
            return this.f10977b;
        }

        public void b() {
            this.f10977b = true;
            this.f10976a.cancel();
        }
    }

    c(b<T> bVar) {
        this.f10975a = bVar;
    }

    /* access modifiers changed from: protected */
    public void b(m<? super u<T>> mVar) {
        boolean z;
        b clone = this.f10975a.clone();
        a aVar = new a(clone);
        mVar.a((e.b.b.b) aVar);
        try {
            u execute = clone.execute();
            if (!aVar.a()) {
                mVar.a(execute);
            }
            if (!aVar.a()) {
                try {
                    mVar.c();
                } catch (Throwable th) {
                    th = th;
                    z = true;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
            io.reactivex.exceptions.a.b(th);
            if (z) {
                e.b.g.a.b(th);
            } else if (!aVar.a()) {
                try {
                    mVar.a(th);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    e.b.g.a.b((Throwable) new CompositeException(th, th3));
                }
            }
        }
    }
}
