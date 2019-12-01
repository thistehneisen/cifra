package e.b.d.e.a;

import e.b.b;
import e.b.c;
import e.b.c.a;

/* compiled from: CompletableFromAction */
public final class d extends b {

    /* renamed from: a reason: collision with root package name */
    final a f7989a;

    public d(a aVar) {
        this.f7989a = aVar;
    }

    /* access modifiers changed from: protected */
    public void b(c cVar) {
        e.b.b.b b2 = e.b.b.c.b();
        cVar.a(b2);
        try {
            this.f7989a.run();
            if (!b2.a()) {
                cVar.c();
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (!b2.a()) {
                cVar.a(th);
            }
        }
    }
}
