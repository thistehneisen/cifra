package e.b.d.e.b;

import e.b.b.b;
import e.b.e;
import e.b.k;
import e.b.m;
import k.a.c;

/* compiled from: FlowableFromObservable */
public final class d<T> extends e<T> {

    /* renamed from: b reason: collision with root package name */
    private final k<T> f8007b;

    /* compiled from: FlowableFromObservable */
    static final class a<T> implements m<T>, k.a.d {

        /* renamed from: a reason: collision with root package name */
        final c<? super T> f8008a;

        /* renamed from: b reason: collision with root package name */
        b f8009b;

        a(c<? super T> cVar) {
            this.f8008a = cVar;
        }

        public void a(long j2) {
        }

        public void a(Throwable th) {
            this.f8008a.a(th);
        }

        public void c() {
            this.f8008a.c();
        }

        public void cancel() {
            this.f8009b.b();
        }

        public void a(T t) {
            this.f8008a.a(t);
        }

        public void a(b bVar) {
            this.f8009b = bVar;
            this.f8008a.a((k.a.d) this);
        }
    }

    public d(k<T> kVar) {
        this.f8007b = kVar;
    }

    /* access modifiers changed from: protected */
    public void b(c<? super T> cVar) {
        this.f8007b.a((m<? super T>) new a<Object>(cVar));
    }
}
