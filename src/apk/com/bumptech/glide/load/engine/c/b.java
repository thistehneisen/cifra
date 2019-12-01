package com.bumptech.glide.load.engine.c;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: GlideExecutor */
public final class b implements ExecutorService {

    /* renamed from: a reason: collision with root package name */
    private static final long f3981a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b reason: collision with root package name */
    private static volatile int f3982b;

    /* renamed from: c reason: collision with root package name */
    private final ExecutorService f3983c;

    /* compiled from: GlideExecutor */
    private static final class a implements ThreadFactory {

        /* renamed from: a reason: collision with root package name */
        private final String f3984a;

        /* renamed from: b reason: collision with root package name */
        final C0057b f3985b;

        /* renamed from: c reason: collision with root package name */
        final boolean f3986c;

        /* renamed from: d reason: collision with root package name */
        private int f3987d;

        a(String str, C0057b bVar, boolean z) {
            this.f3984a = str;
            this.f3985b = bVar;
            this.f3986c = z;
        }

        public synchronized Thread newThread(Runnable runnable) {
            a aVar;
            StringBuilder sb = new StringBuilder();
            sb.append("glide-");
            sb.append(this.f3984a);
            sb.append("-thread-");
            sb.append(this.f3987d);
            aVar = new a(this, runnable, sb.toString());
            this.f3987d++;
            return aVar;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.c.b$b reason: collision with other inner class name */
    /* compiled from: GlideExecutor */
    public interface C0057b {

        /* renamed from: a reason: collision with root package name */
        public static final C0057b f3988a = new c();

        /* renamed from: b reason: collision with root package name */
        public static final C0057b f3989b = new d();

        /* renamed from: c reason: collision with root package name */
        public static final C0057b f3990c = new e();

        /* renamed from: d reason: collision with root package name */
        public static final C0057b f3991d = f3989b;

        void a(Throwable th);
    }

    b(ExecutorService executorService) {
        this.f3983c = executorService;
    }

    public static b a(int i2, String str, C0057b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, bVar, true));
        return new b(threadPoolExecutor);
    }

    public static b b(int i2, String str, C0057b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, bVar, false));
        return new b(threadPoolExecutor);
    }

    public static b c() {
        return a(1, "disk-cache", C0057b.f3991d);
    }

    public static b d() {
        return b(a(), "source", C0057b.f3991d);
    }

    public static b e() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, f3981a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new a("source-unlimited", C0057b.f3991d, false));
        return new b(threadPoolExecutor);
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f3983c.awaitTermination(j2, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f3983c.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f3983c.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f3983c.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f3983c.isShutdown();
    }

    public boolean isTerminated() {
        return this.f3983c.isTerminated();
    }

    public void shutdown() {
        this.f3983c.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f3983c.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.f3983c.submit(runnable);
    }

    public String toString() {
        return this.f3983c.toString();
    }

    public static b a(int i2, C0057b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, i2, f3981a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("animation", bVar, true));
        return new b(threadPoolExecutor);
    }

    public static b b() {
        return a(a() >= 4 ? 2 : 1, C0057b.f3991d);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f3983c.invokeAll(collection, j2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f3983c.invokeAny(collection, j2, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f3983c.submit(runnable, t);
    }

    public static int a() {
        if (f3982b == 0) {
            f3982b = Math.min(4, g.a());
        }
        return f3982b;
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f3983c.submit(callable);
    }
}
