package c.b.a.b.b.d;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class n extends WeakReference<Throwable> {

    /* renamed from: a reason: collision with root package name */
    private final int f3062a;

    public n(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f3062a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == n.class) {
            if (this == obj) {
                return true;
            }
            n nVar = (n) obj;
            return this.f3062a == nVar.f3062a && get() == nVar.get();
        }
    }

    public final int hashCode() {
        return this.f3062a;
    }
}
