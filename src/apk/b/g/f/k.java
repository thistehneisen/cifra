package b.g.f;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SelfDestructiveThread */
public class k {

    /* renamed from: a reason: collision with root package name */
    private final Object f2566a = new Object();

    /* renamed from: b reason: collision with root package name */
    private HandlerThread f2567b;

    /* renamed from: c reason: collision with root package name */
    private Handler f2568c;

    /* renamed from: d reason: collision with root package name */
    private int f2569d;

    /* renamed from: e reason: collision with root package name */
    private Callback f2570e = new g(this);

    /* renamed from: f reason: collision with root package name */
    private final int f2571f;

    /* renamed from: g reason: collision with root package name */
    private final int f2572g;

    /* renamed from: h reason: collision with root package name */
    private final String f2573h;

    /* compiled from: SelfDestructiveThread */
    public interface a<T> {
        void a(T t);
    }

    public k(String str, int i2, int i3) {
        this.f2573h = str;
        this.f2572g = i2;
        this.f2571f = i3;
        this.f2569d = 0;
    }

    private void b(Runnable runnable) {
        synchronized (this.f2566a) {
            if (this.f2567b == null) {
                this.f2567b = new HandlerThread(this.f2573h, this.f2572g);
                this.f2567b.start();
                this.f2568c = new Handler(this.f2567b.getLooper(), this.f2570e);
                this.f2569d++;
            }
            this.f2568c.removeMessages(0);
            this.f2568c.sendMessage(this.f2568c.obtainMessage(1, runnable));
        }
    }

    public <T> void a(Callable<T> callable, a<T> aVar) {
        b(new i(this, callable, new Handler(), aVar));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|(4:25|14|15|16)(1:17)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC] */
    public <T> T a(Callable<T> callable, int i2) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        j jVar = new j(this, atomicReference, callable, reentrantLock, atomicBoolean, newCondition);
        b(jVar);
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos((long) i2);
            do {
                nanos = newCondition.awaitNanos(nanos);
                if (atomicBoolean.get()) {
                    T t = atomicReference.get();
                    reentrantLock.unlock();
                    return t;
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Runnable runnable) {
        runnable.run();
        synchronized (this.f2566a) {
            this.f2568c.removeMessages(0);
            this.f2568c.sendMessageDelayed(this.f2568c.obtainMessage(0), (long) this.f2571f);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        synchronized (this.f2566a) {
            if (!this.f2568c.hasMessages(1)) {
                this.f2567b.quit();
                this.f2567b = null;
                this.f2568c = null;
            }
        }
    }
}
