package e.a.b;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout */
public class m extends D {

    /* renamed from: a reason: collision with root package name */
    private D f7895a;

    public m(D d2) {
        if (d2 != null) {
            this.f7895a = d2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final D a() {
        return this.f7895a;
    }

    public D clearDeadline() {
        return this.f7895a.clearDeadline();
    }

    public D clearTimeout() {
        return this.f7895a.clearTimeout();
    }

    public long deadlineNanoTime() {
        return this.f7895a.deadlineNanoTime();
    }

    public boolean hasDeadline() {
        return this.f7895a.hasDeadline();
    }

    public void throwIfReached() throws IOException {
        this.f7895a.throwIfReached();
    }

    public D timeout(long j2, TimeUnit timeUnit) {
        return this.f7895a.timeout(j2, timeUnit);
    }

    public long timeoutNanos() {
        return this.f7895a.timeoutNanos();
    }

    public final m a(D d2) {
        if (d2 != null) {
            this.f7895a = d2;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public D deadlineNanoTime(long j2) {
        return this.f7895a.deadlineNanoTime(j2);
    }
}
