package e.b.d.g;

import java.util.concurrent.Callable;

/* compiled from: ScheduledDirectTask */
public final class j extends a implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public j(Runnable runnable) {
        super(runnable);
    }

    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            return null;
        } finally {
            lazySet(a.f8196a);
            this.runner = null;
        }
    }
}
