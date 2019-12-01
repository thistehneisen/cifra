package e.b.d.i;

import e.b.d.b.b;
import e.b.d.j.c;
import e.b.g.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k.a.d;

/* compiled from: SubscriptionHelper */
public enum f implements d {
    CANCELLED;

    public static boolean a(d dVar, d dVar2) {
        if (dVar2 == null) {
            a.b((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (dVar == null) {
            return true;
        } else {
            dVar2.cancel();
            a();
            return false;
        }
    }

    public static void b(long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append("More produced than requested: ");
        sb.append(j2);
        a.b((Throwable) new ProtocolViolationException(sb.toString()));
    }

    public static boolean c(long j2) {
        if (j2 > 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("n > 0 required but it was ");
        sb.append(j2);
        a.b((Throwable) new IllegalArgumentException(sb.toString()));
        return false;
    }

    public void a(long j2) {
    }

    public void cancel() {
    }

    public static void a() {
        a.b((Throwable) new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean a(AtomicReference<d> atomicReference, d dVar) {
        b.a(dVar, "s is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() != CANCELLED) {
            a();
        }
        return false;
    }

    public static boolean a(AtomicReference<d> atomicReference) {
        d dVar = (d) atomicReference.get();
        f fVar = CANCELLED;
        if (dVar != fVar) {
            d dVar2 = (d) atomicReference.getAndSet(fVar);
            if (dVar2 != CANCELLED) {
                if (dVar2 != null) {
                    dVar2.cancel();
                }
                return true;
            }
        }
        return false;
    }

    public static boolean a(AtomicReference<d> atomicReference, AtomicLong atomicLong, d dVar) {
        if (!a(atomicReference, dVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet != 0) {
            dVar.a(andSet);
        }
        return true;
    }

    public static void a(AtomicReference<d> atomicReference, AtomicLong atomicLong, long j2) {
        d dVar = (d) atomicReference.get();
        if (dVar != null) {
            dVar.a(j2);
        } else if (c(j2)) {
            c.a(atomicLong, j2);
            d dVar2 = (d) atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    dVar2.a(andSet);
                }
            }
        }
    }
}
