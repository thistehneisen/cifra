package e.b.d.e.c;

import e.b.l;
import e.b.m;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableReplay */
public final class r<T> extends e.b.e.a<T> implements e.b.d.c.c<T>, e.b.d.a.e {

    /* renamed from: a reason: collision with root package name */
    static final b f8112a = new j();

    /* renamed from: b reason: collision with root package name */
    final l<T> f8113b;

    /* renamed from: c reason: collision with root package name */
    final AtomicReference<g<T>> f8114c;

    /* renamed from: d reason: collision with root package name */
    final b<T> f8115d;

    /* renamed from: e reason: collision with root package name */
    final l<T> f8116e;

    /* compiled from: ObservableReplay */
    static abstract class a<T> extends AtomicReference<d> implements e<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        d tail;

        a() {
            d dVar = new d(null);
            this.tail = dVar;
            set(dVar);
        }

        /* access modifiers changed from: 0000 */
        public final void a(d dVar) {
            this.tail.set(dVar);
            this.tail = dVar;
            this.size++;
        }

        /* access modifiers changed from: 0000 */
        public Object b(Object obj) {
            return obj;
        }

        /* access modifiers changed from: 0000 */
        public final void b() {
            d dVar = (d) ((d) get()).get();
            this.size--;
            b(dVar);
        }

        /* access modifiers changed from: 0000 */
        public Object c(Object obj) {
            return obj;
        }

        /* access modifiers changed from: 0000 */
        public final void c() {
            d dVar = (d) get();
            if (dVar.value != null) {
                d dVar2 = new d(null);
                dVar2.lazySet(dVar.get());
                set(dVar2);
            }
        }

        /* access modifiers changed from: 0000 */
        public abstract void d();

        public final void e() {
            a(new d(b(e.b.d.j.h.a())));
            f();
        }

        /* access modifiers changed from: 0000 */
        public void f() {
            c();
        }

        public final void a(T t) {
            e.b.d.j.h.d(t);
            a(new d(b((Object) t)));
            d();
        }

        /* access modifiers changed from: 0000 */
        public final void b(d dVar) {
            set(dVar);
        }

        public final void a(Throwable th) {
            a(new d(b(e.b.d.j.h.a(th))));
            f();
        }

        public final void a(c<T> cVar) {
            if (cVar.getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    d dVar = (d) cVar.c();
                    if (dVar == null) {
                        dVar = a();
                        cVar.index = dVar;
                    }
                    while (!cVar.a()) {
                        d dVar2 = (d) dVar.get();
                        if (dVar2 == null) {
                            cVar.index = dVar;
                            i2 = cVar.addAndGet(-i2);
                        } else if (e.b.d.j.h.a(c(dVar2.value), cVar.child)) {
                            cVar.index = null;
                            return;
                        } else {
                            dVar = dVar2;
                        }
                    }
                    cVar.index = null;
                    return;
                } while (i2 != 0);
            }
        }

        /* access modifiers changed from: 0000 */
        public d a() {
            return (d) get();
        }
    }

    /* compiled from: ObservableReplay */
    interface b<T> {
        e<T> call();
    }

    /* compiled from: ObservableReplay */
    static final class c<T> extends AtomicInteger implements e.b.b.b {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final m<? super T> child;
        Object index;
        final g<T> parent;

        c(g<T> gVar, m<? super T> mVar) {
            this.parent = gVar;
            this.child = mVar;
        }

        public boolean a() {
            return this.cancelled;
        }

        public void b() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.b(this);
                this.index = null;
            }
        }

        /* access modifiers changed from: 0000 */
        public <U> U c() {
            return this.index;
        }
    }

    /* compiled from: ObservableReplay */
    static final class d extends AtomicReference<d> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        d(Object obj) {
            this.value = obj;
        }
    }

    /* compiled from: ObservableReplay */
    interface e<T> {
        void a(c<T> cVar);

        void a(T t);

        void a(Throwable th);

        void e();
    }

    /* compiled from: ObservableReplay */
    static final class f<T> implements b<T> {

        /* renamed from: a reason: collision with root package name */
        private final int f8117a;

        f(int i2) {
            this.f8117a = i2;
        }

        public e<T> call() {
            return new i(this.f8117a);
        }
    }

    /* compiled from: ObservableReplay */
    static final class g<T> extends AtomicReference<e.b.b.b> implements m<T>, e.b.b.b {

        /* renamed from: a reason: collision with root package name */
        static final c[] f8118a = new c[0];

        /* renamed from: b reason: collision with root package name */
        static final c[] f8119b = new c[0];
        private static final long serialVersionUID = -533785617179540163L;
        final e<T> buffer;
        boolean done;
        final AtomicReference<c[]> observers = new AtomicReference<>(f8118a);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        g(e<T> eVar) {
            this.buffer = eVar;
        }

        public boolean a() {
            return this.observers.get() == f8119b;
        }

        public void b() {
            this.observers.set(f8119b);
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this);
        }

        public void c() {
            if (!this.done) {
                this.done = true;
                this.buffer.e();
                e();
            }
        }

        /* access modifiers changed from: 0000 */
        public void d() {
            for (c a2 : (c[]) this.observers.get()) {
                this.buffer.a(a2);
            }
        }

        /* access modifiers changed from: 0000 */
        public void e() {
            for (c a2 : (c[]) this.observers.getAndSet(f8119b)) {
                this.buffer.a(a2);
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean a(c<T> cVar) {
            c[] cVarArr;
            c[] cVarArr2;
            do {
                cVarArr = (c[]) this.observers.get();
                if (cVarArr == f8119b) {
                    return false;
                }
                int length = cVarArr.length;
                cVarArr2 = new c[(length + 1)];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
            } while (!this.observers.compareAndSet(cVarArr, cVarArr2));
            return true;
        }

        /* access modifiers changed from: 0000 */
        public void b(c<T> cVar) {
            c[] cVarArr;
            c[] cVarArr2;
            do {
                cVarArr = (c[]) this.observers.get();
                int length = cVarArr.length;
                if (length != 0) {
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (cVarArr[i3].equals(cVar)) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            cVarArr2 = f8118a;
                        } else {
                            c[] cVarArr3 = new c[(length - 1)];
                            System.arraycopy(cVarArr, 0, cVarArr3, 0, i2);
                            System.arraycopy(cVarArr, i2 + 1, cVarArr3, i2, (length - i2) - 1);
                            cVarArr2 = cVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(cVarArr, cVarArr2));
        }

        public void a(e.b.b.b bVar) {
            if (e.b.d.a.b.b(this, bVar)) {
                d();
            }
        }

        public void a(T t) {
            if (!this.done) {
                this.buffer.a(t);
                d();
            }
        }

        public void a(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.buffer.a(th);
                e();
                return;
            }
            e.b.g.a.b(th);
        }
    }

    /* compiled from: ObservableReplay */
    static final class h<T> implements l<T> {

        /* renamed from: a reason: collision with root package name */
        private final AtomicReference<g<T>> f8120a;

        /* renamed from: b reason: collision with root package name */
        private final b<T> f8121b;

        h(AtomicReference<g<T>> atomicReference, b<T> bVar) {
            this.f8120a = atomicReference;
            this.f8121b = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
        public void a(m<? super T> mVar) {
            g gVar;
            while (true) {
                gVar = (g) this.f8120a.get();
                if (gVar != null) {
                    break;
                }
                g gVar2 = new g(this.f8121b.call());
                if (this.f8120a.compareAndSet(null, gVar2)) {
                    gVar = gVar2;
                    break;
                }
            }
            c cVar = new c(gVar, mVar);
            mVar.a((e.b.b.b) cVar);
            gVar.a(cVar);
            if (cVar.a()) {
                gVar.b(cVar);
            } else {
                gVar.buffer.a(cVar);
            }
        }
    }

    /* compiled from: ObservableReplay */
    static final class i<T> extends a<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        i(int i2) {
            this.limit = i2;
        }

        /* access modifiers changed from: 0000 */
        public void d() {
            if (this.size > this.limit) {
                b();
            }
        }
    }

    /* compiled from: ObservableReplay */
    static final class j implements b<Object> {
        j() {
        }

        public e<Object> call() {
            return new k(16);
        }
    }

    /* compiled from: ObservableReplay */
    static final class k<T> extends ArrayList<Object> implements e<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        k(int i2) {
            super(i2);
        }

        public void a(T t) {
            e.b.d.j.h.d(t);
            add(t);
            this.size++;
        }

        public void e() {
            add(e.b.d.j.h.a());
            this.size++;
        }

        public void a(Throwable th) {
            add(e.b.d.j.h.a(th));
            this.size++;
        }

        public void a(c<T> cVar) {
            if (cVar.getAndIncrement() == 0) {
                m<? super T> mVar = cVar.child;
                int i2 = 1;
                while (!cVar.a()) {
                    int i3 = this.size;
                    Integer num = (Integer) cVar.c();
                    int intValue = num != null ? num.intValue() : 0;
                    while (intValue < i3) {
                        if (!e.b.d.j.h.a(get(intValue), mVar) && !cVar.a()) {
                            intValue++;
                        } else {
                            return;
                        }
                    }
                    cVar.index = Integer.valueOf(intValue);
                    i2 = cVar.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    private r(l<T> lVar, l<T> lVar2, AtomicReference<g<T>> atomicReference, b<T> bVar) {
        this.f8116e = lVar;
        this.f8113b = lVar2;
        this.f8114c = atomicReference;
        this.f8115d = bVar;
    }

    public static <T> e.b.e.a<T> a(l<T> lVar, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return c(lVar);
        }
        return a(lVar, (b<T>) new f<T>(i2));
    }

    public static <T> e.b.e.a<T> c(l<? extends T> lVar) {
        return a(lVar, f8112a);
    }

    public void b(e.b.b.b bVar) {
        this.f8114c.compareAndSet((g) bVar, null);
    }

    /* access modifiers changed from: protected */
    public void b(m<? super T> mVar) {
        this.f8116e.a(mVar);
    }

    static <T> e.b.e.a<T> a(l<T> lVar, b<T> bVar) {
        AtomicReference atomicReference = new AtomicReference();
        return e.b.g.a.a((e.b.e.a<T>) new r<T>(new h(atomicReference, bVar), lVar, atomicReference, bVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
    public void b(e.b.c.e<? super e.b.b.b> eVar) {
        g gVar;
        while (true) {
            gVar = (g) this.f8114c.get();
            if (gVar != null && !gVar.a()) {
                break;
            }
            g gVar2 = new g(this.f8115d.call());
            if (this.f8114c.compareAndSet(gVar, gVar2)) {
                gVar = gVar2;
                break;
            }
        }
        boolean z = !gVar.shouldConnect.get() && gVar.shouldConnect.compareAndSet(false, true);
        try {
            eVar.accept(gVar);
            if (z) {
                this.f8113b.a(gVar);
            }
        } catch (Throwable th) {
            if (z) {
                gVar.shouldConnect.compareAndSet(true, false);
            }
            io.reactivex.exceptions.a.b(th);
            throw e.b.d.j.f.a(th);
        }
    }
}
