package io.intercom.com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.load.g;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.intercom.com.bumptech.glide.load.engine.c reason: case insensitive filesystem */
/* compiled from: ActiveResources */
final class C0744c {

    /* renamed from: a reason: collision with root package name */
    private final boolean f9840a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final Handler f9841b = new Handler(Looper.getMainLooper(), new C0742a(this));

    /* renamed from: c reason: collision with root package name */
    final Map<g, b> f9842c = new HashMap();

    /* renamed from: d reason: collision with root package name */
    private a f9843d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public ReferenceQueue<y<?>> f9844e;

    /* renamed from: f reason: collision with root package name */
    private Thread f9845f;
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public volatile boolean f9846g;
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public volatile a f9847h;

    /* renamed from: io.intercom.com.bumptech.glide.load.engine.c$a */
    /* compiled from: ActiveResources */
    interface a {
        void a();
    }

    /* renamed from: io.intercom.com.bumptech.glide.load.engine.c$b */
    /* compiled from: ActiveResources */
    static final class b extends WeakReference<y<?>> {

        /* renamed from: a reason: collision with root package name */
        final g f9849a;

        /* renamed from: b reason: collision with root package name */
        final boolean f9850b;

        /* renamed from: c reason: collision with root package name */
        E<?> f9851c;

        b(g gVar, y<?> yVar, ReferenceQueue<? super y<?>> referenceQueue, boolean z) {
            E<?> e2;
            super(yVar, referenceQueue);
            h.a(gVar);
            this.f9849a = gVar;
            if (!yVar.f() || !z) {
                e2 = null;
            } else {
                E<?> e3 = yVar.e();
                h.a(e3);
                e2 = e3;
            }
            this.f9851c = e2;
            this.f9850b = yVar.f();
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            this.f9851c = null;
            clear();
        }
    }

    C0744c(boolean z) {
        this.f9840a = z;
    }

    /* access modifiers changed from: 0000 */
    public y<?> b(g gVar) {
        b bVar = (b) this.f9842c.get(gVar);
        if (bVar == null) {
            return null;
        }
        y<?> yVar = (y) bVar.get();
        if (yVar == null) {
            a(bVar);
        }
        return yVar;
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        this.f9843d = aVar;
    }

    /* access modifiers changed from: 0000 */
    public void a(g gVar, y<?> yVar) {
        b bVar = (b) this.f9842c.put(gVar, new b(gVar, yVar, a(), this.f9840a));
        if (bVar != null) {
            bVar.a();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(g gVar) {
        b bVar = (b) this.f9842c.remove(gVar);
        if (bVar != null) {
            bVar.a();
        }
    }

    /* access modifiers changed from: private */
    public void a(b bVar) {
        j.b();
        this.f9842c.remove(bVar.f9849a);
        if (bVar.f9850b) {
            E<?> e2 = bVar.f9851c;
            if (e2 != null) {
                y yVar = new y(e2, true, false);
                yVar.a(bVar.f9849a, this.f9843d);
                this.f9843d.a(bVar.f9849a, yVar);
            }
        }
    }

    private ReferenceQueue<y<?>> a() {
        if (this.f9844e == null) {
            this.f9844e = new ReferenceQueue<>();
            this.f9845f = new Thread(new C0743b(this), "glide-active-resources");
            this.f9845f.start();
        }
        return this.f9844e;
    }
}
