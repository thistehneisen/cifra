package okhttp3.internal.http2;

import i.a.e;
import j.f;
import j.g;
import j.h;
import j.i;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Connection */
public final class k implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public static final ExecutorService f10594a;

    /* renamed from: b reason: collision with root package name */
    final boolean f10595b;

    /* renamed from: c reason: collision with root package name */
    final b f10596c;

    /* renamed from: d reason: collision with root package name */
    final Map<Integer, r> f10597d = new LinkedHashMap();

    /* renamed from: e reason: collision with root package name */
    final String f10598e;

    /* renamed from: f reason: collision with root package name */
    int f10599f;

    /* renamed from: g reason: collision with root package name */
    int f10600g;

    /* renamed from: h reason: collision with root package name */
    boolean f10601h;
    /* access modifiers changed from: private */

    /* renamed from: i reason: collision with root package name */
    public final ScheduledExecutorService f10602i;

    /* renamed from: j reason: collision with root package name */
    private final ExecutorService f10603j;

    /* renamed from: k reason: collision with root package name */
    final v f10604k;
    /* access modifiers changed from: private */

    /* renamed from: l reason: collision with root package name */
    public boolean f10605l;
    long m = 0;
    long n;
    w o = new w();
    final w p = new w();
    boolean q = false;
    final Socket r;
    final s s;
    final d t;
    final Set<Integer> u = new LinkedHashSet();

    /* compiled from: Http2Connection */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        Socket f10606a;

        /* renamed from: b reason: collision with root package name */
        String f10607b;

        /* renamed from: c reason: collision with root package name */
        h f10608c;

        /* renamed from: d reason: collision with root package name */
        g f10609d;

        /* renamed from: e reason: collision with root package name */
        b f10610e = b.f10614a;

        /* renamed from: f reason: collision with root package name */
        v f10611f = v.f10684a;

        /* renamed from: g reason: collision with root package name */
        boolean f10612g;

        /* renamed from: h reason: collision with root package name */
        int f10613h;

        public a(boolean z) {
            this.f10612g = z;
        }

        public a a(Socket socket, String str, h hVar, g gVar) {
            this.f10606a = socket;
            this.f10607b = str;
            this.f10608c = hVar;
            this.f10609d = gVar;
            return this;
        }

        public a a(b bVar) {
            this.f10610e = bVar;
            return this;
        }

        public a a(int i2) {
            this.f10613h = i2;
            return this;
        }

        public k a() {
            return new k(this);
        }
    }

    /* compiled from: Http2Connection */
    public static abstract class b {

        /* renamed from: a reason: collision with root package name */
        public static final b f10614a = new l();

        public void a(k kVar) {
        }

        public abstract void a(r rVar) throws IOException;
    }

    /* compiled from: Http2Connection */
    final class c extends i.a.d {

        /* renamed from: b reason: collision with root package name */
        final boolean f10615b;

        /* renamed from: c reason: collision with root package name */
        final int f10616c;

        /* renamed from: d reason: collision with root package name */
        final int f10617d;

        c(boolean z, int i2, int i3) {
            super("OkHttp %s ping %08x%08x", k.this.f10598e, Integer.valueOf(i2), Integer.valueOf(i3));
            this.f10615b = z;
            this.f10616c = i2;
            this.f10617d = i3;
        }

        public void a() {
            k.this.a(this.f10615b, this.f10616c, this.f10617d);
        }
    }

    /* compiled from: Http2Connection */
    class d extends i.a.d implements b {

        /* renamed from: b reason: collision with root package name */
        final q f10619b;

        d(q qVar) {
            super("OkHttp %s", k.this.f10598e);
            this.f10619b = qVar;
        }

        /* access modifiers changed from: protected */
        public void a() {
            a aVar;
            a aVar2;
            a aVar3 = a.INTERNAL_ERROR;
            e = null;
            try {
                this.f10619b.a((b) this);
                while (this.f10619b.a(false, (b) this)) {
                }
                aVar = a.NO_ERROR;
                try {
                    aVar2 = a.CANCEL;
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
                aVar = aVar3;
                try {
                    aVar = a.PROTOCOL_ERROR;
                    aVar2 = a.PROTOCOL_ERROR;
                    k.this.a(aVar, aVar2, e);
                    e.a((Closeable) this.f10619b);
                } catch (Throwable th) {
                    th = th;
                    k.this.a(aVar, aVar3, e);
                    e.a((Closeable) this.f10619b);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = aVar3;
                k.this.a(aVar, aVar3, e);
                e.a((Closeable) this.f10619b);
                throw th;
            }
            k.this.a(aVar, aVar2, e);
            e.a((Closeable) this.f10619b);
        }

        public void ackSettings() {
        }

        public void headers(boolean z, int i2, int i3, List<b> list) {
            if (k.this.b(i2)) {
                k.this.a(i2, list, z);
                return;
            }
            synchronized (k.this) {
                r a2 = k.this.a(i2);
                if (a2 != null) {
                    a2.a(e.b(list), z);
                } else if (!k.this.f10601h) {
                    if (i2 > k.this.f10599f) {
                        if (i2 % 2 != k.this.f10600g % 2) {
                            int i4 = i2;
                            r rVar = new r(i4, k.this, false, z, e.b(list));
                            k.this.f10599f = i2;
                            k.this.f10597d.put(Integer.valueOf(i2), rVar);
                            k.f10594a.execute(new m(this, "OkHttp %s stream %d", new Object[]{k.this.f10598e, Integer.valueOf(i2)}, rVar));
                        }
                    }
                }
            }
        }

        public void ping(boolean z, int i2, int i3) {
            if (z) {
                synchronized (k.this) {
                    k.this.f10605l = false;
                    k.this.notifyAll();
                }
                return;
            }
            try {
                k.this.f10602i.execute(new c(true, i2, i3));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void priority(int i2, int i3, int i4, boolean z) {
        }

        public void pushPromise(int i2, int i3, List<b> list) {
            k.this.a(i3, list);
        }

        public void windowUpdate(int i2, long j2) {
            if (i2 == 0) {
                synchronized (k.this) {
                    k.this.n += j2;
                    k.this.notifyAll();
                }
                return;
            }
            r a2 = k.this.a(i2);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j2);
                }
            }
        }

        public void a(boolean z, int i2, h hVar, int i3) throws IOException {
            if (k.this.b(i2)) {
                k.this.a(i2, hVar, i3, z);
                return;
            }
            r a2 = k.this.a(i2);
            if (a2 == null) {
                k.this.c(i2, a.PROTOCOL_ERROR);
                long j2 = (long) i3;
                k.this.h(j2);
                hVar.skip(j2);
                return;
            }
            a2.a(hVar, i3);
            if (z) {
                a2.a(e.f8655c, true);
            }
        }

        public void a(int i2, a aVar) {
            if (k.this.b(i2)) {
                k.this.a(i2, aVar);
                return;
            }
            r c2 = k.this.c(i2);
            if (c2 != null) {
                c2.b(aVar);
            }
        }

        public void a(boolean z, w wVar) {
            r[] rVarArr;
            long j2;
            int i2;
            synchronized (k.this) {
                int c2 = k.this.p.c();
                if (z) {
                    k.this.p.a();
                }
                k.this.p.a(wVar);
                a(wVar);
                int c3 = k.this.p.c();
                rVarArr = null;
                if (c3 == -1 || c3 == c2) {
                    j2 = 0;
                } else {
                    j2 = (long) (c3 - c2);
                    if (!k.this.q) {
                        k.this.q = true;
                    }
                    if (!k.this.f10597d.isEmpty()) {
                        rVarArr = (r[]) k.this.f10597d.values().toArray(new r[k.this.f10597d.size()]);
                    }
                }
                k.f10594a.execute(new n(this, "OkHttp %s settings", k.this.f10598e));
            }
            if (rVarArr != null && j2 != 0) {
                for (r rVar : rVarArr) {
                    synchronized (rVar) {
                        rVar.a(j2);
                    }
                }
            }
        }

        private void a(w wVar) {
            try {
                k.this.f10602i.execute(new o(this, "OkHttp %s ACK Settings", new Object[]{k.this.f10598e}, wVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void a(int i2, a aVar, i iVar) {
            r[] rVarArr;
            iVar.size();
            synchronized (k.this) {
                rVarArr = (r[]) k.this.f10597d.values().toArray(new r[k.this.f10597d.size()]);
                k.this.f10601h = true;
            }
            for (r rVar : rVarArr) {
                if (rVar.c() > i2 && rVar.f()) {
                    rVar.b(a.REFUSED_STREAM);
                    k.this.c(rVar.c());
                }
            }
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), e.a("OkHttp Http2Connection", true));
        f10594a = threadPoolExecutor;
    }

    k(a aVar) {
        a aVar2 = aVar;
        this.f10604k = aVar2.f10611f;
        boolean z = aVar2.f10612g;
        this.f10595b = z;
        this.f10596c = aVar2.f10610e;
        this.f10600g = z ? 1 : 2;
        if (aVar2.f10612g) {
            this.f10600g += 2;
        }
        if (aVar2.f10612g) {
            this.o.a(7, 16777216);
        }
        this.f10598e = aVar2.f10607b;
        this.f10602i = new ScheduledThreadPoolExecutor(1, e.a(e.a("OkHttp %s Writer", this.f10598e), false));
        if (aVar2.f10613h != 0) {
            ScheduledExecutorService scheduledExecutorService = this.f10602i;
            c cVar = new c(false, 0, 0);
            int i2 = aVar2.f10613h;
            scheduledExecutorService.scheduleAtFixedRate(cVar, (long) i2, (long) i2, TimeUnit.MILLISECONDS);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), e.a(e.a("OkHttp %s Push Observer", this.f10598e), true));
        this.f10603j = threadPoolExecutor;
        this.p.a(7, 65535);
        this.p.a(5, 16384);
        this.n = (long) this.p.c();
        this.r = aVar2.f10606a;
        this.s = new s(aVar2.f10609d, this.f10595b);
        this.t = new d(new q(aVar2.f10608c, this.f10595b));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    private r b(int i2, List<b> list, boolean z) throws IOException {
        int i3;
        r rVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.s) {
            synchronized (this) {
                if (this.f10600g > 1073741823) {
                    a(a.REFUSED_STREAM);
                }
                if (!this.f10601h) {
                    i3 = this.f10600g;
                    this.f10600g += 2;
                    rVar = new r(i3, this, z3, false, null);
                    if (z && this.n != 0) {
                        if (rVar.f10646b != 0) {
                            z2 = false;
                            if (rVar.g()) {
                                this.f10597d.put(Integer.valueOf(i3), rVar);
                            }
                        }
                    }
                    z2 = true;
                    if (rVar.g()) {
                    }
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            if (i2 == 0) {
                this.s.a(z3, i3, list);
            } else if (!this.f10595b) {
                this.s.a(i2, i3, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z2) {
            this.s.flush();
        }
        return rVar;
    }

    /* access modifiers changed from: 0000 */
    public boolean b(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    /* access modifiers changed from: 0000 */
    public synchronized r c(int i2) {
        r rVar;
        rVar = (r) this.f10597d.remove(Integer.valueOf(i2));
        notifyAll();
        return rVar;
    }

    public void close() {
        a(a.NO_ERROR, a.CANCEL, (IOException) null);
    }

    public void d() throws IOException {
        a(true);
    }

    public void flush() throws IOException {
        this.s.flush();
    }

    /* access modifiers changed from: 0000 */
    public synchronized void h(long j2) {
        this.m += j2;
        if (this.m >= ((long) (this.o.c() / 2))) {
            a(0, this.m);
            this.m = 0;
        }
    }

    public synchronized int c() {
        return this.p.b(Integer.MAX_VALUE);
    }

    /* access modifiers changed from: 0000 */
    public synchronized r a(int i2) {
        return (r) this.f10597d.get(Integer.valueOf(i2));
    }

    /* access modifiers changed from: 0000 */
    public void c(int i2, a aVar) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.f10602i;
            e eVar = new e(this, "OkHttp %s stream %d", new Object[]{this.f10598e, Integer.valueOf(i2)}, i2, aVar);
            scheduledExecutorService.execute(eVar);
        } catch (RejectedExecutionException unused) {
        }
    }

    public r a(List<b> list, boolean z) throws IOException {
        return b(0, list, z);
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, boolean z, List<b> list) throws IOException {
        this.s.a(z, i2, list);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.n), r8.s.b());
        r6 = (long) r3;
        r8.n -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    public void a(int i2, boolean z, f fVar, long j2) throws IOException {
        int min;
        long j3;
        if (j2 == 0) {
            this.s.a(z, i2, fVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (true) {
                    if (this.n > 0) {
                        break;
                    } else if (this.f10597d.containsKey(Integer.valueOf(i2))) {
                        wait();
                    } else {
                        throw new IOException("stream closed");
                    }
                }
            }
            j2 -= j3;
            this.s.a(z && j2 == 0, i2, fVar, min);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, long j2) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.f10602i;
            f fVar = new f(this, "OkHttp Window Update %s stream %d", new Object[]{this.f10598e, Integer.valueOf(i2)}, i2, j2);
            scheduledExecutorService.execute(fVar);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(int i2, a aVar) throws IOException {
        this.s.a(i2, aVar);
    }

    public synchronized boolean b() {
        return this.f10601h;
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z, int i2, int i3) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.f10605l;
                this.f10605l = true;
            }
            if (z2) {
                a((IOException) null);
                return;
            }
        }
        try {
            this.s.a(z, i2, i3);
        } catch (IOException e2) {
            a(e2);
        }
    }

    public void a(a aVar) throws IOException {
        synchronized (this.s) {
            synchronized (this) {
                if (!this.f10601h) {
                    this.f10601h = true;
                    int i2 = this.f10599f;
                    this.s.a(i2, aVar, e.f8653a);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003a */
    public void a(a aVar, a aVar2, IOException iOException) {
        try {
            a(aVar);
        } catch (IOException unused) {
        }
        r[] rVarArr = null;
        synchronized (this) {
            if (!this.f10597d.isEmpty()) {
                rVarArr = (r[]) this.f10597d.values().toArray(new r[this.f10597d.size()]);
                this.f10597d.clear();
            }
        }
        if (rVarArr != null) {
            for (r a2 : rVarArr) {
                try {
                    a2.a(aVar2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        this.s.close();
        try {
            this.r.close();
        } catch (IOException unused3) {
        }
        this.f10602i.shutdown();
        this.f10603j.shutdown();
    }

    /* access modifiers changed from: private */
    public void a(IOException iOException) {
        a aVar = a.PROTOCOL_ERROR;
        a(aVar, aVar, iOException);
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z) throws IOException {
        if (z) {
            this.s.a();
            this.s.b(this.o);
            int c2 = this.o.c();
            if (c2 != 65535) {
                this.s.a(0, (long) (c2 - 65535));
            }
        }
        new Thread(this.t).start();
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r3 = r8;
        r2 = new okhttp3.internal.http2.g(r3, "OkHttp %s Push Request[%s]", new java.lang.Object[]{r8.f10598e, java.lang.Integer.valueOf(r9)}, r9, r10);
        a((i.a.d) r2);
     */
    public void a(int i2, List<b> list) {
        synchronized (this) {
            if (this.u.contains(Integer.valueOf(i2))) {
                c(i2, a.PROTOCOL_ERROR);
                return;
            }
            this.u.add(Integer.valueOf(i2));
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, List<b> list, boolean z) {
        try {
            h hVar = new h(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f10598e, Integer.valueOf(i2)}, i2, list, z);
            a((i.a.d) hVar);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, h hVar, int i3, boolean z) throws IOException {
        f fVar = new f();
        long j2 = (long) i3;
        hVar.e(j2);
        hVar.b(fVar, j2);
        if (fVar.size() == j2) {
            i iVar = new i(this, "OkHttp %s Push Data[%s]", new Object[]{this.f10598e, Integer.valueOf(i2)}, i2, fVar, i3, z);
            a((i.a.d) iVar);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fVar.size());
        sb.append(" != ");
        sb.append(i3);
        throw new IOException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, a aVar) {
        j jVar = new j(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f10598e, Integer.valueOf(i2)}, i2, aVar);
        a((i.a.d) jVar);
    }

    private synchronized void a(i.a.d dVar) {
        if (!b()) {
            this.f10603j.execute(dVar);
        }
    }
}
