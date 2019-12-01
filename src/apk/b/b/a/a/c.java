package b.b.a.a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor */
public class c extends f {

    /* renamed from: a reason: collision with root package name */
    private static volatile c f2237a;

    /* renamed from: b reason: collision with root package name */
    private static final Executor f2238b = new a();

    /* renamed from: c reason: collision with root package name */
    private static final Executor f2239c = new b();

    /* renamed from: d reason: collision with root package name */
    private f f2240d = this.f2241e;

    /* renamed from: e reason: collision with root package name */
    private f f2241e = new e();

    private c() {
    }

    public static c b() {
        if (f2237a != null) {
            return f2237a;
        }
        synchronized (c.class) {
            if (f2237a == null) {
                f2237a = new c();
            }
        }
        return f2237a;
    }

    public void a(Runnable runnable) {
        this.f2240d.a(runnable);
    }

    public void c(Runnable runnable) {
        this.f2240d.c(runnable);
    }

    public boolean a() {
        return this.f2240d.a();
    }
}
