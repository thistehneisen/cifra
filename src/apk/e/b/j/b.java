package e.b.j;

import e.b.m;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PublishSubject */
public final class b<T> extends c<T> {

    /* renamed from: a reason: collision with root package name */
    static final a[] f8364a = new a[0];

    /* renamed from: b reason: collision with root package name */
    static final a[] f8365b = new a[0];

    /* renamed from: c reason: collision with root package name */
    final AtomicReference<a<T>[]> f8366c = new AtomicReference<>(f8365b);

    /* renamed from: d reason: collision with root package name */
    Throwable f8367d;

    /* compiled from: PublishSubject */
    static final class a<T> extends AtomicBoolean implements e.b.b.b {
        private static final long serialVersionUID = 3562861878281475070L;
        final m<? super T> downstream;
        final b<T> parent;

        a(m<? super T> mVar, b<T> bVar) {
            this.downstream = mVar;
            this.parent = bVar;
        }

        public void a(T t) {
            if (!get()) {
                this.downstream.a(t);
            }
        }

        public void b() {
            if (compareAndSet(false, true)) {
                this.parent.b(this);
            }
        }

        public void c() {
            if (!get()) {
                this.downstream.c();
            }
        }

        public void a(Throwable th) {
            if (get()) {
                e.b.g.a.b(th);
            } else {
                this.downstream.a(th);
            }
        }

        public boolean a() {
            return get();
        }
    }

    b() {
    }

    public static <T> b<T> j() {
        return new b<>();
    }

    /* access modifiers changed from: 0000 */
    public boolean a(a<T> aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f8366c.get();
            if (aVarArr == f8364a) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f8366c.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(m<? super T> mVar) {
        a aVar = new a(mVar, this);
        mVar.a((e.b.b.b) aVar);
        if (!a(aVar)) {
            Throwable th = this.f8367d;
            if (th != null) {
                mVar.a(th);
            } else {
                mVar.c();
            }
        } else if (aVar.a()) {
            b(aVar);
        }
    }

    public void c() {
        Object obj = this.f8366c.get();
        Object obj2 = f8364a;
        if (obj != obj2) {
            for (a c2 : (a[]) this.f8366c.getAndSet(obj2)) {
                c2.c();
            }
        }
    }

    public void a(e.b.b.b bVar) {
        if (this.f8366c.get() == f8364a) {
            bVar.b();
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f8366c.get();
            if (aVarArr != f8364a && aVarArr != f8365b) {
                int length = aVarArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (aVarArr[i3] == aVar) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        aVarArr2 = f8365b;
                    } else {
                        a[] aVarArr3 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                        System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            }
        } while (!this.f8366c.compareAndSet(aVarArr, aVarArr2));
    }

    public void a(T t) {
        e.b.d.b.b.a(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (a a2 : (a[]) this.f8366c.get()) {
            a2.a(t);
        }
    }

    public void a(Throwable th) {
        e.b.d.b.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object obj = this.f8366c.get();
        Object obj2 = f8364a;
        if (obj == obj2) {
            e.b.g.a.b(th);
            return;
        }
        this.f8367d = th;
        for (a a2 : (a[]) this.f8366c.getAndSet(obj2)) {
            a2.a(th);
        }
    }
}
