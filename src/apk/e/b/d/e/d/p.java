package e.b.d.e.d;

import e.b.c.g;
import e.b.o;
import e.b.q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleZipArray */
public final class p<T, R> extends o<R> {

    /* renamed from: a reason: collision with root package name */
    final q<? extends T>[] f8180a;

    /* renamed from: b reason: collision with root package name */
    final g<? super Object[], ? extends R> f8181b;

    /* compiled from: SingleZipArray */
    final class a implements g<T, R> {
        a() {
        }

        public R apply(T t) throws Exception {
            R apply = p.this.f8181b.apply(new Object[]{t});
            e.b.d.b.b.a(apply, "The zipper returned a null value");
            return apply;
        }
    }

    /* compiled from: SingleZipArray */
    static final class b<T, R> extends AtomicInteger implements e.b.b.b {
        private static final long serialVersionUID = -5556924161382950569L;
        final e.b.p<? super R> downstream;
        final c<T>[] observers;
        final Object[] values;
        final g<? super Object[], ? extends R> zipper;

        b(e.b.p<? super R> pVar, int i2, g<? super Object[], ? extends R> gVar) {
            super(i2);
            this.downstream = pVar;
            this.zipper = gVar;
            c<T>[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c<>(this, i3);
            }
            this.observers = cVarArr;
            this.values = new Object[i2];
        }

        public boolean a() {
            return get() <= 0;
        }

        public void b() {
            if (getAndSet(0) > 0) {
                for (c<T> a2 : this.observers) {
                    a2.a();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(T t, int i2) {
            this.values[i2] = t;
            if (decrementAndGet() == 0) {
                try {
                    Object apply = this.zipper.apply(this.values);
                    e.b.d.b.b.a(apply, "The zipper returned a null value");
                    this.downstream.b(apply);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.downstream.a(th);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2) {
            c<T>[] cVarArr = this.observers;
            int length = cVarArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3].a();
            }
            while (true) {
                i2++;
                if (i2 < length) {
                    cVarArr[i2].a();
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(Throwable th, int i2) {
            if (getAndSet(0) > 0) {
                a(i2);
                this.downstream.a(th);
                return;
            }
            e.b.g.a.b(th);
        }
    }

    /* compiled from: SingleZipArray */
    static final class c<T> extends AtomicReference<e.b.b.b> implements e.b.p<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final b<T, ?> parent;

        c(b<T, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public void a() {
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this);
        }

        public void b(T t) {
            this.parent.a(t, this.index);
        }

        public void a(e.b.b.b bVar) {
            e.b.d.a.b.b(this, bVar);
        }

        public void a(Throwable th) {
            this.parent.a(th, this.index);
        }
    }

    public p(q<? extends T>[] qVarArr, g<? super Object[], ? extends R> gVar) {
        this.f8180a = qVarArr;
        this.f8181b = gVar;
    }

    /* access modifiers changed from: protected */
    public void b(e.b.p<? super R> pVar) {
        q<? extends T>[] qVarArr = this.f8180a;
        int length = qVarArr.length;
        int i2 = 0;
        if (length == 1) {
            qVarArr[0].a(new a(pVar, new a()));
            return;
        }
        b bVar = new b(pVar, length, this.f8181b);
        pVar.a((e.b.b.b) bVar);
        while (i2 < length && !bVar.a()) {
            q<? extends T> qVar = qVarArr[i2];
            if (qVar == null) {
                bVar.a((Throwable) new NullPointerException("One of the sources is null"), i2);
                return;
            } else {
                qVar.a(bVar.observers[i2]);
                i2++;
            }
        }
    }
}
