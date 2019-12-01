package io.fabric.sdk.android.services.concurrency;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PriorityThreadPoolExecutor */
public class r extends ThreadPoolExecutor {

    /* renamed from: a reason: collision with root package name */
    private static final int f9081a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b reason: collision with root package name */
    private static final int f9082b;

    /* renamed from: c reason: collision with root package name */
    private static final int f9083c;

    /* compiled from: PriorityThreadPoolExecutor */
    protected static final class a implements ThreadFactory {

        /* renamed from: a reason: collision with root package name */
        private final int f9084a;

        public a(int i2) {
            this.f9084a = i2;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f9084a);
            thread.setName("Queue");
            return thread;
        }
    }

    static {
        int i2 = f9081a;
        f9082b = i2 + 1;
        f9083c = (i2 * 2) + 1;
    }

    <T extends Runnable & h & s & p> r(int i2, int i3, long j2, TimeUnit timeUnit, i<T> iVar, ThreadFactory threadFactory) {
        super(i2, i3, j2, timeUnit, iVar, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & h & s & p> r a(int i2, int i3) {
        r rVar = new r(i2, i3, 1, TimeUnit.SECONDS, new i(), new a(10));
        return rVar;
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        s sVar = (s) runnable;
        sVar.setFinished(true);
        sVar.setError(th);
        getQueue().e();
        super.afterExecute(runnable, th);
    }

    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (q.isProperDelegate(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    /* access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new o(runnable, t);
    }

    public static r a() {
        return a(f9082b, f9083c);
    }

    public i getQueue() {
        return (i) super.getQueue();
    }

    /* access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new o(callable);
    }
}
