package i.a;

/* compiled from: NamedRunnable */
public abstract class d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    protected final String f8626a;

    public d(String str, Object... objArr) {
        this.f8626a = e.a(str, objArr);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f8626a);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
