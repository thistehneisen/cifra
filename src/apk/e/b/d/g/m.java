package e.b.d.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SchedulerPoolFactory */
public final class m {

    /* renamed from: a reason: collision with root package name */
    public static final boolean f8254a;

    /* renamed from: b reason: collision with root package name */
    public static final int f8255b;

    /* renamed from: c reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f8256c = new AtomicReference<>();

    /* renamed from: d reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f8257d = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory */
    static final class a {

        /* renamed from: a reason: collision with root package name */
        boolean f8258a;

        /* renamed from: b reason: collision with root package name */
        int f8259b;

        a() {
        }

        /* access modifiers changed from: 0000 */
        public void a(Properties properties) {
            String str = "rx2.purge-enabled";
            if (properties.containsKey(str)) {
                this.f8258a = Boolean.parseBoolean(properties.getProperty(str));
            } else {
                this.f8258a = true;
            }
            if (this.f8258a) {
                String str2 = "rx2.purge-period-seconds";
                if (properties.containsKey(str2)) {
                    try {
                        this.f8259b = Integer.parseInt(properties.getProperty(str2));
                        return;
                    } catch (NumberFormatException unused) {
                        this.f8259b = 1;
                        return;
                    }
                }
            }
            this.f8259b = 1;
        }
    }

    /* compiled from: SchedulerPoolFactory */
    static final class b implements Runnable {
        b() {
        }

        public void run() {
            Iterator it = new ArrayList(m.f8257d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    m.f8257d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.a(properties);
        f8254a = aVar.f8258a;
        f8255b = aVar.f8259b;
        a();
    }

    public static void a() {
        a(f8254a);
    }

    static void a(boolean z) {
        if (z) {
            while (true) {
                ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) f8256c.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new i("RxSchedulerPurge"));
                    if (f8256c.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        b bVar = new b();
                        int i2 = f8255b;
                        newScheduledThreadPool.scheduleAtFixedRate(bVar, (long) i2, (long) i2, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        a(f8254a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static void a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f8257d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }
}
