package e.b.d.i;

import e.b.d.b.b;
import e.b.d.j.c;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k.a.d;

/* compiled from: SubscriptionArbiter */
public class e extends AtomicInteger implements d {
    private static final long serialVersionUID = -2189523197179400958L;
    d actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    final AtomicLong missedProduced = new AtomicLong();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicReference<d> missedSubscription = new AtomicReference<>();
    long requested;
    protected boolean unbounded;

    public e(boolean z) {
        this.cancelOnReplace = z;
    }

    public final void a(long j2) {
        if (f.c(j2) && !this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                c.a(this.missedRequested, j2);
                a();
                return;
            }
            long j3 = this.requested;
            if (j3 != Long.MAX_VALUE) {
                long a2 = c.a(j3, j2);
                this.requested = a2;
                if (a2 == Long.MAX_VALUE) {
                    this.unbounded = true;
                }
            }
            d dVar = this.actual;
            if (decrementAndGet() != 0) {
                b();
            }
            if (dVar != null) {
                dVar.a(j2);
            }
        }
    }

    public final void b(d dVar) {
        if (this.cancelled) {
            dVar.cancel();
            return;
        }
        b.a(dVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            d dVar2 = (d) this.missedSubscription.getAndSet(dVar);
            if (dVar2 != null && this.cancelOnReplace) {
                dVar2.cancel();
            }
            a();
            return;
        }
        d dVar3 = this.actual;
        if (dVar3 != null && this.cancelOnReplace) {
            dVar3.cancel();
        }
        this.actual = dVar;
        long j2 = this.requested;
        if (decrementAndGet() != 0) {
            b();
        }
        if (j2 != 0) {
            dVar.a(j2);
        }
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            a();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a() {
        if (getAndIncrement() == 0) {
            b();
        }
    }

    public final void b(long j2) {
        if (!this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                c.a(this.missedProduced, j2);
                a();
                return;
            }
            long j3 = this.requested;
            if (j3 != Long.MAX_VALUE) {
                long j4 = j3 - j2;
                long j5 = 0;
                if (j4 < 0) {
                    f.b(j4);
                } else {
                    j5 = j4;
                }
                this.requested = j5;
            }
            if (decrementAndGet() != 0) {
                b();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void b() {
        d dVar = null;
        long j2 = 0;
        int i2 = 1;
        do {
            d dVar2 = (d) this.missedSubscription.get();
            if (dVar2 != null) {
                dVar2 = (d) this.missedSubscription.getAndSet(null);
            }
            long j3 = this.missedRequested.get();
            if (j3 != 0) {
                j3 = this.missedRequested.getAndSet(0);
            }
            long j4 = this.missedProduced.get();
            if (j4 != 0) {
                j4 = this.missedProduced.getAndSet(0);
            }
            d dVar3 = this.actual;
            if (this.cancelled) {
                if (dVar3 != null) {
                    dVar3.cancel();
                    this.actual = null;
                }
                if (dVar2 != null) {
                    dVar2.cancel();
                }
            } else {
                long j5 = this.requested;
                if (j5 != Long.MAX_VALUE) {
                    j5 = c.a(j5, j3);
                    if (j5 != Long.MAX_VALUE) {
                        long j6 = j5 - j4;
                        if (j6 < 0) {
                            f.b(j6);
                            j6 = 0;
                        }
                        j5 = j6;
                    }
                    this.requested = j5;
                }
                if (dVar2 != null) {
                    if (dVar3 != null && this.cancelOnReplace) {
                        dVar3.cancel();
                    }
                    this.actual = dVar2;
                    if (j5 != 0) {
                        j2 = c.a(j2, j5);
                        dVar = dVar2;
                    }
                } else if (!(dVar3 == null || j3 == 0)) {
                    j2 = c.a(j2, j3);
                    dVar = dVar3;
                }
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
        if (j2 != 0) {
            dVar.a(j2);
        }
    }
}
