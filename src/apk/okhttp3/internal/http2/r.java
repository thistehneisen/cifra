package okhttp3.internal.http2;

import i.A;
import j.C;
import j.C0790c;
import j.f;
import j.h;
import j.z;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;

/* compiled from: Http2Stream */
public final class r {

    /* renamed from: a reason: collision with root package name */
    long f10645a = 0;

    /* renamed from: b reason: collision with root package name */
    long f10646b;

    /* renamed from: c reason: collision with root package name */
    final int f10647c;

    /* renamed from: d reason: collision with root package name */
    final k f10648d;

    /* renamed from: e reason: collision with root package name */
    private final Deque<A> f10649e = new ArrayDeque();

    /* renamed from: f reason: collision with root package name */
    private boolean f10650f;

    /* renamed from: g reason: collision with root package name */
    private final b f10651g;

    /* renamed from: h reason: collision with root package name */
    final a f10652h;

    /* renamed from: i reason: collision with root package name */
    final c f10653i = new c();

    /* renamed from: j reason: collision with root package name */
    final c f10654j = new c();

    /* renamed from: k reason: collision with root package name */
    a f10655k;

    /* renamed from: l reason: collision with root package name */
    IOException f10656l;

    /* compiled from: Http2Stream */
    final class a implements z {

        /* renamed from: a reason: collision with root package name */
        private final f f10657a = new f();

        /* renamed from: b reason: collision with root package name */
        private A f10658b;

        /* renamed from: c reason: collision with root package name */
        boolean f10659c;

        /* renamed from: d reason: collision with root package name */
        boolean f10660d;

        a() {
        }

        public void a(f fVar, long j2) throws IOException {
            this.f10657a.a(fVar, j2);
            while (this.f10657a.size() >= 16384) {
                a(false);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            if (r8.f10657a.size() <= 0) goto L_0x0022;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            if (r8.f10658b == null) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
            if (r3 == false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
            if (r8.f10657a.size() <= 0) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
            a(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
            r0 = r8.f10661e;
            r0.f10648d.a(r0.f10647c, true, i.a.e.a(r8.f10658b));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
            if (r2 == false) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
            if (r8.f10657a.size() <= 0) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005a, code lost:
            r0 = r8.f10661e;
            r0.f10648d.a(r0.f10647c, true, (j.f) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
            r2 = r8.f10661e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0069, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r8.f10659c = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x006c, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006d, code lost:
            r8.f10661e.f10648d.flush();
            r8.f10661e.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0079, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.f10661e.f10652h.f10660d != false) goto L_0x0067;
         */
        public void close() throws IOException {
            synchronized (r.this) {
                if (this.f10659c) {
                }
            }
        }

        public void flush() throws IOException {
            synchronized (r.this) {
                r.this.b();
            }
            while (this.f10657a.size() > 0) {
                a(false);
                r.this.f10648d.flush();
            }
        }

        public C timeout() {
            return r.this.f10654j;
        }

        /* JADX INFO: finally extract failed */
        private void a(boolean z) throws IOException {
            long min;
            boolean z2;
            synchronized (r.this) {
                r.this.f10654j.h();
                while (r.this.f10646b <= 0 && !this.f10660d && !this.f10659c && r.this.f10655k == null) {
                    try {
                        r.this.j();
                    } catch (Throwable th) {
                        r.this.f10654j.k();
                        throw th;
                    }
                }
                r.this.f10654j.k();
                r.this.b();
                min = Math.min(r.this.f10646b, this.f10657a.size());
                r.this.f10646b -= min;
            }
            r.this.f10654j.h();
            if (z) {
                try {
                    if (min == this.f10657a.size()) {
                        z2 = true;
                        r.this.f10648d.a(r.this.f10647c, z2, this.f10657a, min);
                        r.this.f10654j.k();
                    }
                } catch (Throwable th2) {
                    r.this.f10654j.k();
                    throw th2;
                }
            }
            z2 = false;
            r.this.f10648d.a(r.this.f10647c, z2, this.f10657a, min);
            r.this.f10654j.k();
        }
    }

    /* compiled from: Http2Stream */
    private final class b implements j.A {

        /* renamed from: a reason: collision with root package name */
        private final f f10662a = new f();

        /* renamed from: b reason: collision with root package name */
        private final f f10663b = new f();

        /* renamed from: c reason: collision with root package name */
        private final long f10664c;
        /* access modifiers changed from: private */

        /* renamed from: d reason: collision with root package name */
        public A f10665d;

        /* renamed from: e reason: collision with root package name */
        boolean f10666e;

        /* renamed from: f reason: collision with root package name */
        boolean f10667f;

        b(long j2) {
            this.f10664c = j2;
        }

        private void f(long j2) {
            r.this.f10648d.h(j2);
        }

        public long b(f fVar, long j2) throws IOException {
            Throwable th;
            long b2;
            if (j2 >= 0) {
                while (true) {
                    th = null;
                    synchronized (r.this) {
                        r.this.f10653i.h();
                        try {
                            if (r.this.f10655k != null) {
                                if (r.this.f10656l != null) {
                                    th = r.this.f10656l;
                                } else {
                                    th = new StreamResetException(r.this.f10655k);
                                }
                            }
                            if (this.f10666e) {
                                throw new IOException("stream closed");
                            } else if (this.f10663b.size() > 0) {
                                b2 = this.f10663b.b(fVar, Math.min(j2, this.f10663b.size()));
                                r.this.f10645a += b2;
                                if (th == null && r.this.f10645a >= ((long) (r.this.f10648d.o.c() / 2))) {
                                    r.this.f10648d.a(r.this.f10647c, r.this.f10645a);
                                    r.this.f10645a = 0;
                                }
                            } else if (this.f10667f || th != null) {
                                b2 = -1;
                            } else {
                                r.this.j();
                            }
                        } finally {
                            r.this.f10653i.k();
                        }
                    }
                }
                b2 = -1;
                r.this.f10653i.k();
                if (b2 != -1) {
                    f(b2);
                    return b2;
                } else if (th == null) {
                    return -1;
                } else {
                    throw th;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j2);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public void close() throws IOException {
            long size;
            synchronized (r.this) {
                this.f10666e = true;
                size = this.f10663b.size();
                this.f10663b.a();
                r.this.notifyAll();
            }
            if (size > 0) {
                f(size);
            }
            r.this.a();
        }

        public C timeout() {
            return r.this.f10653i;
        }

        /* access modifiers changed from: 0000 */
        public void a(h hVar, long j2) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j2 > 0) {
                synchronized (r.this) {
                    z = this.f10667f;
                    z2 = true;
                    z3 = this.f10663b.size() + j2 > this.f10664c;
                }
                if (z3) {
                    hVar.skip(j2);
                    r.this.a(a.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    hVar.skip(j2);
                    return;
                } else {
                    long b2 = hVar.b(this.f10662a, j2);
                    if (b2 != -1) {
                        j2 -= b2;
                        synchronized (r.this) {
                            if (this.f10663b.size() != 0) {
                                z2 = false;
                            }
                            this.f10663b.a((j.A) this.f10662a);
                            if (z2) {
                                r.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }
    }

    /* compiled from: Http2Stream */
    class c extends C0790c {
        c() {
        }

        /* access modifiers changed from: protected */
        public IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        public void j() {
            r.this.a(a.CANCEL);
        }

        public void k() throws IOException {
            if (i()) {
                throw b(null);
            }
        }
    }

    r(int i2, k kVar, boolean z, boolean z2, A a2) {
        if (kVar != null) {
            this.f10647c = i2;
            this.f10648d = kVar;
            this.f10646b = (long) kVar.p.c();
            this.f10651g = new b((long) kVar.o.c());
            this.f10652h = new a();
            this.f10651g.f10667f = z2;
            this.f10652h.f10660d = z;
            if (a2 != null) {
                this.f10649e.add(a2);
            }
            if (f() && a2 != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!f() && a2 == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    private boolean b(a aVar, IOException iOException) {
        synchronized (this) {
            if (this.f10655k != null) {
                return false;
            }
            if (this.f10651g.f10667f && this.f10652h.f10660d) {
                return false;
            }
            this.f10655k = aVar;
            this.f10656l = iOException;
            notifyAll();
            this.f10648d.c(this.f10647c);
            return true;
        }
    }

    public void a(a aVar, IOException iOException) throws IOException {
        if (b(aVar, iOException)) {
            this.f10648d.b(this.f10647c, aVar);
        }
    }

    public int c() {
        return this.f10647c;
    }

    public z d() {
        synchronized (this) {
            if (!this.f10650f) {
                if (!f()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f10652h;
    }

    public j.A e() {
        return this.f10651g;
    }

    public boolean f() {
        if (this.f10648d.f10595b == ((this.f10647c & 1) == 1)) {
            return true;
        }
        return false;
    }

    public synchronized boolean g() {
        if (this.f10655k != null) {
            return false;
        }
        if ((this.f10651g.f10667f || this.f10651g.f10666e) && ((this.f10652h.f10660d || this.f10652h.f10659c) && this.f10650f)) {
            return false;
        }
        return true;
    }

    public C h() {
        return this.f10653i;
    }

    /* JADX INFO: finally extract failed */
    public synchronized A i() throws IOException {
        this.f10653i.h();
        while (this.f10649e.isEmpty() && this.f10655k == null) {
            try {
                j();
            } catch (Throwable th) {
                this.f10653i.k();
                throw th;
            }
        }
        this.f10653i.k();
        if (this.f10649e.isEmpty()) {
            throw (this.f10656l != null ? this.f10656l : new StreamResetException(this.f10655k));
        }
        return (A) this.f10649e.removeFirst();
    }

    /* access modifiers changed from: 0000 */
    public void j() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public C k() {
        return this.f10654j;
    }

    public void a(a aVar) {
        if (b(aVar, null)) {
            this.f10648d.c(this.f10647c, aVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(h hVar, int i2) throws IOException {
        this.f10651g.a(hVar, (long) i2);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    public void a(A a2, boolean z) {
        boolean g2;
        synchronized (this) {
            if (this.f10650f) {
                if (z) {
                    this.f10651g.f10665d = a2;
                    if (z) {
                        this.f10651g.f10667f = true;
                    }
                    g2 = g();
                    notifyAll();
                }
            }
            this.f10650f = true;
            this.f10649e.add(a2);
            if (z) {
            }
            g2 = g();
            notifyAll();
        }
        if (!g2) {
            this.f10648d.c(this.f10647c);
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void b(a aVar) {
        if (this.f10655k == null) {
            this.f10655k = aVar;
            notifyAll();
        }
    }

    /* access modifiers changed from: 0000 */
    public void b() throws IOException {
        a aVar = this.f10652h;
        if (aVar.f10659c) {
            throw new IOException("stream closed");
        } else if (!aVar.f10660d) {
            a aVar2 = this.f10655k;
            if (aVar2 != null) {
                Throwable th = this.f10656l;
                if (th == null) {
                    th = new StreamResetException(aVar2);
                }
                throw th;
            }
        } else {
            throw new IOException("stream finished");
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() throws IOException {
        boolean z;
        boolean g2;
        synchronized (this) {
            z = !this.f10651g.f10667f && this.f10651g.f10666e && (this.f10652h.f10660d || this.f10652h.f10659c);
            g2 = g();
        }
        if (z) {
            a(a.CANCEL, (IOException) null);
        } else if (!g2) {
            this.f10648d.c(this.f10647c);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(long j2) {
        this.f10646b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }
}
