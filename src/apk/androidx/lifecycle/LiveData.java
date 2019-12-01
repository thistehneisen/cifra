package androidx.lifecycle;

import b.b.a.a.c;
import java.util.Map.Entry;

public abstract class LiveData<T> {

    /* renamed from: a reason: collision with root package name */
    static final Object f1614a = new Object();

    /* renamed from: b reason: collision with root package name */
    final Object f1615b = new Object();

    /* renamed from: c reason: collision with root package name */
    private b.b.a.b.b<v<? super T>, b> f1616c = new b.b.a.b.b<>();

    /* renamed from: d reason: collision with root package name */
    int f1617d = 0;

    /* renamed from: e reason: collision with root package name */
    private volatile Object f1618e;

    /* renamed from: f reason: collision with root package name */
    volatile Object f1619f;

    /* renamed from: g reason: collision with root package name */
    private int f1620g;

    /* renamed from: h reason: collision with root package name */
    private boolean f1621h;

    /* renamed from: i reason: collision with root package name */
    private boolean f1622i;

    /* renamed from: j reason: collision with root package name */
    private final Runnable f1623j;

    class LifecycleBoundObserver extends b implements C0214g {

        /* renamed from: e reason: collision with root package name */
        final l f1624e;

        LifecycleBoundObserver(l lVar, v<? super T> vVar) {
            super(vVar);
            this.f1624e = lVar;
        }

        public void a(l lVar, androidx.lifecycle.h.a aVar) {
            if (this.f1624e.getLifecycle().a() == androidx.lifecycle.h.b.DESTROYED) {
                LiveData.this.b(this.f1627a);
            } else {
                a(b());
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean b() {
            return this.f1624e.getLifecycle().a().a(androidx.lifecycle.h.b.STARTED);
        }

        /* access modifiers changed from: 0000 */
        public boolean a(l lVar) {
            return this.f1624e == lVar;
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            this.f1624e.getLifecycle().b(this);
        }
    }

    private class a extends b {
        a(v<? super T> vVar) {
            super(vVar);
        }

        /* access modifiers changed from: 0000 */
        public boolean b() {
            return true;
        }
    }

    private abstract class b {

        /* renamed from: a reason: collision with root package name */
        final v<? super T> f1627a;

        /* renamed from: b reason: collision with root package name */
        boolean f1628b;

        /* renamed from: c reason: collision with root package name */
        int f1629c = -1;

        b(v<? super T> vVar) {
            this.f1627a = vVar;
        }

        /* access modifiers changed from: 0000 */
        public void a() {
        }

        /* access modifiers changed from: 0000 */
        public void a(boolean z) {
            if (z != this.f1628b) {
                this.f1628b = z;
                int i2 = 1;
                boolean z2 = LiveData.this.f1617d == 0;
                LiveData liveData = LiveData.this;
                int i3 = liveData.f1617d;
                if (!this.f1628b) {
                    i2 = -1;
                }
                liveData.f1617d = i3 + i2;
                if (z2 && this.f1628b) {
                    LiveData.this.b();
                }
                LiveData liveData2 = LiveData.this;
                if (liveData2.f1617d == 0 && !this.f1628b) {
                    liveData2.c();
                }
                if (this.f1628b) {
                    LiveData.this.a(this);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean a(l lVar) {
            return false;
        }

        /* access modifiers changed from: 0000 */
        public abstract boolean b();
    }

    public LiveData() {
        Object obj = f1614a;
        this.f1618e = obj;
        this.f1619f = obj;
        this.f1620g = -1;
        this.f1623j = new q(this);
    }

    private void b(b bVar) {
        if (bVar.f1628b) {
            if (!bVar.b()) {
                bVar.a(false);
                return;
            }
            int i2 = bVar.f1629c;
            int i3 = this.f1620g;
            if (i2 < i3) {
                bVar.f1629c = i3;
                bVar.f1627a.a(this.f1618e);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar) {
        if (this.f1621h) {
            this.f1622i = true;
            return;
        }
        this.f1621h = true;
        do {
            this.f1622i = false;
            if (bVar == null) {
                d f2 = this.f1616c.f();
                while (f2.hasNext()) {
                    b((b) ((Entry) f2.next()).getValue());
                    if (this.f1622i) {
                        break;
                    }
                }
            } else {
                b(bVar);
                bVar = null;
            }
        } while (this.f1622i);
        this.f1621h = false;
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    public void b(v<? super T> vVar) {
        a("removeObserver");
        b bVar = (b) this.f1616c.remove(vVar);
        if (bVar != null) {
            bVar.a();
            bVar.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public void b(T t) {
        a("setValue");
        this.f1620g++;
        this.f1618e = t;
        a(null);
    }

    public void a(l lVar, v<? super T> vVar) {
        a("observe");
        if (lVar.getLifecycle().a() != androidx.lifecycle.h.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lVar, vVar);
            b bVar = (b) this.f1616c.b(vVar, lifecycleBoundObserver);
            if (bVar != null && !bVar.a(lVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (bVar == null) {
                lVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void a(v<? super T> vVar) {
        a("observeForever");
        a aVar = new a(vVar);
        b bVar = (b) this.f1616c.b(vVar, aVar);
        if (bVar != null && (bVar instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (bVar == null) {
            aVar.a(true);
        }
    }

    /* access modifiers changed from: protected */
    public void a(T t) {
        boolean z;
        synchronized (this.f1615b) {
            z = this.f1619f == f1614a;
            this.f1619f = t;
        }
        if (z) {
            c.b().c(this.f1623j);
        }
    }

    public T a() {
        T t = this.f1618e;
        if (t != f1614a) {
            return t;
        }
        return null;
    }

    private static void a(String str) {
        if (!c.b().a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot invoke ");
            sb.append(str);
            sb.append(" on a background");
            sb.append(" thread");
            throw new IllegalStateException(sb.toString());
        }
    }
}
