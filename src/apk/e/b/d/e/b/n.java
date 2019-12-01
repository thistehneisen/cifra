package e.b.d.e.b;

import e.b.b.b;
import e.b.e;
import e.b.f;
import e.b.o;
import e.b.p;
import java.util.NoSuchElementException;
import k.a.d;

/* compiled from: FlowableSingleSingle */
public final class n<T> extends o<T> implements e.b.d.c.a<T> {

    /* renamed from: a reason: collision with root package name */
    final e<T> f8020a;

    /* renamed from: b reason: collision with root package name */
    final T f8021b;

    /* compiled from: FlowableSingleSingle */
    static final class a<T> implements f<T>, b {

        /* renamed from: a reason: collision with root package name */
        final p<? super T> f8022a;

        /* renamed from: b reason: collision with root package name */
        final T f8023b;

        /* renamed from: c reason: collision with root package name */
        d f8024c;

        /* renamed from: d reason: collision with root package name */
        boolean f8025d;

        /* renamed from: e reason: collision with root package name */
        T f8026e;

        a(p<? super T> pVar, T t) {
            this.f8022a = pVar;
            this.f8023b = t;
        }

        public void a(d dVar) {
            if (e.b.d.i.f.a(this.f8024c, dVar)) {
                this.f8024c = dVar;
                this.f8022a.a((b) this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        public void b() {
            this.f8024c.cancel();
            this.f8024c = e.b.d.i.f.CANCELLED;
        }

        public void c() {
            if (!this.f8025d) {
                this.f8025d = true;
                this.f8024c = e.b.d.i.f.CANCELLED;
                T t = this.f8026e;
                this.f8026e = null;
                if (t == null) {
                    t = this.f8023b;
                }
                if (t != null) {
                    this.f8022a.b(t);
                } else {
                    this.f8022a.a((Throwable) new NoSuchElementException());
                }
            }
        }

        public void a(T t) {
            if (!this.f8025d) {
                if (this.f8026e != null) {
                    this.f8025d = true;
                    this.f8024c.cancel();
                    this.f8024c = e.b.d.i.f.CANCELLED;
                    this.f8022a.a((Throwable) new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f8026e = t;
            }
        }

        public void a(Throwable th) {
            if (this.f8025d) {
                e.b.g.a.b(th);
                return;
            }
            this.f8025d = true;
            this.f8024c = e.b.d.i.f.CANCELLED;
            this.f8022a.a(th);
        }

        public boolean a() {
            return this.f8024c == e.b.d.i.f.CANCELLED;
        }
    }

    public n(e<T> eVar, T t) {
        this.f8020a = eVar;
        this.f8021b = t;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super T> pVar) {
        this.f8020a.a((f<? super T>) new a<Object>(pVar, this.f8021b));
    }

    public e<T> b() {
        return e.b.g.a.a((e<T>) new m<T>(this.f8020a, this.f8021b, true));
    }
}
