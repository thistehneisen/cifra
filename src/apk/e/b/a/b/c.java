package e.b.a.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import e.b.n;
import java.util.concurrent.TimeUnit;

/* compiled from: HandlerScheduler */
final class c extends n {

    /* renamed from: b reason: collision with root package name */
    private final Handler f7939b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f7940c;

    /* compiled from: HandlerScheduler */
    private static final class a extends e.b.n.b {

        /* renamed from: a reason: collision with root package name */
        private final Handler f7941a;

        /* renamed from: b reason: collision with root package name */
        private final boolean f7942b;

        /* renamed from: c reason: collision with root package name */
        private volatile boolean f7943c;

        a(Handler handler, boolean z) {
            this.f7941a = handler;
            this.f7942b = z;
        }

        @SuppressLint({"NewApi"})
        public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f7943c) {
                return e.b.b.c.a();
            } else {
                b bVar = new b(this.f7941a, e.b.g.a.a(runnable));
                Message obtain = Message.obtain(this.f7941a, bVar);
                obtain.obj = this;
                if (this.f7942b) {
                    obtain.setAsynchronous(true);
                }
                this.f7941a.sendMessageDelayed(obtain, timeUnit.toMillis(j2));
                if (!this.f7943c) {
                    return bVar;
                }
                this.f7941a.removeCallbacks(bVar);
                return e.b.b.c.a();
            }
        }

        public void b() {
            this.f7943c = true;
            this.f7941a.removeCallbacksAndMessages(this);
        }

        public boolean a() {
            return this.f7943c;
        }
    }

    /* compiled from: HandlerScheduler */
    private static final class b implements Runnable, e.b.b.b {

        /* renamed from: a reason: collision with root package name */
        private final Handler f7944a;

        /* renamed from: b reason: collision with root package name */
        private final Runnable f7945b;

        /* renamed from: c reason: collision with root package name */
        private volatile boolean f7946c;

        b(Handler handler, Runnable runnable) {
            this.f7944a = handler;
            this.f7945b = runnable;
        }

        public boolean a() {
            return this.f7946c;
        }

        public void b() {
            this.f7944a.removeCallbacks(this);
            this.f7946c = true;
        }

        public void run() {
            try {
                this.f7945b.run();
            } catch (Throwable th) {
                e.b.g.a.b(th);
            }
        }
    }

    c(Handler handler, boolean z) {
        this.f7939b = handler;
        this.f7940c = z;
    }

    @SuppressLint({"NewApi"})
    public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            b bVar = new b(this.f7939b, e.b.g.a.a(runnable));
            Message obtain = Message.obtain(this.f7939b, bVar);
            if (this.f7940c) {
                obtain.setAsynchronous(true);
            }
            this.f7939b.sendMessageDelayed(obtain, timeUnit.toMillis(j2));
            return bVar;
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public e.b.n.b a() {
        return new a(this.f7939b, this.f7940c);
    }
}
