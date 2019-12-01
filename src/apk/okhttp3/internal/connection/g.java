package okhttp3.internal.connection;

import i.C0716e;
import i.P;
import i.a.e;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy.Type;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: RealConnectionPool */
public final class g {

    /* renamed from: a reason: collision with root package name */
    private static final Executor f10496a;

    /* renamed from: b reason: collision with root package name */
    private final int f10497b;

    /* renamed from: c reason: collision with root package name */
    private final long f10498c;

    /* renamed from: d reason: collision with root package name */
    private final Runnable f10499d = new a(this);

    /* renamed from: e reason: collision with root package name */
    private final Deque<f> f10500e = new ArrayDeque();

    /* renamed from: f reason: collision with root package name */
    final h f10501f = new h();

    /* renamed from: g reason: collision with root package name */
    boolean f10502g;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), e.a("OkHttp ConnectionPool", true));
        f10496a = threadPoolExecutor;
    }

    public g(int i2, long j2, TimeUnit timeUnit) {
        this.f10497b = i2;
        this.f10498c = timeUnit.toNanos(j2);
        if (j2 <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("keepAliveDuration <= 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    public /* synthetic */ void a() {
        while (true) {
            long a2 = a(System.nanoTime());
            if (a2 != -1) {
                if (a2 > 0) {
                    long j2 = a2 / 1000000;
                    long j3 = a2 - (1000000 * j2);
                    synchronized (this) {
                        wait(j2, (int) j3);
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(f fVar) {
        if (!this.f10502g) {
            this.f10502g = true;
            f10496a.execute(this.f10499d);
        }
        this.f10500e.add(fVar);
    }

    /* access modifiers changed from: 0000 */
    public boolean a(C0716e eVar, k kVar, List<P> list, boolean z) {
        for (f fVar : this.f10500e) {
            if ((!z || fVar.c()) && fVar.a(eVar, list)) {
                kVar.a(fVar);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public boolean a(f fVar) {
        if (fVar.f10494k || this.f10497b == 0) {
            this.f10500e.remove(fVar);
            return true;
        }
        notifyAll();
        return false;
    }

    /* access modifiers changed from: 0000 */
    public long a(long j2) {
        synchronized (this) {
            long j3 = Long.MIN_VALUE;
            f fVar = null;
            int i2 = 0;
            int i3 = 0;
            for (f fVar2 : this.f10500e) {
                if (a(fVar2, j2) > 0) {
                    i3++;
                } else {
                    i2++;
                    long j4 = j2 - fVar2.q;
                    if (j4 > j3) {
                        fVar = fVar2;
                        j3 = j4;
                    }
                }
            }
            if (j3 < this.f10498c) {
                if (i2 <= this.f10497b) {
                    if (i2 > 0) {
                        long j5 = this.f10498c - j3;
                        return j5;
                    } else if (i3 > 0) {
                        long j6 = this.f10498c;
                        return j6;
                    } else {
                        this.f10502g = false;
                        return -1;
                    }
                }
            }
            this.f10500e.remove(fVar);
            e.a(fVar.f());
            return 0;
        }
    }

    private int a(f fVar, long j2) {
        List<Reference<k>> list = fVar.p;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference reference = (Reference) list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                a aVar = (a) reference;
                StringBuilder sb = new StringBuilder();
                sb.append("A connection to ");
                sb.append(fVar.e().a().k());
                sb.append(" was leaked. Did you forget to close a response body?");
                i.a.d.e.a().a(sb.toString(), aVar.f10527a);
                list.remove(i2);
                fVar.f10494k = true;
                if (list.isEmpty()) {
                    fVar.q = j2 - this.f10498c;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public void a(P p, IOException iOException) {
        if (p.b().type() != Type.DIRECT) {
            C0716e a2 = p.a();
            a2.h().connectFailed(a2.k().o(), p.b().address(), iOException);
        }
        this.f10501f.b(p);
    }
}
