package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import k.a.b;
import k.a.c;
import k.a.d;

/* compiled from: LiveDataReactiveStreams */
public final class s {

    /* compiled from: LiveDataReactiveStreams */
    private static class a<T> extends LiveData<T> {

        /* renamed from: k reason: collision with root package name */
        private final b<T> f1666k;

        /* renamed from: l reason: collision with root package name */
        final AtomicReference<C0013a> f1667l = new AtomicReference<>();

        /* renamed from: androidx.lifecycle.s$a$a reason: collision with other inner class name */
        /* compiled from: LiveDataReactiveStreams */
        final class C0013a extends AtomicReference<d> implements c<T> {
            C0013a() {
            }

            public void a(d dVar) {
                if (compareAndSet(null, dVar)) {
                    dVar.a(Long.MAX_VALUE);
                } else {
                    dVar.cancel();
                }
            }

            public void c() {
                a.this.f1667l.compareAndSet(this, null);
            }

            public void a(T t) {
                a.this.a(t);
            }

            public void a(Throwable th) {
                a.this.f1667l.compareAndSet(this, null);
                b.b.a.a.c.b().b(new r(this, th));
            }

            public void a() {
                d dVar = (d) get();
                if (dVar != null) {
                    dVar.cancel();
                }
            }
        }

        a(b<T> bVar) {
            this.f1666k = bVar;
        }

        /* access modifiers changed from: protected */
        public void b() {
            super.b();
            C0013a aVar = new C0013a();
            this.f1667l.set(aVar);
            this.f1666k.a(aVar);
        }

        /* access modifiers changed from: protected */
        public void c() {
            super.c();
            C0013a aVar = (C0013a) this.f1667l.getAndSet(null);
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public static <T> LiveData<T> a(b<T> bVar) {
        return new a(bVar);
    }
}
