package androidx.lifecycle;

import androidx.lifecycle.h.a;

class FullLifecycleObserverAdapter implements j {

    /* renamed from: a reason: collision with root package name */
    private final C0211d f1611a;

    /* renamed from: b reason: collision with root package name */
    private final j f1612b;

    FullLifecycleObserverAdapter(C0211d dVar, j jVar) {
        this.f1611a = dVar;
        this.f1612b = jVar;
    }

    public void a(l lVar, a aVar) {
        switch (C0212e.f1641a[aVar.ordinal()]) {
            case 1:
                this.f1611a.b(lVar);
                break;
            case 2:
                this.f1611a.f(lVar);
                break;
            case 3:
                this.f1611a.a(lVar);
                break;
            case 4:
                this.f1611a.c(lVar);
                break;
            case 5:
                this.f1611a.d(lVar);
                break;
            case 6:
                this.f1611a.e(lVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        j jVar = this.f1612b;
        if (jVar != null) {
            jVar.a(lVar, aVar);
        }
    }
}
