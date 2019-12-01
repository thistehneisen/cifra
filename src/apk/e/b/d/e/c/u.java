package e.b.d.e.c;

import e.b.b.b;
import e.b.l;
import e.b.m;
import e.b.o;
import e.b.p;
import java.util.NoSuchElementException;

/* compiled from: ObservableSingleSingle */
public final class u<T> extends o<T> {

    /* renamed from: a reason: collision with root package name */
    final l<? extends T> f8123a;

    /* renamed from: b reason: collision with root package name */
    final T f8124b;

    /* compiled from: ObservableSingleSingle */
    static final class a<T> implements m<T>, b {

        /* renamed from: a reason: collision with root package name */
        final p<? super T> f8125a;

        /* renamed from: b reason: collision with root package name */
        final T f8126b;

        /* renamed from: c reason: collision with root package name */
        b f8127c;

        /* renamed from: d reason: collision with root package name */
        T f8128d;

        /* renamed from: e reason: collision with root package name */
        boolean f8129e;

        a(p<? super T> pVar, T t) {
            this.f8125a = pVar;
            this.f8126b = t;
        }

        public void a(b bVar) {
            if (e.b.d.a.b.a(this.f8127c, bVar)) {
                this.f8127c = bVar;
                this.f8125a.a((b) this);
            }
        }

        public void b() {
            this.f8127c.b();
        }

        public void c() {
            if (!this.f8129e) {
                this.f8129e = true;
                T t = this.f8128d;
                this.f8128d = null;
                if (t == null) {
                    t = this.f8126b;
                }
                if (t != null) {
                    this.f8125a.b(t);
                } else {
                    this.f8125a.a((Throwable) new NoSuchElementException());
                }
            }
        }

        public boolean a() {
            return this.f8127c.a();
        }

        public void a(T t) {
            if (!this.f8129e) {
                if (this.f8128d != null) {
                    this.f8129e = true;
                    this.f8127c.b();
                    this.f8125a.a((Throwable) new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f8128d = t;
            }
        }

        public void a(Throwable th) {
            if (this.f8129e) {
                e.b.g.a.b(th);
                return;
            }
            this.f8129e = true;
            this.f8125a.a(th);
        }
    }

    public u(l<? extends T> lVar, T t) {
        this.f8123a = lVar;
        this.f8124b = t;
    }

    public void b(p<? super T> pVar) {
        this.f8123a.a(new a(pVar, this.f8124b));
    }
}
