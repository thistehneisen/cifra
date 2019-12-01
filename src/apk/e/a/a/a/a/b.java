package e.a.a.a.a;

import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Bus */
class b extends ThreadLocal<ConcurrentLinkedQueue<a>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ d f7855a;

    b(d dVar) {
        this.f7855a = dVar;
    }

    /* access modifiers changed from: protected */
    public ConcurrentLinkedQueue<a> initialValue() {
        return new ConcurrentLinkedQueue<>();
    }
}
