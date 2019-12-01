package e.b.d.i;

import e.b.d.c.g;
import k.a.d;

/* compiled from: EmptySubscription */
public enum c implements g<Object> {
    INSTANCE;

    public void a(long j2) {
        f.c(j2);
    }

    public int b(int i2) {
        return i2 & 2;
    }

    public void cancel() {
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() {
        return null;
    }

    public String toString() {
        return "EmptySubscription";
    }

    public static void a(Throwable th, k.a.c<?> cVar) {
        cVar.a((d) INSTANCE);
        cVar.a(th);
    }

    public static void a(k.a.c<?> cVar) {
        cVar.a((d) INSTANCE);
        cVar.c();
    }
}
