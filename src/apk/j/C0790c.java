package j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: j.c reason: case insensitive filesystem */
/* compiled from: AsyncTimeout */
public class C0790c extends C {

    /* renamed from: e reason: collision with root package name */
    private static final long f10239e = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: f reason: collision with root package name */
    private static final long f10240f = TimeUnit.MILLISECONDS.toNanos(f10239e);

    /* renamed from: g reason: collision with root package name */
    static C0790c f10241g;

    /* renamed from: h reason: collision with root package name */
    private boolean f10242h;

    /* renamed from: i reason: collision with root package name */
    private C0790c f10243i;

    /* renamed from: j reason: collision with root package name */
    private long f10244j;

    /* renamed from: j.c$a */
    /* compiled from: AsyncTimeout */
    private static final class a extends Thread {
        a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.j();
         */
        public void run() {
            while (true) {
                try {
                    synchronized (C0790c.class) {
                        C0790c g2 = C0790c.g();
                        if (g2 != null) {
                            if (g2 == C0790c.f10241g) {
                                C0790c.f10241g = null;
                                return;
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private static synchronized void a(C0790c cVar, long j2, boolean z) {
        synchronized (C0790c.class) {
            if (f10241g == null) {
                f10241g = new C0790c();
                new a().start();
            }
            long nanoTime = System.nanoTime();
            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i2 != 0 && z) {
                cVar.f10244j = Math.min(j2, cVar.c() - nanoTime) + nanoTime;
            } else if (i2 != 0) {
                cVar.f10244j = j2 + nanoTime;
            } else if (z) {
                cVar.f10244j = cVar.c();
            } else {
                throw new AssertionError();
            }
            long b2 = cVar.b(nanoTime);
            C0790c cVar2 = f10241g;
            while (true) {
                if (cVar2.f10243i == null) {
                    break;
                } else if (b2 < cVar2.f10243i.b(nanoTime)) {
                    break;
                } else {
                    cVar2 = cVar2.f10243i;
                }
            }
            cVar.f10243i = cVar2.f10243i;
            cVar2.f10243i = cVar;
            if (cVar2 == f10241g) {
                C0790c.class.notify();
            }
        }
    }

    private long b(long j2) {
        return this.f10244j - j2;
    }

    static C0790c g() throws InterruptedException {
        C0790c cVar = f10241g.f10243i;
        C0790c cVar2 = null;
        if (cVar == null) {
            long nanoTime = System.nanoTime();
            C0790c.class.wait(f10239e);
            if (f10241g.f10243i == null && System.nanoTime() - nanoTime >= f10240f) {
                cVar2 = f10241g;
            }
            return cVar2;
        }
        long b2 = cVar.b(System.nanoTime());
        if (b2 > 0) {
            long j2 = b2 / 1000000;
            C0790c.class.wait(j2, (int) (b2 - (1000000 * j2)));
            return null;
        }
        f10241g.f10243i = cVar.f10243i;
        cVar.f10243i = null;
        return cVar;
    }

    public final void h() {
        if (!this.f10242h) {
            long f2 = f();
            boolean d2 = d();
            if (f2 != 0 || d2) {
                this.f10242h = true;
                a(this, f2, d2);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean i() {
        if (!this.f10242h) {
            return false;
        }
        this.f10242h = false;
        return a(this);
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public IOException b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static synchronized boolean a(C0790c cVar) {
        synchronized (C0790c.class) {
            for (C0790c cVar2 = f10241g; cVar2 != null; cVar2 = cVar2.f10243i) {
                if (cVar2.f10243i == cVar) {
                    cVar2.f10243i = cVar.f10243i;
                    cVar.f10243i = null;
                    return false;
                }
            }
            return true;
        }
    }

    public final z a(z zVar) {
        return new C0788a(this, zVar);
    }

    public final A a(A a2) {
        return new C0789b(this, a2);
    }

    /* access modifiers changed from: 0000 */
    public final void a(boolean z) throws IOException {
        if (i() && z) {
            throw b((IOException) null);
        }
    }

    /* access modifiers changed from: 0000 */
    public final IOException a(IOException iOException) throws IOException {
        if (!i()) {
            return iOException;
        }
        return b(iOException);
    }
}
