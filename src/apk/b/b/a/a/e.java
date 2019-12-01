package b.b.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: DefaultTaskExecutor */
public class e extends f {

    /* renamed from: a reason: collision with root package name */
    private final Object f2244a = new Object();

    /* renamed from: b reason: collision with root package name */
    private final ExecutorService f2245b = Executors.newFixedThreadPool(2, new d(this));

    /* renamed from: c reason: collision with root package name */
    private volatile Handler f2246c;

    public void a(Runnable runnable) {
        this.f2245b.execute(runnable);
    }

    public void c(Runnable runnable) {
        if (this.f2246c == null) {
            synchronized (this.f2244a) {
                if (this.f2246c == null) {
                    this.f2246c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f2246c.post(runnable);
    }

    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
