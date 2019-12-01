package io.intercom.com.bumptech.glide.f;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import io.intercom.com.bumptech.glide.f.a.g;
import io.intercom.com.bumptech.glide.f.a.h;
import io.intercom.com.bumptech.glide.f.b.d;
import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.load.engine.GlideException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestFutureTarget */
public class e<R> implements b<R>, f<R>, Runnable {

    /* renamed from: a reason: collision with root package name */
    private static final b f9324a = new b();

    /* renamed from: b reason: collision with root package name */
    private final Handler f9325b;

    /* renamed from: c reason: collision with root package name */
    private final int f9326c;

    /* renamed from: d reason: collision with root package name */
    private final int f9327d;

    /* renamed from: e reason: collision with root package name */
    private final boolean f9328e;

    /* renamed from: f reason: collision with root package name */
    private final b f9329f;

    /* renamed from: g reason: collision with root package name */
    private R f9330g;

    /* renamed from: h reason: collision with root package name */
    private c f9331h;

    /* renamed from: i reason: collision with root package name */
    private boolean f9332i;

    /* renamed from: j reason: collision with root package name */
    private boolean f9333j;

    /* renamed from: k reason: collision with root package name */
    private boolean f9334k;

    /* renamed from: l reason: collision with root package name */
    private GlideException f9335l;

    /* compiled from: RequestFutureTarget */
    private static class a extends ExecutionException {
        private static final long serialVersionUID = 1;
        private final GlideException cause;

        a(GlideException glideException) {
            this.cause = glideException;
        }

        public void printStackTrace() {
            printStackTrace(System.err);
        }

        public void printStackTrace(PrintStream printStream) {
            super.printStackTrace(printStream);
            printStream.print("Caused by: ");
            this.cause.printStackTrace(printStream);
        }

        public void printStackTrace(PrintWriter printWriter) {
            super.printStackTrace(printWriter);
            printWriter.print("Caused by: ");
            this.cause.printStackTrace(printWriter);
        }
    }

    /* compiled from: RequestFutureTarget */
    static class b {
        b() {
        }

        /* access modifiers changed from: 0000 */
        public void a(Object obj, long j2) throws InterruptedException {
            obj.wait(j2);
        }

        /* access modifiers changed from: 0000 */
        public void a(Object obj) {
            obj.notifyAll();
        }
    }

    public e(Handler handler, int i2, int i3) {
        this(handler, i2, i3, true, f9324a);
    }

    private synchronized R a(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f9328e && !isDone()) {
            j.a();
        }
        if (this.f9332i) {
            throw new CancellationException();
        } else if (this.f9334k) {
            throw new ExecutionException(this.f9335l);
        } else if (this.f9333j) {
            return this.f9330g;
        } else {
            if (l2 == null) {
                this.f9329f.a(this, 0);
            } else if (l2.longValue() > 0) {
                this.f9329f.a(this, l2.longValue());
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.f9334k) {
                throw new a(this.f9335l);
            } else if (this.f9332i) {
                throw new CancellationException();
            } else if (this.f9333j) {
                return this.f9330g;
            } else {
                throw new TimeoutException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return true;
     */
    public synchronized boolean cancel(boolean z) {
        if (isDone()) {
            return false;
        }
        this.f9332i = true;
        this.f9329f.a(this);
        if (z) {
            a();
        }
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return a(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    public c getRequest() {
        return this.f9331h;
    }

    public void getSize(g gVar) {
        gVar.a(this.f9326c, this.f9327d);
    }

    public synchronized boolean isCancelled() {
        return this.f9332i;
    }

    public synchronized boolean isDone() {
        return this.f9332i || this.f9333j || this.f9334k;
    }

    public void onDestroy() {
    }

    public void onLoadCleared(Drawable drawable) {
    }

    public synchronized void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public synchronized void onResourceReady(R r, d<? super R> dVar) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void removeCallback(g gVar) {
    }

    public void run() {
        c cVar = this.f9331h;
        if (cVar != null) {
            cVar.clear();
            this.f9331h = null;
        }
    }

    public void setRequest(c cVar) {
        this.f9331h = cVar;
    }

    e(Handler handler, int i2, int i3, boolean z, b bVar) {
        this.f9325b = handler;
        this.f9326c = i2;
        this.f9327d = i3;
        this.f9328e = z;
        this.f9329f = bVar;
    }

    public synchronized boolean onLoadFailed(GlideException glideException, Object obj, h<R> hVar, boolean z) {
        this.f9334k = true;
        this.f9335l = glideException;
        this.f9329f.a(this);
        return false;
    }

    public synchronized boolean onResourceReady(R r, Object obj, h<R> hVar, io.intercom.com.bumptech.glide.load.a aVar, boolean z) {
        this.f9333j = true;
        this.f9330g = r;
        this.f9329f.a(this);
        return false;
    }

    public R get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }

    private void a() {
        this.f9325b.post(this);
    }
}
