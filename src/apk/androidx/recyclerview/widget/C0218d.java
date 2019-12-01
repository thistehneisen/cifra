package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0232s.b;

/* renamed from: androidx.recyclerview.widget.d reason: case insensitive filesystem */
/* compiled from: AsyncListDiffer */
class C0218d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ b f1891a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0219e f1892b;

    C0218d(C0219e eVar, b bVar) {
        this.f1892b = eVar;
        this.f1891a = bVar;
    }

    public void run() {
        C0219e eVar = this.f1892b;
        C0220f fVar = eVar.f1903d;
        if (fVar.f1916g == eVar.f1902c) {
            fVar.a(eVar.f1901b, this.f1891a);
        }
    }
}
