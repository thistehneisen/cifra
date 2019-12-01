package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AsyncTask */
public abstract class e<Params, Progress, Result> {

    /* renamed from: a reason: collision with root package name */
    private static final int f9049a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b reason: collision with root package name */
    private static final int f9050b;

    /* renamed from: c reason: collision with root package name */
    private static final int f9051c;

    /* renamed from: d reason: collision with root package name */
    private static final ThreadFactory f9052d = new a();

    /* renamed from: e reason: collision with root package name */
    private static final BlockingQueue<Runnable> f9053e = new LinkedBlockingQueue(128);

    /* renamed from: f reason: collision with root package name */
    public static final Executor f9054f;

    /* renamed from: g reason: collision with root package name */
    public static final Executor f9055g = new c(null);

    /* renamed from: h reason: collision with root package name */
    private static final b f9056h = new b();

    /* renamed from: i reason: collision with root package name */
    private static volatile Executor f9057i = f9055g;

    /* renamed from: j reason: collision with root package name */
    private final C0098e<Params, Result> f9058j = new b(this);

    /* renamed from: k reason: collision with root package name */
    private final FutureTask<Result> f9059k = new c(this, this.f9058j);

    /* renamed from: l reason: collision with root package name */
    private volatile d f9060l = d.PENDING;
    private final AtomicBoolean m = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final AtomicBoolean n = new AtomicBoolean();

    /* compiled from: AsyncTask */
    private static class a<Data> {

        /* renamed from: a reason: collision with root package name */
        final e f9061a;

        /* renamed from: b reason: collision with root package name */
        final Data[] f9062b;

        a(e eVar, Data... dataArr) {
            this.f9061a = eVar;
            this.f9062b = dataArr;
        }
    }

    /* compiled from: AsyncTask */
    private static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                aVar.f9061a.c(aVar.f9062b[0]);
            } else if (i2 == 2) {
                aVar.f9061a.b((Progress[]) aVar.f9062b);
            }
        }
    }

    /* compiled from: AsyncTask */
    private static class c implements Executor {

        /* renamed from: a reason: collision with root package name */
        final LinkedList<Runnable> f9063a;

        /* renamed from: b reason: collision with root package name */
        Runnable f9064b;

        private c() {
            this.f9063a = new LinkedList<>();
        }

        /* access modifiers changed from: protected */
        public synchronized void a() {
            Runnable runnable = (Runnable) this.f9063a.poll();
            this.f9064b = runnable;
            if (runnable != null) {
                e.f9054f.execute(this.f9064b);
            }
        }

        public synchronized void execute(Runnable runnable) {
            this.f9063a.offer(new f(this, runnable));
            if (this.f9064b == null) {
                a();
            }
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* compiled from: AsyncTask */
    public enum d {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.e$e reason: collision with other inner class name */
    /* compiled from: AsyncTask */
    private static abstract class C0098e<Params, Result> implements Callable<Result> {

        /* renamed from: a reason: collision with root package name */
        Params[] f9069a;

        private C0098e() {
        }

        /* synthetic */ C0098e(a aVar) {
            this();
        }
    }

    static {
        int i2 = f9049a;
        f9050b = i2 + 1;
        f9051c = (i2 * 2) + 1;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f9050b, f9051c, 1, TimeUnit.SECONDS, f9053e, f9052d);
        f9054f = threadPoolExecutor;
    }

    /* access modifiers changed from: private */
    public Result d(Result result) {
        f9056h.obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: private */
    public void e(Result result) {
        if (!this.n.get()) {
            d(result);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Result a(Params... paramsArr);

    /* access modifiers changed from: protected */
    public abstract void a(Result result);

    /* access modifiers changed from: protected */
    public abstract void b(Result result);

    /* access modifiers changed from: protected */
    public void b(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: private */
    public void c(Result result) {
        if (b()) {
            a(result);
        } else {
            b(result);
        }
        this.f9060l = d.FINISHED;
    }

    public final boolean b() {
        return this.m.get();
    }

    public final d a() {
        return this.f9060l;
    }

    public final boolean a(boolean z) {
        this.m.set(true);
        return this.f9059k.cancel(z);
    }

    public final e<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.f9060l != d.PENDING) {
            int i2 = d.f9048a[this.f9060l.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i2 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f9060l = d.RUNNING;
        c();
        this.f9058j.f9069a = paramsArr;
        executor.execute(this.f9059k);
        return this;
    }
}
