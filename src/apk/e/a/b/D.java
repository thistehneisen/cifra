package e.a.b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout */
public class D {
    public static final D NONE = new C();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public D clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public D clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public final D deadline(long j2, TimeUnit timeUnit) {
        if (j2 <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("duration <= 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (timeUnit != null) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j2));
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public D timeout(long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("timeout < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (timeUnit != null) {
            this.timeoutNanos = timeUnit.toNanos(j2);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedIOException {
        try {
            boolean hasDeadline2 = hasDeadline();
            long timeoutNanos2 = timeoutNanos();
            long j2 = 0;
            if (hasDeadline2 || timeoutNanos2 != 0) {
                long nanoTime = System.nanoTime();
                if (hasDeadline2 && timeoutNanos2 != 0) {
                    timeoutNanos2 = Math.min(timeoutNanos2, deadlineNanoTime() - nanoTime);
                } else if (hasDeadline2) {
                    timeoutNanos2 = deadlineNanoTime() - nanoTime;
                }
                if (timeoutNanos2 > 0) {
                    long j3 = timeoutNanos2 / 1000000;
                    Long.signum(j3);
                    obj.wait(j3, (int) (timeoutNanos2 - (1000000 * j3)));
                    j2 = System.nanoTime() - nanoTime;
                }
                if (j2 >= timeoutNanos2) {
                    throw new InterruptedIOException("timeout");
                }
                return;
            }
            obj.wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException("interrupted");
        }
    }

    public D deadlineNanoTime(long j2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j2;
        return this;
    }
}
