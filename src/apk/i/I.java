package i;

import i.a.a.b;
import i.a.b.h;
import i.a.d;
import i.a.d.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.connection.k;

/* compiled from: RealCall */
final class I implements C0721j {

    /* renamed from: a reason: collision with root package name */
    final G f8494a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public k f8495b;

    /* renamed from: c reason: collision with root package name */
    final J f8496c;

    /* renamed from: d reason: collision with root package name */
    final boolean f8497d;

    /* renamed from: e reason: collision with root package name */
    private boolean f8498e;

    /* compiled from: RealCall */
    final class a extends d {

        /* renamed from: b reason: collision with root package name */
        private final C0722k f8499b;

        /* renamed from: c reason: collision with root package name */
        private volatile AtomicInteger f8500c = new AtomicInteger(0);

        a(C0722k kVar) {
            super("OkHttp %s", I.this.b());
            this.f8499b = kVar;
        }

        /* access modifiers changed from: 0000 */
        public void a(a aVar) {
            this.f8500c = aVar.f8500c;
        }

        /* access modifiers changed from: 0000 */
        public AtomicInteger b() {
            return this.f8500c;
        }

        /* access modifiers changed from: 0000 */
        public I c() {
            return I.this;
        }

        /* access modifiers changed from: 0000 */
        public String d() {
            return I.this.f8496c.g().g();
        }

        /* access modifiers changed from: 0000 */
        public void a(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e2) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e2);
                I.this.f8495b.a((IOException) interruptedIOException);
                this.f8499b.a((C0721j) I.this, (IOException) interruptedIOException);
                I.this.f8494a.h().b(this);
            } catch (Throwable th) {
                I.this.f8494a.h().b(this);
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002d A[SYNTHETIC, Splitter:B:12:0x002d] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A[Catch:{ all -> 0x0026 }] */
        public void a() {
            boolean z;
            IOException e2;
            I.this.f8495b.i();
            try {
                z = true;
                try {
                    this.f8499b.a((C0721j) I.this, I.this.a());
                } catch (IOException e3) {
                    e2 = e3;
                    if (!z) {
                    }
                    I.this.f8494a.h().b(this);
                }
            } catch (IOException e4) {
                e2 = e4;
                z = false;
                if (!z) {
                    try {
                        e a2 = e.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Callback failure for ");
                        sb.append(I.this.c());
                        a2.a(4, sb.toString(), (Throwable) e2);
                    } catch (Throwable th) {
                        I.this.f8494a.h().b(this);
                        throw th;
                    }
                } else {
                    this.f8499b.a((C0721j) I.this, e2);
                }
                I.this.f8494a.h().b(this);
            }
            I.this.f8494a.h().b(this);
        }
    }

    private I(G g2, J j2, boolean z) {
        this.f8494a = g2;
        this.f8496c = j2;
        this.f8497d = z;
    }

    /* access modifiers changed from: 0000 */
    public String b() {
        return this.f8496c.g().m();
    }

    /* access modifiers changed from: 0000 */
    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.f8497d ? "web socket" : "call");
        sb.append(" to ");
        sb.append(b());
        return sb.toString();
    }

    public void cancel() {
        this.f8495b.c();
    }

    public M execute() throws IOException {
        synchronized (this) {
            if (!this.f8498e) {
                this.f8498e = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f8495b.i();
        this.f8495b.a();
        try {
            this.f8494a.h().a(this);
            return a();
        } finally {
            this.f8494a.h().b(this);
        }
    }

    public boolean isCanceled() {
        return this.f8495b.f();
    }

    static I a(G g2, J j2, boolean z) {
        I i2 = new I(g2, j2, z);
        i2.f8495b = new k(g2, i2);
        return i2;
    }

    public I clone() {
        return a(this.f8494a, this.f8496c, this.f8497d);
    }

    public void a(C0722k kVar) {
        synchronized (this) {
            if (!this.f8498e) {
                this.f8498e = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f8495b.a();
        this.f8494a.h().a(new a(kVar));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a5  */
    public M a() throws IOException {
        Throwable th;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f8494a.n());
        arrayList.add(new i.a.b.k(this.f8494a));
        arrayList.add(new i.a.b.a(this.f8494a.g()));
        arrayList.add(new b(this.f8494a.o()));
        arrayList.add(new okhttp3.internal.connection.b(this.f8494a));
        if (!this.f8497d) {
            arrayList.addAll(this.f8494a.p());
        }
        arrayList.add(new i.a.b.b(this.f8497d));
        h hVar = new h(arrayList, this.f8495b, null, 0, this.f8496c, this, this.f8494a.d(), this.f8494a.v(), this.f8494a.C());
        boolean z = false;
        try {
            M a2 = hVar.a(this.f8496c);
            if (!this.f8495b.f()) {
                this.f8495b.a((IOException) null);
                return a2;
            }
            i.a.e.a((Closeable) a2);
            throw new IOException("Canceled");
        } catch (IOException e2) {
            throw this.f8495b.a(e2);
        } catch (Throwable th2) {
            th = th2;
            z = true;
            if (!z) {
            }
            throw th;
        }
    }
}
