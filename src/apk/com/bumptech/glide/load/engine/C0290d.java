package com.bumptech.glide.load.engine;

import com.bumptech.glide.h.l;
import com.bumptech.glide.load.f;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.bumptech.glide.load.engine.d reason: case insensitive filesystem */
/* compiled from: ActiveResources */
final class C0290d {

    /* renamed from: a reason: collision with root package name */
    private final boolean f3993a;

    /* renamed from: b reason: collision with root package name */
    private final Executor f3994b;

    /* renamed from: c reason: collision with root package name */
    final Map<f, b> f3995c;

    /* renamed from: d reason: collision with root package name */
    private final ReferenceQueue<A<?>> f3996d;

    /* renamed from: e reason: collision with root package name */
    private a f3997e;

    /* renamed from: f reason: collision with root package name */
    private volatile boolean f3998f;

    /* renamed from: g reason: collision with root package name */
    private volatile a f3999g;

    /* renamed from: com.bumptech.glide.load.engine.d$a */
    /* compiled from: ActiveResources */
    interface a {
        void a();
    }

    /* renamed from: com.bumptech.glide.load.engine.d$b */
    /* compiled from: ActiveResources */
    static final class b extends WeakReference<A<?>> {

        /* renamed from: a reason: collision with root package name */
        final f f4004a;

        /* renamed from: b reason: collision with root package name */
        final boolean f4005b;

        /* renamed from: c reason: collision with root package name */
        G<?> f4006c;

        b(f fVar, A<?> a2, ReferenceQueue<? super A<?>> referenceQueue, boolean z) {
            G<?> g2;
            super(a2, referenceQueue);
            l.a(fVar);
            this.f4004a = fVar;
            if (!a2.f() || !z) {
                g2 = null;
            } else {
                G<?> e2 = a2.e();
                l.a(e2);
                g2 = e2;
            }
            this.f4006c = g2;
            this.f4005b = a2.f();
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            this.f4006c = null;
            clear();
        }
    }

    C0290d(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new C0288b()));
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f3997e = aVar;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r0;
     */
    public synchronized A<?> b(f fVar) {
        b bVar = (b) this.f3995c.get(fVar);
        if (bVar == null) {
            return null;
        }
        A<?> a2 = (A) bVar.get();
        if (a2 == null) {
            a(bVar);
        }
    }

    C0290d(boolean z, Executor executor) {
        this.f3995c = new HashMap();
        this.f3996d = new ReferenceQueue<>();
        this.f3993a = z;
        this.f3994b = executor;
        executor.execute(new C0289c(this));
    }

    /* access modifiers changed from: 0000 */
    public synchronized void a(f fVar, A<?> a2) {
        b bVar = (b) this.f3995c.put(fVar, new b(fVar, a2, this.f3996d, this.f3993a));
        if (bVar != null) {
            bVar.a();
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void a(f fVar) {
        b bVar = (b) this.f3995c.remove(fVar);
        if (bVar != null) {
            bVar.a();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar) {
        synchronized (this.f3997e) {
            synchronized (this) {
                this.f3995c.remove(bVar.f4004a);
                if (bVar.f4005b) {
                    if (bVar.f4006c != null) {
                        A a2 = new A(bVar.f4006c, true, false);
                        a2.a(bVar.f4004a, this.f3997e);
                        this.f3997e.a(bVar.f4004a, a2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        while (!this.f3998f) {
            try {
                a((b) this.f3996d.remove());
                a aVar = this.f3999g;
                if (aVar != null) {
                    aVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
