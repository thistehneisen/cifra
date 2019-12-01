package e.a.b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: e.a.b.c reason: case insensitive filesystem */
/* compiled from: AsyncTimeout */
public class C0709c extends D {
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    static C0709c head;
    private boolean inQueue;
    private C0709c next;
    private long timeoutAt;

    /* renamed from: e.a.b.c$a */
    /* compiled from: AsyncTimeout */
    private static final class a extends Thread {
        a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.timedOut();
         */
        public void run() {
            while (true) {
                try {
                    synchronized (C0709c.class) {
                        C0709c awaitTimeout = C0709c.awaitTimeout();
                        if (awaitTimeout != null) {
                            if (awaitTimeout == C0709c.head) {
                                C0709c.head = null;
                                return;
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static C0709c awaitTimeout() throws InterruptedException {
        C0709c cVar = head.next;
        C0709c cVar2 = null;
        if (cVar == null) {
            long nanoTime = System.nanoTime();
            C0709c.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next == null && System.nanoTime() - nanoTime >= IDLE_TIMEOUT_NANOS) {
                cVar2 = head;
            }
            return cVar2;
        }
        long remainingNanos = cVar.remainingNanos(System.nanoTime());
        if (remainingNanos > 0) {
            long j2 = remainingNanos / 1000000;
            C0709c.class.wait(j2, (int) (remainingNanos - (1000000 * j2)));
            return null;
        }
        head.next = cVar.next;
        cVar.next = null;
        return cVar;
    }

    private static synchronized boolean cancelScheduledTimeout(C0709c cVar) {
        synchronized (C0709c.class) {
            for (C0709c cVar2 = head; cVar2 != null; cVar2 = cVar2.next) {
                if (cVar2.next == cVar) {
                    cVar2.next = cVar.next;
                    cVar.next = null;
                    return false;
                }
            }
            return true;
        }
    }

    private long remainingNanos(long j2) {
        return this.timeoutAt - j2;
    }

    private static synchronized void scheduleTimeout(C0709c cVar, long j2, boolean z) {
        synchronized (C0709c.class) {
            if (head == null) {
                head = new C0709c();
                new a().start();
            }
            long nanoTime = System.nanoTime();
            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i2 != 0 && z) {
                cVar.timeoutAt = Math.min(j2, cVar.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (i2 != 0) {
                cVar.timeoutAt = j2 + nanoTime;
            } else if (z) {
                cVar.timeoutAt = cVar.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = cVar.remainingNanos(nanoTime);
            C0709c cVar2 = head;
            while (true) {
                if (cVar2.next == null) {
                    break;
                } else if (remainingNanos < cVar2.next.remainingNanos(nanoTime)) {
                    break;
                } else {
                    cVar2 = cVar2.next;
                }
            }
            cVar.next = cVar2.next;
            cVar2.next = cVar;
            if (cVar2 == head) {
                C0709c.class.notify();
            }
        }
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final A sink(A a2) {
        return new C0707a(this, a2);
    }

    public final B source(B b2) {
        return new C0708b(this, b2);
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    /* access modifiers changed from: 0000 */
    public final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    /* access modifiers changed from: 0000 */
    public final IOException exit(IOException iOException) throws IOException {
        if (!exit()) {
            return iOException;
        }
        return newTimeoutException(iOException);
    }
}
