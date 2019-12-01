package e.b.d.e.b;

import e.b.d.i.b;
import e.b.e;
import e.b.f;
import java.util.NoSuchElementException;
import k.a.c;
import k.a.d;

/* compiled from: FlowableSingle */
public final class m<T> extends a<T, T> {

    /* renamed from: c reason: collision with root package name */
    final T f8018c;

    /* renamed from: d reason: collision with root package name */
    final boolean f8019d;

    /* compiled from: FlowableSingle */
    static final class a<T> extends b<T> implements f<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;
        final boolean failOnEmpty;
        d upstream;

        a(c<? super T> cVar, T t, boolean z) {
            super(cVar);
            this.defaultValue = t;
            this.failOnEmpty = z;
        }

        public void a(d dVar) {
            if (e.b.d.i.f.a(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.a((d) this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        public void c() {
            if (!this.done) {
                this.done = true;
                T t = this.value;
                this.value = null;
                if (t == null) {
                    t = this.defaultValue;
                }
                if (t != null) {
                    c(t);
                } else if (this.failOnEmpty) {
                    this.downstream.a((Throwable) new NoSuchElementException());
                } else {
                    this.downstream.c();
                }
            }
        }

        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        public void a(T t) {
            if (!this.done) {
                if (this.value != null) {
                    this.done = true;
                    this.upstream.cancel();
                    this.downstream.a((Throwable) new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.value = t;
            }
        }

        public void a(Throwable th) {
            if (this.done) {
                e.b.g.a.b(th);
                return;
            }
            this.done = true;
            this.downstream.a(th);
        }
    }

    public m(e<T> eVar, T t, boolean z) {
        super(eVar);
        this.f8018c = t;
        this.f8019d = z;
    }

    /* access modifiers changed from: protected */
    public void b(c<? super T> cVar) {
        this.f8004b.a((f<? super T>) new a<Object>(cVar, this.f8018c, this.f8019d));
    }
}
