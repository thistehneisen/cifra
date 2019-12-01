package com.bumptech.glide.load.engine;

import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.Registry.NoResultEncoderAvailableException;
import com.bumptech.glide.h.h;
import com.bumptech.glide.j;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeJob */
class l<R> implements com.bumptech.glide.load.engine.C0295i.a, Runnable, Comparable<l<?>>, com.bumptech.glide.h.a.d.c {
    private com.bumptech.glide.load.a A;
    private com.bumptech.glide.load.a.d<?> B;
    private volatile C0295i C;
    private volatile boolean D;
    private volatile boolean E;

    /* renamed from: a reason: collision with root package name */
    private final C0296j<R> f4036a = new C0296j<>();

    /* renamed from: b reason: collision with root package name */
    private final List<Throwable> f4037b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    private final com.bumptech.glide.h.a.g f4038c = com.bumptech.glide.h.a.g.a();

    /* renamed from: d reason: collision with root package name */
    private final d f4039d;

    /* renamed from: e reason: collision with root package name */
    private final b.g.h.d<l<?>> f4040e;

    /* renamed from: f reason: collision with root package name */
    private final c<?> f4041f = new c<>();

    /* renamed from: g reason: collision with root package name */
    private final e f4042g = new e();

    /* renamed from: h reason: collision with root package name */
    private com.bumptech.glide.g f4043h;

    /* renamed from: i reason: collision with root package name */
    private com.bumptech.glide.load.f f4044i;

    /* renamed from: j reason: collision with root package name */
    private j f4045j;

    /* renamed from: k reason: collision with root package name */
    private y f4046k;

    /* renamed from: l reason: collision with root package name */
    private int f4047l;
    private int m;
    private s n;
    private i o;
    private a<R> p;
    private int q;
    private g r;
    private f s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private com.bumptech.glide.load.f x;
    private com.bumptech.glide.load.f y;
    private Object z;

    /* compiled from: DecodeJob */
    interface a<R> {
        void a(G<R> g2, com.bumptech.glide.load.a aVar);

        void a(GlideException glideException);

        void a(l<?> lVar);
    }

    /* compiled from: DecodeJob */
    private final class b<Z> implements a<Z> {

        /* renamed from: a reason: collision with root package name */
        private final com.bumptech.glide.load.a f4048a;

        b(com.bumptech.glide.load.a aVar) {
            this.f4048a = aVar;
        }

        public G<Z> a(G<Z> g2) {
            return l.this.a(this.f4048a, g2);
        }
    }

    /* compiled from: DecodeJob */
    private static class c<Z> {

        /* renamed from: a reason: collision with root package name */
        private com.bumptech.glide.load.f f4050a;

        /* renamed from: b reason: collision with root package name */
        private k<Z> f4051b;

        /* renamed from: c reason: collision with root package name */
        private F<Z> f4052c;

        c() {
        }

        /* access modifiers changed from: 0000 */
        public <X> void a(com.bumptech.glide.load.f fVar, k<X> kVar, F<X> f2) {
            this.f4050a = fVar;
            this.f4051b = kVar;
            this.f4052c = f2;
        }

        /* access modifiers changed from: 0000 */
        public boolean b() {
            return this.f4052c != null;
        }

        /* access modifiers changed from: 0000 */
        public void a(d dVar, i iVar) {
            com.bumptech.glide.h.a.e.a("DecodeJob.encode");
            try {
                dVar.a().a(this.f4050a, new C0294h(this.f4051b, this.f4052c, iVar));
            } finally {
                this.f4052c.e();
                com.bumptech.glide.h.a.e.a();
            }
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            this.f4050a = null;
            this.f4051b = null;
            this.f4052c = null;
        }
    }

    /* compiled from: DecodeJob */
    interface d {
        com.bumptech.glide.load.engine.b.a a();
    }

    /* compiled from: DecodeJob */
    private static class e {

        /* renamed from: a reason: collision with root package name */
        private boolean f4053a;

        /* renamed from: b reason: collision with root package name */
        private boolean f4054b;

        /* renamed from: c reason: collision with root package name */
        private boolean f4055c;

        e() {
        }

        /* access modifiers changed from: 0000 */
        public synchronized boolean a(boolean z) {
            this.f4053a = true;
            return b(z);
        }

        /* access modifiers changed from: 0000 */
        public synchronized boolean b() {
            this.f4055c = true;
            return b(false);
        }

        /* access modifiers changed from: 0000 */
        public synchronized void c() {
            this.f4054b = false;
            this.f4053a = false;
            this.f4055c = false;
        }

        private boolean b(boolean z) {
            return (this.f4055c || z || this.f4054b) && this.f4053a;
        }

        /* access modifiers changed from: 0000 */
        public synchronized boolean a() {
            this.f4054b = true;
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

    l(d dVar, b.g.h.d<l<?>> dVar2) {
        this.f4039d = dVar;
        this.f4040e = dVar2;
    }

    private void e() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.t;
            StringBuilder sb = new StringBuilder();
            sb.append("data: ");
            sb.append(this.z);
            sb.append(", cache key: ");
            sb.append(this.x);
            sb.append(", fetcher: ");
            sb.append(this.B);
            a("Retrieved data", j2, sb.toString());
        }
        G g2 = null;
        try {
            g2 = a(this.B, (Data) this.z, this.A);
        } catch (GlideException e2) {
            e2.a(this.y, this.A);
            this.f4037b.add(e2);
        }
        if (g2 != null) {
            b(g2, this.A);
        } else {
            k();
        }
    }

    private C0295i f() {
        int i2 = C0297k.f4034b[this.r.ordinal()];
        if (i2 == 1) {
            return new H(this.f4036a, this);
        }
        if (i2 == 2) {
            return new C0292f(this.f4036a, this);
        }
        if (i2 == 3) {
            return new K(this.f4036a, this);
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
        this.p.a(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList<Throwable>(this.f4037b)));
        i();
    }

    private int getPriority() {
        return this.f4045j.ordinal();
    }

    private void h() {
        if (this.f4042g.a()) {
            j();
        }
    }

    private void i() {
        if (this.f4042g.b()) {
            j();
        }
    }

    private void j() {
        this.f4042g.c();
        this.f4041f.a();
        this.f4036a.a();
        this.D = false;
        this.f4043h = null;
        this.f4044i = null;
        this.o = null;
        this.f4045j = null;
        this.f4046k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0;
        this.E = false;
        this.v = null;
        this.f4037b.clear();
        this.f4040e.a(this);
    }

    private void k() {
        this.w = Thread.currentThread();
        this.t = h.a();
        boolean z2 = false;
        while (!this.E && this.C != null) {
            z2 = this.C.a();
            if (z2) {
                break;
            }
            this.r = a(this.r);
            this.C = f();
            if (this.r == g.SOURCE) {
                b();
                return;
            }
        }
        if ((this.r == g.FINISHED || this.E) && !z2) {
            g();
        }
    }

    private void l() {
        int i2 = C0297k.f4033a[this.s.ordinal()];
        if (i2 == 1) {
            this.r = a(g.INITIALIZE);
            this.C = f();
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
        Throwable th;
        this.f4038c.b();
        if (this.D) {
            if (this.f4037b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f4037b;
                th = (Throwable) list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.D = true;
    }

    /* access modifiers changed from: 0000 */
    public l<R> a(com.bumptech.glide.g gVar, Object obj, y yVar, com.bumptech.glide.load.f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, j jVar, s sVar, Map<Class<?>, com.bumptech.glide.load.l<?>> map, boolean z2, boolean z3, boolean z4, i iVar, a<R> aVar, int i4) {
        this.f4036a.a(gVar, obj, fVar, i2, i3, sVar, cls, cls2, jVar, iVar, map, z2, z3, this.f4039d);
        this.f4043h = gVar;
        this.f4044i = fVar;
        this.f4045j = jVar;
        this.f4046k = yVar;
        this.f4047l = i2;
        this.m = i3;
        this.n = sVar;
        this.u = z4;
        this.o = iVar;
        this.p = aVar;
        this.q = i4;
        this.s = f.INITIALIZE;
        this.v = obj;
        return this;
    }

    public void b() {
        this.s = f.SWITCH_TO_SOURCE_SERVICE;
        this.p.a(this);
    }

    /* access modifiers changed from: 0000 */
    public boolean c() {
        g a2 = a(g.INITIALIZE);
        return a2 == g.RESOURCE_CACHE || a2 == g.DATA_CACHE;
    }

    public com.bumptech.glide.h.a.g d() {
        return this.f4038c;
    }

    public void run() {
        String str = "DecodeJob";
        com.bumptech.glide.h.a.e.a("DecodeJob#run(model=%s)", this.v);
        com.bumptech.glide.load.a.d<?> dVar = this.B;
        try {
            if (this.E) {
                g();
                if (dVar != null) {
                    dVar.b();
                }
                com.bumptech.glide.h.a.e.a();
                return;
            }
            l();
            if (dVar != null) {
                dVar.b();
            }
            com.bumptech.glide.h.a.e.a();
        } catch (C0291e e2) {
            throw e2;
        } catch (Throwable th) {
            if (dVar != null) {
                dVar.b();
            }
            com.bumptech.glide.h.a.e.a();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r3v1, types: [com.bumptech.glide.load.engine.G] */
    /* JADX WARNING: type inference failed for: r3v7, types: [com.bumptech.glide.load.engine.F] */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    private void b(G<R> g2, com.bumptech.glide.load.a aVar) {
        if (g2 instanceof B) {
            ((B) g2).d();
        }
        F f2 = 0;
        if (this.f4041f.b()) {
            r3 = F.a(g2);
            f2 = r3;
            g2 = r3;
        }
        a((G<R>) g2, aVar);
        this.r = g.ENCODE;
        try {
            if (this.f4041f.b()) {
                this.f4041f.a(this.f4039d, this.o);
            }
            if (f2 != 0) {
                f2.e();
            }
            h();
        } catch (Throwable th) {
            if (f2 != 0) {
                f2.e();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z2) {
        if (this.f4042g.a(z2)) {
            j();
        }
    }

    /* renamed from: a */
    public int compareTo(l<?> lVar) {
        int priority = getPriority() - lVar.getPriority();
        return priority == 0 ? this.q - lVar.q : priority;
    }

    public void a() {
        this.E = true;
        C0295i iVar = this.C;
        if (iVar != null) {
            iVar.cancel();
        }
    }

    private void a(G<R> g2, com.bumptech.glide.load.a aVar) {
        m();
        this.p.a(g2, aVar);
    }

    private g a(g gVar) {
        int i2 = C0297k.f4034b[gVar.ordinal()];
        if (i2 == 1) {
            return this.n.a() ? g.DATA_CACHE : a(g.DATA_CACHE);
        } else if (i2 == 2) {
            return this.u ? g.FINISHED : g.SOURCE;
        } else if (i2 == 3 || i2 == 4) {
            return g.FINISHED;
        } else {
            if (i2 == 5) {
                return this.n.b() ? g.RESOURCE_CACHE : a(g.RESOURCE_CACHE);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized stage: ");
            sb.append(gVar);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void a(com.bumptech.glide.load.f fVar, Object obj, com.bumptech.glide.load.a.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.f fVar2) {
        this.x = fVar;
        this.z = obj;
        this.B = dVar;
        this.A = aVar;
        this.y = fVar2;
        if (Thread.currentThread() != this.w) {
            this.s = f.DECODE_DATA;
            this.p.a(this);
            return;
        }
        com.bumptech.glide.h.a.e.a("DecodeJob.decodeFromRetrievedData");
        try {
            e();
        } finally {
            com.bumptech.glide.h.a.e.a();
        }
    }

    public void a(com.bumptech.glide.load.f fVar, Exception exc, com.bumptech.glide.load.a.d<?> dVar, com.bumptech.glide.load.a aVar) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.a(fVar, aVar, dVar.a());
        this.f4037b.add(glideException);
        if (Thread.currentThread() != this.w) {
            this.s = f.SWITCH_TO_SOURCE_SERVICE;
            this.p.a(this);
            return;
        }
        k();
    }

    private <Data> G<R> a(com.bumptech.glide.load.a.d<?> dVar, Data data, com.bumptech.glide.load.a aVar) throws GlideException {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long a2 = h.a();
            G<R> a3 = a(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Decoded result ");
                sb.append(a3);
                a(sb.toString(), a2);
            }
            return a3;
        } finally {
            dVar.b();
        }
    }

    private <Data> G<R> a(Data data, com.bumptech.glide.load.a aVar) throws GlideException {
        return a(data, aVar, this.f4036a.a(data.getClass()));
    }

    private i a(com.bumptech.glide.load.a aVar) {
        i iVar = this.o;
        if (VERSION.SDK_INT < 26) {
            return iVar;
        }
        boolean z2 = aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || this.f4036a.o();
        Boolean bool = (Boolean) iVar.a(com.bumptech.glide.load.c.a.l.f3747d);
        if (bool != null && (!bool.booleanValue() || z2)) {
            return iVar;
        }
        i iVar2 = new i();
        iVar2.a(this.o);
        iVar2.a(com.bumptech.glide.load.c.a.l.f3747d, Boolean.valueOf(z2));
        return iVar2;
    }

    private <Data, ResourceType> G<R> a(Data data, com.bumptech.glide.load.a aVar, D<Data, ResourceType, R> d2) throws GlideException {
        i a2 = a(aVar);
        com.bumptech.glide.load.a.e b2 = this.f4043h.f().b(data);
        try {
            return d2.a(b2, a2, this.f4047l, this.m, new b(aVar));
        } finally {
            b2.b();
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
        sb.append(h.a(j2));
        sb.append(", load key: ");
        sb.append(this.f4046k);
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

    /* JADX WARNING: type inference failed for: r12v6, types: [com.bumptech.glide.load.engine.g] */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public <Z> G<Z> a(com.bumptech.glide.load.a aVar, G<Z> g2) {
        com.bumptech.glide.load.l lVar;
        G<Z> g3;
        com.bumptech.glide.load.c cVar;
        I i2;
        Class cls = g2.get().getClass();
        k kVar = null;
        if (aVar != com.bumptech.glide.load.a.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.l b2 = this.f4036a.b(cls);
            lVar = b2;
            g3 = b2.a(this.f4043h, g2, this.f4047l, this.m);
        } else {
            g3 = g2;
            lVar = null;
        }
        if (!g2.equals(g3)) {
            g2.a();
        }
        if (this.f4036a.b(g3)) {
            kVar = this.f4036a.a(g3);
            cVar = kVar.a(this.o);
        } else {
            cVar = com.bumptech.glide.load.c.NONE;
        }
        k kVar2 = kVar;
        if (!this.n.a(!this.f4036a.a(this.x), aVar, cVar)) {
            return g3;
        }
        if (kVar2 != null) {
            int i3 = C0297k.f4035c[cVar.ordinal()];
            if (i3 == 1) {
                i2 = new C0293g(this.x, this.f4044i);
            } else if (i3 == 2) {
                I i4 = new I(this.f4036a.b(), this.x, this.f4044i, this.f4047l, this.m, lVar, cls, this.o);
                i2 = i4;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown strategy: ");
                sb.append(cVar);
                throw new IllegalArgumentException(sb.toString());
            }
            F a2 = F.a(g3);
            this.f4041f.a(i2, kVar2, a2);
            return a2;
        }
        throw new NoResultEncoderAvailableException(g3.get().getClass());
    }
}
