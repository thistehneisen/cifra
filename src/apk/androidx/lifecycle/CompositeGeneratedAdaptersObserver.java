package androidx.lifecycle;

import androidx.lifecycle.h.a;

class CompositeGeneratedAdaptersObserver implements j {

    /* renamed from: a reason: collision with root package name */
    private final C0213f[] f1605a;

    CompositeGeneratedAdaptersObserver(C0213f[] fVarArr) {
        this.f1605a = fVarArr;
    }

    public void a(l lVar, a aVar) {
        t tVar = new t();
        for (C0213f a2 : this.f1605a) {
            a2.a(lVar, aVar, false, tVar);
        }
        for (C0213f a3 : this.f1605a) {
            a3.a(lVar, aVar, true, tVar);
        }
    }
}
