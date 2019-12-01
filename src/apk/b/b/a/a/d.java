package b.b.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultTaskExecutor */
class d implements ThreadFactory {

    /* renamed from: a reason: collision with root package name */
    private final AtomicInteger f2242a = new AtomicInteger(0);

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ e f2243b;

    d(e eVar) {
        this.f2243b = eVar;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f2242a.getAndIncrement())}));
        return thread;
    }
}
