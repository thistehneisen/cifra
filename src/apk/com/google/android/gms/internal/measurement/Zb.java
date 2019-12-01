package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Zb extends Xb {

    /* renamed from: c reason: collision with root package name */
    private static final Class<?> f5107c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private Zb() {
        super();
    }

    private static <E> List<E> c(Object obj, long j2) {
        return (List) Yc.f(obj, j2);
    }

    /* access modifiers changed from: 0000 */
    public final <L> List<L> a(Object obj, long j2) {
        return a(obj, j2, 10);
    }

    /* access modifiers changed from: 0000 */
    public final void b(Object obj, long j2) {
        Object obj2;
        List list = (List) Yc.f(obj, j2);
        if (list instanceof Ub) {
            obj2 = ((Ub) list).c();
        } else if (!f5107c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof C0465xc) || !(list instanceof Mb)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                Mb mb = (Mb) list;
                if (mb.b()) {
                    mb.a();
                }
                return;
            }
        } else {
            return;
        }
        Yc.a(obj, j2, obj2);
    }

    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.List<L>] */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    private static <L> List<L> a(Object obj, long j2, int i2) {
        ? r1;
        List<L> list;
        List<L> c2 = c(obj, j2);
        if (c2.isEmpty()) {
            if (c2 instanceof Ub) {
                list = new Vb<>(i2);
            } else if (!(c2 instanceof C0465xc) || !(c2 instanceof Mb)) {
                list = new ArrayList<>(i2);
            } else {
                list = ((Mb) c2).b(i2);
            }
            Yc.a(obj, j2, (Object) list);
            return list;
        }
        if (f5107c.isAssignableFrom(c2.getClass())) {
            ArrayList arrayList = new ArrayList(c2.size() + i2);
            arrayList.addAll(c2);
            Yc.a(obj, j2, (Object) arrayList);
            r1 = arrayList;
        } else if (c2 instanceof Xc) {
            Vb vb = new Vb(c2.size() + i2);
            vb.addAll((Xc) c2);
            Yc.a(obj, j2, (Object) vb);
            r1 = vb;
        } else if (!(c2 instanceof C0465xc) || !(c2 instanceof Mb)) {
            return c2;
        } else {
            Mb mb = (Mb) c2;
            if (mb.b()) {
                return c2;
            }
            Mb b2 = mb.b(c2.size() + i2);
            Yc.a(obj, j2, (Object) b2);
            return b2;
        }
        return r1;
    }

    /* access modifiers changed from: 0000 */
    public final <E> void a(Object obj, Object obj2, long j2) {
        List c2 = c(obj2, j2);
        List a2 = a(obj, j2, c2.size());
        int size = a2.size();
        int size2 = c2.size();
        if (size > 0 && size2 > 0) {
            a2.addAll(c2);
        }
        if (size > 0) {
            c2 = a2;
        }
        Yc.a(obj, j2, (Object) c2);
    }
}
