package b.g.f;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SelfDestructiveThread */
class j implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ AtomicReference f2560a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Callable f2561b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ ReentrantLock f2562c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f2563d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ Condition f2564e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ k f2565f;

    j(k kVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
        this.f2565f = kVar;
        this.f2560a = atomicReference;
        this.f2561b = callable;
        this.f2562c = reentrantLock;
        this.f2563d = atomicBoolean;
        this.f2564e = condition;
    }

    public void run() {
        try {
            this.f2560a.set(this.f2561b.call());
        } catch (Exception unused) {
        }
        this.f2562c.lock();
        try {
            this.f2563d.set(false);
            this.f2564e.signal();
        } finally {
            this.f2562c.unlock();
        }
    }
}
