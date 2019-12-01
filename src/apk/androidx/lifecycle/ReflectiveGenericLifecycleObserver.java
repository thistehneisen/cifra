package androidx.lifecycle;

import androidx.lifecycle.h.a;

class ReflectiveGenericLifecycleObserver implements j {

    /* renamed from: a reason: collision with root package name */
    private final Object f1631a;

    /* renamed from: b reason: collision with root package name */
    private final a f1632b = C0209b.f1634a.a(this.f1631a.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1631a = obj;
    }

    public void a(l lVar, a aVar) {
        this.f1632b.a(lVar, aVar, this.f1631a);
    }
}
