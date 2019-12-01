package com.google.android.gms.internal.measurement;

import java.util.List;

final class Yb extends Xb {
    private Yb() {
        super();
    }

    private static <E> Mb<E> c(Object obj, long j2) {
        return (Mb) Yc.f(obj, j2);
    }

    /* access modifiers changed from: 0000 */
    public final <L> List<L> a(Object obj, long j2) {
        Mb c2 = c(obj, j2);
        if (c2.b()) {
            return c2;
        }
        int size = c2.size();
        Mb b2 = c2.b(size == 0 ? 10 : size << 1);
        Yc.a(obj, j2, (Object) b2);
        return b2;
    }

    /* access modifiers changed from: 0000 */
    public final void b(Object obj, long j2) {
        c(obj, j2).a();
    }

    /* access modifiers changed from: 0000 */
    public final <E> void a(Object obj, Object obj2, long j2) {
        Mb c2 = c(obj, j2);
        Mb c3 = c(obj2, j2);
        int size = c2.size();
        int size2 = c3.size();
        if (size > 0 && size2 > 0) {
            if (!c2.b()) {
                c2 = c2.b(size2 + size);
            }
            c2.addAll(c3);
        }
        if (size > 0) {
            c3 = c2;
        }
        Yc.a(obj, j2, (Object) c3);
    }
}
