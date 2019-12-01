package io.intercom.com.bumptech.glide.load.engine;

import android.os.Build.VERSION;
import android.util.Log;
import io.intercom.com.bumptech.glide.Registry.NoResultEncoderAvailableException;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.l;
import io.intercom.com.bumptech.glide.load.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeJob */
class j<R> implements io.intercom.com.bumptech.glide.load.engine.C0748g.a, Runnable, Comparable<j<?>>, io.intercom.com.bumptech.glide.h.a.d.c {
    private io.intercom.com.bumptech.glide.load.a.b<?> A;
    private volatile C0748g B;
    private volatile boolean C;
    private volatile boolean D;

    /* renamed from: a reason: collision with root package name */
    final C0749h<R> f9896a = new C0749h<>();

    /* renamed from: b reason: collision with root package name */
    private final List<Throwable> f9897b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.h.a.f f9898c = io.intercom.com.bumptech.glide.h.a.f.a();

    /* renamed from: d reason: collision with root package name */
    private final d f9899d;

    /* renamed from: e reason: collision with root package name */
    private final b.g.h.d<j<?>> f9900e;

    /* renamed from: f reason: collision with root package name */
    final c<?> f9901f = new c<>();

    /* renamed from: g reason: collision with root package name */
    private final e f9902g = new e();
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public io.intercom.com.bumptech.glide.e f9903h;

    /* renamed from: i reason: collision with root package name */
    io.intercom.com.bumptech.glide.load.g f9904i;

    /* renamed from: j reason: collision with root package name */
    private h f9905j;

    /* renamed from: k reason: collision with root package name */
    private w f9906k;

    /* renamed from: l reason: collision with root package name */
    int f9907l;
    int m;
    q n;
    io.intercom.com.bumptech.glide.load.j o;
    private a<R> p;
    private int q;
    private g r;
    private f s;
    private long t;
    private boolean u;
    private Thread v;
    io.intercom.com.bumptech.glide.load.g w;
    private io.intercom.com.bumptech.glide.load.g x;
    private Object y;
    private io.intercom.com.bumptech.glide.load.a z;

    /* compiled from: DecodeJob */
    interface a<R> {
        void a(E<R> e2, io.intercom.com.bumptech.glide.load.a aVar);

        void a(GlideException glideException);

        void a(j<?> jVar);
    }

    /* compiled from: DecodeJob */
    private final class b<Z> implements a<Z> {

        /* renamed from: a reason: collision with root package name */
        private final io.intercom.com.bumptech.glide.load.a f9908a;

        b(io.intercom.com.bumptech.glide.load.a aVar) {
            this.f9908a = aVar;
        }

        private Class<Z> b(E<Z> e2) {
            return e2.get().getClass();
        }

        /* JADX WARNING: type inference failed for: r12v9, types: [io.intercom.com.bumptech.glide.load.engine.e] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        public E<Z> a(E<Z> e2) {
            E<Z> e3;
            m mVar;
            io.intercom.com.bumptech.glide.load.c cVar;
            G g2;
            Class b2 = b(e2);
            l lVar = null;
            if (this.f9908a != io.intercom.com.bumptech.glide.load.a.RESOURCE_DISK_CACHE) {
                m b3 = j.this.f9896a.b(b2);
                io.intercom.com.bumptech.glide.e a2 = j.this.f9903h;
                j jVar = j.this;
                mVar = b3;
                e3 = b3.transform(a2, e2, jVar.f9907l, jVar.m);
            } else {
                e3 = e2;
                mVar = null;
            }
            if (!e2.equals(e3)) {
                e2.a();
            }
            if (j.this.f9896a.b(e3)) {
                lVar = j.this.f9896a.a(e3);
                cVar = lVar.a(j.this.o);
            } else {
                cVar = io.intercom.com.bumptech.glide.load.c.NONE;
            }
            l lVar2 = lVar;
            j jVar2 = j.this;
            if (!j.this.n.a(!jVar2.f9896a.a(jVar2.w), this.f9908a, cVar)) {
                return e3;
            }
            if (lVar2 != null) {
                if (cVar == io.intercom.com.bumptech.glide.load.c.SOURCE) {
                    j jVar3 = j.this;
                    g2 = new C0746e(jVar3.w, jVar3.f9904i);
                } else if (cVar == io.intercom.com.bumptech.glide.load.c.TRANSFORMED) {
                    io.intercom.com.bumptech.glide.load.engine.a.b b4 = j.this.f9896a.b();
                    j jVar4 = j.this;
                    G g3 = new G(b4, jVar4.w, jVar4.f9904i, jVar4.f9907l, jVar4.m, mVar, b2, jVar4.o);
                    g2 = g3;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown strategy: ");
                    sb.append(cVar);
                    throw new IllegalArgumentException(sb.toString());
                }
                D a3 = D.a(e3);
                j.this.f9901f.a(g2, lVar2, a3);
                return a3;
            }
            throw new NoResultEncoderAvailableException(e3.get().getClass());
        }
    }

    /* compiled from: DecodeJob */
    private static class c<Z> {

        /* renamed from: a reason: collision with root package name */
        private io.intercom.com.bumptech.glide.load.g f9910a;

        /* renamed from: b reason: collision with root package name */
        private l<Z> f9911b;

        /* renamed from: c reason: collision with root package name */
        private D<Z> f9912c;

        c() {
        }

        /* access modifiers changed from: 0000 */
        public <X> void a(io.intercom.com.bumptech.glide.load.g gVar, l<X> lVar, D<X> d2) {
            this.f9910a = gVar;
            this.f9911b = lVar;
            this.f9912c = d2;
        }

        /* access modifiers changed from: 0000 */
        public boolean b() {
            return this.f9912c != null;
        }

        /* access modifiers changed from: 0000 */
        public void a(d dVar, io.intercom.com.bumptech.glide.load.j jVar) {
            androidx.core.os.b.a("DecodeJob.encode");
            try {
                dVar.a().a(this.f9910a, new C0747f(this.f9911b, this.f9912c, jVar));
            } finally {
                this.f9912c.e();
                androidx.core.os.b.a();
            }
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            this.f9910a = null;
            this.f9911b = null;
            this.f9912c = null;
        }
    }

    /* compiled from: DecodeJob */
    interface d {
        io.intercom.com.bumptech.glide.load.engine.b.a a();
    }

    /* compiled from: DecodeJob */
    private static class e {

        /* renamed from: a reason: collision with root package name */
        private boolean f9913a;

        /* renamed from: b reason: collision with root package name */
        private boolean f9914b;

        /* renamed from: c reason: collision with root package name */
        private boolean f9915c;

        e() {
        }

        /* access modifiers changed from: 0000 */
        public synchronized boolean a(boolean z) {
            this.f9913a = true;
            return b(z);
        }

        /* access modifiers changed from: 0000 */
        public synchronized boolean b() {
            this.f9915c = true;
            return b(false);
        }

        /* access modifiers changed from: 0000 */
        public synchronized void c() {
            this.f9914b = false;
            this.f9913a = false;
            this.f9915c = false;
        }

        private boolean b(boolean z) {
            return (this.f9915c || z || this.f9914b) && this.f9913a;
        }

        /* access modifiers changed from: 0000 */
        public synchronized boolean a() {
            this.f9914b = true;
            return b(false);
        }
    }

    /* compiled from: DecodeJob */
    private enum f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* compiled from: DecodeJob */
    private enum g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    j(d dVar, b.g.h.d<j<?>> dVar2) {
        this.f9899d = dVar;
        this.f9900e = dVar2;
    }

    private void e() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.t;
            StringBuilder sb = new StringBuilder();
            sb.append("data: ");
            sb.append(this.y);
            sb.append(", cache key: ");
            sb.append(this.w);
            sb.append(", fetcher: ");
            sb.append(this.A);
            a("Retrieved data", j2, sb.toString());
        }
        E e2 = null;
        try {
            e2 = a(this.A, (Data) this.y, this.z);
        } catch (GlideException e3) {
            e3.a(this.x, this.z);
            this.f9897b.add(e3);
        }
        if (e2 != null) {
            b(e2, this.z);
        } else {
            k();
        }
    }

    private C0748g f() {
        int i2 = C0750i.f9895b[this.r.ordinal()];
        if (i2 == 1) {
            return new F(this.f9896a, this);
        }
        if (i2 == 2) {
            return new C0745d(this.f9896a, this);
        }
        if (i2 == 3) {
            return new I(this.f9896a, this);
        }
        if (i2 == 4) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized stage: ");
        sb.append(this.r);
        throw new IllegalStateException(sb.toString());
    }

    private void g() {
        m();
        this.p.a(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList<Throwable>(this.f9897b)));
        i();
    }

    private int getPriority() {
        return this.f9905j.ordinal();
    }

    private void h() {
        if (this.f9902g.a()) {
            j();
        }
    }

    private void i() {
        if (this.f9902g.b()) {
            j();
        }
    }

    private void j() {
        this.f9902g.c();
        this.f9901f.a();
        this.f9896a.a();
        this.C = false;
        this.f9903h = null;
        this.f9904i = null;
        this.o = null;
        this.f9905j = null;
        this.f9906k = null;
        this.p = null;
        this.r = null;
        this.B = null;
        this.v = null;
        this.w = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.t = 0;
        this.D = false;
        this.f9897b.clear();
        this.f9900e.a(this);
    }

    private void k() {
        this.v = Thread.currentThread();
        this.t = io.intercom.com.bumptech.glide.h.d.a();
        boolean z2 = false;
        while (!this.D && this.B != null) {
            z2 = this.B.a();
            if (z2) {
                break;
            }
            this.r = a(this.r);
            this.B = f();
            if (this.r == g.SOURCE) {
                b();
                return;
            }
        }
        if ((this.r == g.FINISHED || this.D) && !z2) {
            g();
        }
    }

    private void l() {
        int i2 = C0750i.f9894a[this.s.ordinal()];
        if (i2 == 1) {
            this.r = a(g.INITIALIZE);
            this.B = f();
            k();
        } else if (i2 == 2) {
            k();
        } else if (i2 == 3) {
            e();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized run reason: ");
            sb.append(this.s);
            throw new IllegalStateException(sb.toString());
        }
    }

    private void m() {
        this.f9898c.b();
        if (!this.C) {
            this.C = true;
            return;
        }
        throw new IllegalStateException("Already notified");
    }

    /* renamed from: b */
    public int compareTo(j<?> jVar) {
        int priority = getPriority() - jVar.getPriority();
        return priority == 0 ? this.q - jVar.q : priority;
    }

    /* access modifiers changed from: 0000 */
    public boolean c() {
        g a2 = a(g.INITIALIZE);
        return a2 == g.RESOURCE_CACHE || a2 == g.DATA_CACHE;
    }

    public io.intercom.com.bumptech.glide.h.a.f d() {
        return this.f9898c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r1 != null) goto L_0x001e;
     */
    public void run() {
        String str = "DecodeJob";
        androidx.core.os.b.a("DecodeJob#run");
        io.intercom.com.bumptech.glide.load.a.b<?> bVar = this.A;
        try {
            if (this.D) {
                g();
                if (bVar != null) {
                    bVar.b();
                }
                androidx.core.os.b.a();
                return;
            }
            l();
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.b();
            }
            androidx.core.os.b.a();
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    public j<R> a(io.intercom.com.bumptech.glide.e eVar, Object obj, w wVar, io.intercom.com.bumptech.glide.load.g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, h hVar, q qVar, Map<Class<?>, m<?>> map, boolean z2, boolean z3, boolean z4, io.intercom.com.bumptech.glide.load.j jVar, a<R> aVar, int i4) {
        this.f9896a.a(eVar, obj, gVar, i2, i3, qVar, cls, cls2, hVar, jVar, map, z2, z3, this.f9899d);
        this.f9903h = eVar;
        this.f9904i = gVar;
        this.f9905j = hVar;
        this.f9906k = wVar;
        this.f9907l = i2;
        this.m = i3;
        this.n = qVar;
        this.u = z4;
        this.o = jVar;
        this.p = aVar;
        this.q = i4;
        this.s = f.INITIALIZE;
        return this;
    }

    public void b() {
        this.s = f.SWITCH_TO_SOURCE_SERVICE;
        this.p.a(this);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r3v1, types: [io.intercom.com.bumptech.glide.load.engine.E] */
    /* JADX WARNING: type inference failed for: r3v7, types: [io.intercom.com.bumptech.glide.load.engine.D] */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    private void b(E<R> e2, io.intercom.com.bumptech.glide.load.a aVar) {
        if (e2 instanceof z) {
            ((z) e2).d();
        }
        D d2 = 0;
        if (this.f9901f.b()) {
            r3 = D.a(e2);
            d2 = r3;
            e2 = r3;
        }
        a((E<R>) e2, aVar);
        this.r = g.ENCODE;
        try {
            if (this.f9901f.b()) {
                this.f9901f.a(this.f9899d, this.o);
            }
            if (d2 != 0) {
                d2.e();
            }
            h();
        } catch (Throwable th) {
            if (d2 != 0) {
                d2.e();
            }
            h();
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z2) {
        if (this.f9902g.a(z2)) {
            j();
        }
    }

    public void a() {
        this.D = true;
        C0748g gVar = this.B;
        if (gVar != null) {
            gVar.cancel();
        }
    }

    private void a(E<R> e2, io.intercom.com.bumptech.glide.load.a aVar) {
        m();
        this.p.a(e2, aVar);
    }

    private g a(g gVar) {
        g gVar2;
        g gVar3;
        int i2 = C0750i.f9895b[gVar.ordinal()];
        if (i2 == 1) {
            if (this.n.a()) {
                gVar2 = g.DATA_CACHE;
            } else {
                gVar2 = a(g.DATA_CACHE);
            }
            return gVar2;
        } else if (i2 == 2) {
            return this.u ? g.FINISHED : g.SOURCE;
        } else if (i2 == 3 || i2 == 4) {
            return g.FINISHED;
        } else {
            if (i2 == 5) {
                if (this.n.b()) {
                    gVar3 = g.RESOURCE_CACHE;
                } else {
                    gVar3 = a(g.RESOURCE_CACHE);
                }
                return gVar3;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized stage: ");
            sb.append(gVar);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void a(io.intercom.com.bumptech.glide.load.g gVar, Object obj, io.intercom.com.bumptech.glide.load.a.b<?> bVar, io.intercom.com.bumptech.glide.load.a aVar, io.intercom.com.bumptech.glide.load.g gVar2) {
        this.w = gVar;
        this.y = obj;
        this.A = bVar;
        this.z = aVar;
        this.x = gVar2;
        if (Thread.currentThread() != this.v) {
            this.s = f.DECODE_DATA;
            this.p.a(this);
            return;
        }
        androidx.core.os.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            e();
        } finally {
            androidx.core.os.b.a();
        }
    }

    public void a(io.intercom.com.bumptech.glide.load.g gVar, Exception exc, io.intercom.com.bumptech.glide.load.a.b<?> bVar, io.intercom.com.bumptech.glide.load.a aVar) {
        bVar.b();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.a(gVar, aVar, bVar.a());
        this.f9897b.add(glideException);
        if (Thread.currentThread() != this.v) {
            this.s = f.SWITCH_TO_SOURCE_SERVICE;
            this.p.a(this);
            return;
        }
        k();
    }

    private <Data> E<R> a(io.intercom.com.bumptech.glide.load.a.b<?> bVar, Data data, io.intercom.com.bumptech.glide.load.a aVar) throws GlideException {
        if (data == null) {
            bVar.b();
            return null;
        }
        try {
            long a2 = io.intercom.com.bumptech.glide.h.d.a();
            E<R> a3 = a(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Decoded result ");
                sb.append(a3);
                a(sb.toString(), a2);
            }
            return a3;
        } finally {
            bVar.b();
        }
    }

    private <Data> E<R> a(Data data, io.intercom.com.bumptech.glide.load.a aVar) throws GlideException {
        return a(data, aVar, this.f9896a.a(data.getClass()));
    }

    private io.intercom.com.bumptech.glide.load.j a(io.intercom.com.bumptech.glide.load.a aVar) {
        io.intercom.com.bumptech.glide.load.j jVar = this.o;
        if (VERSION.SDK_INT < 26 || jVar.a(io.intercom.com.bumptech.glide.load.c.a.l.f9606d) != null) {
            return jVar;
        }
        if (aVar == io.intercom.com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || this.f9896a.m()) {
            jVar = new io.intercom.com.bumptech.glide.load.j();
            jVar.a(this.o);
            jVar.a(io.intercom.com.bumptech.glide.load.c.a.l.f9606d, Boolean.valueOf(true));
        }
        return jVar;
    }

    private <Data, ResourceType> E<R> a(Data data, io.intercom.com.bumptech.glide.load.a aVar, B<Data, ResourceType, R> b2) throws GlideException {
        io.intercom.com.bumptech.glide.load.j a2 = a(aVar);
        io.intercom.com.bumptech.glide.load.a.c b3 = this.f9903h.f().b(data);
        try {
            return b2.a(b3, a2, this.f9907l, this.m, new b(aVar));
        } finally {
            b3.b();
        }
    }

    private void a(String str, long j2) {
        a(str, j2, (String) null);
    }

    private void a(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(io.intercom.com.bumptech.glide.h.d.a(j2));
        sb.append(", load key: ");
        sb.append(this.f9906k);
        if (str2 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(", ");
            sb2.append(str2);
            str3 = sb2.toString();
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }
}
