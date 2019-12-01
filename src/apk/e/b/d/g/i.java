package e.b.d.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: RxThreadFactory */
public final class i extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    /* compiled from: RxThreadFactory */
    static final class a extends Thread implements h {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public i(String str) {
        this(str, 5, false);
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder(this.prefix);
        sb.append('-');
        sb.append(incrementAndGet());
        String sb2 = sb.toString();
        Thread aVar = this.nonBlocking ? new a(runnable, sb2) : new Thread(runnable, sb2);
        aVar.setPriority(this.priority);
        aVar.setDaemon(true);
        return aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RxThreadFactory[");
        sb.append(this.prefix);
        sb.append("]");
        return sb.toString();
    }

    public i(String str, int i2) {
        this(str, i2, false);
    }

    public i(String str, int i2, boolean z) {
        this.prefix = str;
        this.priority = i2;
        this.nonBlocking = z;
    }
}
