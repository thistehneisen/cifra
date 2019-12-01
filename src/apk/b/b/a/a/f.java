package b.b.a.a;

/* compiled from: TaskExecutor */
public abstract class f {
    public abstract void a(Runnable runnable);

    public abstract boolean a();

    public void b(Runnable runnable) {
        if (a()) {
            runnable.run();
        } else {
            c(runnable);
        }
    }

    public abstract void c(Runnable runnable);
}
