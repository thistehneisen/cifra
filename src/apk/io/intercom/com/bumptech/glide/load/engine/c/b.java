package io.intercom.com.bumptech.glide.load.engine.c;

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
    private static final long f9852a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b reason: collision with root package name */
    private static volatile int f9853b;

    /* renamed from: c reason: collision with root package name */
    private final ExecutorService f9854c;

    /* compiled from: GlideExecutor */
    private static final class a implements ThreadFactory {

        /* renamed from: a reason: collision with root package name */
        private final String f9855a;

        /* renamed from: b reason: collision with root package name */
        final C0113b f9856b;

        /* renamed from: c reason: collision with root package name */
        final boolean f9857c;

        /* renamed from: d reason: collision with root package name */
        private int f9858d;

        a(String str, C0113b bVar, boolean z) {
            this.f9855a = str;
            this.f9856b = bVar;
            this.f9857c = z;
        }

        public synchronized Thread newThread(Runnable runnable) {
            a aVar;
            StringBuilder sb = new StringBuilder();
            sb.append("glide-");
            sb.append(this.f9855a);
            sb.append("-thread-");
            sb.append(this.f9858d);
            aVar = new a(this, runnable, sb.toString());
            this.f9858d++;
            return aVar;
        }
    }

    /* renamed from: io.intercom.com.bumptech.glide.load.engine.c.b$b reason: collision with other inner class name */
    /* compiled from: GlideExecutor */
    public interface C0113b {

        /* renamed from: a reason: collision with root package name */
        public static final C0113b f9859a = new c();

        /* renamed from: b reason: collision with root package name */
        public static final C0113b f9860b = new d();

        /* renamed from: c reason: collision with root package name */
        public static final C0113b f9861c = new e();

        /* renamed from: d reason: collision with root package name */
        public static final C0113b f9862d = f9860b;

        void a(Throwable th);
    }

    b(ExecutorService executorService) {
        this.f9854c = executorService;
    }

    public static b a(int i2, String str, C0113b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, bVar, true));
        return new b(threadPoolExecutor);
    }

    public static b b(int i2, String str, C0113b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, bVar, false));
        return new b(threadPoolExecutor);
    }

    public static b c() {
        return a(1, "disk-cache", C0113b.f9862d);
    }

    public static b d() {
        return b(a(), "source", C0113b.f9862d);
    }

    public static b e() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, f9852a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new a("source-unlimited", C0113b.f9862d, false));
        return new b(threadPoolExecutor);
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f9854c.awaitTermination(j2, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f9854c.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f9854c.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f9854c.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f9854c.isShutdown();
    }

    public boolean isTerminated() {
        return this.f9854c.isTerminated();
    }

    public void shutdown() {
        this.f9854c.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f9854c.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.f9854c.submit(runnable);
    }

    public String toString() {
        return this.f9854c.toString();
    }

    public static b a(int i2, C0113b bVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, i2, f9852a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("animation", bVar, true));
        return new b(threadPoolExecutor);
    }

    public static b b() {
        return a(a() >= 4 ? 2 : 1, C0113b.f9862d);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f9854c.invokeAll(collection, j2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f9854c.invokeAny(collection, j2, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f9854c.submit(runnable, t);
    }

    public static int a() {
        if (f9853b == 0) {
            f9853b = Math.min(4, g.a());
        }
        return f9853b;
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f9854c.submit(callable);
    }
}
