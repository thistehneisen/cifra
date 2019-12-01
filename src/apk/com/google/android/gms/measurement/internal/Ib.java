package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class Ib extends C0528jc {
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public static final AtomicLong f5589c = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public Lb f5590d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public Lb f5591e;

    /* renamed from: f reason: collision with root package name */
    private final PriorityBlockingQueue<Mb<?>> f5592f = new PriorityBlockingQueue<>();

    /* renamed from: g reason: collision with root package name */
    private final BlockingQueue<Mb<?>> f5593g = new LinkedBlockingQueue();

    /* renamed from: h reason: collision with root package name */
    private final UncaughtExceptionHandler f5594h = new Kb(this, "Thread death: Uncaught exception on worker thread");

    /* renamed from: i reason: collision with root package name */
    private final UncaughtExceptionHandler f5595i = new Kb(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */

    /* renamed from: j reason: collision with root package name */
    public final Object f5596j = new Object();
    /* access modifiers changed from: private */

    /* renamed from: k reason: collision with root package name */
    public final Semaphore f5597k = new Semaphore(2);
    /* access modifiers changed from: private */

    /* renamed from: l reason: collision with root package name */
    public volatile boolean f5598l;

    Ib(Ob ob) {
        super(ob);
    }

    public final <V> Future<V> a(Callable<V> callable) throws IllegalStateException {
        p();
        q.a(callable);
        Mb mb = new Mb(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f5590d) {
            if (!this.f5592f.isEmpty()) {
                e().w().a("Callable skipped the worker queue.");
            }
            mb.run();
        } else {
            a(mb);
        }
        return mb;
    }

    public final <V> Future<V> b(Callable<V> callable) throws IllegalStateException {
        p();
        q.a(callable);
        Mb mb = new Mb(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f5590d) {
            mb.run();
        } else {
            a(mb);
        }
        return mb;
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0532kb e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ C0576tb f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ fe g() {
        return super.g();
    }

    public final void i() {
        if (Thread.currentThread() != this.f5591e) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void j() {
        if (Thread.currentThread() != this.f5590d) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final /* bridge */ /* synthetic */ C0495d k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ C0522ib l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ Wd m() {
        return super.m();
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        return false;
    }

    public final boolean t() {
        return Thread.currentThread() == this.f5590d;
    }

    public final void b(Runnable runnable) throws IllegalStateException {
        p();
        q.a(runnable);
        Mb mb = new Mb(this, runnable, false, "Task exception on network thread");
        synchronized (this.f5596j) {
            this.f5593g.add(mb);
            if (this.f5591e == null) {
                this.f5591e = new Lb(this, "Measurement Network", this.f5593g);
                this.f5591e.setUncaughtExceptionHandler(this.f5595i);
                this.f5591e.start();
            } else {
                this.f5591e.a();
            }
        }
    }

    public final void a(Runnable runnable) throws IllegalStateException {
        p();
        q.a(runnable);
        a(new Mb<>(this, runnable, false, "Task exception on worker thread"));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:16|17|(1:19)(1:20)|21|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r2 = e().w();
        r3 = "Timed out waiting for ";
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r4.length() == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        r3 = r3.concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r3 = new java.lang.String(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r2.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2 = e().w();
        r3 = "Interrupted waiting for ";
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r4.length() != 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        r3 = r3.concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        r3 = new java.lang.String(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r2.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        r1 = r1.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r1 != null) goto L_0x0036;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0037 */
    public final <T> T a(AtomicReference<T> atomicReference, long j2, String str, Runnable runnable) {
        synchronized (atomicReference) {
            d().a(runnable);
            atomicReference.wait(15000);
        }
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    private final void a(Mb<?> mb) {
        synchronized (this.f5596j) {
            this.f5592f.add(mb);
            if (this.f5590d == null) {
                this.f5590d = new Lb(this, "Measurement Worker", this.f5592f);
                this.f5590d.setUncaughtExceptionHandler(this.f5594h);
                this.f5590d.start();
            } else {
                this.f5590d.a();
            }
        }
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
