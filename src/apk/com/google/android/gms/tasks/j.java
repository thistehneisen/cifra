package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.q;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class j {

    private static final class a implements b {

        /* renamed from: a reason: collision with root package name */
        private final CountDownLatch f6199a;

        private a() {
            this.f6199a = new CountDownLatch(1);
        }

        public final void a(Exception exc) {
            this.f6199a.countDown();
        }

        public final void b(Object obj) {
            this.f6199a.countDown();
        }

        public final void a() {
            this.f6199a.countDown();
        }

        public final void b() throws InterruptedException {
            this.f6199a.await();
        }

        /* synthetic */ a(C c2) {
            this();
        }

        public final boolean a(long j2, TimeUnit timeUnit) throws InterruptedException {
            return this.f6199a.await(j2, timeUnit);
        }
    }

    interface b extends C0610b, d, e<Object> {
    }

    public static <TResult> g<TResult> a(TResult tresult) {
        B b2 = new B();
        b2.a(tresult);
        return b2;
    }

    private static <TResult> TResult b(g<TResult> gVar) throws ExecutionException {
        if (gVar.e()) {
            return gVar.b();
        }
        if (gVar.c()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(gVar.a());
    }

    public static <TResult> g<TResult> a(Executor executor, Callable<TResult> callable) {
        q.a(executor, (Object) "Executor must not be null");
        q.a(callable, (Object) "Callback must not be null");
        B b2 = new B();
        executor.execute(new C(b2, callable));
        return b2;
    }

    public static <TResult> TResult a(g<TResult> gVar) throws ExecutionException, InterruptedException {
        q.a();
        q.a(gVar, (Object) "Task must not be null");
        if (gVar.d()) {
            return b(gVar);
        }
        a aVar = new a(null);
        a(gVar, (b) aVar);
        aVar.b();
        return b(gVar);
    }

    public static <TResult> TResult a(g<TResult> gVar, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        q.a();
        q.a(gVar, (Object) "Task must not be null");
        q.a(timeUnit, (Object) "TimeUnit must not be null");
        if (gVar.d()) {
            return b(gVar);
        }
        a aVar = new a(null);
        a(gVar, (b) aVar);
        if (aVar.a(j2, timeUnit)) {
            return b(gVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    private static void a(g<?> gVar, b bVar) {
        gVar.a(i.f6197b, (e<? super TResult>) bVar);
        gVar.a(i.f6197b, (d) bVar);
        gVar.a(i.f6197b, (C0610b) bVar);
    }
}
