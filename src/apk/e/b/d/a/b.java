package e.b.d.a;

import e.b.g.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableHelper */
public enum b implements e.b.b.b {
    DISPOSED;

    public static boolean a(e.b.b.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean b(AtomicReference<e.b.b.b> atomicReference, e.b.b.b bVar) {
        e.b.d.b.b.a(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.b();
        if (atomicReference.get() != DISPOSED) {
            c();
        }
        return false;
    }

    public static void c() {
        a.b((Throwable) new ProtocolViolationException("Disposable already set!"));
    }

    public boolean a() {
        return true;
    }

    public void b() {
    }

    public static boolean a(AtomicReference<e.b.b.b> atomicReference, e.b.b.b bVar) {
        e.b.b.b bVar2;
        do {
            bVar2 = (e.b.b.b) atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.b();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static boolean c(AtomicReference<e.b.b.b> atomicReference, e.b.b.b bVar) {
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            bVar.b();
        }
        return false;
    }

    public static boolean a(AtomicReference<e.b.b.b> atomicReference) {
        e.b.b.b bVar = (e.b.b.b) atomicReference.get();
        b bVar2 = DISPOSED;
        if (bVar != bVar2) {
            e.b.b.b bVar3 = (e.b.b.b) atomicReference.getAndSet(bVar2);
            if (bVar3 != bVar2) {
                if (bVar3 != null) {
                    bVar3.b();
                }
                return true;
            }
        }
        return false;
    }

    public static boolean a(e.b.b.b bVar, e.b.b.b bVar2) {
        if (bVar2 == null) {
            a.b((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (bVar == null) {
            return true;
        } else {
            bVar2.b();
            c();
            return false;
        }
    }
}
