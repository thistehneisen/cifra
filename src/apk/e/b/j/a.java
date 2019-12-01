package e.b.j;

import e.b.b.b;
import e.b.d.j.a.C0092a;
import e.b.d.j.f;
import e.b.d.j.h;
import e.b.m;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: BehaviorSubject */
public final class a<T> extends c<T> {

    /* renamed from: a reason: collision with root package name */
    private static final Object[] f8346a = new Object[0];

    /* renamed from: b reason: collision with root package name */
    static final C0094a[] f8347b = new C0094a[0];

    /* renamed from: c reason: collision with root package name */
    static final C0094a[] f8348c = new C0094a[0];

    /* renamed from: d reason: collision with root package name */
    final AtomicReference<Object> f8349d;

    /* renamed from: e reason: collision with root package name */
    final AtomicReference<C0094a<T>[]> f8350e;

    /* renamed from: f reason: collision with root package name */
    final ReadWriteLock f8351f;

    /* renamed from: g reason: collision with root package name */
    final Lock f8352g;

    /* renamed from: h reason: collision with root package name */
    final Lock f8353h;

    /* renamed from: i reason: collision with root package name */
    final AtomicReference<Throwable> f8354i;

    /* renamed from: j reason: collision with root package name */
    long f8355j;

    /* renamed from: e.b.j.a$a reason: collision with other inner class name */
    /* compiled from: BehaviorSubject */
    static final class C0094a<T> implements b, C0092a<Object> {

        /* renamed from: a reason: collision with root package name */
        final m<? super T> f8356a;

        /* renamed from: b reason: collision with root package name */
        final a<T> f8357b;

        /* renamed from: c reason: collision with root package name */
        boolean f8358c;

        /* renamed from: d reason: collision with root package name */
        boolean f8359d;

        /* renamed from: e reason: collision with root package name */
        e.b.d.j.a<Object> f8360e;

        /* renamed from: f reason: collision with root package name */
        boolean f8361f;

        /* renamed from: g reason: collision with root package name */
        volatile boolean f8362g;

        /* renamed from: h reason: collision with root package name */
        long f8363h;

        C0094a(m<? super T> mVar, a<T> aVar) {
            this.f8356a = mVar;
            this.f8357b = aVar;
        }

        public boolean a() {
            return this.f8362g;
        }

        public void b() {
            if (!this.f8362g) {
                this.f8362g = true;
                this.f8357b.b(this);
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            if (test(r0) == false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
            return;
         */
        public void c() {
            if (!this.f8362g) {
                synchronized (this) {
                    if (!this.f8362g) {
                        if (!this.f8358c) {
                            a<T> aVar = this.f8357b;
                            Lock lock = aVar.f8352g;
                            lock.lock();
                            this.f8363h = aVar.f8355j;
                            Object obj = aVar.f8349d.get();
                            lock.unlock();
                            this.f8359d = obj != null;
                            this.f8358c = true;
                        }
                    }
                }
            }
        }

        /* JADX INFO: used method not loaded: e.b.d.j.a.a(e.b.d.j.a$a):null, types can be incorrect */
        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.a((e.b.d.j.a.C0092a) r2);
         */
        public void d() {
            while (!this.f8362g) {
                synchronized (this) {
                    e.b.d.j.a<Object> aVar = this.f8360e;
                    if (aVar == null) {
                        this.f8359d = false;
                        return;
                    }
                    this.f8360e = null;
                }
            }
        }

        public boolean test(Object obj) {
            return this.f8362g || h.a(obj, this.f8356a);
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r3.f8361f = true;
         */
        public void a(Object obj, long j2) {
            if (!this.f8362g) {
                if (!this.f8361f) {
                    synchronized (this) {
                        if (!this.f8362g) {
                            if (this.f8363h != j2) {
                                if (this.f8359d) {
                                    e.b.d.j.a<Object> aVar = this.f8360e;
                                    if (aVar == null) {
                                        aVar = new e.b.d.j.a<>(4);
                                        this.f8360e = aVar;
                                    }
                                    aVar.a(obj);
                                    return;
                                }
                                this.f8358c = true;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                test(obj);
            }
        }
    }

    a() {
        this.f8351f = new ReentrantReadWriteLock();
        this.f8352g = this.f8351f.readLock();
        this.f8353h = this.f8351f.writeLock();
        this.f8350e = new AtomicReference<>(f8347b);
        this.f8349d = new AtomicReference<>();
        this.f8354i = new AtomicReference<>();
    }

    public static <T> a<T> c(T t) {
        return new a<>(t);
    }

    public static <T> a<T> j() {
        return new a<>();
    }

    public void a(b bVar) {
        if (this.f8354i.get() != null) {
            bVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void b(m<? super T> mVar) {
        C0094a aVar = new C0094a(mVar, this);
        mVar.a((b) aVar);
        if (!a(aVar)) {
            Throwable th = (Throwable) this.f8354i.get();
            if (th == f.f8293a) {
                mVar.c();
            } else {
                mVar.a(th);
            }
        } else if (aVar.f8362g) {
            b(aVar);
        } else {
            aVar.c();
        }
    }

    /* access modifiers changed from: 0000 */
    public void d(Object obj) {
        this.f8353h.lock();
        this.f8355j++;
        this.f8349d.lazySet(obj);
        this.f8353h.unlock();
    }

    /* access modifiers changed from: 0000 */
    public C0094a<T>[] e(Object obj) {
        C0094a<T>[] aVarArr = (C0094a[]) this.f8350e.getAndSet(f8348c);
        if (aVarArr != f8348c) {
            d(obj);
        }
        return aVarArr;
    }

    public T k() {
        T t = this.f8349d.get();
        if (h.b(t) || h.c(t)) {
            return null;
        }
        h.a((Object) t);
        return t;
    }

    public void c() {
        if (this.f8354i.compareAndSet(null, f.f8293a)) {
            Object a2 = h.a();
            for (C0094a a3 : e(a2)) {
                a3.a(a2, this.f8355j);
            }
        }
    }

    public void a(T t) {
        e.b.d.b.b.a(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f8354i.get() == null) {
            h.d(t);
            d(t);
            for (C0094a a2 : (C0094a[]) this.f8350e.get()) {
                a2.a(t, this.f8355j);
            }
        }
    }

    a(T t) {
        this();
        AtomicReference<Object> atomicReference = this.f8349d;
        e.b.d.b.b.a(t, "defaultValue is null");
        atomicReference.lazySet(t);
    }

    public void a(Throwable th) {
        e.b.d.b.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f8354i.compareAndSet(null, th)) {
            e.b.g.a.b(th);
            return;
        }
        Object a2 = h.a(th);
        for (C0094a a3 : e(a2)) {
            a3.a(a2, this.f8355j);
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(C0094a<T> aVar) {
        C0094a<T>[] aVarArr;
        C0094a[] aVarArr2;
        do {
            aVarArr = (C0094a[]) this.f8350e.get();
            int length = aVarArr.length;
            if (length != 0) {
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
                        aVarArr2 = f8347b;
                    } else {
                        C0094a[] aVarArr3 = new C0094a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                        System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f8350e.compareAndSet(aVarArr, aVarArr2));
    }

    /* access modifiers changed from: 0000 */
    public boolean a(C0094a<T> aVar) {
        C0094a[] aVarArr;
        C0094a[] aVarArr2;
        do {
            aVarArr = (C0094a[]) this.f8350e.get();
            if (aVarArr == f8348c) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new C0094a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f8350e.compareAndSet(aVarArr, aVarArr2));
        return true;
    }
}
