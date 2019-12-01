package e.b.d.a;

import e.b.b.b;
import e.b.d.c.e;
import e.b.m;
import e.b.p;

/* compiled from: EmptyDisposable */
public enum c implements e<Object> {
    INSTANCE,
    NEVER;

    public boolean a() {
        return this == INSTANCE;
    }

    public int b(int i2) {
        return i2 & 2;
    }

    public void b() {
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() throws Exception {
        return null;
    }

    public static void a(m<?> mVar) {
        mVar.a((b) INSTANCE);
        mVar.c();
    }

    public static void a(Throwable th, m<?> mVar) {
        mVar.a((b) INSTANCE);
        mVar.a(th);
    }

    public static void a(e.b.c cVar) {
        cVar.a((b) INSTANCE);
        cVar.c();
    }

    public static void a(Throwable th, e.b.c cVar) {
        cVar.a((b) INSTANCE);
        cVar.a(th);
    }

    public static void a(Throwable th, p<?> pVar) {
        pVar.a((b) INSTANCE);
        pVar.a(th);
    }
}
